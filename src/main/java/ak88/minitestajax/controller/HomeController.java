package ak88.minitestajax.controller;

import ak88.minitestajax.model.Category;
import ak88.minitestajax.model.Home;
import ak88.minitestajax.service.CategoryService;
import ak88.minitestajax.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/homes")
@CrossOrigin("*")
public class HomeController {
    @Autowired
    HomeService homeService;
    @Autowired
    CategoryService categoryService;

    @GetMapping("")
    public ResponseEntity<Iterable<Home>> findAll(){
        Iterable<Home> homes=homeService.findAll();
        return new ResponseEntity<>(homes, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Home> findById(@PathVariable Long id){
        Optional<Home> home=homeService.findById(id);
        return new ResponseEntity<>(home.get(),HttpStatus.OK);
    }
    @GetMapping("category")
    public ResponseEntity<Iterable<Category>> findAllCategory(){
        Iterable<Category> categories=categoryService.findAll();
        return new ResponseEntity<>(categories,HttpStatus.OK);
    }
    @PostMapping("")
    public ResponseEntity<Home> createHome(@RequestBody Home home){
        homeService.save(home);
        return new ResponseEntity<>(home,HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Home> deleteHome(@PathVariable Long id){
        homeService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Home> editHome(@PathVariable Long id,@RequestBody Home home){
        home.setId(id);
        homeService.save(home);
        return new ResponseEntity<>(home,HttpStatus.OK);
    }
    @GetMapping("orderByBathroom")
    public ResponseEntity<Iterable<Home>> orderBy(){
        Iterable<Home> homes=homeService.findAllByBathroomGreaterThan(2);
        return new ResponseEntity<>(homes,HttpStatus.OK);
    }
    @GetMapping("category/{id}")
    public ResponseEntity<Iterable<Home>> findByCategory(@PathVariable Long id){
        Optional<Category> category=categoryService.findById(id);
        Iterable<Home> homes=homeService.findAllByCategory(category.get());
        return new ResponseEntity<>(homes,HttpStatus.OK);
    }
    @GetMapping("oderByName")
    public ResponseEntity<Iterable<Home>> findByOderByName(){
        Iterable<Home> homes=homeService.findAllByOrderByNameDesc();
        return new ResponseEntity<>(homes,HttpStatus.OK);
    }
    @GetMapping("search")
    public ResponseEntity<Iterable<Home>> findByName(String key){
        Iterable<Home> homes=homeService.findAllByNameContaining(key);
        return new ResponseEntity<>(homes,HttpStatus.OK);

    }

}
