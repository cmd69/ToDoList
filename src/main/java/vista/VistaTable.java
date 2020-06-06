package vista;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;

public class VistaTable extends JTable {
    public VistaTable(AbstractTableModel Tabla){
        super(Tabla);
        setAutoCreateRowSorter(true);
    }
}
