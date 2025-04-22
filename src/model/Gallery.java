package model ;

import java.io.File;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Gallery {
    private static Gallery instance;

    private Map<Integer,Photo> allphotos = new HashMap<>();
    private static int idCounter = 0; 
    private Set<String> tagsPhoto =new LinkedHashSet<>();
    private Set<String> locationPhoto = new LinkedHashSet<>();
    

    public static Gallery getInstance() {
        if (instance == null) {
            instance = new Gallery();
        }
        return instance;
    }


    private void initData(){
        AddImageToGallery("cairo" , "person",new File("C:\\Users\\Mohamed_Wael\\Pictures\\Screenshots\\ip.png"),"2025-04-16","ip");
        AddImageToGallery("alex" , "person",new File("C:\\Users\\Mohamed_Wael\\Pictures\\Screenshots\\Screenshot (1).png"),"2025-04-16","Screenshot (1).png");

        AddImageToGallery("alex" , "person",new File("C:\\Users\\Mohamed_Wael\\Pictures\\Screenshots\\ip.png"),"2025-04-16","ip");

        AddImageToGallery("alex" , "person",new File("C:\\Users\\Mohamed_Wael\\Pictures\\Screenshots\\ip.png"),"2025-04-16","ip");
        AddImageToGallery("port" , "beach",new File("C:\\Users\\Mohamed_Wael\\Pictures\\Screenshots\\ip.png"),"2025-04-16","ip");
        AddImageToGallery("port" , "skit",new File("C:\\Users\\Mohamed_Wael\\Pictures\\Screenshots\\ip.png"),"2025-04-16","ip");
        AddImageToGallery("port" , "nature",new File("C:\\Users\\Mohamed_Wael\\Pictures\\Screenshots\\ip.png"),"2025-04-16","ip");
        AddImageToGallery("port" , "sports",new File("C:\\Users\\Mohamed_Wael\\Pictures\\Screenshots\\ip.png"),"2025-04-16","ip");
        AddImageToGallery("sharm" , "person",new File("C:\\Users\\Mohamed_Wael\\Pictures\\Screenshots\\ip.png"),"2025-04-16","ip");
        AddImageToGallery("sharm" , "travilling",new File("C:\\Users\\Mohamed_Wael\\Pictures\\Screenshots\\ip.png"),"2025-04-16","ip");
        AddImageToGallery("sharm" , "person",new File("C:\\Users\\Mohamed_Wael\\Pictures\\Screenshots\\ip.png"),"2025-04-16","ip");
        AddImageToGallery("cairo" , "person",new File("C:\\Users\\Mohamed_Wael\\Pictures\\Screenshots\\ip.png"),"2025-04-16","ip");
        AddImageToGallery("giza" , "person",new File("C:\\Users\\Mohamed_Wael\\Pictures\\Screenshots\\ip.png"),"2025-04-16","ip");
        AddImageToGallery("cairo" , "food",new File("C:\\Users\\Mohamed_Wael\\Pictures\\Screenshots\\ip.png"),"2025-04-16","ip");
        AddImageToGallery("giza" , "playing",new File("C:\\Users\\Mohamed_Wael\\Pictures\\Screenshots\\ip.png"),"2025-04-16","ip");
        AddImageToGallery("cairo" , "person",new File("C:\\Users\\Mohamed_Wael\\Pictures\\Screenshots\\ip.png"),"2025-04-16","ip");
        AddImageToGallery("giza" , "snowing",new File("C:\\Users\\Mohamed_Wael\\Pictures\\Screenshots\\ip.png"),"2025-04-16","ip");
        AddImageToGallery("cairo" , "person",new File("C:\\Users\\Mohamed_Wael\\Pictures\\Screenshots\\ip.png"),"2025-04-16","ip");

    }

    public Gallery(){
        initData();        
        updateTags(); 
        updateLocation(); 
    }

    private void updateTags(){
        tagsPhoto.clear();
        tagsPhoto.addAll(allphotos.values().stream().map(Photo::getTag).collect(Collectors.toSet()));
    }

    private void updateLocation(){
        locationPhoto.clear();
        locationPhoto.addAll(allphotos.values().stream().map(Photo::getLocation).collect(Collectors.toSet()));
    }

    public Set<String> getTags(){
        return tagsPhoto ; 
    }

    public List<Photo> getPhotoByTag(String tag){
        return allphotos.values().stream().filter(i -> (i.getTag().equals(tag))).collect(Collectors.toList());
    }

    public List<Photo> getPhotoByLocation(String location){
        return allphotos.values().stream().filter(i -> (i.getLocation().equals(location))).collect(Collectors.toList());
        
    }



    public Set<String> getLocation(){
        return locationPhoto; 
    }

    public void AddImageToGallery(String location , String tag ,File file , String date ,String imageName){
        allphotos.put(++idCounter , new Photo(file,tag, date, location, imageName,idCounter)); 
        updateTags(); 
        updateLocation(); 
    }

    public void deleteImageFromGallery(int id){
        allphotos.remove(id);
        updateTags(); 
        updateLocation(); 
    }

    public List<Photo> searchImage (SearchType searchType , String query){
       
        return searchType.getImages(getAllImages(), query); 
    }

   

    public List<Photo> getAllImages (){
        return allphotos.values().stream().collect(Collectors.toList());
    }

    
}
