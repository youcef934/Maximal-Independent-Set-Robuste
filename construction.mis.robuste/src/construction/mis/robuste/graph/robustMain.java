	package construction.mis.robuste.graph;

import java.util.ArrayList;

/**
 *  * Theorem : All MISs are robust in a graph G if and only if G is complete bipartite or sputnik.
 *  
 *
 */
public class robustMain {

	
	
	/**
	 * Test With complete biparti graph
	 */
	private static void robustWithCompleteBipartiGraph() {
        System.err.println("Test With complete biparti graph");
        
		int v1 = 5; // sommets rouge
		int v2 = 3; // sommets bleu
		// contruction d'un graphe biparti
		graph graph = graphUtils.completeBipartiGraph(v1, v2);
        System.out.println("Martice adjacance:");
		graphUtils.displayV1(graph);
		
		System.out.println();
        
		misSet misSet = new misSet(graph);
        ArrayList<ArrayList<Integer>> res = misSet.maxIndependentSets();
        
        System.out.println("Maximal independent sets:");
        System.out.println(res);	
	}
	
	
	/**
	 * 
	 */
	public static void main(String[] args) {
		
		//
		robustWithCompleteBipartiGraph();
		
		
	}
	
}
