package com.poc.ecard.constants;

import lombok.experimental.UtilityClass;

@UtilityClass
public class DbConstants {

    public static final String UUID_CHAR = "uuid-char";

    @UtilityClass
    public class PaymentsInfo {

        public final String TABLE_NAME = "PAYMENTS_INFO";

        public class Column {

            public static final String ORDER_ID = "ORDER_ID";

            public static final String ORDER_AMOUNT = "ORDER_AMOUNT";

            public static final String CURRENCY_TYPE = "CURRENCY_TYPE";

            public static final String GATEWAY_NAME = "GATEWAY_NAME";

            public static final String GATEWAY_ORDER_ID = "GATEWAY_ORDER_ID";

            private Column() throws IllegalAccessException {
                throw new IllegalAccessException("EXCEPTION_STRING");
            }

        }

    }


}
