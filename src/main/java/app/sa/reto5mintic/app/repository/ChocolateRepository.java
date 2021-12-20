package app.sa.reto5mintic.app.repository;


import app.sa.reto5mintic.app.model.Chocolate;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import app.sa.reto5mintic.app.service.ChocolateCrudRepository;

/**
 *
 * @author jefer
 */
@Repository
public class ChocolateRepository {
    @Autowired
    private ChocolateCrudRepository repository;

    public List<Chocolate> getAll() {
        return repository.findAll();
    }

    public Optional<Chocolate> getproduct(String reference) {
        return repository.findById(reference);
    }
    
    public Chocolate create(Chocolate clothe) {
        return repository.save(clothe);
    }

    public void update(Chocolate clothe) {
        repository.save(clothe);
    }
    
    public void delete(Chocolate clothe) {
        repository.delete(clothe);
    } 
    //Reto 5
    public List<Chocolate> productByPrice(double precio){
        return repository.findByPriceLessThanEqual(precio);
    }
    //Reto 5
    public List<Chocolate> findByDescriptionLike(String description){
        return repository.findByDescriptionLike(description);
    }
}
