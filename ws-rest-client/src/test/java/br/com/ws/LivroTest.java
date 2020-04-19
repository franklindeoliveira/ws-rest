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

public class LivroTest {

	private static String TARGET = "http://localhost:8080";
	private Client client;

	@Before
	public void before() {
		this.client = getClientConfig();
	}

	@After
	public void after() {
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
		String livro = "<livro><titulo>Novo livro</titulo><assunto>Novo livro</assunto><autor>Novo livro</autor></livro>";
		Entity<String> entity = Entity.entity(livro, MediaType.APPLICATION_XML);

		Response response = target.path("/livros").request().post(entity);
		Assert.assertEquals(201, response.getStatus());
	}

	@Test
	public void testaBuscaLivro() {
		WebTarget target = client.target(TARGET);
		String livro = target.path("/livros/1").request().get(String.class);
		Assert.assertTrue(livro.contains("Titulo 1"));
	}
	
	@Test
	public void testaAtualizaLivro() {
		WebTarget target = client.target(TARGET);
		String livro = "<livro><titulo>Titulo atualizado</titulo><assunto>Assunto</assunto><autor>Autor</autor></livro>";
		Entity<String> entity = Entity.entity(livro, MediaType.APPLICATION_XML);

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
