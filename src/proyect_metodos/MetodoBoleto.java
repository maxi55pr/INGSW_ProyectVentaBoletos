package proyect_metodos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import proyect_clases.Boleto;
import proyect_clases.Pasajero;
import proyect_clases.Rutas;
import proyect_clases.Usuario;
import proyect_gui.GUI_Principal;
import proyect_gui.GUI_VentaDeBoletos;

public class MetodoBoleto {

    public static String busqueda;
    GUI_VentaDeBoletos ventaBoletos;
    
    public void guardarArchivoBoleto(Pasajero pasajero, Rutas ruta, Boleto boleto){
        
      try {
            FileWriter fw = new FileWriter (".\\boletos.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            
            //Id boleto
            pw.print(boleto.getId_boleto());
            //pasajero
            pw.print(","+pasajero.getNombre_pasajero());
            pw.print(","+pasajero.getApellido_pasajero());
            pw.print(","+pasajero.getCedula_pasajero());
            pw.print(","+pasajero.getEdad_pasajero());
            pw.print(","+pasajero.getTipo_pasajero());
            //ruta
            pw.print(","+ruta.getNombre_Ruta());
            //boleto
            pw.print(","+boleto.getFecha_boleto());
            pw.print(","+boleto.getHora_boleto());
            pw.print(","+boleto.getNumero_boleto());
            pw.print(","+boleto.getCosto_boleto());
            pw.print(","+boleto.getDescuento());
            pw.println(","+boleto.getCosto_total());
            pw.close();
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
        cabeceras.addElement("FECHA");
        cabeceras.addElement("HORA");
        cabeceras.addElement("CANTIDAD");
        cabeceras.addElement("COSTO");
        cabeceras.addElement("DESCUENTO");
        cabeceras.addElement("TOTAL");
        
        //Crear vector
        DefaultTableModel mdlTablaP = new DefaultTableModel(cabeceras,0);
        try {
     
            FileReader fr = new FileReader(".\\boletos.txt");
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
    
}
