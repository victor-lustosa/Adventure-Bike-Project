package repository;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.Query;

import model.Usuario;

public class UsuarioRepository extends Repository<Usuario> {

	public List<Usuario> findByNome(String nome) {

		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT ");
		jpql.append("  a ");
		jpql.append("FROM ");
		jpql.append("  Usuario a ");
		jpql.append("WHERE ");
		jpql.append("  upper(a.nome) like upper(:nome) ");

		Query query = getEntityManager().createQuery(jpql.toString());

		query.setParameter("nome", "%" + nome + "%");

		return query.getResultList();
	}

	public boolean contains(Integer id, String email) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT ");
		sql.append("  count(*) ");
		sql.append("FROM ");
		sql.append("  Usuario u ");
		sql.append("WHERE ");
		sql.append("  upper(u.email) = upper(?) ");
		sql.append("  AND u.id <> ? ");
		
		Query query = getEntityManager().createNativeQuery(sql.toString());

		query.setParameter(1, email);
		query.setParameter(2, id == null ? -1 : id);
		
		BigInteger resultado = (BigInteger) query.getSingleResult();
		
		return (resultado == null || resultado.equals(BigInteger.ZERO)) ? false : true;
	}

	public boolean containsCpf(Integer id, String cpf) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT ");
		sql.append("  count(*) ");
		sql.append("FROM ");
		sql.append("  Usuario u ");
		sql.append("WHERE ");
		sql.append("  upper(u.cpf) = upper(?) ");
		sql.append("  AND u.id <> ? ");
		
		Query query = getEntityManager().createNativeQuery(sql.toString());

		query.setParameter(1, cpf);
		query.setParameter(2, id == null ? -1 : id);
		
		BigInteger resultado = (BigInteger) query.getSingleResult();
		
		return (resultado == null || resultado.equals(BigInteger.ZERO)) ? false : true;
	}

	public Usuario verificarLoginSenha(String email, String senha) {
		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT ");
		jpql.append(" 	u ");
		jpql.append("FROM ");
		jpql.append("	Usuario u ");
		jpql.append("WHERE ");
		jpql.append("	u.email = :email ");
		jpql.append("	AND u.senha = :senha ");

		Query query = getEntityManager().createQuery(jpql.toString());

		query.setParameter("email", email);
		query.setParameter("senha", senha);

		try {
			return (Usuario) query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
}
