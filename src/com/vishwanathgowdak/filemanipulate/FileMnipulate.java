package com.vishwanathgowdak.filemanipulate;

public class FileMnipulate {

	static FileAccess fileaccess= new FileAccess();
	
	public static void main(String[] args){
		System.out.println(fileaccess.isFileExists("TestFile.txt"));
	}
	
}