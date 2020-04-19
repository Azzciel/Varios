package idiomas;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

class msg {

    private static lang currentIdioma;
    static String outputFilePath;
    static HashMap<String, String> mensajes;

    static File file;

    static void setIdioma(lang e) {
        currentIdioma = e;
        outputFilePath = "src/txt/" + currentIdioma.name() + ".txt";
        crearArchivo();
        cargaHashMap();
    }

    private static void cargaHashMap() {
        mensajes = new HashMap<>();
        /*implementar lectura de archivo txt
            https://www.javacodeexamples.com/read-text-file-into-hashmap-in-java-example/2333
        */  
    }

    private static boolean crearArchivo() {//crea archivode texto si no existe
        file = new File(outputFilePath);
        try {
            if (!file.exists()) {
                file.createNewFile();
                System.out.println("Creado");
                return true;
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public static boolean guardaArchivo() {//escribe dentro del archivo de texto las variables;
        BufferedWriter bf = null;
        try {
            //create new BufferedWriter for the output file
            bf = new BufferedWriter(new FileWriter(file));
            //iterate map entries
            for (Map.Entry<String, String> entry : mensajes.entrySet()) {
                //put key and value separated by a colon
                bf.write(entry.getKey() + ":" + entry.getValue());
                //new line
                bf.newLine();
            }
            bf.flush();
            return true;
        } catch (IOException e) {
        } finally {
            try {
                //always close the writer
                bf.close();
            } catch (Exception e) {
            }
        }
        return false;
    }

    public static void agregarMensaje(String key, String mensaje) {
        mensajes.put(key, mensaje);
    }

    public static String verMensaje(String key) {
        return mensajes.get(key);
    }
}

class main {

    public static void main(String[] args) {
        msg.setIdioma(lang.en);
        msg.agregarMensaje("saludo", "Good Morning");
        System.out.println(msg.verMensaje("saludo"));

        System.out.println(msg.outputFilePath);
        msg.guardaArchivo();
    }
}
