package io.codekaffee.controllers;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import io.codekaffee.dto.PlaceDTO;
import io.codekaffee.exceptions.PlaceNotFoundException;
import io.codekaffee.models.Place;
import io.codekaffee.models.StandardError;
import io.codekaffee.services.PlaceService;

@Path("/places")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PlaceController {

    private PlaceService placeService;


    @Inject
    public PlaceController(PlaceService placeService){
        this.placeService = placeService;
    }


    @GET
    @Produces("application/json")
    public Response getPlaces(){
        List<Place> places = placeService.getPlaces();
        return Response.ok(places).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createPlace(PlaceDTO place){
        try {
            var newPlace = this.placeService.createPlace(place);
            Status status = Status.CREATED;

            return Response.status(status).entity(newPlace).build();
        }catch(Exception exception){
            System.out.println(exception.getLocalizedMessage());
            return Response.status(Status.BAD_REQUEST).build();
        }
    }


    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") Long id){

        try {
            Place place = placeService.getById(id);
            return Response.ok(place).build();
        } catch (PlaceNotFoundException e) {
            StandardError error = new StandardError(e.getLocalizedMessage(),Status.NOT_FOUND.getStatusCode());
            return Response.status(Status.NOT_FOUND).entity(error).build();
        }
    }


    @GET
    @Path("/search-by-name")
    public Response getByName(@QueryParam("name") String name){
        try {
            Place place = placeService.getPlaceByName(name);
            return Response.ok(place).build();
        } catch (Exception e) {
            StandardError error = new StandardError(e.getLocalizedMessage(), Status.NOT_FOUND.getStatusCode());
            return Response.status(Status.NOT_FOUND).entity(error).build();
        }
    }


}
