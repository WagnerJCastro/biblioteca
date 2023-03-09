package br.com.isidroteca.biblioteca.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.isidroteca.biblioteca.model.Livro;
import br.com.isidroteca.biblioteca.repo.LivroRepo;

@Component
public class LivroServiceImpl implements ILivroService{

	@Autowired
	private LivroRepo repo;
	
	@Override
	public ArrayList<Livro> recuperarTodos() {
		// TODO Auto-generated method stub
		return (ArrayList<Livro>)repo.findByOrderByTitulo();
	}

	@Override
	public Livro recuperarPeloId(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id).orElse(null);
	}

	@Override
	public ArrayList<Livro> recuperarPeloTitulo(String palavraChave) {
		// TODO Auto-generated method stub
		return repo.findByTituloContaining(palavraChave);
	}

	@Override
	public Livro adicionarLivro(Livro novo) {
		// TODO Auto-generated method stub
		return repo.save(novo);
	}

	@Override
	public boolean removerLivro(int id) {
		// TODO Auto-generated method stub
		if(repo.existsById(id)) {
			repo.deleteById(id);
			return true;
		}
		return false;
	}

	
	
}
