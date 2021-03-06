import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

  private FileReader fileReader;
  private BufferedReader input;
  private FileWriter fileWriter;
  private BufferedWriter output;
  private FileWriter fileWriter2;
  private BufferedWriter output2;


  /**
   * @return all words saved.
   */
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

  /**
   * @return all registered users.
   */
  public ArrayList<String> lecturaUsuario() {
    ArrayList<String> Nombres = new ArrayList<>();

    try {
      fileReader = new FileReader("src/files/usuarios.txt");
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

  /**
   * @param usuario name of user
   * @return true if user exists, false if user not exists.
   */

  public boolean buscarUsuario(String usuario) {
    ArrayList<String> nombreUsuario = new ArrayList<>();
    nombreUsuario = lecturaUsuario();
    for (String e :
            nombreUsuario) {
      if (e.substring(1).equals(usuario)) {
        return true;

      } else if (e.substring(2).equals(usuario)) {
        return true;
      }
    }
    return false;
  }

  /**
   * @param usuario saves the user if not exists.
   */

  public void escribirUsuario(String usuario) {

    Boolean var = buscarUsuario(usuario);
    if (!(var == true)) {
      try {
        fileWriter = new FileWriter("src/files/usuarios.txt", true);
        output = new BufferedWriter(fileWriter);
        output.write("1" + usuario);
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
    } else {

    }

  }

  /**
   * @param usuario
   * @return level of user
   */

  public int buscarNivel(String usuario) {
    ArrayList<String> nombreUsuario = new ArrayList<>();
    nombreUsuario = lecturaUsuario();
    int nivel = 1;

    for (String e : nombreUsuario) {
      if (e.substring(1).equals(usuario)) {
        nivel = Integer.valueOf(e.substring(0, 1));
      } else if (e.substring(2).equals(usuario)) {
        nivel = Integer.valueOf(e.substring(0, 2));
      }
    }
    return nivel;
  }

  /**
   * @param usuario modifies the level of user when level up.
   */
  public void modificarNivel(String usuario) {
    Integer nivel = buscarNivel(usuario);
    ArrayList<String> nombreUsuario = new ArrayList<>();
    nombreUsuario = lecturaUsuario();
    String antes = nivel.toString();
    if (nivel == 10) {
    } else {
      nivel++;
      try {
        fileWriter2 = new FileWriter("src/files/usuarios.txt", false);
        output2 = new BufferedWriter(fileWriter2);
        output2.write("");
        output2.close();
        for (String e :
                nombreUsuario) {
          fileWriter = new FileWriter("src/files/usuarios.txt", true);
          output = new BufferedWriter(fileWriter);
          if (e.substring(1).equals(usuario)) {
            output.write(e.replace(antes, nivel.toString()));
            output.newLine();
            output.close();
          } else {
            output.write(e);
            output.newLine();
            output.close();
          }

        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

}
