package se.kth.iv350.POS.view;

import se.kth.iv350.POS.controller.Controller;
import se.kth.iv350.POS.database.ItemDTO;
import se.kth.iv350.POS.model.Purchase;
import se.kth.iv350.POS.model.PurchaseDTO;
import se.kth.iv350.POS.model.UniqueItem;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

public class View {

    Controller controller;

    public View(Controller controller){

        this.controller = controller;

        // create JFrame and JTable
        JFrame frame = new JFrame();
        frame.setTitle("Point of Sale");

        prepStartPanel(frame);


        frame.setSize(900,400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private void prepStartPanel(JFrame frame) {
        JPanel panelStart = new JPanel();

        JButton btnNewCustomer = new JButton("New Customer");
        btnNewCustomer.setBounds(150, 220, 100, 25);
        panelStart.add(btnNewCustomer);
        frame.add(panelStart);
        // button add row
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

    private void prepSalePanel(JFrame frame, JPanel panelSale, JPanel panelStart) {

        JTable table = new JTable();
        // create a table model and set a Column Identifiers to this model
        Object[] columns = {"ItemID","Item Name","Price","Amount"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);

        // set the model to the table
        table.setModel(model);

        // Change A JTable Background Color, Font Size, Font Color, Row Height
        table.setBackground(Color.LIGHT_GRAY);
        table.setForeground(Color.black);
        Font font = new Font("",1,22);
        table.setFont(font);
        table.setRowHeight(30);

        JLabel totalPriceLabel = new JLabel("Total Price: ");
        JLabel totalPriceInput = new JLabel();
        JLabel changeInputLabel = new JLabel();

        // create JTextFields
        JTextField textId = new JTextField();
        JTextField textAmount = new JTextField();
        JTextField textCustomerID = new JTextField();
        JTextField textAmountPayed = new JTextField();

        // create JButtons
        JButton btnAdd = new JButton("Register Item");
        JButton btnAmount = new JButton("Add amount");
        JButton btnCustomer = new JButton("Customer ID");
        JButton btnPayed = new JButton("Amount Payed");
        JButton btnClose = new JButton("Finish");


        totalPriceLabel.setBounds(600, 310, 100, 25);
        totalPriceInput.setBounds(700, 310, 100, 25);
        changeInputLabel.setBounds(600, 290, 250, 25);

        textId.setBounds(20, 220, 100, 25);
        textAmount.setBounds(20, 250, 100, 25);
        textCustomerID.setBounds(20, 280, 100, 25);
        textAmountPayed.setBounds(20, 310, 100, 25);

        btnAdd.setBounds(150, 220, 200, 25);
        btnAmount.setBounds(150, 250, 200, 25);
        btnCustomer.setBounds(150, 280, 200, 25);
        btnPayed.setBounds(150, 310, 200, 25);
        btnClose.setBounds(350, 310, 200, 25);


        // create JScrollPane
        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(0, 0, 880, 200);

        panelSale.setLayout(null);

        panelSale.add(pane);

        // add JTextFields to the jframe
        panelSale.add(totalPriceLabel);
        panelSale.add(totalPriceInput);
        panelSale.add(changeInputLabel);
        panelSale.add(textId);
        panelSale.add(textAmount);
        panelSale.add(textCustomerID);
        panelSale.add(textAmountPayed);

        // add JButtons to the jframe
        panelSale.add(btnAdd);
        panelSale.add(btnAmount);
        panelSale.add(btnCustomer);
        panelSale.add(btnPayed);
        panelSale.add(btnClose);


        // Register new Item
        btnAdd.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {

                PurchaseDTO purchaseDTO = controller.registerItem(textId.getText());
                updateView(purchaseDTO.getUniqueItems(), model);
                totalPriceInput.setText(Integer.toString(purchaseDTO.getTotalPrice()));
            }
        });

        // Add amount
        btnAmount.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {

                int amount = Integer.parseInt(textAmount.getText());
                PurchaseDTO purchaseDTO = controller.registerItem(textId.getText());;
                for (int i = 1; i < amount; i++)
                    purchaseDTO = controller.registerItem(textId.getText());

                updateView(purchaseDTO.getUniqueItems(), model);
                totalPriceInput.setText(Integer.toString(purchaseDTO.getTotalPrice()));
            }
        });

        // Finalize sale
        btnPayed.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {

                int inputPayed = Integer.parseInt(textAmountPayed.getText());
                int outputChange = controller.Payment(inputPayed);
                changeInputLabel.setText("Change: " + outputChange);
                table.setBackground(Color.WHITE);

            }
        });

        // Enter Customer ID
        btnCustomer.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {

                String customerID = textCustomerID.getText();
                PurchaseDTO purchaseDTO = controller.tryDiscount(customerID);
                totalPriceInput.setText(Integer.toString(purchaseDTO.getTotalPrice()));
            }
        });

        // Change panel to 
        btnClose.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {

                frame.getContentPane().removeAll();
                frame.getContentPane().add(panelStart);
                frame.revalidate();
                frame.repaint();
            }
        });

    }
    private void updateView(ArrayList<UniqueItem> items, DefaultTableModel model) {
        int temp = model.getRowCount();
        for (int i = 0; i < temp; i++)
            model.removeRow(0);

        for (UniqueItem item : items)
            model.addRow(item.getRowObject());
    }
}


