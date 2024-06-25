/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package walletdigital;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class digitalwallet {
    private double balance = 100.00;
    private DefaultTableModel tableModel;

    public digitalwallet(DefaultTableModel tableModel) {
        this.tableModel = tableModel;
    }

    public double getBalance() {
        return balance;
    }

    public void addTransaction(String type, JTextField txtvalue, JLabel balanceLabel, JTextField remainingBalance) {
        double transactionValue;
        try {
            transactionValue = Double.parseDouble(txtvalue.getText().trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Please enter a valid number.");
            return;
        }

        if (transactionValue < 0) {
            JOptionPane.showMessageDialog(null, "Negative values are not allowed.");
            return;
        }

        if (type.equals("P") && balance < transactionValue) {
            JOptionPane.showMessageDialog(null, "Insufficient funds. Cannot proceed with the purchase.");
            return;
        }

        int transactionId = generateRandomId();
        String transactionDate = new SimpleDateFormat("yyyy-MM-dd-HH:mm").format(new Date());

        if (type.equals("P")) {
            balance -= transactionValue;
        } else if (type.equals("S")) {
            balance += transactionValue;
        }

        tableModel.addRow(new Object[]{transactionId, type, transactionDate, transactionValue});
        balanceLabel.setText("Total: $" + balance);
        remainingBalance.setText("$" + balance);
    }

    private int generateRandomId() {
        Random random = new Random();
        return 100000 + random.nextInt(900000);
    }
}