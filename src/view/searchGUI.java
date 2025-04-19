package view;

import javax.swing.*;

import controller.GalleryController;
import core.ImageComponent;
import model.Gallery;
import model.NameImageSearch;
import model.Photo;
import model.SearchType;
import model.TagSearch;
import model.locationSearch;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class searchGUI extends JPanel implements ActionListener {

    private JTextField searchField;
    private JButton searchButton;
    private GalleryController galleryController ;
    private JRadioButton searchByname;
    private JRadioButton seatchByTag;
    private JRadioButton searchByLocation;   
    private SearchType search ; 
    private JPanel resultPanel;

    public searchGUI() {
        initGUI();
    }

    private void initGUI() {
        galleryController = new GalleryController(new Gallery());
        
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20)); 

        JPanel controlPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 20));

        searchField = new JTextField(30);
        searchButton = new JButton("Search");
        
        searchByname = new JRadioButton("search by name");
        searchByLocation = new JRadioButton("search by location");
        seatchByTag = new JRadioButton("search by tag");

        ButtonGroup layouts = new ButtonGroup();
        layouts.add(searchByname);
        layouts.add(seatchByTag);
        layouts.add(searchByLocation);

        searchByname.setSelected(true);

        JPanel radioButtonspanel = new JPanel(); 
        radioButtonspanel.add(searchByname);
        radioButtonspanel.add(seatchByTag);
        radioButtonspanel.add(searchByLocation);
        
        controlPanel.add(new JLabel("Enter search keyword:"));
        controlPanel.add(searchField);
        controlPanel.add(searchButton);
        controlPanel.add(radioButtonspanel);

        add(controlPanel, BorderLayout.NORTH);
         
        resultPanel = new JPanel();
        resultPanel.setLayout(new BorderLayout()); 
        add(resultPanel, BorderLayout.CENTER);

        searchButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ImageComponent images = new ImageComponent(); 
        String keyword = searchField.getText();
       if (seatchByTag.isSelected()) {
        
        search = new TagSearch(); 

       }else if (searchByname.isSelected()){
        
        search = new NameImageSearch(); 

       }else if (searchByLocation.isSelected()){
        
        search = new locationSearch(); 

       }
       List<Photo> photo =  galleryController.searchPhotos(search, keyword);
       System.out.println(photo);
       JPanel newResultPanel = images.uploadImagesPanel(photo,galleryController);
       newResultPanel.setPreferredSize(new Dimension(1200, 400));
       
       resultPanel.removeAll();
       resultPanel.add(newResultPanel, BorderLayout.CENTER);
       resultPanel.revalidate();
       resultPanel.repaint();
    }
}
