package com.vishwanathgowdak.filemanipulate;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

public class VParser implements Parser{


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
		ArrayList<String> output=new ArrayList<String>();
		for(String line:allLines){
			for(String pattern:search){
				if(line.contains(pattern))
					output.add(line);
			}
		}
		return output;

	}




	public static void main(String[] args){
		try {

			String search[]={"a","b","c","d"};

			URL url=new URL("http://www.google.com");
			new VParser().getAllLinesContaining(search, url);

			ArrayList<String> list=new VParser().getAllLinesContaining("google", url);
			Iterator<String> iterator=list.listIterator();
			while(iterator.hasNext()){
				System.out.println(iterator.next());


			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}



	}
}