package app.sa.reto5mintic.app.service;
import app.sa.reto5mintic.app.model.Chocolate;
import app.sa.reto5mintic.app.repository.ChocolateRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author jefer
 */
@Service
public class ChocolateService {

    @Autowired
    private ChocolateRepository repository;

    public List<Chocolate> getAll() {
        return repository.getAll();
    }

    public Optional<Chocolate> getProduct(String reference) {
        return repository.getproduct(reference);
    }

    public Chocolate create(Chocolate accesory) {
        if (accesory.getReference() == null) {
            return accesory;
        } else {
            return repository.create(accesory);
        }
    }

    public Chocolate update(Chocolate accesory) {

        if (accesory.getReference() != null) {
            Optional<Chocolate> accesoryDb = repository.getproduct(accesory.getReference());
            if (!accesoryDb.isEmpty()) {

                /*if (accesory.getBrand() != null) {
                    accesoryDb.get().setBrand(accesory.getBrand());
                }*/

                if (accesory.getCategory() != null) {
                    accesoryDb.get().setCategory(accesory.getCategory());
                }

                if (accesory.getDescription() != null) {
                    accesoryDb.get().setDescription(accesory.getDescription());
                }
                if (accesory.getPrice() != 0.0) {
                    accesoryDb.get().setPrice(accesory.getPrice());
                }
                if (accesory.getQuantity() != 0) {
                    accesoryDb.get().setQuantity(accesory.getQuantity());
                }
                if (accesory.getPhotography() != null) {
                    accesoryDb.get().setPhotography(accesory.getPhotography());
                }
                accesoryDb.get().setAvailability(accesory.isAvailability());
                repository.update(accesoryDb.get());
                return accesoryDb.get();
            } else {
                return accesory;
            }
        } else {
            return accesory;
        }
    }

    public boolean delete(String reference) {
        Boolean aBoolean = getProduct(reference).map(accesory -> {
            repository.delete(accesory);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    //Reto 5
    public List<Chocolate> productByPrice(double price) {
        return repository.productByPrice(price);
    }

    //Reto 5
    public List<Chocolate> findByDescriptionLike(String description) {
        return repository.findByDescriptionLike(description);
    }
}
