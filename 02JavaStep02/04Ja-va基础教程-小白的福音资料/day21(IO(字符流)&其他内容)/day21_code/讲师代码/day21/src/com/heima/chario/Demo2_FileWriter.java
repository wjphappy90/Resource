package com.heima.chario;

import java.io.FileWriter;
import java.io.IOException;

public class Demo2_FileWriter {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		FileWriter fw = new FileWriter("yyy.txt");
		fw.write("大家好,基础班快接近尾声了,大家要努力,要坚持!!!");
		fw.write(97);
		fw.close();
	}

}
