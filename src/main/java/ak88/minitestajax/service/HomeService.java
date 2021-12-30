package ak88.minitestajax.service;

import ak88.minitestajax.model.Category;
import ak88.minitestajax.model.Home;

public interface HomeService extends IGeneralService<Home> {
    Iterable<Home> findAllByBathroomGreaterThan(int bathroom);
    Iterable<Home> findAllByCategory(Category category);
    Iterable<Home> findAllByOrderByNameDesc();
    Iterable<Home> findAllByName(String name);
    Iterable<Home> findAllByNameContaining(String name);

}
