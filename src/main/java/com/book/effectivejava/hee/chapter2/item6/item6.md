# 아이템 6. 불필요한 객체 생성을 피하라
동일한 객체를 불필요하게 여러번 생성하는 케이스를 막자!

### 아이템 6. 핵심 정리
< 대표적인 3가지 케이스 >
1. 문자열의 중복 (메모리를 많이 사용)
```
String hello = "hello";
String hello2 = new String("hello"); // (X)
String hello3 = "hello";

hello == hello2 //false
hello == hello3 //true
hello.equals(hello2) //true
```
jvm 은 내부적으로 문자열을 캐싱한다. 일종의 해시맵에 한번 만들어진 문자열을 담아놓고,
다른 곳에서 동일한 문자열을 참조하려고 할 때, 새로 문자열을 만드는 것이 아니라 이미 만들어 놓은
constant pool 에서 동일한 문자열을 참조.
따라서 new 로 문자열을 생성하는 경우 불 필요하게 동일한 내용의 객체가 생성된다.

2. 정규표현식 (성능에 직접 영향)

정규표현식의 경우 new 문자열과 같이 완전히 동일해서가 아니라, 정규식을 한번 만드는 리소스가 크기 때문에,
동일한 패턴이 여러번 사용되는 경우, field 에 담아서 사용하는 것을 권장한다.   
Pattern.compile 함수가 유한상태머신을 사용하는 알고리즘이여서 속도가 느리다.
정규표현식 : 문자열 패턴이 유효한지 체크하는 것

3. Autoboxing Unboxing

> Autoboxing : primitive type -> wrapper type
> Unboxing : wrapper type -> primitive type

런타임에 jvm 이 autoboxing 과 unboxing 을 자동으로 처리해준다.   
불필요하게 autoboxing, unboxing 이 발생하는 케이스는 지양해야한다.

---
### 아이템 6. 완벽 공략
> * p31. 사용 자제 api ( Deprecation ) - 언젠가 사라질 기능이므로 다른 표현으로 대체 유도
> * p32. 정규표현식 - 사용되는 곳을 파악하여 주의하고 패턴 인스턴스의 재활용에 초점
> * p32. 한 번 쓰고 버려져서 가비지 컬렉션 대상이 된다.
>> * p33. 초기화 지연 기법 (item83) - 인스턴스 생성 시점을 사용시점으로 최대한 늦추는 기법 ( 해당 인스턴스를 만드는 것이 아주 무겁고, 사용 되는 경우가 드문 케이스에서 이 기법을 사용 )
>> * p34. 방어적 복사 (item50) - 새로운 객체를 만들 때, 기존 객체를 카피하여 만들지 말 것

초기화 지연 기법에 대한 생각 ?
* 인스턴스가 선언될 때 생성하지 않고, 인스턴스가 사용될 때 인스턴스가 생성되도록, 인스턴스의 생성 시기를 늦추는 기법이다.
* 초기화 지연 기법이 유효하게 사용되는 경우가 많지 않다.
* 해당 인스턴스를 만드는 것이 아주 무겁고, 사용 되는 경우가 드문 케이스에서 이 기법을 사용하는 것이 유리하다.
* 근데 어찌보면 조삼모사와 같은 것... 사용되는 시점에 인스턴스를 생성한다고 해서 생성 시간이 단축되는 건 아니기 때문이다!
* 오히려 실제 사용환경에서, 무거운 인스턴스는 static으로 생성하여 서버가 켜지는 시간을 좀 길게 하더라도 실제 서비스 시 인스턴스 생성 시간을 줄이는 게 나을 지도..?

#### 완벽공략 1. Deprecation
> 자바가 클라이언트가 사용하지 않기 바라는 코드로 "사용 자제"를 권장하고 대안을 제시.
> @Deprecated
>    * 컴파일 시 경고 메시기를 통해 사용 자제를 권장하는 API 라는 것을 클라이언트에게 알려줄 수 있다.
> @deprecated
>    * 문서화(Javadoc)에 사용해, 왜 해당 API 사용을 지양하며, 그 대신 권장하는 API 가 어떤 것인지 표기

#### 완벽공략 2. 정규표현식
> 정규표현식이 어떤 부분에서 사용되는지, 내부적으로 Pattern이 쓰이는 곳
> * String.matches(String regex)
> * String.split(String regex)
>  * 대안, Pattern.compile(regex).split(str)
> * String.replace*(String regex, String replacement)
>  * 대안, Pattern.compile(regex).matcher(str).replaceAll(repl)

String.split 의 경우 매개변수로 한 글자의 String, 즉 Char 가 들어오면    
String API 의 split 에서 fastpath 를 통해 매개변수가 Pattern.compile(regex) 되지 않고 빠르게 실행된다.   
한 글자 이상의 String 매개변수인 경우 Pattern.compile 을 거치므로 재사용 해야함