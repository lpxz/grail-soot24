import org.jgrapht.graph.DefaultDirectedWeightedGraph;


public class InsertionTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DefaultDirectedWeightedGraph<Object, Integer> g = new DefaultDirectedWeightedGraph<Object,Integer>(Integer.class);
		int layersize = 10;
		int nolayers = 10;
		Object layerobjects[] = new Object[layersize];
		for(int i=0;i<layersize;i++){
			layerobjects[i] =new Object();
			g.addVertex(layerobjects[i]);
		}
		for(int i=0;i<nolayers;i++)
			for(int j=0;j<layersize;j++){
				Object o = new Object();
				g.addVertex(o);
				g.addEdge(layerobjects[j], o, j);
				g.addEdge(layerobjects[(j+1)%layersize], o, j);
				layerobjects[j]=o;
			}
		System.out.println(g.toString());
	}

}
