package com.siemens.tinyurl.models;
import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@SequenceGenerator(name = "range", initialValue = 100000000)
public class Url {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "range")
    private long id;

    @Size(min = 4, max = 2000)
    @URL()
    @NotNull
    private String fullURL;

    @NotNull
    private Date createdOn;

    private Date expiresOn;

    public Url(){}

    public Url(long id){

        this.id = id;
    }

    public Url(long id, String fullURL, String tinyURL) {
        this.id = id;
        this.fullURL = fullURL;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullURL() {
        return fullURL;
    }

    public void setFullURL(String fullURL) {
        this.fullURL = fullURL;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getExpiresOn() {
        return expiresOn;
    }

    public void setExpiresOn(Date expiresOn) {
        this.expiresOn = expiresOn;
    }
}
