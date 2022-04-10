package com.book.effectivejava.hee.chapter2.item2.hierarchicalbuilder;

import lombok.Builder;

@Builder
public class Calzone extends Pizza {
    private final boolean sauseInside;

    public static class Builder extends Pizza.Builder<Builder> { // Calzone를 반환
        private boolean sauceInside = false;

        public Builder sauceInside() {
            sauceInside = true;
            return this;
        }

        @Override
        public Calzone build() {
            return new Calzone(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    private Calzone(Builder builder) {
        super(builder);
        sauseInside = builder.sauceInside;
    }
}
