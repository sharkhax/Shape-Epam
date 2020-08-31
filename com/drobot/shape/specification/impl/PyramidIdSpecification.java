package com.drobot.shape.specification.impl;

import com.drobot.shape.entity.pyramid.Pyramid;
import com.drobot.shape.specification.Specification;

import java.util.UUID;

public class PyramidIdSpecification<T extends Pyramid> implements Specification<T> {

    private final UUID id;

    public PyramidIdSpecification(UUID id) {
        this.id = id;
    }

    @Override
    public boolean specify(T pyramid) {
        return pyramid.getPyramidId().equals(id);
    }
}
