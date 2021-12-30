package ak88.minitestajax.repository;

import ak88.minitestajax.model.Category;
import ak88.minitestajax.model.Home;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HomeRepository extends JpaRepository<Home,Long> {
    Iterable<Home> findAllByBathroomGreaterThan(int bathroom);
    Iterable<Home> findAllByCategory(Category category);
    Iterable<Home> findAllByOrderByNameDesc();
    Iterable<Home> findAllByName(String name);
    Iterable<Home> findAllByNameContaining(String name);
}
