package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("===Test 1: department findById===");
		Department dep1 = departmentDao.findById(1);
		System.out.println(dep1);
		
		System.out.println("\n===Test 2: department findAll===");
		List<Department> list = new ArrayList<>();
		list = departmentDao.findAll();
		for (Department department : list) {
			System.out.println(department);
		}
		System.out.println("\n===Test 3: department insert===");
		//Department dep2 = new Department(null, "Cama e banho");
		//departmentDao.insert(dep2);
		//System.out.println(dep2.getName()+" inserted");
		
		System.out.println("\n===Test 4: department update===");
		Department dep3 = departmentDao.findById(7);
		dep3.setName("Alimentos");
		departmentDao.update(dep3);
		System.out.println("Update complete");
		
		System.out.println("\n===Test 5: department delete===");
		departmentDao.deleteById(6);
		System.out.println("Delete complete");
	}

}
