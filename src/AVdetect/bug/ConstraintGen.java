package AVdetect.bug;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import Jama.Matrix;

public class ConstraintGen {


	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static Matrix genConstraints(Set<AVTuple> avs) {
		List nodes = getNodes(avs);
		List<AVTuple> avList = toList(avs);
		Matrix toret = new Matrix(avs.size(), nodes.size() );
		
		for(int i=0; i< avList.size(); i++)
		{
			AVTuple tuple = avList.get(i);
			Object x = tuple.getX(); 
			Object y = tuple.getY();
			Object z = tuple.getZ();
			if(x.equals(y) || x.equals(z) || y.equals(z))
			{
				throw new RuntimeException("fix first");
			}
			toret.set(i, nodes.indexOf(x), 1);
			toret.set(i, nodes.indexOf(y), 1);
			toret.set(i, nodes.indexOf(z), 1);		
		}
		//toret.print(nodes.size(), 0);
		
		return toret;
		
		
	}

	private static List<AVTuple> toList(Set<AVTuple> avs) {
		List<AVTuple> list = new  ArrayList<AVTuple>();
		for(AVTuple tuple : avs)
		{
			list.add(tuple);
		}
		
		return list;
	}

	private static List getNodes(Set<AVTuple> avs) {
		
		Set  set = new HashSet();
		for(AVTuple tuple : avs)
		{
			set.add(tuple.getX());
			set.add(tuple.getY());
			set.add(tuple.getZ());			
		}
		
		List list  = new  ArrayList();
		for(Object ob : set)
		{
			list.add(ob);
			
		}
		return list;
	}

}
