package view ;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import controller.GalleryController;
import core.Constant;
import core.ImageComponent;
import core.GalleryViewUpdater;

public class AllImagePanel extends ImagePanel{

    public AllImagePanel(GalleryController gallerycController, GalleryViewUpdater  galleryViewUpdater) {
       super(gallerycController, galleryViewUpdater);
       this.galleryController = gallerycController; 
       refreshImagePanel();
    }

    @Override
    public void refreshImagePanel() {
     removeAll();  
     add(panelLayout(), BorderLayout.CENTER);
     revalidate(); 
     repaint();    
    }

    @Override
    public JPanel panelLayout() {
       ImageComponent functions = new ImageComponent();
       System.out.println(galleryController.getAllPhotos());
       return functions.uploadImagesPanel(galleryController.getAllPhotos(), galleryController);
     
    }

    @Override
    public String getViewKey() {
        return Constant.allImage; 
    }
}