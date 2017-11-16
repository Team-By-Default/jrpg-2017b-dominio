package testsDominio;

import org.junit.Assert;
import org.junit.Test;

import dominio.MyRandomStub;
import dominio.RandomGenerator;

public class TestRandomStub {

	@Test
	public void test() {
		RandomGenerator ran = new MyRandomStub(3,2);
		Assert.assertEquals(2, ran.nextInt(3));
		Assert.assertEquals(3, ran.nextDouble(),0);
	}

}
