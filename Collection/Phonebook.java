package Collection;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Phonebook {
    private Map<String, List<String>>  ph = new HashMap<>();
    private List<String> number;

    public void add(String name, String phone) {
        if (ph.containsKey(name)) {
            number = ph.get(name);
            addPhone(name, phone);
        } else {
            number = new ArrayList<>();
            addPhone(name, phone);
        }
    }

    void addPhone(String name, String phone) {
        number.add(phone);
        ph.put(name, number);
    }

    public List<String> get(String name){
            return ph.get(name);
        }
      }
