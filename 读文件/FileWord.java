import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;
import javax.swing.text.StyledEditorKit.ItalicAction;

public class FileWord{
	public static List<String> readFileByLines(String fileName){
		List<String> list=new LinkedList<String>();
		//Set<String> list=new HashSet<String>();
		File file=new File(fileName);
		BufferedReader reader=null;
		try{
			reader=new BufferedReader(new FileReader(file));
			String tempString=null;
			int line=1;
			while((tempString=reader.readLine())!=null){
				list.add(tempString);
				++line;
			}
			reader.close();
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			if(reader!=null){
				try{
					reader.close();
				}catch(IOException e1){
					
				}
			}
		}
		return list;
	}
	public static void readFileByChars(String fileName){
		File file=new File(fileName);
		Reader reader=null;
		try{
			char[] tempChars=new char[1024];
			int charread=0;
			reader=new InputStreamReader(new FileInputStream(fileName));
			while((charread=reader.read(tempChars))!=-1){
				if((charread==tempChars.length)&&(tempChars[tempChars.length-1]!='\r')){
					System.out.println(tempChars);
				}
				else{
					for(int i=0;i<tempChars.length;i++){
						if(tempChars[i]=='\r'){
							continue;
						}
						else{
							System.out.println(tempChars[i]);
						}
					}
				}
			}
			
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			if(reader!=null){
				try{
					reader.close();
				}catch(IOException e1){
					e1.printStackTrace();
				}
			}
		}
	}
	
public List<String> FileToWord(String fileName){
	List<String> word=readFileByLines(fileName);
	int n=word.size();
	for(int i=0;i<n;i++){
		String str=word.get(0).toString();
		String[] strd=str.split(" ");
		for(int j=0;j<strd.length;j++){
			word.add(strd[j]);
		}
		word.remove(0);
	}
	return word;
}
	
public Set<String> allword(List<String> wordA,List<String> wordB){
	Set<String> all=new HashSet<String>();
	for(String value:wordA){
		all.add(value);
	}
	for(String value:wordB){
		all.add(value);
	}
	return all;
}

public Set<String> publicword(List<String> wordA,List<String> wordB){
	Set<String> wp=new HashSet<String>();
	if(wordA.size()<wordB.size()){
	Iterator iterator=wordA.iterator();
	   while(iterator.hasNext()){
		String str=iterator.next().toString();
		  if(wordB.contains(str)){
			wp.add(str);
		  }
	   }
	}
	else{
		Iterator iterator=wordB.iterator();
		while(iterator.hasNext()){
			String str=iterator.next().toString();
			if(wordA.contains(str)){
				wp.add(str);
			}
	    }
    }
	return wp;
}
 public static void main(String[] args){
	     FileWord so=new FileWord();
         List<String> wordA=so.FileToWord("abc.txt");
         List<String> wordB=so.FileToWord("cba.txt");
         Set<String> allword=so.allword(wordA, wordB);
         Set<String> publicword=so.publicword(wordA, wordB);
         System.out.println("--------------------总共的词汇表---------------------");
         for(String value:allword){
        	 System.out.println(value);
         }
         System.out.println("-------------------交集的词汇表-----------------------");
         for(String value:publicword){
        	 System.out.println(value);
         }
         System.out.println("---------------------词汇表的单词个数-------------------");
	     System.out.println("词汇表A:"+wordA.size());
	     System.out.println("词汇表B:"+wordB.size());
	     System.out.println("---------------------占比---------------------------");
	     List<String> wordAB=new LinkedList<String>();
	     for(String value:wordA){
		     if(!publicword.contains(value)){
		    	 wordAB.add(value);
		     }
	     }
	     float size=((float)wordAB.size()/(float)wordA.size());
	     System.out.println("A-B占A的比例:"+size);
	     wordAB=new LinkedList<String>();
	     for(String value:wordB){
	    	 if(!publicword.contains(value)){
	    		 wordAB.add(value);
	    	 }
	     }
	    size=((float)wordAB.size()/(float)wordB.size());
	    System.out.println("B-A占B的比例:"+size);
	     
	     
    }
    

}

