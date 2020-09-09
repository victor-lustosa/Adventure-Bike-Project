package repository;

import java.util.List;

import javax.persistence.Query;

import model.Bicicleta;
import model.Produto;

public class BoletoRepository extends Repository<Produto> {

	public List<Bicicleta> findByNome(String nome) {

		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT ");
		jpql.append("  a ");
		jpql.append("FROM ");
		jpql.append("  Boleto a ");
		jpql.append("WHERE ");
		jpql.append("  upper(a.nome) like upper(:nome) ");

		Query query = getEntityManager().createQuery(jpql.toString());

		query.setParameter("nome", "%" + nome + "%");

		return query.getResultList();
	}
}
