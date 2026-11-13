import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Answer {
    static int maxValue(List<Integer> values) {
        if (values.isEmpty()) {
            throw new IllegalArgumentException("List មិនអាចទទេ");
        }
        return Collections.max(values);
    }

    public static void main(String[] args) {
        List<Integer> scores = new ArrayList<>(List.of(70, 90, 80));
        int total = 0;
        for (int score : scores) {
            total += score;
        }
        System.out.println("ផលបូក: " + total);

        Set<String> names = new HashSet<>(List.of("សុភា", "ដារ៉ា", "សុភា"));
        System.out.println("ឈ្មោះមិនស្ទួន: " + names.size());

        Map<String, Integer> scoreByName = new HashMap<>();
        scoreByName.put("សុភា", 95);
        scoreByName.put("ដារ៉ា", 88);
        System.out.println("ពិន្ទុសុភា: " + scoreByName.get("សុភា"));

        Collections.sort(scores);
        System.out.println("តម្រៀបរួច: " + scores);
        System.out.println("ពិន្ទុខ្ពស់បំផុត: " + maxValue(scores));
    }
}
