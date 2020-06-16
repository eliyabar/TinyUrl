package com.siemens.tinyurl.services;

import com.siemens.tinyurl.dtos.UrlRequest;
import com.siemens.tinyurl.models.Url;
import com.siemens.tinyurl.repositories.UrlRepository;
import com.siemens.tinyurl.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;

@Service
public class UrlService {
    public static int URL_DAYS_TO_LIVE = 30;
    @Autowired
    private UrlRepository urlRepository;

    @Autowired
    private Base62Converter base62Converter;

    public String convertToTiny(UrlRequest urlRequest) {
        Url url = new Url();
        url.setFullURL(urlRequest.getUrl());
        Date date = new Date();
        url.setCreatedOn(date);
        url.setExpiresOn(DateUtil.getExpiredDate(date, URL_DAYS_TO_LIVE));
        Url entity = urlRepository.save(url);
        return base62Converter.encode(entity.getId());
    }

    public String convertToFullUrl(String tinyUrlId) {
        Url entity = urlRepository.findById(base62Converter.decode(tinyUrlId)).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "There is no TinyUrl for: " + tinyUrlId));
        return entity.getFullURL();

    }


}
