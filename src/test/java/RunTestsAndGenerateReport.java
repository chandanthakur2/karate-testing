import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RunTestsAndGenerateReport {

    @Test
    public void runTestsAndGenerateReport() {
        int exitCode = executeCommand("mvn test");
        System.out.println("Tests completed with exit code: " + exitCode);

        int reportExitCode = executeCommand("mvn allure:report");
        assertEquals(0, reportExitCode, "Allure report generation failed");
    }

    private int executeCommand(String command) {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (System.getProperty("os.name").toLowerCase().startsWith("windows")) {
            processBuilder.command("cmd.exe", "/c", command);
        } else {
            processBuilder.command("sh", "-c", command);
        }

        try {
            Process process = processBuilder.start();
            return process.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}