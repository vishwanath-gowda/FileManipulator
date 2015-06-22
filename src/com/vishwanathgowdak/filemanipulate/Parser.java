package com.vishwanathgowdak.filemanipulate;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public interface Parser {
	public ArrayList<String> getAllLinesContaining(String search,URL url) throws IOException;
	public ArrayList<String> getAllLinesContaining(String[] search,URL url) throws IOException;
	public String getFirstLineContaining(String search,String path);
	public String getFirstLineContaining(String search,URL url);
	public long countOccurances(String search, String Path);
	public long countOccurances(String search, URL url);
	public ArrayList<Integer> countOccurances(ArrayList<String> searchList, String Path);
	public ArrayList<Integer> countOccurances(ArrayList<String> searchList, URL url);
	public int isExists(String search,String Path,boolean caseSensitive, boolean wholeWord);
	public ArrayList<String> getPalindromes(String Path);
	public ArrayList<String> getPalindromes(URL url);
	
}
