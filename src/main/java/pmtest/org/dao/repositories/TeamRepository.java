package pmtest.org.dao.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pmtest.org.model.Event;
import pmtest.org.model.EventWrapper;

import java.util.List;

@Repository
@Transactional
public interface TeamRepository extends CrudRepository <Event, Long> {
    @Query  (value = "SELECT e.nameEvent as nameEvent FROM Event e")
    List <String> getNameEvent();
}
