//Douglas Kiang
//Provides text input for a human Chips player.

import java.util.Scanner;

public class ChipsPlayer_KiangDouglas extends ChipsPlayer{
	
	
	// No new instance variables
	
	// Constructors
	public ChipsPlayer_KiangDouglas()
	{
		super();
	}
	
	public ChipsPlayer_KiangDouglas(String name, String nickname)
	{
		super(name, nickname);
	}
	
	@Override
	public int makeMove(int number, boolean isFirstMove, int previousmove){
		return 1;
	}
	
	// public String toString()
	// {
	// 	return "Mr. Kiang";
	// }
}

