package io.codekaffee.dto;

import java.io.File;
import java.util.ArrayList;
import java.util.List;



public class ImageDTO {

    private Long placeId;

    private List<File> files = new ArrayList<>();


    public ImageDTO(){}


    /**
     * @return the placeId
     */
    public Long getPlaceId() {
        return placeId;
    }


    /**
     * @param placeId the placeId to set
     */
    public void setPlaceId(Long placeId) {
        this.placeId = placeId;
    }


    /**
     * @return the files
     */
    public List<File> getFiles() {
        return files;
    }


    /**
     * @param files the files to set
     */
    public void setFiles(List<File> files) {
        this.files = files;
    }

    
}
