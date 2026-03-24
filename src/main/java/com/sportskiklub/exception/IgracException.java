package com.sportskiklub.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class IgracException extends Exception {

    public IgracException(String message) {
        super(message);
    }
}
