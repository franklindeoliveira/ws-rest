package br.com.ws;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ServidorTest {

	@Before
	public void before() {
		Servidor.iniciar();
	}

	@After
	public void after() {
		Servidor.parar();
	}

	@Test
	public void testaQueServidorIniciou() {
		Assert.assertTrue(Servidor.isIniciou());
	}
}
