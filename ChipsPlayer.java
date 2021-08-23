import java.util.Random;

/*
 * Base class for a ChipsPlayer.
 * All other types of ChipsPlayers should extend this one.
*/
public class ChipsPlayer implements Comparable<ChipsPlayer>
{
		// Instance variables
		private String name = "unknown";
		private String nickname = "unknown";
		private int numMatchWins = 0;
		private int numMatchLosses = 0;
		private int numMatchTies = 0;
		private int numGameWins = 0;
		private int numGameLosses = 0;
		private int numGameDq = 0;
		// ArrayList<ChipsMatchResult> matchResults = new ArrayList<ChipsMatchResult>();
		
		//Constructors

		// Just so that this class has an explicit default constructor.
		public ChipsPlayer()
		{
				super();
				// All default values provided in declarations
		}
		

		public ChipsPlayer(String name, String nickname)
		{
				this.name = name;
				this.nickname = nickname;
		}
		
		// methods
		public String getName()
		{
				return name;
		}
		
		public String getNickname()
		{
				return nickname;
		}
		
		public int getNumMatchWins()
		{
				return numMatchWins;
		}
		
		public int getNumMatchLoses()
		{
				return numMatchLosses;
		}
		
		public int getNumMatchTies()
		{
				return numMatchTies;
		}
		
		public int getNumGameWins()
		{
				return numGameWins;
		}
		
		public int getNumGameLoses()
		{
				return numGameLosses;
		}
		
		public int getNumGameDq()
		{
				return numGameDq;
		}
		
		/*
		 * ChipsPlayers will be compared by winning percentage
		 * For purposes of this game, a tie is counted as 0.5 wins and 0.5 losses.
		*/
		public double getWinningPercentage()
		{
				double winningPercentage = 0.000;
				double denom = numMatchWins + numMatchLosses + numMatchTies;
				double num = numMatchWins + 0.5 * numMatchTies;
				if (denom == 0.0)
						winningPercentage = 0;
				else
						winningPercentage = num / denom;
			
				return winningPercentage;
		}
		
		/**
		 * 
		 * @param numRemaining: int number chips in pile before this move
		 * @param isFirstMove: boolean - informational, is this the first move of the game
		 * @param lastMove: int - informational, how many chips were removed last move
		 * @return
		 */
		public int makeMove(int numRemaining, boolean isFirstMove, int lastMove)
		{
				// Applies thoughtless strategy
				// Remove them all if it can
				// Otherwise, select a random number between 1 and maxMove
				int numRemove = 1;
				int maxMove = 2 * lastMove;
				if (isFirstMove)
						maxMove = numRemaining - 1;
				Random gen = new Random(System.currentTimeMillis());
				
				if (numRemaining <= maxMove)
				{
						numRemove = numRemaining;
				}
				else
				{
						numRemove = (int)(gen.nextDouble() * maxMove + 1);
				}
				 
				return numRemove;
		}
		
				
		public String toString()
		{
			return "ChipsPlayer";
		}
		
		/**
		
		 
			* To fulfill the commitment to meet the Comparable interface
			* Will implement in "reverse" order.  The method will assess the larger percentage as preceding the smaller.
			* This will result in the PriorityQueue working as a MaxHeap, that will sort ChipsPlayers by winning percentages
		 */
		
		@Override
		public int compareTo(ChipsPlayer other)
		{
				final double DELTA = 0.001;
				final int HIGHER_WIN_PERCENT = -1;
				final int SAME_WIN_PERCENT = 0;
				final int LOWER_WIN_PERCENT = 1;
				int rtnVal = SAME_WIN_PERCENT;
				
				double diffWinningPercentages = this.getWinningPercentage() - other.getWinningPercentage();
				if (diffWinningPercentages > DELTA)
						rtnVal = HIGHER_WIN_PERCENT;
				else if (diffWinningPercentages < -DELTA)
						rtnVal = LOWER_WIN_PERCENT;
				
				return rtnVal;
		}
			
		
		
		// main method used during development for testing this class
		public static void main(String[] args)
		{
				ChipsPlayer cp = new ChipsPlayer("Dennis", "TheAuthor");
				System.out.println(cp);

		}

		

}
