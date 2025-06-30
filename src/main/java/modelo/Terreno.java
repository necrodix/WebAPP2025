package modelo;

public class Terreno {
    private int id;
    private boolean pasto;

    // Campos de inmueble
    private String direccion;
    private String zona;
    private double precio;

    public Terreno() {}

    // Getters y setters para id y pasto
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public boolean isPasto() { return pasto; }
    public void setPasto(boolean pasto) { this.pasto = pasto; }

    // Getters y setters para campos de inmueble
    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public String getZona() { return zona; }
    public void setZona(String zona) { this.zona = zona; }

    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }
}
