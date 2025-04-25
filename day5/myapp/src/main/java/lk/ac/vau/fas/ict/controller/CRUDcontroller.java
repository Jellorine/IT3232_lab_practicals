package lk.ac.vau.fas.ict.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
	
	
	
	// update
	// delete
	
}
