package view ;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import controller.GalleryController;
import core.Constant;
import core.ImageComponent;
import core.GalleryViewUpdater;
import model.Photo;

public class LocationImages extends ImagePanel {

    private ImageComponent functions = new ImageComponent(); 
    CardLayout cardLayout = new CardLayout(); 
    JPanel cardJPanel = new JPanel(cardLayout);
    JPanel mainView = new JPanel(); 
    public LocationImages(GalleryController galleryController , GalleryViewUpdater galleryViewUpdater ) {
        super(galleryController, galleryViewUpdater);
        this.galleryController = galleryController;
        
        mainView = locationImages();
        
        cardJPanel.add(mainView , "main"); 
        
        setLayout(new BorderLayout());
        add(cardJPanel , BorderLayout.CENTER);
        
    }

    @Override
    public void refreshImagePanel() {

        mainView = locationImages();
        cardJPanel.removeAll();
        cardJPanel.add(mainView,"main");
        cardLayout.show(cardJPanel, "main");
        revalidate(); 
        repaint();    
    }

    @Override
    public JPanel panelLayout() {
     return this ;   
    }

    private JPanel locationImages(){
        double row = (double) galleryController.getAllLocations().size() / 4.0f; 
    row = Math.ceil(row); 
    Font textFont = new Font("Arial", Font.PLAIN, 28); 
    JPanel panel = new JPanel(new GridLayout((int) row , 4, 10, 10));
    panel.setBackground(Color.lightGray);

    for (String location : galleryController.getAllLocations()) {
        JButton locationButton = new JButton(location);
        locationButton.setPreferredSize(new Dimension(270 ,270));
        locationButton.setContentAreaFilled(false); 
        locationButton.setFont(textFont);

        locationButton.addActionListener(_ -> {
            JPanel tagPanel = locationImages(location);
            String tagKey = "LOCATION_" + location;
        
            cardJPanel.add(tagPanel, tagKey);
            cardLayout.show(cardJPanel, tagKey);
            
        });

        panel.add(locationButton);
    }
    JScrollPane scrollPane = new JScrollPane(panel , JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED , JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    scrollPane.setPreferredSize(new Dimension(380, 300)); 

    JPanel wrapper = new JPanel(new BorderLayout());
    wrapper.add(scrollPane, BorderLayout.CENTER);

    return wrapper;

    }

    private JPanel locationImages(String location){
         List<Photo> photos = galleryController.getPhotosByLocation(location);
       
        return functions.uploadImagesPanel(photos ,galleryController);
    }

    @Override
    public String getViewKey() {
        return Constant.locationImage; 
    }

}