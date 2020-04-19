package br.com.ws;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.filter.LoggingFilter;

//import org.glassfish.jersey.client.ClientConfig;
//import org.glassfish.jersey.filter.LoggingFilter;

import br.com.ws.modelo.Livro;

public class GerenciaLivros 
{
    public static void main( String[] args )
    {
    	ClientConfig config = new ClientConfig();
		config.register(new LoggingFilter());
		Client client = ClientBuilder.newClient(config);
    	WebTarget target = client.target("http://localhost:8080");
    	
		Livro livro = target.path("/livros/1").request().get(Livro.class);
		
		System.out.println(livro.getTitulo());
    }
}
