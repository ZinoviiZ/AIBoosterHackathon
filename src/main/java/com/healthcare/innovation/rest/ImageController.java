package com.healthcare.innovation.rest;

import com.healthcare.innovation.service.ImageService;
import com.healthcare.model.NNResponce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<NNResponce> predictCancer(@RequestParam("image") MultipartFile file) {

    	NNResponce resp = imageService.predictImage(file);
    	System.out.println(resp.getHealthy() + " " + resp.getUnhealthy());
        return new ResponseEntity<NNResponce>(resp, HttpStatus.OK);
    }

    @RequestMapping(value = "/test", method = GET)
    public String predictCancer() {

        return imageService.test();
    }
}
