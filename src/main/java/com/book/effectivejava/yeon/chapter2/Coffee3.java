package com.book.effectivejava.yeon.chapter2;

public class Coffee3 {
    private String bean;
    private boolean water;
    private boolean syrup;

    public static Coffee3.Builder builder() {
        return new Coffee3.Builder();
    }

    public static Coffee3.Builder builder(String bean, boolean water) {
        return new Coffee3.Builder(bean, water);
    }

    public Coffee3(String bean, boolean water, boolean syrup) {
        this.bean = bean;
        this.water = water;
        this.syrup = syrup;
    }

    public static class Builder {
        //필수 매개변수
        private String bean;
        private boolean water;

        //선택 매개변
        private boolean syrup;

        public Builder() {

        }

        public Builder(String bean, boolean water) {
            this.bean = bean;
            this.water = water;
        }

        public Builder bean(String val) {
            this.bean = bean;
            return this;
        }

        public Builder water(boolean water) {
            this.water = water;
            return this;
        }

        public Builder syrup(boolean val) {
            this.syrup = val;
            return this;
        }

        public Coffee3 build() {
            return new Coffee3(bean, water, syrup);
        }
    }
}
