package com.healthcare.innovation.service;

import org.python.core.PyObject;
import org.python.util.PythonInterpreter;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.StringWriter;

import static java.lang.System.out;

/**
 * Created by zinoviyzubko on 23.09.17.
 */
@Service
public class ImageService {

	@PostConstruct
	public void init() throws Exception {

		out.println("start");
		ClassLoader classLoader = getClass().getClassLoader();

		StringBuilder sb = new StringBuilder();
		File ff = new File(classLoader.getResource("algorithm").getFile());
		System.out.println(ff.getAbsolutePath());

		sb.append("cd " + ff.getAbsolutePath() + "\n");
		sb.append("pwd\n");
		sb.append("python test.py\n");

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
		while (null != (line = br.readLine())) {
			System.out.println("> " + line);
		}
		br.close();

		// Make sure the shell has terminated, print out exit value
		System.out.println("Exit code: " + bash.waitFor());

	}

	public String predictImage(MultipartFile file) {

		System.out.println("Got file");
		return file.getName();
	}

	public String test() {
		out.println("DONE");
		return "1";
		
	}
}
