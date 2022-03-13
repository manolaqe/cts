package ro.ase.acs.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) {
		try {
			Class.forName("org.sqlite.JDBC");
			Connection connection = DriverManager.getConnection("jdbc:sqlite:database.db");
			connection.setAutoCommit(false);

			Operation operationCreate = (Operation) Class.forName("ro.ase.acs.sql.CreateTableOperation").getDeclaredConstructor().newInstance();
			Orchestrator orchestratorCreate = new Orchestrator(operationCreate, connection);
			orchestratorCreate.execute();

			Operation operationInsert = (Operation) Class.forName("ro.ase.acs.sql.InsertDataOperation").getDeclaredConstructor().newInstance();
			Orchestrator orchestratorInsert = new Orchestrator(operationInsert, connection);
			orchestratorInsert.execute();

			Operation operationRead = (Operation) Class.forName("ro.ase.acs.sql.ReadDataOperation").getDeclaredConstructor().newInstance();
			Orchestrator orchestratorRead = new Orchestrator(operationRead, connection);
			orchestratorRead.execute();
			
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
