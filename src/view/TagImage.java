package view; 

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
import model.Photo;
import core.ImageComponent;
import core.GalleryViewUpdater;


public class TagImage extends ImagePanel{
    private ImageComponent functions = new ImageComponent(); 
    private CardLayout cardLayout = new CardLayout();
    private JPanel cardPanel = new JPanel(cardLayout);
    private JPanel maiView; 

    
    public TagImage(GalleryController galleryController , GalleryViewUpdater galleryViewUpdater ) {
        super(galleryController, galleryViewUpdater);
        this.galleryController = galleryController; 

        maiView = tagImage();

        cardPanel.add(maiView, "main");

        setLayout(new BorderLayout());
        add(cardPanel,BorderLayout.CENTER);


    }

    @Override
    public void refreshImagePanel() {
        
        maiView = tagImage(); 
        cardPanel.removeAll();
        cardPanel.add(maiView,"main");
        cardLayout.show(cardPanel, "main");

        revalidate(); 
        repaint();   

    }

    @Override
    public JPanel panelLayout() {
        return this; 
    }

    private JPanel tagImage(){
        double row = (double) galleryController.getAllTags().size() / 4.0f; 
        row = Math.ceil(row); 
        Font textFont = new Font("Arial", Font.PLAIN, 28); 
        JPanel panel = new JPanel(new GridLayout((int) row , 4, 10, 10));
        panel.setBackground(Color.lightGray);
    
        for (String tag : galleryController.getAllTags()) {
            JButton tagButton = new JButton(tag);
            tagButton.setPreferredSize(new Dimension(270 ,270));
            tagButton.setContentAreaFilled(false); 
            tagButton.setFont(textFont);
    
            tagButton.addActionListener(_ -> {
                JPanel tagPanel = tagImages(tag);
                String tagKey = "TAG_" + tag;
            
                cardPanel.add(tagPanel, tagKey);
                cardLayout.show(cardPanel, tagKey);
                
             });
    
            panel.add(tagButton);
        }
        JScrollPane scrollPane = new JScrollPane(panel , JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED , JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setPreferredSize(new Dimension(380, 300)); 
    
        JPanel wrapper = new JPanel(new BorderLayout());
        wrapper.add(scrollPane, BorderLayout.CENTER);
    
        return wrapper;
    }

    private JPanel tagImages(String tag){

        List<Photo> photos = galleryController.getPhotosByTag(tag);
       
        return functions.uploadImagesPanel(photos,galleryController);
    }

    @Override
    public String getViewKey() {
       return Constant.tagImage; 
    }
}