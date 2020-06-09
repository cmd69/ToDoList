package modelo.serializacion;

import modelo.tareas.Tarea;

import java.io.*;
import java.util.LinkedList;

public class Serializacion implements Serializable {

    public static void serializacionGuardar(LinkedList<Tarea> tarea) throws IOException {
        FileReader fichero = null;
        try {
            try {
                fichero = new FileReader("src/main/java/Tareas.bin");
            } finally {
                if(fichero != null){
                    fichero.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        FileOutputStream fos = new FileOutputStream("src/main/java/Tareas.bin");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(tarea);
        oos.close();
    }

    public static LinkedList<Tarea> cargarAgenda(String nombreFichero) throws IOException, ClassNotFoundException {
        LinkedList<Tarea> lista = new LinkedList<>();
        try {
            FileInputStream fis = new FileInputStream("src/main/java/" + nombreFichero);
            ObjectInputStream ois = new ObjectInputStream(fis);
            lista = (LinkedList<Tarea>) ois.readObject();
            ois.close();
            return lista;
        }catch (FileNotFoundException ex){
            File file = new File("src/main/java/"+nombreFichero);
            return lista;
        }
    }
}
