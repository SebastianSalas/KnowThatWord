import java.io.*;
import java.util.ArrayList;

public class FileManager {

    private FileReader fileReader;
    private BufferedReader input;
    private FileWriter fileWriter;
    private BufferedWriter output;


    public ArrayList<String> lecturaFile() {
        ArrayList<String> frases = new ArrayList<String>();
        try {
            fileReader = new FileReader("src/files/diccionario.txt");
            input = new BufferedReader(fileReader);
            String line = input.readLine();
            while (line != null) {
                frases.add(line);
                line = input.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return frases;
    }

    /*
        public void buscarUsuario(){
            ArrayList<String> nombreUsuario = new ArrayList<>();
            var = nombreUsuario.contains(line)
            if (var == true){

            }else{
                nombreUsuario.add
            }
        }
        */
    public ArrayList<String> lecturaUsuario() {
        ArrayList<String> Nombres = new ArrayList<>();

        try {
            fileReader = new FileReader("src/files/Usuarios.txt");
            input = new BufferedReader(fileReader);
            String line = input.readLine();
            while (line != null) {
                Nombres.add(line);
                line = input.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return Nombres;
    }

    public void escribirUsuario(String usuario) {
        ArrayList<String> nombreUsuario = new ArrayList<String>();
        nombreUsuario = lecturaUsuario();

        Boolean var = nombreUsuario.contains(usuario);
        if (!(var == true)){
            try {
                fileWriter = new FileWriter("src/files/usuarios.txt", true);
                output = new BufferedWriter(fileWriter);
                output.write(usuario);
                output.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }else{

        }

    }
}
