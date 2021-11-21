import java.awt.*; 
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

//public class Game implements ActionListener{ 
  class Game{
    // JFrame with title
    JFrame jfTitle = new JFrame ("Group #7's Trivia Game");
    jfTitle.setLayout(new FlowLayout());
    jfTitle.setSize(500, 500);    
    // JLabel welcoming the user: 
    JTextField userName = new JTextField(20); // JTextField for username
    userName.setActionCommand("myTF");    
    JLabel askName = new JLabel("Please enter your name: ");
    JLabel welcome = new JLabel("Welcome! " + askName);
    // JLable for category, question text, points worth, and current score
    JLabel category, question, points, score;
    // 4 JButtons each contains one of the options, and a Next button
    JButton bt1 =new JButton("A. ");
    JButton bt2 =new JButton("B. ");
    JButton bt3 =new JButton("C. ");
    JButton bt4 =new JButton("D. ");
    JButton btNext =new JButton("Next Question");
    // actionListeners for buttons:


    // GUI settings: 


    Next.addActionListener(this);
    Q1.addActionListener(this);
    Q2.addActionListener(this);
    Q3.addActionListener(this);
    Q4.addActionListener(this);

  }

//}