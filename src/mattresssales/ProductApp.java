package mattresssales;

import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ProductApp extends JFrame {
    private JTextField txtCustomerName, txtPrice;
    private JComboBox<String> cmbProducts;

    public ProductApp() {
        setTitle("Product App");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Menu Bar
        JMenuBar menuBar = new JMenuBar();
        JMenu menuFile = new JMenu("File");
        JMenuItem itemExit = new JMenuItem("Exit");
        menuFile.add(itemExit);

        JMenu menuTools = new JMenu("Tools");
        JMenuItem itemProcess = new JMenuItem("Process");
        JMenuItem itemClear = new JMenuItem("Clear");
        menuTools.add(itemProcess);
        menuTools.add(itemClear);

        menuBar.add(menuFile);
        menuBar.add(menuTools);
        setJMenuBar(menuBar);

        // Customer Name
        JLabel lblCustomer = new JLabel("Customer Name:");
        lblCustomer.setBounds(30, 30, 120, 25);
        add(lblCustomer);

        txtCustomerName = new JTextField();
        txtCustomerName.setBounds(150, 30, 200, 25);
        add(txtCustomerName);

        // Product Dropdown
        JLabel lblProduct = new JLabel("Select Product:");
        lblProduct.setBounds(30, 80, 120, 25);
        add(lblProduct);

        String[] products = {"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"};
        cmbProducts = new JComboBox<>(products);
        cmbProducts.setBounds(150, 80, 200, 25);
        add(cmbProducts);

        // Price Input
        JLabel lblPrice = new JLabel("Enter Price:");
        lblPrice.setBounds(30, 130, 120, 25);
        add(lblPrice);

        txtPrice = new JTextField();
        txtPrice.setBounds(150, 130, 200, 25);
        add(txtPrice);

        // Process Button
        JButton btnProcess = new JButton("PROCESS");
        btnProcess.setBounds(150, 180, 200, 30);
        add(btnProcess);

        // Listeners
        btnProcess.addActionListener(e -> processData());
        itemProcess.addActionListener(e -> processData());
        itemExit.addActionListener(e -> System.exit(0));
        itemClear.addActionListener(e -> clearFields());

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void processData() {
        try {
            String customer = txtCustomerName.getText();
            String product = (String) cmbProducts.getSelectedItem();
            double price = Double.parseDouble(txtPrice.getText());

            ProductCalculations calc = new ProductCalculations(price);
            double vat = calc.GetVat();
            double commission = calc.GetCommission();
            double total = calc.GetTotal();

            // Popup message
            String message = "Customer Name: " + customer + "\n" +
                             "Product: " + product + "\n" +
                             "VAT: R " + vat + "\n" +
                             "COMMISSION: R " + commission + "\n" +
                             "TOTAL: R " + total;
            JOptionPane.showMessageDialog(this, message, "Message", JOptionPane.INFORMATION_MESSAGE);

            // Save to data.txt
            FileWriter fw = new FileWriter("data.txt", true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println("DATA LOG");
            pw.println("**************************************************");
            pw.println("Customer Name: " + customer);
            pw.println("Product: " + product);
            pw.println("VAT: R " + vat);
            pw.println("COMMISSION: R " + commission);
            pw.println("TOTAL: R " + total);
            pw.println("**************************************************");
            pw.close();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number for price.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error saving to file.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearFields() {
        txtCustomerName.setText("");
        txtPrice.setText("");
        cmbProducts.setSelectedIndex(0);
    }

    public static void main(String[] args) {
        new ProductApp();
    }
}
