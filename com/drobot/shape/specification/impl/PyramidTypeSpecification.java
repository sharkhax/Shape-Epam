package com.drobot.shape.specification.impl;

import com.drobot.shape.entity.pyramid.Pyramid;
import com.drobot.shape.specification.Specification;

public class PyramidTypeSpecification implements Specification<Pyramid> {

    private final Pyramid.PyramidType pyramidType;

    public PyramidTypeSpecification(Pyramid.PyramidType pyramidType) {
        this.pyramidType = pyramidType;
    }

    @Override
    public boolean specify(Pyramid pyramid) {
        return pyramid.getPyramidType().equals(pyramidType);
    }
}
