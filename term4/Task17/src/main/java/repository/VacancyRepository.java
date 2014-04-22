package repository;

import model.Vacancy;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface VacancyRepository extends CrudRepository<Vacancy, Long> {

    @Transactional
    @Query("select vacancy from Vacancy vacancy where vacancy.category.id = ?1")
    Iterable<Vacancy> findByCategory(Long id);
}
