# 아이템 6. 불필요한 객체 생성을 피하라
동일한 객체를 불필요하게 여러번 생성하는 케이스를 막자!

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
