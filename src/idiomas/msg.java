package idiomas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

class msg {

    private static lang currentIdioma;
    static String FilePath;
    static HashMap<String, String> mensajes;

    static File file;

    static void setIdioma(lang e) {
        currentIdioma = e;
        FilePath = "src/txt/" + currentIdioma.name() + ".txt";
        crearArchivo();
        cargaHashMap();
    }
    

    private static boolean cargaHashMap() {
        BufferedReader br = null;
        mensajes = new HashMap<>();
        try {
            br = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = br.readLine()) != null) {
                //divide la linea en :
                String[] parts = line.split(":");

                //obtiene valores de key y valor
                String name = parts[0].trim();
                String value = parts[1].trim();

                //insertar name y value en HashMap
                if (!name.equals("") && !value.equals("")) {
                    mensajes.put(name, value);
                }
                return true;
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        return false;
    }

    private static boolean crearArchivo() {//crea archivode texto si no existe
        file = new File(FilePath);
        try {
            if (!file.exists()) {
                file.createNewFile();
                System.out.println("Creado");
                return true;
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
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
            return false;
        } finally {
            try {
                //always close the writer
                bf.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void agregarMensaje(String key, String mensaje) {
        mensajes.put(key, mensaje);
    }

    public static String verMensaje(String key) {
        if(mensajes.get(key)==null){
            mensajes.put(key, "");
        }
        return mensajes.get(key);
    }
}

class main {

    public static void main(String[] args) {
        msg.setIdioma(lang.en);
        //msg.agregarMensaje("saludo", "Good Morning");

        System.out.println(msg.verMensaje("saludo"));
        //msg.guardaArchivo();
    }
}
