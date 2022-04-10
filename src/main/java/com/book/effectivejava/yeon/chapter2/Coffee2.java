package com.book.effectivejava.yeon.chapter2;

import lombok.Builder;

@Builder
public class Coffee2 {
    private String bean;
    private boolean water;
    private boolean moreWater;
    private boolean syrup;
}
