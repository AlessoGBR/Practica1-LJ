/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.practica1lj.Frontend;

import com.mycompany.practica1lj.Backend.GraphvizController;
import com.mycompany.practica1lj.Backend.Token;
import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author alesso
 */
public class DatoToken extends javax.swing.JFrame {

    private Token tokenPr;
    private int fila;
    private int columna;
    private String token;
    private String lexema;

    public DatoToken(int fila, int columna, String token, String lexema) {
        initComponents();
        this.fila = fila;
        this.columna = columna;
        this.token = token;
        this.lexema = lexema;
        mostrarDatos();
    }

    public DatoToken(Token token) {
        initComponents();
        this.tokenPr = token;
        mostrarDatosTk();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtFila = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtColumna = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtToken = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtLexema = new javax.swing.JLabel();
        btnCrearImg = new javax.swing.JButton();
        PanelImg = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lblImagen = new javax.swing.JLabel();
        btnMenu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("DATOS DEL TOKEN");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel1.setText("DATOS DEL TOKEN:");

        txtFila.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txtFila.setText("FILA:");

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel3.setText("COLUMNA:");

        txtColumna.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txtColumna.setText("FILA:");

        jLabel5.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel5.setText("FILA:");

        jLabel4.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel4.setText("TIPO TOKEN:");

        txtToken.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txtToken.setText("FILA:");

        jLabel6.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel6.setText("LEXEMA:");

        txtLexema.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txtLexema.setText("FILA:");

        btnCrearImg.setText("CREAR GRAFICA");
        btnCrearImg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearImgActionPerformed(evt);
            }
        });

        PanelImg.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jScrollPane1.setViewportView(lblImagen);

        javax.swing.GroupLayout PanelImgLayout = new javax.swing.GroupLayout(PanelImg);
        PanelImg.setLayout(PanelImgLayout);
        PanelImgLayout.setHorizontalGroup(
            PanelImgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE)
        );
        PanelImgLayout.setVerticalGroup(
            PanelImgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
        );

        btnMenu.setText("REGRESAR");
        btnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtFila)
                                    .addComponent(txtColumna))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtToken)
                                    .addComponent(txtLexema))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PanelImg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnCrearImg)
                                .addGap(18, 18, 18)
                                .addComponent(btnMenu)))
                        .addGap(0, 14, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFila)
                    .addComponent(jLabel5))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtColumna))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtToken))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtLexema))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCrearImg)
                    .addComponent(btnMenu))
                .addGap(18, 18, 18)
                .addComponent(PanelImg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearImgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearImgActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Selecciona la ubicación para guardar el gráfico");

        // Mostrar el diálogo de selección de archivo
        int userSelection = fileChooser.showSaveDialog(null);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            GraphvizController imagen = new GraphvizController(tokenPr, selectedFile.getAbsolutePath());
            imagen.drawGraph();
            JOptionPane.showMessageDialog(null, "GRAFICA CREADA");
            mostrarImagen(imagen.getPathImagen());
        } else {
            JOptionPane.showMessageDialog(null, "NO SE SELECCINO");
        }

    }//GEN-LAST:event_btnCrearImgActionPerformed

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed

        this.setVisible(false);
    }//GEN-LAST:event_btnMenuActionPerformed

    private void mostrarImagen(String pathImg) {
        ImageIcon icono = new ImageIcon(pathImg);
        Image img = icono.getImage();
        lblImagen.setIcon(icono);
    }

    private void mostrarDatos() {
        txtFila.setText(fila + "");
        txtColumna.setText(columna + "");
        txtToken.setText(token);
        txtLexema.setText(lexema);
    }

    private void mostrarDatosTk() {
        txtFila.setText(tokenPr.getFila() + "");
        txtColumna.setText(tokenPr.getColumna() + "");
        txtToken.setText(tokenPr.getTipo().toString());
        txtLexema.setText(tokenPr.getToken());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelImg;
    private javax.swing.JButton btnCrearImg;
    private javax.swing.JButton btnMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblImagen;
    private javax.swing.JLabel txtColumna;
    private javax.swing.JLabel txtFila;
    private javax.swing.JLabel txtLexema;
    private javax.swing.JLabel txtToken;
    // End of variables declaration//GEN-END:variables
}
