import liquibase.Contexts;
import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.LiquibaseException;
import liquibase.resource.ClassLoaderResourceAccessor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class LiquibaseAPIExecutor {

  private static final String DEFAULT_URL = "jdbc:mysql://localhost:3306/db";
  private static final String DEFAULT_USER = "root";
  private static final String DEFAULT_PASSWORD = "password";

  private String url;
  private String user;
  private String password;

  // Constructor using default values
  public LiquibaseAPIExecutor() {
    this(DEFAULT_URL, DEFAULT_USER, DEFAULT_PASSWORD);
  }

  // Constructor using custom values
  public LiquibaseAPIExecutor(String url, String user, String password) {
    this.url = url;
    this.user = user;
    this.password = password;
  }

  private void executeLiquibaseCommand(String changelogFile, LiquibaseCommandExecutor commandExecutor) throws ClassNotFoundException, SQLException, LiquibaseException {
    Class.forName("com.mysql.cj.jdbc.Driver");
    try (Connection conn = DriverManager.getConnection(url, user, password)) {
      Database database = DatabaseFactory.getInstance().findCorrectDatabaseImplementation(new JdbcConnection(conn));
      Liquibase liquibase = new Liquibase(changelogFile, new ClassLoaderResourceAccessor(), database);
      commandExecutor.execute(liquibase);
    } // Connection will be closed automatically
  }

  public void update(String changelogFile) throws ClassNotFoundException, SQLException, LiquibaseException {
    executeLiquibaseCommand(changelogFile, liquibase -> {
      liquibase.update(new Contexts());
    });
  }

  public void dropAll(String changelogFile) throws ClassNotFoundException, SQLException, LiquibaseException {
    executeLiquibaseCommand(changelogFile, liquibase -> {
      liquibase.dropAll();
    });
  }

  @FunctionalInterface
  private interface LiquibaseCommandExecutor {
    void execute(Liquibase liquibase) throws LiquibaseException;
  }
}
