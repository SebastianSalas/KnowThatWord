import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Random;

/**
 * This class is used to display all possible actions of the program.
 *
 * @author Janiert Sebastian Salas Castillo janiert.salas@correounivalle.edu.co
 * @author Jhon Alexander Valencia Hilamo jhon.hilamo@correounivalle.edu.co
 * @version v.2.3.0 date:18/02/2022
 */


public class GUI extends JFrame {

  private Header headerProject;
  private PanelFrase frase;
  private JPanel botoncitos, arriba;
  private FileManager fileManager;
  public static String nombreUsario, p = "";
  private ImageIcon fondos;
  private JLabel textoUsuario, aciertos, errores;
  private JButton salir, jugar, bien, mal, ayuda;
  private Escucha escucha;
  private Timer timer, iniciar, verificar;
  private Diccionario palabra = new Diccionario();
  public int nivel, palabras, ver, palabras2;
  private String MENSAJE_INICIO = "I Know That Word es un juego que probara tu memoria.\n" +
          "Te presentaremos un numero aleatorio de palabras, las cuales tendrás 5 segundos en pantalla por cada una." + "\n" + "Luego, te presentaremos un listado con el doble de palabras que se mostraron y por cada palabra debes indicar,\n" +
          "si la palabra estaba o no en las palabras que te mostramos anteriormente, solo tendras 7 segundos por " +
          "palabra.\n" +
          "Pasaras el nivel cuando validemos que cumpliste con el porcentaje de aciertos requeridos.\n" + "\n" +
          "Contara como acierto si seleccionas SI y la palabra estaba contenida o si seleccionas NO y la palabra no " +
          "estaba contenida.\n" +
          "Contara como error si seleccionas SI y la palabra no estaba contenida o si seleccionas NO y la palabra si " +
          "estaba contenida.";

  /**
   * Constructor of GUI class
   */
  public GUI() throws IOException {
    initGUI();
    this.setUndecorated(true);


    //Default JFrame configuration
    this.setTitle("I Know That Word");
    this.setSize(650, 500);
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
    escucha = new Escucha();
    fileManager = new FileManager();
    nombreUsario = JOptionPane.showInputDialog("Ingrese su usuario");
    fileManager.escribirUsuario(nombreUsario);
    nivel = fileManager.buscarNivel(nombreUsario);

    frase = new PanelFrase();
    frase.setFocusable(true);
    add(frase, BorderLayout.CENTER);

    arriba = new JPanel();
    arriba.setBackground(Color.CYAN);
    textoUsuario = new JLabel();
    textoUsuario.setText("Usuario: " + nombreUsario + "         " + " Nivel: " + fileManager.buscarNivel(nombreUsario));
    textoUsuario.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
    textoUsuario.setForeground(new Color(0, 0, 0));
    arriba.add(textoUsuario);
    add(arriba, BorderLayout.PAGE_START);

    botoncitos = new JPanel();
    botoncitos.setBackground(Color.CYAN);
    aciertos = new JLabel();
    errores = new JLabel();
    aciertos.setText("Aciertos: ");
    errores.setText("Errores: ");
    jugar = new JButton("Jugar");
    bien = new JButton("Si");
    bien.setEnabled(false);
    mal = new JButton("No");
    mal.setEnabled(false);
    salir = new JButton();
    ImageIcon img1 = new ImageIcon("src/resources/power.png");
    salir.setIcon(img1);
    salir.setBorderPainted(false);
    salir.setContentAreaFilled(false);
    salir.setFocusable(false);
    salir.addActionListener(escucha);
    ayuda = new JButton();
    ImageIcon img2 = new ImageIcon("src/resources/question.png");
    ayuda.setIcon(img2);
    ayuda.setBorderPainted(false);
    ayuda.setContentAreaFilled(false);
    ayuda.setFocusable(false);
    ayuda.addActionListener(escucha);
    botoncitos.add(ayuda);
    botoncitos.add(aciertos);
    botoncitos.add(bien);
    botoncitos.add(jugar);
    botoncitos.add(mal);
    botoncitos.add(errores);
    botoncitos.add(salir);
    bien.addActionListener(escucha);
    mal.addActionListener(escucha);
    jugar.addActionListener(escucha);
    add(botoncitos, BorderLayout.PAGE_END);

    iniciar = new Timer(5000, escucha);
    verificar = new Timer(7000, escucha);
    verificar.stop();


    //Change this line if you change JFrame Container's Layout
  }

  /**
   * Main process of the Java program
   *
   * @param args Object used in order to send input data from command line when
   *             the program is execute by console.
   */
  public static void main(String[] args) {

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
  private class Escucha implements ActionListener {
    private int counter, centinela, counter2 = 0, errores, aciertos, c3, aciertosp;
    private Random random;

    public Escucha() {
      random = new Random();
      counter = 0;
      centinela = 1;
      errores = 0;
      aciertos = 0;
      ver = 0;
      c3 = 0;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

      if (e.getSource() == jugar) {
        nivel = fileManager.buscarNivel(nombreUsario);
        iniciar.start();
        verificar.stop();
        jugar.setEnabled(false);
        ver = 1;
        counter = 0;
        switch (nivel) {
          case 1:
            palabras = 10;
            palabras2 = 20;
            aciertosp = (70 * palabras) / 100;
            break;
          case 2:
            palabras = 20;
            palabras2 = 40;
            aciertosp = (70 * palabras) / 100;
            break;
          case 3:
            palabras = 25;
            palabras2 = 50;
            aciertosp = (75 * palabras) / 100;
            break;
          case 4:
            palabras = 30;
            palabras2 = 60;
            aciertosp = (80 * palabras) / 100;
            break;
          case 5:
            palabras = 35;
            palabras2 = 70;
            aciertosp = (80 * palabras) / 100;
            break;
          case 6:
            palabras = 40;
            palabras2 = 80;
            aciertosp = (85 * palabras) / 100;
            break;
          case 7:
            palabras = 50;
            palabras2 = 100;
            aciertosp = (90 * palabras) / 100;
            break;
          case 8:
            palabras = 60;
            palabras2 = 120;
            aciertosp = (90 * palabras) / 100;
            break;
          case 9:
            palabras = 70;
            palabras2 = 140;
            aciertosp = (95 * palabras) / 100;
            break;
          case 10:
            palabras = 100;
            palabras2 = 200;
            aciertosp = (100 * palabras) / 100;
            break;
        }
      }

      if (e.getSource() == iniciar && ver == 1) {
        counter++;
        frase.setStep(1);
        frase.paintComponent(getGraphics());
        if (counter < palabras) {
        } else {
          iniciar.stop();
          verificar.stop();
          mal.setEnabled(true);
          bien.setEnabled(true);
          jugar.setEnabled(false);
          frase.setStep(3);
          frase.paintComponent(getGraphics());
          JOptionPane.showMessageDialog(null, "Veamos si las memorizaste");
          verificar.start();
          ver = 2;
        }
      } else {
        iniciar.start();
      }
      if (e.getSource() == verificar && ver == 2) {
        frase.setI(counter2);
        counter2++;
        frase.setStep(4);
        frase.paintComponent(getGraphics());
        if (counter2 < palabras2) {
          if (counter2 == 0 | counter2 == 1) {
          }
        } else {
          //subirnivel
          verificar.stop();
          iniciar.stop();
          if (aciertos >= aciertosp && counter2 == (palabras2)) {
            fileManager.modificarNivel(nombreUsario);
            JOptionPane.showMessageDialog(null, "GANASTE!! HAS PASADO DE NIVEL");
            palabra.clearMethod();
            GUI.this.errores.setText("Errores: ");
            GUI.this.aciertos.setText("Aciertos: ");
            errores = 0;
            aciertos = 0;
            ver = 0;
            counter = 0;
            counter2 = 1;
            iniciar.stop();
            verificar.stop();
            mal.setEnabled(false);
            bien.setEnabled(false);
            jugar.setEnabled(true);
            frase.setStep(2);
            frase.paintComponent(getGraphics());
            add(arriba,BorderLayout.PAGE_START);
            textoUsuario.setText("Usuario: " + nombreUsario + "       " + " Nivel: " + fileManager.buscarNivel(nombreUsario));

          } else {
            JOptionPane.showMessageDialog(null, "PERDISTE!! VUELVE A EMPEZAR :(");
            palabra.clearMethod();
            GUI.this.errores.setText("Errores: ");
            GUI.this.aciertos.setText("Aciertos: ");
            errores = 0;
            aciertos = 0;
            ver = 0;
            counter = 0;
            counter2 = 1;
            iniciar.stop();
            verificar.stop();
            mal.setEnabled(false);
            bien.setEnabled(false);
            jugar.setEnabled(true);
            frase.setStep(2);
            frase.paintComponent(getGraphics());
            add(arriba,BorderLayout.PAGE_START);
            textoUsuario.setText("Usuario: " + nombreUsario + "       " + " Nivel: " + fileManager.buscarNivel(nombreUsario));
          }
        }
      } else {
        verificar.start();
      }


      if (e.getSource() == salir) {
        System.exit(0);
      }

      if (e.getSource() == ayuda) {
        JOptionPane.showMessageDialog(null, MENSAJE_INICIO);
      }

      if (e.getSource() == bien) {
        palabra.comparar();
        if (palabra.comparar()) {
          JOptionPane.showMessageDialog(null, "Perfecto, acertaste!");
          aciertos++;
          GUI.this.aciertos.setText("Aciertos: " + aciertos);
        } else {
          JOptionPane.showMessageDialog(null, "Parece que no es correcto :(");
          errores++;
          GUI.this.errores.setText("Errores: " + errores);
        }
      }

      if (e.getSource() == mal) {
        palabra.comparar();
        if (!palabra.comparar()) {
          JOptionPane.showMessageDialog(null, "Perfecto, acertaste!");
          aciertos++;
          GUI.this.aciertos.setText("Aciertos: " + aciertos);
        } else {
          JOptionPane.showMessageDialog(null, "Parece que no es correcto :(");
          errores++;
          GUI.this.errores.setText("Errores: " + errores);
        }
      }

    }
  }


}