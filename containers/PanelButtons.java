package containers;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

public class PanelButtons extends JPanel{
    private JButton circle;
    private JButton line;
    private Type type;

    PanelButtons(Type type){
        initialize();
        this.type = type;
        setEvents();
    }

    void initialize(){
        setLayout(new FlowLayout());
        
        //Creating Buttons
        circle = new JButton("Circle");
        line = new JButton("Line");

        //Adding buttons
        add(circle);
        add(line);
    }

  /**
   * Sets the events of both line and circle
   */
  public void setEvents() {

    circle.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        type.setType(TypeButton.CIRCLE);
      }
    });

    line.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        type.setType(TypeButton.LINE);
      }
    });
  }
}
