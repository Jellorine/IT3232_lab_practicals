package lk.ac.vau.fas.ict.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class CRUDcontroller<K,T> {
	
	private Map<K, T> objects = new HashMap<K, T>();
	
	public Map<K, T> getMap() {
		return objects;
	}
	
	@GetMapping("/all")
	public Map<K, T> getAll() {
		return objects;
	}
	@GetMapping("/{id}")
	public T get(@PathVariable("id") K id) {
		return objects.get(id);
	}
	
	// add new
	@PostMapping("/add/{id}")
    public String add(@PathVariable("id") K id, @RequestBody T obj) {
        if (objects.containsKey(id)) {
            return "Item with this ID already exists!";
        }
        objects.put(id, obj);
        return "Item added successfully!";
    }
	
	
	// update
	// delete
	
}
