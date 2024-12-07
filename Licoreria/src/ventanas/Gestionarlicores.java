
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

public class Gestionarlicores extends javax.swing.JFrame {

 
    
    public Gestionarlicores() {
        initComponents();
        cargarLicores();
        configurarTabla();
         inicializarFecha();  // Mostrar la fecha actual en el campo txtFechadeingreso
    inicializarID();
    
    }

    private void inicializarFecha() {
    // Obtener la fecha actual
    java.util.Date fechaActual = new java.util.Date(System.currentTimeMillis());
    
    // Formato de fecha: Año-Mes-Día
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    
    // Establecer la fecha en el campo de texto
    txtFechadeingreso.setText(sdf.format(fechaActual));
}
    
    private void inicializarID() {
    try (Connection con = ConexionBD.conectar();
         PreparedStatement ps = con.prepareStatement("SELECT MAX(id) FROM licores");
         ResultSet rs = ps.executeQuery()) {
        
        if (rs.next()) {
            int id = rs.getInt(1); // Obtener el último ID
            txtCodigolico.setText(String.valueOf(id + 1));  // Mostrar el siguiente ID
        } else {
            txtCodigolico.setText("1");  // Si no hay registros, iniciar con ID 1
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error al obtener el ID: " + e.getMessage());
    }
}

    private void configurarTabla() {
    // Agregar un listener para detectar cambios en la selección de filas
    tbllicores.getSelectionModel().addListSelectionListener(e -> {
        // Verifica que hay una fila seleccionada
        if (!e.getValueIsAdjusting() && tbllicores.getSelectedRow() != -1) {
            int selectedRow = tbllicores.getSelectedRow(); // Obtener la fila seleccionada
            String id = tbllicores.getValueAt(selectedRow, 0).toString(); // Obtener el ID de la primera columna
            txtCodigolico.setText(id); // Mostrar el ID en el campo de texto
        }
    });
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
                        rs.getInt("id"), rs.getString("nombre"), rs.getString("tipo"),
                        rs.getString("marca"), rs.getInt("cantidad"), rs.getDouble("precio"),
                        rs.getString("pais_origen"), rs.getString("fecha_ingreso"), rs.getString("descripcion")
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
        txtCodigolico = new javax.swing.JTextField();
        txtpaisorigen = new javax.swing.JTextField();
        txtcantidadlico = new javax.swing.JTextField();
        txtNombrelico = new javax.swing.JTextField();
        jbtnIGV = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbllicores = new javax.swing.JTable();
        txtbuscarid = new javax.swing.JTextField();
        btnbuscarlicor = new javax.swing.JButton();
        txtcostolico1 = new javax.swing.JTextField();
        txtTipo = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        txtFechadeingreso = new javax.swing.JTextField();
        btneliminarlicor = new javax.swing.JButton();
        btnactualizarlicor1 = new javax.swing.JButton();
        btnAgregarlico1 = new javax.swing.JButton();
        txtMarca = new javax.swing.JTextField();
        btnreporteslicor1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtCodigolico.setBorder(javax.swing.BorderFactory.createTitledBorder("CODIGO"));
        txtCodigolico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigolicoActionPerformed(evt);
            }
        });
        jPanel1.add(txtCodigolico, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 250, 60));

        txtpaisorigen.setBorder(javax.swing.BorderFactory.createTitledBorder("Origen"));
        txtpaisorigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpaisorigenActionPerformed(evt);
            }
        });
        jPanel1.add(txtpaisorigen, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 250, 60));

        txtcantidadlico.setBorder(javax.swing.BorderFactory.createTitledBorder("Cantidad"));
        txtcantidadlico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcantidadlicoActionPerformed(evt);
            }
        });
        jPanel1.add(txtcantidadlico, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, 110, 60));

        txtNombrelico.setBorder(javax.swing.BorderFactory.createTitledBorder("Nombre"));
        txtNombrelico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombrelicoActionPerformed(evt);
            }
        });
        jPanel1.add(txtNombrelico, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 250, 60));

        jbtnIGV.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar el IGV", "18%" }));
        jbtnIGV.setBorder(javax.swing.BorderFactory.createTitledBorder("IGV"));
        jPanel1.add(jbtnIGV, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 100, 110, 60));

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

        jPanel5.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, 420));
        jPanel5.add(txtbuscarid, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 30, 160, 40));

        btnbuscarlicor.setText("BUSCAR");
        btnbuscarlicor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarlicorActionPerformed(evt);
            }
        });
        jPanel5.add(btnbuscarlicor, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 30, 150, 50));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 1060, 500));

        txtcostolico1.setBorder(javax.swing.BorderFactory.createTitledBorder("Costo"));
        txtcostolico1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcostolico1ActionPerformed(evt);
            }
        });
        jPanel1.add(txtcostolico1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 20, 110, 60));

        txtTipo.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipo"));
        txtTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTipoActionPerformed(evt);
            }
        });
        jPanel1.add(txtTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 150, 110, 60));

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        txtDescripcion.setBorder(javax.swing.BorderFactory.createTitledBorder("Descripcion"));
        jScrollPane3.setViewportView(txtDescripcion);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 20, -1, -1));

        txtFechadeingreso.setEditable(false);
        txtFechadeingreso.setBorder(javax.swing.BorderFactory.createTitledBorder("Fecha de ingreso"));
        txtFechadeingreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechadeingresoActionPerformed(evt);
            }
        });
        jPanel1.add(txtFechadeingreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 20, 110, 60));

        btneliminarlicor.setText("ELIMINAR");
        btneliminarlicor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarlicorActionPerformed(evt);
            }
        });
        jPanel1.add(btneliminarlicor, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 100, 150, 50));

        btnactualizarlicor1.setText("ACTUALIZAR");
        btnactualizarlicor1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnactualizarlicor1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnactualizarlicor1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 180, 150, 50));

        btnAgregarlico1.setText("AGREGAR");
        btnAgregarlico1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarlico1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregarlico1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 170, 150, 50));

        txtMarca.setBorder(javax.swing.BorderFactory.createTitledBorder("Marca"));
        txtMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMarcaActionPerformed(evt);
            }
        });
        jPanel1.add(txtMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 20, 110, 60));

        btnreporteslicor1.setText("REPORTE");
        jPanel1.add(btnreporteslicor1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 100, 150, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1130, 760));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCodigolicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigolicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigolicoActionPerformed

    private void txtpaisorigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpaisorigenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpaisorigenActionPerformed

    private void txtcantidadlicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcantidadlicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcantidadlicoActionPerformed

    private void txtNombrelicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombrelicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombrelicoActionPerformed

    private void txtcostolico1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcostolico1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcostolico1ActionPerformed

    private void txtTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTipoActionPerformed

    private void txtFechadeingresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechadeingresoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechadeingresoActionPerformed

    private void btnAgregarlico1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarlico1ActionPerformed
        String nombre = txtNombrelico.getText();
    String tipo = txtTipo.getText();
    String marca = txtMarca.getText();
    int cantidad = Integer.parseInt(txtcantidadlico.getText());
    double precio = Double.parseDouble(txtcostolico1.getText());
    String paisOrigen = txtpaisorigen.getText();
    String descripcion = txtDescripcion.getText();

    // Obtener la fecha actual
    java.sql.Date fechaIngreso = new java.sql.Date(System.currentTimeMillis()); // Usamos java.sql.Date

    try (Connection con = ConexionBD.conectar();
         PreparedStatement ps = con.prepareStatement(
                 "INSERT INTO licores (nombre, tipo, marca, cantidad, precio, pais_origen, fecha_ingreso, descripcion) VALUES (?, ?, ?, ?, ?, ?, ?, ?)")) {
        ps.setString(1, nombre);
        ps.setString(2, tipo);
        ps.setString(3, marca);
        ps.setInt(4, cantidad);
        ps.setDouble(5, precio);
        ps.setString(6, paisOrigen);
        ps.setDate(7, fechaIngreso); // Asignamos la fecha al PreparedStatement
        ps.setString(8, descripcion);

        ps.executeUpdate();
        JOptionPane.showMessageDialog(this, "Licor agregado exitosamente.");
        cargarLicores(); // Actualizar tabla
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error al agregar licor: " + e.getMessage());
    }
    }//GEN-LAST:event_btnAgregarlico1ActionPerformed

    private void txtMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMarcaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMarcaActionPerformed

    private void btnactualizarlicor1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnactualizarlicor1ActionPerformed
        String idText = txtCodigolico.getText();

    if (idText.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Por favor, ingrese un ID válido.");
        return;
    }

    try {
        int id = Integer.parseInt(idText);
        String nombre = txtNombrelico.getText();
        String tipo = txtTipo.getText();
        String marca = txtMarca.getText();
        String cantidadText = txtcantidadlico.getText();
        String precioText = txtcostolico1.getText();
        String paisOrigen = txtpaisorigen.getText();
        String fechaIngreso = txtFechadeingreso.getText();
        String descripcion = txtDescripcion.getText();

        if (nombre.isEmpty() || tipo.isEmpty() || marca.isEmpty() || cantidadText.isEmpty() || precioText.isEmpty() || paisOrigen.isEmpty() || fechaIngreso.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.");
            return;
        }

        int cantidad = Integer.parseInt(cantidadText);
        double precio = Double.parseDouble(precioText);

        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(
                     "UPDATE licores SET nombre = ?, tipo = ?, marca = ?, cantidad = ?, precio = ?, pais_origen = ?, fecha_ingreso = ?, descripcion = ? WHERE id = ?")) {
            ps.setString(1, nombre);
            ps.setString(2, tipo);
            ps.setString(3, marca);
            ps.setInt(4, cantidad);
            ps.setDouble(5, precio);
            ps.setString(6, paisOrigen);
            ps.setString(7, fechaIngreso);
            ps.setString(8, descripcion);
            ps.setInt(9, id);

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Licor actualizado exitosamente.");
            } else {
                JOptionPane.showMessageDialog(this, "No se encontró un licor con el ID especificado.");
            }
            cargarLicores(); // Actualizar tabla
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Cantidad, precio e ID deben ser números válidos.");
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error al actualizar licor: " + e.getMessage());
    }
    
    }//GEN-LAST:event_btnactualizarlicor1ActionPerformed

    private void btnbuscarlicorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarlicorActionPerformed
        String buscar = txtbuscarid.getText();
        DefaultTableModel model = (DefaultTableModel) tbllicores.getModel();
        model.setRowCount(0); // Limpiar la tabla

        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(
                     "SELECT * FROM licores WHERE id = ? OR nombre LIKE ?")) {
            ps.setString(1, buscar);
            ps.setString(2, "%" + buscar + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                model.addRow(new Object[]{
                        rs.getInt("id"), rs.getString("nombre"), rs.getString("tipo"),
                        rs.getString("marca"), rs.getInt("cantidad"), rs.getDouble("precio"),
                        rs.getString("pais_origen"), rs.getString("fecha_ingreso"), rs.getString("descripcion")
                });
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al buscar licor: " + e.getMessage());
        }
    }//GEN-LAST:event_btnbuscarlicorActionPerformed

    private void btneliminarlicorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarlicorActionPerformed
        String idText = txtCodigolico.getText();

    if (idText.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Por favor, ingrese un ID válido.");
        return;
    }

    try {
        int id = Integer.parseInt(idText);

        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement("DELETE FROM licores WHERE id = ?")) {

            ps.setInt(1, id);

            int confirm = JOptionPane.showConfirmDialog(this, "¿Estás seguro de eliminar este licor?", "Confirmar", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                int rowsAffected = ps.executeUpdate();

                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(this, "Licor eliminado exitosamente.");
                } else {
                    JOptionPane.showMessageDialog(this, "No se encontró un licor con el ID especificado.");
                }
                cargarLicores(); // Actualizar tabla
            }
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "El ID debe ser un número.");
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error al eliminar licor: " + e.getMessage());
    }
    }//GEN-LAST:event_btneliminarlicorActionPerformed

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
            java.util.logging.Logger.getLogger(Gestionarlicores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gestionarlicores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gestionarlicores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gestionarlicores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Gestionarlicores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAgregarlico1;
    public javax.swing.JButton btnactualizarlicor1;
    public javax.swing.JButton btnbuscarlicor;
    public javax.swing.JButton btneliminarlicor;
    public javax.swing.JButton btnreporteslicor1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    public javax.swing.JComboBox<String> jbtnIGV;
    public javax.swing.JTable tbllicores;
    public javax.swing.JTextField txtCodigolico;
    public javax.swing.JTextArea txtDescripcion;
    public javax.swing.JTextField txtFechadeingreso;
    public javax.swing.JTextField txtMarca;
    public javax.swing.JTextField txtNombrelico;
    public javax.swing.JTextField txtTipo;
    public javax.swing.JTextField txtbuscarid;
    public javax.swing.JTextField txtcantidadlico;
    public javax.swing.JTextField txtcostolico1;
    public javax.swing.JTextField txtpaisorigen;
    // End of variables declaration//GEN-END:variables
}
