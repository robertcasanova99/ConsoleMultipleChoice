# ConsoleMultipleChoice
A small java program that will display terms and their definition as a multiple choice quiz in an IDE console.

The user will include a textfile where each line is composed of a word, a colon, and a definition in that order. Here is an example of an appropriate textfile that will be read successfully: <br />
 
Finland: Helsinki <br />
Pinyin: The official romanization system for Standard Chinese. <br />
Korea: Seoul <br />
First Battle of Bullrun: The first military confrontation of the U.S Civil War. <br />
Russia: Moscow <br />
Edward VIII: British monarch who abdicated the throne in 1936. <br />
Burma: Naypyidaw <br />


Said textfile must be placed in the directory of the project. After doing so and inputting the correct name of the file in the inputstream on line 28 of Driver.java, the program should be functional and quiz the user to match the term with 4 randomly chosen, not repeating, answer choices. The program will continue until it has ran through all of the terms and definitions. This can be changed by increasing the upper bound of the for-loop on line 40 of Driver.java.

