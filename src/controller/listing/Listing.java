package controller.listing;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.primefaces.PrimeFaces;

import application.Session;
import factory.JPAFactory;
import model.DefaultEntity;;

public abstract class Listing<T extends DefaultEntity<T>> implements Serializable {


	private static final long serialVersionUID = 8821446832823365046L;
	private Class<T> clazz = null;

	public Listing(Class<T> clazz) {
		this.clazz = clazz;
	}

	public void select(int id) {
		EntityManager em = JPAFactory.getEntityManager();
		T entity = (T) em.find(clazz, id);
		PrimeFaces.current().dialog().closeDynamic(entity);
	}

	protected void addObjectSession(String key, Object value) {
		Session.getInstance().setAttribute(key, value);
	}

	protected Object getObjectSession(String key) {
		return Session.getInstance().getAttributeAndRemove(key);
	}

}
