import javax.swing.*;
import java.awt.*;

public class PanelFrase extends JPanel {
    public static final int WIDTH=370;
    public static final int HEIGTH= 200;

    private Diccionario palabra= new Diccionario();
    private String errores, aciertos,frases,texto;
    private int step;
    private Font font;

    public PanelFrase(){
        setBackground(Color.LIGHT_GRAY);
        font = new Font(Font.DIALOG,Font.BOLD,27);
        this.setPreferredSize(new Dimension(WIDTH,HEIGTH));
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
        switch (step){
            case 1:
                g.setColor(Color.MAGENTA);
                g.drawString(palabra.getFrase(), 20,22);
                break;
            default:g.setColor(Color.BLUE);
                g.drawString("The End!!",50,22);
                break;
        }
    }
}
