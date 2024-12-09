
package ventanas;

import java.sql.*;
import conexion.ConexionBD;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Principal extends javax.swing.JFrame {

   private DefaultTableModel modelo = new DefaultTableModel();
   private Integer idPedido = null;
    private final double IGV = 0.18;
    
    
    public Principal() {
        initComponents(); // Esto debe ir primero para inicializar el UI
    this.setLocationRelativeTo(null);
    this.TableDetalles.setModel(modelo);
    this.modelo.addColumn("Tipo de Licor o Combo");
    this.modelo.addColumn("Marca/Combo");
    this.modelo.addColumn("Cantidad");
    this.modelo.addColumn("Precio Unitario");
    this.modelo.addColumn("Total a Pagar");

    cargarTiposLicor(); // Llama a cargar los tipos después de inicializar el UI
    // Genera un pedido nuevo
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelLogo = new javax.swing.JLabel();
        jLabelIcono = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        btnListaPrecios = new javax.swing.JButton();
        btnVentas = new javax.swing.JButton();
        jLabelTipoLicorCombo = new javax.swing.JLabel();
        jLabelMarcaCombo = new javax.swing.JLabel();
        jLabelCantidad = new javax.swing.JLabel();
        jLabelPrecio = new javax.swing.JLabel();
        txtCant = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        btnLimpiar = new javax.swing.JButton();
        btnagregartabla = new javax.swing.JButton();
        jLabelTotalPagar = new javax.swing.JLabel();
        txtTotalPagar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableDetalles = new javax.swing.JTable();
        cbLicorCombo = new javax.swing.JComboBox<>();
        btnLimpiarTabla = new javax.swing.JButton();
        btnQuitarCompra = new javax.swing.JButton();
        btnNetoPagar = new javax.swing.JButton();
        btnGenerarpedido = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtNetoPagar = new javax.swing.JTextField();
        cbLicorNombre = new javax.swing.JComboBox<>();
        jLabelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabelLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/imagen2.png"))); // NOI18N

        jLabelIcono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/imagen9.png"))); // NOI18N

        btnSalir.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSalir.setText("SALIR");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnListaPrecios.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnListaPrecios.setText("LISTA DE PRECIOS");
        btnListaPrecios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListaPreciosActionPerformed(evt);
            }
        });

        btnVentas.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnVentas.setText("GANACIAS ACUMULADAS");
        btnVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVentasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLabelLogo))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabelIcono, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnSalir)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnVentas)
                                .addGap(43, 43, 43)
                                .addComponent(btnListaPrecios)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabelLogo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelIcono, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalir)
                    .addComponent(btnListaPrecios)
                    .addComponent(btnVentas))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 670));

        jLabelTipoLicorCombo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelTipoLicorCombo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTipoLicorCombo.setText("TIPO DE LICOR O COMBO");
        getContentPane().add(jLabelTipoLicorCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 40, -1, -1));

        jLabelMarcaCombo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelMarcaCombo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelMarcaCombo.setText("Nombre");
        getContentPane().add(jLabelMarcaCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 40, -1, -1));

        jLabelCantidad.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelCantidad.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCantidad.setText("CANTIDAD");
        getContentPane().add(jLabelCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 40, -1, -1));

        jLabelPrecio.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelPrecio.setForeground(new java.awt.Color(255, 255, 255));
        jLabelPrecio.setText("PRECIO");
        getContentPane().add(jLabelPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 40, -1, -1));
        getContentPane().add(txtCant, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 80, 100, -1));
        getContentPane().add(txtPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 80, 100, -1));

        btnLimpiar.setBackground(new java.awt.Color(0, 0, 102));
        btnLimpiar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnLimpiar.setForeground(new java.awt.Color(255, 255, 255));
        btnLimpiar.setText("LIMPIAR");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        getContentPane().add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 130, 120, -1));

        btnagregartabla.setBackground(new java.awt.Color(0, 0, 102));
        btnagregartabla.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnagregartabla.setForeground(new java.awt.Color(255, 255, 255));
        btnagregartabla.setText("AGREGAR A LA TABLA");
        btnagregartabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregartablaActionPerformed(evt);
            }
        });
        getContentPane().add(btnagregartabla, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 130, -1, -1));

        jLabelTotalPagar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelTotalPagar.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTotalPagar.setText("TOTAL A PAGAR: ");
        getContentPane().add(jLabelTotalPagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 130, -1, -1));

        txtTotalPagar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtTotalPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalPagarActionPerformed(evt);
            }
        });
        getContentPane().add(txtTotalPagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 130, 100, -1));

        TableDetalles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(TableDetalles);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 170, 660, 420));

        cbLicorCombo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cbLicorCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbLicorComboActionPerformed(evt);
            }
        });
        getContentPane().add(cbLicorCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 70, 130, 30));

        btnLimpiarTabla.setBackground(new java.awt.Color(0, 0, 102));
        btnLimpiarTabla.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnLimpiarTabla.setForeground(new java.awt.Color(255, 255, 255));
        btnLimpiarTabla.setText("LIMPIAR TABLA");
        btnLimpiarTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarTablaActionPerformed(evt);
            }
        });
        getContentPane().add(btnLimpiarTabla, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 600, -1, -1));

        btnQuitarCompra.setBackground(new java.awt.Color(0, 0, 102));
        btnQuitarCompra.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnQuitarCompra.setForeground(new java.awt.Color(255, 255, 255));
        btnQuitarCompra.setText("QUITAR");
        btnQuitarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarCompraActionPerformed(evt);
            }
        });
        getContentPane().add(btnQuitarCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 630, 80, -1));

        btnNetoPagar.setBackground(new java.awt.Color(0, 0, 102));
        btnNetoPagar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnNetoPagar.setForeground(new java.awt.Color(255, 255, 255));
        btnNetoPagar.setText("PRECIO NETO");
        btnNetoPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNetoPagarActionPerformed(evt);
            }
        });
        getContentPane().add(btnNetoPagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 600, 110, -1));

        btnGenerarpedido.setBackground(new java.awt.Color(0, 0, 102));
        btnGenerarpedido.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnGenerarpedido.setForeground(new java.awt.Color(255, 255, 255));
        btnGenerarpedido.setText("GENERAR PEDIDO");
        btnGenerarpedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarpedidoActionPerformed(evt);
            }
        });
        getContentPane().add(btnGenerarpedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 630, 140, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("NETO A PAGAR: S/.");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 630, -1, -1));

        txtNetoPagar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtNetoPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNetoPagarActionPerformed(evt);
            }
        });
        getContentPane().add(txtNetoPagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 620, 120, 30));

        cbLicorNombre.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cbLicorNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbLicorNombreActionPerformed(evt);
            }
        });
        getContentPane().add(cbLicorNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 70, 130, 30));

        jLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fonfo azul hd.jpg"))); // NOI18N
        getContentPane().add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 670));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private int netoPagarCont=0;
    private double netoPagarAcumul=0;
    private double cantidad;
    private double precio;
    private double total;
    
    
    private void generarNuevoPedido() {
        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(
                 "INSERT INTO pedido (total) VALUES (0)", Statement.RETURN_GENERATED_KEYS)) {
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                idPedido = rs.getInt(1);
                JOptionPane.showMessageDialog(this, "Nuevo pedido generado. ID: " + idPedido);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al generar nuevo pedido: " + e.getMessage());
        }
    }
    private void cargarTiposLicor() {
    cbLicorCombo.removeAllItems();
    try (Connection con = ConexionBD.conectar();
     Statement st = con.createStatement();
     ResultSet rs = st.executeQuery("SELECT DISTINCT tipo FROM licores")) {
    while (rs.next()) {
        System.out.println("Tipo encontrado: " + rs.getString("tipo")); // Depuración
        cbLicorCombo.addItem(rs.getString("tipo"));
    }
} catch (SQLException e) {
    System.out.println("Error al cargar tipos de licor: " + e.getMessage());
}
}

private void cargarLicoresPorTipo(String tipo) {
    cbLicorNombre.removeAllItems();
    try (Connection con = ConexionBD.conectar();
         PreparedStatement ps = con.prepareStatement("SELECT nombre FROM licores WHERE tipo = ?")) {
        ps.setString(1, tipo);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            cbLicorNombre.addItem(rs.getString("nombre"));
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error al cargar nombres de licores: " + e.getMessage());
        e.printStackTrace(); // Para depuración
    }
}

    private void btnagregartablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregartablaActionPerformed
        String tipo = (String) cbLicorCombo.getSelectedItem();
        String nombre = (String) cbLicorNombre.getSelectedItem();
        int cantidad = Integer.parseInt(txtCant.getText());
        double precio = Double.parseDouble(txtPrecio.getText());
        double total = cantidad * precio;

        DecimalFormat df = new DecimalFormat("##.##");
        modelo.addRow(new Object[]{tipo, nombre, cantidad, df.format(precio), df.format(total)});
    }//GEN-LAST:event_btnagregartablaActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        cbLicorCombo.setSelectedIndex(0);
        txtCant.setText("");
        txtPrecio.setText("");
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnLimpiarTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarTablaActionPerformed
        // TODO add your handling code here:
        int x=TableDetalles.getRowCount();
        for(int y=x-1; y>=0; y--){
            this.modelo.removeRow(y);
        }
        this.txtNetoPagar.setText("");  
    }//GEN-LAST:event_btnLimpiarTablaActionPerformed

    private void btnQuitarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarCompraActionPerformed

        try{ 
            this.modelo.removeRow(this.TableDetalles.getSelectedRow());
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this,"NO HAY MÁS DATOS POR QUITAR O NO SELECCIONO UNA FILA");
        }
    }//GEN-LAST:event_btnQuitarCompraActionPerformed

    private void btnNetoPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNetoPagarActionPerformed
        // TODO add your handling code here:
        double sumatoria;
        double sumatorial=0;
        int totalRow=TableDetalles.getRowCount();
        double netoIGV;
        totalRow-=1;
        for(int i =0; i<=(totalRow);i++){
            sumatoria=Double.parseDouble(String.valueOf(TableDetalles.getValueAt(i,4)));
            sumatorial+=sumatoria;
        }
        netoIGV=sumatorial*(1+IGV);
        DecimalFormat df=new DecimalFormat("##.##");
        txtNetoPagar.setText(df.format(netoIGV));
        
        netoPagarCont++;
        netoPagarAcumul+=netoIGV;
    }//GEN-LAST:event_btnNetoPagarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnListaPreciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListaPreciosActionPerformed
        
    }//GEN-LAST:event_btnListaPreciosActionPerformed

    private void txtTotalPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalPagarActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtTotalPagarActionPerformed

    private void txtNetoPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNetoPagarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNetoPagarActionPerformed

    private void btnVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentasActionPerformed
        // TODO add your handling code here:
        DecimalFormat df= new DecimalFormat("#.##");
         String mensaje = "Ventas realizadas: " + netoPagarCont+ "\n" +
                         "Ganancia acumulada: " + df.format(netoPagarAcumul);
        JOptionPane.showMessageDialog(this, mensaje, "Información", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnVentasActionPerformed

    private void cbLicorNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbLicorNombreActionPerformed
        String nombre = (String) cbLicorNombre.getSelectedItem();
    if (nombre != null) {
        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(
                 "SELECT cantidad, precio FROM licores WHERE nombre = ?")) {
            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                txtCant.setText(String.valueOf(rs.getInt("cantidad")));
                txtPrecio.setText(String.valueOf(rs.getDouble("precio")));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al cargar información del licor: " + e.getMessage());
        }
    }
    }//GEN-LAST:event_cbLicorNombreActionPerformed

    private void btnGenerarpedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarpedidoActionPerformed

    try (Connection con = ConexionBD.conectar()) {
        for (int i = 0; i < modelo.getRowCount(); i++) {
            String nombre = (String) modelo.getValueAt(i, 1);
            int cantidadSolicitada = Integer.parseInt(String.valueOf(modelo.getValueAt(i, 2)));

            // Verificar si hay suficiente stock
            try (PreparedStatement psStock = con.prepareStatement(
                 "SELECT cantidad FROM licores WHERE nombre = ?")) {
                psStock.setString(1, nombre);
                ResultSet rs = psStock.executeQuery();
                if (rs.next()) {
                    int cantidadDisponible = rs.getInt("cantidad");
                    if (cantidadSolicitada > cantidadDisponible) {
                        JOptionPane.showMessageDialog(this,
                                "No hay suficiente stock para el licor: " + nombre +
                                ". Stock disponible: " + cantidadDisponible,
                                "Stock insuficiente",
                                JOptionPane.ERROR_MESSAGE);
                        return; // Cancelar todo el proceso si no hay stock suficiente
                    }
                } else {
                    JOptionPane.showMessageDialog(this,
                            "El licor seleccionado no existe en la base de datos.",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return; // Cancelar todo el proceso si no se encuentra el licor
                }
            }
        }

        // Generar un nuevo pedido solo si la validación de stock fue exitosa
        if (idPedido == null) {
            generarNuevoPedido();
        }

        // Insertar detalles del pedido y actualizar stock
        for (int i = 0; i < modelo.getRowCount(); i++) {
            String tipo = (String) modelo.getValueAt(i, 0);
            String nombre = (String) modelo.getValueAt(i, 1);
            int cantidadSolicitada = Integer.parseInt(String.valueOf(modelo.getValueAt(i, 2)));
            double precio = Double.parseDouble(String.valueOf(modelo.getValueAt(i, 3)));
            double total = Double.parseDouble(String.valueOf(modelo.getValueAt(i, 4)));

            // Obtener el ID del licor
            int idLicor = -1;
            try (PreparedStatement psId = con.prepareStatement(
                 "SELECT id FROM licores WHERE nombre = ?")) {
                psId.setString(1, nombre);
                ResultSet rs = psId.executeQuery();
                if (rs.next()) {
                    idLicor = rs.getInt("id");
                }
            }

            // Insertar detalle del pedido
            try (PreparedStatement psDetalle = con.prepareStatement(
                 "INSERT INTO detalle_pedido (id_pedido, id_licor, tipo, nombre, cantidad, precio_unitario, total) " +
                 "VALUES (?, ?, ?, ?, ?, ?, ?)")) {
                psDetalle.setInt(1, idPedido);
                psDetalle.setInt(2, idLicor);
                psDetalle.setString(3, tipo);
                psDetalle.setString(4, nombre);
                psDetalle.setInt(5, cantidadSolicitada);
                psDetalle.setDouble(6, precio);
                psDetalle.setDouble(7, total);
                psDetalle.executeUpdate();
            }

            // Actualizar el stock
            try (PreparedStatement psUpdateStock = con.prepareStatement(
                 "UPDATE licores SET cantidad = cantidad - ? WHERE id = ?")) {
                psUpdateStock.setInt(1, cantidadSolicitada);
                psUpdateStock.setInt(2, idLicor);
                psUpdateStock.executeUpdate();
            }
        }

        // Actualizar el total del pedido
        try (PreparedStatement ps = con.prepareStatement(
             "UPDATE pedido SET total = (SELECT SUM(total) FROM detalle_pedido WHERE id_pedido = ?) WHERE id_pedido = ?")) {
            ps.setInt(1, idPedido);
            ps.setInt(2, idPedido);
            ps.executeUpdate();
        }

        JOptionPane.showMessageDialog(this, "Pedido generado correctamente con ID: " + idPedido);

        // Limpiar la tabla y reiniciar el pedido
        modelo.setRowCount(0);
        idPedido = null; // Reiniciar el ID para permitir generar un nuevo pedido
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error al generar pedido: " + e.getMessage());
    }
    }//GEN-LAST:event_btnGenerarpedidoActionPerformed

    private void cbLicorComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbLicorComboActionPerformed
String tipoSeleccionado = (String) cbLicorCombo.getSelectedItem();
    if (tipoSeleccionado != null) {
        cargarLicoresPorTipo(tipoSeleccionado);
    }
    }//GEN-LAST:event_cbLicorComboActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TableDetalles;
    private javax.swing.JButton btnGenerarpedido;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnLimpiarTabla;
    private javax.swing.JButton btnListaPrecios;
    private javax.swing.JButton btnNetoPagar;
    private javax.swing.JButton btnQuitarCompra;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnVentas;
    private javax.swing.JButton btnagregartabla;
    private javax.swing.JComboBox<String> cbLicorCombo;
    private javax.swing.JComboBox<String> cbLicorNombre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelCantidad;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JLabel jLabelIcono;
    private javax.swing.JLabel jLabelLogo;
    private javax.swing.JLabel jLabelMarcaCombo;
    private javax.swing.JLabel jLabelPrecio;
    private javax.swing.JLabel jLabelTipoLicorCombo;
    private javax.swing.JLabel jLabelTotalPagar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtCant;
    private javax.swing.JTextField txtNetoPagar;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtTotalPagar;
    // End of variables declaration//GEN-END:variables
}
