package modelo.VO;

public class FacrturaVO {

    private int num_factura;
    private int cod_agencia;
    private int cod_pdv;
    private String fec_factura;
    private String hora_factura;
    private int cod_cliente;
    private double mon_subtotal;
    private double mon_impto;
    private double mon_descto;
    private String cod_vendedor;
    private String notas;
    private String nom_factura;
    private String id_factura;
    private String tipo_id;
    private String email;
    private String tipo_fac;
    private String tipo_doc;
    private int plazo_fac;

    public FacrturaVO() {
    }

    public int getNum_factura() {
        return num_factura;
    }

    public void setNum_factura(int num_factura) {
        this.num_factura = num_factura;
    }

    public int getCod_agencia() {
        return cod_agencia;
    }

    public void setCod_agencia(int cod_agencia) {
        this.cod_agencia = cod_agencia;
    }

    public int getCod_pdv() {
        return cod_pdv;
    }

    public void setCod_pdv(int cod_pdv) {
        this.cod_pdv = cod_pdv;
    }

    public String getFec_factura() {
        return fec_factura;
    }

    public void setFec_factura(String fec_factura) {
        this.fec_factura = fec_factura;
    }

    public String getHora_factura() {
        return hora_factura;
    }

    public void setHora_factura(String hora_factura) {
        this.hora_factura = hora_factura;
    }

    public int getCod_cliente() {
        return cod_cliente;
    }

    public void setCod_cliente(int cod_cliente) {
        this.cod_cliente = cod_cliente;
    }

    public double getMon_subtotal() {
        return mon_subtotal;
    }

    public void setMon_subtotal(double mon_subtotal) {
        this.mon_subtotal = mon_subtotal;
    }

    public double getMon_impto() {
        return mon_impto;
    }

    public void setMon_impto(double mon_impto) {
        this.mon_impto = mon_impto;
    }

    public double getMon_descto() {
        return mon_descto;
    }

    public void setMon_descto(double mon_descto) {
        this.mon_descto = mon_descto;
    }

    public String getCod_vendedor() {
        return cod_vendedor;
    }

    public void setCod_vendedor(String cod_vendedor) {
        this.cod_vendedor = cod_vendedor;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public String getNom_factura() {
        return nom_factura;
    }

    public void setNom_factura(String nom_factura) {
        this.nom_factura = nom_factura;
    }

    public String getId_factura() {
        return id_factura;
    }

    public void setId_factura(String id_factura) {
        this.id_factura = id_factura;
    }

    public String getTipo_id() {
        return tipo_id;
    }

    public void setTipo_id(String tipo_id) {
        this.tipo_id = tipo_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTipo_fac() {
        return tipo_fac;
    }

    public void setTipo_fac(String tipo_fac) {
        this.tipo_fac = tipo_fac;
    }

    public String getTipo_doc() {
        return tipo_doc;
    }

    public void setTipo_doc(String tipo_doc) {
        this.tipo_doc = tipo_doc;
    }

    public int getPlazo_fac() {
        return plazo_fac;
    }

    public void setPlazo_fac(int plazo_fac) {
        this.plazo_fac = plazo_fac;
    }

}
