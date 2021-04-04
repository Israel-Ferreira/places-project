package io.codekaffee.services;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import io.codekaffee.dto.PlaceDTO;
import io.codekaffee.exceptions.EmptyArgumentException;
import io.codekaffee.exceptions.PlaceNotFoundException;
import io.codekaffee.models.Place;
import io.codekaffee.repositories.PlaceRepository;

@ApplicationScoped
public class PlaceService {

    private PlaceRepository placeRepository;

    @Inject
    public PlaceService(PlaceRepository placeRepository){
        this.placeRepository = placeRepository;
    }

    public List<Place> getPlaces(){
        return placeRepository.listAll();
    }

    public Place getById(Long id){
        Place place = placeRepository.findById(id);

        if(place.equals(null)){
            throw new PlaceNotFoundException();
        }

        return place;
    }

    public Place getPlaceByName(String name){

        if(name.equals("") || name.equals(null)){
            throw new EmptyArgumentException();
        }

        return placeRepository.findByName(name);
    }
    

    public boolean deleteById(Long id){
        return placeRepository.deleteById(id);
    }


    @Transactional
    public Place createPlace(PlaceDTO place){
        Place newPlace = new Place(place);

        placeRepository.persist(newPlace);
        return newPlace;
    }
}
