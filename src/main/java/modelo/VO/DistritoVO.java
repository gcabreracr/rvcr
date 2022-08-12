
package modelo.VO;


public class DistritoVO {
    private int idProvincia;
    private int idCanton;
    private int idDistrito;
    private String nomDistrito;

    public int getIdProvincia() {
        return idProvincia;
    }

    public void setIdProvincia(int idProvincia) {
        this.idProvincia = idProvincia;
    }

    public int getIdCanton() {
        return idCanton;
    }

    public void setIdCanton(int idCanton) {
        this.idCanton = idCanton;
    }

    public int getIdDistrito() {
        return idDistrito;
    }

    public void setIdDistrito(int idDistrito) {
        this.idDistrito = idDistrito;
    }

    public String getNomDistrito() {
        return nomDistrito;
    }

    public void setNomDistrito(String nomDistrito) {
        this.nomDistrito = nomDistrito;
    }

    @Override
    public String toString(){
        return this.getNomDistrito();
    }
  
    
}
