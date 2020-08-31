package com.drobot.shape.specification;

import com.drobot.shape.entity.pyramid.Pyramid;

public interface Specification<T extends Pyramid> {
    boolean specify(T pyramid);
}
