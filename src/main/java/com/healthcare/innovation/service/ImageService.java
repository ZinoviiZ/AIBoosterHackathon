package com.healthcare.innovation.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import static java.lang.System.out;

/**
 * Created by zinoviyzubko on 23.09.17.
 */
@Service
public class ImageService {

    @PostConstruct
    public void init() throws Exception {

        out.println("start");
        Process p = Runtime.getRuntime().exec("python /Users/zinoviyzubko/Downloads/test/test.py");

        BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
        while (in.ready())
            System.out.println("value is : "+in.readLine());

//        StringWriter writer = new StringWriter(); //ouput will be stored here
//
//        ScriptEngineManager manager = new ScriptEngineManager();
//        ScriptContext context = new SimpleScriptContext();
//
//        context.setWriter(writer); //configures output redirection
//        ScriptEngine engine = manager.getEngineByName("python");
//        engine.eval(new FileReader("numbers.py"), context);
//        System.out.println(writer.toString());
    }

    public String predictImage(MultipartFile file) {

        return file.getName();
    }

    public void test() {

        out.println("DONE");
    }
}
