package containers;
import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {

  private final static Color BACKGROUND = Color.white;
  private final static Color FOREGROUND = Color.black;
  private DrawPanel drawP;
  private PanelButtons panelButtons;

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

    

    // getContentPane().setBackground(BACKGROUND);
    // getContentPane().setForeground(FOREGROUND);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    add(getDrawP(), BorderLayout.CENTER);

    panelButtons = new PanelButtons(getDrawP().getTypeButton());
    add(panelButtons, BorderLayout.PAGE_END);

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
