package br.com.isidroteca.biblioteca.repo;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import br.com.isidroteca.biblioteca.model.Livro;

public interface LivroRepo extends CrudRepository<Livro, Integer>{

	public ArrayList<Livro> findByTituloContaining(String nome);
	
	public ArrayList<Livro> findByOrderByTitulo();
}
