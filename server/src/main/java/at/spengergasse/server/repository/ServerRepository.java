package at.spengergasse.server.repository;

import at.spengergasse.server.model.Server;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author david on 05.12.2022
 * @version 1.0.0
 */
public interface ServerRepository extends JpaRepository<Server, Long> {
    Server findByIpAddress(String ipAddress);
}
