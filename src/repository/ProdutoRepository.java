package repository;

import java.util.List;

import javax.persistence.Query;

import model.Produto;

public class ProdutoRepository extends Repository<Produto> {

	public List<Produto> findByNome(String nome) {

		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT ");
		jpql.append("  a ");
		jpql.append("FROM ");
		jpql.append("  Produto a ");
		jpql.append("WHERE ");
		jpql.append("  upper(a.nome) like upper(:nome) ");

		Query query = getEntityManager().createQuery(jpql.toString());

		query.setParameter("nome", "%" + nome + "%");

		return query.getResultList();
	}

	public List<Produto> findProdutoEstoque() {

		StringBuffer sql = new StringBuffer();
		sql.append("SELECT ");
		sql.append("  p.id ");
		sql.append("FROM ");
		sql.append("  Produto p, ");
		sql.append("  Estoque e ");
		sql.append("WHERE ");
		sql.append("  p.id = e.idproduto ");

		Query query = getEntityManager().createNativeQuery(sql.toString());

		return query.getResultList();

	}

	public List<Produto> findByAll() {
		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT ");
		jpql.append("  a ");
		jpql.append("FROM ");
		jpql.append("  Produto a ");
		Query query = getEntityManager().createQuery(jpql.toString());
		return query.getResultList();
	}

}
