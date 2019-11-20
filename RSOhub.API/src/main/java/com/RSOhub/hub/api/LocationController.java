package com.RSOhub.hub.api;

import com.RSOhub.hub.dao.LocationRepository;
import com.RSOhub.hub.dto.CreateLocationRequest;
import com.RSOhub.hub.dto.GetLocationRequest;
import com.RSOhub.hub.model.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/location")
@RestController
public class LocationController {
    private final LocationRepository locationRepository;

    @Autowired
    LocationController(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(path = "get")
    public Location getLocation(@RequestBody GetLocationRequest getLocationRequest) {
        return locationRepository.findById(getLocationRequest.getRefLocationId()).get();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(path = "create")
    public Location getLocation(@RequestBody CreateLocationRequest createLocationRequest) {
        Location location = new Location(createLocationRequest.getName());
        return locationRepository.save(location);
    }
}
