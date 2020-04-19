package br.com.ws.resources;

import java.net.URI;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.ws.dao.LivroDao;
import br.com.ws.modelo.Livro;

@Path("/livros")
public class LivroResource {
	
	@GET
	@Path("/{id}")
    @Produces(MediaType.APPLICATION_XML)
	public Livro busca(@PathParam("id") long id) {
		return new LivroDao().busca(id);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	public Response adiciona(Livro livro) {
        new LivroDao().adiciona(livro);
        URI uri = URI.create("/livros/" + livro.getId());
		return Response.created(uri).build();
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_XML)
	public Response atualiza(@PathParam("id") long id, Livro livro) {
		new LivroDao().atualiza(id, livro);
		return Response.ok().build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response remove(@PathParam("id") long id) {
		new LivroDao().remove(id);
		return Response.ok().build();
	}
	
}
