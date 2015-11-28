package problem;

import aima.core.search.framework.GoalTest;

public class PuzzleNBGoalTest implements GoalTest {

	
	public boolean isGoalState(Object state){
		PuzzleNBBoard board = (PuzzleNBBoard)state;
		int estado[];
		estado = board.getState();
		int i = 0,j=0;
		while(i < 3){
			if(estado[j] == 2)
				i++;
			else if(estado[j] == 1){
				return false;
			}
			j++;
		}
		return true;
	}
}
