package Gui.Panels;

import java.awt.FlowLayout;
import java.awt.*;



import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.*;
import javax.swing.border.Border;

import Gui.GuiUtils;

public class MenuPanel extends JPanel {
  private JComboBox<String> selector;
  private JButton jbtnRedraw; /* redraw */
  private JButton jbtnDelete;
  private JSlider jsliderThickness;
  private JButton jbtnColor;

  private String options[] = { "None", "Circle", "Line", "Polygonal Line", "Rectangle", "Polygon", "Select" };

  public MenuPanel() {
    initialize();
  }

  void addButton() {

  }

  void initialize() {
    setLayout(new FlowLayout());
    selector = new JComboBox<String>(options);
    add(selector);
    add(getjbtnRedraw());
    add(getjbtnDelete());
    add(getjbtnColor());
    add(getJsliderThickness());
  }

  public JComboBox<String> getSelector() {
    return selector;
  }

  public void setSelector(JComboBox<String> selector) {
    this.selector = selector;
  }

  public JButton getjbtnRedraw() {
    if (jbtnRedraw == null) {
      jbtnRedraw = new JButton("Redraw");
      GuiUtils.setShapeButton(Color.white, Color.black, jbtnRedraw);
    }
    return jbtnRedraw;

  }

  public JButton getjbtnDelete() {
    if (jbtnDelete == null) {
      jbtnDelete = new JButton("Delete");
      GuiUtils.setShapeButton(Color.white, Color.black, jbtnDelete);
    }
    return jbtnDelete;

  }

  public JButton getjbtnColor() {
    if (jbtnColor == null) {
      jbtnColor = new JButton("Color");
      GuiUtils.setShapeButton(Color.white, Color.black, jbtnColor);
    }
    return jbtnColor;

  }

  public JSlider getJsliderThickness() {
    if(jsliderThickness == null){
      jsliderThickness = new JSlider(JSlider.HORIZONTAL, 2, 20, 3);
      GuiUtils.setSliderHorizontal(jsliderThickness, "Thickness");
    }
    return jsliderThickness;
  }

  public void setJsliderThickness(JSlider jsliderThickness) {
    this.jsliderThickness = jsliderThickness;
  }

}
