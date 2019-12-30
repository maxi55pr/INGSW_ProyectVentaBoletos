package proyect_metodos;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import proyect_clases.Pasajero;

public class MetodoPasajero {
    
    Vector vPrincipal = new Vector();
        
    // Se declara esta variable final que obtendra siempre la ruta de los archivos dentro del directorio del programa
    private final String ruta = System.getProperties().getProperty("user.dir");
        
    //guarda datos en el vector
    public void guardarPasajero(Pasajero unPasajero) {
        vPrincipal.addElement(unPasajero);
    }
    
    //guardar archivo txt
    public void guardarArchivoPasajero(Pasajero pasajero){
        
        try {
            FileWriter fw = new FileWriter (".\\pasajero.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.print(pasajero.getId_pasajero());
            pw.print(","+pasajero.getNombre_pasajero());
            pw.print(","+pasajero.getApellido_pasajero());
            pw.print(","+pasajero.getCedula_pasajero());
            pw.print(","+pasajero.getEdad_pasajero());
            pw.println(","+pasajero.getTipo_pasajero());
            pw.close();

        } catch (IOException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    //mostrar los datos en el jtable
    public DefaultTableModel listaPasajero() throws FileNotFoundException, IOException{
        
        Vector cabeceras = new Vector();
        
        cabeceras.addElement("ID");
        cabeceras.addElement("NOMBRE");
        cabeceras.addElement("APELLIDO");
        cabeceras.addElement("CEDULA");
        cabeceras.addElement("EDAD");
        cabeceras.addElement("TIPO");
        
        //Crear vector con nombre apellido pasajero cedula edad
        DefaultTableModel mdlTablaP = new DefaultTableModel(cabeceras,0);
        try {
     
            FileReader fr = new FileReader(".\\pasajero.txt");
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
        }catch (IOException e){
        JOptionPane.showMessageDialog(null, "Estimado usuario: Al momento, no se registran pasajeros existentes.");
        }
        return mdlTablaP;
    }
    //-------------------------------------------//
  
    public Vector BuscarPasajero(String cedulaP){
        try {
            FileReader fr = new FileReader(".\\pasajero.txt");
            BufferedReader br = new BufferedReader(fr);
            String d;
            while ((d=br.readLine())!=null){
                StringTokenizer dato = new StringTokenizer (d,",");
                Vector x = new Vector();
                while (dato.hasMoreTokens()){
                    x.addElement(dato.nextToken());
                    }
                        String a = x.elementAt(3).toString();
                        if(a.equals(cedulaP)){
                            
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
    
    public void EditaPasajero(){
    
        //FALTA
    }
    
    public void EliminarPasajero(int Id, String Nombre, String Apellido, String Cedula, String Edad, String Tipo){
    
        int id = Id;
        String nombre = Nombre;
        String apellido = Apellido;
        String cedula = Cedula;
        String edad = Edad;
        String tipo = Tipo;
        
        ArrayList<String> tempArray = new ArrayList<>();
        
        try {
            try (FileReader fr = new FileReader(ruta+"//pasajero.txt"))
            {
                Scanner reader = new Scanner(fr);
                String linea;
                String [] lineaArray;
        // Si al recorrer el arreglo, encuentra la cedula del seleccionado al hacer click
        // se borra toda la linea que contiene esa cedula único  
        
                while((linea=reader.nextLine())!=null){
            
                lineaArray = linea.split(",");
                if(lineaArray[3].equals(cedula)){
                
                // Se toma la CEDULA, que siempre estarán el la posición [3] hacer la modificacion dado
                // y el sistema sólo borra la linea seleccionada.
                    tempArray.remove(
                   
                            
                            id + "," +
                            nombre + "," +
                            apellido + "," +
                            cedula + "," +
                            edad + "," +
                            tipo);
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
            try(PrintWriter pr = new PrintWriter(ruta+"//pasajero.txt"))
                
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
