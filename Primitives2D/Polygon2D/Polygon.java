package Primitives2D.Polygon2D;

import Primitives2D.Point2D.Point;

public class Polygon{
    //Lines attributes
    private Point sp, ep; //starting point and ending point

    public Polygon(int x1, int y1, int x2, int y2){
        setSP(new Point(x1, y1));
        setEP(new Point(x2, x2));
    }

    

    //setters
    public void setSP(Point p){
        this.sp = p;
    }

    public void setEP(Point p){
        this.ep = p;
    }

    //getters
    public Point getP1(){
        return this.sp;
    }

    public Point getP2(){
        return this.ep;
    }

}
