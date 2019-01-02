import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class GrammarTest {
    public static void main(String[] args) {
        System.out.println(System.getProperty("user.dir"));
        try (BufferedReader bf = new BufferedReader(new FileReader("./resource/testGrammer/test.md"))) {
            String line;
            while ((line = bf.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
