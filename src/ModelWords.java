import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ModelWords {
    private static int aciertos;
    private int nivel;
    private FileManager fileManager;


    public boolean verificarGanar(int aciertos){
        boolean pasarLvl=false;
        //nivel= fileManager.buscarNivel();
        return pasarLvl;
    }

    public boolean verificarPasoNivel(int aciertosp, String usuario) {
        nivel=fileManager.buscarNivel(usuario);
        boolean pasoNivel= false;
        switch(nivel){
            case 1: if(aciertos>7) {
                pasoNivel= true;
            }
                break;
            case 2: if(aciertos>=14) {
                pasoNivel= true;
            }
                break;
            case 3: if(aciertos>=19) {
                pasoNivel= true;
            }
                break;
            case 4: if(aciertos>=24) {
                pasoNivel= true;
            }
                break;
            case 5: if(aciertos>=28) {
                pasoNivel= true;
            }
                break;
            case 6: if(aciertos>=34) {
                pasoNivel= true;
            }
                break;
            case 7: if(aciertos>=45) {
                pasoNivel= true;
            }
                break;
            case 8: if(aciertos>=54) {
                pasoNivel= true;
            }
                break;
            case 9: if(aciertos>=67) {
                pasoNivel= true;
            }
                break;
            case 10: if(aciertos==100) {
                pasoNivel= true;
            }
                break;
        }
        return pasoNivel;
    }


}
