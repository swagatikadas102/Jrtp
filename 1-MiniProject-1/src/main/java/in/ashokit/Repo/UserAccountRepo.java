package in.ashokit.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import in.ashokit.entity.UserAccount;
import jakarta.transaction.Transactional;


public interface UserAccountRepo extends JpaRepository<UserAccount, Integer> {

	@Modifying
	@Transactional
	@Query("update UserAccount set Active_Sw=:status where  User_Id=:User_Id")
	public void updateUserAccStatus(Integer  User_Id,String status);
}
