package br.com.isidroteca.biblioteca.services;

import java.util.ArrayList;

import br.com.isidroteca.biblioteca.model.Livro;

public interface ILivroService {

	public ArrayList<Livro> recuperarTodos();
	public Livro recuperarPeloId(int id);
	public ArrayList<Livro> recuperarPeloTitulo(String palavraChave);
	public Livro adicionarLivro(Livro novo);
	public boolean removerLivro(int id);
}
