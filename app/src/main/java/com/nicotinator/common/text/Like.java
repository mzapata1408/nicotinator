package com.nicotinator.common.text;

import java.util.Objects;

import com.nicotinator.common.validation.InvalidArgumentProvided;

public class Like {

    public static String contains(String term) {
        Objects.requireNonNull(term, new InvalidArgumentProvided(term));
        return "%" + term + "%";
    }
}
