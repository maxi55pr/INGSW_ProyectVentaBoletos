package proyect_metodos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
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
import proyect_clases.Usuario;
import proyect_gui.GUI_Principal;

public class MetodoBoleto {
    
    Vector vPrincipal = new Vector();
    
    public void crearBoleto(Boleto unBoleto) {
        
        //
        
    }
    
    public void guardarBoleto(Boleto unBoleto) {
        vPrincipal.addElement(unBoleto);
    }
    
   
    public void guardarArchivoBoleto(Boleto boleto){
        
      try {
            FileWriter fw = new FileWriter (".\\Boleto.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.print(boleto.getNumero_boleto());
            pw.print(","+boleto.getFecha_boleto());
            pw.print(","+boleto.getHora_boleto());
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
        
        cabeceras.addElement("NUMERO");
        cabeceras.addElement("COSTO");
        cabeceras.addElement("DESCUENTO");
        cabeceras.addElement("COSTO TOTAL");
        cabeceras.addElement("FECHA");
        cabeceras.addElement("HORA");
        
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

    public void BuscarBoleto(Usuario unUsuario){
      
        //
        
    }
    
}
