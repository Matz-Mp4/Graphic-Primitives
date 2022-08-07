import javax.swing.*;
import java.awt.*;

public class DrawPanel extends JPanel {

  private final static Color BACKGROUND = Color.white;
  private final static Color FOREGROUND = Color.black;

  private void initialize() {
    setBackground(BACKGROUND);
    setForeground(FOREGROUND);
  }

  public DrawPanel() {
    initialize();
  }

  @Override
  public void paintComponent(Graphics g) {

    LineGr l2 = new LineGr(800, 600, 0, 0);
    l2.drawLine(g);
    LineGr l3 = new LineGr(400, 0, 400, 600);
    l3.drawLine(g);
    LineGr l4 = new LineGr(800, 0, 0, 600);
    l4.drawLine(g);
  }
}
