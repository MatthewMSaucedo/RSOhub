package com.RSOhub.hub.api;

import com.RSOhub.hub.dao.ValueRepository;
import com.RSOhub.hub.model.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

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

    /*
    @GetMapping(path = "{id}")
    public Value getValueById(@PathVariable("id") UUID id) {
        return valueRepository.getValueById(id)
                .orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deletePersonById(@PathVariable("id") UUID id) {
        valueRepository.deleteValue(id);
    }

    @PutMapping(path = "{id}")
    public void updatePerson(@PathVariable("id") UUID id, @Valid @NonNull @RequestBody Value valueToUpdate) {
        valueRepository.updateValue(id, valueToUpdate);
    }*/
}
