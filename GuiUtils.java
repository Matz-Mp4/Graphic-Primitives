import java.awt.*;

public class GuiUtils {

  private static Dimension dimScreen = Toolkit.getDefaultToolkit().getScreenSize();

  public static Color generateRandomColor() {
    int R = (int) (Math.random() * 256);
    int G = (int) (Math.random() * 256);
    int B = (int) (Math.random() * 256);

    return new Color(R, G, B);
  }

  public static int getWidthScreen() {
    return (int)dimScreen.getWidth();
  }

  public static int getHeightScreen() {
    return (int)dimScreen.getHeight();
  }

}
