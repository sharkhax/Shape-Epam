package com.drobot.shape.entity.pyramid;

import com.drobot.shape.exception.ObserverException;
import com.drobot.shape.observer.Observable;
import com.drobot.shape.entity.Point;
import com.drobot.shape.observer.Observer;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class Pyramid implements Observable {

    public enum PyramidType {
        TRIANGLE_PYRAMID
    }

    private static final Logger LOGGER = LogManager.getLogger(Pyramid.class);
    protected final PyramidType PYRAMID_TYPE;
    protected UUID pyramidId;
    protected List<Point> points;
    protected List<Observer> observers = new ArrayList<>();

    protected Pyramid(UUID pyramidId, List<Point> points, PyramidType pyramidType) {
        this.points = points;
        this.pyramidId = pyramidId;
        PYRAMID_TYPE = pyramidType;
        LOGGER.log(Level.DEBUG, "Pyramid " + pyramidId.toString() + " has been created");
    }

    public UUID getPyramidId() {
        return pyramidId;
    }

    public void setPyramidId(UUID pyramidId) {
        this.pyramidId = pyramidId;
        LOGGER.log(Level.DEBUG, "Id has been set");
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
    }

    public void setPoints(List<Point> points) throws ObserverException {
        this.points = points;
        notifyObservers();
        LOGGER.log(Level.DEBUG, "Points have been set");
    }

    public PyramidType getPyramidType() {
        return PYRAMID_TYPE;
    }

    public List<Observer> getObservers() {
        return Collections.unmodifiableList(observers);
    }

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
        LOGGER.log(Level.DEBUG, "Observer has been attached");
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
        LOGGER.log(Level.DEBUG, "Observer has been detached");
    }

    @Override
    public void notifyObservers() throws ObserverException {
        LOGGER.log(Level.DEBUG, "Observers have been notified");
        for (Observer observer : observers) {
            observer.handleEvent();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Pyramid pyramid = (Pyramid) o;
        if (!pyramidId.equals(pyramid.pyramidId)) {
            return false;
        }
        if (!points.equals(pyramid.points)) {
            return false;
        }
        return observers.equals(pyramid.observers);
    }

    @Override
    public int hashCode() {
        int result = pyramidId.hashCode();
        result = 31 * result + points.hashCode();
        result = 31 * result + observers.hashCode();
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Pyramid{");
        sb.append("pyramidId=").append(pyramidId);
        sb.append(", points=").append(points);
        sb.append(", observers=").append(observers);
        sb.append('}');
        return sb.toString();
    }
}
