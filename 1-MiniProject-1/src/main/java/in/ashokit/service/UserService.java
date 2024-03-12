package in.ashokit.service;

import java.util.List;

import in.ashokit.entity.UserAccount;

public interface UserService {

	  public String saveUserAcc(UserAccount useracc);
	  
	  public List<UserAccount> getAllUserAccounts();
	  
	  public UserAccount getUserAcc(Integer UserId);
	  
	  public boolean deleteUserAcc(Integer UserId);
	  
	  public boolean updateUserAccStatus(Integer UserId,String status);
	  
	  
}
