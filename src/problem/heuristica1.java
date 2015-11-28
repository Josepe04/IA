package problem;

import aima.core.search.framework.HeuristicFunction;

public class heuristica1 implements HeuristicFunction {

	@Override
	public double h(Object state) {
		int retorno = 0;
		PuzzleNBBoard board = (PuzzleNBBoard) state;
		retorno = valorHeuristica1(board);
		return retorno;
	}
	
	//v = 0 N N N E B B B pri +1 seg +2 ter +3 E pri +1 seg +2 ter +3
	
	public int valorHeuristica1(PuzzleNBBoard board) {
		int valor = 0;
		int estado[] = board.getState();
		int mult = 1;
		for(int i = 0; i < 7; i++){
			if(i<3 && estado[i] == 1){
				valor += 1*mult;
				mult++;
			} else if(i>3 && estado[i] == 2){
				valor += 1*mult;
				mult++;
			} else if(estado[i]==0 && i < 3){
				if(estado[3] == 1) valor++;
			} else if(estado[i]==0 && i > 3){
				if(estado[3] == 2) valor++;
			} 
		}
		return valor;
	}

}
