package com.vishwanathgowdak.filemanipulate;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.RandomAccessFile;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;


public class FileAccess implements FileAccessDAO {

	@Override
	public File isFileExists(String path) {
		File file=new File(path);
		if(file.exists())
			return file;
		else
			return null;
	}

	@Override
	public BufferedReader getBufferedReader(String path) throws FileNotFoundException {
		File file=isFileExists(path);
		if(file!=null){
			FileReader fr=new FileReader(file);
			return new BufferedReader(fr);
		}else{
			return null;
		}

	}

	@Override
	public BufferedWriter getBufferedWriter(String path) throws IOException {
		File file=isFileExists(path);
		if(file!=null){
			FileWriter fw= new FileWriter(file);
			return new BufferedWriter(fw);
		}else
			return null;


	}

	public String getString(String path) throws FileNotFoundException, IOException{
		if(isFileExists(path)!=null){
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
			File file=isFileExists(path);
			if(file!=null){
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
			}else
				return null;
		}else{
			return null;
		}



	}

	@Override

	public String[] getNLinesToStringArray(String path, int n) throws IOException {

		@SuppressWarnings("unused")
		StringBuilder builder=new StringBuilder();
		File file=isFileExists(path);
		if(file==null){
			return null;
		}
		BufferedReader reader=getBufferedReader(path);
		int totalLine=getTotalLines(reader);
		String output[]=new String[totalLine];
		if(n>0){

			int i;
			for(i=0;i<n;i++){
				String temp=reader.readLine();
				if(temp!=null)
					output[i]=temp;
				else
					break;
			}
			return output;

		}else if(n<0){


			RandomAccessFile rfile=new RandomAccessFile(file, "r");
			long length=file.length();

			int count=0;
			length--;
			long seek=length;
			StringBuilder temp= new StringBuilder();
			while(seek>=0){
				rfile.seek(seek);
				char c=(char)rfile.read();
				temp.append(c);
				if(c=='\n'){
					temp.reverse();
					output[count++]=temp.toString();
					temp=null;
					temp=new StringBuilder();
					n--;
				}

				if(0==n){
					break;
				}
				seek--;
			}
			temp.reverse();
			output[count++]=temp.toString();
			rfile.close();
			return output;
		}
		return null;
	}

	@Override
	public String[] getBetweenToArray(String path, long start, long end) throws IOException {

		boolean reverseFlag=false;
		int no_of_lines=0;
		int i,j=0;
		File file=isFileExists(path);
		if(file==null||(start<0)||(end<0))
			return null;
		BufferedReader reader=new FileAccess().getBufferedReader(path);
		if(start > end){
			long temp=start;
			start=end;
			end=temp;
			reverseFlag=true;
			no_of_lines=(int) (end-start);
			j=no_of_lines;

		}
		String output[]=new String[no_of_lines];
		for(i=0;i<=end;i++){
			reader.readLine();
			if(i<start){
				continue;
			}
			if(reverseFlag)
				output[j++]=reader.readLine();
			else
				output[j--]=reader.readLine();
		}
		return output;
	}


	@Override
	public String[] getAllLines(String path) throws IOException {
		File file=isFileExists(path);
		if(file==null)
			return null;
		BufferedReader reader=getBufferedReader(path);

		int length=getTotalLines(reader);
		String output[]=new String[length];
		for(int i=0;i<length;i++){
			output[i]=reader.readLine();
		}
		return output;
	}

	@Override
	public String[] getAllLines(URL url) throws IOException {
		InputStream inputStream=null;
		BufferedReader reader=null;
		ArrayList<String> output= new ArrayList<String>();
		String line=null;
		try{
			inputStream=url.openStream();
			reader=new BufferedReader(new InputStreamReader(inputStream));
			while((line=reader.readLine())!=null){
				output.add(line);
			}
		}finally{
			if(inputStream!=null)
				inputStream.close();
			if(reader!=null)
				reader.close();
		}
		String[] out=new String[output.size()];
		output.toArray(out);
		return out;
	}


	@Override
	public String[] getAllLines(BufferedReader reader) throws IOException {

		if(reader==null)
			return null;
		int length=getTotalLines(reader);
		String output[]=new String[length];
		for(int i=0;i<length;i++){
			output[i]=reader.readLine();
		}
		reader.close();
		return output;
	}

	@Override
	public int getTotalLines(String path) throws IOException {
		File file=isFileExists(path);
		if(file==null)
			throw new FileNotFoundException();
		return getTotalLines(file);
	}


	@Override
	public int getTotalLines(FileReader reader) throws IOException {
		LineNumberReader line=null;
		try{
			line=new LineNumberReader(reader);
			line.skip(Long.MAX_VALUE);
			return line.getLineNumber();
		}finally{
			line.close();
		}
	}
	public int getTotalLines(BufferedReader reader) throws IOException {
		LineNumberReader line=null;
		try{
			line=new LineNumberReader(reader);
			line.skip(Long.MAX_VALUE);
			return line.getLineNumber();
		}finally{
			line.close();
		}
	}


	@Override
	public int getTotalLines(File file) throws IOException {
		if(!file.exists())
			throw new FileNotFoundException();
		return getTotalLines(new FileReader(file));
	}

	@Override
	public long getCharacterCount(String path) {
		File file=isFileExists(path);
		return (file!=null)? file.length():-1;	
	}

	@Override
	public long getCharacterCount(File file) {
		return (file!=null)? file.length():-1;
	}

	@Override
	public long getCharacterCount(BufferedReader reader) throws IOException {
		long count=0;
		while(reader.read()!=-1)
			count++;
		return count;
	}
}
