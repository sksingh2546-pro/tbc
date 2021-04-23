package in.his.tbcServer.login;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public interface LoginRepo extends CrudRepository<Login,Long> {

    @Query("select b1 from Login b1 where user_name=?1")
    List<Login> getLogin(String user_name);


    @Query("select b1 from Login b1 where user_name=?1 and password=?2")
    List<Login> getLogin(String user_name,String password);

}
