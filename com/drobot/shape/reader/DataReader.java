package com.drobot.shape.reader;

import com.drobot.shape.exception.ReaderException;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class DataReader {

    private static final Logger LOGGER = LogManager.getLogger(DataReader.class);
    private static final String FILE_PATH = "data/info.txt";

    public List<String> readFile() throws ReaderException {
        List<String> result;
        try (FileReader reader = new FileReader(FILE_PATH)) {
            BufferedReader bufferedReader = new BufferedReader(reader);
            result = bufferedReader.lines().collect(Collectors.toList());
            LOGGER.log(Level.INFO, "File has been read: " + result.size() + " lines");
        } catch (IOException e) {
            LOGGER.log(Level.ERROR, "Exception while reading file", e);
            throw new ReaderException(e);
        }
        return result;
    }
}
