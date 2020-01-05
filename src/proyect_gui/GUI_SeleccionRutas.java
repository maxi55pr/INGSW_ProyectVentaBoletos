package proyect_gui;

import java.io.IOException;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import java.util.logging.Level;
import java.util.logging.Logger;
import proyect_clases.Rutas;
import proyect_metodos.MetodoRutas;

public class GUI_SeleccionRutas extends javax.swing.JFrame {

     // Se declara esta variable final que obtendra siempre la ruta de los archivos dentro del directorio del programa
    private final String ruta = System.getProperties().getProperty("user.dir");
   
    Rutas unaRuta = new Rutas();
    MetodoRutas metodos = new MetodoRutas();
    DefaultTableModel mdlTablaR;
    Vector vCabeceras = new Vector();
    
    public GUI_SeleccionRutas() throws IOException {
        
        initComponents();

        
        vCabeceras.addElement("ID");
        vCabeceras.addElement("RUTA");
        vCabeceras.addElement("ORIGEN");
        vCabeceras.addElement("DESTINO");
        vCabeceras.addElement("COSTO");
        vCabeceras.addElement("HORA");
        vCabeceras.addElement("FECHA");
        
        mdlTablaR = new DefaultTableModel(vCabeceras,0);
        table_seleccion_rutas.setModel(mdlTablaR);
        table_seleccion_rutas.setModel(metodos.listaRutas());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_r_salir = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_seleccion_rutas = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Modulo De Rutas");
        setBackground(new java.awt.Color(204, 204, 204));

        btn_r_salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/salida.png"))); // NOI18N
        btn_r_salir.setText("Salir");
        btn_r_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_r_salirActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/destino.png"))); // NOI18N
        jLabel6.setText("SELECCIONE UNA RUTA DE VUELO");

        table_seleccion_rutas.setBackground(new java.awt.Color(204, 255, 204));
        table_seleccion_rutas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        table_seleccion_rutas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_seleccion_rutasMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                table_seleccion_rutasMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                table_seleccion_rutasMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(table_seleccion_rutas);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Haga doble click en la siguiente lista para seleccionar una ruta");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 747, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_r_salir, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_r_salir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_r_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_r_salirActionPerformed
        // TODO add your handling code here:
        GUI_Principal b = new GUI_Principal();
        b.setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_r_salirActionPerformed
   
    
    private void table_seleccion_rutasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_seleccion_rutasMouseClicked
 

 
    }//GEN-LAST:event_table_seleccion_rutasMouseClicked

    private void table_seleccion_rutasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_seleccion_rutasMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_table_seleccion_rutasMouseEntered

    private void table_seleccion_rutasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_seleccion_rutasMousePressed
      
          if (evt.getClickCount()==2) {
            
            int fila = table_seleccion_rutas.getSelectedRow();
            
            String ruta="";
            String origen="";
            String destino="";
            String costo="";
            String hora="";
            String fecha="";
            
            ruta=table_seleccion_rutas.getValueAt(fila, 1).toString();
            origen=table_seleccion_rutas.getValueAt(fila, 2).toString();
            destino=table_seleccion_rutas.getValueAt(fila, 3).toString();
            costo=table_seleccion_rutas.getValueAt(fila, 4).toString();
            hora=table_seleccion_rutas.getValueAt(fila, 5).toString();
            fecha=table_seleccion_rutas.getValueAt(fila, 6).toString();

            GUI_VentaDeBoletos.txtRuta.setText(ruta);
            GUI_VentaDeBoletos.txtOrigen.setText(origen);
            GUI_VentaDeBoletos.txtDestino.setText(destino);
            GUI_VentaDeBoletos.txtCosto.setText(costo);
            GUI_VentaDeBoletos.txtHora.setText(hora);
            GUI_VentaDeBoletos.txtFecha.setText(fecha);

            this.dispose();
        }
        
    }//GEN-LAST:event_table_seleccion_rutasMousePressed

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
            java.util.logging.Logger.getLogger(GUI_SeleccionRutas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_SeleccionRutas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_SeleccionRutas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_SeleccionRutas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new GUI_SeleccionRutas().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(GUI_SeleccionRutas.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_r_salir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table_seleccion_rutas;
    // End of variables declaration//GEN-END:variables
}
