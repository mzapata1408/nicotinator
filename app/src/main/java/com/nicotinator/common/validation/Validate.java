package com.nicotinator.common.validation;

import com.nicotinator.common.MessageSupplier;

public class Validate {

    private static void notNull(Object value, String message) {
        if (value == null) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void notNull(Object value, MessageSupplier messageSupplier) {
        notNull(value, messageSupplier.get());
    }
}
