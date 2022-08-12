
package modelo.VO;

public class CatArticuloVO {
    private int codCategoria;
    private String desCategoria;

    public int getCodCategoria() {
        return codCategoria;
    }

    public void setCodCategoria(int codCategoria) {
        this.codCategoria = codCategoria;
    }

    public String getDesCategoria() {
        return desCategoria;
    }

    public void setDesCategoria(String desCategoria) {
        this.desCategoria = desCategoria;
    }
    
    @Override
    public String toString(){
        return desCategoria;
    }
    
}
