package repository;

import java.util.List;

import javax.persistence.Query;

import model.ServicoPrestado;

public class ServicoPrestadoRepository extends Repository<ServicoPrestado> {

	public List<ServicoPrestado> findByNome(String nome) {

		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT ");
		jpql.append("  a ");
		jpql.append("FROM ");
		jpql.append("  ServicoPrestado a ");
		jpql.append("WHERE ");
		jpql.append("  upper(a.nome) like upper(:nome) ");

		Query query = getEntityManager().createQuery(jpql.toString());

		query.setParameter("nome", "%" + nome + "%");

		return query.getResultList();
	}
}
