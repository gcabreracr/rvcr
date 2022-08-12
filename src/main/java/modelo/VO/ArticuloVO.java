package modelo.VO;

public class ArticuloVO {

    private int codigo_art;
    private String nom_lar_art;
    private String nom_cor_art;
    private String uni_med;
    private int codMedida;
    private int codCategoria;
    private String nom_grupo;
    private String cod_barra;
    private boolean esActivo;
    private int tipo_item;
    private String codCabys;

    public ArticuloVO() {
    }

    public int getCodigo_art() {
        return codigo_art;
    }

    public void setCodigo_art(int codigo_art) {
        this.codigo_art = codigo_art;
    }

    public String getNom_lar_art() {
        return nom_lar_art;
    }

    public void setNom_lar_art(String nom_lar_art) {
        this.nom_lar_art = nom_lar_art;
    }

    public String getNom_cor_art() {
        return nom_cor_art;
    }

    public void setNom_cor_art(String nom_cor_art) {
        this.nom_cor_art = nom_cor_art;
    }

    public String getUni_med() {
        return uni_med;
    }

    public void setUni_med(String uni_med) {
        this.uni_med = uni_med;
    }

    public int getCodCategoria() {
        return codCategoria;
    }

    public void setCodCategoria(int codCategoria) {
        this.codCategoria = codCategoria;
    }

    public String getNom_grupo() {
        return nom_grupo;
    }

    public void setNom_grupo(String nom_grupo) {
        this.nom_grupo = nom_grupo;
    }

    public String getCod_barra() {
        return cod_barra;
    }

    public void setCod_barra(String cod_barra) {
        this.cod_barra = cod_barra;
    }

    public boolean getEsActivo() {
        return esActivo;
    }

    public void setEsActivo(boolean esActivo) {
        this.esActivo = esActivo;
    }

    public int getTipo_item() {
        return tipo_item;
    }

    public void setTipo_item(int tipo_item) {
        this.tipo_item = tipo_item;
    }

    public int getCodMedida() {
        return codMedida;
    }

    public void setCodMedida(int codMedida) {
        this.codMedida = codMedida;
    }

    public String getCodCabys() {
        return codCabys;
    }

    public void setCodCabys(String codCabys) {
        this.codCabys = codCabys;
    }

}
