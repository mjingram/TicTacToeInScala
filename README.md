# Tic Tac Toe Game in Scala (Functional and Object Oriented programming game)

This is a command line application of the game tic tac toe written in scala. It contains classes tic tac toe, 
player and game board. This program follows the functional programming paradigm as much as possible meaning there are 
no mutable items, side effects and there are no loops. All methods are recursive. 

The computer decides its moves via random number generation. Since it is random and not based on the previous state of the 
game, the computer is not too hard to beat

### How to play

When the program starts choose if you want to be X's or O's. Next choose the row number and then column number.
The numbers must be between 0 - 2 and correspond to the game board as follows

(0,0) | (0,1) | (0,2)
---------------------
(1,0) | (1,1) | (1,2)
---------------------
(2,0) | (2,1) | (2,2)
---------------------

After your turn the computer will then play their move. Rounds will continue until a plater gets three in a row 
or the board fills up without a winner resulting in a draw. 
