package com.book.effectivejava.hee.chapter2.item6;

public class Deprecation {

    /**
     * @deprecated in favor of
     * {@link #Deprecation(String)}
     */
    // TODO 애노테이션 프로세서 & JavaDoc 에서 '#' 의 의미
    @Deprecated(forRemoval = true, since = "1.2") //forRemoval : 삭제될 거니? , since : 이 프로그램의 몇 버전부터? (Java9이후)
    public Deprecation() {
        // 만약에 이제 이 기본생성자를 앞으로 사용하지 않도록 하고 싶으면 @Deprecated 를 붙여서 컴파일러가 애노테이션 프로세서를 통해서, 처리를 해줌!
        // 컴파일 경고 메시지를 보여준다.
    }

    private String name;

    public Deprecation(String name) {
        this.name = name;
    }
}
