import java.io.BufferedWriter;
import java.io.File;
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
        fileManager = new FileManager();
        fileManager.buscarNivel(usuario);
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
