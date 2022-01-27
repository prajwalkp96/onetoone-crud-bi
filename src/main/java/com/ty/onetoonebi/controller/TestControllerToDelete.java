package com.ty.onetoonebi.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.onetoonebi.dto.Invoice;

public class TestControllerToDelete {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("dev");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		Invoice invoice = entityManager.find(Invoice.class, 10);
		if (invoice != null) {
			entityManager.remove(invoice);
			entityTransaction.commit();
			System.out.println("Deleted");
		}
		else {
			System.out.println("No Data to delete");
		}
	}
}
