package com.infnet.ghproperty.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum UserType {
    LOCATARIO(Values.LOCATARIO),
    PROPRIETARIO(Values.PROPRIETARIO);

    private String value;

    public static class Values {
        public static final String LOCATARIO = "LOCATARIO";
        public static final String PROPRIETARIO = "PROPRIETARIO";
    }

}
