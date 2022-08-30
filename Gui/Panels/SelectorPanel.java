package Gui.Panels;

import java.awt.FlowLayout;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import DataStruct.List.*;

import javax.swing.*;
import javax.swing.border.Border;

import Gui.GuiUtils;

public class SelectorPanel extends JPanel {
  private JComboBox<String> selector;
  private JButton buttonR; /* redraw */
  private PrimitiveList primitiveList;

  private String options[] = { "None", "Circle", "Line", "Polygonal Line", "Rectangle" };

  public SelectorPanel() {
    initialize();
  }

  void addButton() {

  }

  void initialize() {
    setLayout(new FlowLayout());
    selector = new JComboBox<String>(options);
    add(selector);
    add(getButtonR());
    // addEvent();
  }

  public JComboBox<String> getSelector() {
    return selector;
  }

  public void setSelector(JComboBox<String> selector) {
    this.selector = selector;
  }

  public JButton getButtonR() {
    if (buttonR == null) {
      buttonR = new JButton("Redraw");
      GuiUtils.setShapeButton(Color.black, Color.white, buttonR);
    }
    return buttonR;

  }

  /*
   * public void addEvent() {
   * if (buttonR != null) {
   * buttonR.addActionListener(
   * (ActionEvent e) -> {
   * primitiveList.drawEverything();
   * });
   * }
   * }
   * 
   * public void actionPerformed(ActionEvent ev) {
   * try {
   * System.out.println(ev.getActionCommand());
   * } catch (Exception e) {
   * }
   * }
   */
  public void setPrimitiveList(PrimitiveList primitiveList) {
    this.primitiveList = primitiveList;
  }

}
