package io.codekaffee.controllers;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import io.codekaffee.models.Place;
import io.codekaffee.services.PlaceService;

@Path("/places")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PlaceController {

    @Inject
    private PlaceService placeService;


    @GET
    @Produces("application/json")
    public Response getPlaces(){
        List<Place> places = placeService.getPlaces();
        return Response.ok(places).build();
    }


}
