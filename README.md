# Chips Challenge
Create a Chips class that will play a legal number of chips when called by the Chips driver (supplied).
## How to Play
* Create your ChipsPlayer subclass.
* Override the makeMove method with your own makeMove method.
* Compile and test your subclass
* Add your class file to the ChipsDriver at Line 47 (enter it in twice, once for players, and once for players2)

## What to Create
Create your own ChipsPlayer subclass by extending the ChipsPlayer class. Your subclass can compete in Chips matches.

Name your class using the following convention: ChipsPlayer_LastFirst (Last = your last name, First = your first name).

For example, one possible class header would be:
`public class ChipsPlayer_MillsteinDennis extends ChipsPlayer`

`// The "extends ChipsPlayer" defines ChipsPlayer_MillsteinDennis as a subclass of ChipsPlayer.`

Your class should provide two constructors:

* A zero parameter constructor which only needs to call the ChipsPlayer zero parameter constructor
* A two parameter constructor which accepts two Strings (name and nickname), your two parameter constructor will call the ChipsPlayer two parameter constructor (remember to use super)

Your class needs to override only the ChipsPlayer makeMove method:
`public int makeMove(int numRemaining, boolean isFirstMove, int lastMove)`

where numRemaining is the number of chips left in the pile before you make your move, isFirstMove indicates whether or not this is the first move of the game, and lastMove represents the number of chips removed by the other player on the previous move.

Your makeMove method should, when invoked, do the following:
* Use the isFirstMove parameter to determine if it is making the first move of a game. Remember, the rules for how many chips may be taken is different for the first move of the game. 
* Determine the best number of chips to take given the numRemaining, isFirstMove, and lastMove inputs.
* Ensure the move is valid (between 1 and numRemaining for the first move, between 1 and 2 * lastMove for all other moves)
* Return an integer value (the number of chips to take on this move).

#Chips Rules
* Two players take turns removing chips from a pile with n number of chips.
* The first player to play can remove between 1 and (n-1) chips.
* The next player can remove between 1 and 2x the previous number of chips removed by the other player.
* The player to remove the last chip from the pile WINS.
