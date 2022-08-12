
package modelo.VO;

public class UsuarioVO {
    private String codigoUsu;
    private String nombreUsu;
    private String passUsu;
    private int tipoUsu;
    private int codAgencia;
    private String nomAgencia;
    private int codPDV;
    private int catPDV;
    private String nomPDV;
    private String codBodega;
    private boolean statusUsu;

    

    public String getNomAgencia() {
        return nomAgencia;
    }

    public void setNomAgencia(String nomAgencia) {
        this.nomAgencia = nomAgencia;
    }

    public String getNomPDV() {
        return nomPDV;
    }

    public void setNomPDV(String nomPDV) {
        this.nomPDV = nomPDV;
    }

    public UsuarioVO() {
       
    }

    public String getCodigoUsu() {
        return codigoUsu;
    }

    public void setCodigoUsu(String codigoUsu) {
        this.codigoUsu = codigoUsu;
    }

    public String getNombreUsu() {
        return nombreUsu;
    }

    public void setNombreUsu(String nombreUsu) {
        this.nombreUsu = nombreUsu;
    }

    public String getPassUsu() {
        return passUsu;
    }

    public void setPassUsu(String passUsu) {
        this.passUsu = passUsu;
    }

    public int getTipoUsu() {
        return tipoUsu;
    }

    public void setTipoUsu(int tipoUsu) {
        this.tipoUsu = tipoUsu;
    }

    public int getCodAgencia() {
        return codAgencia;
    }

    public void setCodAgencia(int codAgencia) {
        this.codAgencia = codAgencia;
    }

    public int getCodPDV() {
        return codPDV;
    }

    public void setCodPDV(int codPDV) {
        this.codPDV = codPDV;
    }

    public String getCodBodega() {
        return codBodega;
    }

    public void setCodBodega(String codBodega) {
        this.codBodega = codBodega;
    }

    public boolean getStatusUsu() {
        return statusUsu;
    }

    public void setStatusUsu(boolean statusUsu) {
        this.statusUsu = statusUsu;
    }

    public int getCatPDV() {
        return catPDV;
    }

    public void setCatPDV(int catPDV) {
        this.catPDV = catPDV;
    }

              
    
    
}
