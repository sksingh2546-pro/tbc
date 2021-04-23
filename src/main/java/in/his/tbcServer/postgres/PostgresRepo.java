package in.his.tbcServer.postgres;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface PostgresRepo extends CrudRepository<Postgres, Long> {
    @Query("select b1 from Postgres b1 where user_name=?1")
    List<Postgres> getUserName(String user_name);

    @Modifying
    @Query(value = "update postgres set license_code=?1,frequency=?2,no_of_devices=?3,status=?4,stage=?5 where user_name=?6", nativeQuery = true)
    @Transactional
    int updateUserName(String license_code,String frequency,String no_of_devices,String status,String stage,String user_name);


    @Modifying
    @Query(value = "update postgres set stage=?1 where user_name=?2", nativeQuery = true)
    @Transactional
    int updateStage(String stage,String user_name);


}
