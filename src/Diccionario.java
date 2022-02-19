
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Diccionario {
  public static ArrayList<String> diccionario = new ArrayList<String>();
  private static ArrayList<String> palabrasRepetidas = new ArrayList<String>();
  private static ArrayList<String> validarPalabras = new ArrayList<String>();
  private static ArrayList<String> salidaRepetir = new ArrayList<String>();
  private static String pal = new String();
  private static int i = 0;


  /**
   * declare diccionario, diccionario is an arraylist of all words that can be displayed on the screen
   */
  public Diccionario() {
    FileManager fileManager = new FileManager();
    diccionario = fileManager.lecturaFile();
  }

  /**
   * @return words selected to memorize.
   */
  public static String getFrase() {
    Random aleatorio = new Random();
    pal = diccionario.get(aleatorio.nextInt(diccionario.size()));
    do {
      pal = diccionario.get(aleatorio.nextInt(diccionario.size()));
    } while (palabrasRepetidas.contains(pal));
    palabrasRepetidas.add(pal);
    return pal;
  }

  /**
   * @return an disordered arraylist with the words to memorize and more incorrect words.
   */

  public static ArrayList getFraseCalifi() {
    Random aleatorio = new Random();
    validarPalabras = (ArrayList<String>) palabrasRepetidas.clone();
    int palabras = validarPalabras.size() * 2;
    while (validarPalabras.size() < palabras) {
      do {
        pal = diccionario.get(aleatorio.nextInt(diccionario.size()));
      } while (validarPalabras.contains(pal));
      validarPalabras.add(pal);
    }
    Collections.shuffle(validarPalabras);
    return validarPalabras;


  }

  /**
   * @return word that will be displayed on the screen.
   */
  public static String setFrase() {
    Random aleatorio = new Random();
    if (i == 0) {
      getFraseCalifi();
      i++;
    }
    pal = validarPalabras.get(aleatorio.nextInt(validarPalabras.size()));
    do {
      pal = validarPalabras.get(aleatorio.nextInt(validarPalabras.size()));
    } while (salidaRepetir.contains(pal));
    salidaRepetir.add(pal);
    return pal;
  }


  /**
   * compare if the word displayed is correct or not.
   *
   * @return true if the word has been displayed
   * @return false if the word hasn't been displayed.
   */
  public static boolean comparar() {
    boolean esCorrecta;
    if (palabrasRepetidas.contains(pal)) {
      esCorrecta = true;
    } else {
      esCorrecta = false;
    }
    return esCorrecta;
  }

  /**
   * clear all methods to continue with another round.
   */
  public static void clearMethod() {
    palabrasRepetidas.clear();
    validarPalabras.clear();
    salidaRepetir.clear();
    i = 0;
  }

}
