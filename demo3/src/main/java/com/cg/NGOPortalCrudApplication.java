package com.cg;

import java.util.List;
import java.util.logging.Logger;


import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cg.dao.AddressDao;
import com.cg.dao.AdminDao;
import com.cg.dao.DonorDao;
import com.cg.dao.EmployeeDao;
import com.cg.dao.NeedyPeopleDao;
import com.cg.model.Address;
import com.cg.model.Admin;
import com.cg.model.Donor;
import com.cg.model.Employee;
import com.cg.model.NeedyPeople;

@SpringBootApplication

public class NGOPortalCrudApplication implements CommandLineRunner {
	
	 @Autowired 
	 AdminDao adminDao;
	@Autowired
	DonorDao donorDao;
	@Autowired
	EmployeeDao employeeDao;
	@Autowired
	NeedyPeopleDao needyPeopleDao;
	@Autowired 
	AddressDao addressDao;
	public static void main(String[] args) {
			SpringApplication.run(NGOPortalCrudApplication.class, args);
		}

	public void run(String... args) throws Exception{
		//System.out.println("Values getting inserted");
		Admin a=new Admin();
		
		a.setAdminId(1001);
		a.setAdminUsername("Lavanya");
		a.setAdminPassword("root");
		//System.out.println("values inserted");
		Admin a1=new Admin();
		a1.setAdminId(1002);
		a1.setAdminUsername("Akanksha");
		a1.setAdminPassword("Bhaiyya");
		adminDao.save(a);
		adminDao.save(a1);
		
		Address ad=new Address();
		ad.setAddressId(101);
		ad.setCity("Hyderabad");
		ad.setLandmark("GVK");
		ad.setPin("5091008");
		ad.setState("Telangana");
		addressDao.save(ad);
		
		Address ad1=new Address();
		ad1.setAddressId(102);
		ad1.setCity("Kurnool");
		ad1.setLandmark("N.R.Pet");
		ad1.setPin("645749");
		ad1.setState("AndhraPradesh");
		addressDao.save(ad1);
		
		Donor d=new Donor();
		d.setDonorId(1);
		d.setDonorName("Shaheen");
		d.setDonorUsername("Shaheen Sheik");
		d.setDonorEmail("ShaheenSheik@gmail.com");
		d.setDonorPassword("sheik");
		d.setDonorPhone("7013579142");
		d.setAddress(ad);
		donorDao.save(d);
		
		Donor d1=new Donor();
		d1.setDonorId(2);
		d1.setDonorName("Srija");
		d1.setDonorUsername("Srija Somavarapu");
		d1.setDonorEmail("srisrija@gmail.com");
		d1.setDonorPassword("siri");
		d1.setDonorPhone("7013579145");
		d1.setAddress(ad1);
		donorDao.save(d1);
		
		Employee emp=new Employee();
		emp.setAddress(ad);
		emp.setEmail("lavanya@gmail.com");
		emp.setEmployeeId(501);
		emp.setEmployeeName("Lavanya Pyatla");
		emp.setUsername("lavanya");
		emp.setPhone("9581942330");
		emp.setPassword("pyatla");
	
		employeeDao.save(emp);
		
		Employee emp1=new Employee();
		emp1.setAddress(ad1);
		emp1.setEmail("hema@gmail.com");
		emp1.setEmployeeId(502);
		emp1.setEmployeeName("Hema Reddy");
		emp1.setUsername("Hema");
		emp1.setPhone("8498939728");
		emp1.setPassword("siddu");
		employeeDao.save(emp1);
		
		NeedyPeople np=new NeedyPeople();
		np.setFamilyIncome(15000);
		np.setNeedyPersonId(201);
		np.setNeedyPersonName("Anil");
		np.setPhone("9885726295");
		np.setAddress(ad1);
		needyPeopleDao.save(np);
		
		
		  Admin adm=adminDao.findById(((int) 1001)).get(); 
		  System.out.println(adm);
		 
		
		Donor don=donorDao.findById((int) 1).get();
		System.out.println(don);
		
		Address add=addressDao.findById(101).get();
		System.out.println(add);
		
		adminDao.deleteById(1002);
		
		List<Employee> employee=employeeDao.findAll();
		System.out.println(employee);
		
		Employee ep=employeeDao.findById(501).get();
		ep.setUsername("Siri");
		employeeDao.save(ep);
	}
		
	
}
