import javax.swing.*;
import java.awt.*;

public class DrawPanel extends JPanel {

  private final static Color BACKGROUND = Color.white;
  private final static Color FOREGROUND = Color.black;

  private void initialize() {
    setBackground(BACKGROUND);
    setForeground(FOREGROUND);
    add(new JLabel("Ola"));
  }

  public DrawPanel() {
    initialize();
  }
@Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    LineGr line = new LineGr(5, 5, 100, 100);
    line.drawLine(g);
    LineGr line2 = new LineGr(300, 200, 500, 200);
    line2.drawLine(g);
    LineGr line3 = new LineGr(300, 200, 500, 150);
    line3.drawLine(g);
 
    LineGr line4 = new LineGr(300, 200, 500, 250);
    line4.drawLine(g);


  }
}
