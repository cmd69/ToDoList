package modelo.tareas;

public class Tarea {
    private String titulo;
    private String descripcion;
    private boolean completado;
    private Prioridad prioridad;

    //ENUM PRIORIDAD
    public enum Prioridad{
        ALTA("Alta", 1),
        MEDIA("Media", 2),
        BAJA("Baja", 3);
        private String tipo;
        private int nivel;

        Prioridad(String tipo, int nivel) {
            this.tipo = tipo;
            this.nivel = nivel;
        }
        public String getPrioridad(){
            return this.tipo;
        }
        public int getNivel(){
            return this.nivel;
        }
    }

    //CONSTRUCTOR
    public Tarea(String titulo, String descripcion, boolean completado, Prioridad prioridad ){
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.completado = completado;
        this.prioridad = prioridad;
    }


    //GETTERS
    public String getDescripcion() {
        return this.descripcion;
    }
    public String getTitulo() {
        return this.titulo;
    }
    public String getTipoPrioridad(){
        return prioridad.tipo;
    }
    public int getNivelPrioridad(){
        return prioridad.nivel;
    }
    public boolean getCompletado(){
        return completado;
    }

    public void setCompletado(boolean b){
        this.completado = b;
    }



}
