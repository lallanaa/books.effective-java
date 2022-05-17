package com.book.effectivejava.hee.chapter2.item5.dependencyinjection;

import com.book.effectivejava.hee.chapter2.item5.DefaultDictionary;
import com.book.effectivejava.hee.chapter2.item5.IDictionary;
import org.springframework.stereotype.Component;

import javax.swing.plaf.SplitPaneUI;
import java.util.List;
import java.util.function.Supplier;

//의존성주입을 사용하여 만든 클래스 :
//주입한 Dictionary 가 인터페이스이면!
//Dictionary의 구현체가 변경되어도, 아래 클래스 안의 모든 코드를 재사용할 수 있다.
@Component
public class SpellChecker {

    //의존성주입
    private final IDictionary dictionary;

    public SpellChecker(IDictionary dictionary) {
        //클래스 내에서 사용하는 자원을 직접 명시한 것이 아니라, 주입한 자원 클래스에 접근이 가능하도록 장치.
        this.dictionary = dictionary;
    }

    //5-2. 완벽공략
    //의존객체를 생성하는 Factory클래스를 사용하여 객체 주입(p29. 생성자에 자원 팩터리를 넘겨주는 방식)
    //자원을 바로 받는 것이 아니라, 자원을 만들어주는 팩터리를 받아서 한번 더 추상화시킴.
    //ex. Supplier<T> 인터페이스 : 받는 것은 없고 하나를 리턴하는 함수.
    /*public SpellChecker(DictionaryFactory dictionaryFactory) {
        this.dictionary = dictionaryFactory.get(); //펙터리 메소드 패턴
    }*/
    //DictionaryFactory 를 만드는 것 대신, Supplier 인터페이스로 사용할 수 있다.
    /*public SpellChecker(Supplier<IDictionary> dictionarySupplier) {
        this.dictionary = dictionarySupplier.get();
    }*/
    //IDictionary 인터페이스 뿐 아니라, 이의 하위타입을 생성하는 팩토리도 받을 수 있음.
    //p29. 한정적 와일드카드 타입을 사용해 팩터리의 타입 매개변수를 제한하는 방법
    public SpellChecker(Supplier<? extends IDictionary> dictionarySupplier) {
        //문맥의 추측 : <? extends IDictionary> 를 쓰라고 하는 이유?
        //Supplier<DefaultDictionary> 처럼, 구체적인 타입을 받아오는 Supplier 함수형 인터페이스의 경우, 다른 Dictionary는 주입을 해줄 수 없다.
        this.dictionary = dictionarySupplier.get();
    }


    public boolean isValid(String word) {
        // TODO SpellChecker 에서 쓰는 코드 (이 부분에 코드가 없으, dictionary 클래스를 직접 사용하는 것이 옳다)
        return dictionary.contains(word);
    }

    public List<String> suggestion(String typo) {
        // TODO SpellChecker 에서 쓰는 코드
        return dictionary.closeWordsTo(typo);
    }

    //1.팩토리메소드패턴
    //2.스프링IoC
}
