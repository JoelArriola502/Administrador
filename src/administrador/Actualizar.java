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
PreparedStatement Eliminar=null;

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
public void Limpiar(){
    txtNombre.setText("");
    txtApellido.setText("");
    txtDPI.setText("");
   jComboBox1.setSelectedIndex(0);
   txtPago.setText("");
   jComboBox2.setSelectedIndex(0);
   txtFecha.setText("");
   txtID.setText("");
   
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
        jButton1 = new javax.swing.JButton();
        jButtonMostrar = new javax.swing.JButton();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtDPI = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        txtPago = new javax.swing.JTextField();
        jComboBox2 = new javax.swing.JComboBox<>();
        txtFecha = new javax.swing.JTextField();
        txtID = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableDatos = new javax.swing.JTable();

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
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 190, 150, 50));

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
        jPanel2.add(jButtonMostrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 190, 150, 50));

        txtNombre.setBackground(new java.awt.Color(87, 222, 192));
        txtNombre.setForeground(new java.awt.Color(51, 51, 51));
        txtNombre.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "NOMBRE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14), new java.awt.Color(0, 0, 0))); // NOI18N
        txtNombre.setCaretColor(new java.awt.Color(51, 255, 204));
        txtNombre.setPreferredSize(new java.awt.Dimension(64, 40));
        txtNombre.setSelectionColor(new java.awt.Color(51, 255, 204));
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        jPanel2.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 220, 60));

        txtApellido.setBackground(new java.awt.Color(87, 222, 192));
        txtApellido.setForeground(new java.awt.Color(51, 51, 51));
        txtApellido.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "APELLIDO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14), new java.awt.Color(0, 0, 0))); // NOI18N
        txtApellido.setCaretColor(new java.awt.Color(51, 255, 204));
        txtApellido.setSelectionColor(new java.awt.Color(51, 255, 204));
        txtApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidoActionPerformed(evt);
            }
        });
        jPanel2.add(txtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 70, 220, 60));

        txtDPI.setBackground(new java.awt.Color(87, 222, 192));
        txtDPI.setForeground(new java.awt.Color(51, 51, 51));
        txtDPI.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DPI", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14), new java.awt.Color(0, 0, 0))); // NOI18N
        txtDPI.setCaretColor(new java.awt.Color(51, 255, 204));
        txtDPI.setSelectionColor(new java.awt.Color(51, 255, 204));
        txtDPI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDPIActionPerformed(evt);
            }
        });
        jPanel2.add(txtDPI, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 130, 220, 60));

        jComboBox1.setBackground(new java.awt.Color(87, 222, 192));
        jComboBox1.setForeground(new java.awt.Color(51, 51, 51));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione Pago", "Efectivo", "Targeta Credito", " " }));
        jComboBox1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "TIPO PAGO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14), new java.awt.Color(0, 0, 0))); // NOI18N
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel2.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 220, 70));

        txtPago.setBackground(new java.awt.Color(87, 222, 192));
        txtPago.setForeground(new java.awt.Color(51, 51, 51));
        txtPago.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "PAGO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14), new java.awt.Color(0, 0, 0))); // NOI18N
        txtPago.setCaretColor(new java.awt.Color(51, 255, 204));
        txtPago.setSelectionColor(new java.awt.Color(51, 255, 204));
        txtPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPagoActionPerformed(evt);
            }
        });
        txtPago.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPagoKeyTyped(evt);
            }
        });
        jPanel2.add(txtPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 80, 220, 60));

        jComboBox2.setBackground(new java.awt.Color(87, 222, 192));
        jComboBox2.setForeground(new java.awt.Color(51, 51, 51));
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione la Menbresía", "PREMIUN", "VIP", " " }));
        jComboBox2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "MENBRESÍA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14), new java.awt.Color(0, 0, 0))); // NOI18N
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        jPanel2.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 200, 220, 70));

        txtFecha.setBackground(new java.awt.Color(87, 222, 192));
        txtFecha.setForeground(new java.awt.Color(51, 51, 51));
        txtFecha.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "INGRESE FECHA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14), new java.awt.Color(0, 0, 0))); // NOI18N
        txtFecha.setCaretColor(new java.awt.Color(51, 255, 204));
        txtFecha.setSelectionColor(new java.awt.Color(51, 255, 204));
        txtFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaActionPerformed(evt);
            }
        });
        jPanel2.add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 140, 220, 60));

        txtID.setBackground(new java.awt.Color(87, 222, 192));
        txtID.setForeground(new java.awt.Color(51, 51, 51));
        txtID.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ID CLIENTE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14), new java.awt.Color(0, 0, 0))); // NOI18N
        txtID.setCaretColor(new java.awt.Color(51, 255, 204));
        txtID.setSelectionColor(new java.awt.Color(51, 255, 204));
        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });
        txtID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIDKeyTyped(evt);
            }
        });
        jPanel2.add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, 220, 60));

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

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 279, 908, 320));

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
        jButton1.setEnabled(true);
        jButtonMostrar.setEnabled(false);
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

    private void txtPagoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPagoKeyTyped
        // TODO add your handling code here:
        //solo acepta numeros
        char Validar =evt.getKeyChar();
        if(Validar<'0'||Validar>'9') evt.consume();
    }//GEN-LAST:event_txtPagoKeyTyped

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void txtFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaActionPerformed

    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDActionPerformed

    private void txtIDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIDKeyTyped
        // TODO add your handling code here:
        char Validar=evt.getKeyChar();
        if(Validar<'0'||Validar>'9') evt.consume();
    }//GEN-LAST:event_txtIDKeyTyped

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonMostrar;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableDatos;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtDPI;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPago;
    // End of variables declaration//GEN-END:variables
}
