package in.his.tbcServer.encryptionData;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
@Service
public interface EncryptionRepository extends JpaRepository<EncryptionData,String> {
}
