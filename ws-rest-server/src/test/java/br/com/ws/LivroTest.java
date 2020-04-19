package br.com.ws;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.filter.LoggingFilter;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.ws.modelo.Livro;

public class LivroTest {

	private static String TARGET = "http://localhost:8080";
	private Client client;

	@Before
	public void before() {
		Servidor.iniciar();
		this.client = getClientConfig();
	}

	@After
	public void after() {
		Servidor.parar();
	}

	public Client getClientConfig() {
		ClientConfig config = new ClientConfig();
		config.register(new LoggingFilter());
		Client client = ClientBuilder.newClient(config);
		return client;
	}
	
	@Test
	public void testaAdicionaLivro() {
		WebTarget target = client.target(TARGET);
		Livro livro = new Livro("Titulo", "Assunto", "Autor");
		Entity<Livro> entity = Entity.entity(livro, MediaType.APPLICATION_XML);

		Response response = target.path("/livros").request().post(entity);
		Assert.assertEquals(201, response.getStatus());
	}

	@Test
	public void testaBuscaLivro() {
		WebTarget target = client.target(TARGET);
		Livro livro = target.path("/livros/1").request().get(Livro.class);
		Assert.assertTrue(livro.getTitulo().contains("Titulo 1"));
	}
	
	@Test
	public void testaAtualizaLivro() {
		WebTarget target = client.target(TARGET);
		Livro livro = new Livro("Titulo atualizado", "Assunto", "Autor");
		Entity<Livro> entity = Entity.entity(livro, MediaType.APPLICATION_XML);

		Response response = target.path("/livros/2").request().put(entity);
		Assert.assertEquals(200, response.getStatus());
	}
	
	@Test
	public void testaRemoveLivro() {
		WebTarget target = client.target(TARGET);
		Response response = target.path("/livros/2").request().delete();
		Assert.assertEquals(200, response.getStatus());
	}

}
