package proyect_metodos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import proyect_clases.Boleto;
import proyect_clases.Pasajero;
import proyect_clases.Rutas;
import proyect_gui.GUI_VentaDeBoletos;
import static proyect_gui.GUI_VentaDeBoletos.mdlTablaBoletos;

public class MetodoBoleto {

    public static String busqueda;
    GUI_VentaDeBoletos ventaBoletos;
    
    Vector vPrincipal = new Vector();
    
    // Se declara esta variable final que obtendra siempre la ruta de los archivos dentro del directorio del programa
    private final String ruta = System.getProperties().getProperty("user.dir");
    
    public void guardarArchivoBoleto(Pasajero pasajero, Rutas rutaBoleto, Boleto boleto){
        
      try {
            FileWriter fw = new FileWriter (ruta+"\\src\\proyect_persistencia\\boletos.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
          //Id boleto
          try (PrintWriter pw = new PrintWriter(bw)) {
              //Id boleto
              pw.print(boleto.getId_boleto());
              //pasajero
              pw.print(","+pasajero.getNombre_pasajero());
              pw.print(","+pasajero.getApellido_pasajero());
              pw.print(","+pasajero.getCedula_pasajero());
              pw.print(","+pasajero.getEdad_pasajero());
              pw.print(","+pasajero.getTipo_pasajero());
              //ruta
              pw.print(","+rutaBoleto.getNombre_Ruta());
              pw.print(","+rutaBoleto.getOrigen_Ruta());
              pw.print(","+rutaBoleto.getDestino_Ruta());
              //boleto
              pw.print(","+boleto.getFecha_boleto());
              pw.print(","+boleto.getHora_boleto());
              pw.print(","+boleto.getNumero_boleto());
              pw.print(","+boleto.getCosto_boleto());
              pw.print(","+boleto.getDescuento());
              pw.println(","+boleto.getCosto_total());
          }
        } catch (IOException e){
            JOptionPane.showMessageDialog(null, e);
        } 
    }
    
    public DefaultTableModel listaBoleto() throws FileNotFoundException, IOException{
        
        Vector cabeceras = new Vector();
        
        cabeceras.addElement("ID BOLETO");
        cabeceras.addElement("NOMBRE");
        cabeceras.addElement("APELLIDO");
        cabeceras.addElement("CEDULA");
        cabeceras.addElement("EDAD");
        cabeceras.addElement("CATEGORIA");
        cabeceras.addElement("RUTA");
        cabeceras.addElement("ORIGEN");
        cabeceras.addElement("DESTINO");
        cabeceras.addElement("FECHA");
        cabeceras.addElement("HORA");
        cabeceras.addElement("CANTIDAD");
        cabeceras.addElement("COSTO");
        cabeceras.addElement("DESCUENTO");
        cabeceras.addElement("TOTAL");
        
        //Crear vector
        DefaultTableModel mdlTablaP = new DefaultTableModel(cabeceras,0);
        try {
     
            FileReader fr = new FileReader(ruta+"\\src\\proyect_persistencia\\boletos.txt");
            BufferedReader br = new BufferedReader(fr);
            String d;

            while ((d=br.readLine())!=null){
                StringTokenizer dato = new StringTokenizer (d,",");
                Vector x = new Vector();
                while (dato.hasMoreTokens()){
                    x.addElement(dato.nextToken());
                }
                mdlTablaP.addRow(x);
            }
        }catch (Exception e){
        JOptionPane.showMessageDialog(null, "Estimado usuario: Al momento, no se registran BOLETOS existentes.");
        }
        return mdlTablaP;
    }

     // Este metodo utiliza la CEDULA
    public DefaultTableModel BuscarBoleto (String buscar) throws IOException{
        
        Vector cabeceras = new Vector();
        
        cabeceras.addElement("ID BOLETO");
        cabeceras.addElement("NOMBRE");
        cabeceras.addElement("APELLIDO");
        cabeceras.addElement("CEDULA");
        cabeceras.addElement("EDAD");
        cabeceras.addElement("CATEGORIA");
        cabeceras.addElement("RUTA");
        cabeceras.addElement("ORIGEN");
        cabeceras.addElement("DESTINO");
        cabeceras.addElement("FECHA");
        cabeceras.addElement("HORA");
        cabeceras.addElement("CANTIDAD");
        cabeceras.addElement("COSTO");
        cabeceras.addElement("DESCUENTO");
        cabeceras.addElement("TOTAL");

        if(buscar.length() == 00){
            JOptionPane.showMessageDialog(null, "Debe ingresar una CEDULA de Pasajero para su búsqueda.");
        }else{
            
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        
        GUI_VentaDeBoletos.mdlTablaBoletos = new DefaultTableModel(cabeceras,0);
        GUI_VentaDeBoletos.table_ventas_boletos.setModel(mdlTablaBoletos);

           try {
            archivo = new File(ruta+"\\src\\proyect_persistencia\\boletos.txt");
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
    
    public void EditarBoleto(String Id, String Nombre, String Apellido, String Cedula, String Edad, String Tipo, String Ruta, String Origen, String Destino, String Fecha, String Hora, String Cantidad, String Costo, String Descuento, String Total){

        String IdBoleto = Id;
        String nombre = Nombre;
        String apellido = Apellido;
        String venta_cedula = Cedula;
        String edad = Edad;
        String tipo = Tipo;
        String rutaBoleto = Ruta;
        String origen = Origen;
        String destino = Destino;
        String fecha = Fecha;
        String hora = Hora;
        String cantidadBoletos = Cantidad;
        String costoBoleto = Costo;
        String descuento = Descuento;
        String total = Total;
        
        ArrayList<String> tempArray = new ArrayList<>();
        
        try {
            try (FileReader fr = new FileReader(ruta+"\\src\\proyect_persistencia\\boletos.txt"))
            {
                Scanner reader = new Scanner(fr);
                String linea;
                String [] lineaArray;
                
                while((linea=reader.nextLine())!=null){
                    
            // Se toma el ID para lograr validar dado que al hacer clicik 
            // ese Empleado será el que entienda el sistema que debe actualizar
            
                lineaArray = linea.split(",");
                if(lineaArray[0].equals(IdBoleto)){
                    
           // Recorro y agrego en la fila que el sistema entiende que existe el ID
                    tempArray.add(
                            
                            IdBoleto + "," +
                            nombre + "," +
                            apellido + "," +
                            venta_cedula + "," +
                            edad + "," +
                            tipo+ "," +
                            rutaBoleto + "," +
                            origen + "," +
                            destino + "," +
                            fecha + "," +
                            hora + "," +
                            cantidadBoletos + "," +
                            costoBoleto + "," +
                            descuento + "," +
                            total);
                    
                    JOptionPane.showMessageDialog(null, "Boleto modificado Correctamente."); 
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
            try(PrintWriter pr = new PrintWriter(ruta+"\\src\\proyect_persistencia\\boletos.txt")) 
            {
                tempArray.forEach((str) -> {
                    pr.println(str);
                });
                pr.close();
            } catch (Exception e) {
            }
        } catch (Exception e) {
      }   
    }
    
     public void EliminarBoleto(String Id, String Nombre, String Apellido, String Cedula, String Edad, String Tipo, String Ruta, String Origen, String Destino, String Fecha, String Hora, String Cantidad, String Costo, String Descuento, String Total){
 
        String id = Id;
        String nombre = Nombre;
        String apellido = Apellido;
        String cedula = Cedula;
        String edad = Edad;
        String tipo = Tipo;
        String rutaBoleto = Ruta;
        String origen = Origen;
        String destino = Destino;
        String fecha = Fecha;
        String hora = Hora;
        String cantidad = Cantidad;
        String costo = Costo;
        String descuento = Descuento;
        String total = Total;

        ArrayList<String> tempArray = new ArrayList<>();
        
        try {
            try (FileReader fr = new FileReader(ruta+"\\src\\proyect_persistencia\\boletos.txt"))
            {
                Scanner reader = new Scanner(fr);
                String linea;
                String [] lineaArray;
        // Si al recorrer el arreglo, encuentra la cedula del seleccionado al hacer click
        // se borra toda la linea que contiene esa cedula único  
                while((linea=reader.nextLine())!=null){
                lineaArray = linea.split(",");
                if(lineaArray[0].equals(id)){
                
                // Se toma el ID, que siempre estarán el la posición [0] hacer la modificacion dado
                // y el sistema sólo borra la linea seleccionada.
                    tempArray.remove(
                            id + "," +
                            nombre + "," +
                            apellido + "," +
                            cedula + "," +
                            edad + "," +
                            tipo+ "," +
                            rutaBoleto + "," +
                            origen + "," +
                            destino + "," +
                            fecha + "," +
                            hora + "," +
                            cantidad + "," +
                            costo + "," +
                            descuento + "," +
                            total);
                }else{
                    tempArray.add(linea);
                }
            }
                fr.close();
  
            } catch (Exception e) {
            }
        } catch (Exception e) {
        }
        try {
            try(PrintWriter pr = new PrintWriter(ruta+"\\src\\proyect_persistencia\\boletos.txt"))
            {
               tempArray.forEach((str) -> {
                    pr.println(str);
                });
                pr.close();

            } catch (Exception e) {
            }
        } catch (Exception e) {
       }
     }
}
