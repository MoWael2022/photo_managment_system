// package view ;

// import java.awt.Font;

// import javax.swing.ButtonGroup;
// import javax.swing.JPanel;
// import javax.swing.JRadioButton;

// import core.Constant;

// public class RadioButtons extends JPanel{
// private JPanel ratioButtons(){

//     JRadioButton allImageButton = new JRadioButton("all Image");
//     JRadioButton tagImageButton =new JRadioButton("tag Image");
//     JRadioButton locationButton =new JRadioButton("locations Image");

//     Font radioFont = new Font("Arial", Font.PLAIN, 18); 
//     allImageButton.setFont(radioFont);
//     tagImageButton.setFont(radioFont);
//     locationButton.setFont(radioFont);

//     ButtonGroup layouts = new ButtonGroup();
//     layouts.add(allImageButton);
//     layouts.add(tagImageButton);
//     layouts.add(locationButton);
    
//     allImageButton.setSelected(true);

//     allImageButton.addActionListener(this);
//     tagImageButton.addActionListener(this);
//     locationButton.addActionListener(this);

//     allImageButton.setActionCommand(Constant.allImage);
//     tagImageButton.setActionCommand(Constant.tagImage);
//     locationButton.setActionCommand(Constant.locationImage);

//     JPanel radioJPanel = new JPanel();
//     radioJPanel.add(allImageButton);
//     radioJPanel.add(tagImageButton);    
//     radioJPanel.add(locationButton);

//     return radioJPanel;

// }
// }