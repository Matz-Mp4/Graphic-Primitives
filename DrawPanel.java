import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

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
    // LineGr l1 = new LineGr(0, 300, 800, 300);
    // l1.setLineColor(GuiUtils.generateRandomColor());
    // l1.drawLine(g);
    //
    // LineGr l2 = new LineGr(800, 600, 0, 0);
    // l2.setLineColor(GuiUtils.generateRandomColor());
    // l2.drawLine(g);
    //
    // LineGr l3 = new LineGr(400, 0, 400, 600);
    // l3.setLineColor(GuiUtils.generateRandomColor());
    // l3.drawLine(g);
    //
    // LineGr l4 = new LineGr(800, 0, 0, 600);
    // l4.setLineColor(GuiUtils.generateRandomColor());
    // l4.drawLine(g);
    // g.drawOval(150, 150, 100, 100);
    CircleGr circle1 = new CircleGr(100, 100, 80);
    circle1.drawCircle(g);

    // g.drawOval(300, 250, 300, 100);
    CircleGr circle2 = new CircleGr(300, 250, 300);
    circle2.drawCircle(g);

    LineGr l5 = new LineGr(200, 300, 600, 303);
    l5.drawLine(g);

  }
}
