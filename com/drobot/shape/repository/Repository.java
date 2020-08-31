package com.drobot.shape.repository;

import com.drobot.shape.entity.pyramid.Pyramid;
import com.drobot.shape.specification.Specification;

import java.util.Comparator;
import java.util.List;

public interface Repository<T extends Pyramid> {

    boolean add(T pyramid);
    boolean remove(T pyramid);
    int size();
    List<T> sort(Comparator<T> comparator);
    List<T> query(Specification<T> specification);
}
