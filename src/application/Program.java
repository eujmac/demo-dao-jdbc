package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		SellerDao sellerDao = DaoFactory.createSellerDao();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("===Test 1: seller findById===");
		Seller seller = sellerDao.findById(2);
		System.out.println(seller);
		
		System.out.println("\n===Test 2: seller findByDepartment===");
		Department department = new Department(1,null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for (Seller s : list) {
			System.out.println(s);
		}
		
		System.out.println("\n===Test 3: seller findByAll===");
		list = sellerDao.findAll();
		for (Seller s : list) {
			System.out.println(s);
		}
		
		System.out.println("\n===Test 4: seller insert===");
		Seller newSeller = new Seller(null, "gred", "greg@gmail.com", new Date(), 4000.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted new id = "+newSeller.getId());
		
		System.out.println("\n===Test 5: seller update===");
		seller = sellerDao.findById(1);
		seller.setName("Martha waine");
		sellerDao.update(seller);
		System.out.println("Update complete");
		
		System.out.println("\n===Test 6: seller delete===");
		System.out.println("enter id for delete test: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Delete complete");
	
	}

}
