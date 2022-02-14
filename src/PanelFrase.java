import javax.swing.*;
import java.awt.*;

public class PanelFrase extends JPanel {
    public static final int WIDTH=650;
    public static final int HEIGTH= 500;

    private Diccionario palabra= new Diccionario();
    private String errores, aciertos,frases,texto;
    private int step;
    private Font font;

    public PanelFrase(){
        setBackground(new Color(255,255,255,0));
        font = new Font(Font.DIALOG,Font.BOLD,27);
        //this.setPreferredSize(new Dimension(WIDTH,HEIGTH));
        step=1;
    }

    public void dibujarParte(){
        step++;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setFont(font);
        if (step>=1){
            g.setColor(Color.BLACK);
            g.drawString(palabra.getFrase(), 240,250);
        }
        /*
        * switch (step){
            case 1:
                g.setColor(Color.BLACK);
                g.drawString(palabra.getFrase(), 240,250);
                break;
        }*/

    }
}
