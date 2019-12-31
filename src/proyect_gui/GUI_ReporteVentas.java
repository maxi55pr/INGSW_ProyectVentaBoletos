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


public class GUI_ReporteVentas extends javax.swing.JFrame {
    
    Boleto boleto = new Boleto();
    Pasajero pasajero = new Pasajero();
    Rutas ruta = new Rutas ();
    MetodoPasajero buscarP = new MetodoPasajero();
    MetodoRutas buscarR = new MetodoRutas();
    MetodoBoleto metodos = new MetodoBoleto();
    public static String busqueda;
    public DefaultTableModel mdlTablaBoletos;
    Vector vCabeceras = new Vector();

    public GUI_ReporteVentas() throws IOException {
        initComponents();
        
        GenerarCodigoReserva();
        txt_venta_total.setEditable(false);
        txt_IdCompra.setEditable(false);
        txt_IdCompra.setBackground(Color.YELLOW);
        txt_venta_total.setBackground(Color.YELLOW);
        
        // Solo se visualizan los valores en reporte. No se pueden editar 
        txt_venta_nombre.setBackground(Color.CYAN);
        txt_venta_apellido.setBackground(Color.CYAN);
        txt_venta_cedula.setBackground(Color.CYAN);
        txt_venta_edad.setBackground(Color.CYAN);
        txt_venta_tipoPasajero.setBackground(Color.CYAN);
        txt_venta_fecha.setBackground(Color.CYAN);
        txt_venta_hora.setBackground(Color.CYAN);
        txt_venta_numboleto.setBackground(Color.CYAN);
        txt_venta_costo.setBackground(Color.CYAN);
        txt_venta_descuento.setBackground(Color.CYAN);
        txt_venta_total.setBackground(Color.CYAN);
        
        // Modificamos el color de fondo para los reportes
        
        txt_IdCompra.setEditable(false);
        txt_venta_nombre.setEditable(false);
        txt_venta_apellido.setEditable(false);
        txt_venta_cedula.setEditable(false);
        txt_venta_edad.setEditable(false);
        txt_venta_tipoPasajero.setEditable(false);
        txt_venta_fecha.setEditable(false);
        txt_venta_hora.setEditable(false);
        txt_venta_numboleto.setEditable(false);
        txt_venta_costo.setEditable(false);
        txt_venta_descuento.setEditable(false);
        txt_venta_total.setEditable(false);
        
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
                Logger.getLogger(GUI_ReporteVentas.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(GUI_ReporteVentas.class.getName()).log(Level.SEVERE, null, ex);
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
        txt_venta_apellido = new javax.swing.JTextField();
        txt_venta_edad = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_venta_nombre = new javax.swing.JTextField();
        txt_venta_cedula = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txt_venta_tipoPasajero = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_venta_costo = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txt_venta_fecha = new javax.swing.JTextField();
        txt_venta_hora = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txt_venta_numboleto = new javax.swing.JTextField();
        txt_venta_descuento = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txt_venta_total = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_ventas_boletos = new javax.swing.JTable();
        txt_buscarBoleto = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        btn_buscarBoleto = new javax.swing.JButton();
        btn_p_salir = new javax.swing.JButton();
        txt_IdCompra = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("DATOS DE PASAJERO :");

        txt_venta_apellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_venta_apellidoActionPerformed(evt);
            }
        });

        jLabel1.setText("Nombre Pasajero:");

        jLabel2.setText("Apellido Pasajero:");

        jLabel4.setText("Edad Pasajero:");

        jLabel5.setText("Categoria  Pasajero:");

        jLabel16.setText("Cédula Pasajero:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addContainerGap(476, Short.MAX_VALUE))
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_venta_tipoPasajero, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(33, 33, 33))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
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
                        .addComponent(txt_venta_cedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_venta_tipoPasajero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setText("DATOS DE RUTA :");

        jLabel9.setText("Costo de Ruta");

        jLabel10.setText("Fecha de viaje");

        jLabel11.setText("Hora de viaje");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addContainerGap(369, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txt_venta_costo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 128, Short.MAX_VALUE)
                                .addComponent(txt_venta_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(58, 58, 58))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel10)
                                .addGap(88, 88, 88)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(txt_venta_hora, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_venta_hora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_venta_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_venta_costo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel12.setText("Numero de boletos");

        jLabel13.setText("Descuento");

        jLabel15.setText("Total a Pagar");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel19.setText("DATOS DE COMPRA :");

        txt_venta_total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_venta_totalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(txt_venta_numboleto, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(104, 104, 104)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(txt_venta_total, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(txt_venta_descuento, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel19)
                .addGap(14, 14, 14)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel15)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txt_venta_numboleto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_venta_descuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_venta_total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setText("BUSCAR BOLETO POR CEDULA DE PASAJERO");

        btn_buscarBoleto.setText("BUSCAR");
        btn_buscarBoleto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarBoletoActionPerformed(evt);
            }
        });

        btn_p_salir.setText("Salir");
        btn_p_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_p_salirActionPerformed(evt);
            }
        });

        jLabel18.setText("ID COMPRA");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel20.setText("REPORTE DE VENTAS DE BOLETOS");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 888, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34))
                            .addComponent(txt_IdCompra, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_buscarBoleto, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_p_salir, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txt_buscarBoleto))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(293, 293, 293)
                .addComponent(jLabel20)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_IdCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 49, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txt_buscarBoleto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_buscarBoleto, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_p_salir, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_p_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_p_salirActionPerformed
        // TODO add your handling code here:
        GUI_Principal b = new GUI_Principal();
        b.setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_p_salirActionPerformed

    private void txt_venta_apellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_venta_apellidoActionPerformed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_txt_venta_apellidoActionPerformed

    private void table_ventas_boletosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_ventas_boletosMouseClicked

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
        txt_venta_edad.setText(table_ventas_boletos.getValueAt(fila, 4).toString());
        txt_venta_tipoPasajero.setText(table_ventas_boletos.getValueAt(fila, 5).toString());
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
        txt_venta_nombre.setText("");
        txt_venta_apellido.setText("");
        txt_venta_cedula.setText("");
        txt_venta_edad.setText("");
        txt_venta_tipoPasajero.setText("");
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
                     Logger.getLogger(GUI_ReporteVentas.class.getName()).log(Level.SEVERE, null, ex);
                }
    }//GEN-LAST:event_btn_buscarBoletoActionPerformed

    private void table_ventas_boletosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_ventas_boletosMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_table_ventas_boletosMouseEntered

    private void txt_venta_totalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_venta_totalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_venta_totalActionPerformed

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
            java.util.logging.Logger.getLogger(GUI_ReporteVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_ReporteVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_ReporteVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_ReporteVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new GUI_ReporteVentas().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(GUI_ReporteVentas.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_buscarBoleto;
    private javax.swing.JButton btn_p_salir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable table_ventas_boletos;
    private javax.swing.JTextField txt_IdCompra;
    private javax.swing.JTextField txt_buscarBoleto;
    private javax.swing.JTextField txt_venta_apellido;
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
