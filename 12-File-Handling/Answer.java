import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class Answer {
    public static void main(String[] args) {
        Path path = Path.of("output.txt");

        try (BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {
            writer.write("រៀន Java");
            writer.newLine();
            writer.write("អនុវត្ត File I/O");
        } catch (IOException exception) {
            System.out.println("សរសេរ file មិនបាន: " + exception.getMessage());
            return;
        }

        try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException exception) {
            System.out.println("អាន file មិនបាន: " + exception.getMessage());
        }
    }
}
