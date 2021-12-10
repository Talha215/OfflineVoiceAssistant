While it may be possible to run the files on a command line, we had our best results running it in our IDEs for both Java and Python.

JAVA:
1- Import the files in BumblebeeJava/src/ to the project folder. We used Eclipse and IntelliJ. Both should work.
2- Add the required libraries as dependencies:
	Guava, JSON parser, JSoup, MaryTTS (multiple JARs)
3- The links for the libraries are as follows:
	Guava: http://search.maven.org/remotecontent?filepath=com/google/guava/guava/23.0/guava-23.0.jar
	JSON: https://search.maven.org/remotecontent?filepath=org/json/json/20211205/json-20211205.jar
	JSoup: https://jsoup.org/packages/jsoup-1.14.3.jar
	MaryTTS: https://github.com/marytts/marytts/releases/download/v5.2/marytts-5.2.zip 
		(use marytts-runtime-5.2-jar-with-dependencies.jar, marytts-lang-en-5.2.jar, and voice-dfki-poppy-hsmm-5.2.jar)
4- Run the GUI.java's main method in the IDE. No arguments are required.
5- There will be no output until the Python side starts running.

PYTHON:
1- Import the two .py files in BumblebeeJava/BumblebeePython/ into a PyCharm project.
2- Install the required python 3 modules via the package manager in Pycharm or via pip:
	SoundFile==0.10.3.post1
	numpy==1.21.3
	pip==19.3.1
	playsound==1.3.0
	pvporcupine==1.9.5 (IMPORTANT TO BE ON THIS VERSION)
	pvrecorder==1.0.2
	pycparser==2.20
	simpleaudio==1.0.2
	sounddevice==0.4.3
	vosk==0.3.32
	NOTE: It is possible you need other modules, please refer to console output if you have errors.
3- Run the demo.py file with arguments "--keywords bumblebee"
4- If run on command line, the command would look like this:
		python demo.py --keywords bumblebee
5- Once the program starts running you will see a "Listening { bumblebee (0.50) }" ouptut in the console. This means the Python portion is working.

Once both programs are running, you can say "Bumblebee," then wait for the beep, then ask your query. This can be repeated however many times you like.
To close the program, you may close the GUI window in Java and terminate the program in PyCharm.
Here is a list of commands you can use in the program:
-about
-calculator
-coin
-date
-delete
-joke
-list
-notes
-read
-search
-syntax
-time
-timer
-weather