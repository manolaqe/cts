package ro.ase.acs.sql;

import java.sql.Connection;
import java.sql.SQLException;

public interface Operation {
    void execute(Connection connection) throws SQLException;
}
