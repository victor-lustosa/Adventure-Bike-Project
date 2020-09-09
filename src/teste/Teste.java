package teste;

import java.util.List;

import model.Estoque;
import model.Produto;
import repository.EstoqueRepository;
import repository.ProdutoRepository;

public class Teste {

	public static void main(String[] args) {
		ProdutoRepository produto = new ProdutoRepository();
		EstoqueRepository repo = new EstoqueRepository();
		List<Produto> produtoLista = null;
		List<Estoque> estoqueLista = null;
		produtoLista = produto.findProdutoEstoque();
//		int i = 0;
//		for (Produto produto2 : produtoLista) {
//			System.out.println(produtoLista.get(i).toString());
//			i = i++;
//		}
//		estoqueLista = repo.findProdutoEstoque();
//		System.out.println(estoqueLista.toString());
		System.out.println(produtoLista);
		
		for (int i = 0; i < produtoLista.size(); i++) {
			System.out.println(produtoLista.get(i));

		}
		
	}

}
