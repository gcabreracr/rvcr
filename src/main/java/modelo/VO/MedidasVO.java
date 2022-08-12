
package modelo.VO;


public class MedidasVO {
    
    private int codMedida;
    private String desMedida;

    public int getCodMedida() {
        return codMedida;
    }

    public void setCodMedida(int codMedida) {
        this.codMedida = codMedida;
    }

    public String getDesMedida() {
        return desMedida;
    }

    public void setDesMedida(String desMedida) {
        this.desMedida = desMedida;
    }
    
    @Override
    public String toString(){
        return desMedida;
    }
    
}
