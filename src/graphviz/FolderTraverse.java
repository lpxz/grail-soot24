package graphviz;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FolderTraverse {
    public static boolean print = false;
    
    private String indent = "";
    private File originalFileObject;
    private File fileObject;

    public FolderTraverse(File fileObject)
    {
        this.originalFileObject = fileObject;
        this.fileObject = fileObject;
    }
    
    public FolderTraverse(String  fileObject)
    {
        String folderPath = 
          fileObject;
        File  f = new File(folderPath);
        this.originalFileObject = f;
        this.fileObject = f;
    }

    public void traverse(List list)
    {
        recursiveTraversal(fileObject, list);
    }

    public void recursiveTraversal(File fileObject, List list ){		
        if (fileObject.isDirectory()){
            indent = getIndent(fileObject);
            if(print)
            {
            	System.out.println(indent +  fileObject.getName());
            }
                  

            File allFiles[] = fileObject.listFiles();
            for(File aFile : allFiles){
                recursiveTraversal(aFile, list);
             }
        }else if (fileObject.isFile()){
            if(print)
            {
            	System.out.println(indent  + "  " + fileObject.getName());
            }
            list.add(fileObject);
        	
        }		
    }

    private String getIndent(File fileObject)
    {
        String original = originalFileObject.getAbsolutePath();
        String fileStr = fileObject.getAbsolutePath();		
        String subString = 
            fileStr.substring(original.length(), fileStr.length());

        String indent = ""; 
        for(int index=0; index<subString.length(); index ++){
            char aChar = subString.charAt(index);
            if (aChar == File.separatorChar){
                indent = indent + "  ";
            }
        }
    return indent;
    }
    
    public static void main(String[] args) {

        String folderPath = 
            "/home/lpxz/eclipse/workspace/soot24/src";
        FolderTraverse traversal = new FolderTraverse(new File(folderPath));
        List list = new ArrayList();
        traversal.traverse(list);
        System.out.println();
        
    }

}



