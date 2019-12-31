package proyect_metodos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
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
import proyect_clases.Rutas;

public class MetodoRutas {
 
    // Se declara esta variable final que obtendra siempre la ruta de los archivos dentro del directorio del programa
    private final String rutaArchivo = System.getProperties().getProperty("user.dir");
    
    Vector vPrincipal = new Vector();

    //guarda datos en el vector
    public void guardarRutas(Rutas unaRuta) {
        vPrincipal.addElement(unaRuta);
    }
    //guardar archivo txt
    public void guardarArchivoRutas(Rutas ruta){
        try {
            FileWriter fw = new FileWriter (".\\ruta.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.print(ruta.getId_Ruta());
            pw.print(","+ruta.getNombre_Ruta());
            pw.print(","+ruta.getOrigen_Ruta());
            pw.print(","+ruta.getDestino_Ruta());
            pw.print(","+ruta.getCosto_Ruta());
            pw.print(","+ruta.getHora_Ruta());
            pw.println(","+ruta.getFecha_Ruta());
            pw.close();
        } catch (IOException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    //mostrar los datos en el jtable
    
    
    public DefaultTableModel listaRutas() throws FileNotFoundException, IOException{   
        Vector cabeceras = new Vector();
        cabeceras.addElement("ID");
        cabeceras.addElement("RUTA");
        cabeceras.addElement("ORIGEN");
        cabeceras.addElement("DESTINO");
        cabeceras.addElement("COSTO");
        cabeceras.addElement("HORA");
        cabeceras.addElement("FECHA");
        //Crear vector con nombre apellido pasajero cedula edad
        DefaultTableModel mdlTablaR = new DefaultTableModel(cabeceras,0);
        try {
            FileReader fr = new FileReader(".\\ruta.txt");
            BufferedReader br = new BufferedReader(fr);
            String d;
            while ((d=br.readLine())!=null){
                StringTokenizer dato = new StringTokenizer (d,",");
                Vector x = new Vector();
                while (dato.hasMoreTokens()){
                    x.addElement(dato.nextToken());
                }
                mdlTablaR.addRow(x);
            }
        }catch (IOException e){
        JOptionPane.showMessageDialog(null, "Estimado usuario: Al momento, no se registran rutas existentes.");
        }
        return mdlTablaR;
       
    }
   
    public Vector BuscarRuta(String unaRuta){
        try {
            FileReader fr = new FileReader(".\\ruta.txt");
            BufferedReader br = new BufferedReader(fr);
            String d;
            while ((d=br.readLine())!=null){
                StringTokenizer dato = new StringTokenizer (d,",");
                Vector x = new Vector();
                while (dato.hasMoreTokens()){
                    x.addElement(dato.nextToken());
                    }
                        String a = x.elementAt(1).toString();
                        if(a.equals(unaRuta)){
                            vPrincipal=x;
                            System.out.println(vPrincipal);     
                }
            }br.close();
            fr.close();
        }catch (IOException e){
        JOptionPane.showMessageDialog(null, e);
        }       
        return vPrincipal;
    }
    
    public void EditarRutas(String Id, String Ruta, String Costo, String Origen, String Destino, String Fecha, String Hora) {
           
         String id = Id;
        String ruta = Ruta;
        String costo = Costo;
        String origen = Origen;
        String destino = Destino;
        String fecha = Fecha;
        String hora = Hora;

        ArrayList<String> tempArray = new ArrayList<>();
        
        try {
            try (FileReader fr = new FileReader(".\\ruta.txt"))
            {
                Scanner reader = new Scanner(fr);
                String linea;
                String [] lineaArray;
                
                while((linea=reader.nextLine())!=null){
                    
            // Se toma el ID para lograr validar dado que al hacer clicik 
            // ese Empleado será el que entienda el sistema que debe actualizar
            
                lineaArray = linea.split(",");
                if(lineaArray[0].equals(id)){
                    
           // Recorro y agrego en la fila que el sistema entiende que existe el ID
                    tempArray.add(
                            
                            id + "," +
                            ruta + "," +
                            costo + "," +
                            origen + "," +
                            destino + "," +
                            fecha + "," +
                            hora);
                    
                    JOptionPane.showMessageDialog(null, "RUTA modificada correctamente."); 
                    
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
            try(PrintWriter pr = new PrintWriter(".\\ruta.txt")) 
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
    
    
    public void EliminarRuta(String Id, String Ruta,String Origen, String Destino, String Costo, String Hora,String Fecha) {
           
        String id = Id;
        String ruta = Ruta;
        String origen = Origen;
        String destino = Destino;
        String costo = Costo;
        String hora = Hora;
        String fecha = Fecha;

        ArrayList<String> tempArray = new ArrayList<>();
        
        try {
            try (FileReader fr = new FileReader(rutaArchivo+"//ruta.txt"))
            {
                Scanner reader = new Scanner(fr);
                String linea;
                String [] lineaArray;
        // Si al recorrer el arreglo, encuentra el ID seleccionado al hacer click
        // se borra toda la linea que contiene ese ID único  
        
                while((linea=reader.nextLine())!=null){
            
                lineaArray = linea.split(",");
                if(lineaArray[0].equals(id)){
                
                // Se toma la CEDULA, que siempre estarán el la posición [3] hacer la modificacion dado
                // y el sistema sólo borra la linea seleccionada.
                    tempArray.remove(
 
                            id + "," +
                            ruta + "," +
                            origen + "," +
                            destino + "," +
                            costo + "," +
                            hora + "," +
                            fecha);
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
            try(PrintWriter pr = new PrintWriter(rutaArchivo+"//ruta.txt"))
                
            {
                for(String str:tempArray) {
                    pr.println(str);
                }
                pr.close();
            } catch (Exception e) {
            }
        } catch (Exception e) {
        }
        }
        
    }

