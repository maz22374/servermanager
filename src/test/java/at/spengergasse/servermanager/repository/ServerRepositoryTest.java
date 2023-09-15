package at.spengergasse.servermanager.repository;

import at.spengergasse.servermanager.enumeration.Status;
import at.spengergasse.servermanager.model.Server;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class ServerRepositoryTest {

    @Autowired
    ServerRepository underTest;

    @Test
    void canFindByIpAddress() {
        // given
        Server server = new Server(
                1L,
                "192.168.1.160",
                "Ubuntu Linux",
                "16 GB",
                "Personal PC",
                "http://localhost:8080/server/image/server1.png",
                Status.SERVER_UP
        );
        underTest.save(server);

        // when
        Server foundServer = underTest.findByIpAddress("192.168.1.160");

        // then
        assertThat(foundServer).isNotNull();
        assertThat(foundServer.getIpAddress()).isEqualTo("192.168.1.160");
        assertThat(foundServer.getName()).isEqualTo("Ubuntu Linux");
        assertThat(foundServer.getMemory()).isEqualTo("16 GB");
        assertThat(foundServer.getType()).isEqualTo("Personal PC");
        assertThat(foundServer.getImageUrl()).isEqualTo("http://localhost:8080/server/image/server1.png");
        assertThat(foundServer.getStatus()).isEqualTo(Status.SERVER_UP);
    }
}