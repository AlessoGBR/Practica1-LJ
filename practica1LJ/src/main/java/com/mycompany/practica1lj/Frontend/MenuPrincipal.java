/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.practica1lj.Frontend;

import com.mycompany.practica1lj.Backend.AnalizadorCodigo;
import com.mycompany.practica1lj.Backend.GestorSimbolos;
import com.mycompany.practica1lj.Backend.LeerArchivo;
import com.mycompany.practica1lj.Backend.NumeroLinea;
import com.mycompany.practica1lj.Backend.Token;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import java.util.List;
import javax.swing.border.BevelBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author alesso
 */
public class MenuPrincipal extends javax.swing.JFrame {

    private NumeroLinea numero;
    private AnalizadorCodigo analizadorCodigo;
    private List<Token> listaTokens;

    /**
     * Creates new form MenuPrincipal
     */
    public MenuPrincipal() {
        initComponents();
        numero = new NumeroLinea(txtCodigo);
        jScrollPane2.setRowHeaderView(numero);
        btnReportes.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelSquare = new javax.swing.JPanel();
        panelTexto = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtCodigo = new javax.swing.JTextArea();
        btnAnalizar = new javax.swing.JButton();
        bntSubir = new javax.swing.JButton();
        btnReportes = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MENU PRINCIPAL");
        setResizable(false);

        panelSquare.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout panelSquareLayout = new javax.swing.GroupLayout(panelSquare);
        panelSquare.setLayout(panelSquareLayout);
        panelSquareLayout.setHorizontalGroup(
            panelSquareLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 607, Short.MAX_VALUE)
        );
        panelSquareLayout.setVerticalGroup(
            panelSquareLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        panelTexto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtCodigo.setColumns(20);
        txtCodigo.setRows(5);
        jScrollPane2.setViewportView(txtCodigo);

        javax.swing.GroupLayout panelTextoLayout = new javax.swing.GroupLayout(panelTexto);
        panelTexto.setLayout(panelTextoLayout);
        panelTextoLayout.setHorizontalGroup(
            panelTextoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTextoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelTextoLayout.setVerticalGroup(
            panelTextoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTextoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 546, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnAnalizar.setText("ANALIZAR");
        btnAnalizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAnalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalizarActionPerformed(evt);
            }
        });

        bntSubir.setText("SUBIR");
        bntSubir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bntSubir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntSubirActionPerformed(evt);
            }
        });

        btnReportes.setText("REPORTE");
        btnReportes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bntSubir))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAnalizar)
                        .addGap(18, 18, 18)
                        .addComponent(btnReportes)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelSquare, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(5, 5, 5))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bntSubir)
                    .addComponent(btnAnalizar)
                    .addComponent(btnReportes))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelSquare, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelTexto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAnalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalizarActionPerformed
        analizarCodigo();
    }//GEN-LAST:event_btnAnalizarActionPerformed

    private void bntSubirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntSubirActionPerformed
        // Crear una instancia de JFileChooser
        JFileChooser fileChooser = new JFileChooser();

        // Establecer el modo de selección de archivos (solo archivos)
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        // Crear un filtro para archivos .txt
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de texto", "txt");
        fileChooser.setFileFilter(filter);

        // Mostrar el file chooser y capturar la respuesta del usuario
        int result = fileChooser.showOpenDialog(this);

        // Procesar la respuesta del usuario
        if (result == JFileChooser.APPROVE_OPTION) {
            // Obtener el archivo seleccionado
            File selectedFile = fileChooser.getSelectedFile();
            // Mostrar la ruta del archivo seleccionado
            LeerArchivo leer = new LeerArchivo();
            txtCodigo.setText(leer.leerArchivoTxt(selectedFile.getAbsolutePath()));

        }

    }//GEN-LAST:event_bntSubirActionPerformed

    private void btnReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportesActionPerformed
        Reporte reportes = new Reporte(listaTokens);
        reportes.setVisible(true);
    }//GEN-LAST:event_btnReportesActionPerformed

    public void analizarCodigo() {
        GestorSimbolos gestor = new GestorSimbolos();

        analizadorCodigo = new AnalizadorCodigo(gestor.getOperadoresColores());
        String codigo = txtCodigo.getText();

        panelSquare.removeAll();
        List<String> error = new ArrayList<>();
        listaTokens = new ArrayList<>();
        analizadorCodigo.analizarCodigo(codigo, listaTokens, error);

        if (analizadorCodigo.getFila() != 0) {
            panelSquare.setLayout(new GridLayout(analizadorCodigo.getFila(), analizadorCodigo.getColumna()));
            btnReportes.setVisible(true);
        } else {
            return;
        }

        for (Token panelToken : listaTokens) {
            Color color = panelToken.getColor();
            JLabel cuadro = new JLabel();
            cuadro.setOpaque(true);
            cuadro.setBackground(color);
            cuadro.setPreferredSize(new Dimension(30, 30));
            cuadro.setBorder(new BevelBorder(1));
            cuadro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            cuadro.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    /*
                    DatoToken datos = new DatoToken(panelToken.getFila(), panelToken.getColumna(),
                            panelToken.getTipo().toString(), panelToken.getToken());*/
                    DatoToken datos = new DatoToken(panelToken);
                    datos.setVisible(true);                    
                }
            });

            panelSquare.add(cuadro);
        }

        panelSquare.revalidate();
        panelSquare.repaint();

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntSubir;
    private javax.swing.JButton btnAnalizar;
    private javax.swing.JButton btnReportes;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel panelSquare;
    private javax.swing.JPanel panelTexto;
    private javax.swing.JTextArea txtCodigo;
    // End of variables declaration//GEN-END:variables
}
