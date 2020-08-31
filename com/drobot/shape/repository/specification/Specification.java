package com.drobot.shape.repository.specification;

import com.drobot.shape.entity.pyramid.Pyramid;

public interface Specification<T extends Pyramid> {
    boolean specify(T pyramid);
}
