package model  ; 

import java.util.List;


public abstract class SearchType {

    abstract List<Photo> getImages(List< Photo> allphotos, String query); 
}
