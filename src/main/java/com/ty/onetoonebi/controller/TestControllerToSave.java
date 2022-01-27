package com.ty.onetoonebi.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.onetoonebi.dto.Invoice;
import com.ty.onetoonebi.dto.Item;


public class TestControllerToSave {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("dev");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Item item = new Item();
		item.setId(2);
		item.setName("BOOK");
		item.setPrice(100);
		item.setQuantity(2);
		
		Invoice invoice = new Invoice();
		invoice.setId(20);
		invoice.setName("Book invoice");
		invoice.setBillingAddress("BLR JSP");
		invoice.setGstNumber("9776bk");
		invoice.setTax(18.32);
		invoice.setItem(item);
		
		entityTransaction.begin();
		entityManager.persist(item);
		entityManager.persist(invoice);
		entityTransaction.commit();
	}

}
