
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Diccionario {
  public static ArrayList<String> diccionario = new ArrayList<String>();
  private static ArrayList<String> palabrasRepetidas = new ArrayList<String>();
  private static ArrayList<String> validarPalabras = new ArrayList<String>() ;
  private static ArrayList<String> salidaRepetir = new ArrayList<String>() ;
  private static String pal = new String();
  //private String pal2 = new String();
  private FileManager fileManager;
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
    if(i==0){
      System.out.println(i);
      getFraseCalifi();
      i=i+1;
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


  public boolean verificarPasoNivel(int aciertosp, String usuario) {
    fileManager = new FileManager();
    int nivel=fileManager.buscarNivel(usuario);
    boolean pasoNivel= false;
    switch(nivel){
      case 1: if(aciertosp>7) {
        pasoNivel= true;
      }
        break;
      case 2: if(aciertosp>=14) {
        pasoNivel= true;
      }
        break;
      case 3: if(aciertosp>=19) {
        pasoNivel= true;
      }
        break;
      case 4: if(aciertosp>=24) {
        pasoNivel= true;
      }
        break;
      case 5: if(aciertosp>=28) {
        pasoNivel= true;
      }
        break;
      case 6: if(aciertosp>=34) {
        pasoNivel= true;
      }
        break;
      case 7: if(aciertosp>=45) {
        pasoNivel= true;
      }
        break;
      case 8: if(aciertosp>=54) {
        pasoNivel= true;
      }
        break;
      case 9: if(aciertosp>=67) {
        pasoNivel= true;
      }
        break;
      case 10: if(aciertosp==100) {
        pasoNivel= true;
      }
        break;
    }
    return pasoNivel;
  }

}
