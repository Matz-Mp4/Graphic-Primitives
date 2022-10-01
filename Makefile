TARGET = App

all:
	javac -cp ".:./Dependecies/json-20220924.jar" $(TARGET).java
	java -cp ".:./Dependecies/json-20220924.jar" App
	$(RM) *.class
	$(RM) ./Primitives2D/*.class  
	$(RM) ./Primitives2D/Point2D/*.class  
	$(RM) ./Primitives2D/Polygon2D/*.class
	$(RM) ./Primitives2D/Line2D/*.class
	$(RM) ./Primitives2D/Circle2D/*.class
	$(RM) ./Primitives2D/Rectangle2D/*.class
	$(RM) ./DataStruct/LinkedList/*.class
	$(RM) ./DataStruct/List/*.class
	$(RM) ./DataStruct/JsonData/*.class
	$(RM) ./Gui/Panels/*.class
	$(RM) ./Gui/*.class

clean:

	$(RM) *.class
	$(RM) ./Primitives2D/*.class  
	$(RM) ./Primitives2D/Point2D/*.class  
	$(RM) ./Primitives2D/Line2D/*.class
	$(RM) ./Primitives2D/Circle2D/*.class
	$(RM) ./Primitives2D/Polygon2D/*.class
	$(RM) ./Primitives2D/Rectangle2D/*.class
	$(RM) ./DataStruct/LinkedList/*.class
	$(RM) ./DataStruct/List/*.class
	$(RM) ./DataStruct/JsonData/*.class
	$(RM) ./Gui/Panels/*.class
	$(RM) ./Gui/*.class





