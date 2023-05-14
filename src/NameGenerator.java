import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NameGenerator {
    private static Random random = new Random();
    private static List<String> firstNames = new ArrayList<>();
    private static List<String> lastNames = new ArrayList<>();

    static {
        firstNames.add("John");
        firstNames.add("Jane");
        firstNames.add("Michael");
        firstNames.add("Emily");
        firstNames.add("David");
        firstNames.add("Sarah");
        lastNames.add("Smith");
        lastNames.add("Johnson");
        lastNames.add("Williams");
        lastNames.add("Jones");
        lastNames.add("Brown");
        lastNames.add("Davis");
    }

    public static String generateFullName() {
        String firstName = firstNames.get(random.nextInt(firstNames.size()));
        String lastName = lastNames.get(random.nextInt(lastNames.size()));
        return firstName + " " + lastName;
    }
}
