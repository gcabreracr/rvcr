
package modelo.VO;

public class TarifasVO {
    
    private int codTarifa;
    private String desTarifa;
    private double porTarifa;

    public int getCodTarifa() {
        return codTarifa;
    }

    public void setCodTarifa(int codTarifa) {
        this.codTarifa = codTarifa;
    }

    public String getDesTarifa() {
        return desTarifa;
    }

    public void setDesTarifa(String desTarifa) {
        this.desTarifa = desTarifa;
    }

    public double getPorTarifa() {
        return porTarifa;
    }

    public void setPorTarifa(double porTarifa) {
        this.porTarifa = porTarifa;
    }
    
    @Override
    public String toString(){
        return desTarifa;
    }
    
}
