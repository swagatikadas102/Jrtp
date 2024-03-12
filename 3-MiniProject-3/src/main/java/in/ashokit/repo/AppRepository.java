package in.ashokit.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ashokit.entity.AppEntity;

public interface AppRepository extends JpaRepository<AppEntity,Integer >{

}
