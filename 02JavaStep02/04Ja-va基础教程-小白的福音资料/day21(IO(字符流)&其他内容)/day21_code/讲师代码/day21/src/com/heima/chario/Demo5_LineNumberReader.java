package com.heima.chario;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class Demo5_LineNumberReader {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		LineNumberReader lnr = new LineNumberReader(new FileReader("zzz.txt"));
		
		String line;
		lnr.setLineNumber(100);
		while((line = lnr.readLine()) != null) {
			System.out.println(lnr.getLineNumber() + ":" + line);
		}
		
		lnr.close();
	}

}
