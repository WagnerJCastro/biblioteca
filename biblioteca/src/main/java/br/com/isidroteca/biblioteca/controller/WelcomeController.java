package br.com.isidroteca.biblioteca.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

	@GetMapping("/")
	public String sayWelcome() {
		return "<pre>"
				+ "Bem vindo a API de livros<br/>"
				+ "Endpoints Disponiveis<br/>"
				+ "/livros (GET) - para recuperar tudo<br/>"
				+ "/livros/id (GET) - para recuperar detalhes de um unico livro pelo id<br/>"
				+ "/livros/busca?palavra= (GET) - para recuperar livros por palavra chave<br/>"
				+ "/livros (POST) - para adicionar livro<br/>"
				+ "/livros/id (DELETE) - para deletar livro por id<br/>";
	}
}
