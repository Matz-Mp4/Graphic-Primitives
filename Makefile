TARGET = App

all:
	javac $(TARGET).java
	java App
	$(RM) *.class
	$(RM) ./Primitives2D/Point/*.class  
	$(RM) ./Primitives2D/Line2D/*.class
	$(RM) ./Primitives2D/Circle2D/*.class
	$(RM) ./Panels/*.class

