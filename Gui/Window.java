package Gui;

import DataStruct.List.PrimitiveList;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import Gui.Panels.*;
import DataStruct.JsonData.JsonFile;

public class Window extends JFrame {

  private DrawPanel drawP;
  private MenuPanel menuP;
  private PrimitiveList list;
  private TitlePanel titleP;
  private int width; 
  private int height;
  private JsonFile jsonFile;

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

    setLayout(new BorderLayout());
    width = GuiUtils.getWidthScreen();   
    height = GuiUtils.getHeightScreen();   
    width = (width/2) + (width /4); 
    height = (height/ 2) + (height/4);
    setSize(width , height);
    getContentPane().setBackground(GuiUtils.getBackground());
    getContentPane().setForeground(GuiUtils.getForeground());
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    add(getTitleP(), BorderLayout.PAGE_START);
    add(getMenuP(), BorderLayout.PAGE_END);
    list = new PrimitiveList();
    jsonFile = new JsonFile(list, new Dimension(width, height));
    add(getDrawP(), BorderLayout.CENTER);
    setVisible(true);
  }

  public int getWidth(){
    return width;
  }

public int getHeight(){
    return height;
  }

  

  public DrawPanel getDrawP() {
    if (drawP == null) {
      drawP = new DrawPanel(menuP, list, jsonFile);
    }
    return drawP;
  }

  public TitlePanel getTitleP(){
    if(titleP == null){
      titleP = new TitlePanel();
    }

    return titleP;
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
