import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {

  private final static Color BACKGROUND = Color.white;
  private final static Color FOREGROUND = Color.black;
  private DrawPanel drawP;
  private JPanel jpnButtons;
  private JButton Circle;
  private JButton Line;
 /**
   * Constructor for objects of class Window
   */
  public Window() {
    initialize();
    
  }
/**
 * defines the layout, the bounds, and put the panels in the window
 */
  private void initialize() {

    setSize(800, 600);
    // setSize(GuiUtils.getWidthScreen() / 2, GuiUtils.getHeightScreen() / 2);
    setLayout(new BorderLayout());

    jpnButtons = new JPanel();
    jpnButtons.setLayout(new FlowLayout());
    
    //Creates draw buttons
    Circle = new JButton("Circle");
    Line = new JButton("Line");

    //Adding buttons to frame
    jpnButtons.add(Circle);
    jpnButtons.add(Line);
    

    // getContentPane().setBackground(BACKGROUND);
    // getContentPane().setForeground(FOREGROUND);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    add(getDrawP(), BorderLayout.CENTER);

    add(jpnButtons, BorderLayout.PAGE_END);
    setVisible(true);

  }

  public DrawPanel getDrawP() {
    if (drawP == null) {
      drawP = new DrawPanel();
      drawP.setCircle(Circle);
      drawP.setLine(Line);
      drawP.setEvents();
    }
    return drawP;

  }

  public void setDrawP(DrawPanel drawP) {

    this.drawP = drawP;
  }

}
