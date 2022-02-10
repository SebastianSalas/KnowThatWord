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
            case 2:
                g.setColor(Color.RED);
                g.drawString("Draw Lines",20,22);
                g.drawLine(5,30, 380,30);
                break;
            case 3:g.setColor(Color.CYAN);
                g.drawString("Draw Rect",20,22);
                g.drawRect(5,40,90,55);
                g.fillRect(100,40,90,55);
                g.setColor(Color.ORANGE);
                g.drawRoundRect(290,40,90,55,20,20);
                g.fillRoundRect(195,40,90,55,50,50);
                g.setColor(Color.MAGENTA);
                g.draw3DRect(5,100,90,55,true);
                g.fill3DRect(100,100,90,55,false);
                break;
            case 4:g.setColor(Color.YELLOW);
                g.drawString("Draw Ovals",20,22);
                g.drawOval(195,100,90,55);
                g.fillOval(290,100,90,55);
                break;
            case 5:g.setColor(Color.GREEN);
                g.drawString("Draw Images",20,22);
                ImageIcon image = new ImageIcon(getClass().getResource("resources/paolaLogo.png"));
                g.drawImage(image.getImage(),7,40,90,90,null);
                break;
            default:g.setColor(Color.BLUE);
                g.drawString("The End!!",50,22);
                break;
        }
    }
}
