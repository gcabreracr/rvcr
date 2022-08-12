
package modelo.VO;


public class ItemCompraVO {
    
    private String nomItem;
    private int cantidad;
    private int tipoItem;
    private double subTotItem;
    private double totDesctoItem;
    private int porImptoItem;
    private double totImptoItem;
    private int exento;
    private double precioItem;
    private String codigoCabys;

    public ItemCompraVO() {
    }

    public String getNomItem() {
        return nomItem;
    }

    public void setNomItem(String nomItem) {
        this.nomItem = nomItem;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getTipoItem() {
        return tipoItem;
    }

    public void setTipoItem(int tipoItem) {
        this.tipoItem = tipoItem;
    }

    public double getSubTotItem() {
        return subTotItem;
    }

    public void setSubTotItem(double subTotItem) {
        this.subTotItem = subTotItem;
    }

    public double getTotDesctoItem() {
        return totDesctoItem;
    }

    public void setTotDesctoItem(double totDesctoItem) {
        this.totDesctoItem = totDesctoItem;
    }

    public double getTotImptoItem() {
        return totImptoItem;
    }

    public void setTotImptoItem(double totImptoItem) {
        this.totImptoItem = totImptoItem;
    }

    public int getExento() {
        return exento;
    }

    public void setExento(int exento) {
        this.exento = exento;
    }

    public double getPrecioItem() {
        return precioItem;
    }

    public void setPrecioItem(double precioItem) {
        this.precioItem = precioItem;
    }

    public int getPorImptoItem() {
        return porImptoItem;
    }

    public void setPorImptoItem(int porImptoItem) {
        this.porImptoItem = porImptoItem;
    }

    public String getCodigoCabys() {
        return codigoCabys;
    }

    public void setCodigoCabys(String codigoCabys) {
        this.codigoCabys = codigoCabys;
    }
    
    
    
}
