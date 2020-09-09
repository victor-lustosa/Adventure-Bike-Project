package repository;

import java.util.List;

import javax.persistence.Query;

import model.ItemPedido;
import model.Pedido;

public class ItemPedidoRepository extends Repository<ItemPedido> {

	public List<ItemPedido> findByPedido(Pedido pedido) {

		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT ");
		jpql.append("  a ");
		jpql.append("FROM ");
		jpql.append("  ItemPedido a, ");
		jpql.append("  Produto p ");
		jpql.append("WHERE ");
		jpql.append(" a.id = p.id ");

		Query query = getEntityManager().createQuery(jpql.toString());

		return query.getResultList();
	}
}