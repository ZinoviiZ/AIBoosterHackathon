package com.healthcare.innovation;

import static java.lang.System.out;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.PrintStream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by zinoviyzubko on 23.09.17.
 */
@SpringBootApplication
public class HealthcareInnovation {

    public static void main(String[] args) {
        SpringApplication.run(HealthcareInnovation.class, args);
    }
}


/**

        out.println("start");
//        Process p = Runtime.getRuntime().exec("python /Users/zinoviyzubko/Downloads/test/test.py");
//
//        BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
//        while (in.ready())
//            System.out.println("value is : "+in.readLine());
//
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("algorithm/go.sh").getFile());
//        file.getPath();
//        
//        PythonInterpreter python = new PythonInterpreter();
//
//        
//        StringWriter out = new StringWriter();
//        python.setOut(out);
//        python.exec(file.getPath());
//        
//        System.out.println(out.toString());
        
        StringBuilder sb = new StringBuilder();

        // You're not strictly speaking executing a shell script but
        // rather programatically typing commands into the shell
        //sb.append("#!/bin/bash\n");
        //sb.append(file.getAbsolutePath());
        //sb.append("echo Hello world!\n");
        //sb.append("cd /tmp\n");
        //sb.append("echo current directory: `pwd`\n");
        
        //sb.append("#!/usr/bin/env python");
        //sb.append("print 2");
        

        // Start the shell
        //ProcessBuilder pb = new ProcessBuilder("/usr/bin/python");
        ProcessBuilder pb = new ProcessBuilder("/bin/bash");
        Process bash = pb.start();

        // Pass commands to the shell
        PrintStream ps = new PrintStream(bash.getOutputStream());
        ps.println(sb);
        ps.close();

        // Get an InputStream for the stdout of the shell
        BufferedReader br = new BufferedReader(
            new InputStreamReader(bash.getInputStream()));

        // Retrieve and print output
        String line;
        while (null != (line = br.readLine())) {
          System.out.println("> "+line);
        }
        br.close();

        // Make sure the shell has terminated, print out exit value
        System.out.println("Exit code: " + bash.waitFor());
*/