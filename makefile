J = java
JFLAG = -g
JC = javac

default:
	$(JC) UserInterface.java

clean: 
	rm *.class

run:
	@ $(J) UserInterface
