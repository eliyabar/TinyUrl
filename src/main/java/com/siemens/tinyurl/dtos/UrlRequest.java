package com.siemens.tinyurl.dtos;

import java.io.Serializable;

public class UrlRequest implements Serializable {

    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
