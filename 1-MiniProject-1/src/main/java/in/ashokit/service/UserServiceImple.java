package in.ashokit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.Repo.UserAccountRepo;
import in.ashokit.entity.UserAccount;

@Service
public class UserServiceImple implements UserService {

	@Autowired
	private UserAccountRepo repo;
	
	
	@Override
	public String saveUserAcc(UserAccount useracc) {
		UserAccount save = repo.save(useracc);
		Integer user_Id = useracc.getUser_Id();
		if(user_Id==null) {
			
			return "User Data is saved";
		}
		else {
			return "User Record is Updated";
		}
	}
	

	@Override
	public List<UserAccount> getAllUserAccounts() {
		List<UserAccount> findAll = repo.findAll();
		return findAll;
	}

	@Override
	public UserAccount getUserAcc(Integer UserId) {
	    Optional<UserAccount> findById = repo.findById(UserId);
		if(findById.isPresent()) {
		    return findById.get();
		}
	    return null; 
	}

	@Override
	public boolean deleteUserAcc(Integer UserId) {
	   boolean existsById = repo.existsById(UserId);
	   if(existsById) {
		   repo.deleteById(UserId);
		   return true;
	   }else {
		return false;
	   }
	}

	@Override
	public boolean updateUserAccStatus(Integer UserId, String status) {
	
		try {
			repo.updateUserAccStatus(UserId, status);
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

}
