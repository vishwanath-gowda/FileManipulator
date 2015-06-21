package com.vishwanathgowdak.testfilemanipulate;
import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

import com.vishwanathgowdak.filemanipulate.FileAccess;

public class TestFileAccess {
	FileAccess fileaccess=new FileAccess();
	@Test
	public void testisFileExists(){
		File result=fileaccess.isFileExists("Resources/TestFile.txt");
		assertNotNull("File Object null", result);

	}
	
	@Test
	public void testisFileExistsNegative(){
		File result=fileaccess.isFileExists("TestFile.txt");
		assertEquals(null, result);
	}
	
	@Test
	public void testgetBufferedReader() throws FileNotFoundException{
		
		
		assertNotNull(fileaccess.getBufferedReader("Resources/TestFile.txt"));
		
	}
	public void testgetBufferedReaderNegative(String path) throws FileNotFoundException{
		assertEquals(null,fileaccess.getBufferedReader("jkh"));
		
		
		
	}
	public void testgetBufferedWriter(String path) throws IOException{
		
	}
	public void testgetString(String path) throws FileNotFoundException, IOException{
		
	}
	public void testgetNlines(String path, int n) throws FileNotFoundException, IOException{
		
	}
}
