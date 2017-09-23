package com.healthcare.innovation.rest;

import com.healthcare.innovation.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    @RequestMapping(value = "/image", method = POST)
    public String predictCancer(@RequestParam("image") MultipartFile file) {

        return imageService.predictImage(file);
    }

    @RequestMapping(value = "/test", method = GET)
    public void predictCancer() {

        imageService.test();
    }
}
