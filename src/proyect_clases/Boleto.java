package proyect_clases;

public class Boleto{
    
    private int     numero_boleto;
    private String  fecha_boleto;
    private String  hora_boleto;
    private Double  costo_boleto;
    private Double descuento;
    private Double costo_total;
    
    public Boleto(){
    
    }

    public Boleto(int numero_boleto, String fecha_boleto, String hora_boleto, Double costo_boleto, Double descuento, Double costo_total) {
        this.numero_boleto = numero_boleto;
        this.fecha_boleto = fecha_boleto;
        this.hora_boleto = hora_boleto;
        this.costo_boleto = costo_boleto;
        this.descuento = descuento;
        this.costo_total = costo_total;
    }

    public int getNumero_boleto() {
        return numero_boleto;
    }

    public void setNumero_boleto(int numero_boleto) {
        this.numero_boleto = numero_boleto;
    }

    public String getFecha_boleto() {
        return fecha_boleto;
    }

    public void setFecha_boleto(String fecha_boleto) {
        this.fecha_boleto = fecha_boleto;
    }

    public String getHora_boleto() {
        return hora_boleto;
    }

    public void setHora_boleto(String hora_boleto) {
        this.hora_boleto = hora_boleto;
    }

    public Double getCosto_boleto() {
        return costo_boleto;
    }

    public void setCosto_boleto(Double costo_boleto) {
        this.costo_boleto = costo_boleto;
    }

    public Double getDescuento() {
        return descuento;
    }

    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }

    public Double getCosto_total() {
        return costo_total;
    }

    public void setCosto_total(Double costo_total) {
        this.costo_total = costo_total;
    }
    
    
 
}
