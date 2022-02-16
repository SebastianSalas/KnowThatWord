import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Random;

/**
 * This class is used for ...
 * @autor Jhon Alexander Valencia Hilamo jhon.hilamo@correounivalle.edu.co
 * @author Janiert Sebastian Salas Castillo janiert.salas@correounivalle.edu.co
 * @version v.1.0.0 date:21/11/2021
 */


public class GUI extends JFrame {

    private Header headerProject;
    private PanelFrase frase;
    private JPanel botoncitos,header;
    private FileManager fileManager;
    private String nombreUsario,p="";
    private ImageIcon fondos;
    private JLabel textoUsuario,aciertos,errores;
    private JButton salir,jugar,bien,mal,calificar;
    private Escucha escucha;
    private Timer timer,iniciar,verificar;
    private Diccionario palabra= new Diccionario();
    private Integer nivel,palabras;
    private ModelWords modelWords;
    private GUI guiPalabras;
    /**
     * Constructor of GUI class
     */
    public GUI() throws IOException {
        initGUI();
        this.setUndecorated(true);


        //Default JFrame configuration
        this.setTitle("I Know That Word");
        this.setSize(650,500);
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
        escucha= new Escucha();
        modelWords= new ModelWords();
        fileManager = new FileManager();
        nombreUsario=JOptionPane.showInputDialog("Ingrese su usuario");
        fileManager.escribirUsuario(nombreUsario);
        nivel = fileManager.buscarNivel(nombreUsario);
        guiPalabras=this;


        frase = new PanelFrase();
        frase.setFocusable(true);
        add(frase,BorderLayout.CENTER);


        /*headerProject = new Header("I Know That Word",Color.BLACK);
        this.add(headerProject,BorderLayout.PAGE_START);*/

        header= new JPanel();
        textoUsuario = new JLabel(" Usuario: " + fileManager.lecturaUsuario() + " Nivel: " + fileManager.buscarNivel(nombreUsario));
        textoUsuario.setFont(new Font(Font.DIALOG,Font.BOLD,20));
        textoUsuario.setForeground(new Color(7,48,100));
        textoUsuario.setHorizontalAlignment(JLabel.CENTER);
        textoUsuario.setVerticalAlignment(JLabel.CENTER);
        header.add(textoUsuario);
        add(header,BorderLayout.NORTH);



        botoncitos=new JPanel();
        botoncitos.setBackground(Color.CYAN);
        aciertos=new JLabel();
        errores=new JLabel();
        aciertos.setText("Aciertos: ");
        errores.setText("Errores: ");
        jugar = new JButton("Jugar");
        bien=new JButton("Si");
        bien.setEnabled(false);
        mal= new JButton("No");
        mal.setEnabled(false);
        calificar =new JButton ("Calificar");
        calificar.setEnabled(false);
        salir = new JButton();
        ImageIcon img1=new ImageIcon("src/resources/power.png");
        salir.setIcon(img1);
        salir.setBorderPainted(false);
        salir.setContentAreaFilled(false);
        salir.setFocusable(false);
        salir.addActionListener(escucha);
        botoncitos.add(aciertos);
        botoncitos.add(bien);
        botoncitos.add(jugar);
        botoncitos.add(calificar);
        botoncitos.add(mal);
        botoncitos.add(errores);
        botoncitos.add(salir);
        bien.addActionListener(escucha);
        mal.addActionListener(escucha);
        calificar.addActionListener(escucha);
        jugar.addActionListener(escucha);
        add(botoncitos, BorderLayout.PAGE_END);

        iniciar= new Timer(1000,escucha);
        verificar=new Timer(7000,escucha);
        verificar.stop();


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
    public void traerPalabras(){
        frase.setStep(1);
        frase.paintComponent(getGraphics());
    }

    public void cambiarNivel(){

    }
    /**
     * inner class that extends an Adapter Class or implements Listeners used by GUI class
     */
    private class Escucha implements ActionListener {
        private int counter,centinela, counter2=0,ver=0,errores,aciertos;
        private Random random;
        public Escucha(){
            random= new Random();
            counter=0;
            centinela=1;
            errores=0;
            aciertos=0;
        }
        @Override
        public void actionPerformed(ActionEvent e) {

            switch (nivel){
                case 1:
                    palabras=10;
                    break;
                case 2:
                    palabras = 20;
                    break;
                case 3:
                    palabras = 25;
                    break;
                case 4:
                    palabras=30;
                    break;
                case 5:
                    palabras = 35;
                    break;
                case 6:
                    palabras = 40;
                    break;
                case 7:
                    palabras = 50;
                    break;
                case 8:
                    palabras = 60;
                    break;
                case 9:
                    palabras = 70;
                    break;
                case 10:
                    palabras = 100;
                    break;
            }

            if(e.getSource()==jugar){
                iniciar.start();
                verificar.stop();
                System.out.println("INICIANDO");
                ver=1;
            }

            if(e.getSource()==iniciar&&ver==1){
                counter++;
                traerPalabras();
                if(counter<palabras){
                }else{
                    iniciar.stop();
                    verificar.stop();
                    mal.setEnabled(true);
                    bien.setEnabled(true);
                    jugar.setEnabled(false);
                    calificar.setEnabled(true);
                    frase.setStep(3);
                    frase.paintComponent(getGraphics());
                }
            }else{
                iniciar.start();
            }

            if(e.getSource()==calificar){
                verificar.start();
                iniciar.stop();
                System.out.println("INICIANDO 2");
                ver=2;
            }

            if(e.getSource()==verificar&&ver==2){
                counter2++;
                traerPalabras();
                if(counter2<palabras*2){
                    if(counter2==0|counter2==1){
                    }else{
                        JOptionPane.showMessageDialog(null,"Oops, llegaste al limite de tiempo");
                        errores++;
                        GUI.this.errores.setText("Errores: "+errores);
                    }
                }else{
                    verificar.stop();
                    mal.setEnabled(true);
                    bien.setEnabled(true);
                    jugar.setEnabled(false);
                    calificar.setEnabled(true);
                    System.out.println("parar 2");
                }
            }else{
                verificar.start();
            }

            if (e.getSource()==salir){
                System.exit(0);
            }

            if(e.getSource()==bien){
                if(counter2==0){
                    JOptionPane.showMessageDialog(null,"pasaste de lvl");

                }
            }

            if(e.getSource()==mal){

            }

        }
    }


}