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
import proyect_clases.Boleto;
import proyect_clases.Pasajero;
import proyect_clases.Rutas;
import proyect_metodos.MetodoBoleto;
import proyect_metodos.MetodoPasajero;
import proyect_metodos.MetodoRutas;


public class GUI_VentaDeBoletos extends javax.swing.JFrame {
    
     
   // Se declara esta variable final que obtendra siempre la ruta de los archivos dentro del directorio del programa
    private final String ruta = System.getProperties().getProperty("user.dir");
    
    Boleto boleto = new Boleto();
    Pasajero pasajero = new Pasajero();
    Rutas rutaBoleto = new Rutas ();
    MetodoPasajero buscarP = new MetodoPasajero();
    MetodoRutas buscarR = new MetodoRutas();
    MetodoBoleto metodos = new MetodoBoleto();
    public static String busqueda="";
    public static DefaultTableModel mdlTablaBoletos;
    public DefaultTableModel mdlTablaRutasDisponibles;
    Vector vCabeceras = new Vector();
    Vector vCabecerasRutas = new Vector();

    public GUI_VentaDeBoletos() throws IOException {
        initComponents();
        
        //Generamos codigo de venta nuevo
        GenerarCodigoReserva();
        
        //Preparamos los jtxtField
        txt_venta_total.setEditable(false);
        txt_IdCompra.setEditable(false);
        txt_venta_nombre.setEditable(false);
        txt_venta_apellido.setEditable(false);
        txt_venta_cedula.setEditable(false);
        txt_venta_edad.setEditable(false);
        txt_venta_tipoPasajero.setEditable(false);
        txtRuta.setEditable(false);
        txtCosto.setEditable(false);
        txtFecha.setEditable(false);
        txt_venta_total.setText("0.00");
        txt_venta_total.setBackground(Color.BLACK);
        txt_venta_total.setForeground(Color.yellow);
        
        //creamos la cabecera de la tabla de Venta de Boletos
        vCabeceras.addElement("ID BOLETO");
        vCabeceras.addElement("NOMBRE");
        vCabeceras.addElement("APELLIDO");
        vCabeceras.addElement("CEDULA");
        vCabeceras.addElement("EDAD");
        vCabeceras.addElement("CATEGORIA");
        vCabeceras.addElement("RUTA");
        vCabeceras.addElement("ORIGEN");
        vCabeceras.addElement("DESTINO");
        vCabeceras.addElement("FECHA");
        vCabeceras.addElement("HORA");
        vCabeceras.addElement("CANTIDAD");
        vCabeceras.addElement("COSTO");
        vCabeceras.addElement("DESCUENTO");
        vCabeceras.addElement("TOTAL");
        
        //creamos la cabecera de la tabla de Rutas Disponibles
        vCabecerasRutas.addElement("ID");
        vCabecerasRutas.addElement("RUTA");
        vCabecerasRutas.addElement("ORIGEN");
        vCabecerasRutas.addElement("DESTINO");
        vCabecerasRutas.addElement("COSTO");
        vCabecerasRutas.addElement("HORA");
        vCabecerasRutas.addElement("FECHA");

        //Leemos y colocamos datos en la tabla de Boletos
        mdlTablaBoletos = new DefaultTableModel(vCabeceras,0);
        table_ventas_boletos.setModel(mdlTablaBoletos);
        table_ventas_boletos.setModel(metodos.listaBoleto());
        
        //Leemos y colocamos datos en la tabla de Rutas Disponibles
        mdlTablaRutasDisponibles = new DefaultTableModel(vCabecerasRutas,0);
        table_rutasDisponibles.setModel(mdlTablaRutasDisponibles);
        table_rutasDisponibles.setModel(buscarR.listaRutas());
        
        //preparamos los botones
         btn_p_editar.setEnabled(false);
         btn_p_eliminar.setEnabled(false);
         btn_p_guardar.setEnabled(true);
         btn_ventas_nuevo.setEnabled(true);
         
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
            archivo = new File(ruta+"\\src\\proyect_persistencia\\boletos.txt");
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
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtRuta = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtCosto = new javax.swing.JTextField();
        txtFecha = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_rutasDisponibles = new javax.swing.JTable();
        jLabel22 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        txtOrigen = new javax.swing.JTextField();
        txtDestino = new javax.swing.JTextField();
        txtHora = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txt_venta_numboleto = new javax.swing.JTextField();
        txt_venta_descuento = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txt_venta_total = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        btn_calcular_ruta = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
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
        jButton3 = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/turista.png"))); // NOI18N
        jLabel6.setText("DATOS DE PASAJERO :");

        jLabel3.setText("Buscar Cedula:");

        txt_venta_apellido.setEditable(false);
        txt_venta_apellido.setBackground(new java.awt.Color(0, 0, 0));
        txt_venta_apellido.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_venta_apellido.setForeground(new java.awt.Color(153, 255, 0));
        txt_venta_apellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_venta_apellidoActionPerformed(evt);
            }
        });

        txt_venta_edad.setEditable(false);
        txt_venta_edad.setBackground(new java.awt.Color(0, 0, 0));
        txt_venta_edad.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_venta_edad.setForeground(new java.awt.Color(153, 255, 0));

        txt_venta_tipoPasajero.setEditable(false);
        txt_venta_tipoPasajero.setBackground(new java.awt.Color(0, 0, 0));
        txt_venta_tipoPasajero.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_venta_tipoPasajero.setForeground(new java.awt.Color(153, 255, 0));

        jLabel1.setText("Nombre Pasajero:");

        jLabel2.setText("Apellido Pasajero:");

        jLabel4.setText("Edad Pasajero:");

        jLabel5.setText("Categoria  Pasajero:");

        txt_venta_nombre.setEditable(false);
        txt_venta_nombre.setBackground(new java.awt.Color(0, 0, 0));
        txt_venta_nombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_venta_nombre.setForeground(new java.awt.Color(153, 255, 0));

        btn_buscarr_pasajero.setBackground(new java.awt.Color(153, 255, 255));
        btn_buscarr_pasajero.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/seaarch.png"))); // NOI18N
        btn_buscarr_pasajero.setText("Buscar");
        btn_buscarr_pasajero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarr_pasajeroActionPerformed(evt);
            }
        });

        txt_venta_cedula.setEditable(false);
        txt_venta_cedula.setBackground(new java.awt.Color(0, 0, 0));
        txt_venta_cedula.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_venta_cedula.setForeground(new java.awt.Color(153, 255, 0));
        txt_venta_cedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_venta_cedulaActionPerformed(evt);
            }
        });

        jLabel16.setText("Cédula Pasajero:");

        jLabel18.setText("ID COMPRA");

        txt_IdCompra.setBackground(new java.awt.Color(0, 0, 0));
        txt_IdCompra.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_IdCompra.setForeground(new java.awt.Color(153, 255, 0));
        txt_IdCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_IdCompraActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(204, 255, 204));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/turista_1.png"))); // NOI18N
        jButton1.setText("REGISTRAR NUEVO PASAJERO");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(153, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ruta_1.png"))); // NOI18N
        jButton2.setText("VER PASAJEROS REGISTRADOS");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(txt_venta_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_venta_apellido, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txt_venta_edad, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txt_venta_cedula, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txt_venta_tipoPasajero, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5)))
                        .addContainerGap(234, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txt_venta_busca_cedula, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_buscarr_pasajero, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(151, 151, 151)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_IdCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel18))))
                        .addGap(160, 160, 160)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(12, 12, 12))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(22, 22, 22)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_venta_busca_cedula)
                            .addComponent(btn_buscarr_pasajero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_IdCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel16)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_venta_tipoPasajero, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_venta_cedula, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_venta_edad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_venta_apellido, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_venta_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel7.setText("Seleccione una Ruta");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ruta.png"))); // NOI18N
        jLabel8.setText(" RUTA :");

        jLabel9.setText("RUTA");

        txtRuta.setEditable(false);
        txtRuta.setBackground(new java.awt.Color(0, 0, 0));
        txtRuta.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtRuta.setForeground(new java.awt.Color(153, 255, 0));

        jLabel10.setText("COSTO");

        jLabel11.setText("FECHA");

        txtCosto.setEditable(false);
        txtCosto.setBackground(new java.awt.Color(0, 0, 0));
        txtCosto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtCosto.setForeground(new java.awt.Color(153, 255, 0));

        txtFecha.setEditable(false);
        txtFecha.setBackground(new java.awt.Color(0, 0, 0));
        txtFecha.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtFecha.setForeground(new java.awt.Color(153, 255, 0));

        table_rutasDisponibles.setBackground(new java.awt.Color(204, 255, 204));
        table_rutasDisponibles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        table_rutasDisponibles.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_rutasDisponiblesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                table_rutasDisponiblesMouseEntered(evt);
            }
        });
        jScrollPane2.setViewportView(table_rutasDisponibles);

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ruta.png"))); // NOI18N
        jLabel22.setText("LISTADO DE RUTAS DE VUELOS DISPONIBLES");

        jButton4.setBackground(new java.awt.Color(204, 255, 204));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/destino.png"))); // NOI18N
        jButton4.setText("SELECCIONAR RUTA ");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        txtOrigen.setEditable(false);
        txtOrigen.setBackground(new java.awt.Color(0, 0, 0));
        txtOrigen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtOrigen.setForeground(new java.awt.Color(153, 255, 0));

        txtDestino.setEditable(false);
        txtDestino.setBackground(new java.awt.Color(0, 0, 0));
        txtDestino.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtDestino.setForeground(new java.awt.Color(153, 255, 0));

        txtHora.setEditable(false);
        txtHora.setBackground(new java.awt.Color(0, 0, 0));
        txtHora.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtHora.setForeground(new java.awt.Color(153, 255, 0));

        jLabel23.setText("HORA");

        jLabel24.setText("ORIGEN");

        jLabel25.setText("DESTINO");

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel26.setText("$");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel7)
                        .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel9))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel26)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel10))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel24))))
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 479, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23)
                            .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(104, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel23))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel25)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(65, 65, 65)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9))
                        .addGap(4, 4, 4)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26))
                .addContainerGap())
        );

        jLabel12.setText("Numero de boletos");

        jLabel13.setText("Descuento");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pasaporte.png"))); // NOI18N
        jLabel14.setText("BOLETOS :");

        txt_venta_total.setEditable(false);
        txt_venta_total.setBackground(new java.awt.Color(0, 0, 0));
        txt_venta_total.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_venta_total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_venta_totalActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setText("Total a pagar");

        btn_calcular_ruta.setBackground(new java.awt.Color(204, 204, 255));
        btn_calcular_ruta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/venta_1.png"))); // NOI18N
        btn_calcular_ruta.setText("Calcular");
        btn_calcular_ruta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_calcular_rutaActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel20.setText("Calcular total");

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel21.setText("$");

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel27.setText("$");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_venta_numboleto)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(7, 7, 7)
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_venta_descuento, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(btn_calcular_ruta, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                                .addComponent(jLabel27)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(37, 37, 37)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(txt_venta_total, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel15)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel20))
                .addGap(14, 14, 14)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btn_calcular_ruta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_venta_numboleto, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_venta_descuento, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_venta_total, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
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

        table_ventas_boletos.setBackground(new java.awt.Color(204, 255, 204));
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

        btn_buscarBoleto.setBackground(new java.awt.Color(153, 255, 255));
        btn_buscarBoleto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/seaarch.png"))); // NOI18N
        btn_buscarBoleto.setText("BUSCAR");
        btn_buscarBoleto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarBoletoActionPerformed(evt);
            }
        });

        btn_ventas_nuevo.setBackground(new java.awt.Color(255, 255, 204));
        btn_ventas_nuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ruta.png"))); // NOI18N
        btn_ventas_nuevo.setText("Nueva compra");
        btn_ventas_nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ventas_nuevoActionPerformed(evt);
            }
        });

        btn_p_guardar.setBackground(new java.awt.Color(255, 255, 102));
        btn_p_guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cuenta.png"))); // NOI18N
        btn_p_guardar.setText("ACEPTAR COMPRA");
        btn_p_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_p_guardarActionPerformed(evt);
            }
        });

        btn_p_editar.setBackground(new java.awt.Color(204, 204, 255));
        btn_p_editar.setText("Editar");
        btn_p_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_p_editarActionPerformed(evt);
            }
        });

        btn_p_eliminar.setBackground(new java.awt.Color(255, 153, 153));
        btn_p_eliminar.setText("Eliminar");
        btn_p_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_p_eliminarActionPerformed(evt);
            }
        });

        btn_p_salir.setBackground(new java.awt.Color(255, 204, 204));
        btn_p_salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/salida.png"))); // NOI18N
        btn_p_salir.setText("Salir");
        btn_p_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_p_salirActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(204, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pasaporte.png"))); // NOI18N
        jButton3.setText("ACTUALIZAR  BOLETOS COMPRADOS");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel19.setText("BOLETOS COMPRADOS");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 34, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btn_p_eliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_p_editar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_ventas_nuevo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE))
                            .addComponent(btn_p_salir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(73, 73, 73)
                                .addComponent(btn_p_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txt_buscarBoleto, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn_buscarBoleto, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel17)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(199, 199, 199)
                        .addComponent(btn_p_salir, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                                .addComponent(jLabel19)
                                .addGap(18, 18, 18))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_p_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_buscarBoleto, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_buscarBoleto, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(btn_ventas_nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_p_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(btn_p_eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
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
      
        
        
        txt_venta_total.setText("0.00");
        txt_venta_total.setBackground(Color.BLACK);
        txt_venta_total.setForeground(Color.yellow);
        
        // Generamos un nuevo codigo de reserva automatica para la siguiente compra de boleto
        try {
            GenerarCodigoReserva();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GUI_VentaDeBoletos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // Activamos el boton de guardar
        btn_p_guardar.setEnabled(true);
        // Desactivamos el boton Editar mientras estamos en modo NUEVO
        btn_p_editar.setEnabled(false);
         // Desactivamos el boton Eliminar mientras estamos en modo NUEVO
        btn_p_eliminar.setEnabled(false);
          txt_buscarBoleto.setEnabled(true);
        btn_buscarBoleto.setEnabled(true);        
       
        
        // Limpia los Jtext:
        txt_venta_busca_cedula.setText("");
        txt_venta_nombre.setText("");
        txt_venta_apellido.setText("");
        txt_venta_cedula.setText("");
        txt_venta_edad.setText("");
        txt_venta_tipoPasajero.setText("");
        txtOrigen.setText("");
        txtDestino.setText("");
        txtRuta.setText("");
        txtCosto.setText("");
        txtFecha.setText("");
        txtHora.setText("");
        txt_venta_numboleto.setText("");
        txt_venta_descuento.setText("");
        txt_venta_total.setText("");
        txt_buscarBoleto.setText("");

    }//GEN-LAST:event_btn_ventas_nuevoActionPerformed

    private void btn_p_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_p_editarActionPerformed
        // Boton editar boletos de compra en tabla:
        
        //Confirmamos si deseamos eliminar o no, por seguridad
        int opcion = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea EDITAR el BOLETO del sistema?");
        if(opcion == JOptionPane.YES_OPTION){  
        
        String IdBoleto = txt_IdCompra.getText();
        String nombre = txt_venta_nombre.getText();
        String apellido = txt_venta_apellido.getText();
        String venta_cedula = txt_venta_cedula.getText();
        String edad = txt_venta_edad.getText();
        String tipo = txt_venta_tipoPasajero.getText();
        String rutaEditarBoleto = txtRuta.getText();
        String origen = txtOrigen.getText();
        String destino = txtDestino.getText();
        String fecha = txtFecha.getText();
        String hora = txtHora.getText();
        String cantidadBoletos = txt_venta_numboleto.getText();
        String costoBoleto = txtCosto.getText();
        String descuento = txt_venta_descuento.getText();
        String total = txt_venta_total.getText();
        
        //Pasamos al metodo los valores de las variables para procesar en el metodo
        metodos.EditarBoleto(IdBoleto, nombre, apellido, venta_cedula, edad, tipo, rutaEditarBoleto, origen, destino, fecha, hora, cantidadBoletos, costoBoleto, descuento, total);
        
      txt_venta_total.setText("0.00");
        
        // Generamos un nuevo codigo de reserva automatica para la siguiente compra de boleto
        try {
            GenerarCodigoReserva();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GUI_VentaDeBoletos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // Activamos el boton de guardar
        btn_p_guardar.setEnabled(true);
        // Desactivamos el boton Editar mientras estamos en modo NUEVO
        btn_p_editar.setEnabled(false);
         // Desactivamos el boton Eliminar mientras estamos en modo NUEVO
        btn_p_eliminar.setEnabled(false);  
        txt_buscarBoleto.setEnabled(true);
        btn_buscarBoleto.setEnabled(true);
       
        
        // Limpia los Jtext:
        txt_venta_busca_cedula.setText("");
        txt_venta_nombre.setText("");
        txt_venta_apellido.setText("");
        txt_venta_cedula.setText("");
        txt_venta_edad.setText("");
        txt_venta_tipoPasajero.setText("");
        txtOrigen.setText("");
        txtDestino.setText("");
        txtRuta.setText("");
        txtCosto.setText("");
        txtFecha.setText("");
        txtHora.setText("");
        txt_venta_numboleto.setText("");
        txt_venta_descuento.setText("");
        txt_venta_total.setText("");
        txt_buscarBoleto.setText("");
        } 
        
          try {
            table_ventas_boletos.setModel(metodos.listaBoleto());
        } catch (IOException ex) {
            Logger.getLogger(GUI_VentaDeBoletos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btn_p_editarActionPerformed

    private void btn_buscarr_pasajeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarr_pasajeroActionPerformed

        if (txt_venta_busca_cedula.getText().length() == 0) {
                        JOptionPane.showMessageDialog(rootPane, "Debe ingresar una Cedula de Pasajero");
                        txt_venta_busca_cedula.requestFocus();
                        return;
                    }
        
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
        
        Double ventaTotal = 0.00;
        
        // Primero validamos cada una de la entradas

                        if (txt_venta_nombre.getText().length() == 0) {
                        JOptionPane.showMessageDialog(rootPane, "Debe ingresar una Cedula de Pasajero para Seleccionar un PASAJERO");
                        txt_venta_nombre.requestFocus();
                        return;
                    }
                       if (txtRuta.getText().length() == 0) {
                        JOptionPane.showMessageDialog(rootPane, "Debe seleccionar una Ruta para su compra");
                        txtRuta.requestFocus();
                        return;
                    }
                       
                        if (txt_venta_numboleto.getText().length() == 0) {
                        JOptionPane.showMessageDialog(rootPane, "Debe ingresar una CANTIDAD de BOLETOS para su compra");
                        txt_venta_numboleto.requestFocus();
                        return;
                    }
                        if (txt_venta_total.getText().length() == 0) {
                        JOptionPane.showMessageDialog(rootPane, "Debe seleccionar un PASAJERO, UNA RUTA y UNA CANTIDAD de BOLETOS antes de su compra");
                        txt_venta_numboleto.requestFocus();
                        return;
                    }
                       
            mdlTablaBoletos = new DefaultTableModel();
            
            int IdCompra = Integer.parseInt(txt_IdCompra.getText());
            String Nombre = txt_venta_nombre.getText();
            String Apellido = txt_venta_apellido.getText();
            int Cedula = Integer.parseInt(txt_venta_cedula.getText());
            int Edad = Integer.parseInt(txt_venta_edad.getText());
            String Categoria = txt_venta_tipoPasajero.getText();
            String Ruta = txtRuta.getText();
            String Origen = txtOrigen.getText();
            String Destino = txtDestino.getText();
            String ventaFecha = txtFecha.getText();
            String ventaHora = txtHora.getText();
            int ventaCantidadBoleto = Integer.parseInt(txt_venta_numboleto.getText());
            Double ventaCosto = Double.parseDouble(txtCosto.getText());
            Double ventaDescuento = Double.parseDouble(txt_venta_descuento.getText());
            ventaTotal = Double.parseDouble(txt_venta_total.getText());
            
            
      // Id de COMPRA
        boleto.setId_boleto(IdCompra);
        
     // Datos del pasajero
        pasajero.setNombre_pasajero(Nombre);
        pasajero.setApellido_pasajero(Apellido);
        pasajero.setCedula_pasajero(Cedula);
        pasajero.setEdad_pasajero(Edad);
        pasajero.setTipo_pasajero(Categoria);
        
     // Datos de la ruta
        rutaBoleto.setNombre_Ruta(Ruta);
        rutaBoleto.setOrigen_Ruta(Origen);
        rutaBoleto.setDestino_Ruta(Destino);
       
     // Datos de venta del boleto
        
        boleto.setNumero_boleto(ventaCantidadBoleto);
        boleto.setFecha_boleto(ventaFecha);
        boleto.setHora_boleto(ventaHora);
        boleto.setCosto_boleto(ventaCosto);
        boleto.setDescuento(ventaDescuento);
        boleto.setCosto_total(ventaTotal);
        
     // Guardamos los datos de la compra del boleto
        metodos.guardarArchivoBoleto(pasajero, rutaBoleto, boleto);
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
        txtRuta.setText("");
        txtOrigen.setText("");
        txtDestino.setText("");
        txtCosto.setText("");
        txtFecha.setText("");
        txtHora.setText("");
        txt_venta_numboleto.setText("");
        txt_venta_descuento.setText("");
        txt_venta_total.setText("");

        
        try {
            table_ventas_boletos.setModel(metodos.listaBoleto());
        } catch (IOException ex) {
            Logger.getLogger(GUI_RegistroPasajeros.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ventaTotal = 0.00;

    }//GEN-LAST:event_btn_p_guardarActionPerformed

    private void txt_venta_apellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_venta_apellidoActionPerformed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_txt_venta_apellidoActionPerformed

    private void txt_venta_totalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_venta_totalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_venta_totalActionPerformed

    private void btn_calcular_rutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_calcular_rutaActionPerformed
        // TODO add your handling code here:
        
        Double str = 0.00;
        
        // Primero validamos cada una de las entradas
        
                     if (txt_venta_nombre.getText().length() == 0) {

                        JOptionPane.showMessageDialog(rootPane, "Debe INGRESAR una CEDULA para seleccionar un PASAJERO");
                        txt_venta_nombre.requestFocus();
                        return;
                    }
                    
                      if (txtRuta.getText().length() == 0) {

                        JOptionPane.showMessageDialog(rootPane, "Debe ingresar una RUTA para poder calcular costos de Boletos y Ruta.");
                        txtRuta.requestFocus();
                        return;
                    }
                      
                         if (txt_venta_numboleto.getText().length() == 0) {

                        JOptionPane.showMessageDialog(rootPane, "Debe ingresar una CANTIDAD para poder calcular costos de Boletos y Ruta.");
                        txt_venta_numboleto.requestFocus();
                        return;
                    }
                         
                            if (txt_venta_descuento.getText().length() == 0) {

                        JOptionPane.showMessageDialog(rootPane, "Debe ingresar un DESCUENTO para poder calcular costos de Boletos. Coloque un cero si no hay descuentos");
                        txt_venta_descuento.requestFocus();
                        return;
                    }
   
                    try {
                        
                    int numBoletos = Integer.parseInt(txt_venta_numboleto.getText());
                    Double costoRuta = Double.parseDouble(txtCosto.getText());
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
                        txtRuta.setText("");
                        txtOrigen.setText("");
                        txtDestino.setText("");
                        txtCosto.setText("");
                        txtFecha.setText("");
                        txt_venta_numboleto.setText("");
                        txt_venta_descuento.setText("");
                        txt_venta_total.setText("");
                        txt_venta_cedula.setText("");

                    }
        
    }//GEN-LAST:event_btn_calcular_rutaActionPerformed

    private void table_ventas_boletosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_ventas_boletosMouseClicked

        txt_venta_nombre.setEditable(true);
        txt_venta_apellido.setEditable(true);
        txt_venta_cedula.setEditable(true);
        txt_venta_edad.setEditable(true);
        txt_venta_tipoPasajero.setEditable(true);
        txtRuta.setEditable(true);
        txtCosto.setEditable(true);
        txtFecha.setEditable(true); 
        txtHora.setEditable(true);
        txtOrigen.setEditable(true);
        txtDestino.setEditable(true);
        txt_buscarBoleto.setEnabled(false);
        btn_buscarBoleto.setEnabled(false);
  
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
        vCabeceras.addElement("ORIGEN");
        vCabeceras.addElement("DESTINO");
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
        
        txtRuta.setText(table_ventas_boletos.getValueAt(fila, 6).toString());
        txtOrigen.setText(table_ventas_boletos.getValueAt(fila, 7).toString());
        txtDestino.setText(table_ventas_boletos.getValueAt(fila, 8).toString());
        txtFecha.setText(table_ventas_boletos.getValueAt(fila, 9).toString());
        txtHora.setText(table_ventas_boletos.getValueAt(fila, 10).toString());
        txt_venta_numboleto.setText(table_ventas_boletos.getValueAt(fila, 11).toString());
        txtCosto.setText(table_ventas_boletos.getValueAt(fila, 12).toString());
        txt_venta_descuento.setText(table_ventas_boletos.getValueAt(fila, 13).toString());
        txt_venta_total.setText(table_ventas_boletos.getValueAt(fila, 14).toString());
 
    }//GEN-LAST:event_table_ventas_boletosMouseClicked

    private void txt_buscarBoletoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_buscarBoletoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_buscarBoletoActionPerformed

    private void btn_buscarBoletoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarBoletoActionPerformed
               
        
  
        busqueda = txt_buscarBoleto.getText();
        try {
            metodos.BuscarBoleto(busqueda);
        } catch (IOException ex) {
            Logger.getLogger(GUI_VentaDeBoletos.class.getName()).log(Level.SEVERE, null, ex);
        }
        busqueda = "";     
    }//GEN-LAST:event_btn_buscarBoletoActionPerformed

    private void btn_p_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_p_eliminarActionPerformed
        
         //Confirmamos si deseamos eliminar o no, por seguridad
        int opcion = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar el BOLETO del sistema?");
        if(opcion == JOptionPane.YES_OPTION){  
        
        String IdBoleto = txt_IdCompra.getText();
        String nombre = txt_venta_nombre.getText();
        String apellido = txt_venta_apellido.getText();
        String venta_cedula = txt_venta_cedula.getText();
        String edad = txt_venta_edad.getText();
        String tipo = txt_venta_tipoPasajero.getText();
        String ruta = txtRuta.getText();
        String origen = txtOrigen.getText();
        String destino = txtDestino.getText();
        String fecha = txtCosto.getText();
        String hora = txtFecha.getText();
        String cantidadBoletos = txt_venta_numboleto.getText();
        String costoBoleto = txtRuta.getText();
        String descuento = txt_venta_descuento.getText();
        String total = txt_venta_total.getText();
        
        //Pasamos al metodo los valores de las variables para procesar en el metodo
        metodos.EliminarBoleto(IdBoleto, nombre, apellido, venta_cedula, edad, tipo, ruta, origen, destino, fecha, hora, cantidadBoletos, costoBoleto, descuento, total);
        
        // limipiamos los text
        txt_venta_busca_cedula.setText("");
        txt_venta_nombre.setText("");
        txt_venta_apellido.setText("");
        txt_venta_cedula.setText("");
        txt_venta_edad.setText("");
        txt_venta_tipoPasajero.setText("");
        txtRuta.setText("");
        txtOrigen.setText("");
        txtDestino.setText("");
        txtCosto.setText("");
        txtFecha.setText("");
        txtHora.setText("");
        txt_venta_numboleto.setText("");
        txt_venta_descuento.setText("");
        txt_venta_total.setText("");
        txt_buscarBoleto.setText("");

            try {
                // volvemos a leer los datos de la tabla
                table_ventas_boletos.setModel(metodos.listaBoleto());
            } catch (IOException ex) {
                Logger.getLogger(GUI_VentaDeBoletos.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try {
                GenerarCodigoReserva();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(GUI_VentaDeBoletos.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            btn_p_editar.setEnabled(false);
            btn_p_eliminar.setEnabled(false);
            btn_p_guardar.setEnabled(true);
            btn_ventas_nuevo.setEnabled(true);
            txt_venta_nombre.setEditable(false);
            txt_venta_apellido.setEditable(false);
            txt_venta_cedula.setEditable(false);
            txt_venta_edad.setEditable(false);
            txt_venta_tipoPasajero.setEditable(false);
            txtRuta.setEditable(false);
            txtOrigen.setEditable(false);
            txtDestino.setEditable(false);
            txtCosto.setEditable(false);
            txtFecha.setEditable(false);
            txt_buscarBoleto.setEnabled(false);
            btn_buscarBoleto.setEnabled(false);
            
            }  
        
        txt_venta_total.setText("0.00");
    }//GEN-LAST:event_btn_p_eliminarActionPerformed

    private void table_ventas_boletosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_ventas_boletosMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_table_ventas_boletosMouseEntered

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
            // Agregamos Manejo de Execpciones
        GUI_RegistroPasajeros b = null;
        try {
            b = new GUI_RegistroPasajeros();
        } catch (IOException ex) {
            Logger.getLogger(GUI_Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        b.setVisible(true);
       dispose();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
              // Agregamos Manejo de Execpciones
        GUI_ReportePasajeros b = null;
        try {
            b = new GUI_ReportePasajeros();
        } catch (IOException ex) {
            Logger.getLogger(GUI_Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        b.setVisible(true);

    }//GEN-LAST:event_jButton2ActionPerformed

    private void txt_IdCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_IdCompraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_IdCompraActionPerformed

    private void txt_venta_cedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_venta_cedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_venta_cedulaActionPerformed

    private void table_rutasDisponiblesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_rutasDisponiblesMouseClicked
 

    }//GEN-LAST:event_table_rutasDisponiblesMouseClicked

    private void table_rutasDisponiblesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_rutasDisponiblesMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_table_rutasDisponiblesMouseEntered

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
        try {
            table_ventas_boletos.setModel(metodos.listaBoleto());
        } catch (IOException ex) {
            Logger.getLogger(GUI_VentaDeBoletos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        
        GUI_SeleccionRutas registroRutas = null;
        try {
            registroRutas = new GUI_SeleccionRutas();
        } catch (IOException ex) {
            Logger.getLogger(GUI_VentaDeBoletos.class.getName()).log(Level.SEVERE, null, ex);
        }
        registroRutas.toFront();
        registroRutas.setVisible(true);
        
    }//GEN-LAST:event_jButton4ActionPerformed

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
    private javax.swing.JButton btn_buscarr_pasajero;
    private javax.swing.JButton btn_calcular_ruta;
    private javax.swing.JButton btn_p_editar;
    private javax.swing.JButton btn_p_eliminar;
    private javax.swing.JButton btn_p_guardar;
    private javax.swing.JButton btn_p_salir;
    private javax.swing.JButton btn_ventas_nuevo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
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
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable table_rutasDisponibles;
    public static javax.swing.JTable table_ventas_boletos;
    public static javax.swing.JTextField txtCosto;
    public static javax.swing.JTextField txtDestino;
    public static javax.swing.JTextField txtFecha;
    public static javax.swing.JTextField txtHora;
    public static javax.swing.JTextField txtOrigen;
    public static javax.swing.JTextField txtRuta;
    private javax.swing.JTextField txt_IdCompra;
    private javax.swing.JTextField txt_buscarBoleto;
    private javax.swing.JTextField txt_venta_apellido;
    private javax.swing.JTextField txt_venta_busca_cedula;
    private javax.swing.JTextField txt_venta_cedula;
    private javax.swing.JTextField txt_venta_descuento;
    private javax.swing.JTextField txt_venta_edad;
    private javax.swing.JTextField txt_venta_nombre;
    private javax.swing.JTextField txt_venta_numboleto;
    private javax.swing.JTextField txt_venta_tipoPasajero;
    private javax.swing.JTextField txt_venta_total;
    // End of variables declaration//GEN-END:variables
}
