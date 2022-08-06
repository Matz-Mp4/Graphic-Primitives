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
    super.paintComponent(g);
    // Comparing funcitons
    g.drawLine(20, 1, 110, 400);
    LineGr line = new LineGr(30, 1, 120, 400);
    line.drawLine(g);

    LineGr line1 = new LineGr(300, 555, 500, 555);
    line1.drawLine(g);

    g.drawLine(300, 655, 500, 655);

  }
}
