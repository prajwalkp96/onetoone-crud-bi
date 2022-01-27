package com.ty.onetoonebi.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.onetoonebi.dto.Invoice;
import com.ty.onetoonebi.dto.Item;

public class TestControllerToUpdate {

	public static void main(String[] args) {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("dev");
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			EntityTransaction entityTransaction = entityManager.getTransaction();

		
			Invoice invoice = entityManager.find(Invoice.class, 20);
			Item item = invoice.getItem();
			item.setId(2);
			item.setName("PEN");
			item.setPrice(50);
			item.setQuantity(8);
			
			invoice.setId(20);
			invoice.setName("Pen invoice");
			invoice.setBillingAddress("BLR QSP");
			invoice.setGstNumber("6354pn");
			invoice.setTax(18.32);
			invoice.setItem(item);
			entityTransaction.begin();
			entityManager.merge(invoice);
			entityTransaction.commit();
	}

}
