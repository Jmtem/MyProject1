package ru.myapp.phone;

import java.util.HashMap;
import java.util.Map;

public class PhoneService {

    private static Map<String, Phone> phone = new HashMap<>();

    static  {
        phone.put("Samsung", new Phone("Samsung", 30000.0, "smartphone", "6", "Blue", "China"));
        phone.put("Honor", new Phone("Honor", 20000.0, "smartphone", "6.2", "White", "China"));
        phone.put("Apple", new Phone("Apple", 75500.0,"smartphone", "6.4", "Black", "China"));
        phone.put("Realme", new Phone("Realme", 25500.0, "smartphone", "6.3", "Grey", "China"));
        phone.put("Xiaomi", new Phone("Xiaomi", 35500.0,"smartphone", "6.5", "Grey", "China"));

    }

    public static synchronized Map<String, Phone> getAll() {
        return phone;
    }

    public  synchronized void add(Phone phone) {
        this.phone.put(phone.getName(), phone);
    }
}
