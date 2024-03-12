package in.ashokit.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class CitizenPlan {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer citizen_id;
	private String citizen_name;
	private String gender;
	private String plan_name;
	private String plan_status;
	private LocalDate plan_start_date;
	private LocalDate plan_end_date;
	private Double benifit_amount;
	private String denial_reason;
	private LocalDate terminated_date;
	private String terminal_reason;
	
}
