/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.practica1lj.Frontend;

import com.mycompany.practica1lj.Backend.Token;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author alesso
 */
public class Reporte extends javax.swing.JFrame {

    private final String[] columnas = {"TOKEN", "LEXEMA", "FILA", "COLUMNA", "COLOR"};
    private JTable tabla;
    private final List<Token> listaTokens;

    /**
     * Creates new form Reporte
     *
     * @param listaTokens
     */
    public Reporte(List<Token> listaTokens) {
        this.listaTokens = listaTokens;
        initComponents();
        crearTabla();
        mostrarTokens();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JButton();
        panel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("REPORTE");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel1.setText("REPORTES");

        btnRegresar.setText("REGRESAR");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        panel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panel.setLayout(new java.awt.GridLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 457, Short.MAX_VALUE)
                .addComponent(btnRegresar)
                .addGap(68, 68, 68))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnRegresar))
                .addGap(18, 18, 18)
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed

        this.setVisible(false);
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void mostrarTokens() {
        if (listaTokens != null) {
            // Definir el modelo de la tabla para que no sea editable
            DefaultTableModel model = new DefaultTableModel(columnas, 0) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };

            // Agregar los tokens al modelo
            for (Token token : listaTokens) {
                model.addRow(new Object[]{
                    token.getTipo(), // Tipo del token
                    token.getToken(), // Texto del token
                    token.getFila(), // Fila del token
                    token.getColumna(), // Columna del token
                    token.getColor() // Objeto Color directamente
                });
            }

            // Asignar el modelo a la tabla
            tabla.setModel(model);

            // Asignar el ColorRenderer a la columna que muestra los colores
            tabla.getColumnModel().getColumn(4).setCellRenderer(new ColorRenderer()); // Índice 4 es donde está el color

            panel.repaint();
        } else {
            JOptionPane.showMessageDialog(null,
                    "INGRESE TOKENS PARA MOSTRAR EL REPORTE",
                    "ERROR",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

// Renderer personalizado para mostrar el color en la celda
    class ColorRenderer extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            // Verificar si la columna es la que tiene el color
            if (column == 4) { // Suponiendo que la columna 4 es la de color
                if (value instanceof Color) {
                    c.setBackground((Color) value);  // Establecer el color de fondo
                    setText(""); // Limpiar el texto de la celda para que solo se vea el color
                } else {
                    c.setBackground(Color.WHITE); // Color predeterminado
                }
            } else {
                c.setBackground(Color.WHITE); // Color predeterminado para otras columnas
            }

            return c;
        }
    }

    private void crearTabla() {
        DefaultTableModel model = new DefaultTableModel(null, columnas);

        // Crear la JTable con el modelo
        tabla = new JTable(model);

        // Añadir la tabla a un JScrollPane
        JScrollPane scrollPane = new JScrollPane(tabla);

        // Añadir el JScrollPane al panel
        tabla.setEnabled(false);
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.repaint();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel panel;
    // End of variables declaration//GEN-END:variables
}
