//William Akis

import java.util.Scanner;
import java.util.Random;

public class ChipsPlayer_AkisWilliam extends ChipsPlayer{
	
	
	// No new instance variables
	
	// Constructors
	public ChipsPlayer_AkisWilliam()
	{
		super();
	}
	
	public ChipsPlayer_AkisWilliam(String name, String nickname)
	{
		super(name, nickname);
	}
	
	@Override
	public int makeMove(int numRemaining, boolean isFirstMove, int lastMove){
				int numRemove = 1;
				int maxMoveLast = 2 * lastMove;
				if (isFirstMove)
                    maxMoveLast = numRemaining - 1;
				Random gen = new Random(System.currentTimeMillis());
				
				int maxMoveThird = Math.max(1, ((int) Math.ceil((double) numRemaining/3))-1);
                /*
                if (numRemaining%2==1)
                    {
                        maxMoveThird = Math.max(1, ((int) Math.ceil((double) numRemaining/3))-1);
                    }
                */
                // give 8
                // give 5
                if (numRemaining==12)
                    {
                        maxMoveThird = 2;             // I lose 12 but this for some reason helps against bad bots
                    }
                if (numRemaining==10)
                    {
                        maxMoveThird = 2;             // I win 10 by giving 8
                    }
                if (numRemaining==9)
                    {
                        maxMoveThird = 1;             // I win 9 by giving 8
                    }
                
                int maxMoveGood = Math.min(maxMoveLast, maxMoveThird);

				if (numRemaining <= maxMoveLast)
				{
                    numRemove = numRemaining;
				}
				else
				{
                    numRemove = maxMoveGood;
				}
				 
				return numRemove;
                
	}
	
	public String toString()
	{
		return "AkisWilliam";
	}
}