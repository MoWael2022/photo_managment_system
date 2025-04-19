package model ;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TagSearch extends SearchType{

    @Override
    List<Photo> getImages(List<Photo> allphotos,String query) {
        Stream<Photo> stream = allphotos.stream();
        List<Photo> returnedByTagPhotos= stream.filter(i -> (i.getTag().contains(query))).collect(Collectors.toList()); 
        return returnedByTagPhotos;   
    }

}