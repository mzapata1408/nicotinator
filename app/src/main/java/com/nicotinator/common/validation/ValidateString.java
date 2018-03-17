package com.nicotinator.common.validation;

import com.nicotinator.common.MessageSupplier;

public class ValidateString {

    public static void notEmpty(String value, MessageSupplier messageSupplier) {
        Validate.notNull(value, messageSupplier);

        if (value.trim().isEmpty()) {
            throw new IllegalArgumentException(messageSupplier.get());
        }
    }
}
