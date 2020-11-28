package construction.mis.robuste.graph;

public class graphUtils {


///////////////////////////////////////////////////////////////////////////////////////////
/**
* Display   ==>  Graph
*/
///////////////////////////////////////////////////////////////////////////////////////////
	
	// Print the matrix
	private static String toStringGraph(graph graph) {
		int numN = graph.numN;
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < numN; i++) {
//			s.append(i + ": ");
			s.append(intToChar(i) + ": ");
			
			for (int j : graph.adjMatrix[i]) {
				s.append(j + " ");
			}
			s.append("\n");
		}
		return s.toString();
	}
	
	private static String intToChar(int i) {
		String str = "";
		switch (i) {
		case 0:
			str = "A";
			break;
		case 1:
			str = "B";
			break;
		case 2:
			str = "C";
			break;
		case 3:
			str = "D";
			break;
		case 4:
			str = "E";
			break;
		case 5:
			str = "F";
			break;
		case 6:
			str = "J";
			break;

		default:
			str = "K";
			break;
		}
		return str;
	}
	
	/**
	 * Display Version 1
	 * 
	 * @return
	 */
	public static void displayV1(graph graph) {
		System.out.print(toStringGraph(graph));
	}
	
	/**
	 * Display Version 2
	 * 
	 * A utility function to print the adjacency list 
	 * representation of graph 
     * 
	 * @return
	 */
	public static void displayV2(graph graph) {
		for (int i = 0; i < graph.adjMatrix.length; i++) { 
    		System.out.println("\nAdjacency list of vertex : " + i); 
    		for (int j = 0; j < graph.adjMatrix[i].length; j++) { 
    			if(graph.adjMatrix[i][j] == 1) {
        			System.out.print(" -> " + j); 	
    			}
    		} 
    		System.out.println(); 
    	} 
	}
	
	/**
	 * Display Version 3
	 * 
	 * @return
	 */
	public static void displayV3(graph graph) {

        System.out.print("  | ");
        for (int i1 = 0; i1 < graph.adjMatrix.length; i1++) {
            System.out.print(i1 + " ");
        }

        System.out.println();

        for (int i2 = 0; i2 < graph.adjMatrix.length; i2++) {
            System.out.print("---");
        }

        System.out.println();

        for (int i3 = 0; i3 < graph.adjMatrix.length; i3++) {
            System.out.print(i3 + " | ");
            for (int j = 0; j < graph.adjMatrix[0].length; j++) {
                System.out.print(graph.adjMatrix[i3][j] + " ");
            }
            System.out.println();
        }

        for (int i4 = 0; i4 < graph.adjMatrix.length; i4++) {
            System.out.print("---");
        }
        System.out.println();
    }
	
	
///////////////////////////////////////////////////////////////////////////////////////////
/**
*    ==>  Construct Graph
*/
///////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * 	// Returns a complete bipartite graph on `V1` and `V2` vertices.
	 */
	public static graph completeBipartiGraph(int v1, int v2) {
		
//		int numN = v1 + v2;
//		Graph graph = new Graph(numN);
//		graph.adjMatrix = new int[numN][numN];	
		
		graph graph = bipartiGraph(v1, v2, v1*v2);
		
		return graph;
	}
	
	/**
	 * 	// Returns a random simple bipartite graph on `V1` and `V2` vertices with `E` edges.
	 */
	private static graph bipartiGraph(int v1, int v2, int e) {
		if(e > (long)v1 * v2)
			throw new IllegalArgumentException("Too many edges");
		if(e < 0)
			throw new IllegalArgumentException("Edges can't be negative");
		
		int numN = v1 + v2;
		graph graph = new graph(numN);
		graph.adjMatrix = new int[numN][numN];	
		
		int[] vertices = new int[v1 + v2];
		for(int i = 0; i < numN; i++)
			vertices[i] = i;
		
		int egdeNb = 0;
		while(egdeNb < e) {			
			int i = 0 + (int)(Math.random() * (((v1-1) - 0) + 1));
			int j = v1 +  0 + (int)(Math.random() * (((v2-1) - 0) + 1));
			
			int _i = vertices[i];
			int _j = vertices[j];
			boolean hsEdg = graph.hasEdge(_i, _j);
			if(!hsEdg) {
				graph.addEdge(_i, _j);
				egdeNb ++;
			}
		}
		
		return graph;
	}
			
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		int v1 = 5; // sommets rouge
		int v2 = 3; // sommets bleu
		// contruction d'un graphe biparti
		graph graph = graphUtils.completeBipartiGraph(v1, v2);
        System.out.println("Martice adjacance:");
		//graphUtils.displayV1(graph);
	graphUtils.displayV3(graph);

		System.out.println();
		//GraphUtils.displayV2(graph);
		
		
	}
		
}
