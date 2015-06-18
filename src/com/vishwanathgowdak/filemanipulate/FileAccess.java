package com.vishwanathgowdak.filemanipulate;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Paths;


public class FileAccess implements FileAccessDAo {

	@Override
	public boolean isFileExists(String path) {
		File file=new File(path);
		return file.exists();
	}

	@Override
	public BufferedReader getBufferedReader(String path) throws FileNotFoundException {
		File file =new File(path);
		if(file.exists()){
		FileReader fr=new FileReader(file);
		return new BufferedReader(fr);
		}else{
			return null;
		}

	}

	@Override
	public BufferedWriter getBufferedWriter(String path) throws IOException {
		File file =new File(path);
		FileWriter fw= new FileWriter(file);
		return new BufferedWriter(fw);


	}

	public String getString(String path) throws FileNotFoundException, IOException{
		if(isFileExists(path)){
			byte[] encoded=Files.readAllBytes(Paths.get(path));
			return new String(encoded);
		}else{
			return null;
		}

	}

	@Override
	public String getNlines(String path,int n) throws IOException {
		StringBuilder builder=new StringBuilder();
		BufferedReader reader=getBufferedReader(path);
		if(n>0){
			for(int i=0;i<n;i++){
				builder.append(reader.readLine());
			}
			return builder.toString();
		}else if(n<0){

			File file=new File(path);
			RandomAccessFile rfile=new RandomAccessFile(file, "r");
			long length=file.length();
			length--;
			long seek=length;
			StringBuilder temp= new StringBuilder();
			while(seek>=0){
				rfile.seek(seek);
				char c=(char)rfile.read();
				temp.append(c);
				if(c=='\n'){
					temp.reverse();
					builder.append(temp.toString());
					temp=null;
					temp=new StringBuilder();
				}
				n--;
				if(0==n){
					temp.reverse();
					builder.append(temp.toString());
					break;
				}
				seek--;
			}
			rfile.close();
			return builder.toString();

		}else{
			return null;
		}



	}

}
