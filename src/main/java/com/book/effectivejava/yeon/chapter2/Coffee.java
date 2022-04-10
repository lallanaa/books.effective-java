package com.book.effectivejava.yeon.chapter2;

public class Coffee {

    private String bean;
    private boolean water;
    private boolean moreWater;
    private boolean syrup;

    public Coffee(Builder builder) {
        bean = builder.bean;
        water = builder.water;
        moreWater = builder.moreWater;
        syrup = builder.syrup;
    }

    public static class Builder {
        //필수 매개변수
        private String bean;
        private boolean water;

        //선택 매개변수
        private boolean moreWater;
        private boolean syrup;

        public Builder(String bean, boolean water) {
            this.bean = bean;
            this.water = water;
        }

        public Builder moreWater(boolean val) {
            this.moreWater = val;
            return this;
        }

        public Builder syrup(boolean val) {
            this.syrup = val;
            return this;
        }

        public Coffee build() {
            return new Coffee(this);
        }
    }
}
