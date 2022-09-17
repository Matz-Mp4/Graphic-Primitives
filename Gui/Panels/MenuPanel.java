package Gui.Panels;

import java.awt.FlowLayout;
import java.awt.*;

import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.channels.SelectableChannel;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import DataStruct.List.*;
import javax.swing.*;
import javax.swing.border.Border;

import Gui.GuiUtils;

public class MenuPanel extends JPanel {
  private JComboBox<String> selector;
  private JButton jbtnRedraw; /* redraw */
  private JButton jbtnDelete;
  private PrimitiveList list;

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
      GuiUtils.setShapeButton(Color.white, Color.black, jbtnRedraw);
    }
    return jbtnDelete;

  }

}
