package com.siemens.tinyurl.services;

import org.springframework.stereotype.Service;

@Service
public class Base62Converter implements IBaseConverter {

    private static final String allowedCharString = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private final char[] allowedCharacters = allowedCharString.toCharArray();
    private final int base = allowedCharacters.length;

    @Override
    public String encode(long value) {
        StringBuilder encodedString = new StringBuilder();
        if(value == 0) {
            return String.valueOf(allowedCharacters[0]);
        }
        while (value > 0) {
            encodedString.append(allowedCharacters[(int) (value % base)]);
            value = value / base;
        }
        return encodedString.reverse().toString();
    }

    @Override
    public long decode(String value) {
        char[] characters = value.toCharArray();
        int length = characters.length;

        long decoded = 0;

        int counter = 1;
        for (char character : characters) {
            decoded += allowedCharString.indexOf(character) * Math.pow(base, length - counter);
            counter++;
        }
        return decoded;
    }
}
