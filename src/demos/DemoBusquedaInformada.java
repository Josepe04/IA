package demos;

import java.util.List;

import problem.PuzzleNBBoard;
import problem.PuzzleNBGoalTest;
import problem.PuzzleNBfunctionFactory;
import problem.heuristica1;
import problem.heuristica2;
import aima.core.agent.Action;
import aima.core.environment.eightpuzzle.MisplacedTilleHeuristicFunction;
import aima.core.search.framework.GraphSearch;
import aima.core.search.framework.Problem;
import aima.core.search.framework.Search;
import aima.core.search.framework.SearchAgent;
import aima.core.search.framework.TreeSearch;
import aima.core.search.informed.AStarSearch;
import aima.core.search.informed.GreedyBestFirstSearch;

public class DemoBusquedaInformada {

	public static void main(String[] args) {
		Problem problem = new Problem(new PuzzleNBBoard() , PuzzleNBfunctionFactory.getActionsFunction(),
				PuzzleNBfunctionFactory.getResultFunction(), new PuzzleNBGoalTest(),PuzzleNBfunctionFactory.getStepCostFunction());

		try{
			Search search = new AStarSearch(new GraphSearch(),
					new heuristica1());
			List<Action> l = search.search(problem);
			//SearchAgent agent = new SearchAgent(p, search);
			System.out.println("-Resultados AStarSearch h1:");
			System.out.println(l.toString());
			System.out.println("Coste:");
			System.out.println(search.getMetrics().toString());
			System.out.println("");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try{
			Search search2 = new GreedyBestFirstSearch(new TreeSearch(),
					new heuristica1());
			List<Action> l2 = search2.search(problem);
			//SearchAgent agent = new SearchAgent(p, search);
			System.out.println("-Resultados AStarSearch h2:");
			System.out.println(l2.toString());
			System.out.println("Coste:");
			System.out.println(search2.getMetrics().toString());
			System.out.println("");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/*
		try{
			Search search = new GreedyBestFirstSearch(new TreeSearch(),
					new heuristica1());
			List<Action> l2 = search.search(problem);
			//SearchAgent agent = new SearchAgent(p, search);
			System.out.println("-Resultados GreedyBestFirstSearch h2:");
			System.out.println(l2.toString());
			System.out.println("Coste:");
			System.out.println(search.getMetrics().toString());
			System.out.println("");
		} catch (Exception e) {
			e.printStackTrace();
		}
		*/
	}

}
