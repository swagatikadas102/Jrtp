package in.ashokit.Searchrequest;

import java.time.LocalDate;

import lombok.Data;

@Data
public class SearchRequest {

	private String planname;
	private String planstatus;
	private String gender;
	private LocalDate startdate;
	private LocalDate enddate; 
	
	
}
