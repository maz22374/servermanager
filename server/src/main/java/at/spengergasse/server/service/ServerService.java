package at.spengergasse.server.service;

import at.spengergasse.server.model.Server;

import java.io.IOException;
import java.util.Collection;

/**
 * @author david on 05.12.2022
 * @version 1.0.0
 */
public interface ServerService {
    Server create(Server server);

    Server ping(String ipAddress) throws IOException;

    Collection<Server> list(int limit);

    Server get(Long id);

    Server update(Server server);

    Boolean delete(Long id);
}
