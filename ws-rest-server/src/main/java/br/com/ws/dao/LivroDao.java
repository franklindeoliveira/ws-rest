package br.com.ws.dao;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import br.com.ws.modelo.Livro;

public class LivroDao {
	
	private static Map<Long, Livro> banco = new HashMap<Long, Livro>();
	private static AtomicLong contador = new AtomicLong();
	
	static {
		Livro livro1 = new Livro("Titulo 1", "Assunto 1", "Autor 1");
		livro1.setId(contador.incrementAndGet());
		Livro livro2 = new Livro("Titulo 2", "Assunto 2", "Autor 2");
		livro2.setId(contador.incrementAndGet());
		Livro livro3 = new Livro("Titulo 3", "Assunto 3", "Autor 3");
		livro3.setId(contador.incrementAndGet());
		banco.put(1l, livro1);
		banco.put(2l, livro2);
		banco.put(3l, livro3);
	}
	
	public void adiciona(Livro livro) {
		long id = contador.incrementAndGet();
		livro.setId(id);
		banco.put(id, livro);
	}
	
	public Livro busca(long id) {
		return banco.get(id);
	}
	
	public Livro remove(long id) {
		return banco.remove(id);
	}
	
	public Livro atualiza(long id, Livro livro) {
		Livro livroBanco = this.busca(id);
		livroBanco.setTitulo(livro.getTitulo());
		livroBanco.setAssunto(livro.getAssunto());
		livroBanco.setAutor(livro.getAutor());
		return livroBanco;
	}
}
