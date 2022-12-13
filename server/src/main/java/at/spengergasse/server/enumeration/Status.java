package at.spengergasse.server.enumeration;

/**
 * @author david on 05.12.2022
 * @version 1.0.0
 */
public enum Status {
    SERVER_UP("SERVER_UP"),
    SERVER_DOWN("SERVER_DOWN");

    private final String status;

    Status(String status) {
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }
}
