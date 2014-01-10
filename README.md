Couch
=====

Mecanum Couch Project

###NOTE

###The CONFIG file

The config file uses JSON to change settings for the couch in one place. However, you should not need to do anything with it to get things working. 

###To RUN


####WINDOWS - definitely working

javac -d bin -sourcepath src -cp bin;lib/jinput.jar src/Main.java

java -Djava.library.path=lib/Controller -cp bin;lib/jinput.jar Main

####LINUX - untested

javac -d bin -sourcepath src -cp bin:lib/jinput.jar src/Main.java

java -Djava.library.path=lib/Controller -Djinput.plugins=net.java.games.input.LinuxEnvironmentPlugin -cp bin:lib/jinput.jar Main


####LINUX ARM (Raspberry Pi) - Not Working

