package construction.mis.robuste.graph;

/**
 * 
 * Representation le graph avec Martice adjacance
 *
 */
public class graph {

	// 
	protected int adjMatrix[][];
	protected int numN;
	

	/**
	 * 
	 */
	public graph(int numN) {
		this.numN = numN;
		adjMatrix = new int[numN][numN];	
	}
	
	
	// Add edges
	public void addEdge(int i, int j) {
		adjMatrix[i][j] = 1;
		adjMatrix[j][i] = 1;
	}
	
	// Remove edges
	public void removeEdge(int i, int j) {
		adjMatrix[i][j] = 0;
		adjMatrix[j][i] = 0;
	}

	// return la valeur du sommet 0 ou 1 
	public int nodeElemnt(int _i, int _j) {
		return adjMatrix[_i][_j];
	}
	
	// Has edges
	public boolean hasEdge(int _i, int _j) {
		if(adjMatrix[_i][_j] == 1) {
			return true;
		}
		return false;
	}
	
	
}

