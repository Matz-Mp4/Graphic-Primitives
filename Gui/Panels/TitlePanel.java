package Gui.Panels;

import javax.swing.JPanel;
import Gui.GuiUtils;
import java.awt.*;
import javax.swing.*;

/**
 * Class that inherits JPanel and where the title will be placed
 * @author Mateus Assalti Santana
 */
public class TitlePanel extends JPanel{

  private JLabel jlbTitle;
  private RoundedPanel pnlTitle;


  public TitlePanel(){
    initialize();
  }

  /**
    * initialize the panel
    * @param void
    * @return void
   */
  private void initialize(){
    add(getPnlTitle());
    setBackground(GuiUtils.getBackground());
    setForeground(GuiUtils.getBackground());
  }

  /**
    * Create a panel and his components for the title of the window 
    * @param void
    * @return RoundedPanel
   */
  private RoundedPanel getPnlTitle(){
    if(pnlTitle == null){
      //Create a rounded panel with 30 of "curvature" in the borders
      pnlTitle = new RoundedPanel(30, GuiUtils.getForeground());
      pnlTitle.setBackground(GuiUtils.getBackground());
      pnlTitle.setPreferredSize(new Dimension(200, 30));
      
      jlbTitle = new JLabel("BETTER PAINT");
      jlbTitle.setBackground(GuiUtils.getForeground());
      jlbTitle.setForeground(GuiUtils.getBackground());
      jlbTitle.setFont(new Font("Arial", Font.BOLD, 20)); 
      jlbTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
      
      pnlTitle.add(jlbTitle);
    }
    return pnlTitle;
  }

}
