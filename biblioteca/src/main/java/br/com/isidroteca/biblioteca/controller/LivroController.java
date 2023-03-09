package br.com.isidroteca.biblioteca.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.isidroteca.biblioteca.dto.MensagemErro;
import br.com.isidroteca.biblioteca.model.Livro;
import br.com.isidroteca.biblioteca.services.ILivroService;

@RestController
public class LivroController {

	@Autowired
	private ILivroService service;

	@GetMapping("/livros")
	public ArrayList<Livro> recuperarTodos() {
		return service.recuperarTodos();
	}

	@GetMapping("/livros/{id}")
	public ResponseEntity<?> recuperarPorID(@PathVariable int id) {
		Livro l = service.recuperarPeloId(id);
		if (l != null) {
			return ResponseEntity.ok(l);
		}
		return ResponseEntity.status(404).body(new MensagemErro(1,"Não existe livro na bibliteca com esse ID!"));
	}

	@GetMapping("/livros/busca")
	public ResponseEntity<?> buscarPorNome(@RequestParam(name = "palavra") String palavra) {
		ArrayList<Livro> lista = service.recuperarPeloTitulo(palavra);
		if (lista.size() > 0) {
			return ResponseEntity.ok(lista);
		}
		return ResponseEntity.status(404).body(new MensagemErro(1,"Não existe livro na biblioteca que contenha esse titulo!"));

	}
	
	@PostMapping("/livros")
	public ResponseEntity<?> adicionarLivro(@RequestBody Livro l) {
		Livro res = service.adicionarLivro(l);
		if (res != null) {
			return ResponseEntity.status(201).body(res);
		}
		return ResponseEntity.badRequest().body(new MensagemErro(2,"Dados inseridos invalidos!"));
	}

	@DeleteMapping("/livros/{id}")
	public ResponseEntity<?> removerLivro(@PathVariable int id) {
		if(service.removerLivro(id)) {
			return ResponseEntity.ok(null);
		}
	return ResponseEntity.status(404).body(new MensagemErro(1,"O livro a ser excluido não existe na biblioteca!"));
	}
	
}
