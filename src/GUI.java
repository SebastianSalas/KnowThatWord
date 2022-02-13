import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * This class is used for ...
 * @autor Jhon Alexander Valencia Hilamo jhon.hilamo@correounivalle.edu.co
 * @author Janiert Sebastian Salas Castillo janiert.salas@correounivalle.edu.co
 * @version v.1.0.0 date:21/11/2021
 */

// PROBANDO PEPITA XDDDDD

public class GUI extends JFrame {

    private Header headerProject;
    private PanelFrase frase;
    private FileManager fileManager;
    private String nombreUsario;


    /**
     * Constructor of GUI class
     */
    public GUI() throws IOException {
        initGUI();

        //Default JFrame configuration
        this.setTitle("The Title app");
        this.setSize(200,100);
        //this.pack();
        this.setResizable(true);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * This method is used to set up the default JComponent Configuration,
     * create Listener and control Objects used for the GUI class
     */
    private void initGUI() {
        //Set up JFrame Container's Layout
        //Create Listener Object and Control Object
        //Set up JComponents
        fileManager = new FileManager();
        nombreUsario=JOptionPane.showInputDialog("Ingrese su usuario");
        fileManager.escribirUsuario(nombreUsario);
        headerProject = new Header("I Kno That Word", Color.BLACK);
        this.add(headerProject,BorderLayout.NORTH);
        frase = new PanelFrase();
        frase.setFocusable(true);
        add(frase,BorderLayout.NORTH);

         //Change this line if you change JFrame Container's Layout
    }

    /**
     * Main process of the Java program
     * @param args Object used in order to send input data from command line when
     *             the program is execute by console.
     */
    public static void main(String[] args){

        EventQueue.invokeLater(() -> {
            try {
                GUI miProjectGUI = new GUI();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * inner class that extends an Adapter Class or implements Listeners used by GUI class
     */
    private class Escucha {

    }
}
