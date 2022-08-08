import javax.swing.*;
import java.awt.*;

public class DrawPanel extends JPanel {

  private final static Color BACKGROUND = Color.white;
  private final static Color FOREGROUND = Color.black;

  private void initialize() {
    setBackground(BACKGROUND);
    setForeground(FOREGROUND);
    setLayout(null);
  }

  public DrawPanel(){
    initialize();
  }

  public void paintComponent(Graphics g){
    DotGr oi = new DotGr(40, 50);
    oi.drawDot(g);
  
  }

  public void paint(Graphics g){
    super.paint(g);
    DotGr oi = new DotGr(60, 50);
    oi.drawDot(g);
    g.drawOval(80, 80, 150, 150);
  }
}
