package in.his.tbcServer.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8011")
public class LoginController {

    @Autowired
    LoginRepo loginRepo;

    @PostMapping("insertLogin")
    public String insertLogin(@RequestBody Login login){
        String message="UnSuccessful";
        List<Login>loginList=loginRepo.getLogin(login.getUser_name());
        if(loginList.size()>0){
            message="Try another user name";
        }else {
            loginRepo.save(login);
            message="Inserted";
        }
        return message;
    }

    @GetMapping("getLogin")
    public String getLogin(@RequestParam("user_name")String user_name,@RequestParam("password")String password
                           ){
        String message="Not Login";
        List<Login>loginList=loginRepo.getLogin(user_name,password);
        if(loginList.size()>0){
            if(loginList.get(0).getUser_type().equalsIgnoreCase("admin")){
                message="admin";
            }
            else{

                message="user";
            }
        }
        return  message;
    }
}
