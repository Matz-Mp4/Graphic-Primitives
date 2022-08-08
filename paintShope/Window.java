import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
  
  private final static Color BACKGROUND = Color.white;
  private final static Color FOREGROUND = Color.black;
  private DrawPanel mainPanel;

  public Window(){
    initialize();
  }

  private void initialize() {

    setSize(600, 600);
    setLayout(new BorderLayout());

    getContentPane().setBackground(BACKGROUND);
    getContentPane().setForeground(FOREGROUND);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setVisible(true);

    mainPanel = new DrawPanel();
    add(mainPanel);
  }

  public static void main(String []args){
    SwingUtilities.invokeLater(new Runnable(){
      public void run(){
        new Window();
      }
    });
  }
  
}
