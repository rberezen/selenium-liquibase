import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class LiquibaseCLIExecutor {

  public void executeLiquibaseCommand(String pathToLiquibaseFolder, String... liquibaseCommandParts) {
    try {
      List<String> commands = new ArrayList<>();
      for (String part : liquibaseCommandParts) {
        commands.add(part);
      }

      for (String cmdPart : commands) {
        System.out.print(cmdPart + " ");
      }
      System.out.println();

      ProcessBuilder builder = new ProcessBuilder(commands);
      builder.directory(new File(pathToLiquibaseFolder));

      Process process = builder.start();

      BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));
      String s;
      while ((s = stdInput.readLine()) != null) {
        System.out.println(s);
      }

      BufferedReader stdError = new BufferedReader(new InputStreamReader(process.getErrorStream()));
      while ((s = stdError.readLine()) != null) {
        System.err.println(s);
      }

      int exitVal = process.waitFor();
      if (exitVal == 0) {
        System.out.println("Liquibase command executed successfully.");
      } else {
        System.err.println("Liquibase command execution failed.");
      }

    } catch (IOException | InterruptedException e) {
      e.printStackTrace();
    }
  }
}
