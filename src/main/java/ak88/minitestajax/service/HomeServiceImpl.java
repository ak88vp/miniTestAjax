package ak88.minitestajax.service;

import ak88.minitestajax.model.Category;
import ak88.minitestajax.model.Home;
import ak88.minitestajax.repository.HomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HomeServiceImpl implements HomeService {
    @Autowired
    HomeRepository homeRepository;

    @Override
    public Iterable<Home> findAll() {
        return homeRepository.findAll();
    }

    @Override
    public Optional<Home> findById(Long id) {
        return homeRepository.findById(id);
    }

    @Override
    public void save(Home home) {
        homeRepository.save(home);
    }

    @Override
    public void remove(Long id) {
        homeRepository.deleteById(id);
    }

    @Override
    public Iterable<Home> findAllByBathroomGreaterThan(int bathroom) {
        return homeRepository.findAllByBathroomGreaterThan(2);
    }

    @Override
    public Iterable<Home> findAllByCategory(Category category) {
        return homeRepository.findAllByCategory(category);
    }

    @Override
    public Iterable<Home> findAllByOrderByNameDesc() {
        return homeRepository.findAllByOrderByNameDesc();
    }
}
