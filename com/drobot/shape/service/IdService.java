package com.drobot.shape.service;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.UUID;

public class IdService {

    private static final Logger LOGGER = LogManager.getLogger(IdService.class);

    public static UUID generateId() {
        LOGGER.log(Level.DEBUG, "Id has been generated");
        return UUID.randomUUID();
    }

    public static UUID fromString(String id) {
        return UUID.fromString(id);
    }
}
