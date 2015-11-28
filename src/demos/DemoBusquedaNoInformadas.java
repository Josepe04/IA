package demos;

import java.util.List;

import problem.PuzzleNBBoard;
import problem.PuzzleNBGoalTest;
import problem.PuzzleNBfunctionFactory;
import aima.core.agent.Action;
import aima.core.search.framework.Problem;
import aima.core.search.framework.Search;
import aima.core.search.framework.SearchAgent;
import aima.core.search.framework.TreeSearch;
import aima.core.search.uninformed.BreadthFirstSearch;
import aima.core.search.uninformed.DepthFirstSearch;
import aima.core.search.uninformed.DepthLimitedSearch;


public class DemoBusquedaNoInformadas {

	public static void main(String[] args) {
		Problem p = new Problem(new PuzzleNBBoard() , PuzzleNBfunctionFactory.getActionsFunction(),
						PuzzleNBfunctionFactory.getResultFunction(), new PuzzleNBGoalTest(),PuzzleNBfunctionFactory.getStepCostFunction());
		
		BreadthFirstSearch sBreadth = new BreadthFirstSearch();
		List<Action> l = sBreadth.search(p);
		System.out.println("-Resultados BreadthFirstSearch");
		System.out.println("Actions:");
		System.out.println(l.toString());
		System.out.println("Coste:");
		System.out.println(sBreadth.getMetrics().toString());
		
		try {
			Search search = new DepthLimitedSearch(9);
			//Search search = new DepthLimitedSearch(9);
			List<Action> l2 = search.search(p);
			//SearchAgent agent = new SearchAgent(p, search);
			System.out.println("");
			System.out.println("-Resultados DepthLimitedSearch");
			System.out.println("Actions:");
			System.out.println(l2.toString());
			System.out.println("Coste:");
			System.out.println(search.getMetrics().toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
