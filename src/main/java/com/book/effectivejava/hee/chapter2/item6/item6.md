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
> 참고 1) https://docs.oracle.com/javase/tutorial/essential/regex/index.html
> 참고 2) https://regex101.com/ 또는 https://regexr.com/

String.split 의 경우 매개변수로 한 글자의 String, 즉 Char 가 들어오면    
String API 의 split 에서 fastpath 를 통해 매개변수가 Pattern.compile(regex) 되지 않고 빠르게 실행된다.   
한 글자 이상의 String 매개변수인 경우 Pattern.compile 을 거치므로 재사용 해야함

#### 완벽공략 3. 가비지 컬렉션
가비지 컬렉션 / 가비지 컬렉션의 대상은 어떻게 처리되는가?
1) 가비지 컬렉션의 **기본 개념** 3가지
2) 자바에 줄 수 있는 가비지 컬렉션 관련 **옵션들** ( GC 로깅 관련 등등 ) - GC 로그는 자세히 남길 수록 좋음
3) tool - jstat, JConsole 와 같이 메모리를 모니터링 할 수 있는 툴. GC log 를 분석해줄 수 있는 툴
> **Mark, Sweep, Compact**   
> Young Generation (Eden, S0(space0), S1(space1), Old generation 영역  
> Minor GC, Full GC   
> Throughput, Latency (Stop-The-World), Footprint - 이 세가지의 관점에서 아래 GC 의 로직들을 확인해야 한다.  
> Serial, Parallel, CMS, G1, ZGC, Shenandoah - Full GC 알고리즘의 종류  
> 참고 ) How to choose the best Java garbage collector
1. 가비지 컬렉션의 기본 개념   
**Mark**: 더 이상 어떤 오브젝트에 대한 참조를 가지고 있는지 체크해 놓는 것.   
해당 오브젝트가 더 이상의 참조가 없는지 체크하여 가비지 컬렉션의 대상인지를 확인   
ex) p32. 정규표현식에 사용되고 난 뒤 Pattern 객체는 한번 사용되고 바로 가비지 컬렉션의 대상이 된 다 == Marking 된다   
**Sweep**: 필요 없는 오브젝트를 실제 메모리 공간인 힙에서 날리는 것   
**Compact**: 파편화 된 메모리 공간을 모아서 다른 큰 메모리가 올라갈 수 있게끔 하는 것
2. 객체의 생명주기
객체의 생명주기는 짧다. -> 오래 살아남는 객체가 많지 않다. 한 메서드 내에서 죽는 객체도 많음.
오래 살아남는 객체는 최종적으로 old generation 영역에서 인스턴스가 관리가 됨.   
금방 죽는 객체가 많기 때문에 두 영역으로 나누어 관리.
   1. Eden 영역: 객체가 처음 생성되는 영역. 해당 영역에 메모리가 가득 차면 더 이상 인스턴스를 생성하지 못하므로 에러(GC 내부적으로 메모리를 할당할 수 없다는 에러)가 남.
   2. Eden 영역이 가득 차서 에러가 발생하면 GC 가 일을 하기 시작함. Eden 영역의 객체를 S1(또는 S0) 영역으로 부으면서 필요없는 오브젝트를 정리한다.   
   S0, S1 은 중요하지 않음. Eden 영역에서 2개의 공간으로 생성된 객체를 계속 한 곳으로 부어가며 필요없어진 객체를 정리한다는 것이 포인트. (여기서 일어나는 건 Minor GC)
   3. 계속 살아남아있는 오브젝트는 오래 살아남아야 하는 것으로 간주하여 Old Generation 영역으로 넘긴다. (Old Generation + Young Generation 모두를 처리하는 건 Full GC)
3. Minor GC vs. Full GC
   1. Minor GC: only Young Generation
   2. Full GC: Young + Old Generation. 대규모의 청소 작업이자 가비지 컬렉션의 꽃.    
   가비지 컬렉션을 위한 다양한 로직이 존재하는데, Java8의 기본 로직은 Parallel 로직이다.
      1. Parallel GC vs. Serial GC   
      Parallel GC 는 Serial GC 와 동일한 방법이나 thread 를 더 많이 사용하여 효율적이나 CPU 가 적은 PC 에서 사용하면 안 됨.
4. Throughput, Latency, Footprint 의 의미
   1. Throughput: 애플리케이션을 처리할 수 있는 처리량.     
      GC가 별도의 thread 를 가지고 mark, sweep, compact 등의 일을 계속 수행하여 시스템 리소스 일부를 계속 사용할 수 있다.   
      -> 애플리케이션의 throughput 이 줄어든다.
   2. **Latency**: stop-the-world. GC 특히 compact 과정에서 모든 것이 멈춘다. GC 만 일을 하고, 새로운 오브젝트를 만들거나 변경이 불가능한 상태가 된다.   
      -> 멈추는 시간이 길어질 수록 시스템 장애가 발생할 수도 있음..   
      -> 어떻게하면 Latency 를 줄일 수 있을까, FullGC 에 걸리는 시간을 줄일 수 있을까 가 화두였던 적이 있다.   
      -> 요즘은 메모리가 엄청 많아지더라도 FullGC time = latency = stop-the-world 가 크게 늘지 않는다. (CMS이후 나온 GC. 특히 ZGC)
   3. Footprint: GC 알고리즘을 수행하는 데에 있어서 필요한 메모리공간.   
      16gb jvm 을 사용하는 애플리케이션이 G1 사용시 800mb 사용한다는 것도 있고....

결론 : 가장 짧은 Latency 를 보장하는 GC 가 짱짱맨 (throughput은 서버를 늘리면 되니까 이걸 조금 포기하더라도..)
알고리즘은 give and take ( 메모리와 CPU의 크기 싸움? )
각 java 버전마다 기본 gc가 다르다. 설정은 가능. 
java8 - parallel, java11 - g1
지금 나온 것 중엔 ZGC가 젤 좋은듯~!~! / CMS GC는 이론적으로만 보자. 사장되었음.