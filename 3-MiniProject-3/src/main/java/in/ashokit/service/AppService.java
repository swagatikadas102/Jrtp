package in.ashokit.service;

import java.util.List;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import in.ashokit.entity.AppEntity;
import in.ashokit.repo.AppRepository;

@Service("appService")
public class AppService {
	
	@Autowired
	private AppRepository repo;

	
	public Boolean saveStudentData(List<AppEntity> list){
		repo.saveAll(list);
		return true;
	}
}
