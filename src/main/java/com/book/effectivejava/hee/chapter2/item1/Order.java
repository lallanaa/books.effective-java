package com.book.effectivejava.hee.chapter2.item1;

public class Order {

    private boolean prime;

    private boolean urgent;

    private Product product;

    // 정적 팩터리 메소드 활용을 위하여 기존에 만들어 놓은 생성자들을 주석처리 -> 생성자가 없는 클래스는 자동으로 기본생성자가 생성됨!!!
    /*public Order(Product product, boolean prime) {
        this.product = product;
        this.prime = prime;
    }*/

    // 동일한 시그니처(생성자의 파라미터 타입과 순서)의 생성자를 여러 개 만들 수 없다.
    // 생성자도 일종의 메서드 역할을 하기 때문. 컴파일 에러 발생.
    // 파라미터의 순서를 바꿔줌으로서 우회를 할 수 있지만 좋은 방법은 아니다.
    /*public Order(Product product, boolean urgent) {
        this.product = product;
        this.urgent = urgent;
    }*/

    /**
     * 정적 팩터리 메소드를 이용해서 prime의 값으로 생성하는 방식, urgent의 값으로 생성하는 방식 두 가지를 구분해보자.
     * 추상팩토리 패턴 or 팩토리 메서드 패턴과 혼동하지 말  <- 두 가지 패턴과는 무관함.
     */
    public static Order primeOrder(Product product) {
        Order order = new Order();
        order.prime = true;
        order.product = product;
        return order;
    }

    public static Order urgentOrder(Product product) {
        Order order = new Order();
        order.urgent = true;
        order.product = product;
        return order;
    }

    // 정적 팩터리 메소드의 장점

    // 1. 객체를 생성하는 메서드(생성자와 다르기 때문에 이름이 있지)의 특징을 이름으로 표현할 수 있다!
    // 따라서 생성자의 시그니처가 중복되는 위와 같은 케이스에서는 정적 팩터리 메서드를 사용하면 좋다.
}
