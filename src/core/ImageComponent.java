package core ;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import controller.GalleryController;
import model.Photo;

public class ImageComponent extends MouseAdapter{

    

    public JPanel uploadImagesPanel(List<Photo> images ,GalleryController galleryController ){
        double row = (double) images.size() / 4.0f; 
        row = Math.ceil(row); 
        JPanel panel = new JPanel(new GridLayout((int) row , 4, 10, 10)); 
        panel.setBackground(Color.lightGray);
        for(Photo photo : images){
            File imageFile = photo.getFile();
            ImageIcon imageIcon = new ImageIcon(imageFile.getAbsolutePath());
            Image scImage = imageIcon.getImage().getScaledInstance(270, 270, JFrame.DO_NOTHING_ON_CLOSE);
            imageIcon = new ImageIcon(scImage);

            JLabel imageLabel = new JLabel(imageIcon);
           

        imageLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                showImageDialog( panel, imageLabel , photo ,galleryController);
            }
        });

            panel.add(imageLabel);
    }

    JScrollPane scrollPane = new JScrollPane(panel , JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED , JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    scrollPane.setPreferredSize(new Dimension(380, 300)); 
    

    JPanel wrapper = new JPanel(new BorderLayout());
    wrapper.add(scrollPane, BorderLayout.CENTER);


    return wrapper;
    }


    private void showImageDialog(JPanel iamge , JLabel label , Photo originalPhoto ,GalleryController gallerycController){
        JDialog jDialog = new JDialog();
        jDialog.setTitle("Image");

    
        jDialog.setSize(400, 450);
        jDialog.setLocationRelativeTo(null);

        ImageIcon imageIcon = new ImageIcon(originalPhoto.getFile().getAbsolutePath());
        Image photo = imageIcon.getImage().getScaledInstance(350, 350, Image.SCALE_SMOOTH) ;
        JLabel imageDisplay = new JLabel(new ImageIcon(photo));
        imageDisplay.setHorizontalAlignment(SwingConstants.CENTER);


        JButton exitButton = new JButton("Exit"); 
        exitButton.addActionListener(_ -> {
            jDialog.dispose(); 
        });


        JButton deleteButton = new JButton("Delete"); 
        deleteButton.addActionListener(_ -> {
            gallerycController.deleteImage(originalPhoto.getId());
            jDialog.dispose(); 
        });

        JPanel buttons = new JPanel();
        buttons.add(exitButton); 
        buttons.add(deleteButton);


        jDialog.setLayout(new BorderLayout());
        jDialog.add(imageDisplay, BorderLayout.CENTER);
        jDialog.add(buttons, BorderLayout.SOUTH);

        jDialog.setVisible(true);

    }
}

