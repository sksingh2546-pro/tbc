package in.his.tbcServer.postgres;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
public class PostgresController {
    @Autowired
    PostgresRepo postgresRepo;

    @PostMapping("insertUserCredentials")
    public String insertUser_credentials(@RequestBody Postgres postgres){
        String message="UnSuccessful";
        Date date =new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<Postgres>postgres1=postgresRepo.getUserName(postgres.getUser_name());
        if(postgres1.size()>0){
            int update=postgresRepo.updateUserName(sdf.format(date),postgres.getFrequency(),
                    postgres.getNo_of_devices(),"valid","Unused",postgres.getUser_name());
            if(update>0){
                message="Updated";
            }
        }else {
            postgres.setStage("Unused");
            postgres.setStatus("Valid");
            postgres.setLicense_code(sdf.format(date));
            postgresRepo.save(postgres);
            message="Inserted";
        }
        return message;
    }

    @GetMapping("getData")
    public List<Postgres> getAllData(){

        return (List<Postgres>) postgresRepo.findAll();
    }

    @PostMapping("updateStatus")
    public String updateStatus(@RequestBody Postgres postgres){
        String message="UnSuccessful";
        List<Postgres>postgres1=postgresRepo.getUserName(postgres.getUser_name());
        if(postgres1.size()>0){
            int update=postgresRepo.updateStage("Used",postgres.getUser_name());
            if(update>0){
                message="Updated";
            }
        }
        return message;

    }

    @GetMapping("getTotalLicencingList")
    public Map<String,List<Postgres>> getTotalStockManagement(){
        List<Postgres>postgres= (List<Postgres>) postgresRepo.findAll();
        HashMap<String,List<Postgres>> hMap=new HashMap<>();
        hMap.put("totalData",postgres);
        return hMap;
    }

}
