
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Diccionario {
  public static ArrayList<String> diccionario = new ArrayList<String>();
  private static ArrayList<String> palabrasRepetidas = new ArrayList<String>();
  private static ArrayList<String> validarPalabras = new ArrayList<String>() ;
  private static String pal = new String();
  //private String pal2 = new String();
  private static String pal3 = new String();
  private static int i=0;


  public Diccionario(){
    FileManager fileManager = new FileManager();
    diccionario= fileManager.lecturaFile();
  }

  public static String getFrase(){
    Random aleatorio = new Random();
    pal = diccionario.get(aleatorio.nextInt(diccionario.size()));
    do {
      pal = diccionario.get(aleatorio.nextInt(diccionario.size()));
    }while (palabrasRepetidas.contains(pal));
    palabrasRepetidas.add(pal);
    System.out.println(palabrasRepetidas);
    return pal;
  }

  public static ArrayList  getFraseCalifi(){
    Random aleatorio = new Random();
    validarPalabras=(ArrayList<String>)palabrasRepetidas.clone();
    while (validarPalabras.size()<20) {
      do {
        pal = diccionario.get(aleatorio.nextInt(diccionario.size()));
      } while (validarPalabras.contains(pal));
      validarPalabras.add(pal);
    }
    Collections.shuffle(validarPalabras);
    System.out.println("Arreglo de palabras"+validarPalabras);
    return validarPalabras;

  }

  public static String setFrase(){
    Random aleatorio = new Random();
    if(i==0){
      System.out.println(i);
      getFraseCalifi();
      i=i+1;
    }

    System.out.println("arreglo de frase "+validarPalabras);
    pal = validarPalabras.get(aleatorio.nextInt(validarPalabras.size()));
    return pal;
  }


  public static boolean comparar() {
    boolean esCorrecta;
    //System.out.println("comparar please"+palabrasRepetidas);
    if (palabrasRepetidas.contains(pal)){
      esCorrecta= true;
    }else{
      esCorrecta= false;
    }
    return esCorrecta;
  }


}
