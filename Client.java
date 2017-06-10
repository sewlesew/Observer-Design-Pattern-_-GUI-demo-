/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Observer;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author USER
 */
public class Client extends JFrame implements ActionListener{
    
    JPanel contents;
    JTextField addText,removeText;
    JButton addBut,removeBut;
    Box vbox;
    Box hbox,hbox2;
    JPanel northPanel;
    JTextArea textarea;
    Subject subject;
    Observer observer;
     JLabel label;
   public  Client(){
       
       contents=new JPanel();
       contents.setLayout(new BorderLayout());
       this.add(contents);
       
       vbox=Box.createVerticalBox();
       hbox=Box.createHorizontalBox();
       hbox2=Box.createHorizontalBox();
       
       addBut=new JButton("Add");
       
       removeBut=new JButton("Remove");
      Dimension addButDim=removeBut.getPreferredSize();
      addBut.setPreferredSize(addButDim);
      
      addText=new JTextField(10);
      removeText=new JTextField(10);
      
      hbox.add(addText);
      hbox.add(addBut);
      hbox.setAlignmentX(LEFT_ALIGNMENT);   
      
      hbox2.add(removeText);
      hbox2.add(removeBut);
      hbox2.setAlignmentX(LEFT_ALIGNMENT);  
      
      
      vbox.add(hbox);
      vbox.add(hbox2);
      
      northPanel=new JPanel();
      
      northPanel.add(vbox);
     
      
      
      textarea=new JTextArea(20,20);
      
       northPanel.add(textarea);
       label=new JLabel("Observer Design Pattern",SwingConstants.CENTER);
       label.setFont(new Font(Font.DIALOG,Font.BOLD,19));
       
       contents.add(label,BorderLayout.NORTH);
      contents.add(northPanel,BorderLayout.CENTER);
      
      subject=new Subject();
      observer=new Observer(subject);
      
      addBut.addActionListener(this);
      removeBut.addActionListener(this);     
    
      setSize(500,400);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setResizable(false);
      setVisible(true);
      
      
      
       
       
       
       
        
    }
   
    public static void main(String[] args){
        new Client();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        Object source=ae.getSource();
        
        if(source==addBut){
            String takeText=addText.getText();
            subject.setNames(takeText);             
              String allNames="";
                   for(String str:observer.getNames()){
                       allNames+=str+"\n";                  
                      
                   }
                     addText.setText("");
                     textarea.setText(allNames);
                     return;                    
        }
        
        if(source==removeBut){
            String removedText=removeText.getText();            
            subject.removeName(removedText);
            
                      
              String allNames="";
                   for(String str:observer.getNames()){
                       allNames+=str+"\n";                                    
                   }
                   removeText.setText("");
                   textarea.setText(allNames);
                   
            
        }

    }
    
    
    
}
