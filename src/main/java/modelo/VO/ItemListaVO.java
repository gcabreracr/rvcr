
package modelo.VO;


public class ItemListaVO {
    
    private int codigo_art;
    private String nombre_art;
    private double precio_art;
    private String codTarifa;
    private int impto_art;
    private int redondeo;
    private int exento;

    public ItemListaVO() {
    }

    public int getCodigo_art() {
        return codigo_art;
    }

    public void setCodigo_art(int codigo_art) {
        this.codigo_art = codigo_art;
    }

    public String getNombre_art() {
        return nombre_art;
    }

    public void setNombre_art(String nombre_art) {
        this.nombre_art = nombre_art;
    }

    public double getPrecio_art() {
        return precio_art;
    }

    public void setPrecio_art(double precio_art) {
        this.precio_art = precio_art;
    }

    public int getImpto_art() {
        return impto_art;
    }

    public void setImpto_art(int impto_art) {
        this.impto_art = impto_art;
    }

    public int getRedondeo() {
        return redondeo;
    }

    public void setRedondeo(int redondeo) {
        this.redondeo = redondeo;
    }

    public int getExento() {
        return exento;
    }

    public void setExento(int exento) {
        this.exento = exento;
    }

    public String getCodTarifa() {
        return codTarifa;
    }

    public void setCodTarifa(String codTarifa) {
        this.codTarifa = codTarifa;
    }
    
    
    
}
