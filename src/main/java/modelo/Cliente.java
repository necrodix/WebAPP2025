package modelo;

public class Cliente {
    private int id;
    private String nombre;
    private String ine;
    private String cartaResponsiva;
    private String referencia;

    public Cliente() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIne() {
        return ine;
    }

    public void setIne(String ine) {
        this.ine = ine;
    }

    public String getCartaResponsiva() {
        return cartaResponsiva;
    }

    public void setCartaResponsiva(String cartaResponsiva) {
        this.cartaResponsiva = cartaResponsiva;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }
}
