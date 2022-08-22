package Gui;
import java.awt.BorderLayout;

import javax.swing.JFrame;

import Gui.Panels.*;

public class Window extends JFrame {

  private DrawPanel drawP;
  private SelectorPanel buttonP;

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

     getContentPane().setBackground(GuiUtils.getBackground());
     getContentPane().setForeground(GuiUtils.getForeground()); 
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    add(getDrawP(), BorderLayout.CENTER);
    add(getButtonP(), BorderLayout.PAGE_END);
    drawP.setSelector(buttonP.getSelector());

    setVisible(true);
  }

  public DrawPanel getDrawP() {
    if (drawP == null) {
      drawP = new DrawPanel();
    }
    return drawP;
  }

  public SelectorPanel getButtonP() {
    if (buttonP == null) {
      buttonP = new SelectorPanel();

    }
    return buttonP;
  }

  public void setDrawP(DrawPanel drawP) {

    this.drawP = drawP;
  }

}
