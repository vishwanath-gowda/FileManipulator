package com.vishwanathgowdak.testfilemanipulate;
import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

import com.vishwanathgowdak.filemanipulate.FileAccess;

public class TestFileAccess {
	FileAccess fileaccess=new FileAccess();
	@Test
	public void testisFileExists(){
		boolean result=fileaccess.isFileExists("Resources/TestFile.txt");
		assertTrue(result);

	}
	
	@Test
	public void testisFileExistsNegative(){
		boolean result=fileaccess.isFileExists("TestFile.txt");
		assertFalse(result);
	}
	
	public void testgetBufferedReader(String path) throws FileNotFoundException{
		
		
	}
	public void testgetBufferedReaderNegative(String path) throws FileNotFoundException{
		
	}
	public void testgetBufferedWriter(String path) throws IOException{
		
	}
	public void testgetString(String path) throws FileNotFoundException, IOException{
		
	}
	public void testgetNlines(String path, int n) throws FileNotFoundException, IOException{
		
	}
}
