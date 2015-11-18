package com.syl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 编写一个程序，实现以下功能
 * 1、读取两个不同的文本文件，输出两个文件总共的词汇表（即所有不重复的单词）
 * 2、进一步计算同时出现在两个文件中的交集单词词汇表
 * 3、统计上述两个文件词汇表中各自包含单词总数
 * @author syl
 *
 */
public class HomeWork {
	public static void main(String args[]){
		String path1 = "/Users/user/Desktop/2.txt" ;
		String path2 = "/Users/user/Desktop/3.txt" ;
		List<String> list1 = HomeWork.readFile(path1);
		List<String> list2 = HomeWork.readFile(path2);
		int size1 = list1.size();     
		int size2 = list2.size();     /
		System.out.println("第一个文件包含单词总数 = "+ size1 );
		System.out.println("第二个文件包含单词总数 = "+ size2 );
		
		//去掉list集合中重复的单词
		HomeWork.removeDuplicated(list1);
		HomeWork.removeDuplicated(list2);
		
		int sameCount = 0 ; //计算重复单词数
		List<String> result = new ArrayList<String>();   //第一个文件和第二个文件总共词汇表
		List<String> sameresult = new ArrayList<String>(); //两个文件交集的词汇表
		for(String str1 : list1){
			result.add(str1);
			for(String str2 : list2){
				result.add(str2);
				if(str1.equals(str2)){
					sameCount ++ ;
					sameresult.add(str1);
				}
			}
		}
		HomeWork.removeDuplicated(result); //去掉重复的元素
		System.out.println("两个文件中的总词汇表位："+result);
		System.out.println("两个文件中重复的词汇数为: "+sameCount);
		System.out.println("两个文件交集的词汇为："+sameresult);
	}
	//读取文件中的词汇放入list集合中
	static List<String> readFile(String path){
		List<String> List = new ArrayList<String>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(
					new File(path)));
			String temp = null ;
		
			while((temp = br.readLine()) != null){
				String[] str = temp.split(" ");
				for(String s : str){
					List.add(s);
				}
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return List ;
	}
	//将List集合中重复的元素去掉
	static void removeDuplicated(List list){
		Set<String> set = new HashSet<String>(list);
		list.clear();
		list.addAll(set);
	}
}

