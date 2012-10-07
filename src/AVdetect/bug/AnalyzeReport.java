package AVdetect.bug;

import japa.parser.ast.test.Helper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.jgrapht.DirectedGraph;
import org.jgrapht.Graph;

import Jama.Matrix;

import popl.petrinet.element.Transition;

public class AnalyzeReport {

	public static String readFile(File file, List<String> lines)
			throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				new FileInputStream(file)));
		try {
			StringBuilder ret = new StringBuilder();
			String line;
			while ((line = reader.readLine()) != null) {
				ret.append(line);
				lines.add(line);
				ret.append("\n");
			}
			return ret.toString();
		} finally {
			reader.close();
		}
	}

	public static void main(String[] args) {
		List<String> lines = new ArrayList<String>();
		String testfile = "/home/lpxz/eclipse/workspace/soot24/src/AVdetect/bug/derby.txt";
		String dotfile = "/home/lpxz/eclipse/workspace/soot24/src/AVdetect/bug/derby.dot";
		try {
			String source = readFile(new File(testfile), lines);

			HashMap<String, Set<AVTuple>> mem2AVs = mem2AVs(lines);
			// buildDotG(mem2AVs, dotfile);

			// ===================subsuming relation
			distanceReportOfSameRemote(mem2AVs);

			// constraints: rank reduction
			fixSameNameInAV(mem2AVs);
			constraintsTest(mem2AVs);
			System.err.println(redu);
			System.err.println(total);

			// printMem2AVs(mem2AVs);
			// System.out.println(source);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void distanceReportOfSameRemote(
			HashMap<String, Set<AVTuple>> mem2aVs) {
		HashMap<Object, Set<AVTuple>> cacheMap = new HashMap<Object, Set<AVTuple>>();
		Iterator it = mem2aVs.keySet().iterator();
		while (it.hasNext()) {
			Object str = (Object) it.next();
			cacheMap.clear(); // you can store it in an outer map
			Set<AVTuple> avs =mem2aVs.get(str);
			for(AVTuple tuple : avs )
			{
				Object y = tuple.getY();
				Set<AVTuple> tuplesOnY =cacheMap.get(y);
				if(tuplesOnY ==null)
				{
					tuplesOnY = new HashSet<AVTuple>();
					cacheMap.put(y, tuplesOnY);
				}
				tuplesOnY.add(tuple);				
			}
			
			Iterator it2 =cacheMap.keySet().iterator();
			while (it2.hasNext()) {
				Object object = (Object) it2.next();
				System.out.println("the same memory, same y:");
				Set<AVTuple> tuples2 =cacheMap.get(object);
				for(AVTuple tuple2: tuples2)
				{
					System.out.println( "x:" + tuple2.getX() + " z:" + tuple2.getZ());
				}
				System.out.println();			
			}

		}

	}

	private static void fixSameNameInAV(HashMap<String, Set<AVTuple>> mem2aVs) {
		Iterator it = mem2aVs.keySet().iterator();
		while (it.hasNext()) {
			Object str = (Object) it.next();
			Set<AVTuple> avs = mem2aVs.get(str);
			for (AVTuple tuple : avs) {
				Object x = tuple.getX();
				Object y = tuple.getY();
				Object z = tuple.getZ();
				if (x.equals(z)) {
					z = z + "_" + "2";
					tuple.setZ(z);
				}
				if (x.equals(y) || z.equals(y)) {
					y = y + "_" + "remote";
					tuple.setY(y);
				}
			}

		}

	}

	private static void printMem2AVs(HashMap<String, Set<AVTuple>> mem2aVs) {
		Iterator it = mem2aVs.keySet().iterator();
		while (it.hasNext()) {
			Object object = (Object) it.next();
			Set<AVTuple> avs = mem2aVs.get(object);
			for (AVTuple tuple : avs) {
				System.out.println(object + " " + tuple.getX() + " "
						+ tuple.getY() + " " + tuple.getZ());
			}

		}

	}

	public static int redu = 0;
	public static int total = 0;

	private static void constraintsTest(HashMap<String, Set<AVTuple>> mem2aVs) {
		Iterator<String> memIt = mem2aVs.keySet().iterator();
		while (memIt.hasNext()) {
			String mem = (String) memIt.next();
			Set<AVTuple> avs = mem2aVs.get(mem);
			Matrix matrix = ConstraintGen.genConstraints(avs);
			total += avs.size();
			if (matrix.rank() < avs.size()) {
				System.out.println("reduction happens. "
						+ ("constraints: " + avs.size() + " rank: " + matrix
								.rank()));
				redu++;
			}
		}

	}

	public static Set methods = new HashSet();
	private static HashMap<String, Set<AVTuple>> mem2AVs(List<String> lines) {
		HashMap<String, Set<AVTuple>> map = new HashMap<String, Set<AVTuple>>();
		for (int i = 0; i < lines.size(); i++) {
			String lineString = lines.get(i);
			if (lineString.startsWith("*** AV-I")
					|| lineString.startsWith("*** AV-II")) {
				String[] segs = lineString.split(" ");

				String memString = segs[4];
				AVTuple av = new AVTuple(segs[5], segs[11], segs[17]);
				System.out.println("\nhere, the bug:");
				System.out.println(segs[4] + " " + segs[5]);
				System.out.println(segs[10]+ " " + segs[11]);
				System.out.println(segs[16]+ " " + segs[17]);
				
				Set<AVTuple> AVsOfMem = map.get(memString);
				if (AVsOfMem == null) {
					AVsOfMem = new HashSet<AVTuple>();
					map.put(memString, AVsOfMem);
				}
				AVsOfMem.add(av);
			}

		}

		return map;
	}

	public static HashMap<String, Integer> encoding = new HashMap<String, Integer>();
	private static int curIndex = 0;

	private static int getEncode(String string) {
		Integer id = encoding.get(string);
		if (id == null) {
			encoding.put(string, curIndex++);
		}
		return encoding.get(string).intValue();
	}

	public static Set<String> visited = new HashSet<String>();
	public static String indent = "  ";

	private static void buildDotG(HashMap<String, Set<AVTuple>> map,
			String filename) throws Exception {
		File file = new File(filename);
		FileWriter fw;
		fw = new FileWriter(file);
		PrintWriter out = new PrintWriter(fw);
		out.println("digraph G {");
		String connector = " -> ";

		Iterator<String> memIt = map.keySet().iterator();
		while (memIt.hasNext()) {
			String mem = (String) memIt.next();
			Set<AVTuple> avs = map.get(mem);
			int encode = getEncode(mem);

			for (AVTuple tuple : avs) {
				Object x = tuple.getX();
				Object y = tuple.getY();
				Object z = tuple.getZ();
				String wrapX = "\"" + encode + "_" + x + "\"";
				String wrapY = "\"" + encode + "_" + y + "\"";
				String wrapZ = "\"" + encode + "_" + z + "\"";
				String edgeXY = wrapX + connector + wrapY;
				String edgeYZ = wrapY + connector + wrapZ;

				buffer2Out(out, wrapX);
				buffer2Out(out, wrapY);
				buffer2Out(out, wrapZ);
				buffer2Out(out, edgeXY);
				buffer2Out(out, edgeYZ);
			}

		}

		out.println("}");

		out.flush();

	}

	// private static void buildDotG(List<String> lines, String filename)
	// throws Exception {
	// File file = new File(filename);
	// FileWriter fw;
	// fw = new FileWriter(file);
	// PrintWriter out = new PrintWriter(fw);
	// out.println("digraph G {");
	// String connector = " -> ";
	// String indent = "  ";
	// for (int i = 0; i < lines.size(); i++) {
	// String lineString = lines.get(i);
	// if (lineString.startsWith("*** AV-I")
	// || lineString.startsWith("*** AV-II")) {
	// String[] segs = lineString.split(" ");
	// // System.out.println(segs[4] + " " + segs[5] +" " + segs[11]
	// // +" " + segs[17]);
	// int encode = getEncode(segs[4]);
	// // System.out.println(encode);
	// String wrapX = "\"" + encode + "_" + segs[5] + "\"";
	// String wrapY = "\"" + encode + "_" + segs[11] + "\"";
	// String wrapZ = "\"" + encode + "_" + segs[17] + "\"";
	// String edgeXY = wrapX + connector + wrapY;
	// String edgeYZ = wrapY + connector + wrapZ;
	// if (!visited.contains(wrapX)) {
	// out.print(indent + wrapX);
	// out.println(";");
	// visited.add(wrapX);
	// }
	//
	// if (!visited.contains(wrapY)) {
	// out.print(indent + wrapY);
	// out.println(";");
	// visited.add(wrapY);
	// }
	//
	// if (!visited.contains(wrapZ)) {
	// out.print(indent + wrapZ);
	// out.println(";");
	// visited.add(wrapZ);
	// }
	//
	// if (!visited.contains(edgeXY)) {
	// out.print(indent + edgeXY);
	// out.println(";");
	// visited.add(edgeXY);
	// }
	//
	// if (!visited.contains(edgeYZ)) {
	// out.print(indent + edgeYZ);
	// out.println(";");
	// visited.add(edgeYZ);
	// }
	//
	// }
	//
	// }
	// out.println("}");
	//
	// out.flush();
	//
	// }

	private static void buffer2Out(PrintWriter out, String wrapX) {
		if (!visited.contains(wrapX)) {
			out.print(indent + wrapX);
			out.println(";");
			visited.add(wrapX);
		}

	}

}
