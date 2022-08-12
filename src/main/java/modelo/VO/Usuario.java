
package modelo.VO;

public class Usuario {
    private String codigoUsu;
    private String nombreUsu;
    private String passUsu;
    private int tipoUsu;
    private int codAgencia;
    private String nomAgencia;
    private int codPDV;
    private String nomPDV;
    private String codBodega;
    private int statusUsu;

    public Usuario(String codigoUsu, String nombreUsu, String passUsu, int tipoUsu, int codAgencia, String nomAgencia, int codPDV, String nomPDV, String codBodega, int statusUsu) {
        this.codigoUsu = codigoUsu;
        this.nombreUsu = nombreUsu;
        this.passUsu = passUsu;
        this.tipoUsu = tipoUsu;
        this.codAgencia = codAgencia;
        this.nomAgencia = nomAgencia;
        this.codPDV = codPDV;
        this.nomPDV = nomPDV;
        this.codBodega = codBodega;
        this.statusUsu = statusUsu;
    }

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

    public Usuario() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    public int getStatusUsu() {
        return statusUsu;
    }

    public void setStatusUsu(int statusUsu) {
        this.statusUsu = statusUsu;
    }

   

               
    
    
}
