package com.cat.misc.annotation;

public enum Gender {
    MAN {
        public String getName() {
            return "male";
        }
    }, WOMAN {
        public String getName() {
            return "female";
        }
    };

    public abstract String getName();

}
