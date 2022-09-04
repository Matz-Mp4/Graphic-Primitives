package Gui;

import DataStruct.List.PrimitiveList;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import Gui.Panels.*;

public class Window extends JFrame {

  private DrawPanel drawP;
  private MenuPanel menuP;
  private PrimitiveList list;

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
    add(getMenuP(), BorderLayout.PAGE_END);
    add(getDrawP(), BorderLayout.CENTER);
    drawP.setSelector(menuP.getSelector());

    list = new PrimitiveList();
    getDrawP().setList(list);
    setVisible(true);
  }

  public DrawPanel getDrawP() {
    if (drawP == null) {
      drawP = new DrawPanel(menuP);
    }
    return drawP;
  }

  public MenuPanel getMenuP() {
    if (menuP == null) {
      menuP = new MenuPanel();

    }
    return menuP;
  }

  public void setDrawP(DrawPanel drawP) {
    this.drawP = drawP;
  }

}
