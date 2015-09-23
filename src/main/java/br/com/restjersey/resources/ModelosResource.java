package br.com.restjersey.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.restjersey.models.Modelo;

@Path("/modelos")
public class ModelosResource {
	
	private static List<Modelo> modelos = new ArrayList<Modelo>(Arrays.asList(
			new Modelo(1, "Atributo 1"), 
			new Modelo(2, "Atributo 2"),
			new Modelo(3, "Atributo 3")));
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<Modelo> getModelos() {
		return modelos;
	}
	
	@GET @Path("/{id}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Modelo getModelo(@PathParam("id") Integer id) {
		return modelos.get(id - 1);
	}
	
	@POST
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<Modelo> addModelos(List<Modelo> modelos) {
		ModelosResource.modelos.addAll(modelos);
		return ModelosResource.modelos;
	}
	
	@PUT @Path("/{id}")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Modelo atualizaModelo(@PathParam("id") Integer id, Modelo modelo) {
		modelos.get(modelos.indexOf(getModelo(id))).setAtributo(modelo.getAtributo());;
		return getModelo(id);
	}
	
	@DELETE
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<Modelo> deleteModelos() {
		modelos.clear();
		return modelos;
	}
	
	@DELETE @Path("/{id}")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<Modelo> deleteModelo(@PathParam("id") Integer id) {
		modelos.remove(id - 1);
		return modelos;
	}

}