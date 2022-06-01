package br.com.jkControl.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.jkControl.model.Visitor;


public class VisitorDao {


	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("jkControl-persistence-unit");
	private EntityManager manager = factory.createEntityManager();
	
	public void create(Visitor visitor) {
		
		manager.getTransaction().begin();
		manager.persist(visitor);
		manager.getTransaction().commit();
		
		manager.clear();
	}
	
	public List<Visitor> listAll(){
		TypedQuery<Visitor> query = 
				manager.createQuery("select v from Visitor v", Visitor.class);
		
		return query.getResultList();
	}
}
