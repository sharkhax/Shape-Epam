package com.drobot.shape.entity;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PyramidWarehouse {

    private static final Logger LOGGER = LogManager.getLogger(PyramidWarehouse.class);
    private static PyramidWarehouse instance;
    private final Map<UUID, PyramidRecorder> storage;

    private PyramidWarehouse() {
        storage = new HashMap<>();
        LOGGER.log(Level.INFO, "PyramidWarehouse has been created");
    }

    public static PyramidWarehouse getInstance() {
        if (instance == null) {
            instance = new PyramidWarehouse();
        }
        return instance;
    }

    public int size() {
        return storage.size();
    }

    public boolean isEmpty() {
        return storage.isEmpty();
    }

    public boolean contains(UUID id) {
        return storage.containsKey(id);
    }

    public boolean contains(PyramidRecorder recorder) {
        return storage.containsValue(recorder);
    }

    public PyramidRecorder get(UUID id) {
        return storage.get(id);
    }

    public PyramidRecorder put(UUID key, PyramidRecorder value) {
        LOGGER.log(Level.DEBUG, "PyramidRecorder has been put");
        return storage.put(key, value);
    }

    public PyramidRecorder remove(UUID id) {
        if (storage.containsKey(id)) {
            LOGGER.log(Level.DEBUG, "PyramidRecorder has been removed");
        } else {
            LOGGER.log(Level.WARN, "PyramidRecorder has not been removed: does not contain");
        }
        return storage.remove(id);
    }
}
