package construction.mis.robuste.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * 	
 * retainAll() method of ArrayList : 
 * 		is used to remove all the array list’s elements that are not contained in the specified collection 
 * 		or retains all matching elements in the current ArrayList instance that match all elements 
 * 		from the Collection list passed as a parameter to the method.
 * 
 * 	Object cloning  : 
 * 		refers to creation of exact copy of an object. 
 * 		It creates a new instance of the class of current object and initializes all 
 * 		its fields with exactly the contents of the corresponding fields of this object
 * 
 * 
 * ArrayList<ArrayList<Integer>> : list of list (Ex : [[0, 1, 2, 3, 4], [5, 6, 7]])
 * 
 */
public class misSet {

	private graph graph;
	
	
	/**
	 * 
	 */
	public misSet(graph graph) {
		this.graph = graph;
	}
	
	
	/**
	 * 
	 */
	public ArrayList<ArrayList<Integer>> maxIndependentSets() {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        
		int dim = graph.numN;
		
		//First : clone all sommets 
		ArrayList<Integer> unused = new ArrayList<Integer>();
		for(int i = 0;i < dim; i++) {
			unused.add(i);
		}
		
		//To stock one set : MIS
		ArrayList<Integer> set = new ArrayList<Integer>();
		
		findMISetsRec(unused, res, set);
		return res;
	}
	
	/**
	 * Recursive
	 */
	private void findMISetsRec(ArrayList<Integer> unused, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> set) {
		
		int dim = graph.numN;
		ArrayList<Integer> applicant = new ArrayList<Integer>();
		//System.err.println("unused : " + unused);					
		int i = 0;
		if(!unused.isEmpty()) {
			applicant.addAll((ArrayList<Integer>)unused.clone());
			
			i = 0;
			while(i < dim) {
				if(applicant.contains(i)) {
					//Nouveau unused, Set
					ArrayList<Integer> newSet = (ArrayList<Integer>) set.clone();
					newSet.add(i);
					ArrayList<Integer> newUnused = (ArrayList<Integer>) unused.clone();
					
					//Supprimer le voisinage du sommet ajouté
					for(int j = 0;j < dim;j++) {
						if(graph.adjMatrix[i][j] == 1) {
							newUnused.remove(Integer.valueOf(j));
						}
					}
					
					//Supprimer le haut lui-même
					newUnused.remove(Integer.valueOf(i));
					
					//System.err.println("set : " + newSet);

					findMISetsRec(newUnused, res, newSet);

					//Changement unused, applicant
					unused.remove(Integer.valueOf(i));
					applicant = intersection(unused, graph.adjMatrix[i]);
				}
				i++;
			}//End While
			
		} else {
			res.add((ArrayList<Integer>)set.clone());
			set.clear();

		}
	}
	
	/**
	 * Intersection of two list (first , second)
	 *    -- Init new list "res"
	 *    -- add all elments of list "first" in "res"
	 *    --  tmp : elemnt in list "second" (has edge ==> == 1)
	 *    -- Use Methode retainAll ()
	 */
	private ArrayList<Integer> intersection(ArrayList<Integer> first, int[] second) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		res.addAll((ArrayList<Integer>)first.clone());
		
		List<Integer> tmp = new ArrayList<Integer>();
		for(int i = 0;i < second.length; i++) {
			if(second[i] == 1) {
				tmp.add(i);
			}
		}
		
		res.retainAll(tmp);
		return res;
	}
	    

	
	
}
