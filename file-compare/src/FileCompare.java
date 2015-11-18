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
		System.out.println("��A�в���B�е���ռA�İٷֱ�Ϊ��" + (double)(wordA.size() - repeat.size())/wordA.size());
		System.out.println("��B�в���A�е���ռB�İٷֱ�Ϊ��" + (double)(wordB.size() - repeat.size())/wordB.size());
	}  
	
	public static Set<String> readFileByLines(String fileName) {        //�����ļ����������е��ʴ�Ϊ�ַ�����
        File file = new File(fileName);
        BufferedReader reader = null;
        Set<String> string = new LinkedHashSet<String>();
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;        
            while ((tempString = reader.readLine()) != null)            // һ�ζ���һ�У�ֱ������nullΪ�ļ�����
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
	
	public static Set<String> countRepeat(Set<String> a,Set<String> b) {    //�����ļ��Ľ���
		Set<String> repeat = new LinkedHashSet<String>();
		Iterator<String> iter = a.iterator(); 
		System.out.println("���µ���ΪA.txt��B.txt�Ľ������֣�");
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
	
	public static Set<String> countAll(Set<String> a,Set<String> b) {      //�����ļ��Ĳ���
		Set<String> all = new LinkedHashSet<String>();
		Iterator<String> iter = a.iterator(); 
		System.out.println("���µ���ΪA.txt��B.txt�Ĳ������֣�");
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
