package repository;

import java.util.List;

import javax.persistence.Query;

import model.Estado;

public class EstadoRepository extends Repository<Estado> {

	public List<Estado> findByNome(String nome) {
		return findByNome(nome, null);
	}
	
	public List<Estado> findByNome(String nome, Integer maxResults) {

		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT ");
		jpql.append("  e ");
		jpql.append("FROM ");
		jpql.append("  Estado e ");
		jpql.append("WHERE ");
		jpql.append("  upper(e.nome) like upper(:nome) ");
		jpql.append("ORDER BY e.nome ");

		Query query = getEntityManager().createQuery(jpql.toString());
		query.setParameter("nome", "%" + nome + "%");
		if (maxResults != null && maxResults > 0 )
			query.setMaxResults(maxResults);

		return query.getResultList();
	}
	
}
