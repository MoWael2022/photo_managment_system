package view ;


import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;


import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.border.EmptyBorder;

import controller.GalleryController;
import core.Constant;
import core.GalleryViewUpdater;



public class headerGUI extends JFrame{


@SuppressWarnings("unused")
public JPanel header(GalleryController gallerycController,GalleryViewUpdater galleryViewUpdater){

    JButton addImagebutton = new JButton("Add Image");
    JButton searchImagebutton = new JButton("search Image");
    JButton galleryViewbutton = new JButton("Gallery View");
    JLabel label = new JLabel("Gallery", JLabel.CENTER);

    
    JPanel topPanel = new JPanel(new BorderLayout());
    topPanel.setBorder(new EmptyBorder(20, 15, 20, 15));

    JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
    buttonsPanel.add(addImagebutton);
    buttonsPanel.add(searchImagebutton);
    buttonsPanel.add(galleryViewbutton);
    Dimension buttonSize = new Dimension(120, 40);

    addImagebutton.setPreferredSize(buttonSize); 
    addImagebutton.setBackground(Color.BLUE);
    addImagebutton.setForeground(Color.BLACK);
    addImagebutton.setContentAreaFilled(false);  

    searchImagebutton.setPreferredSize(buttonSize); 
    searchImagebutton.setBackground(Color.BLUE);
    searchImagebutton.setForeground(Color.BLACK);
    searchImagebutton.setContentAreaFilled(false);  

    galleryViewbutton.setPreferredSize(buttonSize); 
    galleryViewbutton.setBackground(Color.BLUE);
    galleryViewbutton.setForeground(Color.BLACK);
    galleryViewbutton.setContentAreaFilled(false);  
    
    label.setHorizontalAlignment(JLabel.CENTER);

    label.setFont(new Font("Arial", Font.BOLD, 24));

   
    topPanel.add(buttonsPanel, BorderLayout.WEST);
    topPanel.add(label, BorderLayout.CENTER);

    addImagebutton.addActionListener(e -> {
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            gallerycController.addImageAction(fileChooser.getSelectedFile());
            galleryViewUpdater.showView(Constant.allImage);
        }
    });

    searchImagebutton.addActionListener(_ -> {
        galleryViewUpdater.showView(Constant.searchView);
       

        
    });

    galleryViewbutton.addActionListener(_ -> {
        galleryViewUpdater.RefreshAllImage();
        galleryViewUpdater.showView(Constant.galleryView);
    });


    return topPanel; 
}





}