//Douglas Kiang
//Provides text input for a human Chips player.

import java.util.Scanner;

public class ChipsPlayer_Human extends ChipsPlayer{
	
	
	// No new instance variables
	
	// Constructors
	public ChipsPlayer_Human()
	{
		super();
	}
	
	public ChipsPlayer_Human(String name, String nickname)
	{
		super(name, nickname);
	}
	
	@Override
	public int makeMove(int number, boolean isFirstMove, int previousmove){
		Scanner in = new Scanner(System.in);
		String lastmove = "" + 2 * previousmove;
		if(isFirstMove)
		{                     
			System.out.println("There are " + number + " chips");
			lastmove = "" + (number-1);
		}
		System.out.println("You can take between 1 and " + lastmove + " chips.");                     
		System.out.println("How many chips would you like to take? ");
		return in.nextInt();
	}
	
	public String toString()
	{
		return "Human";
	}
}

