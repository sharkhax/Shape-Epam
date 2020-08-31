package com.drobot.shape.repository.impl;

import com.drobot.shape.entity.pyramid.Pyramid;
import com.drobot.shape.repository.Repository;
import com.drobot.shape.specification.Specification;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PyramidRepository implements Repository<Pyramid> {

    private static final Logger LOGGER = LogManager.getLogger(PyramidRepository.class);
    private static PyramidRepository instance;
    private final List<Pyramid> storage;
    private static final int MAX_CAPACITY = 1000;

    private PyramidRepository() {
        storage = new ArrayList<>(MAX_CAPACITY);
        LOGGER.log(Level.INFO, "PyramidRepository has been created");
    }

    public static PyramidRepository getInstance() {
        if (instance == null) {
            instance = new PyramidRepository();
        }
        return instance;
    }

    @Override
    public boolean add(Pyramid pyramid) {
        boolean result = false;
        if (storage.size() != MAX_CAPACITY) {
            result = storage.add(pyramid);
            LOGGER.log(Level.DEBUG, "Pyramid has been add");
        }
        return result;
    }

    @Override
    public boolean remove(Pyramid pyramid) {
        if (storage.contains(pyramid)) {
            LOGGER.log(Level.DEBUG, "Pyramid has been removed");
        } else {
            LOGGER.log(Level.DEBUG, "Pyramid has not been removed: does not contain");
        }
        return storage.remove(pyramid);
    }

    @Override
    public int size() {
        return storage.size();
    }

    @Override
    public List<Pyramid> sort(Comparator<Pyramid> comparator) {
        List<Pyramid> sortedList = new ArrayList<>(storage);
        sortedList.sort(comparator);
        LOGGER.log(Level.DEBUG, "Sorting complete");
        return sortedList;
    }

    @Override
    public List<Pyramid> query(Specification<Pyramid> specification) {
        List<Pyramid> result = storage.stream().filter(specification::specify).collect(Collectors.toList());
        LOGGER.log(Level.DEBUG, "Query complete");
        LOGGER.log(Level.DEBUG, result.size());
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Repository{");
        sb.append("storage: ").append(storage);
        sb.append('}');
        return sb.toString();
    }
}
