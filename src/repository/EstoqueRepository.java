package repository;

import java.util.List;

import javax.persistence.Query;

import model.Estoque;

public class EstoqueRepository extends Repository<Estoque> {

	public List<Estoque> findByNome(String nome) {

		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT ");
		jpql.append("  a ");
		jpql.append("FROM ");
		jpql.append("  Estoque a ");
		jpql.append("WHERE ");
		jpql.append("  upper(a.nome) like upper(:nome) ");

		Query query = getEntityManager().createQuery(jpql.toString());

		query.setParameter("nome", "%" + nome + "%");

		return query.getResultList();
	}

	public List<Estoque> findAll() {

		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT ");
		jpql.append("  a ");
		jpql.append("FROM ");
		jpql.append("  Estoque  a ");

		Query query = getEntityManager().createQuery(jpql.toString());

		return query.getResultList();
	}

	public List<Estoque> findProdutoEstoque() {

		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT ");
		jpql.append("  e ");
		jpql.append("FROM ");
		jpql.append("  Estoque e ");
		jpql.append("   JOIN FETCH e.produto ");
//		jpql.append("WHERE ");
//		jpql.append("  upper(e.idproduto) = upper(p.id) ");

		Query query = getEntityManager().createQuery(jpql.toString());

		return query.getResultList();
	}

}
