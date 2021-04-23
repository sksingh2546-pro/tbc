package in.his.tbcServer.postgres;


import in.his.tbcServer.converter.StringEncryptDecryptConverter;

import javax.persistence.*;

@Entity
@Table(name = "postgres")
public class Postgres {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "license_code")
    @Convert(converter = StringEncryptDecryptConverter.class)
    private String license_code;
    private  String frequency;
    private String no_of_devices;
    private String status;
    private String stage;
    private String user_name;
    private String user_type;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLicense_code() {
        return license_code;
    }

    public void setLicense_code(String license_code) {
        this.license_code = license_code;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getNo_of_devices() {
        return no_of_devices;
    }

    public void setNo_of_devices(String no_of_devices) {
        this.no_of_devices = no_of_devices;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }
}
