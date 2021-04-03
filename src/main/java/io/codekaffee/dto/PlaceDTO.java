package io.codekaffee.dto;

import io.codekaffee.models.Place;

public class PlaceDTO {
    
    private String name;

    private String description;

    private String city;


    public PlaceDTO(){}

    public PlaceDTO(Place place){
        this.name = place.getName();
        this.description = place.getDescription();
        this.city = place.getDescription();
    }
    

    /**
     * @param name
     * @param description
     * @param city
     */
    public PlaceDTO(String name, String description, String city) {
        this.name = name;
        this.description = description;
        this.city = city;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }
}
