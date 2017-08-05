SCRAMBLE 2.0

** A Game where users must enter enter in words within a time limit to earn points.**
** The User with the most points wins!!!**



Version History:

07/03/2017: Recreation of previous semester work with improvements to server code. First files included with this commit are the Dictionary
Class that is used to store a set of words for verification so user can earn points on proper validation. Also included is a MainDriver
file that will be used to drive the main program once it is fixed and complete. Created and Included an Interface for the Scramble server
to handle data flow in an RMI method.

07/04/2017: Happy Fourth of July!!!\n
Overhaul of the Game Logic is underway, creation of new Player objects to store and hold information for game play use ensures that users have
their name, score, wins, loses and ties, and their word library. The idea is to have two User GUIs run asynchronous, at the end to the time end word entry
send the words to the server where then the word list is sent to each respective player object. Once that is done a Game Logic object is created and used
to score the words, where it is then evaluated and sent back to the users to determine who is the winner.

07/05/2017:The Day After... \n
Changed the visibility of some of the variables in Player. Began the implementation of the GameEngine class, creating logic methods to score the players
words and check to ensure word is a valid word. Made GameEngine implement runnable to run as thread as server is running. Started unit tests for Player class
will write unit tests as creating new classes to ensure functionality.

07/10/2017: Still Working...\n
Changed to have a simple socket server...nothing too crazy with this re-make. Working with game engine to make sure logic is working properly.

07/12/2017: Back at it again...\n
Implementation of a "SplashPage" class where users see the game name and option buttons to either start a game or quit game play. Need to work on Creating a EDT for the GUI Implementation. Server is working in regards to receiving user input and sending back, need to work with multiple thread types.

08/04/2017: Back Again Guys...\n
Hello all it has been a while since I last made any updates to anything really but this project/ review thing that I for some reason set up is back on its feed. I finally figured
out why the server was not continuously handling input and had that error fixed with a simple weird looking layout that is going to be fixed pretty shortly. I am also experimenting
with a card layout for the initial frame to get everything working on the same run thread.