package ak88.minitestajax.controller;

import ak88.minitestajax.model.City;
import ak88.minitestajax.model.Home;
import ak88.minitestajax.model.Nation;
import ak88.minitestajax.service.CityService;
import ak88.minitestajax.service.NationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/cities")
@CrossOrigin("*")
public class CityController {
    @Autowired
    CityService cityService;
    @Autowired
    NationService nationService;

    @GetMapping("")
    public ResponseEntity<Iterable<City>> findAll() {
        Iterable<City> cities = cityService.findAll();
        return new ResponseEntity<>(cities, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<City> findOne(@PathVariable Long id) {
        Optional<City> city = cityService.findById(id);
        return new ResponseEntity<>(city.get(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<City> createCity(@RequestBody  City city) {
        cityService.save(city);
        return new ResponseEntity<>(city, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<City> updateCity(@PathVariable Long id,@RequestBody City city){
        city.setId(cityService.findById(id).get().getId());
        cityService.save(city);
        return new ResponseEntity<>(city,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<City> deleteCity(@PathVariable Long id){
        cityService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/nation")
    public ResponseEntity<Iterable<Nation>> findAllNation(){
        Iterable<Nation> nations=nationService.findAll();
        return new ResponseEntity<>(nations,HttpStatus.OK);
    }
}
