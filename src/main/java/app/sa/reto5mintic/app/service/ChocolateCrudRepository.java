/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.sa.reto5mintic.app.service;


import app.sa.reto5mintic.app.model.Chocolate;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 *
 * @author jefer
 */
public interface ChocolateCrudRepository extends MongoRepository<Chocolate, String> {
    //Reto 5
    public List<Chocolate> findByPriceLessThanEqual(double precio);
    
    //Reto 5
    @Query("{'description':{'$regex':'?0','$options':'i'}}")
    public List<Chocolate> findByDescriptionLike(String description);
}
