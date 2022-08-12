package metodos;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;

public class ValidaCampos {

    public static boolean soloLetras(Character c) {
        if (!Character.isDigit(c)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean soloNumeros(Character c) {

        if (Character.isDigit(c)) {
            return true;
        }else{
            return false;
        }

    }

    public void limitarCaracteres(JTextField campo, int cantidad) {
        campo.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                int tam = campo.getText().length();
                if (tam > cantidad) {
                    e.consume();
                }
            }
        });
    }

}
