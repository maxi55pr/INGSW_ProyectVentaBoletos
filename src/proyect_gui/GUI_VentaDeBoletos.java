package proyect_gui;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import proyect_clases.Boleto;
import proyect_clases.Pasajero;
import proyect_clases.Rutas;
import proyect_metodos.MetodoBoleto;
import proyect_metodos.MetodoPasajero;
import proyect_metodos.MetodoRutas;


public class GUI_VentaDeBoletos extends javax.swing.JFrame {
    
    Boleto boleto = new Boleto();
    Pasajero pasajero = new Pasajero();
    Rutas ruta = new Rutas ();
    MetodoPasajero buscarP = new MetodoPasajero();
    MetodoRutas buscarR = new MetodoRutas();
    MetodoBoleto metodos = new MetodoBoleto();
    public static String busqueda;
    public DefaultTableModel mdlTablaBoletos;
    Vector vCabeceras = new Vector();

    public GUI_VentaDeBoletos() throws IOException {
        initComponents();
        
        GenerarCodigoReserva();
        txt_venta_total.setEditable(false);
        txt_IdCompra.setEditable(false);
        txt_IdCompra.setBackground(Color.ORANGE);
        txt_venta_total.setBackground(Color.YELLOW);
        
        vCabeceras.addElement("ID BOLETO");
        vCabeceras.addElement("NOMBRE");
        vCabeceras.addElement("APELLIDO");
        vCabeceras.addElement("CEDULA");
        vCabeceras.addElement("EDAD");
        vCabeceras.addElement("CATEGORIA");
        vCabeceras.addElement("RUTA");
        vCabeceras.addElement("FECHA");
        vCabeceras.addElement("HORA");
        vCabeceras.addElement("CANTIDAD");
        vCabeceras.addElement("COSTO");
        vCabeceras.addElement("DESCUENTO");
        vCabeceras.addElement("TOTAL");
        
        mdlTablaBoletos = new DefaultTableModel(vCabeceras,0);
        table_ventas_boletos.setModel(mdlTablaBoletos);
        table_ventas_boletos.setModel(metodos.listaBoleto());
         
    }
    // Este metodo genera en forma automatica un Id diferente y consecuitivo para cada venta de boleto.
    // Cada Id nuevo generado sera el numero siguiente al ultimo Id generado en la venta anterior.
    // Los ID son únicos, irrepetibles y no pueden ser editados. Son los identificadores de cada venta
    public final void GenerarCodigoReserva() throws FileNotFoundException{

        txt_IdCompra.setText("1");
        String ultimoCodigo="0";
        int nuevoCodigo=0;
        
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        
           try {
            archivo = new File(".\\boletos.txt");
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
                    txt_IdCompra.setText(String.valueOf(nuevoCodigo+1));
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

       // Este metodo utiliza la CEDULA
    public DefaultTableModel BuscarBoleto (String buscar) throws IOException{

        if(buscar.length() == 00){
            JOptionPane.showMessageDialog(null, "Debe ingresar una CEDULA de Pasajero para su búsqueda.");
        }else{
            
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        
        mdlTablaBoletos = new DefaultTableModel(vCabeceras,0);
        table_ventas_boletos.setModel(mdlTablaBoletos);

           try {
            archivo = new File(".\\boletos.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
           Object [] tablas = br.lines().toArray();
           
               for (int i = 0; i < tablas.length; i++) {
                   String line = tablas[i].toString().trim();
                   String [] datosFilas = line.split(",");
                   if(datosFilas[3].equalsIgnoreCase(buscar))
                   {
                       
                mdlTablaBoletos.addRow(datosFilas);
   
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

        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_venta_busca_cedula = new javax.swing.JTextField();
        txt_venta_apellido = new javax.swing.JTextField();
        txt_venta_edad = new javax.swing.JTextField();
        txt_venta_tipoPasajero = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_venta_nombre = new javax.swing.JTextField();
        btn_buscarr_pasajero = new javax.swing.JButton();
        txt_venta_cedula = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txt_IdCompra = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        txt_busca_ruta = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_venta_costo = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txt_venta_fecha = new javax.swing.JTextField();
        txt_venta_hora = new javax.swing.JTextField();
        btn_buscar_ruta = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txt_venta_numboleto = new javax.swing.JTextField();
        txt_venta_descuento = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txt_venta_total = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        btn_calcular_ruta = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_ventas_boletos = new javax.swing.JTable();
        txt_buscarBoleto = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        btn_buscarBoleto = new javax.swing.JButton();
        btn_ventas_nuevo = new javax.swing.JButton();
        btn_p_guardar = new javax.swing.JButton();
        btn_p_editar = new javax.swing.JButton();
        btn_p_eliminar = new javax.swing.JButton();
        btn_p_salir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("DATOS DE PASAJERO :");

        jLabel3.setText("Buscar Cedula:");

        txt_venta_apellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_venta_apellidoActionPerformed(evt);
            }
        });

        jLabel1.setText("Nombre Pasajero:");

        jLabel2.setText("Apellido Pasajero:");

        jLabel4.setText("Edad Pasajero:");

        jLabel5.setText("Categoria  Pasajero:");

        btn_buscarr_pasajero.setText("Buscar");
        btn_buscarr_pasajero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarr_pasajeroActionPerformed(evt);
            }
        });

        jLabel16.setText("Cédula Pasajero:");

        jLabel18.setText("ID COMPRA");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(txt_venta_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(txt_venta_apellido, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_venta_edad, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel16)
                                    .addComponent(txt_venta_cedula, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(txt_venta_tipoPasajero, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(txt_venta_busca_cedula, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_IdCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(181, 181, 181)
                        .addComponent(btn_buscarr_pasajero, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel18))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_venta_busca_cedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_IdCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2)
                        .addComponent(jLabel4)
                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_venta_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_venta_apellido, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_venta_edad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_venta_tipoPasajero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_venta_cedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(btn_buscarr_pasajero)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel7.setText("Buscar Ruta:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("DATOS DE RUTA :");

        jLabel9.setText("Costo de Ruta");

        jLabel10.setText("Fecha de viaje");

        jLabel11.setText("Hora de viaje");

        btn_buscar_ruta.setText("Buscar");
        btn_buscar_ruta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscar_rutaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_venta_costo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(txt_venta_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_buscar_ruta, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(58, 58, 58)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel11)
                            .addComponent(txt_venta_hora, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(29, 29, 29)
                                .addComponent(txt_busca_ruta, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txt_busca_ruta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txt_venta_hora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_venta_costo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txt_venta_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btn_buscar_ruta)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel12.setText("Numero de boletos");

        jLabel13.setText("Descuento");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("BOLETOS :");

        txt_venta_total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_venta_totalActionPerformed(evt);
            }
        });

        jLabel15.setText("Total a Pagar");

        btn_calcular_ruta.setText("Calcular");
        btn_calcular_ruta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_calcular_rutaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(txt_venta_numboleto, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(txt_venta_total, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(51, 51, 51))))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(175, 175, 175)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_venta_descuento, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_calcular_ruta, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addContainerGap(208, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel15)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txt_venta_total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_venta_numboleto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_venta_descuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btn_calcular_ruta)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 463, Short.MAX_VALUE)
        );

        table_ventas_boletos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        table_ventas_boletos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_ventas_boletosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                table_ventas_boletosMouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(table_ventas_boletos);

        txt_buscarBoleto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_buscarBoletoActionPerformed(evt);
            }
        });

        jLabel17.setText("BUSCAR BOLETO POR CEDULA DE PASAJERO");

        btn_buscarBoleto.setText("BUSCAR");
        btn_buscarBoleto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarBoletoActionPerformed(evt);
            }
        });

        btn_ventas_nuevo.setText("Nuevo");
        btn_ventas_nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ventas_nuevoActionPerformed(evt);
            }
        });

        btn_p_guardar.setText("Guardar");
        btn_p_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_p_guardarActionPerformed(evt);
            }
        });

        btn_p_editar.setText("Editar");
        btn_p_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_p_editarActionPerformed(evt);
            }
        });

        btn_p_eliminar.setText("Eliminar");
        btn_p_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_p_eliminarActionPerformed(evt);
            }
        });

        btn_p_salir.setText("Salir");
        btn_p_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_p_salirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 967, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(71, 71, 71)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_buscarBoleto)))
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_p_salir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_ventas_nuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_buscarBoleto, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(btn_p_editar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_p_eliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_p_guardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 11, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel17)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_buscarBoleto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_buscarBoleto))
                        .addGap(268, 268, 268))))
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(btn_ventas_nuevo)
                .addGap(18, 18, 18)
                .addComponent(btn_p_guardar)
                .addGap(34, 34, 34)
                .addComponent(btn_p_editar)
                .addGap(18, 18, 18)
                .addComponent(btn_p_eliminar)
                .addGap(18, 18, 18)
                .addComponent(btn_p_salir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_p_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_p_salirActionPerformed
        // TODO add your handling code here:
        GUI_Principal b = new GUI_Principal();
        b.setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_p_salirActionPerformed

    private void btn_ventas_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ventas_nuevoActionPerformed
      
      // Activamos el boton de guardar
        
        btn_p_guardar.setEnabled(true);
        
        // Desactivamos el boton Editar mientras estamos en modo NUEVO
        
        btn_p_editar.setEnabled(false);
        
         // Desactivamos el boton Eliminar mientras estamos en modo NUEVO
        
        btn_p_eliminar.setEnabled(false);        
       
        
        // Limpia los Jtext:
        
        txt_venta_busca_cedula.setText("");
        txt_venta_nombre.setText("");
        txt_venta_apellido.setText("");
        txt_venta_cedula.setText("");
        txt_venta_edad.setText("");
        txt_venta_tipoPasajero.setText("");
        txt_busca_ruta.setText("");
        txt_venta_costo.setText("");
        txt_venta_fecha.setText("");
        txt_venta_hora.setText("");
        txt_venta_numboleto.setText("");
        txt_venta_descuento.setText("");
        txt_venta_total.setText("");
        txt_buscarBoleto.setText("");

    }//GEN-LAST:event_btn_ventas_nuevoActionPerformed

    private void btn_p_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_p_editarActionPerformed
        // Boton editar boletos de compra en tabla:
        
         // Mediante variables y lectura de arreglos, tomamos los valores
        // de los TextField los ingresamos en el archivo TXT en la posicion 
        // que la logica siguiente entiende que es la correcta y actualiza el txt en el momento.
        
        //  Este algoritmo utilza un array temporal para escribir los datos
            String IdCompra = txt_IdCompra.getText();
            String Nombre = txt_venta_nombre.getText();
            String Apellido = txt_venta_apellido.getText();
            int Cedula = Integer.parseInt(txt_venta_cedula.getText());
            int Edad = Integer.parseInt(txt_venta_edad.getText());
            String Categoria = txt_venta_tipoPasajero.getText();
            String Ruta = txt_busca_ruta.getText();
            String ventaFecha = txt_venta_fecha.getText();
            String ventaHora = txt_venta_hora.getText();
            int ventaCantidadBoleto = Integer.parseInt(txt_venta_numboleto.getText());
            Double ventaCosto = Double.parseDouble(txt_venta_costo.getText());
            Double ventaDescuento = Double.parseDouble(txt_venta_descuento.getText());
            Double ventaTotal = Double.parseDouble(txt_venta_total.getText());

        ArrayList<String> tempArray = new ArrayList<>();
        
        try {
            try (FileReader fr = new FileReader(".\\boletos.txt"))
            {
                Scanner reader = new Scanner(fr);
                String linea;
                String [] lineaArray;
                
                while((linea=reader.nextLine())!=null){
                    
            // Se toma el ID para lograr validar dado que al hacer clicik 
            // ese Empleado será el que entienda el sistema que debe actualizar
            
                lineaArray = linea.split(",");
                if(lineaArray[0].equals(IdCompra)){
                    
           // Recorro y agrego en la fila que el sistema entiende que existe el ID
                    tempArray.add(
                            
                            IdCompra + "," +
                            Nombre + "," +
                            Apellido + "," +
                            Cedula + "," +
                            Edad + "," +
                            Categoria+ "," +
                            Ruta + "," +
                            ventaFecha + "," +
                            ventaHora + "," +
                            ventaCantidadBoleto + "," +
                            ventaCosto + "," +
                            ventaDescuento + "," +
                            ventaTotal);
                }else{
            // Si no encuentra cambios, el array temporal será el mismo que el original
                    tempArray.add(linea);
                }
            }
                fr.close();

              } catch (Exception e) {
            }
          } catch (Exception e) {
        }
        // Aqui se guardan los datos del array temporal, ya modificados, en el array original
        try {
            try(PrintWriter pr = new PrintWriter(".\\boletos.txt"))
                
            {
                for(String str:tempArray) {
                    pr.println(str);
                }
                pr.close();
                metodos.listaBoleto();
            } catch (Exception e) {
            }
        } catch (Exception e) {
        }
 
       
        

      
    }//GEN-LAST:event_btn_p_editarActionPerformed

    private void btn_buscarr_pasajeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarr_pasajeroActionPerformed
        
        Vector v = new Vector();
        String cedula = txt_venta_busca_cedula.getText();
        
        try {
            
        v = buscarP.BuscarPasajero(cedula);
        
        txt_venta_nombre.setText((String) v.elementAt(1));
        txt_venta_apellido.setText((String) v.elementAt(2));
        txt_venta_cedula.setText((String) v.elementAt(3));
        txt_venta_edad.setText((String) v.elementAt(4));
        txt_venta_tipoPasajero.setText((String) v.elementAt(5)); 
        
        } catch (Exception e) {
           JOptionPane.showMessageDialog(null, "No existe ningún pasajero registrado con el numero de cédula ingresado. Intente con otro número.");
           txt_venta_busca_cedula.setText("");
           txt_venta_busca_cedula.requestFocus();
        }
       
    }//GEN-LAST:event_btn_buscarr_pasajeroActionPerformed

    private void btn_p_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_p_guardarActionPerformed
        // TODO add your handling code here:
        
        // Primero validamos cada una de la entradas

                        if (txt_venta_busca_cedula.getText().length() == 0) {
                        JOptionPane.showMessageDialog(rootPane, "Debe ingresar una Cedula de Pasajero");
                        txt_venta_busca_cedula.requestFocus();
                        return;
                    }
                       if (txt_busca_ruta.getText().length() == 0) {
                        JOptionPane.showMessageDialog(rootPane, "Debe ingresar una Ruta para su compra");
                        txt_busca_ruta.requestFocus();
                        return;
                    }
                       
            mdlTablaBoletos = new DefaultTableModel();
            
            int IdCompra = Integer.parseInt(txt_IdCompra.getText());
            String Nombre = txt_venta_nombre.getText();
            String Apellido = txt_venta_apellido.getText();
            int Cedula = Integer.parseInt(txt_venta_cedula.getText());
            int Edad = Integer.parseInt(txt_venta_edad.getText());
            String Categoria = txt_venta_tipoPasajero.getText();
            String Ruta = txt_busca_ruta.getText();
            String ventaFecha = txt_venta_fecha.getText();
            String ventaHora = txt_venta_hora.getText();
            int ventaCantidadBoleto = Integer.parseInt(txt_venta_numboleto.getText());
            Double ventaCosto = Double.parseDouble(txt_venta_costo.getText());
            Double ventaDescuento = Double.parseDouble(txt_venta_descuento.getText());
            Double ventaTotal = Double.parseDouble(txt_venta_total.getText());
            
            
      // Id de COMPRA
        boleto.setId_boleto(IdCompra);
        
     // Datos del pasajero
        pasajero.setNombre_pasajero(Nombre);
        pasajero.setApellido_pasajero(Apellido);
        pasajero.setCedula_pasajero(Cedula);
        pasajero.setEdad_pasajero(Edad);
        pasajero.setTipo_pasajero(Categoria);
        
     // Datos de la ruta
        ruta.setNombre_Ruta(Ruta);
       
     // Datos de venta del boleto
        
        boleto.setNumero_boleto(ventaCantidadBoleto);
        boleto.setFecha_boleto(ventaFecha);
        boleto.setHora_boleto(ventaHora);
        boleto.setCosto_boleto(ventaCosto);
        boleto.setDescuento(ventaDescuento);
        boleto.setCosto_total(ventaTotal);
        
     // Guardamos los datos de la compra del boleto
        metodos.guardarArchivoBoleto(pasajero, ruta, boleto);
     // Generamos el nuevo codigo de reserva unico para la siguiente compra
        try {
            GenerarCodigoReserva();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GUI_VentaDeBoletos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         // Limpia los Jtext:
         
        txt_venta_busca_cedula.setText("");
        txt_venta_nombre.setText("");
        txt_venta_apellido.setText("");
        txt_venta_cedula.setText("");
        txt_venta_edad.setText("");
        txt_venta_tipoPasajero.setText("");
        txt_busca_ruta.setText("");
        txt_venta_costo.setText("");
        txt_venta_fecha.setText("");
        txt_venta_hora.setText("");
        txt_venta_numboleto.setText("");
        txt_venta_descuento.setText("");
        txt_venta_total.setText("");

        
        try {
            table_ventas_boletos.setModel(metodos.listaBoleto());
        } catch (IOException ex) {
            Logger.getLogger(GUI_RegistroPasajeros.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btn_p_guardarActionPerformed

    private void txt_venta_apellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_venta_apellidoActionPerformed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_txt_venta_apellidoActionPerformed

    private void btn_buscar_rutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscar_rutaActionPerformed
        // TODO add your handling code here:
        
        Vector v = new Vector();
        String ruta = txt_busca_ruta.getText();
        try {
        v = buscarR.BuscarRuta(ruta);
        txt_venta_fecha.setText((String) v.elementAt(6));
        txt_venta_costo.setText((String) v.elementAt(4));
        txt_venta_hora.setText((String) v.elementAt (5));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No existe ninguna RUTA registrado con el nombre ingresado. Intente con otro nombre de RUTA del tipo CUE-ORO");
           txt_busca_ruta.setText("");
           txt_busca_ruta.requestFocus();
        }
        
        
    }//GEN-LAST:event_btn_buscar_rutaActionPerformed

    private void txt_venta_totalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_venta_totalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_venta_totalActionPerformed

    private void btn_calcular_rutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_calcular_rutaActionPerformed
        // TODO add your handling code here:
        
        Double str = 0.00;
        
        // Primero validamos cada una de las entradas
        
                     if (txt_venta_busca_cedula.getText().length() == 0) {

                        JOptionPane.showMessageDialog(rootPane, "Debe ingresar una cédula de PASAJERO para poder comprar");
                        txt_venta_busca_cedula.requestFocus();
                        return;
                    }
                    
                      if (txt_busca_ruta.getText().length() == 0) {

                        JOptionPane.showMessageDialog(rootPane, "Debe ingresar una RUTA para poder calcular costos de Boletos y Ruta.");
                        txt_busca_ruta.requestFocus();
                        return;
                    }

                    if (txt_venta_numboleto.getText().length() == 0) {

                        JOptionPane.showMessageDialog(rootPane, "Debe ingresar una CANTIDAD de BOLETOS a comprar");
                        txt_venta_numboleto.requestFocus();
                        return;
                    }
                    
                      if (txt_venta_descuento.getText().length() == 0) {

                        JOptionPane.showMessageDialog(rootPane, "Debe ingresar una cantidad de DESCUENTO.");
                        txt_venta_descuento.requestFocus();
                        return;
                    }
                      
                    try {
                        
                    int numBoletos = Integer.parseInt(txt_venta_numboleto.getText());
                    Double costoRuta = Double.parseDouble(txt_venta_costo.getText());
                    Double descuento = Double.parseDouble(txt_venta_descuento.getText());
                    Double total = (numBoletos*costoRuta)-descuento;
                    str = total;
                    txt_venta_total.setText(Double.toString(str));
                    
                    JOptionPane.showMessageDialog(rootPane, "SU COSTO TOTAL DEL PASAJE ES DE "+str +" dólares.");
                    
                    } catch (NumberFormatException e) {

                    JOptionPane.showMessageDialog(rootPane, "No es posible su compra. Intente nuevamente");
                        
                        txt_venta_busca_cedula.setText("");
                        txt_venta_nombre.setText("");
                        txt_venta_apellido.setText("");
                        txt_venta_edad.setText("");
                        txt_venta_tipoPasajero.setText("");
                        txt_busca_ruta.setText("");
                        txt_venta_costo.setText("");
                        txt_venta_fecha.setText("");
                        txt_venta_hora.setText("");
                        txt_venta_numboleto.setText("");
                        txt_venta_descuento.setText("");
                        txt_venta_total.setText("");
                        txt_venta_cedula.setText("");

                    }
        
    }//GEN-LAST:event_btn_calcular_rutaActionPerformed

    private void table_ventas_boletosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_ventas_boletosMouseClicked

        // Desactivamos el boton de guardar para habilitar solo la opcion EDITAR
        btn_p_guardar.setEnabled(false);
        // Activamos el boton de eliminar 
        btn_p_eliminar.setEnabled(true);
        // Activamos el boton de guardar cambios 
        btn_p_editar.setEnabled(true);
   
        // Cambiamos el valor del boton Editar a texto "Guardar Cambios" para aceptar todo cambio en la tabla
        btn_p_editar.setText("Guardar cambios");

        // guardamos en fila el valor que hacemos click en la fila seleccionada
        int fila = table_ventas_boletos.rowAtPoint(evt.getPoint());

        // Cargamos cada valor de la tabla en los JtextField
        
        vCabeceras.addElement("ID BOLETO");
        vCabeceras.addElement("NOMBRE");
        vCabeceras.addElement("APELLIDO");
        vCabeceras.addElement("CEDULA");
        vCabeceras.addElement("EDAD");
        vCabeceras.addElement("CATEGORIA");
        vCabeceras.addElement("RUTA");
        vCabeceras.addElement("FECHA");
        vCabeceras.addElement("HORA");
        vCabeceras.addElement("CANTIDAD");
        vCabeceras.addElement("COSTO");
        vCabeceras.addElement("DESCUENTO");
        vCabeceras.addElement("TOTAL");
        
        txt_IdCompra.setText(table_ventas_boletos.getValueAt(fila, 0).toString());
        txt_venta_nombre.setText(table_ventas_boletos.getValueAt(fila, 1).toString());
        txt_venta_apellido.setText(table_ventas_boletos.getValueAt(fila, 2).toString());
        txt_venta_cedula.setText(table_ventas_boletos.getValueAt(fila, 3).toString());
        txt_venta_busca_cedula.setText(table_ventas_boletos.getValueAt(fila, 3).toString());
        txt_venta_edad.setText(table_ventas_boletos.getValueAt(fila, 4).toString());
        txt_venta_tipoPasajero.setText(table_ventas_boletos.getValueAt(fila, 5).toString());
        txt_busca_ruta.setText(table_ventas_boletos.getValueAt(fila, 6).toString());
        txt_venta_fecha.setText(table_ventas_boletos.getValueAt(fila, 7).toString());
        txt_venta_hora.setText(table_ventas_boletos.getValueAt(fila, 8).toString());
        txt_venta_numboleto.setText(table_ventas_boletos.getValueAt(fila, 9).toString());
        txt_venta_costo.setText(table_ventas_boletos.getValueAt(fila, 10).toString());
        txt_venta_descuento.setText(table_ventas_boletos.getValueAt(fila, 11).toString());
        txt_venta_total.setText(table_ventas_boletos.getValueAt(fila, 12).toString());
    }//GEN-LAST:event_table_ventas_boletosMouseClicked

    private void txt_buscarBoletoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_buscarBoletoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_buscarBoletoActionPerformed

    private void btn_buscarBoletoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarBoletoActionPerformed

        //Limpiamos los Jtext
        txt_venta_busca_cedula.setText("");
        txt_venta_nombre.setText("");
        txt_venta_apellido.setText("");
        txt_venta_cedula.setText("");
        txt_venta_edad.setText("");
        txt_venta_tipoPasajero.setText("");
        txt_busca_ruta.setText("");
        txt_venta_costo.setText("");
        txt_venta_fecha.setText("");
        txt_venta_hora.setText("");
        txt_venta_numboleto.setText("");
        txt_venta_descuento.setText("");
        txt_venta_total.setText("");           

        // Se utiliza como parámetro de búsqueda el cammpo CEDULA de un pasajero 
           
        busqueda = txt_buscarBoleto.getText();

                try {
                     BuscarBoleto(busqueda);
                     
                 } catch (IOException ex) {
                     JOptionPane.showMessageDialog(rootPane, "Error. Intente nuevamente");
                     Logger.getLogger(GUI_VentaDeBoletos.class.getName()).log(Level.SEVERE, null, ex);
                }
    }//GEN-LAST:event_btn_buscarBoletoActionPerformed

    private void btn_p_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_p_eliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_p_eliminarActionPerformed

    private void table_ventas_boletosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_ventas_boletosMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_table_ventas_boletosMouseEntered

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
            java.util.logging.Logger.getLogger(GUI_VentaDeBoletos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_VentaDeBoletos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_VentaDeBoletos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_VentaDeBoletos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new GUI_VentaDeBoletos().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(GUI_VentaDeBoletos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_buscarBoleto;
    private javax.swing.JButton btn_buscar_ruta;
    private javax.swing.JButton btn_buscarr_pasajero;
    private javax.swing.JButton btn_calcular_ruta;
    private javax.swing.JButton btn_p_editar;
    private javax.swing.JButton btn_p_eliminar;
    private javax.swing.JButton btn_p_guardar;
    private javax.swing.JButton btn_p_salir;
    private javax.swing.JButton btn_ventas_nuevo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable table_ventas_boletos;
    private javax.swing.JTextField txt_IdCompra;
    private javax.swing.JTextField txt_busca_ruta;
    private javax.swing.JTextField txt_buscarBoleto;
    private javax.swing.JTextField txt_venta_apellido;
    private javax.swing.JTextField txt_venta_busca_cedula;
    private javax.swing.JTextField txt_venta_cedula;
    private javax.swing.JTextField txt_venta_costo;
    private javax.swing.JTextField txt_venta_descuento;
    private javax.swing.JTextField txt_venta_edad;
    private javax.swing.JTextField txt_venta_fecha;
    private javax.swing.JTextField txt_venta_hora;
    private javax.swing.JTextField txt_venta_nombre;
    private javax.swing.JTextField txt_venta_numboleto;
    private javax.swing.JTextField txt_venta_tipoPasajero;
    private javax.swing.JTextField txt_venta_total;
    // End of variables declaration//GEN-END:variables
}
