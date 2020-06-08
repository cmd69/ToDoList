package modelo.serializacion;

import modelo.InterfaceModelo;
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
                if(fichero != null)
                    fichero.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("metodo guardae");
        FileOutputStream fos = new FileOutputStream("src/main/java/Tareas.bin");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(tarea);
        oos.close();
    }

    public static InterfaceModelo serializacionVaciar(String nombreFichero) throws ClassNotFoundException, IOException {
        FileReader fichero = null;
        try {
            try {
                fichero = new FileReader("src/main/java/"+nombreFichero);
            } finally {
                if(fichero != null)
                    fichero.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        FileInputStream fis = new FileInputStream("src/main/java/"+nombreFichero);
        ObjectInputStream ois = new ObjectInputStream(fis);
        InterfaceModelo modelo = (InterfaceModelo) ois.readObject();
        ois.close();
        return modelo;
    }

    public static LinkedList<Tarea> cargarAgenda(String nombreFichero) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("src/main/java/" + nombreFichero);
        ObjectInputStream ois = new ObjectInputStream(fis);

        System.out.println("agenda cargada");
        LinkedList<Tarea> lista = (LinkedList<Tarea>) ois.readObject();
        ois.close();
        return lista;
    }
}
