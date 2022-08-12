
package modelo.VO;

public class PrecioVO {
    
    private int codigo_art;
    private int cat_pdv;
    private double precio_art;
    private int descto_art;
    private int impto_art;
    private int codTarifa;
    private String desTarifa;
    private int exento;
    private int redondeo;

    public PrecioVO() {
    }

    public int getCodigo_art() {
        return codigo_art;
    }

    public void setCodigo_art(int codigo_art) {
        this.codigo_art = codigo_art;
    }

    public int getCat_pdv() {
        return cat_pdv;
    }

    public void setCat_pdv(int cat_pdv) {
        this.cat_pdv = cat_pdv;
    }

    public double getPrecio_art() {
        return precio_art;
    }

    public void setPrecio_art(double precio_art) {
        this.precio_art = precio_art;
    }

    public int getDescto_art() {
        return descto_art;
    }

    public void setDescto_art(int descto_art) {
        this.descto_art = descto_art;
    }

    public int getImpto_art() {
        return impto_art;
    }

    public void setImpto_art(int impto_art) {
        this.impto_art = impto_art;
    }

    public int getExento() {
        return exento;
    }

    public void setExento(int exento) {
        this.exento = exento;
    }

    public int getRedondeo() {
        return redondeo;
    }

    public void setRedondeo(int redondeo) {
        this.redondeo = redondeo;
    }

    public int getCodTarifa() {
        return codTarifa;
    }

    public void setCodTarifa(int codTarifa) {
        this.codTarifa = codTarifa;
    }

    public String getDesTarifa() {
        return desTarifa;
    }

    public void setDesTarifa(String desTarifa) {
        this.desTarifa = desTarifa;
    }

    
    
    
    
}
