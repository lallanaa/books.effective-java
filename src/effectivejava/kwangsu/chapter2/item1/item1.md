# 정적팩토리

### 클래스를 공개하지 않는다는게 무슨 의미인지?

- 공개는 접근제어자(public, protected,....) 로 객체 생성과 상속하여 재구현 가능하냐 또는 우리가 소스 개발 하면서 해당 클래스 접근이 가능하냐를 공개냐 비공개냐로 이해하면 된다.
- package-private 레벨 클래스나 private 메소드는 IDE에서 찿아 주지 않아서 보이지 않는데 이걸로 공개냐 아니냐로 봐도 될것 같다.
- 글에 보시다 시피 Collections 안에는 내부 클래스로 45개의 클래스가 있는데 **전부 package-private 레벨로 해당 패키지내가 아니라면 클래스를 생성 할수도 접근도 못한다.** 그래서
  Collections에서 대신 만들어서 해당 객체를 리턴 해주고 있다.

```java
    public static<T> List<T> unmodifiableList(List<?extends T> list){
        return(list instanceof RandomAccess?
        new UnmodifiableRandomAccessList<>(list):
        new UnmodifiableList<>(list));
        }

/**
 * @serial include
 */
static class UnmodifiableList<E> extends UnmodifiableCollection<E>
        implements List<E> {
    private static final long serialVersionUID = -283967356065247728L;

    final List<? extends E> list;

    UnmodifiableList(List<? extends E> list) {
        super(list);
        this.list = list;
    }
```

![Untitled](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/2ea844d3-9438-4ac4-9855-dd6a0840a0c3/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220325%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220325T085707Z&X-Amz-Expires=86400&X-Amz-Signature=b05be200a11be8ea41c20b1f32eedf002220c7a7933ff9940ebffc2055667453&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject)

### 클래스를 공개하지 않음으로써 api를 작게 유지할 수 있다고 얘기하는 것 같은데?

![Untitled](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/60a576d2-3445-411d-9ac6-b0c0fcb24e41/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220325%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220325T085727Z&X-Amz-Expires=86400&X-Amz-Signature=0b317f26c84e425e6a4ef244a8c77ea2d5b080e54f6063659d2ec2955320cca6&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject)

- 여기서 Collections를 얘기하는게 아니라 **“컬렉션 프레임워크”**를 얘기 하고 있다.
- 컬렉션 프레임 워크는 Collection 인터페이스를 구현한 모든 클래스를 가리킨다. (List,Set,Map.....)
- API가 작아졌다는 말은 45개의 클래스를 공개 했으면 45개의 클래스에 대해 어떻게 생성하고 어떻게 사용 해야 되고 상속을 받아서 어떻게 또 구현 해야 되나 이런 고민을 했을텐데 공개 하지 않고
  Collections 내부에 45개를 숨기고 사용자는 그냥 가져다 씀으로 쉬워졌다는 얘기다.

### 인스턴스 화처럼 객체를 직접적으로 다루는 부분이 말 그대로 내부로 들어가지 않는 이상 안 보인다는 의미인 건지?

- Collections 객체를 생성하지 못하도록 private 생성자를 만들고, 이건 생성하지 말고 상속도 받지말고 그냥 써라라고 알려줌
- public 생성자로 했으면 상속 받아서 쓰고 생성해서 쓰고 이상하게 가져다 쓰는 사람이 있을 수 있는데 그렇게 쓰면 원래 Collections 만든 취지에 어긋나 버리기 때문에 이건 private 이라고 선언
  해서 막음

### 동반 클래스가 무슨 말일까 이너 클래스 말하는 걸까 ? 검색했더니 kotlin에 동반 객체 이런게 나왔음

- 대충봐도 책에서 말한거랑 kotlin에서의 동반이랑 다름
- Collection의 동반 클래스는 Collections인데 Collection과 관련된 유틸성 메소드를 모아놈
    - 그래서 저는 List, Set, Map 과 관련된 정렬이라던지 합치기라던지 필요 할때 Collections. 찍고 어떤 메소드들이 있는지 살펴봄
    - 배열도 마찬가지 배열 합치기 복사, List로 만들기 필요할땐 Arrays. 찍고 메소드 살펴봄

### 정적 팩토리 클래스를 사용하면 얻어 온 객체를 해당 클래스가 아닌 인터페이스로 다루게 된다는 것도 무슨 의미인지?

- 돈에 대한 인터페이스를 만들고 돈을 구현한 객체는 달러, 원화, 등등 있다고 했을때

       Dollor d = Money.of(MoneyType.USD, 1000); 이렇게 받을수 있겠지만

      Money d = Money.of(MoneyType.USD, 1000); 이렇게도 받을수 있다.

```java
public interface Money {

    long getAmount();

    //java 8부터 정적 메소드 정의 가능
    public static Money of(MoneyType type, long amount) {
        if (MoneyType.DOLLAR == type) {
            return new Dollar(amount);
        }
        if (MoneyType.WON == type) {
            return new Won(amount);
        }
        throw new IllegalArgumentException();
    }
}

```

```java
public class Dollar implements Money {

  long amount;

  public Dollar(long amount) {
    this.amount = amount;
  }

  @Override
  public long getAmount() {
    return amount;
  }
}
```

```java
public class Won implements Money {

    long amount;

    public Won(long amount) {
        this.amount = amount;
    }

    @Override
    public long getAmount() {
        return amount;
    }
}
```

```java
class MoneyTest {
    @Test
    void test() {
        //인터페이스로 리턴받음
        Money d = Money.of(MoneyType.DOLLAR, 100);
        assertThat(d)
                .isInstanceOf(Dollar.class);

        //인터페이스로 리턴받음
        Money w = Money.of(MoneyType.WON, 100);
        assertThat(w)
                .isInstanceOf(Won.class);

        //인터페이스로 리턴받아서 메소드 하나로 처리 가능
        same(d, 100);
        same(w, 100);
    }

    //인터페이스로 받아서 처리
    boolean same(Money d, long b) {
        return d.getAmount() == b;
    }
}
```