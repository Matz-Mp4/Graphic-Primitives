import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {

  private final static Color BACKGROUND = Color.white;
  private final static Color FOREGROUND = Color.black;
  private DrawPanel drawP;

  public Window() {
    initialize();
  }

  private void initialize() {

    getContentPane().setSize(800, 600);
    setLayout(new BorderLayout());

    // getContentPane().setBackground(BACKGROUND);
    // getContentPane().setForeground(FOREGROUND);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    add(getDrawP(), BorderLayout.CENTER);
    setVisible(true);

  }

  public DrawPanel getDrawP() {
    if (drawP == null) {
      drawP = new DrawPanel();
    }
   return drawP;

  }

  public void setDrawP(DrawPanel drawP) {

    this.drawP = drawP;
  }

}
