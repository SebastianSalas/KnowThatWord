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
    private String nombreUsario;
    private ImageIcon fondos;
    private JLabel fondo;
    private JButton salir,jugar,bien,mal;
    private Escucha escucha;
    private Timer timer,iniciar;
    private Diccionario palabra= new Diccionario();

    /**
     * Constructor of GUI class
     */
    public GUI() throws IOException {
        initGUI();
        this.setUndecorated(true);
        fondos= new ImageIcon(getClass().getResource("/resources/fondo.jpg"));
        fondo= new JLabel(fondos);

        //Default JFrame configuration
        this.setTitle("I Know That Word");
        this.setSize(650,500);
        //this.pack();
        this.setResizable(true);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /*
        * javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );*/


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

        fileManager = new FileManager();
        nombreUsario=JOptionPane.showInputDialog("Ingrese su usuario");
        fileManager.escribirUsuario(nombreUsario);

        frase = new PanelFrase();
        frase.setFocusable(true);
        add(frase,BorderLayout.CENTER);


        headerProject = new Header("I Know That Word",Color.BLACK);
        this.add(headerProject,BorderLayout.PAGE_START);
        salir = new JButton();

        ImageIcon img1=new ImageIcon("src/resources/power.png");
        salir.setIcon(img1);
        salir.setBorderPainted(false);
        salir.setContentAreaFilled(false);
        salir.setFocusable(false);
        salir.addActionListener(escucha);


        botoncitos=new JPanel();
        botoncitos.setBackground(Color.CYAN);
        jugar = new JButton("Jugar");
        bien=new JButton("Si");
        mal= new JButton("No");
        botoncitos.add(bien);
        botoncitos.add(jugar);
        botoncitos.add(mal);
        botoncitos.add(salir);
        jugar.addActionListener(escucha);
        add(botoncitos, BorderLayout.PAGE_END);

        timer= new Timer(5000,escucha);
        iniciar= new Timer(2000,escucha);
        //timer.start();


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
    private class Escucha implements ActionListener {
        private int counter=0,c2;
        private Random random;
        public Escucha(){
            random= new Random();
            counter=0;
        }
        @Override
        public void actionPerformed(ActionEvent e) {

            if(e.getSource()==jugar){
                timer.start();
                System.out.println("INICIANDO");
            }

            /*
            * if(e.getSource()==timer){
                c2++;
                frase.conteo(getGraphics(),c2);
                if(counter<=4){

                }else{
                    iniciar.start();
                    timer.stop();
                }
            }else{

            }*/


            if(e.getSource()==iniciar){
                counter++;
                frase.setStep(1);
                frase.paintComponent(getGraphics());
                if(counter<10){
                    System.out.println("x");
                }else{
                    iniciar.stop();
                    timer.stop();
                    System.out.println("parar");
                }
            }else{
                iniciar.start();
                //counter=0;
            }

            if (e.getSource()==salir){
                System.exit(0);
            }

        }
    }
}
