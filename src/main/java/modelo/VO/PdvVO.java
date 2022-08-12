/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.VO;

/**
 *
 * @author gcabr
 */
public class PdvVO {
    private int codAgencia;
    private int codPdv;
    private String nomPdv;
    private String codBodega;
    private int catPdv;

    public PdvVO() {
    }

    public int getCodAgencia() {
        return codAgencia;
    }

    public void setCodAgencia(int codAgencia) {
        this.codAgencia = codAgencia;
    }

    public int getCodPdv() {
        return codPdv;
    }

    public void setCodPdv(int codPdv) {
        this.codPdv = codPdv;
    }

    public String getNomPdv() {
        return nomPdv;
    }

    public void setNomPdv(String nomPdv) {
        this.nomPdv = nomPdv;
    }

    public String getCodBodega() {
        return codBodega;
    }

    public void setCodBodega(String codBodega) {
        this.codBodega = codBodega;
    }

    public int getCatPdv() {
        return catPdv;
    }

    public void setCatPdv(int catPdv) {
        this.catPdv = catPdv;
    }
    
    
    
    
}
