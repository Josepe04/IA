package problem;

import aima.core.search.framework.HeuristicFunction;

public class heuristica2 implements HeuristicFunction {

	@Override
	public double h(Object state) {
		int retorno = 0;
		PuzzleNBBoard board = (PuzzleNBBoard) state;
		retorno = valorHeuristica2(board);
		return retorno;
	}
	
	public int valorHeuristica2(PuzzleNBBoard board) {
		
		int valor = 0;
		int estado[] = board.getState();
		
		for(int i = 0; i < 7; i++) {
			
			if(i < 3) {
				int asumar=3-i;
				if(estado[i] == 1) valor += asumar;
				else if(estado[i] == 0 && estado[3] == 1) valor++;
			}
			else if(i > 3) {
				int asumar=i-3;
				if(estado[i] == 2) valor += asumar;
				else if(estado[i] == 0 && estado[3] == 2) valor++;
			}
		}
		
		return valor;
	}

}
