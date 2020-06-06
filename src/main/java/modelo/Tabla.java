package modelo;

import modelo.tareas.Tarea;

import javax.swing.table.AbstractTableModel;
import java.util.Arrays;
import java.util.List;

public class Tabla extends AbstractTableModel {
    final List<String> cabeceras = Arrays.asList("Completado", "Prioridad", "Título");
    List<Tarea> datos;

    public Tabla(final List<Tarea> datos) {
        this.datos = datos;
    }

    public Tabla setDatos(final List<Tarea> datos) {
        this.datos = datos;
        return this;
    }

    public int getRowCount() {
        return datos.size();
    }

    public int getColumnCount() {
        return cabeceras.size();
    }

    public String getValueAt(int fila, int columna) {
        if (columna == 0){
            if (datos.get(fila).getCompletado()){
                return "true";
            }else{
                return "false";
            }
        }
        if (columna == 1){
            return datos.get(fila).getTipoPrioridad();
        }
        if (columna == 2){
            return datos.get(fila).getTitulo();
        }
        else return "";
    }

    public Tarea getTarea(int fila){
        return datos.get(fila);
    }

    @Override
    public String getColumnName(int column) {
        return cabeceras.get(column);
    }
}
