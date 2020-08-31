package com.drobot.shape.observer;

import com.drobot.shape.exception.ObserverException;

public interface Observable {
    void attach(Observer observer);
    void detach(Observer observer);
    void notifyObservers() throws ObserverException;
}
