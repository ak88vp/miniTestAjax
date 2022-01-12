package ak88.minitestajax.controller;

import ak88.minitestajax.model.City;
import ak88.minitestajax.model.Home;
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
    public ResponseEntity<Iterable<City>> findAll(){
        Iterable<City> cities= cityService.findAll();
        return new ResponseEntity<>(cities, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<City> findOne(@PathVariable Long id){
        Optional<City> city=cityService.findById(id);
        return new ResponseEntity<>(city.get(),HttpStatus.OK);
    }
}
