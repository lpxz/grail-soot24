package graphviz;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class UseDot {

	/**
	 * @param args
	 */
	static GraphViz gv  = new  GraphViz();
	private static String dotMark= "g";
	
	public static void genNshow(String dotname, String type)
	{
		File  f  = new  File(dotname);
		GraphViz gv = new  GraphViz();
		gv.genNshow(f, type);
	}
	
	public static void genNshowFolder(String folder, String type)
	{
		FolderTraverse ft = new  FolderTraverse(folder);
		List list  = new ArrayList();
		ft.traverse(list);
		for(Object  of : list)
		{
			  if(of instanceof File)
			  {
				  File  f  = (File ) of;
				  if(f.getName().endsWith(dotMark) && !f.getName().endsWith("png"))
				  {
						GraphViz gv = new  GraphViz();
						gv.genNshow(f, type);
				  }
			  }
			
		}
		

	}
	
	public static void main(String[] args) {

	//	genNshowFolder( "/home/lpxz/eclipse/workspace/soot24/dotgraph/", "png");
		genNshow( "/home/lpxz/eclipse/workspace/soot24/learnerPtr1.dot", "png");
		
	}

}
