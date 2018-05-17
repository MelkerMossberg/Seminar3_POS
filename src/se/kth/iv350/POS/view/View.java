package se.kth.iv350.POS.view;

import se.kth.iv350.POS.controller.Controller;
import se.kth.iv350.POS.controller.OperationFailedException;
import se.kth.iv350.POS.controller.RegisterFailedException;
import se.kth.iv350.POS.database.DatabaseFailureException;
import se.kth.iv350.POS.model.PurchaseDTO;
import se.kth.iv350.POS.model.UniqueItem;
import se.kth.iv350.POS.util.LogHandler;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class View {

    Controller controller;
    ErrorMessageHandler errorMessageHandler = new ErrorMessageHandler();

    /**
     * Creates a <code>view</code> object. A view  has action-listeners
     * that makes method calls to the <code>controller</code> with user input.
     * @param controller is object that will handle and propagate the input given to rest of application
     */
    public View(Controller controller){

        this.controller = controller;
        controller.addTotalPurchasedObserver(new TotalPurchasedDisplay());

        /**
         * Creates a new window with two panels: <code>startPanel</code> & <code>salesPanel</code>
         * The <code>startPanel</code> is the first to be loaded.
         */

        JFrame frame = new JFrame();
        frame.setTitle("Point of Sale");

        prepStartPanel(frame);

        frame.setSize(900,400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    /**
     * This <code>panel</code> handles the state when no purchase is being registered.
     * @param frame This panel is contained in the main frame (window).
     */
    private void prepStartPanel(JFrame frame) {
        JPanel panelStart = new JPanel();

        /**
         * Add user interface elements to <code>panel</code>.
         * Then add <code>panel</code> to <code>frame</code>
         */
        JButton btnNewCustomer = new JButton("New Customer");
        btnNewCustomer.setBounds(150, 220, 100, 25);
        panelStart.add(btnNewCustomer);
        frame.add(panelStart);

        /**
         * When user clicks "New customer"-button, create new Purchase and show new SalesPanel.
         */
        btnNewCustomer.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.startNewSale();

                frame.getContentPane().removeAll();
                JPanel panelSale = new JPanel();
                prepSalePanel(frame, panelSale, panelStart);
                frame.getContentPane().add(panelSale);
                frame.revalidate();
                frame.repaint();
            }
        });
    }

    /**
     * This <code>panel</code> handles the current purchase.
     * @param frame This panel is contained in the main frame (window).
     */
    private void prepSalePanel(JFrame frame, JPanel panelSale, JPanel panelStart) {

        /**
         * Setup all user interface elements.
         * <code>table</code> is a dynamic table that displays item info in rows and columns
         * <code>model</code> determines how the contents of the table should behave
         * <code>pane</code> is a container for the table. It enables scrolling if table grows high.
         * Then there is all input fields and buttons.
         */

        JTable table = new JTable();
        Object[] columns = {"ItemID","Item Name","Price","Amount"};

        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);
        table.setModel(model);

        table.setBackground(Color.LIGHT_GRAY);
        table.setForeground(Color.black);
        Font font = new Font("",1,22);
        table.setFont(font);
        table.setRowHeight(30);

        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(0, 0, 880, 200);
        panelSale.setLayout(null);
        panelSale.add(pane);

        // Text input fields
        JTextField textItemCall = new JTextField();
        JTextField textAmount = new JTextField();
        JTextField textCustomerID = new JTextField();
        JTextField textAmountPayed = new JTextField();
        textItemCall.setBounds(20, 220, 100, 25);
        textAmount.setBounds(20, 250, 100, 25);
        textCustomerID.setBounds(20, 280, 100, 25);
        textAmountPayed.setBounds(20, 310, 100, 25);
        panelSale.add(textItemCall);
        panelSale.add(textAmount);
        panelSale.add(textCustomerID);
        panelSale.add(textAmountPayed);

        // Buttons
        JButton btnAddID = new JButton("Register Item by ID");
        JButton btnAddName = new JButton("Register Item by Name");
        JButton btnAmount = new JButton("Add amount");
        JButton btnCustomer = new JButton("Customer ID");
        JButton btnPayed = new JButton("Amount Payed");
        JButton btnClose = new JButton("Finish");
        btnAddID.setBounds(150, 220, 200, 25);
        btnAddName.setBounds(350, 220, 200, 25);
        btnAmount.setBounds(150, 250, 200, 25);
        btnCustomer.setBounds(150, 280, 200, 25);
        btnPayed.setBounds(150, 310, 200, 25);
        btnClose.setBounds(350, 310, 200, 25);
        panelSale.add(btnAddID);
        panelSale.add(btnAddName);
        panelSale.add(btnAmount);
        panelSale.add(btnCustomer);
        panelSale.add(btnPayed);
        panelSale.add(btnClose);

        // Dynamic text fields
        JLabel totalPriceLabel = new JLabel("Total Price: ");
        JLabel totalPriceInput = new JLabel();
        JLabel changeInputLabel = new JLabel();
        totalPriceLabel.setBounds(600, 310, 100, 25);
        totalPriceInput.setBounds(700, 310, 100, 25);
        changeInputLabel.setBounds(600, 290, 250, 25);
        panelSale.add(totalPriceLabel);
        panelSale.add(totalPriceInput);
        panelSale.add(changeInputLabel);


        /**
         * <code>ActionListener</code>: When user presses "Register Item by ID",
         * fire method <code>registerItem</code> and update view
         * with input from text-field called <code>textItemCall</code>
         */
        btnAddID.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String strategy = "ID";
                callRegisterItem(textItemCall, model, totalPriceInput, strategy);
            }
        });

        /**
         * <code>ActionListener</code>: When user presses "Register Item by Name",
         * fire method <code>registerItem</code> and update view
         * with input from text-field called <code>textItemCall</code>
         */
        btnAddName.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String strategy = "Name";
                callRegisterItem(textItemCall, model, totalPriceInput, strategy);
            }
        });

        /**
         * <code>ActionListener</code>: When user presses "Add Amount",
         * fire method <code>registerItem</code> in a <code>loop</code> and update view
         * with input from text-fields called <code>textItemCall</code> and <code>textAmount</code>
         */

        btnAmount.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int amount = Integer.parseInt(textAmount.getText()) +1;
                for (int i = 1; i < amount; i++)
                    callRegisterItem(textItemCall, model, totalPriceInput, "ID");
            }
        });

        /**
         * <code>ActionListener</code>: When user presses "Amount Payed",
         * fire method <code>registerItem</code> in a <code>loop</code> and update view
         * with input from text-fields called <code>textItemCall</code> and <code>textAmount</code>
         */
        btnPayed.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int inputPayed = Integer.parseInt(textAmountPayed.getText());
                int outputChange = controller.payment(inputPayed);
                changeInputLabel.setText("Change: " + outputChange);
                table.setBackground(Color.WHITE);

            }
        });

        /**
         * <code>ActionListener</code>: When user presses "Customer ID",
         * fire method <code>tryDiscount</code> and update view
         * with input from text-fields called <code>textCustomerID</code>
         */
        btnCustomer.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String customerID = textCustomerID.getText();
                PurchaseDTO purchaseDTO = controller.tryDiscount(customerID);
                totalPriceInput.setText(Integer.toString(purchaseDTO.getTotalPrice()));
            }
        });

        /**
         * <code>ActionListener</code>: When user presses "Finish",
         * remove current Salespanel and go back to Startpanel.
         * This clears the Salespanel of all graphics to start from scratch with next customer
         */
        btnClose.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.closePurchase();
                frame.getContentPane().removeAll();
                frame.getContentPane().add(panelStart);
                frame.revalidate();
                frame.repaint();
            }
        });
    }

    private void callRegisterItem(JTextField textItemCall, DefaultTableModel model, JLabel totalPriceInput, String strategy) {

        try {
            PurchaseDTO purchaseDTO = controller.registerItem(textItemCall.getText(), strategy);
            updateView(purchaseDTO.getUniqueItems(), model);
            totalPriceInput.setText(Integer.toString(purchaseDTO.getTotalPrice()));

        }catch (RegisterFailedException exc) {
            errorMessageHandler.showErrorMsg(exc.getMessage());
            LogHandler logger = null;
            try {
                logger = new LogHandler();
                logger.logException((Exception) exc.getCause());
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }catch (OperationFailedException oExc){
            errorMessageHandler.showErrorMsg(oExc.getMessage());
            LogHandler logger = null;
            try {
                logger = new LogHandler();
                logger.logException((Exception) oExc.getCause());
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }

    }

    private void updateView(ArrayList<UniqueItem> items, DefaultTableModel model) {
        int temp = model.getRowCount();
        for (int i = 0; i < temp; i++)
            model.removeRow(0);

        for (UniqueItem item : items)
            model.addRow(item.getRowObject());
    }
}


