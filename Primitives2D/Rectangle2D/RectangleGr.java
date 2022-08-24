package Primitives2D.Rectangle2D;

import Primitives2D.Rectangle2D.Rectangle;
import Primitives2D.Line2D.Line;
import Primitives2D.Line2D.LineGr;
import java.awt.Graphics;

import Gui.GuiUtils;

/**
 * Retângulo gráfico.
 *
 * @author Gabriel Cavalcanti
 * @version 15/08/2021
 */



public class RectangleGr extends Rectangle {
    public RectangleGr(int x1, int y1, int x2, int y2){
        super((double)x1, (double)y1, (double)x2,(double)y2);
    }
}