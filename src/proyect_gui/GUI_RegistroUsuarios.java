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
import proyect_clases.Usuario;
import proyect_metodos.MetodoUsuario;

public class GUI_RegistroUsuarios extends javax.swing.JFrame {
    
   // Se declara esta variable final que obtendra siempre la ruta de los archivos dentro del directorio del programa
    private final String ruta = System.getProperties().getProperty("user.dir");
    
    Usuario usuario = new Usuario();
    MetodoUsuario metodos = new MetodoUsuario ();
    MetodoUsuario buscar = new MetodoUsuario ();
    MetodoUsuario eliminar = new MetodoUsuario();
    DefaultTableModel mdlTablaU;
    Vector vCabeceras = new Vector();
    Vector v = new Vector();
    
    public GUI_RegistroUsuarios() throws FileNotFoundException {
        
        initComponents();
        GenerarCodigoUsuario();
        txt_u_id.setEditable(false);
        txt_u_id.setBackground(Color.yellow);
        vCabeceras.addElement("ID");
        vCabeceras.addElement("NOMBRE");
        vCabeceras.addElement("APELLIDO");
        vCabeceras.addElement("USERNAME");
        vCabeceras.addElement("CLAVE");
        mdlTablaU = new DefaultTableModel(vCabeceras,0);
        table_usuario.setModel(mdlTablaU);
        table_usuario.setModel(metodos.listaUsuario());

    }
    
    // Este metodo genera en forma automatica un Id diferente y consecuitivo para cada venta de boleto.
    // Cada Id nuevo generado sera el numero siguiente al ultimo Id generado en la venta anterior.
    // Los ID son únicos, irrepetibles y no pueden ser editados. Son los identificadores de cada venta
    public final void GenerarCodigoUsuario() throws FileNotFoundException{

        txt_u_id.setText("1");
        String ultimoCodigo="0";
        int nuevoCodigo=0;
        
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        
           try {
            archivo = new File(ruta+"\\src\\proyect_persistencia\\usuario.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            
           Object [] tableLines = br.lines().toArray();
         // Recorro mediante un Array todo el archivo usuario.txt y verifico la posicion [0] para ver el codigo de venta de cada pasaje
               for (int i = 0; i < tableLines.length; i++) {
                   String line = tableLines[i].toString().trim();
                   String [] dataRow = line.split(",");
                   ultimoCodigo = (dataRow[0]);
                   }
                // Si ya existen ventas, el código de la próxima venta será el útltimo código + 1
                    nuevoCodigo = Integer.parseInt(ultimoCodigo);
                    txt_u_id.setText(String.valueOf(nuevoCodigo+1));
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

        jScrollPane1 = new javax.swing.JScrollPane();
        table_usuario = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txt_u_nombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_u_apellido = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_u_user = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_u_password = new javax.swing.JTextField();
        txt_u_id = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btn_u_nuevo = new javax.swing.JButton();
        btn_u_guardar = new javax.swing.JButton();
        btn_u_editar = new javax.swing.JButton();
        btn_u_eliminar = new javax.swing.JButton();
        btn_u_salir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        table_usuario.setBackground(new java.awt.Color(255, 255, 153));
        table_usuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        table_usuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_usuarioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_usuario);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/usuario.png"))); // NOI18N
        jLabel6.setText("INGRESO DE USUARIOS");

        jLabel5.setText("Id Usuario :");

        jLabel1.setText("Nombre :");

        jLabel2.setText("Apellido :");

        jLabel4.setText("Username :");

        jLabel3.setText("Clave :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(txt_u_user)
                            .addComponent(txt_u_id, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_u_password, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_u_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addGap(32, 32, 32)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(txt_u_apellido, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_u_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_u_apellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_u_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_u_user, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_u_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 319, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        btn_u_nuevo.setText("Nuevo");
        btn_u_nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_u_nuevoActionPerformed(evt);
            }
        });

        btn_u_guardar.setText("Guardar");
        btn_u_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_u_guardarActionPerformed(evt);
            }
        });

        btn_u_editar.setText("Editar");
        btn_u_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_u_editarActionPerformed(evt);
            }
        });

        btn_u_eliminar.setText("Eliminar");
        btn_u_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_u_eliminarActionPerformed(evt);
            }
        });

        btn_u_salir.setText("Salir");
        btn_u_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_u_salirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btn_u_nuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_u_guardar, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                        .addComponent(btn_u_editar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_u_eliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btn_u_salir, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(btn_u_nuevo)
                .addGap(18, 18, 18)
                .addComponent(btn_u_guardar)
                .addGap(18, 18, 18)
                .addComponent(btn_u_editar)
                .addGap(18, 18, 18)
                .addComponent(btn_u_eliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_u_salir)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(75, 75, 75))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_u_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_u_guardarActionPerformed

                  // Primero validamos cada una de la sentradas

                    if (txt_u_id.getText().length() == 0) {

                        JOptionPane.showMessageDialog(rootPane, "Debe ingresar un número de ID");
                        txt_u_id.requestFocus();
                        return;
                    }
                    
                      if (txt_u_nombre.getText().length() == 0) {

                        JOptionPane.showMessageDialog(rootPane, "Debe ingresar un nombre");
                        txt_u_nombre.requestFocus();
                        return;
                    }
                      
                        if (txt_u_apellido.getText().length() == 0) {

                        JOptionPane.showMessageDialog(rootPane, "Debe ingresar un Apellido");
                        txt_u_apellido.requestFocus();
                        return;
                    }
                        
                          if (txt_u_user.getText().length() == 0) {

                        JOptionPane.showMessageDialog(rootPane, "Debe ingresar un Username");
                        txt_u_user.requestFocus();
                        return;
                    }
                          
                            if (txt_u_password.getText().length() == 0) {

                        JOptionPane.showMessageDialog(rootPane, "Debe ingresar un Password");
                        txt_u_password.requestFocus();
                        return;
                    }

        mdlTablaU = new DefaultTableModel();
        
        int id_u = Integer.parseInt(txt_u_id.getText());
        String nombre_u = txt_u_nombre.getText();
        String apellido_u = txt_u_apellido.getText();
        String user_u = txt_u_user.getText();
        String password_u = txt_u_password.getText();
        usuario.setId_usuario(id_u);
        usuario.setNombre_usuario(nombre_u);
        usuario.setApellido_usuario(apellido_u);
        usuario.setUsarname(user_u);
        usuario.setPassword(password_u);
        metodos.guardarUsuario(usuario);
        metodos.guardarArchivoUsuario(usuario);
        table_usuario.setModel(metodos.listaUsuario());
        
         // Limpia los Jtext:
        txt_u_nombre.setText("");
        txt_u_apellido.setText("");
        txt_u_password.setText("");
        txt_u_user.setText("");
        
        try {
            GenerarCodigoUsuario();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GUI_RegistroUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_u_guardarActionPerformed

    private void btn_u_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_u_salirActionPerformed
        // TODO add your handling code here:
        GUI_Principal b = new GUI_Principal();
        b.setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_u_salirActionPerformed

    private void btn_u_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_u_nuevoActionPerformed
       
        txt_u_nombre.setEditable(true);
        txt_u_apellido.setEditable(true);
        txt_u_password.setEditable(true);
        txt_u_user.setEditable(true);
        
        //Generamos un nuevo codigo de usuario unico
        try {
            GenerarCodigoUsuario();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GUI_RegistroUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
         
       // Activamos el boton de guardar
        
        btn_u_guardar.setEnabled(true);
        
        // Desactivamos el boton Editar mientras estamos en modo NUEVO
        
        btn_u_editar.setEnabled(false);
        
         // Desactivamos el boton Eliminar mientras estamos en modo NUEVO
        
        btn_u_eliminar.setEnabled(false);

       // Limpia los Jtext:
        txt_u_nombre.setText("");
        txt_u_apellido.setText("");
        txt_u_password.setText("");
        txt_u_user.setText("");
    }//GEN-LAST:event_btn_u_nuevoActionPerformed

    private void btn_u_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_u_eliminarActionPerformed
   
        //Confirmamos si deseamos eliminar o no, por seguridad
        int opcion = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar el USUARIO del sistema?");
        if(opcion == JOptionPane.YES_OPTION){  
        
        String IdUsuario = txt_u_id.getText();
        String Nombre = txt_u_nombre.getText();
        String Apellido = txt_u_apellido.getText();
        String Usuario = txt_u_user.getText();
        String Password = txt_u_password.getText();
        
        //Pasamos al metodo los valores de las variables para procesar en el metodo
        metodos.EliminarUsuario(IdUsuario, Nombre, Apellido, Usuario, Password);
        
        // limipiamos los text
        txt_u_nombre.setText("");
        txt_u_apellido.setText("");
        txt_u_password.setText("");
        txt_u_user.setText("");

        // volvemos a leer los datos de la tabla
        table_usuario.setModel(metodos.listaUsuario());

            try {
                GenerarCodigoUsuario();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(GUI_RegistroUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            }
         
        }
        
        btn_u_editar.setEnabled(false);
        btn_u_guardar.setEnabled(true);
    }//GEN-LAST:event_btn_u_eliminarActionPerformed

    private void btn_u_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_u_editarActionPerformed
       
         // Primero validamos cada una de la sentradas
                      if (txt_u_nombre.getText().length() == 0) {

                        JOptionPane.showMessageDialog(rootPane, "Debe ingresar un nombre");
                        txt_u_nombre.requestFocus();
                        return;
                    }
                      
                        if (txt_u_apellido.getText().length() == 0) {

                        JOptionPane.showMessageDialog(rootPane, "Debe ingresar un Apellido");
                        txt_u_apellido.requestFocus();
                        return;
                    }
                        
                          if (txt_u_user.getText().length() == 0) {

                        JOptionPane.showMessageDialog(rootPane, "Debe ingresar un Username");
                        txt_u_user.requestFocus();
                        return;
                    }
                          
                            if (txt_u_password.getText().length() == 0) {

                        JOptionPane.showMessageDialog(rootPane, "Debe ingresar un Password");
                        txt_u_password.requestFocus();
                        return;
                    }

        String id = txt_u_id.getText();
        String nombre_u = txt_u_nombre.getText();
        String apellido_u = txt_u_apellido.getText();
        String user_u = txt_u_user.getText();
        String password_u = txt_u_password.getText();

        metodos.EditarUsuario(id, nombre_u, apellido_u, user_u, password_u);
        
        mdlTablaU = new DefaultTableModel();
        table_usuario.setModel(metodos.listaUsuario());
        
         // Limpia los Jtext:
       
        txt_u_nombre.setText("");
        txt_u_apellido.setText("");
        txt_u_password.setText("");
        txt_u_user.setText("");
        
        // Colocamos el programa para guardar un nuevo usuario luego de cada modificacion
        
        txt_u_nombre.setEditable(true);
        txt_u_apellido.setEditable(true);
        txt_u_password.setEditable(true);
        txt_u_user.setEditable(true);
        
        //Generamos un nuevo codigo de usuario unico
        
        try {
            GenerarCodigoUsuario();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GUI_RegistroUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
         
       // Activamos el boton de guardar
        btn_u_guardar.setEnabled(true);
        
        // Desactivamos el boton Editar mientras estamos en modo NUEVO
        btn_u_editar.setEnabled(false);
        
         // Desactivamos el boton Eliminar mientras estamos en modo NUEVO
        btn_u_eliminar.setEnabled(false);
    }//GEN-LAST:event_btn_u_editarActionPerformed

    private void table_usuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_usuarioMouseClicked
        
        // Desactivamos el boton de guardar para habilitar solo la opcion EDITAR
        
        btn_u_guardar.setEnabled(false);
        
        // Activamos el boton de eliminar 
        
        btn_u_eliminar.setEnabled(true);
        
        // Activamos el boton de guardar cambios 
        
        btn_u_editar.setEnabled(true);
        
        // Cambiamos el valor del boton Editar a texto "Guardar Cambios" para aceptar todo cambio en la tabla
        
        btn_u_editar.setText("Guardar cambios");
         
        // guardamos en fila el valor que hacemos click en la fila seleccionada
        
        int fila = table_usuario.rowAtPoint(evt.getPoint()); 
        txt_u_id.setText(table_usuario.getValueAt(fila, 0).toString());
        txt_u_nombre.setText(table_usuario.getValueAt(fila, 1).toString());
        txt_u_apellido.setText(table_usuario.getValueAt(fila, 2).toString());
        txt_u_user.setText(table_usuario.getValueAt(fila, 3).toString());
        txt_u_password.setText(table_usuario.getValueAt(fila, 4).toString());
        
         
    // Colocamos el programa para guardar un nuevo usuario siempre despues de guardar un cambio
    
    
    
    }//GEN-LAST:event_table_usuarioMouseClicked

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
            java.util.logging.Logger.getLogger(GUI_RegistroUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_RegistroUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_RegistroUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_RegistroUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new GUI_RegistroUsuarios().setVisible(true);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(GUI_RegistroUsuarios.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_u_editar;
    private javax.swing.JButton btn_u_eliminar;
    private javax.swing.JButton btn_u_guardar;
    private javax.swing.JButton btn_u_nuevo;
    private javax.swing.JButton btn_u_salir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table_usuario;
    private javax.swing.JTextField txt_u_apellido;
    private javax.swing.JTextField txt_u_id;
    private javax.swing.JTextField txt_u_nombre;
    private javax.swing.JTextField txt_u_password;
    private javax.swing.JTextField txt_u_user;
    // End of variables declaration//GEN-END:variables
}
