package repository;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.Query;

import model.Fornecedor;

public class FornecedorRepository extends Repository<Fornecedor> {
	public List<Fornecedor> findByNome(String nome) {

		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT ");
		jpql.append("  a ");
		jpql.append("FROM ");
		jpql.append("  Fornecedor a ");
		jpql.append("WHERE ");
		jpql.append("  upper(a.nome) like upper(:nome) ");

		Query query = getEntityManager().createQuery(jpql.toString());

		query.setParameter("nome", "%" + nome + "%");

		return query.getResultList();
	}

	public boolean containsCnpj(Integer id, String cnpj) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT ");
		sql.append("  count(*) ");
		sql.append("FROM ");
		sql.append("  Fornecedor f ");
		sql.append("WHERE ");
		sql.append("  upper(f.cnpj) = upper(?) ");
		sql.append("  AND f.id <> ? ");

		Query query = getEntityManager().createNativeQuery(sql.toString());

		query.setParameter(1, cnpj);
		query.setParameter(2, id == null ? -1 : id);

		BigInteger resultado = (BigInteger) query.getSingleResult();

		return (resultado == null || resultado.equals(BigInteger.ZERO)) ? false : true;
	}

}
