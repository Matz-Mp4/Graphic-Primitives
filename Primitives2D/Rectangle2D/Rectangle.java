package Primitives2D.Rectangle2D;

import Primitives2D.Line2D.Line;
import Primitives2D.Line2D.Line;

/**
 * Retângulo matemático.
 *
 * @author Gabriel Cavalcanti
 * @version 15/08/2021
 */
public class Rectangle {
    //Diagonal
    private Line diagonal;
    private Line []lines = new Line [4];
    

    public Rectangle(double x1, double y1, double x2, double y2){
      
        setDiagonal(new Line(x1, y1, x2, y2));
        convertToRectangle( x1,  y1,  x2,  y2);
        
    }

     public Rectangle(Line diagonal){
        convertToRectangle(diagonal.getP1().getX(), diagonal.getP1().getY(), diagonal.getP2().getX(), diagonal.getP2().getY());
        setDiagonal(new Line(diagonal.getP1().getX(), diagonal.getP1().getY(), diagonal.getP2().getX(), diagonal.getP2().getY()));
     }

    public void setDiagonal(Line line){ this.diagonal = line; }

    public Line getDiagonal(){ return diagonal; }

    public void convertToRectangle(double x1, double y1, double x2, double y2){
        //Vertical
        lines[0] = new Line(x1, y1, x1, y2);
        //Vertical
        lines[1] = new Line(x2, y1, x2, y2);
        //Horizonal
        lines[2] = new Line(x1, y1, x2, y1);
        //Horizontal
        lines[2] = new Line(x1, y2, x2, y2);
    }

    public setLine
}