import javax.swing.*;
import java.awt.*;

public class PanelFrase extends JPanel {

  private Diccionario palabra= new Diccionario();
  private String errores, aciertos,frases,texto;
  private int step;
  private Font font;
  public static int i;

  public PanelFrase(){
    setBackground(Color.CYAN);
    font = new Font(Font.DIALOG,Font.BOLD,27);
    step=2;
  }

  public int setI(int i){
    this.i=i;
    return this.i;
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
        g.setColor(Color.BLACK);
        g.drawString(this.palabra.getFrase(), 270,250);
        break;
      case 2:
        g.setColor(Color.BLACK);
        g.drawString( "I Know That Word",200,220);
        break;
      case 3:
        g.setColor(Color.BLACK);
        g.drawString( "Perfecto, ahora veamos si las memorizaste!!",50,250);
        break;
      case 4:
        g.setColor(Color.BLACK);
        g.drawString( this.palabra.setFrase(),270,250);
        break;
    }


  }




  public void setStep(int step){
    this.step=step;
  }
}
