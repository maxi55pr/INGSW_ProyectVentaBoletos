package proyect_metodos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
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
import proyect_clases.Usuario;

public class MetodoUsuario {
    
    // Se declara esta variable final que obtendra siempre la ruta de los archivos dentro del directorio del programa
    private final String ruta = System.getProperties().getProperty("user.dir");
    
    Vector vUsuario = new Vector();
    Vector v1 = new Vector();

    public void guardarUsuario(Usuario unUsuario) {
        vUsuario.addElement(unUsuario);
    }

    public void guardarArchivoUsuario(Usuario usuario){
        try {
            FileWriter fw = new FileWriter (".\\Usuario.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.print(usuario.getId_usuario());
            pw.print("|"+usuario.getNombre_usuario());
            pw.print("|"+usuario.getApellido_usuario());
            pw.print("|"+usuario.getUsarname());
            pw.println("|"+usuario.getPassword());
            pw.close();
        } catch (IOException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public DefaultTableModel listaUsuario(){
        Vector cabeceras = new Vector();
        cabeceras.addElement("ID");
        cabeceras.addElement("NOMBRE");
        cabeceras.addElement("APELLIDO");
        cabeceras.addElement("USER");
        cabeceras.addElement("PASSWORD");
        //Crear vector con nombre apellido pasajero cedula edad
        DefaultTableModel mdlTablaU = new DefaultTableModel(cabeceras,0);
        try {
            FileReader fr = new FileReader(".\\Usuario.txt");
            BufferedReader br = new BufferedReader(fr);
            String d;
            while ((d=br.readLine())!=null){
                StringTokenizer dato = new StringTokenizer (d,"|");
                Vector x = new Vector();
                while (dato.hasMoreTokens()){
                    x.addElement(dato.nextToken());
                }
                mdlTablaU.addRow(x);
            }
        }catch (Exception e){
        JOptionPane.showMessageDialog(null, "Estimado usuario: Al momento, no se registran Usuarios existentes.");
        }
        return mdlTablaU;
    }
   
    public Vector BuscarUsuario(String unIdUser){
        try {
            FileReader fr = new FileReader(".\\Usuario.txt");
            BufferedReader br = new BufferedReader(fr);
            String d;
            while ((d=br.readLine())!=null){
                StringTokenizer dato = new StringTokenizer (d,"|");
                Vector x = new Vector();
                while (dato.hasMoreTokens()){
                    x.addElement(dato.nextToken());
                    }
                        String a = x.elementAt(0).toString();
                        if(a.equals(unIdUser)){
                            v1=x;
                            System.out.println(v1);     
                }
            }br.close();
            fr.close();
        }catch (Exception e){
        JOptionPane.showMessageDialog(null, e);
        }       
        return v1;
    }
    
      public void EditarUsuario() {
           
        //FALTA
    }
    
    
    public void EliminarUsuario(String Id, String Nombre, String Apellido, String Usuario, int Password) {
           
        int opcion = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar el USUARIO del sistema?");
        if(opcion == JOptionPane.YES_OPTION){        
             
        
        ArrayList<String> tempArray = new ArrayList<>();
        
        try {
            try (FileReader fr = new FileReader(ruta+"//Usuario.txt"))
            {
                Scanner reader = new Scanner(fr);
                String linea;
                String [] lineaArray;
        // Si al recorrer el arreglo, encuentra el ID seleccionado al hacer click
        // se borra toda la linea que contiene ese ID único  
        
                while((linea=reader.nextLine())!=null){
            
                lineaArray = linea.split(",");
                if(lineaArray[1].equals(Id)){
                
                    tempArray.remove(
                   
                            Id + ", " +
                            Nombre + ", " +
                            Apellido + ", " +
                            Usuario + ", " +
                            Password);
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
            try(PrintWriter pr = new PrintWriter(ruta+"//Usuario.txt"))
                
            {
                for(String str:tempArray) {
                    pr.println(str);
                }
                pr.close();
            } catch (Exception e) {
            }
        } catch (Exception e) {
        }
        }else if(opcion == JOptionPane.NO_OPTION) {
       }
    }
  
}


