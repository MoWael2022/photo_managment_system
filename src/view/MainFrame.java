package view;

import model.Gallery;
import java.awt.BorderLayout;
import java.awt.CardLayout;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;


import controller.GalleryController;
import core.Constant;
import core.GalleryObserver;
import core.GalleryViewUpdater;

public class MainFrame extends JFrame implements GalleryObserver ,GalleryViewUpdater{

    private CardLayout cardLayout = new CardLayout(); 
    private JPanel cardPanel = new JPanel(cardLayout);
    private AllImagePanel allImage ; 
    private TagImage tagImage; 
    private LocationImages locationImages;
    private GalleryController galleryController; 

    private JTabbedPane tabbedPane;

 public MainFrame(){
    
    galleryController = new GalleryController(new Gallery()); 
    galleryController.addObserver(this);
    initGUI(); 
    
 }

private void initGUI() {
    
     tabbedPane = new JTabbedPane();
    
    
    allImage = new AllImagePanel(galleryController, this);
    tagImage = new TagImage(galleryController, this);
    locationImages = new LocationImages(galleryController, this);
    
    
    tabbedPane.addTab("All Images", allImage);
    tabbedPane.addTab("Tags", tagImage);
    tabbedPane.addTab("Locations", locationImages);

    tabbedPane.addChangeListener(_ -> {
        refreshCurrentTab();
    });
    
    
    JPanel headerPanel = new headerGUI().header(galleryController, this);

    JPanel galleryContentView = new JPanel(new BorderLayout());
    galleryContentView.add(tabbedPane,BorderLayout.CENTER);
    cardPanel.add(galleryContentView, Constant.galleryView);
    cardPanel.add(new searchGUI(),Constant.searchView); 
    
    
   
    JPanel mainPanel = new JPanel(new BorderLayout());
    mainPanel.add(headerPanel, BorderLayout.NORTH);
    mainPanel.add(cardPanel, BorderLayout.CENTER);
    
    

   
    setTitle("Gallery");
    setContentPane(mainPanel);
    setSize(1500, 700);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setVisible(true);

    cardLayout.show(cardPanel, Constant.galleryView);
}

private void refreshCurrentTab() {
    int selectedIndex = tabbedPane.getSelectedIndex();
    if (selectedIndex == 0) {
        allImage.refreshImagePanel();
    } else if (selectedIndex == 1) {
        tagImage.refreshImagePanel();
    } else if (selectedIndex == 2) {
        locationImages.refreshImagePanel();
    }
}
 @Override
 public void RefreshAllImage() {
    allImage.refreshImagePanel();
    tagImage.refreshImagePanel();
    locationImages.refreshImagePanel();
 }

 @Override
 public void showView(String viewName) {
    cardLayout.show(cardPanel, viewName);

 }

 @Override
 public void onGalleryChanged() {
    RefreshAllImage(); 
 }
}