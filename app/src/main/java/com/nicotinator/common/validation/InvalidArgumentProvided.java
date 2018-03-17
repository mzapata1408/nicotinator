package com.nicotinator.common.validation;

import com.nicotinator.common.MessageSupplier;

public class InvalidArgumentProvided implements MessageSupplier {

    private static final String INVALID_ARGUMENT_PROVIDED = "Invalid argument provided: ";

    private final String name;

    public InvalidArgumentProvided(String name) {
        this.name = name;
    }

    public static InvalidArgumentProvided of(String name) {
        return new InvalidArgumentProvided(name);
    }

    @Override
    public String get() {
        return INVALID_ARGUMENT_PROVIDED + name;
    }
}
