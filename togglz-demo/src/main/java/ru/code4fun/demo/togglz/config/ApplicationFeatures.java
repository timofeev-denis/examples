package ru.code4fun.demo.togglz.config;

import org.togglz.core.Feature;
import org.togglz.core.annotation.Label;

public enum ApplicationFeatures implements Feature {

    @Label("Some custom message")
    MESSAGE_A
}
