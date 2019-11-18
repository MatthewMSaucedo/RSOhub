package com.RSOhub.hub.api;

import com.RSOhub.hub.dao.UniversityRepository;
import com.RSOhub.hub.dto.FindUniversityByNameRequest;
import com.RSOhub.hub.model.University;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("api/university")
@RestController
public class UniversityController {
    private final UniversityRepository universityRepository;

    @Autowired
    public UniversityController(UniversityRepository universityRepository) {
        this.universityRepository = universityRepository;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(path = "list")
    public List<University> list() {
        try {
            return universityRepository.findAll();
        } catch (Exception e) {
            return null;
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(path = "create")
    public University create(@RequestBody University university) {
        try {
            return universityRepository.save(university);
        } catch (Exception e) {
            return null;
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(path = "findByName")
    public int findByName(@RequestBody FindUniversityByNameRequest request) {
        try {
            String universityName = request.getUniversityName();
            University university = universityRepository.findByName(universityName);
            return university.getId();
        } catch (Exception e) {
            throw e;
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(path = "{id}")
    public University getUniversity(@PathVariable("id") int id) {
        try {
            Optional<University> value = universityRepository.findById(id);
            return value.get();
        } catch (Exception e) {
            return null;
        }
    }

}
