package modelo;

public class Local {
    private int id;
    private int m2;
    private boolean instalacionesElectricas;
    private boolean bodega;

    public Local() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getM2() {
        return m2;
    }

    public void setM2(int m2) {
        this.m2 = m2;
    }

    public boolean isInstalacionesElectricas() {
        return instalacionesElectricas;
    }

    public void setInstalacionesElectricas(boolean instalacionesElectricas) {
        this.instalacionesElectricas = instalacionesElectricas;
    }

    public boolean isBodega() {
        return bodega;
    }

    public void setBodega(boolean bodega) {
        this.bodega = bodega;
    }
}
