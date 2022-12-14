/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;


import compressordecompressor.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.plaf.ColorUIResource;

/**
 *
 * @author abhijeet
 */
public class AppFrame extends JFrame implements ActionListener{
    
    JButton compressButton;
    JLabel background;
    JButton decompressButton;
    
    AppFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Hey! Let's save memory");
        this.setLayout(null);
        
        this.setResizable(true);
        this.setSize(600,600);
        this.setVisible(true);

        ImageIcon img=new ImageIcon("muskk.jpg");
        background =new JLabel("",img,JLabel.CENTER);
        background.setBounds(0,0,600,600);
        
        compressButton=new JButton("Select file to compress");
        compressButton.addActionListener(this);
        compressButton.setBounds(20,100,200,30);
        compressButton.setBackground(Color.yellow);
        
        decompressButton=new JButton("Select file to decpmpress");
        decompressButton.addActionListener(this);
        decompressButton.setBounds(250,100,200,30);
        decompressButton.setBackground(new Color(218,109,85));
        
        this.add(background);
        background.add(compressButton);
        background.add(decompressButton);
        //this.setSize(500,200);
      //  this.getContentPane().setBackground(Color.green);
        
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==compressButton){
            JFileChooser filechooser=new JFileChooser();
            int response=filechooser.showSaveDialog(null);
            
            if(response==JFileChooser.APPROVE_OPTION){
                File file = new File(filechooser.getSelectedFile().getAbsolutePath());
                System.out.println(file);
                try{
                    compressor.method(file);
                    
                }
                catch(Exception excp){
                    JOptionPane.showMessageDialog(null, excp.toString());
                    
                }
            }            
        }
        if(e.getSource()==decompressButton){
            JFileChooser filechooser=new JFileChooser();
            int response=filechooser.showSaveDialog(null);
            
            if(response==JFileChooser.APPROVE_OPTION){
                File file = new File(filechooser.getSelectedFile().getAbsolutePath());
                System.out.println(file);
                try{
                    decompressor.method(file);
                    
                }
                catch(Exception excp){
                    JOptionPane.showMessageDialog(null, excp.toString());
                    
                }
            }
            
        }
    }
}
