/*
 * Copyright (C) 2007 J�lio Vilmar Gesser.
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
 * Created on 05/10/2006
 */
package japa.parser.ast.visitor;
import java.util.Stack;
import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.StringBuilder;


public  class SameBlockChecker 
{
    public static void main(String[] args)
    {
         String file1="/home/lpxz/eclipse/workspace/soot24/javaparseSrc/japa/parser/ast/visitor/Test.java";
         int line1=6;
         int line2=12;
         try{
            boolean sameblock=checkBlock(file1, line1,  line2);
            System.out.println(sameblock);
            
         }
         catch(Exception e)
         {
         }
    }

    public static boolean checkBlock(String file1, int line1,  int line2) 
    {
         String between= "";
         
         try {
			 between = between(file1, line1, line2); 
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("check the exception!!");
		}
        // System.out.println(between);
         
         char[] betweenChars =between.toCharArray();
         Stack stack= new Stack();

         for(int i=0; i< betweenChars.length; i++)
         {
            if(betweenChars[i]=='{')
            {
               stack.push("block");
            }
            else if (betweenChars[i]=='}')
            {
               if(stack.size()!=0)
               stack.pop();
               else
                 return false;// we see more } than {.
            }
         }
         if(stack.size()==0)
                 return true;
         else
                return false; // we see more { than }.
    }

    public static String between(String file1, int line1, int line2) throws Exception
   {
        StringBuilder sb= new StringBuilder();
        BufferedReader br = new BufferedReader(new FileReader(file1));
        String line;
        int lineNo=0;
        boolean append=false;
        while ((line = br.readLine()) != null) {
             lineNo++;
             if(lineNo==line1)
             {
                append=true;
             }
            if(lineNo==line2)
            {
               append=false;
            }    
            if(append==true)
            {
               if(lineNo==line1)
               {
            	   int lastMaohao= line.lastIndexOf('(');//invoke left brace
            	   try {
            		   sb.append(line.substring(lastMaohao));
					} catch (Exception e) {
						 sb.append(line.substring(lastMaohao));
					}
            	   
               }
               else if(lineNo ==line2)
               {
            	   int firstMaohao = line.indexOf('(');
            	   sb.append(line.substring(0, firstMaohao));
               }
               else {
            	   sb.append(line);
			   }
              
            }
        }
        br.close();

        return sb.toString();
    }  
}
