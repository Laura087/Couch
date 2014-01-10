Couch
=====

Mecanum Couch Project

##To RUN


###WINDOWS - definitely working

javac -d bin -sourcepath src -cp bin;lib/jinput.jar src/Main.java

java -Djava.library.path=lib/Controller -cp bin;lib/jinput.jar Main

###LINUX - untested

javac -d bin -sourcepath src -cp bin:lib/jinput.jar src/Main.java

java -Djava.library.path=lib/Controller -Djinput.plugins=net.java.games.input.LinuxEnvironmentPlugin -cp bin:lib/jinput.jar Main


###LINUX ARM (Raspberry Pi) - Not Working

