package com.drobot.shape.repository.specification.impl;

import com.drobot.shape.entity.pyramid.Pyramid;
import com.drobot.shape.repository.specification.Specification;

public class PyramidTypeSpecification<T extends Pyramid> implements Specification<T> {

    private final Pyramid.PyramidType pyramidType;

    public PyramidTypeSpecification(Pyramid.PyramidType pyramidType) {
        this.pyramidType = pyramidType;
    }

    @Override
    public boolean specify(T pyramid) {
        return pyramid.getPyramidType().equals(pyramidType);
    }
}
