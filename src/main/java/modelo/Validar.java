
package modelo;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;

public class Validar {
    
    public void soloLetras(JTextField campo ){
        campo.addKeyListener(new KeyAdapter(){
            @Override
            public void keyTyped(KeyEvent e){
                char c=e.getKeyChar();
                if(Character.isDigit(c)){
                    e.consume();
                }                
            }            
        });        
    }
    
    public void soloNumeros(JTextField campo ){
        campo.addKeyListener(new KeyAdapter(){
            @Override
            public void keyTyped(KeyEvent e){
                char c=e.getKeyChar();
                if(!Character.isDigit(c)){
                    e.consume();
                }                
            }            
        });        
    }
    
    public void limitarCaracteres(JTextField campo, int cantidad ){
        campo.addKeyListener(new KeyAdapter(){
            @Override
            public void keyTyped(KeyEvent e){
                char c=e.getKeyChar();
                int tam=campo.getText().length();
                if(tam > cantidad){
                    e.consume();
                }                
            }            
        });        
    }
       
}
