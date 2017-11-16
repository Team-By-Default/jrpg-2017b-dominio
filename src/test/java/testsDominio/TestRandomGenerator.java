package testsDominio;

import org.junit.Assert;
import org.junit.Test;

import dominio.RandomGenerator;

public class TestRandomGenerator {

	@Test
	public void test() {
		RandomGenerator ran = new RandomGenerator();
		Assert.assertEquals(0, ran.nextInt(3));
		Assert.assertEquals(0, ran.nextDouble(),0);
	}

}
