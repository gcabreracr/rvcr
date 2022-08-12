
package modelo.VO;


public class ItemFacVO {
    
   
    private int cod_articulo;
    private String nom_articulo;
    private int cantidad;
    private double precio;
    private int por_descto;
    private double mon_descto;
    private int por_impto;
    private double mon_impto;
    private double mon_subtotal;
    private int tipoItem;
    private int exento;
    private String codCabys;

    public ItemFacVO() {
    }

    public int getCod_articulo() {
        return cod_articulo;
    }

    public void setCod_articulo(int cod_articulo) {
        this.cod_articulo = cod_articulo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getPor_descto() {
        return por_descto;
    }

    public void setPor_descto(int por_descto) {
        this.por_descto = por_descto;
    }

    public double getMon_descto() {
        return mon_descto;
    }

    public void setMon_descto(double mon_descto) {
        this.mon_descto = mon_descto;
    }

    public int getPor_impto() {
        return por_impto;
    }

    public void setPor_impto(int por_impto) {
        this.por_impto = por_impto;
    }

    public double getMon_impto() {
        return mon_impto;
    }

    public void setMon_impto(double mon_impto) {
        this.mon_impto = mon_impto;
    }

    public double getMon_subtotal() {
        return mon_subtotal;
    }

    public void setMon_subtotal(double mon_subtotal) {
        this.mon_subtotal = mon_subtotal;
    }

    
    public String getNom_articulo() {
        return nom_articulo;
    }

    public void setNom_articulo(String nom_articulo) {
        this.nom_articulo = nom_articulo;
    }

    public int getExento() {
        return exento;
    }

    public void setExento(int exento) {
        this.exento = exento;
    }

    public int getTipoItem() {
        return tipoItem;
    }

    public void setTipoItem(int tipoItem) {
        this.tipoItem = tipoItem;
    }

    public String getCodCabys() {
        return codCabys;
    }

    public void setCodCabys(String codCabys) {
        this.codCabys = codCabys;
    }
    
    
}
