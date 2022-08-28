package Primitives2D.Line2D;


import java.awt.Color;
import java.awt.Graphics;

import Primitives2D.Point2D.PointGr;
import Primitives2D.Point2D.Point;

public class SuperLineGr extends Line {

  private Color lineColor = Color.BLACK;
  private String nameLine = "";
  private Color nameLineColor = Color.BLACK;

  public SuperLineGr(int x1, int y1, int x2, int y2) {
    super((double) x1, (double) y1, (double) x2, (double) y2);
    setLineColor(this.lineColor);
    setNameLineColor(this.nameLineColor);
    setNameLine("Generic Name");
  }

  public SuperLineGr(int x1, int y1, int x2, int y2, String nome) {
    super((double) x1, (double) y1, (double) x2, (double) y2);
    setLineColor(lineColor);
    setNameLineColor(nameLineColor);
    setNameLine(nome);
  }

  public SuperLineGr(int x1, int y1, int x2, int y2, Color corReta, Color corNome, String nome) {
    super((double) x1, (double) y1, (double) x2, (double) y2);
    setLineColor(corReta);
    setNameLineColor(corNome);
    setNameLine(nome);
  }

  public SuperLineGr(PointGr x, PointGr y) {
    super(x, y);
    setLineColor(this.lineColor);
    setNameLineColor(this.nameLineColor);
    setNameLine("Generic Name");

  }

  public SuperLineGr(Point x, Point y) {
    super(x, y);
    setLineColor(this.lineColor);
    setNameLineColor(this.nameLineColor);
    setNameLine("Generic Name");
  }

  public SuperLineGr(Line reta) {
    super(reta);
    //setLineColor(nameLineColor);
    //setNameLineColor(corNome);
    //setNameLine(nome);
  }

  public Color getLineColor() {
    return lineColor;
  }

  public void setLineColor(Color lineColor) {
    this.lineColor = lineColor;
  }

  public String getNameLine() {
    return nameLine;
  }

  public void setNameLine(String nameLine) {
    this.nameLine = nameLine;
  }

  public Color getNameLineColor() {
    return nameLineColor;
  }

  public void setNameLineColor(Color nameLineColor) {
    this.nameLineColor = nameLineColor;
  }
}
