SCRAMBLE 2.0

** A Game where users must enter enter in words within a time limit to earn points.**
** The User with the most points wins!!!**



Version History:

07/03/2017: Recreation of previous semester work with improvements to server code. First files included with this commit are the Dictionary
Class that is used to store a set of words for verification so user can earn points on proper validation. Also included is a MainDriver
file that will be used to drive the main program once it is fixed and complete. Created and Included an Interface for the Scramble server
to handle data flow in an RMI method.

07/04/2017: Happy Fourth of July!!!
Overhaul of the Game Logic is underway, creation of new Player objects to store and hold information for game play use ensures that users have
their name, score, wins, loses and ties, and their word library. The idea is to have two User GUIs run asynchronous, at the end to the time end word entry
send the words to the server where then the word list is sent to each respective player object. Once that is done a Game Logic object is created and used
to score the words, where it is then evaluated and sent back to the users to determine who is the winner.