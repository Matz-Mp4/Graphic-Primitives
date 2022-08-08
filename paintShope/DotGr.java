import java.awt.*;

public class DotGr extends Dot{

    private Color color;
    private String dotName = "";
    private int diameter = 1;
    
    public DotGr(double x, double y, Color c){
        super(x,y);
        this.color = c;
    }

    public DotGr(double x, double y){
        super(x,y);
    }

    public DotGr(double x, double y, String name){
        super(x,y);
        this.dotName = name;
    }

    public DotGr(double x, double y, String name, Color c){
        super(x,y);
        this.color = c;
        this.dotName = name;
    }

    public String getDotName(){
        return dotName;
    }

    public void setDotName(String value){
        value = dotName;
    }

    public void setColor(Color value){
        color = value;
    }

    public void setDiameter(int value){
        diameter = value;
    }

    public void drawRecta(Graphics g){
        g.setColor(color);
        g.drawRect((int)getX(),(int)getY(), 1, 1);
        g.drawString(dotName, (int)getX()+1, (int)getY()+1);
    }

    public static void drawPixel(Graphics g, double x, double y, Color c){
        g.setColor(c);
        g.drawRect((int)x, (int)y, 1, 1);
    }

    public void drawDot(Graphics g){
        g.setColor(color);
        g.fillOval((int)getX(), (int)getY(), diameter, diameter);
    }

}
