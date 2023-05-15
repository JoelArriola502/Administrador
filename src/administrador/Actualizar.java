/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package administrador;

import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author Joel Arriola
 */
public class Actualizar extends javax.swing.JPanel {
Conexion conectar=new Conexion();
Connection ConectarBD=conectar.getConection();
PreparedStatement actualizar=null;

/**
     * Creates new form Actualizar
     */
    public Actualizar() {
        initComponents();
    }
   
     public void MostrarDatos(){
        DefaultTableModel Modelo=new DefaultTableModel();
        Modelo.addColumn("idClientes");
        Modelo.addColumn("Nombre");
        Modelo.addColumn("Apellido");
        Modelo.addColumn("DPI");
        Modelo.addColumn("Pago");
        Modelo.addColumn("TipoPago");
        Modelo.addColumn("Menbresia");
        Modelo.addColumn("FechaIngreso");
        jTableDatos.setModel(Modelo);
        String Mostrar="select c.idClientes, c.Nombre , c.Apellido, c.DPI, p.Pago,tp.TipoPago,p.Membresia,i.FechaIngreso\n" +
"from Clientes c, Pago p, Ingresos i, TipoPago tp\n" +
"where c.idClientes=i.idClientes and i.idPago=p.idPago and p.idTipoPago=tp.idTipoPago";
        String Datos[]=new String[9];
        Statement st;
        try {
            st=ConectarBD.createStatement();
            ResultSet rs=st.executeQuery(Mostrar);
            while(rs.next()){
                Datos[0]=rs.getString(1);
                Datos[1]=rs.getString(2);
                Datos[2]=rs.getString(3);
                Datos[3]=rs.getString(4);
                Datos[4]=rs.getString(5);
                Datos[5]=rs.getString(6);
                Datos[6]=rs.getString(7);
                Datos[7]=rs.getString(8);
                Modelo.addRow(Datos);
               
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro mostrar consulta"+e.toString());
        }
        
    }

     public void Clientes(){
         try {
              actualizar=ConectarBD.prepareStatement("update Clientes set Nombre='"+txtNombre.getText()+"',Apellido='"+txtApellido.getText()+"',DPI='"+txtDPI.getText()+"' where idClientes='"+txtID.getText()+"'");
             int indice=actualizar.executeUpdate();
             if(indice>0){
                // JOptionPane.showMessageDialog(null, "DATOS ACTUALIZADOS CORRECTAMENTE");
                 MostrarDatos();
                 
             }else{
                 JOptionPane.showMessageDialog(null, "No selecciono la fila");
             }
         } catch (Exception e) {
              JOptionPane.showMessageDialog(null, "ERROR AL ACTUALIZAR "+e.toString());
         }
     }
     public void Pago(){
         try {
            actualizar=ConectarBD.prepareStatement("update Pago set Pago='"+txtPago.getText()+"',Membresia='"+jComboBox2.getSelectedItem()+"' where idPago='"+txtID.getText()+"'");
        int indice=actualizar.executeUpdate();
        if(indice>0){
            // JOptionPane.showMessageDialog(null, "DATOS ACTUALIZADOS CORRECTAMENTE pago");
                 MostrarDatos();
            
        }else{
                 JOptionPane.showMessageDialog(null, "No selecciono la fila");
             }
         } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "ERROR AL ACTUALIZAR "+e.toString());
         }
     }
     public void TipoPago(){
         try {
            actualizar=ConectarBD.prepareStatement("update TipoPago set TipoPago='"+jComboBox1.getSelectedItem()+"' where idTipoPago='"+txtID.getText()+"'");
        int indice=actualizar.executeUpdate();
        if(indice>0){
           //  JOptionPane.showMessageDialog(null, "DATOS ACTUALIZADOS CORRECTAMENTE Tipo Pago");
                 MostrarDatos();
            
        }else{
                 JOptionPane.showMessageDialog(null, "No selecciono la fila");
             }
         } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "ERROR AL ACTUALIZAR "+e.toString());
         }
     }
      public void Ingresos(){
         try {
            actualizar=ConectarBD.prepareStatement("update Ingresos set FechaIngreso='"+txtFecha.getText()+"' where idIngresos='"+txtID.getText()+"'");
        int indice=actualizar.executeUpdate();
        if(indice>0){
            // JOptionPane.showMessageDialog(null, "DATOS ACTUALIZADOS CORRECTAMENTE INGRESOS");
                 MostrarDatos();
            
        }else{
                 JOptionPane.showMessageDialog(null, "No selecciono la fila");
             }
         } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "ERROR AL ACTUALIZAR "+e.toString());
         }
     }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        txtNombre = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        txtApellido = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        txtDPI = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jComboBox1 = new javax.swing.JComboBox<>();
        jSeparator7 = new javax.swing.JSeparator();
        txtPago = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        jComboBox2 = new javax.swing.JComboBox<>();
        jSeparator5 = new javax.swing.JSeparator();
        txtFecha = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        txtID = new javax.swing.JTextField();
        jSeparator8 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableDatos = new javax.swing.JTable();
        jButtonMostrar = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(87, 222, 192));

        txtNombre.setBackground(new java.awt.Color(87, 222, 192));
        txtNombre.setForeground(new java.awt.Color(153, 153, 153));
        txtNombre.setText("Nombre");
        txtNombre.setBorder(null);
        txtNombre.setCaretColor(new java.awt.Color(51, 255, 204));
        txtNombre.setSelectionColor(new java.awt.Color(51, 255, 204));
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        txtApellido.setBackground(new java.awt.Color(87, 222, 192));
        txtApellido.setForeground(new java.awt.Color(153, 153, 153));
        txtApellido.setText("Apellido");
        txtApellido.setBorder(null);
        txtApellido.setCaretColor(new java.awt.Color(51, 255, 204));
        txtApellido.setSelectionColor(new java.awt.Color(51, 255, 204));
        txtApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidoActionPerformed(evt);
            }
        });

        txtDPI.setBackground(new java.awt.Color(87, 222, 192));
        txtDPI.setForeground(new java.awt.Color(153, 153, 153));
        txtDPI.setText("DPI");
        txtDPI.setBorder(null);
        txtDPI.setCaretColor(new java.awt.Color(51, 255, 204));
        txtDPI.setSelectionColor(new java.awt.Color(51, 255, 204));
        txtDPI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDPIActionPerformed(evt);
            }
        });

        jComboBox1.setBackground(new java.awt.Color(87, 222, 192));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tipo Pago", "Efectivo", "Targeta Credito", " " }));
        jComboBox1.setBorder(null);

        txtPago.setBackground(new java.awt.Color(87, 222, 192));
        txtPago.setForeground(new java.awt.Color(153, 153, 153));
        txtPago.setText("Pago");
        txtPago.setBorder(null);
        txtPago.setCaretColor(new java.awt.Color(51, 255, 204));
        txtPago.setSelectionColor(new java.awt.Color(51, 255, 204));
        txtPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPagoActionPerformed(evt);
            }
        });

        jComboBox2.setBackground(new java.awt.Color(87, 222, 192));
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Menbresía", "PREMIUN", "VIP", " " }));
        jComboBox2.setBorder(null);

        txtFecha.setBackground(new java.awt.Color(87, 222, 192));
        txtFecha.setForeground(new java.awt.Color(153, 153, 153));
        txtFecha.setText("Fecha Ingreso");
        txtFecha.setBorder(null);
        txtFecha.setCaretColor(new java.awt.Color(51, 255, 204));
        txtFecha.setSelectionColor(new java.awt.Color(51, 255, 204));
        txtFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaActionPerformed(evt);
            }
        });

        txtID.setBackground(new java.awt.Color(87, 222, 192));
        txtID.setForeground(new java.awt.Color(153, 153, 153));
        txtID.setText("ID CLIENTE");
        txtID.setBorder(null);
        txtID.setCaretColor(new java.awt.Color(51, 255, 204));
        txtID.setSelectionColor(new java.awt.Color(51, 255, 204));
        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(87, 222, 192));
        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("ACTUALIZAR");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTableDatos.setBackground(new java.awt.Color(87, 222, 192));
        jTableDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTableDatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableDatosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableDatos);

        jButtonMostrar.setBackground(new java.awt.Color(87, 222, 192));
        jButtonMostrar.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButtonMostrar.setForeground(new java.awt.Color(0, 0, 0));
        jButtonMostrar.setText("MOSTRAR");
        jButtonMostrar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonMostrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMostrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(181, 181, 181)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtApellido, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtDPI, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jSeparator7, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.LEADING, 0, 159, Short.MAX_VALUE)))
                .addGap(44, 44, 44)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jSeparator8, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtID, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator6, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtFecha, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator5, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPago, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 162, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonMostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(65, 65, 65))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDPI, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtPago, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jButtonMostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)))
                        .addGap(0, 0, 0)
                        .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidoActionPerformed

    private void txtDPIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDPIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDPIActionPerformed

    private void txtPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPagoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPagoActionPerformed

    private void txtFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaActionPerformed

    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Clientes();
        TipoPago();
        Pago();
        Ingresos();
      
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButtonMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMostrarActionPerformed
        // TODO add your handling code here:
        MostrarDatos();
    }//GEN-LAST:event_jButtonMostrarActionPerformed

    private void jTableDatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableDatosMouseClicked
        // TODO add your handling code here:
        int fila=this.jTableDatos.getSelectedRow();
        this.txtID.setText(this.jTableDatos.getValueAt(fila, 0).toString());
        this.txtNombre.setText(this.jTableDatos.getValueAt( fila,1).toString());
        this.txtApellido.setText(this.jTableDatos.getValueAt(fila,2).toString());
        this.txtDPI.setText(this.jTableDatos.getValueAt(fila, 3).toString());
        this.txtPago.setText(this.jTableDatos.getValueAt(fila,4).toString());
        this.jComboBox1.setSelectedItem(this.jTableDatos.getValueAt(fila,5).toString());
        this.jComboBox2.setSelectedItem(this.jTableDatos.getValueAt(fila,6).toString());
        this.txtFecha.setText(this.jTableDatos.getValueAt(fila, 7).toString());
        
        
    }//GEN-LAST:event_jTableDatosMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonMostrar;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JTable jTableDatos;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtDPI;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPago;
    // End of variables declaration//GEN-END:variables
}
