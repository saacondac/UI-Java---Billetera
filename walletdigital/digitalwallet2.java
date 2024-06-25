/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package walletdigital;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class digitalwallet2 extends javax.swing.JFrame {
    private DefaultTableModel tableModel;
    private digitalwallet walletLogic;

    public digitalwallet2() {
        initComponents();
        walletLogic = new digitalwallet (tableModel);
    }

    private void initComponents() {
        // Inicializar componentes
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtvalue = new javax.swing.JTextField();
        purchaseButton = new javax.swing.JButton();
        saleButton = new javax.swing.JButton();
        balanceLabel = new javax.swing.JLabel();
        remainingBalance = new javax.swing.JTextField();

        // Configuración de la tabla y su modelo
        tableModel = new DefaultTableModel(
                new Object[][]{},
                new String[]{"ID", "Type", "Date", "Amount"}
        );
        table.setModel(tableModel);
        jScrollPane1.setViewportView(table);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Enter the value:");

        purchaseButton.setText("Purchase");
        purchaseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                walletLogic.addTransaction("P", txtvalue, balanceLabel, remainingBalance);
            }
        });

        saleButton.setText("Sale");
        saleButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                walletLogic.addTransaction("S", txtvalue, balanceLabel, remainingBalance);
            }
        });

        balanceLabel.setText("Total:");

        remainingBalance.setText("$100.00");
        remainingBalance.setEditable(false);

        // Diseño del layout
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 375, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel1)
                                                        .addComponent(txtvalue, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(purchaseButton))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(saleButton)
                                                        .addComponent(balanceLabel)
                                                        .addComponent(remainingBalance, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(balanceLabel))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtvalue, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(remainingBalance, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(purchaseButton)
                                        .addComponent(saleButton))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 275, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new digitalwallet2().setVisible(true);
            }
        });
    }

    // Declaración de componentes GUI
    private javax.swing.JLabel balanceLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton purchaseButton;
    private javax.swing.JTextField remainingBalance;
    private javax.swing.JButton saleButton;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtvalue;
}
