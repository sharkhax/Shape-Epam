package com.drobot.shape.observer;

import com.drobot.shape.exception.ObserverException;

public interface Observer {
    void handleEvent() throws ObserverException;
}
