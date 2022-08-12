
package modelo.VO;


public class CantonVO {
    private int idProvincia;
    private int idCanton;
    private String nomCanton;

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

    public String getNomCanton() {
        return nomCanton;
    }

    public void setNomCanton(String nomCanton) {
        this.nomCanton = nomCanton;
    }

    @Override
    public String toString(){
        return this.getNomCanton();
    }
    
}
