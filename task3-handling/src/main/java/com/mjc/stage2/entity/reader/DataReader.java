package com.mjc.stage2.entity.reader;


import com.mjc.stage2.exception.HandlingException;

public interface DataReader {
    String readFile(String path) throws HandlingException;

}
