package com.healthcare.innovation.rest;

import com.healthcare.innovation.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by zinoviyzubko on 23.09.17.
 */
@Controller
public class ImageController {

    @Autowired private ImageService imageService;
    
    @CrossOrigin(origins = "http://localhost")
    @RequestMapping(value = "/image", method = POST, produces = "application/json")
    public String predictCancer(@RequestParam("image") MultipartFile file) {

    	String resp = imageService.predictImage(file);
    	System.out.println(resp);
        return resp;
    }

    @RequestMapping(value = "/test", method = GET)
    public String predictCancer() {

        return imageService.test();
    }
}
