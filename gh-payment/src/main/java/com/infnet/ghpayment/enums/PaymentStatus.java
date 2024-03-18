package com.infnet.ghpayment.enums;

import lombok.AllArgsConstructor;


@AllArgsConstructor
public enum PaymentStatus {
    PENDING(Values.PENDING),
    COMPLETED(Values.COMPLETED),
    CANCELED(Values.CANCELED);

    private String value;

    public static class Values {
        public static final String PENDING = "PENDING";
        public static final String COMPLETED = "COMPLETED";
        public static final String CANCELED = "CANCELED";
    }
}
