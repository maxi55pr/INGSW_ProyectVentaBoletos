package proyect_gui;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class GUIi_AccesoSistema extends javax.swing.JFrame {
    
  // Se declara esta variable final que obtendra siempre la ruta de los archivos dentro del directorio del programa
    private final String ruta = System.getProperties().getProperty("user.dir");
    
    // Variable de control para controlar el acceso al sistema
    boolean control = false;
    
    public GUIi_AccesoSistema() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cj_pass = new javax.swing.JPasswordField();
        cj_usuario = new javax.swing.JTextField();
        btn_entrar = new javax.swing.JButton();
        btn_entrar1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 255));
        setBounds(new java.awt.Rectangle(500, 200, 0, 0));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel1.setText("INGRESAR");

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel2.setText("Usuario:");

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel3.setText("Contraseña:");

        cj_pass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cj_passKeyTyped(evt);
            }
        });

        cj_usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cj_usuarioActionPerformed(evt);
            }
        });
        cj_usuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cj_usuarioKeyTyped(evt);
            }
        });

        btn_entrar.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btn_entrar.setText("Salir");
        btn_entrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_entrarActionPerformed(evt);
            }
        });

        btn_entrar1.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btn_entrar1.setText("Entrar");
        btn_entrar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_entrar1ActionPerformed(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/usuario.png"))); // NOI18N

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/password.png"))); // NOI18N

        jLabel6.setText("Tarea 2 - Maximiliano Ariel Frias Vozzi");

        jLabel7.setText("Profesor: Ing. Marco Patricio Abad Espinoza");

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Universidad_Técnica_Particular_de_Loja.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(72, 72, 72)
                        .addComponent(btn_entrar1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_entrar, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cj_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cj_pass, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5))
                            .addComponent(jLabel8)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cj_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(cj_pass, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(184, 184, 184)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_entrar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_entrar1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cj_passKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cj_passKeyTyped
 
    }//GEN-LAST:event_cj_passKeyTyped

    private void cj_usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cj_usuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cj_usuarioActionPerformed

    private void cj_usuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cj_usuarioKeyTyped
        // TODO add your handling code here:
        int c = evt.getKeyChar();
        if ( c == 10 )
        {
            cj_pass.requestFocus();
        }
    }//GEN-LAST:event_cj_usuarioKeyTyped

    private void btn_entrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_entrarActionPerformed
        
         System.exit(0);

    }//GEN-LAST:event_btn_entrarActionPerformed

    private void btn_entrar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_entrar1ActionPerformed
        
     //Comprobamos si las credenciales de usuario y password estan correctas contral el archivo usuario.txt
        
        String Usuario = cj_usuario.getText().trim();
        String Password = new String(cj_pass.getPassword());

           try {
            
            FileReader fr = new FileReader(ruta+"\\src\\proyect_persistencia\\usuario.txt");
            BufferedReader br = new BufferedReader(fr);

           Object [] tablas = br.lines().toArray();
           
           // Recorremos mediante un for el archivo usuario.txt para ver cada datos y validar
               for (int i = 0; i < tablas.length; i++) 
               
              {
                   String line = tablas[i].toString().trim();
                   String [] datosFilas = line.split(",");
               
            // En la posicion 3 del array esta el usuario y en la pos 4 el password
                   if(datosFilas[3].equals(Usuario) && datosFilas[4].equals(Password) )
              {
            // Si enncuetra un Usuario existente y coinciden las credenciales, da acceso a las ventas.
                   GUI_Principal formulario = new GUI_Principal();
                   formulario.setVisible(true);
            // cambiamos el valor del control para indicar que el usuario fue encontrado
                   control = true;
                   this.dispose();
               }
              } // fin bucle for
               
            // Si control sigue en estado FALSE, termina el bucle e indica que el usuario no se encuentra
                if(control == false){
                          JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrecta. Intente nuevamente.");
                          
                          cj_usuario.setText("");
                          cj_pass.setText("");
               } 
               
            try {
                fr.close();
            } catch (IOException ex) {
                Logger.getLogger(GUIi_AccesoSistema.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(GUIi_AccesoSistema.class.getName()).log(Level.SEVERE, null, ex);
            }

          } catch (FileNotFoundException e) {
              
          } catch (IOException ex) {
            Logger.getLogger(GUIi_AccesoSistema.class.getName()).log(Level.SEVERE, null, ex);
        }

      /**  
        String usuario = cj_usuario.getText().trim();
        String contraseña = new String(cj_pass.getPassword());
        if( usuario.equalsIgnoreCase(user) && contraseña.equalsIgnoreCase(pass) )
        {
            GUI_Principal b = new GUI_Principal();
            b.setVisible(true);
            dispose();
        }
        else if( usuario.isEmpty() && contraseña.isEmpty() )
        {
            JOptionPane.showMessageDialog(null, "Ingrese Usuario y Contraseña");
        }
        else if( usuario != user && contraseña != pass )
        {
            JOptionPane.showMessageDialog(null, "Usuario y Contraseña Incorrectos", "Error Al Ingresar", JOptionPane.ERROR_MESSAGE);
        }
        else if( usuario != user )
        {
            JOptionPane.showMessageDialog(null, "Usuario Incorrecto", "Usuario No Existe", JOptionPane.ERROR_MESSAGE);
        }
        else if( contraseña != pass )
        {
            JOptionPane.showMessageDialog(null, "Contraseña Incorrecta", "Contraseña Mal Escrita", JOptionPane.ERROR_MESSAGE);
        }
        */
        
        
    }//GEN-LAST:event_btn_entrar1ActionPerformed

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
            java.util.logging.Logger.getLogger(GUIi_AccesoSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIi_AccesoSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIi_AccesoSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIi_AccesoSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUIi_AccesoSistema().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_entrar;
    private javax.swing.JButton btn_entrar1;
    private javax.swing.JPasswordField cj_pass;
    private javax.swing.JTextField cj_usuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    // End of variables declaration//GEN-END:variables
}
