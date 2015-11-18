import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;


public class FileCompare {
	public static void main(String[] args) {
		Set<String> wordA = readFileByLines("A.txt");
		Set<String> wordB = readFileByLines("B.txt");
		
		Set<String> repeat = countRepeat(wordA,wordB);
		Set<String> all = countAll(wordA,wordB);
		System.out.println("在A中不在B中单词占A的百分比为：" + (double)(wordA.size() - repeat.size())/wordA.size());
		System.out.println("在B中不在A中单词占B的百分比为：" + (double)(wordB.size() - repeat.size())/wordB.size());
	}  
	
	public static Set<String> readFileByLines(String fileName) {        //读入文件，并将其中单词存为字符数组
        File file = new File(fileName);
        BufferedReader reader = null;
        Set<String> string = new LinkedHashSet<String>();
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;        
            while ((tempString = reader.readLine()) != null)            // 一次读入一行，直到读入null为文件结束
            {  
            	String[] word = tempString.split(" ");
            	for (int i = 0; i < word.length; i++)
            	{
            		string.add(word[i]);
            	}
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
        return string;
    }
	
	public static Set<String> countRepeat(Set<String> a,Set<String> b) {    //求两文件的交集
		Set<String> repeat = new LinkedHashSet<String>();
		Iterator<String> iter = a.iterator(); 
		System.out.println("以下单词为A.txt和B.txt的交集部分：");
		while(iter.hasNext())
		{
			String word = iter.next();
			if (b.contains(word))
			{
				System.out.print(word + " ");
				repeat.add(word);
			}			
		}
		System.out.println();
		return repeat;
	}
	
	public static Set<String> countAll(Set<String> a,Set<String> b) {      //求两文件的并集
		Set<String> all = new LinkedHashSet<String>();
		Iterator<String> iter = a.iterator(); 
		System.out.println("以下单词为A.txt和B.txt的并集部分：");
		while(iter.hasNext())
		{
			String word = iter.next();
			System.out.print(word + " ");
			all.add(word);
		}
		iter = b.iterator();
		while(iter.hasNext())
		{
			String word = iter.next();
			if (!(all.contains(word)))
			{
			System.out.print(word + " ");
			}
			all.add(word);
		}
		System.out.println();
		return all;
	}
}
