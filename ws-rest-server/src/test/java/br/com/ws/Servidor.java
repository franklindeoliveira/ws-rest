package br.com.ws;

import java.io.IOException;
import java.net.URI;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

/**
 * @author franklindeoliveira
 *
 */
public class Servidor {

	private static HttpServer server;

	public static void main(String[] args) throws IOException {
		iniciar();
		System.in.read();
	}

	public static void iniciar() {
		try {
			URI uri = URI.create("http://localhost:8080/");
			ResourceConfig config = new ResourceConfig().packages("br.com.ws");
			server = GrizzlyHttpServerFactory.createHttpServer(uri, config);
			server.start();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public static void parar() {
		server.stop();
	}
	
	public static boolean isIniciou() {
		return server.isStarted();
	}

}
