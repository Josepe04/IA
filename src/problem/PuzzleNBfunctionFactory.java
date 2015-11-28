package problem;


import java.util.LinkedHashSet;
import java.util.Set;

import aima.core.agent.Action;
import aima.core.search.framework.ActionsFunction;
import aima.core.search.framework.ResultFunction;
import aima.core.search.framework.StepCostFunction;

public class PuzzleNBfunctionFactory {

	private static ActionsFunction _actionsFunction = null;
	private static ResultFunction _resultFunction = null;
	private static StepCostFunction _StepCostFunction = null;
	
	
	public static ActionsFunction getActionsFunction() {
		if (null == _actionsFunction) {
			_actionsFunction = new NBActionsFunction();
		}
		return _actionsFunction;
	}

	public static ResultFunction getResultFunction() {
		if (null == _resultFunction) {
			_resultFunction = new NBResultFunction();
		}
		return _resultFunction;
	}
	
	public static StepCostFunction getStepCostFunction() {
		if (null == _StepCostFunction) {
			_StepCostFunction = new NBStepCostFunction();
		}
		return _StepCostFunction;
	}
	
	private static class NBActionsFunction implements ActionsFunction {
		public Set<Action> actions(Object state) {
			PuzzleNBBoard board = (PuzzleNBBoard) state;

			Set<Action> actions = new LinkedHashSet<Action>();

			if (board.canMoveGap(PuzzleNBBoard.LEFT)) {
				actions.add(PuzzleNBBoard.LEFT);
			}
			if (board.canMoveGap(PuzzleNBBoard.LEFT1)) {
				actions.add(PuzzleNBBoard.LEFT1);
			}
			if (board.canMoveGap(PuzzleNBBoard.LEFT2)) {
				actions.add(PuzzleNBBoard.LEFT2);
			}
			if (board.canMoveGap(PuzzleNBBoard.RIGHT)) {
				actions.add(PuzzleNBBoard.RIGHT);
			}
			if (board.canMoveGap(PuzzleNBBoard.RIGHT1)) {
				actions.add(PuzzleNBBoard.RIGHT1);
			}
			if (board.canMoveGap(PuzzleNBBoard.RIGHT2)) {
				actions.add(PuzzleNBBoard.RIGHT2);
			}

			return actions;
		}
	}

	private static class NBStepCostFunction implements StepCostFunction{

		@Override
		public double c(Object ini, Action a, Object arg2) {
			PuzzleNBBoard board = (PuzzleNBBoard) ini;
			if (PuzzleNBBoard.LEFT.equals(a)
					&& board.canMoveGap(PuzzleNBBoard.LEFT)) {
				return 1;
			}else if (PuzzleNBBoard.LEFT1.equals(a)
					&& board.canMoveGap(PuzzleNBBoard.LEFT1)) {
				return 1;
			}else if (PuzzleNBBoard.LEFT2.equals(a)
					&& board.canMoveGap(PuzzleNBBoard.LEFT2)) {
				return 2;
			}else if (PuzzleNBBoard.RIGHT.equals(a)
					&& board.canMoveGap(PuzzleNBBoard.RIGHT)) {
				return 1;
			}else if (PuzzleNBBoard.RIGHT1.equals(a)
					&& board.canMoveGap(PuzzleNBBoard.RIGHT1)) {
				return 1;
			}else if (PuzzleNBBoard.RIGHT2.equals(a)
					&& board.canMoveGap(PuzzleNBBoard.RIGHT2)) {
				return 2;
			}
			return 0;
		}
		
	}

	private static class NBResultFunction implements ResultFunction {
		public Object result(Object s, Action a) {
			PuzzleNBBoard board = (PuzzleNBBoard) s;

			if (PuzzleNBBoard.LEFT.equals(a)
					&& board.canMoveGap(PuzzleNBBoard.LEFT)) {
				PuzzleNBBoard newBoard = new PuzzleNBBoard(board);
				newBoard.moveGapLeft();
				return newBoard;
			}else if (PuzzleNBBoard.LEFT1.equals(a)
					&& board.canMoveGap(PuzzleNBBoard.LEFT1)) {
				PuzzleNBBoard newBoard = new PuzzleNBBoard(board);
				newBoard.moveGapLeft1();
				return newBoard;
			}else if (PuzzleNBBoard.LEFT2.equals(a)
					&& board.canMoveGap(PuzzleNBBoard.LEFT2)) {
				PuzzleNBBoard newBoard = new PuzzleNBBoard(board);
				newBoard.moveGapLeft2();
				return newBoard;
			}else if (PuzzleNBBoard.RIGHT.equals(a)
					&& board.canMoveGap(PuzzleNBBoard.RIGHT)) {
				PuzzleNBBoard newBoard = new PuzzleNBBoard(board);
				newBoard.moveGapRight();
				return newBoard;
			}else if (PuzzleNBBoard.RIGHT1.equals(a)
					&& board.canMoveGap(PuzzleNBBoard.RIGHT1)) {
				PuzzleNBBoard newBoard = new PuzzleNBBoard(board);
				newBoard.moveGapRight1();
				return newBoard;
			}else if (PuzzleNBBoard.RIGHT2.equals(a)
					&& board.canMoveGap(PuzzleNBBoard.RIGHT2)) {
				PuzzleNBBoard newBoard = new PuzzleNBBoard(board);
				newBoard.moveGapRight2();
				return newBoard;
			}

			// The Action is not understood or is a NoOp
			// the result will be the current state.
			return s;
		}
	}
	
	
}



