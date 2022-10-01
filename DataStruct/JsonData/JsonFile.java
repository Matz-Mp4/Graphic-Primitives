package DataStruct.JsonData;

import DataStruct.LinkedList.DoublyLinkedList;
import DataStruct.LinkedList.Node;
import DataStruct.List.PrimitiveList;
import Primitives2D.PrimitiveGr2D;
import Primitives2D.Circle2D.Circle;
import Primitives2D.Circle2D.CircleGr;
import Primitives2D.Line2D.LineGr;
import Primitives2D.Point2D.Point;
import Primitives2D.Polygon2D.Polygon;
import Primitives2D.Polygon2D.PolygonalLineGr;
import Primitives2D.Rectangle2D.RectangleGr;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONString;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.Color;
import javax.swing.JOptionPane;

public class JsonFile {

    private PrimitiveList list;
    private JSONObject mainJson;
    private String primitives[];

    public JsonFile(PrimitiveList list){
        this.list = list;
        primitives = list.getTypes();
    }

    public void createJSON(String fileName){
        mainJson = new JSONObject();

        JSONArray lineArray = new JSONArray();
        JSONArray circleArray = new JSONArray();
        JSONArray rectangleArray = new JSONArray();
        JSONArray polygonArray = new JSONArray();
        JSONArray polygonLineArray = new JSONArray();


        for(DoublyLinkedList primitiveList : list.getLinkedList()){
            Node aux = primitiveList.getBegin();
            String valor = primitiveList.getType();
            switch(valor){
                case "Line":
                lineToJson(lineArray, aux);
                mainJson.put("Line", lineArray);
                break;
                case "Circle":
                circleToJson(circleArray, aux);
                mainJson.put("Circle", circleArray);
                break;
                case "Rectangle":
                rectangleToJson(rectangleArray, aux);
                mainJson.put("Rectangle", rectangleArray);
                break;
                case "Polygon":
                polygonToJson(polygonArray, aux);
                mainJson.put("Polygon", polygonArray);
                break;
                case "Polygonal Line":
                polygonLineToJson(polygonLineArray, aux);
                mainJson.put("Polygonal Line", polygonLineArray);
                break;
            }
        }

        createFile(fileName, mainJson);
    }

    public void getJson(String fileName, PrimitiveList list){
        File file = null;
        BufferedReader br = null;
        FileReader fr = null;
        
        //caminho do arquivo
        file = new File(fileName);
        if (!file.exists()) { //testa para ver se o arquivo existe
            JOptionPane.showInputDialog("Arquivo inexistente");
        }
        String jsonString = "";
        try {
            String jsonString2 = "";
            
            fr = new FileReader(file);
            br = new BufferedReader(fr);

            while((jsonString2 = br.readLine()) != null){
                jsonString += jsonString2;
            }
            
        } catch(FileNotFoundException ex) {
            JOptionPane.showInputDialog("Arquivo inexistente:");
        } catch(Exception ex) {
            JOptionPane.showInputDialog("Erro inesperado ao tentar abrir o arquivo: ");
            ex.printStackTrace();
        }finally{
            
        }

        JSONObject jsonObj = new JSONObject(jsonString);

        if(jsonObj != null){
            list.deleteAll();
            //Add lines
            JSONArray lines = jsonObj.getJSONArray("Line");
            for(int i = 0; i < lines.length(); i++){
                JSONObject line = lines.getJSONObject(i);

                JSONObject p1 = line.getJSONObject("p1");
                int x1 = p1.getInt("x");
                int y1 = p1.getInt("y");

                JSONObject p2 = line.getJSONObject("p2");
                int x2 = p2.getInt("x");
                int y2 = p2.getInt("y");

                JSONObject color = line.getJSONObject("color");
                int r = color.getInt("r");
                int g = color.getInt("g");
                int b = color.getInt("b");

                LineGr lineGr = new LineGr(x1, y1, x2, y2);
                lineGr.setLineColor(new Color(r, g, b));
                list.add(lineGr, "Line");
            }

            JSONArray circles = jsonObj.getJSONArray("Circle");
            for(int i = 0; i < circles.length(); i++){
                JSONObject circle = circles.getJSONObject(i);

                JSONObject point = circle.getJSONObject("point");
                double x = point.getDouble("x");
                double y = point.getDouble("y");

                double radius = circle.getDouble("radius");

                JSONObject color = circle.getJSONObject("color");
                int r = color.getInt("r");
                int g = color.getInt("g");
                int b = color.getInt("b");

                CircleGr circleGr = new CircleGr((int) x, (int) y, (int) radius, "");
                circleGr.setCircleColor(new Color(r,g,b));
                list.add(circleGr, "Circle");
            }

            JSONArray retangles = jsonObj.getJSONArray("Rectangle");
            for(int i = 0; i < retangles.length(); i++){
                JSONObject retangle = retangles.getJSONObject(i);

                JSONObject p1 = retangle.getJSONObject("p1");
                int x1 = p1.getInt("x");
                int y1 = p1.getInt("y");

                JSONObject p2 = retangle.getJSONObject("p2");
                int x2 = p2.getInt("x");
                int y2 = p2.getInt("y");
/* 
                JSONObject p3 = retangle.getJSONObject("p3");
                int x3 = p1.getInt("x");
                int y3 = p1.getInt("y");

                JSONObject p4 = retangle.getJSONObject("p4");
                int x4 = p2.getInt("x");
                int y4 = p2.getInt("y");
*/

                JSONObject color = retangle.getJSONObject("color");
                int r = color.getInt("r");
                int g = color.getInt("g");
                int b = color.getInt("b");

                RectangleGr rectangle = new RectangleGr(new Point(1,1), new Point(1,1));
                rectangle.setRectangelColor(new Color(r,g,b));
                rectangle.convertToRectangle(x1, y1, x2, y2);
                list.add(rectangle, "Rectangle");
            }

            JSONArray polygons = jsonObj.getJSONArray("Polygon");
            for(int i = 0; i < polygons.length(); i++){
                JSONObject polygon = polygons.getJSONObject(i);
                JSONArray pointsArray = polygon.getJSONArray("ponto");

                Polygon polygonGr = new Polygon();

                JSONObject firstPoint = pointsArray.getJSONObject(0);
                double xAnt = firstPoint.getDouble("x");
                double yAnt = firstPoint.getDouble("y");
        
                for(int j = 1; j < pointsArray.length(); j++){
                    JSONObject point = pointsArray.getJSONObject(i);
                    double x = point.getDouble("x");
                    double y = point.getDouble("y");
                    
                    polygonGr.getList().add(new LineGr((int) xAnt, (int)yAnt,(int) x,(int) y), "Polygon");
                    xAnt = x; yAnt = y;
                }

                JSONObject color = polygon.getJSONObject("color");
                int r = color.getInt("r");
                int g = color.getInt("g");
                int b = color.getInt("b");

                polygonGr.setColorPolygon(new Color(r,g,b));
                list.add(polygonGr, "Polygon");
            }

            JSONArray polygonalLine = jsonObj.getJSONArray("Polygonal Line");
            for(int i = 0; i < polygonalLine.length(); i++){
                JSONObject polygonal = polygonalLine.getJSONObject(i);
                JSONArray pointsArray = polygonal.getJSONArray("point");

                PolygonalLineGr polygonGr = new PolygonalLineGr();

                JSONObject firstPoint = pointsArray.getJSONObject(0);
                double xAnt = firstPoint.getDouble("x");
                double yAnt = firstPoint.getDouble("y");
        
                for(int j = 1; j < pointsArray.length(); j++){
                    JSONObject point = pointsArray.getJSONObject(i);
                    double x = point.getDouble("x");
                    double y = point.getDouble("y");
                    
                    polygonGr.getList().add(new LineGr((int) xAnt, (int)yAnt,(int) x,(int) y), "Polygonal Line");
                    xAnt = x; yAnt = y;
                }

                JSONObject color = polygonal.getJSONObject("color");
                int r = color.getInt("r");
                int g = color.getInt("g");
                int b = color.getInt("b");

                polygonGr.setColorPolygonalLine(new Color(r,g,b));
                list.add(polygonGr, "Polygonal Line");
            }
        }
    }
    

    private void polygonToJson(JSONArray polygonArray, Node aux){
        while(aux != null){
            JSONObject polygon = new JSONObject();
            JSONArray polygonPoints = new JSONArray();
            Polygon polygonAux = (Polygon) aux.getItem();

            LineGr line = null;

            Node node = polygonAux.getList().getBegin();
            while(node != null){
                line = (LineGr) node.getItem();
                JSONObject p = new JSONObject();
                p.put("x", line.getP1().getX());
                p.put("y", line.getP1().getY());

                polygonPoints.put(p);
                node = node.getNext();
            }
 
            //Adicionando ultimo ponto
            if(line != null){ //Precisa deixar pois capta sempre o primeiro ponto. No final do loop teremos o ultimo ponto
                JSONObject p = new JSONObject();
                p.put("x", line.getP2().getX());
                p.put("y", line.getP2().getY());
                polygonPoints.put(p);
            } 

            polygon.put("point", polygonPoints);

            JSONObject color = new JSONObject();
            color.put("r", polygonAux.getColorPolygon().getRed());
            color.put("g", polygonAux.getColorPolygon().getGreen());
            color.put("b", polygonAux.getColorPolygon().getBlue());
            polygon.put("color", color);

            polygonArray.put(polygon);
            aux = aux.getNext();
        }
    }

    private void polygonLineToJson(JSONArray polygonLineArray, Node aux){
        while(aux != null){
            JSONObject polygon = new JSONObject();
            JSONArray polygonPoints = new JSONArray();
            PolygonalLineGr polygonAux = (PolygonalLineGr) aux.getItem();

            LineGr line = null;

            Node node = polygonAux.getList().getBegin();
            while(node != null){
                line = (LineGr) node.getItem();
                JSONObject p = new JSONObject();
                p.put("x", line.getP1().getX());
                p.put("y", line.getP1().getY());

                polygonPoints.put(p);
                node = node.getNext();
            }

            //Adicionando ultimo ponto
            if(line != null){ //Precisa deixar pois capta sempre o primeiro ponto. No final do loop teremos o ultimo ponto
                JSONObject p = new JSONObject();
                p.put("x", line.getP2().getX());
                p.put("y", line.getP2().getY());
                polygonPoints.put(p);
            }

            polygon.put("point", polygonPoints);

            JSONObject color = new JSONObject();
            color.put("r", polygonAux.getColorPolygonalLine().getRed());
            color.put("g", polygonAux.getColorPolygonalLine().getGreen());
            color.put("b", polygonAux.getColorPolygonalLine().getBlue());
            polygon.put("color", color);

            polygonLineArray.put(polygon);
            aux = aux.getNext();
        }
    }

    private void rectangleToJson(JSONArray rectangleArray, Node aux){
        while(aux != null){
            JSONObject rectangle = new JSONObject();
            RectangleGr rectangleAux = (RectangleGr) aux.getItem();

            JSONObject p1 = new JSONObject();
            p1.put("x", rectangleAux.getDiagonal().getP1().getX());
            p1.put("y", rectangleAux.getDiagonal().getP1().getY());

            JSONObject p2 = new JSONObject();
            p2.put("x", rectangleAux.getDiagonal().getP2().getX());
            p2.put("y", rectangleAux.getDiagonal().getP2().getY());

            JSONObject p3 = new JSONObject();
            p3.put("x", rectangleAux.getDiagonal().getP1().getX());
            p3.put("y", rectangleAux.getDiagonal().getP2().getY());

            JSONObject p4 = new JSONObject();
            p4.put("x", rectangleAux.getDiagonal().getP2().getX());
            p4.put("y", rectangleAux.getDiagonal().getP1().getY());

            JSONObject color = new JSONObject();
            color.put("r", rectangleAux.getRectangelColor().getRed());
            color.put("g", rectangleAux.getRectangelColor().getGreen());
            color.put("b", rectangleAux.getRectangelColor().getBlue());

            rectangle.put("p1", p1); rectangle.put("p2", p2); 
            rectangle.put("p3", p3); rectangle.put("p4", p4);
            rectangle.put("color", color);

            rectangleArray.put(rectangle);
            aux = aux.getNext();
        }
    }

    private void circleToJson(JSONArray circleArray, Node aux){
        while(aux != null){
            JSONObject circle = new JSONObject();
            CircleGr circleAux = (CircleGr) aux.getItem();

            JSONObject point = new JSONObject();
            point.put("x", circleAux.getX()); point.put("y", circleAux.getY());

            JSONObject color = new JSONObject();
            color.put("r", circleAux.getCircleColor().getRed());
            color.put("g", circleAux.getCircleColor().getGreen());
            color.put("b", circleAux.getCircleColor().getBlue());

            circle.put("point", point);
            circle.put("radius", circleAux.getRadius());
            circle.put("color", color);

            circleArray.put(circle);

            aux = aux.getNext();
        }
    }

    private void lineToJson(JSONArray lineArray, Node aux) {
        while(aux != null){
            JSONObject line = new JSONObject();
            LineGr lineAux = (LineGr) aux.getItem();

            double x = lineAux.getP1().getX(); double y = lineAux.getP1().getY();
            JSONObject p1 = new JSONObject();
            p1.put("x", x); p1.put("y", y);

            x = lineAux.getP2().getX(); y = lineAux.getP2().getY();
            JSONObject p2 = new JSONObject();
            p2.put("x", x); p2.put("y", y);

            JSONObject color = new JSONObject();
            color.put("r", lineAux.getLineColor().getRed());
            color.put("g", lineAux.getLineColor().getGreen());
            color.put("b", lineAux.getLineColor().getBlue());

            line.put("p1", p1);
            line.put("p2", p2);
            line.put("color", color);
            lineArray.put(line);
            aux = aux.getNext();
        }
    }

    private void createFile(String fileName, JSONObject json) {
        FileWriter writeFile;

        try{
            writeFile = new FileWriter(fileName+".json");
            writeFile.write(json.toString());
            writeFile.close();
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

}