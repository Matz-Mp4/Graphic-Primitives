package Panels;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

public class ButtonPanel extends JPanel {
  private JButton circle;
  private JButton line;
  private JComboBox selector;

  private String options[] = { "Circle", "Line", "None" };

  public ButtonPanel() {
    initialize();
  }

  void initialize() {
    setLayout(new FlowLayout());
    selector = new JComboBox(options);
    add(selector);
  }

  public JComboBox getSelector() {
    return selector;
  }

  public void setSelector(JComboBox selector) {
    this.selector = selector;
  }

}
