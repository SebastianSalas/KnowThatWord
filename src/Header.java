import javax.swing.*;
import java.awt.*;

public class Header  extends JLabel {
    /**
     * Constructor of the Header class
     * @autor Jhon Alexander Valencia Hilamo jhon.hilamo@correounivalle.edu.co
     * @author Janiert Sebastian Salas Castillo janiert.salas@correounivalle.edu.co
     * @param title String that contains Header text
     * @param colorBackground Color object to be assigned for the Header background
     */
    public Header(String title, Color colorBackground){
        this.setText(title);
        this.setBackground(colorBackground);
        this.setForeground(new Color(0,0,0));
        this.setFont(new Font(Font.DIALOG, Font.BOLD,20));
        this.setHorizontalAlignment(JLabel.CENTER);
        this.setVerticalAlignment(JLabel.CENTER);
        this.setOpaque(true);
    }
}
