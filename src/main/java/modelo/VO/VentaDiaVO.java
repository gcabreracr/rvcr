
package modelo.VO;

import java.sql.Date;

public class VentaDiaVO {
    
    private int cod_agencia;
    private int cod_pdv;
    private int codigo_art;
    private String nom_lar_art;
    private String nom_cor_art;
    private String fecha_liq;
    private int carga_ini;
    private int recargas;
    private int cant_venta;
    private double monto_liq;
    private boolean estado_liq;

    public VentaDiaVO() {
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

    public int getCodigo_art() {
        return codigo_art;
    }

    public void setCodigo_art(int codigo_art) {
        this.codigo_art = codigo_art;
    }

   
    public int getCarga_ini() {
        return carga_ini;
    }

    public void setCarga_ini(int carga_ini) {
        this.carga_ini = carga_ini;
    }

    public int getRecargas() {
        return recargas;
    }

    public void setRecargas(int recargas) {
        this.recargas = recargas;
    }

    public int getCant_venta() {
        return cant_venta;
    }

    public void setCant_venta(int cant_venta) {
        this.cant_venta = cant_venta;
    }

    public double getMonto_liq() {
        return monto_liq;
    }

    public void setMonto_liq(double monto_liq) {
        this.monto_liq = monto_liq;
    }

    public boolean isEstado_liq() {
        return estado_liq;
    }

    public void setEstado_liq(boolean estado_liq) {
        this.estado_liq = estado_liq;
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

    public String getFecha_liq() {
        return fecha_liq;
    }

    public void setFecha_liq(String fecha_liq) {
        this.fecha_liq = fecha_liq;
    }

    
    
    
    
    
    
}
