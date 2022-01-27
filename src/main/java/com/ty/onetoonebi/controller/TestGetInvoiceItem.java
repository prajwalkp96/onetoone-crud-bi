package com.ty.onetoonebi.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.onetoonebi.dto.Invoice;
import com.ty.onetoonebi.dto.Item;

public class TestGetInvoiceItem {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("dev");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		 Invoice invoice = entityManager.find(Invoice.class,10);
		 System.out.println("ID is : "+invoice.getId());
		 System.out.println("Name is : "+invoice.getName());
		 System.out.println("Billing Address is : "+invoice.getBillingAddress());
		 System.out.println("GST Number is : "+invoice.getGstNumber());
		 System.out.println("Tax is : "+invoice.getTax());
		 Item item = invoice.getItem();
		 System.out.println("----------------------------------------------------------");
		 System.out.println("ID is :"+item.getId());
		 System.out.println("Name is :"+item.getName());
		 System.out.println("price is :"+item.getPrice());
		 System.out.println("Quantity is :"+item.getQuantity());
	}

}
