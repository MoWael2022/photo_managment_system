package model ;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class locationSearch extends SearchType{

    @Override
    List<Photo> getImages(List<Photo> allphotos, String query) {
        Stream<Photo> stream = allphotos.stream();
        List<Photo> returnedByLocationPhotos= stream.filter(i -> (i.getLocation().contains(query))).collect(Collectors.toList()); 
        return returnedByLocationPhotos;   
    }

}