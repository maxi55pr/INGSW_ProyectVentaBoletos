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
    
   
    public void guardarArchivoBoleto(Pasajero pasajero){
        
      //
        
    }
    
    public DefaultTableModel listaBoleto() throws FileNotFoundException, IOException{
        
        Vector cabeceras = new Vector();
        cabeceras.addElement("NOMBRE");
        cabeceras.addElement("APELLIDO");
        cabeceras.addElement("EDAD");
        cabeceras.addElement("CEDULA");
        cabeceras.addElement("TIPO");
        
        //Crear vector con nombre apellido pasajero cedula edad
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
        JOptionPane.showMessageDialog(null, "Estimado usuario: Al momento, no se registran pasajeros existentes.");
        }
        return mdlTablaP;
    }

    public void BuscarBoleto(Usuario unUsuario){
      
        //
        
    }
    
}
