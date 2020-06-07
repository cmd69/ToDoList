package modelo.serializacion;

import modelo.InterfaceModelo;

import java.io.*;

public class Serializacion {
    public static void serializacionGuardar(InterfaceModelo modelo) throws IOException {
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
        oos.writeObject(modelo);
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
}
