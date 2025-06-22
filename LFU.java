import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

class LFUCache {
    private final int capacity;
    private int minFrequency;
    private final Map<Integer, Integer> keyToValue;
    private final Map<Integer, Integer> keyToFrequency;
    private final Map<Integer, Set<Integer>> frequencyToKeys;
    
    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFrequency = 0;
        this.keyToValue = new HashMap<>();
        this.keyToFrequency = new HashMap<>();
        this.frequencyToKeys = new HashMap<>();
    }
    
    public int get(int key) {
        if (!keyToValue.containsKey(key)) {
            return -1;
        }
        int frequency = keyToFrequency.get(key);
        keyToFrequency.put(key, frequency + 1);
        frequencyToKeys.get(frequency).remove(key);
        frequencyToKeys.computeIfAbsent(frequency + 1, k -> new LinkedHashSet<>()).add(key);
        if (frequency == minFrequency && frequencyToKeys.get(frequency).isEmpty()) {
            minFrequency++;
        }
        
        return keyToValue.get(key);
    }
    
    public void put(int key, int value) {
        if (capacity <= 0) {
            return;
        }
        
        if (keyToValue.containsKey(key)) {
            keyToValue.put(key, value);
            get(key); 
            return;
        }
        if (keyToValue.size() >= capacity) {
            Set<Integer> keys = frequencyToKeys.get(minFrequency);
            int keyToEvict = keys.iterator().next();
            keys.remove(keyToEvict);
            keyToValue.remove(keyToEvict);
            keyToFrequency.remove(keyToEvict);
        }
        keyToValue.put(key, value);
        keyToFrequency.put(key, 1);
        frequencyToKeys.computeIfAbsent(1, k -> new LinkedHashSet<>()).add(key);
        minFrequency = 1; 
    }
}
