package com.vishwanathgowdak.filemanipulate;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public interface FileAccessDAo {

	public boolean isFileExists(String path);
	public BufferedReader getBufferedReader(String path) throws FileNotFoundException;
	public BufferedWriter getBufferedWriter(String path) throws IOException;
	public String getString(String path) throws FileNotFoundException, IOException;
	public String getNlines(String path, int n) throws FileNotFoundException, IOException;
}
