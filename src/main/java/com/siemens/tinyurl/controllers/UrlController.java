package com.siemens.tinyurl.controllers;

import com.siemens.tinyurl.repositories.UrlRepository;
import com.siemens.tinyurl.services.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/url")
public class UrlController {

    @Autowired
    UrlRepository urlRepository;

    @Autowired
    UrlService urlService;

    @GetMapping(value = "{tinyUrlId}")
    public String getAllNotes(@PathVariable String tinyUrlId) {
        return urlService.convertToFullUrl(tinyUrlId);
    }
}
