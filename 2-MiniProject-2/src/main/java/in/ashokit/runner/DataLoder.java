package in.ashokit.runner;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import in.ashokit.entity.CitizenPlan;
import in.ashokit.repo.CitizenPlanRepository;

@Component
public class DataLoder implements ApplicationRunner{
	
	@Autowired
	private CitizenPlanRepository repo;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		repo.deleteAll();
		
		//cash plan data
		CitizenPlan c1= new CitizenPlan();
		c1.setCitizen_name("John");
		c1.setGender("Male");
		c1.setPlan_name("Cash");
		c1.setPlan_status("Approved");
		c1.setPlan_start_date(LocalDate.now());
		c1.setPlan_end_date(LocalDate.now().plusMonths(6));
		c1.setBenifit_amount(5000.00);
		
		//cash plan data 
		CitizenPlan c2= new CitizenPlan();
		c2.setCitizen_name("Smith");
		c2.setGender("Male");
		c2.setPlan_name("Cash");
		c2.setPlan_status("Denied");
		c2.setDenial_reason("Rental Income");
	
		//cash plan data
		CitizenPlan c3= new CitizenPlan();
		c3.setCitizen_name("Cathy");
		c3.setGender("Fe-Male");
		c3.setPlan_name("Cash");
		c3.setPlan_start_date(LocalDate.now());
		c3.setPlan_end_date(LocalDate.now().plusMonths(6) );
		c3.setBenifit_amount(5000.00);
		c3.setPlan_status("Terminated");
		c3.setTerminated_date(LocalDate.now());
		c3.setTerminal_reason("Employed");

		//Food plan data
		CitizenPlan c4= new CitizenPlan();
		c4.setCitizen_name("Devid");
		c4.setGender("Male");
		c4.setPlan_name("Food");
		c4.setPlan_status("Denied");
		c4.setDenial_reason("Property ");
		
		//Food plan data
		CitizenPlan c5= new CitizenPlan();
		c5.setCitizen_name("Robert");
		c5.setGender("Male");
		c5.setPlan_name("Food");
		c5.setPlan_status("Denied");
		c5.setDenial_reason("Property Income");
		
		//Food plan data
		CitizenPlan c6= new CitizenPlan();
		c6.setCitizen_name("Orien");
		c6.setGender("Fe-Male");
		c6.setPlan_name("Cash");
		c6.setPlan_start_date(LocalDate.now());
		c6.setPlan_end_date(LocalDate.now().plusMonths(6));
		c6.setBenifit_amount(5000.00);
		c6.setPlan_status("Terminated");
		c6.setTerminated_date(LocalDate.now());
		c6.setTerminal_reason("Employed");
	
		List<CitizenPlan> list = List.of(c1,c2,c3,c4,c5,c6);
		repo.saveAll(list);
	}

}
