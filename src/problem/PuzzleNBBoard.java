package problem;

import aima.core.agent.Action;
import aima.core.agent.impl.DynamicAction;



public class PuzzleNBBoard {

	public static Action LEFT = new DynamicAction("Left");

	public static Action LEFT1 = new DynamicAction("Left1");
	
	public static Action LEFT2 = new DynamicAction("Left2");

	public static Action RIGHT = new DynamicAction("Right");

	public static Action RIGHT1 = new DynamicAction("Right1");
	
	public static Action RIGHT2 = new DynamicAction("Right2");

	private int[] state;

	public PuzzleNBBoard() {	
		state = new int[] { 1, 1, 1, 0, 2, 2, 2 };
	}
	
	public PuzzleNBBoard(int[] state) {
		this.state = new int[state.length];
		System.arraycopy(state, 0, this.state, 0, state.length);
	}
	
	public PuzzleNBBoard(PuzzleNBBoard copyBoard) {
		this(copyBoard.getState());
	}
	
	public int[] getState() {
		return state;
	}
	
	private int getPositionOf(int val) {
		int retVal = -1;
		for (int i = 0; i < 7; i++) {
			if (state[i] == val) {
				retVal = i;
			}
		}
		return retVal;
	}
	
	public boolean canMoveGap(Action where) {
		boolean puedeMover = true;
		int posGap = getPositionOf(0);
		
			
			if(where.equals(LEFT)) posGap = posGap-1; 
			
			else if(where.equals(LEFT1)) posGap = posGap-2; 
			
			else if(where.equals(LEFT2)) posGap = posGap-3; 
			
			else if(where.equals(RIGHT)) posGap = posGap+1; 
			
			else if(where.equals(RIGHT1)) posGap = posGap+2; 
			
			else if(where.equals(RIGHT2)) posGap = posGap+3; 

		
		if(posGap < 0 || posGap > state.length-1) puedeMover = false;
		
		return puedeMover;
	}

	
	public String toString() {
		String retVal = state[0] + " " + state[1] + " " + state[2] + " "
				+ state[3] + " " + state[4] + " " + state[5] + " " 
				+ state[6];
		return retVal;
	}
	
	
	public void moveGapRight() {
		int posGap = getPositionOf(0);
		int aux = state[posGap+1];
		state[posGap+1] = 0;
		state[posGap] = aux;
	}
	
	public void moveGapRight1() {
		int posGap = getPositionOf(0);
		int aux = state[posGap+2];
		state[posGap+2] = 0;
		state[posGap] = aux;
	}
	
	public void moveGapRight2() {
		int posGap = getPositionOf(0);
		int aux = state[posGap+3];
		state[posGap+3] = 0;
		state[posGap] = aux;
	}
	
	public void moveGapLeft() {
		int posGap = getPositionOf(0);
		int aux = state[posGap-1];
		state[posGap-1] = 0;
		state[posGap] = aux;
	}
	
	public void moveGapLeft1() {
		int posGap = getPositionOf(0);
		int aux = state[posGap-2];
		state[posGap-2] = 0;
		state[posGap] = aux;
	}
	
	public void moveGapLeft2() {
		int posGap = getPositionOf(0);
		int aux = state[posGap-3];
		state[posGap-3] = 0;
		state[posGap] = aux;
	}

}
















