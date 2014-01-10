Couch
=====

Mecanum Couch Project

###NOTE
--It runs fine on Windows, you should get a screen with an output feild and information about each motor. 

--If you run it with no gamepad connected it will output the message "ERROR: no controllers found Controller Initialisation Error". 

--It is configured to work with a microsoft wired USB Xbox controller

--With the default control scheme, holding the right trigger and moving the thumbsticks should change the motor values


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

