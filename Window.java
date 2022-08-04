import java.swing.JFrame;
import java.awt.*;

public class Window extends JFrame {
  
  private final static Color BACKGROUND = Color.white;
  private final static Color FOREGROUND = Color.black;

  private void initialize() {

    setSize(600, 800);
    setLayout(new BorderLayout());

    getContentPane().setBackground(BACKGROUND);
    getContentPane().setForeground(FOREGROUND);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setVisible(true);

  }
  
  public Window(){
    initialize();
  }

}
