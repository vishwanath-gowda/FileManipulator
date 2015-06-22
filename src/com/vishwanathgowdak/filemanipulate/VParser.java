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

	@Override
	public String getFirstLineContaining(String search, String path) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFirstLineContaining(String search, URL url) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long countOccurances(String search, String Path) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long countOccurances(String search, URL url) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Integer> countOccurances(ArrayList<String> searchList,
			String Path) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Integer> countOccurances(ArrayList<String> searchList,
			URL url) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int isExists(String search, String Path, boolean caseSensitive,
			boolean wholeWord) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<String> getPalindromes(String Path) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<String> getPalindromes(URL url) {
		// TODO Auto-generated method stub
		return null;
	}
}