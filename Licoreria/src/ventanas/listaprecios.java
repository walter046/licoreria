
package ventanas;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import conexion.ConexionBD;
import java.sql.*;
import java.time.LocalDate; // Asegúrate de importar esta clase
import java.time.format.DateTimeFormatter;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class listaprecios extends javax.swing.JFrame {

 
    
    public listaprecios() {
        initComponents();
        cargarLicores();
    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    
    }

    private void cargarLicores() {
        DefaultTableModel model = (DefaultTableModel) tbllicores.getModel();
        model.setRowCount(0); // Limpiar la tabla

        try (Connection con = ConexionBD.conectar();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM licores")) {

            // Agregar los datos a la tabla
            while (rs.next()) {
                model.addRow(new Object[]{
                       rs.getString("nombre"), rs.getString("tipo"),
                        rs.getString("marca"), rs.getInt("cantidad"), rs.getDouble("precio"),
                        rs.getString("pais_origen"), rs.getString("descripcion")
                });
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al cargar datos: " + e.getMessage());
        }
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbllicores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "id_licores", "tipo", "nombre", "marca", "cantidad", "precio", "pais_origen", "fecha", "descripcion"
            }
        ));
        jScrollPane1.setViewportView(tbllicores);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 390));

        jTabbedPane1.addTab("tab1", jPanel2);

        jPanel5.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 420));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 430));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 430));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tbllicores;
    // End of variables declaration//GEN-END:variables
}
