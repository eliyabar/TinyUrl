package com.siemens.tinyurl.services;

public interface IBaseConverter {
    String encode(long value);
    long decode(String value);
}
