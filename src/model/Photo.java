package model ; 

import java.io.File;

public class Photo {
    
    private String tag ; 
    private int id ; 
    private String date ; 
    private String location;
    private String imageName ;
    private File file;



    public Photo(File file ,String tag, String date, String location, String image ,int id  ) {
        this.file = file ; 
        this.tag = tag;
        this.date = date;
        this.location = location;
        this.imageName = image;
        this.id =id ; 
    }

    public File getFile() {
        return file;
    }

    public int getId() {
        return id;
    }
    public String getTag() {
        return tag;
    }
    public String getDate() {
        return date;
    }
    public String getLocation() {
        return location;
    }
    public String getImage() {
        return imageName;
    }


}