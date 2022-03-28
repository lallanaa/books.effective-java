import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class TestClass {
	String strA = "Hello World";
	String strB = new String("Hello World");
	String strC = "Hello World";

	@Test
	public void strTest(){
		//isSame 주소값 비교
		assertThat(strA).isNotSameAs(strB); //ok
	}

	@Test
	public void strTest2(){
		assertThat(strA).isSameAs(strC); //ok
	}

	@Test
	public void strTest3(){
		assertThat(strA).isEqualTo(strB);
	}

	@Test
	public void strTest4(){
		assertThat(strA).isEqualTo(strC);
	}

	@Test
	void name() {
		//given
		assertThat(strA.hashCode()).isEqualTo(strB.hashCode());

		//when

		//then
	}
}
