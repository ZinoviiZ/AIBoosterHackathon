package com.healthcare.innovation.service;

import org.python.core.PyObject;
import org.python.util.PythonInterpreter;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.healthcare.model.NNResponce;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.StringWriter;

import static java.lang.System.out;

/**
 * Created by zinoviyzubko on 23.09.17.
 */
@Service
public class ImageService {

	private NNResponce process(File fileToSys) throws IOException {
		ClassLoader classLoader = getClass().getClassLoader();

		StringBuilder sb = new StringBuilder();
		File ff = new File(classLoader.getResource("algorithm").getFile());
		System.out.println(ff.getAbsolutePath());

		sb.append("cd " + ff.getAbsolutePath() + "\n");
		sb.append("pwd\n");
		sb.append("python test.py " + fileToSys.getAbsolutePath() + "\n");

		// Start the shell
		ProcessBuilder pb = new ProcessBuilder("/bin/bash");
		Process bash = pb.start();

		// Pass commands to the shell
		PrintStream ps = new PrintStream(bash.getOutputStream());
		ps.println(sb);
		ps.close();

		// Get an InputStream for the stdout of the shell
		BufferedReader br = new BufferedReader(new InputStreamReader(bash.getInputStream()));

		// Retrieve and print output
		String line;
		String lastLine = "";
		while (null != (line = br.readLine())) {
			lastLine = line;
			System.out.println("> " + line);
		}
		br.close();

		// Make sure the shell has terminated, print out exit value
		try {
			System.out.println("Exit code: " + bash.waitFor());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// temp trash
		int x = Integer.parseInt(lastLine);
		if(x % 2 == 1) {
			return new NNResponce("78", "22");
		}
		else {
			return new NNResponce("22", "78");
		}
//		return lastLine;
	}

	@PostConstruct
	public void init() throws Exception {

		out.println("start");

	}

	private File convert(MultipartFile file) {
		File convFile = new File(file.getOriginalFilename());
		
		FileOutputStream fos;
		try {
			convFile.createNewFile();
			fos = new FileOutputStream(convFile);
			fos.write(file.getBytes());
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return convFile;
	}

	public NNResponce predictImage(MultipartFile file) {

		File fileToSys = convert(file);
		System.out.println(fileToSys.getAbsolutePath());
		
		System.out.println("Got file");
		NNResponce res = null;
		try {
			res = process(fileToSys);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

	public String test() {
		out.println("DONE");
		return "1";

	}
}
