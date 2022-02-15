
import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.Random;

public class Diccionario {
    public ArrayList<String> diccionario = new ArrayList<String>();
    private ArrayList<String> palabrasRepetidas = new ArrayList<String>();
    private String pal = new String();


    public Diccionario(){
        FileManager fileManager = new FileManager();
        diccionario= fileManager.lecturaFile();
    }

    public String getFrase(){
        Random aleatorio = new Random();
        pal = diccionario.get(aleatorio.nextInt(diccionario.size()));
        do {
            pal = diccionario.get(aleatorio.nextInt(diccionario.size()));
        }while (palabrasRepetidas.contains(pal));
        palabrasRepetidas.add(pal);
        System.out.println(palabrasRepetidas);
        return pal;
    }
}
