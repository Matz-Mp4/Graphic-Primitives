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
    // g.drawLine(13, 2, 117, 456);
    LineGr line = new LineGr(13 , 2, 117, 456);
    line.drawLine(g);

  }
}
