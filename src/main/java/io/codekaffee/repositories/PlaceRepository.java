package io.codekaffee.repositories;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import io.codekaffee.models.Place;
import io.quarkus.hibernate.orm.panache.PanacheRepository;


@ApplicationScoped
public class PlaceRepository implements PanacheRepository<Place> {

    public Place findByName(String name){
        return find("name", name).firstResult();
    }

    public List<Place> findByCity(String city){
        return find("city", city).list();
    }
    
}
