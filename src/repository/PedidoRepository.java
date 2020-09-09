package repository;

import java.util.List;

import javax.persistence.Query;

import model.Pedido;

public class PedidoRepository extends Repository<Pedido> {

	public List<Pedido> findByUsuario(int idUsuario) {

		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT ");
		jpql.append("  a ");
		jpql.append("FROM ");
		jpql.append("  Pedido a, ");
		jpql.append("  Usuario u ");
		jpql.append("WHERE ");
		jpql.append(" a.id = u.id ");

		Query query = getEntityManager().createQuery(jpql.toString());

		return query.getResultList();
	}
}
