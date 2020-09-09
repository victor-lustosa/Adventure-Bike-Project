package repository;

import java.util.List;

import javax.persistence.Query;

import model.Cidade;

public class CidadeRepository extends Repository<Cidade> {

	public List<Cidade> findByNome(String nome) {

		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT ");
		jpql.append("  c ");
		jpql.append("FROM ");
		jpql.append("  Cidade c ");
		jpql.append("WHERE ");
		jpql.append("  upper(c.nome) like upper(:nome) ");

		Query query = getEntityManager().createQuery(jpql.toString());

		query.setParameter("nome", "%" + nome + "%");

		return query.getResultList();
	}
	
	public List<Cidade> findByNome(String nome, Integer idEstado) {

		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT ");
		jpql.append("  c ");
		jpql.append("FROM ");
		jpql.append("  Cidade c ");
		jpql.append("WHERE ");
		jpql.append("  c.estado.id = :idEstado ");
		jpql.append("  AND upper(c.nome) like upper(:nome) ");

		Query query = getEntityManager().createQuery(jpql.toString());

		query.setParameter("idEstado", idEstado);
		query.setParameter("nome", "%" + nome + "%");

		return query.getResultList();
	}	
	
	public List<Object> findByNomeSql(String nome) {

		StringBuffer sql = new StringBuffer();
		sql.append("SELECT ");
		sql.append("  c.id, c.nome, c.sigla ");
		sql.append("FROM ");
		sql.append("  Cidade c ");
		sql.append("WHERE ");
		sql.append("  upper(c.nome) like upper(?1) ");

		Query query = getEntityManager().createNativeQuery(sql.toString());

		query.setParameter(1, "%" + nome + "%");

		return query.getResultList();
	}	

}
