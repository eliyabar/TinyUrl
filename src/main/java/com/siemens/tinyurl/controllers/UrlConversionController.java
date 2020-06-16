package com.siemens.tinyurl.controllers;

import com.siemens.tinyurl.dtos.UrlRequest;
import com.siemens.tinyurl.models.Url;
import com.siemens.tinyurl.repositories.UrlRepository;
import com.siemens.tinyurl.services.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class UrlConversionController {

    @Value("${app.tiny.url.entry-point}")
    public String ENTRY_POINT;

    @Autowired
    UrlRepository urlRepository;

    @Autowired
    UrlService urlService;

    @PostMapping("/create-tinyurl")
    public String createTinyUrl(@RequestBody UrlRequest urlRequest) {
        return ENTRY_POINT + urlService.convertToTiny(urlRequest);
    }

    @GetMapping("urls")
    public List<Url> getAll(){
        return urlRepository.findAll();
    }
}