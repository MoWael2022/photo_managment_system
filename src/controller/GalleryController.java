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
    private Gallery gallery;
    private static final String DEFAULT_TAG = "nature";
    private static final String DEFAULT_LOCATION = "home";

    private void initData(){
        gallery.AddImageToGallery("cairo" , "person",new File("C:\\Users\\Mohamed_Wael\\Pictures\\Screenshots\\ip.png"),"2025-04-16","ip");
        gallery.AddImageToGallery("alex" , "person",new File("C:\\Users\\Mohamed_Wael\\Pictures\\Screenshots\\Screenshot (1).png"),"2025-04-16","Screenshot (1).png");

        gallery.AddImageToGallery("alex" , "person",new File("C:\\Users\\Mohamed_Wael\\Pictures\\Screenshots\\ip.png"),"2025-04-16","ip");

        gallery.AddImageToGallery("alex" , "person",new File("C:\\Users\\Mohamed_Wael\\Pictures\\Screenshots\\ip.png"),"2025-04-16","ip");
        gallery.AddImageToGallery("port" , "beach",new File("C:\\Users\\Mohamed_Wael\\Pictures\\Screenshots\\ip.png"),"2025-04-16","ip");
        gallery.AddImageToGallery("port" , "skit",new File("C:\\Users\\Mohamed_Wael\\Pictures\\Screenshots\\ip.png"),"2025-04-16","ip");
        gallery.AddImageToGallery("port" , "nature",new File("C:\\Users\\Mohamed_Wael\\Pictures\\Screenshots\\ip.png"),"2025-04-16","ip");
        gallery.AddImageToGallery("port" , "sports",new File("C:\\Users\\Mohamed_Wael\\Pictures\\Screenshots\\ip.png"),"2025-04-16","ip");
        gallery.AddImageToGallery("sharm" , "person",new File("C:\\Users\\Mohamed_Wael\\Pictures\\Screenshots\\ip.png"),"2025-04-16","ip");
        gallery.AddImageToGallery("sharm" , "travilling",new File("C:\\Users\\Mohamed_Wael\\Pictures\\Screenshots\\ip.png"),"2025-04-16","ip");
        gallery.AddImageToGallery("sharm" , "person",new File("C:\\Users\\Mohamed_Wael\\Pictures\\Screenshots\\ip.png"),"2025-04-16","ip");
        gallery.AddImageToGallery("cairo" , "person",new File("C:\\Users\\Mohamed_Wael\\Pictures\\Screenshots\\ip.png"),"2025-04-16","ip");
        gallery.AddImageToGallery("giza" , "person",new File("C:\\Users\\Mohamed_Wael\\Pictures\\Screenshots\\ip.png"),"2025-04-16","ip");
        gallery.AddImageToGallery("cairo" , "food",new File("C:\\Users\\Mohamed_Wael\\Pictures\\Screenshots\\ip.png"),"2025-04-16","ip");
        gallery.AddImageToGallery("giza" , "playing",new File("C:\\Users\\Mohamed_Wael\\Pictures\\Screenshots\\ip.png"),"2025-04-16","ip");
        gallery.AddImageToGallery("cairo" , "person",new File("C:\\Users\\Mohamed_Wael\\Pictures\\Screenshots\\ip.png"),"2025-04-16","ip");
        gallery.AddImageToGallery("giza" , "snowing",new File("C:\\Users\\Mohamed_Wael\\Pictures\\Screenshots\\ip.png"),"2025-04-16","ip");
        gallery.AddImageToGallery("cairo" , "person",new File("C:\\Users\\Mohamed_Wael\\Pictures\\Screenshots\\ip.png"),"2025-04-16","ip");

    }

    public GalleryController(Gallery gallery) {
        this.gallery = gallery;
        initData();
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
