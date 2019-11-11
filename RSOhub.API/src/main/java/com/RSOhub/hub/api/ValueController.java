package com.RSOhub.hub.api;

import com.RSOhub.hub.dao.ValueRepository;
import com.RSOhub.hub.model.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RequestMapping("api/value")
@RestController
public class ValueController {
    private final ValueRepository valueRepository;

    @Autowired
    public ValueController(ValueRepository valueRepository) {
        this.valueRepository = valueRepository;
    }

    @PostMapping
    public Value addValue(@RequestBody Map<String, Integer> value) {
        int number = value.get("number");
        return valueRepository.save(new Value(number));
    }

    @GetMapping
    public List<Value> getAllValues() {
        return valueRepository.findAll();
    }

    @GetMapping(path = "{id}")
    public Value getValue(@PathVariable("id") int id) {
        Optional<Value> value = valueRepository.findById(id);
        return value.get();
    }

    @DeleteMapping(path = "{id}")
    public Value deleteValueById(@PathVariable("id") int id) {
        Optional<Value> deletedValue = valueRepository.findById(id);
        valueRepository.deleteById(id);
        return deletedValue.get();
    }

    @PutMapping(path = "{id}")
    public Value updateValue(@PathVariable("id") int id, @RequestBody Map<String, Integer> newValue) {
        Optional<Value> oldValue = valueRepository.findById(id);
        int number = newValue.get("number");
        Value updatedValue = new Value(oldValue.get().getId(), number);

        return valueRepository.save(updatedValue);
    }
}
