package model;

import java.util.List;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NameImageSearch extends SearchType{

    @Override
    List<Photo> getImages(List<Photo> allphotos, String query) {
        Stream<Photo> stream = allphotos.stream();
        List<Photo> returnedByNamePhotos= stream.filter(i -> (i.getImage().contains(query))).collect(Collectors.toList()); 
        return returnedByNamePhotos;  
    }

}