TARGET = App

all:
	javac $(TARGET).java
	java App
	$(RM) *.class
	$(RM) ./Primitives2D/Point2D/*.class  
	$(RM) ./Primitives2D/Polygon2D/*.class
	$(RM) ./Primitives2D/Line2D/*.class
	$(RM) ./Primitives2D/Circle2D/*.class
	$(RM) ./Primitives2D/Rectangle2D/*.class
	$(RM) ./DataStruct/LinkedList/*.class
	$(RM) ./Gui/Panels/*.class
	$(RM) ./Gui/*.class

clean:

	$(RM) *.class
	$(RM) ./Primitives2D/Point2D/*.class  
	$(RM) ./Primitives2D/Line2D/*.class
	$(RM) ./Primitives2D/Circle2D/*.class
	$(RM) ./Primitives2D/Polygon2D/*.class
	$(RM) ./Primitives2D/Rectangle2D/*.class
	$(RM) ./DataStruct/LinkedList/*.class
	$(RM) ./Gui/Panels/*.class
	$(RM) ./Gui/*.class





