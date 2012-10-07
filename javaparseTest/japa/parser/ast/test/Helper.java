/*
 * Copyright (C) 2008 J�lio Vilmar Gesser.
 * 
 * This file is part of Java 1.5 parser and Abstract Syntax Tree.
 *
 * Java 1.5 parser and Abstract Syntax Tree is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Java 1.5 parser and Abstract Syntax Tree is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Java 1.5 parser and Abstract Syntax Tree.  If not, see <http://www.gnu.org/licenses/>.
 */
/*
 * Created on 30/06/2008
 */
package japa.parser.ast.test;

import japa.parser.JavaParser;
import japa.parser.ParseException;
import japa.parser.ast.CompilationUnit;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringBufferInputStream;
import java.util.List;

/**
 * @author Julio Vilmar Gesser
 */
public final class Helper {

    private Helper() {
        // hide the constructor
    }

    private static File getFile(String sourceFolder, Class< ? > clazz) {
        return new File(sourceFolder, clazz.getName().replace('.', '/') + ".java");
    }

    public static CompilationUnit parserClass(String sourceFolder, Class< ? > clazz) throws ParseException {
        try {
            return JavaParser.parse(getFile(sourceFolder, clazz));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static CompilationUnit parserString(String source) throws ParseException {
        return JavaParser.parse(new StringBufferInputStream(source));
    }

    public static String readFile(File file) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        try {
            StringBuilder ret = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                ret.append(line);
                ret.append("\n");
            }
            return ret.toString();
        } finally {
            reader.close();
        }
    }

    public static String readClass(String sourceFolder, Class< ? > clazz) throws IOException {
        return readFile(getFile(sourceFolder, clazz));
    }
    
	public static void listFilesInDirectory(String  dirStr, List container) {
		File dir = new File(dirStr);
		  File[] files = dir.listFiles();
		  if (files != null) {
		    for  (File f : files) {
		      if (f.isDirectory()) {
		        listFilesInDirectory(f.getAbsolutePath(),container);
		      } else {
		    	  //System.out.println(f.getName());
		    	  container.add(f);
		      }
		    }
		  }
		}
    
	
	public static void writeFile(String itemset, String filename) {
		
		  try{
			  // Create file 
			  FileWriter fstream = new FileWriter(filename);
			  BufferedWriter out = new BufferedWriter(fstream);
			  out.write(itemset);
			  //Close the output stream
			  out.close();
			  }catch (Exception e){//Catch exception if any
			  System.err.println("Error: " + e.getMessage());
			  }
		
	}

}
