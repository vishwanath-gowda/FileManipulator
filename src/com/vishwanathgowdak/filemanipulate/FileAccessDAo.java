package com.vishwanathgowdak.filemanipulate;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

public interface FileAccessDAO {

	public File isFileExists(String path);
	public BufferedReader getBufferedReader(String path) throws FileNotFoundException;
	public BufferedWriter getBufferedWriter(String path) throws IOException;
	public String getString(String path) throws FileNotFoundException, IOException;
	public String getNlines(String path, int n) throws FileNotFoundException, IOException;
	public String[] getNLinesToStringArray(String path,int n) throws FileNotFoundException, IOException;
	public String[] getBetweenToArray(String path,long start,long end) throws FileNotFoundException, IOException;
	public String[] getAllLines(String path) throws IOException;
	public String[] getAllLines(BufferedReader reader) throws IOException;
	public String[] getAllLines(URL url) throws IOException;
	public int getTotalLines(String path) throws FileNotFoundException, IOException;
	public int getTotalLines(FileReader reader) throws IOException;
	public int getTotalLines(File file) throws FileNotFoundException, IOException;
	public int getTotalLines(BufferedReader reader) throws IOException;
}
