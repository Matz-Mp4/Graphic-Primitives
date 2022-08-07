TARGET = App

all:
	$(RM) *.class
	javac $(TARGET).java
	java App

