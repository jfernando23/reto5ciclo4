package app.sa.reto5mintic.app.repository.crud;

import app.sa.reto5mintic.app.model.Order;
import java.util.Date;
import java.util.List;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author jefer
 */
public interface OrderCrudRepository extends CrudRepository<Order, Integer> {

    @Query("{'salesMan.zone': ?0}")
    List<Order> findByZone(final String zone);
    
    @Query("{status: ?0}")
    List<Order> findByStatus(final String status);
}
