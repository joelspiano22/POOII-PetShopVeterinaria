/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.mascotas;
import java.util.List;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Categoria;
import model.Mascotas;
import controller.CategoriaController;
import controller.MascotasController;

/**
 *
 * @author Esteban Avendaño
 */
public class FormMascotas extends javax.swing.JFrame {
        private DefaultTableModel dtm = new DefaultTableModel();
        private DefaultTableModel dtmC = new DefaultTableModel();

        private DefaultComboBoxModel dcbBusca = new DefaultComboBoxModel();
        private DefaultComboBoxModel dcbB = new DefaultComboBoxModel();

        MascotasController pMascota = new MascotasController();
        CategoriaController cateControl = new CategoriaController();
        Categoria ope = new Categoria();

    
 private int getCod() {
     return Integer.parseInt(txtCod.getText());
 }
 private String getDes() {
     return txtDes.getText();
 }
 private double getPrecio() {
     return Double.parseDouble(txtPrecio.getText());
 }
 private double getStock() {
     return Double.parseDouble(txtStock.getText());
 }
 private String getTipo() {
     return cboTipo.getSelectedItem().toString();
 }
 private String getTipoBuscar() {
     return(String)cboBuscar.getSelectedItem(); 
 }
 private void setComboBox(List<String> s) {
        dcbBusca.removeAllElements();
            for (String x : s) {
                dcbBusca.addElement(x);
            }
        this.cboTipo.setModel(dcbBusca);
        
        dcbB.removeAllElements();
            for (String x : s) {
                dcbB.addElement(x);
            }
        this.cboBuscar.setModel(dcbB);
    }
    /**
     * Creates new form FormMascotas
     */
    
    //funcion para hallar los totales y colocar en el text area
    public void Totales(boolean inicio) {
        listar(inicio);
        if(pMascota.size()<=0) {
            txtTotal.setText("No hay Productos Registrados");
            return;
        }  
        Mascotas mascotaMenor = ope.precioMenor(pMascota.getProducto());
        txtTotal.setText("Total registrado: " + pMascota.size() 
                + "\n\nStock Total de Mascotas: " + ope.sumarStock(pMascota.getProducto())
                + "\n\nPrecio minimo es: \n" + mascotaMenor.getDes()
                + " ---> (S/. " + mascotaMenor.getPrecio() + ")  \nCódigo: "
                + mascotaMenor.getCod() + " \nCantidad: " + mascotaMenor.getStock()
                + " mascota(s)");
    }
    
    //agregar columnas al JTable principal y categoria
    public void agregarColumnaM()
    {
        dtm.addColumn("CODIGO");
        dtm.addColumn("DESCRIPCION");
        dtm.addColumn("PRECIO");
        dtm.addColumn("STOCK");
        dtm.addColumn("CATEGORIA");
        this.tPrincipal.setModel(dtm);
        /*  */
        dtmC.addColumn("NOMBRE CATEGORIA");
        dtmC.addColumn("CANTIDAD DE PRODUCTOS");
        this.tCategoria.setModel(dtmC);
        
    }
    
    /*public void agregarColumnaCat()
    {
        dtmC.addColumn("NOMBRE CATEGORIA");
        dtmC.addColumn("CANTIDAD DE PRODUCTOS");
        this.tCategoria.setModel(dtmC);

    }*/
    /*
    public void ComboCategoria(){
        for(int i=0;i<this.cateControl.size();i++){
            this.cboTipo.addItem(cateControl.get(i).getDesCategoria());
        }
    }
    
    public String getCategoria() {
        return (String) cboBuscar.getSelectedItem();
    }
    

    
    public void ComboCategoriaBuscar() {
        for(int i=0;i<this.cateControl.size();i++){
            this.cboBuscar.addItem(cateControl.get(i).getDesCategoria());
        }
    }*/
    
    private void listar(boolean inicio)
    {
        if(pMascota.size() == 0) {
            if (!inicio) {
            JOptionPane.showMessageDialog(this,"La tabla PRINCIPAL no tiene datos");
            }
            return;
        }
        dtm.setRowCount(0);
        
        for(int i=0;i<pMascota.size();i++) {
            if (pMascota.get(i).getDes().toUpperCase().contains(txtBuscar.getText().toUpperCase()) &&
                pMascota.get(i).getCate().toUpperCase().contains(this.getTipoBuscar().toUpperCase())){
                Object arreglo[] = new Object[5];
                arreglo[0] = pMascota.get(i).getCod();
                arreglo[1] = pMascota.get(i).getDes();
                arreglo[2] = pMascota.get(i).getPrecio();
                arreglo[3] = pMascota.get(i).getStock();
                arreglo[4] = pMascota.get(i).getCate();
                dtm.addRow(arreglo);
            }
        }
        this.tPrincipal.setModel(dtm);
        
        ArrayList<ArrayList<Object>> result = ope.getCoincidenciasDeTipo(pMascota.getProducto());
        dtmC.setRowCount(0);
        for (int i = 0; i < result.size(); i++) {
            Object arreglo[] = new Object[2];
            arreglo[0] = result.get(i).get(0);
            arreglo[1] = result.get(i).get(1);
            dtmC.addRow(arreglo);
        }
        this.tCategoria.setModel(dtmC);
        
    }
  
    public FormMascotas() {
        initComponents();
        //Totales();
        agregarColumnaM();
        //ComboCategoria();
        //ComboCategoriaBuscar();
        //listar();
        //listarCate();
        if (cateControl.size() > 0) {
        setComboBox(cateControl.getCategorias());
        }
        Totales(true);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtCod = new javax.swing.JTextField();
        txtDes = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        txtStock = new javax.swing.JTextField();
        cboTipo = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tPrincipal = new javax.swing.JTable();
        btnNuevo = new javax.swing.JButton();
        btnGrabar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtTotal = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tCategoria = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        cboBuscar = new javax.swing.JComboBox<>();
        txtBuscar = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pet Shop");
        setAutoRequestFocus(false);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setForeground(java.awt.Color.white);

        jLabel1.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 36)); // NOI18N
        jLabel1.setText("BIENVENIDO A PET SHOP");

        jLabel2.setText("Código");

        jLabel3.setText("Descripcion");

        jLabel4.setText("Precio");

        jLabel5.setText("Stock");

        jLabel6.setText("Categoría");

        tPrincipal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Código", "Descripción", "Precio", "Stock", "Categoría"
            }
        ));
        tPrincipal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tPrincipalMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tPrincipal);

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnGrabar.setText("Grabar");
        btnGrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrabarActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        txtTotal.setColumns(20);
        txtTotal.setRows(5);
        jScrollPane2.setViewportView(txtTotal);

        jLabel7.setText("Base de datos");

        tCategoria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Código", "Nombre"
            }
        ));
        jScrollPane4.setViewportView(tCategoria);

        jLabel9.setText("Categorías");

        cboBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboBuscarActionPerformed(evt);
            }
        });

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        jLabel8.setText("Filtro de búsqueda:");

        jLabel10.setText("Filtrar por categoría:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(41, 41, 41)
                                .addComponent(cboTipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(63, 63, 63)
                                .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4))
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCod, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDes, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(131, 131, 131)
                                .addComponent(jLabel9))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnNuevo)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnGrabar)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnBuscar))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE))
                                        .addGap(38, 38, 38)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cboBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel10)))))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 726, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 19, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(201, 201, 201)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(344, 344, 344))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnNuevo)
                            .addComponent(btnGrabar)
                            .addComponent(btnBuscar))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9)
                        .addGap(108, 108, 108))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(txtCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(txtDes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addGap(15, 15, 15)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel6)
                                        .addComponent(cboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(179, 179, 179)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cboBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)))
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        //this.bloquear_estado(true);//Activo los controles
        txtCod.setText(String.valueOf(pMascota.getCorrelativo()));
        txtDes.setText("");
        txtPrecio.setText("");      
        txtStock.setText("");
        
        cboTipo.setSelectedItem("");
        txtBuscar.setText("");
        cboBuscar.setSelectedItem("");
        
        Totales(false);
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        if (pMascota.buscar(getCod()) == null) {
            JOptionPane.showMessageDialog(this, "Producto no Encontrado, intente nuevamente");
            return;
        }
        Mascotas obj = pMascota.buscar(getCod());
        JOptionPane.showMessageDialog(this, "Código: " + obj.getCod() + "\nDescripción: "
            + obj.getDes() + "\nCosto: S/." + obj.getPrecio()
            + "\nStock: " + obj.getStock());
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrabarActionPerformed
        // TODO add your handling code here:
        int rpta = JOptionPane.showConfirmDialog(this, "Deseas Grabar el Registro", "Grabar", JOptionPane.YES_NO_OPTION);
        if (JOptionPane.NO_OPTION == rpta) {
            return;
        }

        if (pMascota.buscar(getCod()) != null) {
            JOptionPane.showMessageDialog(this, "Producto existente");
            return;
        }
        
        Mascotas obj = new Mascotas(getCod(), getDes(), getPrecio(),getStock(),getTipo());
        pMascota.add(obj);
        pMascota.grabar();
        btnNuevoActionPerformed(evt);
    }//GEN-LAST:event_btnGrabarActionPerformed

    private void cboBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboBuscarActionPerformed
        // TODO add your handling code here:
        listar(false);
    }//GEN-LAST:event_cboBuscarActionPerformed

    private void tPrincipalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tPrincipalMouseClicked
        // TODO add your handling code here:
        this.txtCod.setText(this.dtm.getValueAt(this.tPrincipal.getSelectedRow(),0).toString());
        this.txtDes.setText(this.dtm.getValueAt(this.tPrincipal.getSelectedRow(),1).toString());
        this.txtPrecio.setText(this.dtm.getValueAt(this.tPrincipal.getSelectedRow(),2).toString());
        this.txtStock.setText(this.dtm.getValueAt(this.tPrincipal.getSelectedRow(),3).toString());     
        
        try{
            this.cboTipo.setSelectedItem(dtm.getValueAt(this.tPrincipal.getSelectedRow(), 5).toString());
        }catch (Exception e){
            this.cboTipo.setSelectedItem("");
        }
    }//GEN-LAST:event_tPrincipalMouseClicked

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        // TODO add your handling code here:
        listar(false);
    }//GEN-LAST:event_txtBuscarKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormMascotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormMascotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormMascotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormMascotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormMascotas().setVisible(true);
            }
        });
    }
    
  


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnGrabar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JComboBox<String> cboBuscar;
    private javax.swing.JComboBox<String> cboTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tCategoria;
    private javax.swing.JTable tPrincipal;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCod;
    private javax.swing.JTextField txtDes;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtStock;
    private javax.swing.JTextArea txtTotal;
    // End of variables declaration//GEN-END:variables
}
