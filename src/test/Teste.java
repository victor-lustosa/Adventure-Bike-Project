package test;

import javax.persistence.EntityManager;

import factory.JPAFactory;

public class Teste {
	public static void main(String[] args) {

		
		EntityManager em = JPAFactory.getEntityManager();
		em.getTransaction().begin();
		
//		em.persist(cidade);
		em.getTransaction().commit();
		System.out.println("Feito.");
		
	}
}
