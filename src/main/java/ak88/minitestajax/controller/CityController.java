package ak88.minitestajax.controller;

import ak88.minitestajax.service.CityService;
import ak88.minitestajax.service.NationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/cities")
@CrossOrigin("*")
public class CityController {
    @Autowired
    CityService cityService;
    @Autowired
    NationService nationService;

}
