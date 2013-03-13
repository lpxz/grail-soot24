package japa.parser.ast.visitor;

import japa.parser.ast.CompilationUnit;
import japa.parser.ast.body.TypeDeclaration;
import japa.parser.ast.test.Helper;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.io.FileUtils;

public class SearchForClassFile {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {    
		String filename = findFile4Class("/home/lpxz/eclipse/workspace/soot24/javaparseSrc", "japa.parser.ast.visitor.SearchForClassFile");
      System.out.println(filename);
        }
	

	public static String findFile4Class(String folderName, String className) throws Exception {
		
         Collection<File> files= FileUtils.listFiles(new File(folderName), null, true);
         for(File file: files)
         {
        	 if(file.getAbsoluteFile().toString().contains("oracle")||
        			 file.getAbsoluteFile().toString().contains("soot24")||
        			 file.getAbsoluteFile().toString().contains("Dcon")||
        			 file.getAbsoluteFile().toString().contains("pecan")||
        			 !file.getAbsoluteFile().toString().endsWith(".java")) continue;
        	 String source = Helper.readFile(file);    	
        	 CompilationUnit cu = null;
        	 try {
            
            	
            	cu= Helper.parserString(source);
			} catch (Throwable e) {
				continue;
			}
 	       
 	       
 	       
 	        String packageName =cu.getPackage().getName().toString();
 	        Iterator<TypeDeclaration> types =cu.getTypes().iterator();
            while (types.hasNext()) {
				TypeDeclaration typeDeclaration = (TypeDeclaration) types
						.next();
				String fullname = packageName+ "."+typeDeclaration.getName();
				//System.out.println(fullname);
				
				if(fullname.equals(className))
				{
					return file.getAbsolutePath();
				}
				
			}
         }
         return null;
	}

}
