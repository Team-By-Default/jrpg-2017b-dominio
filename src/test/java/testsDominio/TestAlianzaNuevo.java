package testsDominio;

import org.junit.Assert;
import org.junit.Test;

import dominio.Alianza;

public class TestAlianzaNuevo {

	
	@Test
	public void testGetNombre() {
		Alianza ali = new Alianza("Los Isotopos");
		Assert.assertEquals("Los Isotopos", ali.obtenerNombre());
	}
		

}
