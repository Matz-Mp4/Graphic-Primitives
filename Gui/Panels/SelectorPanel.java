package Gui.Panels;

import java.awt.FlowLayout;

import javax.swing.JComboBox;
import javax.swing.JPanel;

public class SelectorPanel extends JPanel {
  private JComboBox <String>selector;

  private String options[] = { "None", "Circle", "Line" };

  public SelectorPanel() {
    initialize();
  }

  void initialize() {
    setLayout(new FlowLayout());
    selector = new JComboBox<String>(options);
    add(selector);
  }

  public JComboBox <String>getSelector() {
    return selector;
  }

  public void setSelector(JComboBox<String> selector) {
    this.selector = selector;
  }

}
