package com.vishwanathgowdak.filemanipulate;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

public class VParser {

	
	public ArrayList<String> getAllLinesContaining(String search,URL url) throws IOException{
		
		FileAccess fileAccess=new FileAccess();
		String[] allLines=fileAccess.getAllLines(url);
		ArrayList<String> arrayList=new ArrayList<String>();
		for(int i=0;i<allLines.length;i++){
			if(allLines[i].contains(search))
				arrayList.add(allLines[i]);
		}
		return arrayList;
		
	}
	
public ArrayList<String> getAllLinesContaining(String[] search,URL url) throws IOException{
		
		FileAccess fileAccess=new FileAccess();
		String[] allLines=fileAccess.getAllLines(url);
		ArrayList<String> arrayList=new ArrayList<String>();
		StringBuilder builder=new StringBuilder("^.*?(");
		for (int i=0;i<search.length;i++){
			
			
			
		}
			
	}
	
	
	
	
	public static void main(String[] args){
		try {
			
		String search[]={"a","b","c","d"};
		
		URL url=new URL("http://grad-schools.usnews.rankingsandreviews.com/best-graduate-schools/top-science-schools/computer-science-rankings");
		new VParser().getAllLinesContaining(search, url);
		/*
		ArrayList<String> list=new VParser().getAllLinesContaining("University", url);
		Iterator<String> iterator=list.listIterator();
			while(iterator.hasNext()){
				System.out.println(iterator.next());
			}*/
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}