
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Diccionario {
  public static ArrayList<String> diccionario = new ArrayList<String>();
  private static ArrayList<String> palabrasRepetidas = new ArrayList<String>();
  private static ArrayList<String> validarPalabras = new ArrayList<String>() ;
  private static ArrayList<String> salidaRepetir = new ArrayList<String>() ;
  private static String pal = new String();
  private FileManager fileManager;
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
    System.out.println("getFraseCalifi: "+ validarPalabras);
    int palabras = validarPalabras.size()*2;
    while (validarPalabras.size()<palabras) {
      do {
        pal = diccionario.get(aleatorio.nextInt(diccionario.size()));
      } while (validarPalabras.contains(pal));
      validarPalabras.add(pal);
    }
    Collections.shuffle(validarPalabras);
    return validarPalabras;


  }

  public static String setFrase(){
    Random aleatorio = new Random();
    System.out.println("Arreglo de palabras q se muestra: "+validarPalabras);
    System.out.println("Arreglo de palabras para que no se repitan: "+salidaRepetir);
    if(i==0){
      System.out.println("si se muestra esta chimbada? "+i);
      System.out.println("método : "+getFraseCalifi());
      i++;
    }
    pal = validarPalabras.get(aleatorio.nextInt(validarPalabras.size()));
    do {
      pal = validarPalabras.get(aleatorio.nextInt(validarPalabras.size()));
    }while(salidaRepetir.contains(pal));
    salidaRepetir.add(pal);
    System.out.println("Palabra que se muestra: "+pal);
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

  public static void clearMethod(){
    palabrasRepetidas.clear();
    validarPalabras.clear();
    salidaRepetir.clear();
    i=0;
  }

}
