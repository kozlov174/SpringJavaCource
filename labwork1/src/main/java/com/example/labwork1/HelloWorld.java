import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CollectionController {

    private ArrayList<String> arrayList = null;
    private HashMap<Integer, String> hashMap = null;
    private int mapCounter = 1;

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    @GetMapping("/update-array")
    public String updateArrayList(@RequestParam(value = "s") String s) {
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        arrayList.add(s);
        return "Добавлено в ArrayList: " + s;
    }

    @GetMapping("/show-array")
    public String showArrayList() {
        if (arrayList == null || arrayList.isEmpty()) {
            return "ArrayList пуст";
        }
        return "Элементы ArrayList: " + String.join(", ", arrayList);
    }

    @GetMapping("/update-map")
    public String updateHashMap(@RequestParam(value = "s") String s) {
        if (hashMap == null) {
            hashMap = new HashMap<>();
        }
        hashMap.put(mapCounter++, s);
        return "Добавлено в HashMap: " + s + " (ключ: " + (mapCounter - 1) + ")";
    }

    @GetMapping("/show-map")
    public String showHashMap() {
        if (hashMap == null || hashMap.isEmpty()) {
            return "HashMap пуст";
        }

        StringBuilder result = new StringBuilder("Элементы HashMap: ");
        for (Map.Entry<Integer, String> entry : hashMap.entrySet()) {
            result.append("Ключ: ").append(entry.getKey())
                    .append(" - Значение: ").append(entry.getValue())
                    .append("; ");
        }
        return result.toString();
    }

    @GetMapping("/show-all-length")
    public String showAllLength() {
        int arraySize = (arrayList == null) ? 0 : arrayList.size();
        int mapSize = (hashMap == null) ? 0 : hashMap.size();

        return String.format("Количество элементов: ArrayList - %d, HashMap - %d", arraySize, mapSize);
    }
}