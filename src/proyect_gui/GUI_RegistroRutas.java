package proyect_gui;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import proyect_clases.Rutas;
import proyect_metodos.MetodoRutas;

public class GUI_RegistroRutas extends javax.swing.JFrame {

     // Se declara esta variable final que obtendra siempre la ruta de los archivos dentro del directorio del programa
    private final String ruta = System.getProperties().getProperty("user.dir");
    
    Rutas unaRuta = new Rutas();
    MetodoRutas metodos = new MetodoRutas();
    DefaultTableModel mdlTablaR;
    Vector vCabeceras = new Vector();
    
    public GUI_RegistroRutas() throws IOException {
        
        initComponents();
        GenerarCodigoRuta();
        
        btn_r_actializar.setEnabled(false);
        btn_r_guardar.setEnabled(true);
        btn_r_eliminar.setEnabled(false);
        
        txt_r_id.setEditable(false);
        txt_r_id.setBackground(Color.yellow);
        
        vCabeceras.addElement("ID");
        vCabeceras.addElement("RUTA");
        vCabeceras.addElement("ORIGEN");
        vCabeceras.addElement("DESTINO");
        vCabeceras.addElement("COSTO");
        vCabeceras.addElement("HORA");
        vCabeceras.addElement("FECHA");
        
        mdlTablaR = new DefaultTableModel(vCabeceras,0);
        table_rutas.setModel(mdlTablaR);
        table_rutas.setModel(metodos.listaRutas());
    }
    
     // Este metodo genera en forma automatica un Id diferente y consecuitivo para cada venta de boleto.
    // Cada Id nuevo generado sera el numero siguiente al ultimo Id generado en la venta anterior.
    // Los ID son únicos, irrepetibles y no pueden ser editados. Son los identificadores de cada venta
    public final void GenerarCodigoRuta() throws FileNotFoundException{

        txt_r_id.setText("1");
        String ultimoCodigo="0";
        int nuevoCodigo=0;
        
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        
           try {
            archivo = new File(ruta+"\\src\\proyect_persistencia\\ruta.txt");
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
                    txt_r_id.setText(String.valueOf(nuevoCodigo+1));
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
    
    // Este metodo utiliza EL NOMBRE DE LA RUTA
    public DefaultTableModel BuscarRuta (String buscar) throws IOException{

        if(buscar.length() == 00){
            JOptionPane.showMessageDialog(null, "Debe ingresar un RUTA del tipo CUE-QUI para su búsqueda.");
        }else{
            
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        
        mdlTablaR = new DefaultTableModel(vCabeceras,0);
        table_rutas.setModel(mdlTablaR);

           try {
            archivo = new File(ruta+"\\src\\proyect_persistencia\\ruta.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
           Object [] tablas = br.lines().toArray();
           
               for (int i = 0; i < tablas.length; i++) {
                   String line = tablas[i].toString().trim();
                   String [] datosFilas = line.split(",");
                   if(datosFilas[1].equalsIgnoreCase(buscar))
                   {
                mdlTablaR.addRow(datosFilas);
                   }
               }
              fr.close();
              br.close();
             } catch (FileNotFoundException e) {
                 JOptionPane.showMessageDialog(null, "Error. Intente nuevamente"); 
           }
         }
        return null;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table_rutas = new javax.swing.JTable();
        btn_r_salir = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_r_nombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_r_id = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_r_origen = new javax.swing.JTextField();
        txt_r_destino = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_r_fecha = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_r_hora = new javax.swing.JTextField();
        txt_r_costo = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txt_r_buscar = new javax.swing.JTextField();
        btn_r_guardar1 = new javax.swing.JButton();
        btn_r_listar = new javax.swing.JButton();
        btn_r_nuevo = new javax.swing.JButton();
        btn_r_guardar = new javax.swing.JButton();
        btn_r_eliminar = new javax.swing.JButton();
        btn_r_actializar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Modulo De Rutas");
        setBackground(new java.awt.Color(204, 204, 204));

        table_rutas.setBackground(new java.awt.Color(204, 255, 204));
        table_rutas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        table_rutas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_rutasMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                table_rutasMouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(table_rutas);

        btn_r_salir.setText("Salir");
        btn_r_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_r_salirActionPerformed(evt);
            }
        });

        jLabel9.setText("Hora");

        jLabel1.setText("ID");

        jLabel3.setText("Costo Ruta");

        jLabel4.setText("Ruta");

        jLabel5.setText("Origen");

        jLabel2.setText("Destino");

        jLabel10.setText("Fecha");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ruta.png"))); // NOI18N
        jLabel6.setText("DATOS DE LA RUTA:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txt_r_hora, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_r_origen, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_r_id, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2)
                            .addComponent(txt_r_nombre, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(jLabel4)
                            .addComponent(txt_r_destino))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel10)
                            .addComponent(txt_r_fecha)
                            .addComponent(jLabel3)
                            .addComponent(txt_r_costo, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_r_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_r_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_r_costo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel2)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_r_origen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_r_destino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_r_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_r_hora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("BUSQUEDA DE LA RUTA:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Ingrese una ruta a buscar:");

        btn_r_guardar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/seaarch.png"))); // NOI18N
        btn_r_guardar1.setText("BUSCAR UNA RUTA");
        btn_r_guardar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_r_guardar1ActionPerformed(evt);
            }
        });

        btn_r_listar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ruta.png"))); // NOI18N
        btn_r_listar.setText("LISTAR TODAS LAS RUTAS");
        btn_r_listar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_r_listarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btn_r_guardar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_r_buscar, javax.swing.GroupLayout.Alignment.LEADING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(btn_r_listar))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_r_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_r_guardar1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_r_listar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 21, Short.MAX_VALUE))
        );

        btn_r_nuevo.setText("Nuevo");
        btn_r_nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_r_nuevoActionPerformed(evt);
            }
        });

        btn_r_guardar.setText("Guardar");
        btn_r_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_r_guardarActionPerformed(evt);
            }
        });

        btn_r_eliminar.setText("Elminar");
        btn_r_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_r_eliminarActionPerformed(evt);
            }
        });

        btn_r_actializar.setText("Actualizar");
        btn_r_actializar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_r_actializarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_r_actializar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                            .addComponent(btn_r_guardar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_r_nuevo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(140, 140, 140)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_r_eliminar, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                            .addComponent(btn_r_salir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(52, 52, 52))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(btn_r_nuevo)
                        .addGap(27, 27, 27)
                        .addComponent(btn_r_guardar)
                        .addGap(33, 33, 33)
                        .addComponent(btn_r_actializar))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_r_eliminar)
                        .addGap(34, 34, 34)
                        .addComponent(btn_r_salir)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_r_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_r_guardarActionPerformed
        
                // Primero validamos cada una de la entradas

                        if (txt_r_id.getText().length() == 0) {

                        JOptionPane.showMessageDialog(rootPane, "Debe ingresar un número de ID");
                        txt_r_id.requestFocus();
                        return;
                    }
                    
                       if (txt_r_nombre.getText().length() == 0) {

                        JOptionPane.showMessageDialog(rootPane, "Debe ingresar un nombre");
                        txt_r_nombre.requestFocus();
                        return;
                    }
                      
                        if (txt_r_costo.getText().length() == 0) {

                        JOptionPane.showMessageDialog(rootPane, "Debe ingresar un Costo");
                        txt_r_costo.requestFocus();
                        return;
                    }
                        
                         if (txt_r_origen.getText().length() == 0) {

                        JOptionPane.showMessageDialog(rootPane, "Debe ingresar un Origen");
                        txt_r_origen.requestFocus();
                        return;
                    }
                          
                         if (txt_r_destino.getText().length() == 0) {

                        JOptionPane.showMessageDialog(rootPane, "Debe ingresar un Destino");
                        txt_r_destino.requestFocus();
                        return;
                    }
                            
                        if (txt_r_fecha.getText().length() == 0) {

                        JOptionPane.showMessageDialog(rootPane, "Debe ingresar una Fecha");
                        txt_r_fecha.requestFocus();
                        return;
                    }
                           
                        if (txt_r_hora.getText().length() == 0) {

                        JOptionPane.showMessageDialog(rootPane, "Debe ingresar una hora");
                        txt_r_hora.requestFocus();
                        return;
                    }
                     

        // Guarda todos los datos en la tabla:

        mdlTablaR = new DefaultTableModel();

        int id_r = Integer.parseInt(txt_r_id.getText());
        
        String nombre_r = txt_r_nombre.getText();
        String origen_r = txt_r_origen.getText();
        String destino_r = txt_r_destino.getText();
        String costo_r = txt_r_costo.getText();
        String hora_r = txt_r_hora.getText();
        String fecha_r = txt_r_fecha.getText();
        
        unaRuta.setId_Ruta(id_r);
        unaRuta.setNombre_Ruta(nombre_r);
        unaRuta.setOrigen_Ruta(origen_r);
        unaRuta.setDestino_Ruta(destino_r);
        unaRuta.setCosto_Ruta(costo_r);
        unaRuta.setHora_Ruta(hora_r);
        unaRuta.setFecha_Ruta(fecha_r);
        metodos.guardarRutas(unaRuta);
        try {
            metodos.guardarArchivoRutas(unaRuta);
        } catch (IOException ex) {
            Logger.getLogger(GUI_RegistroRutas.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            table_rutas.setModel(metodos.listaRutas());
        } catch (IOException ex) {
            Logger.getLogger(GUI_RegistroRutas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
          // Limpia los Jtext:
        txt_r_nombre.setText("");
        txt_r_origen.setText("");
        txt_r_destino.setText("");
        txt_r_costo.setText("");
        txt_r_hora.setText("");
        txt_r_fecha.setText("");
        
        // Colocamos el programa para guardar una nueva ruta, luego de registrar una ruta
          try {
            GenerarCodigoRuta();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GUI_RegistroRutas.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btn_r_guardarActionPerformed

    private void btn_r_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_r_salirActionPerformed
        // TODO add your handling code here:
        GUI_Principal b = new GUI_Principal();
        b.setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_r_salirActionPerformed

    private void btn_r_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_r_nuevoActionPerformed
        
        btn_r_actializar.setEnabled(false);
        btn_r_guardar.setEnabled(true);
        btn_r_eliminar.setEnabled(false);
        
          // Limpia los Jtext:
        txt_r_nombre.setText("");
        txt_r_origen.setText("");
        txt_r_destino.setText("");
        txt_r_costo.setText("");
        txt_r_hora.setText("");
        txt_r_fecha.setText("");
        
        try {
            GenerarCodigoRuta();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GUI_RegistroRutas.class.getName()).log(Level.SEVERE, null, ex);
        }

      
    }//GEN-LAST:event_btn_r_nuevoActionPerformed

    private void btn_r_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_r_eliminarActionPerformed
        // Boton eliminar rutas en tabla:
    
       //Confirmamos si deseamos eliminar o no, por seguridad
        int opcion = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar la RUTA del sistema?");
        if(opcion == JOptionPane.YES_OPTION){  
        
        String Id = txt_r_id.getText();
        String Costo = txt_r_costo.getText();
        String Ruta = txt_r_nombre.getText();
        String Origen = txt_r_origen.getText();
        String Destino = txt_r_destino.getText();
        String Fecha = txt_r_fecha.getText();
        String Hora = txt_r_hora.getText();
        
        //Pasamos al metodo los valores de las variables para procesar en el metodo
        metodos.EliminarRuta(Id, Costo, Ruta, Origen, Destino, Fecha, Hora);
        
        // limipiamos los text
        txt_r_costo.setText("");
        txt_r_nombre.setText("");
        txt_r_origen.setText("");
        txt_r_destino.setText("");
        txt_r_fecha.setText("");
        txt_r_hora.setText("");
        
            try {
                // volvemos a leer los datos de la tabla
                table_rutas.setModel(metodos.listaRutas());
            } catch (IOException ex) {
                Logger.getLogger(GUI_RegistroRutas.class.getName()).log(Level.SEVERE, null, ex);
            }

        // Colocamos el programa para guardar una nueva ruta, luego de registrar una ruta
          try {
            GenerarCodigoRuta();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GUI_RegistroRutas.class.getName()).log(Level.SEVERE, null, ex);
        }
        }   
        
        
    }//GEN-LAST:event_btn_r_eliminarActionPerformed

    private void btn_r_actializarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_r_actializarActionPerformed
        // Carga los datos del archivo de texto con la base de datos de pasajeros:
        
         //Confirmamos si deseamos eliminar o no, por seguridad
        int opcion = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar la RUTA del sistema?");
        if(opcion == JOptionPane.YES_OPTION){  
        
        String Id = txt_r_id.getText();
        String Ruta = txt_r_nombre.getText();
        String Origen = txt_r_origen.getText();
        String Destino = txt_r_destino.getText();
        String Costo = txt_r_costo.getText();
        String Hora = txt_r_hora.getText();
        String Fecha = txt_r_fecha.getText();
        
         //Pasamos al metodo los valores de las variables para procesar en el metodo
        metodos.EditarRutas(Id, Ruta, Origen, Destino, Costo, Hora, Fecha);
        
         // limipiamos los text
      
        txt_r_nombre.setText("");
        txt_r_origen.setText("");
        txt_r_destino.setText("");
        txt_r_costo.setText("");
        txt_r_hora.setText("");
        txt_r_fecha.setText("");
 
            try {
                // volvemos a leer los datos de la tabla
                table_rutas.setModel(metodos.listaRutas());
            } catch (IOException ex) {
                Logger.getLogger(GUI_RegistroRutas.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        // Colocamos el programa para guardar una nueva ruta, luego de registrar una ruta
          try {
            GenerarCodigoRuta();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GUI_RegistroRutas.class.getName()).log(Level.SEVERE, null, ex);
        }
          
        btn_r_nuevo.setEnabled(true);
        btn_r_guardar.setEnabled(true);
        btn_r_actializar.setEnabled(false);
    }//GEN-LAST:event_btn_r_actializarActionPerformed
   }
    
    private void table_rutasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_rutasMouseClicked
 

        btn_r_eliminar.setEnabled(true);
        btn_r_guardar.setEnabled(false);
        btn_r_actializar.setEnabled(true);
        btn_r_actializar.setText("Guardar Cambios");
        
        
        int fila = table_rutas.rowAtPoint(evt.getPoint()); // guardamos en fila el valor que hacemos click en la fila seleccionada

        txt_r_id.setText(table_rutas.getValueAt(fila, 0).toString());
        txt_r_nombre.setText(table_rutas.getValueAt(fila, 1).toString());
        txt_r_origen.setText(table_rutas.getValueAt(fila, 2).toString());
        txt_r_destino.setText(table_rutas.getValueAt(fila, 3).toString());
        txt_r_costo.setText(table_rutas.getValueAt(fila, 4).toString());
        txt_r_hora.setText(table_rutas.getValueAt(fila, 5).toString());
        txt_r_fecha.setText(table_rutas.getValueAt(fila, 6).toString());
 
    }//GEN-LAST:event_table_rutasMouseClicked

    private void table_rutasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_rutasMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_table_rutasMouseEntered

    private void btn_r_guardar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_r_guardar1ActionPerformed

        String busqueda = txt_r_buscar.getText();
        try {   
            BuscarRuta(busqueda);
        } catch (IOException e) {
           JOptionPane.showMessageDialog(null, "No existe ninguna RUTA con el nombre ingresado. Intente con otro número.");
           txt_r_buscar.setText("");
           txt_r_buscar.requestFocus();
        }
    }//GEN-LAST:event_btn_r_guardar1ActionPerformed

    private void btn_r_listarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_r_listarActionPerformed
        
        try {
            table_rutas.setModel(metodos.listaRutas());
        } catch (IOException ex) {
            Logger.getLogger(GUI_RegistroRutas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_r_listarActionPerformed

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
            java.util.logging.Logger.getLogger(GUI_RegistroRutas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_RegistroRutas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_RegistroRutas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_RegistroRutas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new GUI_RegistroRutas().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(GUI_RegistroRutas.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_r_actializar;
    private javax.swing.JButton btn_r_eliminar;
    private javax.swing.JButton btn_r_guardar;
    private javax.swing.JButton btn_r_guardar1;
    private javax.swing.JButton btn_r_listar;
    private javax.swing.JButton btn_r_nuevo;
    private javax.swing.JButton btn_r_salir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table_rutas;
    private javax.swing.JTextField txt_r_buscar;
    private javax.swing.JTextField txt_r_costo;
    private javax.swing.JTextField txt_r_destino;
    private javax.swing.JTextField txt_r_fecha;
    private javax.swing.JTextField txt_r_hora;
    private javax.swing.JTextField txt_r_id;
    private javax.swing.JTextField txt_r_nombre;
    private javax.swing.JTextField txt_r_origen;
    // End of variables declaration//GEN-END:variables
}
