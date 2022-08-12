package modelo.VO;

public class ProvinciaVO {

    private int idProvincia;
    private String nomProvincia;

    public int getIdProvincia() {
        return idProvincia;
    }

    public void setIdProvincia(int idProvincia) {
        this.idProvincia = idProvincia;
    }

    public String getNomProvincia() {
        return nomProvincia;
    }

    public void setNomProvincia(String nomProvincia) {
        this.nomProvincia = nomProvincia;
    }
    
    @Override
    public String toString(){
        return this.getNomProvincia();
    }
}
