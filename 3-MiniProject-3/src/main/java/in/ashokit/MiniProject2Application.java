package in.ashokit;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import in.ashokit.entity.AppEntity;
import in.ashokit.service.AppService;

@SpringBootApplication
public class MiniProject2Application {

	
	
	
	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(MiniProject2Application.class, args);
		AppService service = ctx.getBean("appService",AppService.class);
		
		
		AppEntity student1 = new AppEntity();
		student1.setId(101);
		student1.setName("kiran");
		
		AppEntity student2 = new AppEntity();
		student2.setId(102);
		student2.setName("ravi");
		
		AppEntity student3 = new AppEntity();
		student3.setId(103);
		student3.setName("subha");
		
		AppEntity student4 = new AppEntity();
		student4.setId(104);
		student4.setName("didi");
		
		AppEntity student5 = new AppEntity();
		student5.setId(105);
		student5.setName("rudra");
	
		
		List<AppEntity> list = List.of(student1,student2,student3,student4,student5);
           
		Boolean saveStudentData = service.saveStudentData(list);
		System.out.println(saveStudentData);

}
}
