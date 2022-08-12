
package modelo.VO;

import java.sql.Date;



public class ClienteVO {
    
    private int cod_cliente;
    private String nom_cliente;
    private String nom_tributa;
    private String id_tributa;
    private String tipo_id;
    private String email_cliente;
    private int tipo_neg;
    private String tel_negocio;
    private String nom_contacto;
    private String tel_contacto;
    private String num_pos;
    private int idProvincia;
    private String provincia;
    private int idCanton;
    private String canton;
    private int idDistrito;
    private String distrito;
    private String referencia;
    private int mon_credito;
    private int plazo_credito;
    private int por_descto;
    private boolean vis_lun;
    private boolean vis_mar;
    private boolean vis_mie;
    private boolean vis_jue;
    private boolean vis_vie;
    private boolean vis_sab;
    private boolean vis_dom;
    private double secuencia;
    private int cod_agencia;
    private int cod_ruta;
    private int cat_pdv;
    private boolean status_cli;
    private String fecapertura;
    private String feccamsta;
    private int shareKolbi;
    private int shareMovistar;
    private String codigo_itec;
    private double latitud;
    private double longitud;

    public ClienteVO() {
    }

    public int getCod_cliente() {
        return cod_cliente;
    }

    public void setCod_cliente(int cod_cliente) {
        this.cod_cliente = cod_cliente;
    }

    public String getNom_cliente() {
        return nom_cliente;
    }

    public void setNom_cliente(String nom_cliente) {
        this.nom_cliente = nom_cliente;
    }

    public String getNom_tributa() {
        return nom_tributa;
    }

    public void setNom_tributa(String nom_tributa) {
        this.nom_tributa = nom_tributa;
    }

    public String getId_tributa() {
        return id_tributa;
    }

    public void setId_tributa(String id_tributa) {
        this.id_tributa = id_tributa;
    }

    public String getTipo_id() {
        return tipo_id;
    }

    public void setTipo_id(String tipo_id) {
        this.tipo_id = tipo_id;
    }

    public String getEmail_cliente() {
        return email_cliente;
    }

    public void setEmail_cliente(String email_cliente) {
        this.email_cliente = email_cliente;
    }

    public int getTipo_neg() {
        return tipo_neg;
    }

    public void setTipo_neg(int tipo_neg) {
        this.tipo_neg = tipo_neg;
    }

    public String getTel_negocio() {
        return tel_negocio;
    }

    public void setTel_negocio(String tel_negocio) {
        this.tel_negocio = tel_negocio;
    }

    public String getNom_contacto() {
        return nom_contacto;
    }

    public void setNom_contacto(String nom_contacto) {
        this.nom_contacto = nom_contacto;
    }

    public String getTel_contacto() {
        return tel_contacto;
    }

    public void setTel_contacto(String tel_contacto) {
        this.tel_contacto = tel_contacto;
    }

    public String getNum_pos() {
        return num_pos;
    }

    public void setNum_pos(String num_pos) {
        this.num_pos = num_pos;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCanton() {
        return canton;
    }

    public void setCanton(String canton) {
        this.canton = canton;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public int getMon_credito() {
        return mon_credito;
    }

    public void setMon_credito(int mon_credito) {
        this.mon_credito = mon_credito;
    }

    public int getPlazo_credito() {
        return plazo_credito;
    }

    public void setPlazo_credito(int plazo_credito) {
        this.plazo_credito = plazo_credito;
    }

    public int getPor_descto() {
        return por_descto;
    }

    public void setPor_descto(int por_descto) {
        this.por_descto = por_descto;
    }

    public boolean isVis_lun() {
        return vis_lun;
    }

    public void setVis_lun(boolean vis_lun) {
        this.vis_lun = vis_lun;
    }

    public boolean isVis_mar() {
        return vis_mar;
    }

    public void setVis_mar(boolean vis_mar) {
        this.vis_mar = vis_mar;
    }

    public boolean isVis_mie() {
        return vis_mie;
    }

    public void setVis_mie(boolean vis_mie) {
        this.vis_mie = vis_mie;
    }

    public boolean isVis_jue() {
        return vis_jue;
    }

    public void setVis_jue(boolean vis_jue) {
        this.vis_jue = vis_jue;
    }

    public boolean isVis_vie() {
        return vis_vie;
    }

    public void setVis_vie(boolean vis_vie) {
        this.vis_vie = vis_vie;
    }

    public boolean isVis_sab() {
        return vis_sab;
    }

    public void setVis_sab(boolean vis_sab) {
        this.vis_sab = vis_sab;
    }

    public boolean isVis_dom() {
        return vis_dom;
    }

    public void setVis_dom(boolean vis_dom) {
        this.vis_dom = vis_dom;
    }

    public double getSecuencia() {
        return secuencia;
    }

    public void setSecuencia(double secuencia) {
        this.secuencia = secuencia;
    }

    public int getCod_agencia() {
        return cod_agencia;
    }

    public void setCod_agencia(int cod_agencia) {
        this.cod_agencia = cod_agencia;
    }

    public int getCod_ruta() {
        return cod_ruta;
    }

    public void setCod_ruta(int cod_ruta) {
        this.cod_ruta = cod_ruta;
    }

    public boolean isStatus_cli() {
        return status_cli;
    }

    public void setStatus_cli(boolean status_cli) {
        this.status_cli = status_cli;
    }

    public String getFecapertura() {
        return fecapertura;
    }

    public void setFecapertura(String fecapertura) {
        this.fecapertura = fecapertura;
    }

    public String getFeccamsta() {
        return feccamsta;
    }

    public void setFeccamsta(String feccamsta) {
        this.feccamsta = feccamsta;
    }

    public int getShareKolbi() {
        return shareKolbi;
    }

    public void setShareKolbi(int shareKolbi) {
        this.shareKolbi = shareKolbi;
    }

    public int getShareMovistar() {
        return shareMovistar;
    }

    public void setShareMovistar(int shareMovistar) {
        this.shareMovistar = shareMovistar;
    }

    public String getCodigo_itec() {
        return codigo_itec;
    }

    public void setCodigo_itec(String codigo_itec) {
        this.codigo_itec = codigo_itec;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public int getCat_pdv() {
        return cat_pdv;
    }

    public void setCat_pdv(int cat_pdv) {
        this.cat_pdv = cat_pdv;
    }

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
    
    

      
}
