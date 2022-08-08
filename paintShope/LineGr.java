import java.awt.*;

public class LineGr extends Line{
    
    Color color = Color.black;

    public LineGr(Dot A, Dot B){
        super(A, B);
    }

    public LineGr(Dot A, Dot B, Color c){
        super(A, B);
        color = c;
    }

    public void setColor(Color value){
        color = value;
    }

    public void drawLine(Graphics g){
        g.setColor(color);

        double A = getDotA().getX(); 
        double B = getDotB().getX();

        if(A == B){
            A = getDotA().getY();
            B = getDotB().getY();
        }

        boolean truce = true; //To adds, i.e, xA(or yA) < xB(or yA)
        if(A > B) truce = false;

        for(; A <= B; indexFunction(A, truce)){
            DotGr.drawPixel(g, A, calculateY(A), Color.BLACK);
        }

    }

    private void indexFunction(double value, boolean truce){
        if(truce){ //Adds
            ++value;
        }else --value;
    }

}
