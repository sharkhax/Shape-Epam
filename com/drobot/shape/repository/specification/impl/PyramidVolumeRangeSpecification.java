package com.drobot.shape.repository.specification.impl;

import com.drobot.shape.entity.PyramidRecorder;
import com.drobot.shape.entity.PyramidWarehouse;
import com.drobot.shape.entity.pyramid.Pyramid;
import com.drobot.shape.repository.specification.Specification;

import java.util.UUID;

public class PyramidVolumeRangeSpecification<T extends Pyramid> implements Specification<T> {

    private final double minValue;
    private final double maxValue;

    public PyramidVolumeRangeSpecification(double minValue, double maxValue) {
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    @Override
    public boolean specify(T pyramid) {
        UUID pyramidId = pyramid.getPyramidId();
        PyramidWarehouse warehouse = PyramidWarehouse.getInstance();
        PyramidRecorder recorder = warehouse.get(pyramidId);
        double pyramidVolume = recorder.getVolume();
        return pyramidVolume >= minValue && pyramidVolume <= maxValue;
    }
}
