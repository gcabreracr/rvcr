
package modelo;

import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;


public class FiltrarTablas {
    DefaultTableModel dm;
    
     public void filtro(String consulta, JTable jtBuscar, int columna) {
        dm = (DefaultTableModel) jtBuscar.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(dm);
        jtBuscar.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter("(?i)"+consulta,columna));  
        
     
    }
    
}
