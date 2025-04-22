package controller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import core.GalleryObserver;
import model.Gallery;
import model.Photo;
import model.SearchType; 

public class GalleryController {

    private static GalleryController instance ;

    private Gallery gallery = Gallery.getInstance();
    private static final String DEFAULT_TAG = "nature";
    private static final String DEFAULT_LOCATION = "home";



    public GalleryController() {
        
    }

    public static GalleryController getInstance(){
        if (instance == null) {
            instance = new GalleryController();
        }
        return instance; 
    }

  

    private List<GalleryObserver> observers = new ArrayList<>();

    public void addObserver(GalleryObserver observer){
        observers.add(observer);
    }

    private void notifyObserver(){
        observers.forEach(GalleryObserver::onGalleryChanged);

    }

    public void addImageAction(File file){
        String imageName = file.getName();
        String date = java.time.LocalDate.now().toString();
        gallery.AddImageToGallery(DEFAULT_LOCATION, DEFAULT_TAG, file, date, imageName);
        notifyObserver();
    }


    public void addImage(File file, String tag, String location, String date, String name) {
        gallery.AddImageToGallery(location, tag, file, date, name);
        notifyObserver();
    }

    public List<Photo> getPhotosByTag(String tag) {
        return gallery.getPhotoByTag(tag);
    }

    public List<Photo> getPhotosByLocation(String location) {
        return gallery.getPhotoByLocation(location);
    }

    public List<Photo> searchPhotos(SearchType type, String query) {
        return gallery.searchImage(type, query);
    }

    public Set<String> getAllTags() {
        return gallery.getTags();
    }

    public Set<String> getAllLocations() {
        return gallery.getLocation();
    }

    public List<Photo> getAllPhotos() {
        return gallery.getAllImages();
    }

    public void deleteImage(int id) {
        gallery.deleteImageFromGallery(id);
        notifyObserver();
    }
}
