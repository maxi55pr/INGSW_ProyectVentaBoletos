package proyect_gui;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import proyect_metodos.MetodoPasajero;
import proyect_clases.Pasajero;

public class GUI_RegistroPasajeros extends javax.swing.JFrame {

     // Se declara esta variable final que obtendra siempre la ruta de los archivos dentro del directorio del programa
    private final String ruta = System.getProperties().getProperty("user.dir");
    
    Pasajero pasajero = new Pasajero();
    MetodoPasajero metodos = new MetodoPasajero();
    DefaultTableModel mdlTablaP;
    Vector vCabeceras = new Vector();
    
    public GUI_RegistroPasajeros() throws IOException {
        initComponents();
        
         GenerarCodigoPasajero();
        txt_p_id.setEditable(false);
        txt_p_id.setBackground(Color.yellow);
        
        vCabeceras.addElement("ID");
        vCabeceras.addElement("NOMBRE");
        vCabeceras.addElement("APELLIDO");
        vCabeceras.addElement("CEDULA");
        vCabeceras.addElement("EDAD");
        vCabeceras.addElement("CATEGORIA");
        
        mdlTablaP = new DefaultTableModel(vCabeceras,0);
        table_pasajero.setModel(mdlTablaP);
        table_pasajero.setModel(metodos.listaPasajero());
    }
    
     // Este metodo genera en forma automatica un Id diferente y consecuitivo para cada venta de boleto.
    // Cada Id nuevo generado sera el numero siguiente al ultimo Id generado en la venta anterior.
    // Los ID son únicos, irrepetibles y no pueden ser editados. Son los identificadores de cada venta
    public final void GenerarCodigoPasajero() throws FileNotFoundException{

        txt_p_id.setText("1");
        String ultimoCodigo="0";
        int nuevoCodigo=0;
        
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        
           try {
            archivo = new File(ruta+"\\src\\proyect_persistencia\\pasajero.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            
           Object [] tableLines = br.lines().toArray();
         // Recorro mediante un Array todo el archivo Boletos.txt y verifico la posicion [0] para ver el codigo de venta de cada pasaje
               for (int i = 0; i < tableLines.length; i++) {
                   String line = tableLines[i].toString().trim();
                   String [] dataRow = line.split(",");
                   ultimoCodigo = (dataRow[0]);
                   }
                // Si ya existen ventas, el código de la próxima venta será el útltimo código + 1
                    nuevoCodigo = Integer.parseInt(ultimoCodigo);
                    txt_p_id.setText(String.valueOf(nuevoCodigo+1));
            try {
                fr.close();
            } catch (IOException ex) {
                Logger.getLogger(GUI_VentaDeBoletos.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(GUI_VentaDeBoletos.class.getName()).log(Level.SEVERE, null, ex);
            }
          } catch (FileNotFoundException e) {
        }
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_p_nombre = new javax.swing.JTextField();
        txt_p_apellido = new javax.swing.JTextField();
        txt_p_cedula = new javax.swing.JTextField();
        txt_p_edad = new javax.swing.JTextField();
        txt_p_pasajero = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_pasajero = new javax.swing.JTable();
        btn_p_guardar = new javax.swing.JButton();
        btn_p_salir = new javax.swing.JButton();
        btn_p_nuevo = new javax.swing.JButton();
        btn_p_eliminar = new javax.swing.JButton();
        btn_p_actializar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txt_p_id = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nombre:");

        jLabel2.setText("Apellido");

        jLabel3.setText("Cedula");

        jLabel4.setText("Edad:");

        jLabel5.setText("Tipo Pasajero");

        table_pasajero.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        table_pasajero.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_pasajeroMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_pasajero);

        btn_p_guardar.setText("Guardar");
        btn_p_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_p_guardarActionPerformed(evt);
            }
        });

        btn_p_salir.setText("Salir");
        btn_p_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_p_salirActionPerformed(evt);
            }
        });

        btn_p_nuevo.setText("Nuevo");
        btn_p_nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_p_nuevoActionPerformed(evt);
            }
        });

        btn_p_eliminar.setText("Eliminar");
        btn_p_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_p_eliminarActionPerformed(evt);
            }
        });

        btn_p_actializar.setText("Actualizar");
        btn_p_actializar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_p_actializarActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/turista.png"))); // NOI18N
        jLabel6.setText("DATOS DEL PASAJERO:");

        jLabel7.setText("ID Pasajero");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(btn_p_nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(btn_p_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_p_id, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_p_cedula, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_p_pasajero, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(txt_p_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btn_p_actializar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addComponent(txt_p_edad, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_p_eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txt_p_apellido, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btn_p_salir, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel2)
                    .addComponent(txt_p_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_p_apellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(txt_p_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_p_edad, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_p_cedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_p_pasajero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_p_guardar)
                    .addComponent(btn_p_salir)
                    .addComponent(btn_p_nuevo)
                    .addComponent(btn_p_actializar)
                    .addComponent(btn_p_eliminar))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_RegistroPasajeros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
     
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new GUI_RegistroPasajeros().setVisible(true);
            } catch (IOException ex) {
                Logger.getLogger(GUI_RegistroPasajeros.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
    
    private void btn_p_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_p_guardarActionPerformed
        try {
            // TODO add your handling code here:

            GenerarCodigoPasajero();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GUI_RegistroPasajeros.class.getName()).log(Level.SEVERE, null, ex);
        }

            // Primero validamos cada una de la entradas

                        if (txt_p_nombre.getText().length() == 0) {
                        JOptionPane.showMessageDialog(rootPane, "Debe ingresar un Nombre");
                        txt_p_nombre.requestFocus();
                        return;
                    }
                       if (txt_p_apellido.getText().length() == 0) {
                        JOptionPane.showMessageDialog(rootPane, "Debe ingresar un Apellido");
                        txt_p_apellido.requestFocus();
                        return;
                    }
                       if (txt_p_edad.getText().length() == 0) {

                        JOptionPane.showMessageDialog(rootPane, "Debe ingresar una Edad");
                        txt_p_edad.requestFocus();
                        return;
                    } 
                        if (txt_p_cedula.getText().length() == 0) {
                        JOptionPane.showMessageDialog(rootPane, "Debe ingresar un número de Cédula");
                        txt_p_cedula.requestFocus();
                        return;
                    }
                         if (txt_p_pasajero.getText().length() == 0) {
                        JOptionPane.showMessageDialog(rootPane, "Debe ingresar tipo de Pasajero");
                        txt_p_pasajero.requestFocus();
                        return;
                    } 
        
        mdlTablaP = new DefaultTableModel();
      
        int id_p = Integer.parseInt(txt_p_id.getText());
        String nombre_p = txt_p_nombre.getText();
        String apellido_p = txt_p_apellido.getText();
        int cedula_p = Integer.parseInt(txt_p_cedula.getText());
        int edad_p = Integer.parseInt(txt_p_edad.getText());
        String Tipopasajero_p = txt_p_pasajero.getText();
        
        pasajero.setId_pasajero(id_p);
        pasajero.setNombre_pasajero(nombre_p);
        pasajero.setApellido_pasajero(apellido_p);
        pasajero.setCedula_pasajero(cedula_p);
        pasajero.setEdad_pasajero(edad_p);
        pasajero.setTipo_pasajero(Tipopasajero_p);

        metodos.guardarPasajero(pasajero);
        metodos.guardarArchivoPasajero(pasajero);

        txt_p_nombre.setText("");
        txt_p_apellido.setText("");
        txt_p_pasajero.setText("");
        txt_p_cedula.setText("");
        txt_p_edad.setText("");
        
        try {
            table_pasajero.setModel(metodos.listaPasajero());
        } catch (IOException ex) {
            Logger.getLogger(GUI_RegistroPasajeros.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_p_guardarActionPerformed

    private void btn_p_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_p_salirActionPerformed
        // TODO add your handling code here:
        GUI_Principal b = new GUI_Principal();
        b.setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_p_salirActionPerformed

    private void btn_p_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_p_eliminarActionPerformed
              // Boton eliminar pasajeros en tabla:
              
       //Confirmamos si deseamos eliminar o no, por seguridad
        int opcion = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar el PASAJERO del sistema?");
        if(opcion == JOptionPane.YES_OPTION){  
        
        String Id = txt_p_id.getText();
        String Nombre = txt_p_nombre.getText();
        String Apellido = txt_p_apellido.getText();
        String Cedula = txt_p_cedula.getText();
        String Edad = txt_p_edad.getText();
        String tipoPasajero = txt_p_pasajero.getText();

        //Pasamos al metodo los valores de las variables para procesar en el metodo
        metodos.EliminarPasajero(Id, Nombre, Apellido, Cedula, Edad, tipoPasajero);
        
        // limipiamos los text
        
        txt_p_nombre.setText("");
        txt_p_apellido.setText("");
        txt_p_pasajero.setText("");
        txt_p_cedula.setText("");
        txt_p_edad.setText("");
        
            try {
                // volvemos a leer los datos de la tabla
                table_pasajero.setModel(metodos.listaPasajero());
            } catch (IOException ex) {
                Logger.getLogger(GUI_RegistroPasajeros.class.getName()).log(Level.SEVERE, null, ex);
            }
        }   
    }//GEN-LAST:event_btn_p_eliminarActionPerformed
   
    private void btn_p_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_p_nuevoActionPerformed
        
        btn_p_guardar.setEnabled(true);
        btn_p_actializar.setEnabled(false);
        
        
        //nuevo codigo de pasajero se genera
        try {
            GenerarCodigoPasajero();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GUI_RegistroPasajeros.class.getName()).log(Level.SEVERE, null, ex);
        }
       // Limpia los Jtext:
        txt_p_nombre.setText("");
        txt_p_apellido.setText("");
        txt_p_pasajero.setText("");
        txt_p_cedula.setText("");
        txt_p_edad.setText("");
    }//GEN-LAST:event_btn_p_nuevoActionPerformed

    private void btn_p_actializarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_p_actializarActionPerformed
       
         // Primero validamos cada una de la sentradas

                    
                      if (txt_p_nombre.getText().length() == 0) {

                        JOptionPane.showMessageDialog(rootPane, "Debe ingresar un Nombre");
                        txt_p_nombre.requestFocus();
                        return;
                    }
                      
                        if (txt_p_apellido.getText().length() == 0) {

                        JOptionPane.showMessageDialog(rootPane, "Debe ingresar un Apellido");
                        txt_p_apellido.requestFocus();
                        return;
                    }
                        
                          if (txt_p_cedula.getText().length() == 0) {

                        JOptionPane.showMessageDialog(rootPane, "Debe ingresar una Cedula");
                        txt_p_cedula.requestFocus();
                        return;
                    }
                          if (txt_p_cedula.getText().length() == 0) {

                        JOptionPane.showMessageDialog(rootPane, "Debe ingresar una Cedula");
                        txt_p_cedula.requestFocus();
                        return;
                    }
                                  
                       if (txt_p_edad.getText().length() == 0) {

                        JOptionPane.showMessageDialog(rootPane, "Debe ingresar una Edad del Pasajero");
                        txt_p_edad.requestFocus();
                        return;
                    }
                            
                       if (txt_p_pasajero.getText().length() == 0) {

                        JOptionPane.showMessageDialog(rootPane, "Debe ingresar un tipo de Pasajero");
                        txt_p_pasajero.requestFocus();
                        return;
                    }

        String id = txt_p_id.getText();
        String nombre = txt_p_nombre.getText();
        String apellido = txt_p_apellido.getText();
        String cedula = txt_p_cedula.getText();
        String edad = txt_p_edad.getText();
        String tipo= txt_p_pasajero.getText();

        metodos.EditarPasajero(id, nombre, apellido, cedula, edad, tipo);
        
        try {
            table_pasajero.setModel(metodos.listaPasajero());
        } catch (IOException ex) {
            Logger.getLogger(GUI_RegistroPasajeros.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         // Limpia los Jtext:
       
        txt_p_nombre.setText("");
        txt_p_apellido.setText("");
        txt_p_cedula.setText("");
        txt_p_edad.setText("");
        txt_p_pasajero.setText("");

    }//GEN-LAST:event_btn_p_actializarActionPerformed

    private void table_pasajeroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_pasajeroMouseClicked
        // TODO add your handling code here:
        
       btn_p_guardar.setEnabled(false);
       btn_p_actializar.setText("Guardar Cambios");
        
        int fila = table_pasajero.rowAtPoint(evt.getPoint()); // guardamos en fila el valor que hacemos click en la fila seleccionada
        
        txt_p_id.setText(table_pasajero.getValueAt(fila , 0).toString());
        txt_p_nombre.setText(table_pasajero.getValueAt(fila, 1).toString());
        txt_p_apellido.setText(table_pasajero.getValueAt(fila, 2).toString());
        txt_p_cedula.setText(table_pasajero.getValueAt(fila, 3).toString());
        txt_p_edad.setText(table_pasajero.getValueAt(fila, 4).toString());
        txt_p_pasajero.setText(table_pasajero.getValueAt(fila, 5).toString());

    }//GEN-LAST:event_table_pasajeroMouseClicked
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_p_actializar;
    private javax.swing.JButton btn_p_eliminar;
    private javax.swing.JButton btn_p_guardar;
    private javax.swing.JButton btn_p_nuevo;
    private javax.swing.JButton btn_p_salir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table_pasajero;
    private javax.swing.JTextField txt_p_apellido;
    private javax.swing.JTextField txt_p_cedula;
    private javax.swing.JTextField txt_p_edad;
    private javax.swing.JTextField txt_p_id;
    private javax.swing.JTextField txt_p_nombre;
    private javax.swing.JTextField txt_p_pasajero;
    // End of variables declaration//GEN-END:variables

    
}
