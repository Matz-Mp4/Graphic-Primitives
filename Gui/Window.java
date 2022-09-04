package Gui;

import DataStruct.List.PrimitiveList;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import Gui.Panels.*;


public class Window extends JFrame {

  private DrawPanel drawP;

  private SelectorPanel selectorP;

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
    add(getSelectorP(), BorderLayout.PAGE_END);
    add(getDrawP(), BorderLayout.CENTER);
    drawP.setSelector(selectorP.getSelector());
 


    list = new PrimitiveList();
    getDrawP().setList(list);
    setVisible(true);
  }


    /*
     * private void setEventos(IArmazenagem cad, PainelMensagem mens) {
     * guiRemover.getBotaoRemover().addActionListener(new ActionListener() {
     * public void actionPerformed(ActionEvent e) {
     */

  

  public DrawPanel getDrawP() {
    if (drawP == null) {
      drawP = new DrawPanel(selectorP);
    }
    return drawP;
  }

  public SelectorPanel getSelectorP() {
    if (selectorP == null) {
      selectorP = new SelectorPanel();

    }
    return selectorP;
  }

  public void setDrawP(DrawPanel drawP) {
    this.drawP = drawP;
  }

}
