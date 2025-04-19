package view ;

import java.awt.BorderLayout;


import javax.swing.JPanel;

import controller.GalleryController;

import core.GalleryViewUpdater;

public abstract class ImagePanel extends JPanel{

    protected GalleryController galleryController ; 
    protected GalleryViewUpdater galleryViewUpdater; 


    public ImagePanel(GalleryController galleryController, GalleryViewUpdater galleryViewUpdater) {
        super(new BorderLayout());
        this.galleryController = galleryController; 
        this.galleryViewUpdater = galleryViewUpdater; 

    }

    public abstract void refreshImagePanel(); 

    public abstract JPanel panelLayout();

    public abstract String getViewKey();


}



