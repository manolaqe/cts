package ro.ase.acs.sql;

import java.sql.Connection;
import java.sql.SQLException;

public class Orchestrator {
    private Operation operation;
    private Connection connection;

    public Orchestrator(Operation operation, Connection connection) {
        this.operation = operation;
        this.connection = connection;
    }

    public void execute() throws SQLException {
        operation.execute(connection);
    }
}
