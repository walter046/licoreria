
package ventanas;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import conexion.ConexionBD;
import java.sql.*;

public class detalles_pedido extends javax.swing.JFrame {

 
    
    public detalles_pedido() {
        initComponents();
        cargarLicores();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbllicores = new javax.swing.JTable();
        txtbuscarid = new javax.swing.JTextField();
        btnbuscardetalles = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbllicores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "id_detalle_pedido", "id_pedido", "id_licor", "tipo", "nombre", "cantidad", "precio", "total"
            }
        ));
        jScrollPane1.setViewportView(tbllicores);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 390));

        jTabbedPane1.addTab("tab1", jPanel2);

        jPanel5.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, 420));

        txtbuscarid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbuscaridActionPerformed(evt);
            }
        });
        jPanel5.add(txtbuscarid, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 30, 180, 50));

        btnbuscardetalles.setText("BUSCAR");
        btnbuscardetalles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscardetallesActionPerformed(evt);
            }
        });
        jPanel5.add(btnbuscardetalles, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 30, 150, 50));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 1060, 500));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1080, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

     private void cargarLicores() {
        DefaultTableModel model = (DefaultTableModel) tbllicores.getModel();
        model.setRowCount(0); // Limpiar la tabla

        try (Connection con = ConexionBD.conectar();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM detalle_pedido")) {

            // Agregar los datos a la tabla
            while (rs.next()) {
                model.addRow(new Object[]{
                       rs.getInt("id_detalle_pedido"), rs.getInt("id_pedido"), rs.getInt("id_licor"),
                    rs.getString("tipo"), rs.getString("nombre"),rs.getInt("cantidad"), rs.getDouble("precio_unitario"),
                    rs.getString("total")
                });
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al cargar datos: " + e.getMessage());
        }
    }
     
    private void btnbuscardetallesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscardetallesActionPerformed
        String buscar = txtbuscarid.getText();
        DefaultTableModel model = (DefaultTableModel) tbllicores.getModel();
        model.setRowCount(0); // Limpiar la tabla

        try (Connection con = ConexionBD.conectar();
            PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM detalle_pedido WHERE id_pedido = ? OR nombre LIKE ?")) {
            ps.setString(1, buscar);
            ps.setString(2, "%" + buscar + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("id_detalle_pedido"), rs.getInt("id_pedido"), rs.getInt("id_licor"),
                    rs.getString("tipo"), rs.getString("nombre"),rs.getInt("cantidad"), rs.getDouble("precio_unitario"),
                    rs.getString("total")
                });
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al buscar licor: " + e.getMessage());
        }
    }//GEN-LAST:event_btnbuscardetallesActionPerformed

    private void txtbuscaridActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbuscaridActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbuscaridActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnbuscardetalles;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    public javax.swing.JTable tbllicores;
    public javax.swing.JTextField txtbuscarid;
    // End of variables declaration//GEN-END:variables
}
