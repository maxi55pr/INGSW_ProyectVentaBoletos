package proyect_clases;

public class Pasajero {

    private int  id_pasajero;
    private String  nombre_pasajero;
    private String  apellido_pasajero;
    private int     cedula_pasajero;
    private int     edad_pasajero;
    private String  tipo_pasajero;

    public Pasajero(){
    
    }

    public Pasajero(int id_pasajero, String nombre_pasajero, String apellido_pasajero, int cedula_pasajero, int edad_pasajero, String tipo_pasajero) {
        
        this.id_pasajero        = id_pasajero;
        this.nombre_pasajero    = nombre_pasajero;
        this.apellido_pasajero  = apellido_pasajero;
        this.cedula_pasajero    = cedula_pasajero;
        this.edad_pasajero      = edad_pasajero;
        this.tipo_pasajero      = tipo_pasajero;
 
    }

    public int getId_pasajero() {
        return id_pasajero;
    }

    public void setId_pasajero(int id_pasajero) {
        this.id_pasajero = id_pasajero;
    }
    
    public String getNombre_pasajero() {
        return nombre_pasajero;
    }

    public void setNombre_pasajero(String nombre_pasajero) {
        this.nombre_pasajero = nombre_pasajero;
    }

    public String getApellido_pasajero() {
        return apellido_pasajero;
    }

    public void setApellido_pasajero(String apellido_pasajero) {
        this.apellido_pasajero = apellido_pasajero;
    }

    public String getTipo_pasajero() {
        return tipo_pasajero;
    }

    public void setTipo_pasajero(String tipo_pasajero) {
        this.tipo_pasajero = tipo_pasajero;
    }

    public int getCedula_pasajero() {
        return cedula_pasajero;
    }

    public void setCedula_pasajero(int cedula_pasajero) {
        this.cedula_pasajero = cedula_pasajero;
    }

    public int getEdad_pasajero() {
        return edad_pasajero;
    }

    public void setEdad_pasajero(int edad_pasajero) {
        this.edad_pasajero = edad_pasajero;
    }
    
}

