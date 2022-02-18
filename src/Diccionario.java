
import java.util.ArrayList;
import java.util.Random;

public class Diccionario {
    public ArrayList<String> diccionario = new ArrayList<String>();
    private ArrayList<String> palabrasRepetidas = new ArrayList<String>();
    private ArrayList<String> palabrasCalificar = new ArrayList<String>();
    private ArrayList<String> palabrasCalificar2 = new ArrayList<String>();
    private String pal = new String();
    //private String pal2 = new String();
    private String pal3 = new String();


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

    public String getFrasenuevas(){
        Random aleatorio= new Random();

        pal=diccionario.get(aleatorio.nextInt(diccionario.size()));
        return pal;

    }

    public void getFrasesCalificar(){
        Random aleatorio = new Random();
        String pal2;
        //System.out.println(palabrasRepetidas);
        palabrasCalificar=palabrasRepetidas;
        int tam=palabrasRepetidas.size();
        for(int i=0;i<tam;i++){
            do{
                pal2=getFrasenuevas();
            }while (palabrasRepetidas.contains(pal2));
            palabrasCalificar.add(pal2);
        }
        System.out.println(palabrasCalificar);
        /*pal = diccionario.get(aleatorio.nextInt(diccionario.size()));
        pal2 = palabrasRepetidas.get(aleatorio.nextInt(palabrasRepetidas.size()));
        //pal3 = palabrasCalificar.get(aleatorio.nextInt(palabrasCalificar.size()));
        do{
            pal = diccionario.get(aleatorio.nextInt(diccionario.size()));
            pal2 = palabrasRepetidas.get(aleatorio.nextInt(palabrasRepetidas.size()));
        }while (palabrasCalificar.contains(pal)|palabrasCalificar.contains(pal2));

        palabrasCalificar.add(pal2);
        palabrasCalificar.add(pal);
        //System.out.println(palabrasCalificar);

        */
    }

    public String getFrasesCal(int i){
        Random aleatorio= new Random();
        if (i<=0) {
            getFrasesCalificar();
        }
        pal3 = palabrasCalificar.get(aleatorio.nextInt(palabrasCalificar.size()));
        do {
            pal3 = palabrasCalificar.get(aleatorio.nextInt(palabrasCalificar.size()));
        }while (palabrasCalificar2.contains(pal3));
        palabrasCalificar2.add(pal3);
        System.out.println(palabrasCalificar2);
        return pal3;
    }
}
