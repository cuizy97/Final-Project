import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class Game implements ActionListener{ 
  JFrame frame;
  JTextField userName;
  JLabel askName;
  JLabel welcome;
  // JLable for category, question text, points worth, and current score
  JLabel categoryLb, questionLb, pointsLb, scoreLb;
  // Question object in questionList:
  ArrayList<Question> questionList = new ArrayList<Question>();
  String question = "";
  String answerA = "";
  String answerB = "";
  String answerC = "";
  String answerD = "";
  String correctAnswer = "";
  String points = "";
  String category = "";

  JButton bt1;
  JButton bt2;
  JButton bt3;
  JButton bt4;
  JButton btNext;

  public Game() {
    // JFrame with title
    frame = new JFrame ("Group #7's Trivia Game");
    frame.setLayout(new FlowLayout());
    frame.setSize(500, 500);
    // JLabel welcoming the user: 
    userName = new JTextField(20); // JTextField for username
    userName.setActionCommand("myTF");    
    askName = new JLabel("Please enter your name: ");
    welcome = new JLabel("Welcome! ");
    // 4 JButtons each contains one of the options, and a Next button
    bt1 =new JButton("A. ");
    bt2 =new JButton("B. ");
    bt3 =new JButton("C. ");
    bt4 =new JButton("D. ");
    btNext =new JButton("Next Question");
    // actionListeners:
    userName.addActionListener(this);
    bt1.addActionListener(this);
    bt2.addActionListener(this);
    bt3.addActionListener(this);
    bt4.addActionListener(this);
    btNext.addActionListener(this);

    try {
      FileReader file = new FileReader("trivia.txt");
      BufferedReader reader = new BufferedReader(file);
      while(reader.ready()) {
        question = reader.readLine();
        answerA = reader.readLine();
        answerB = reader.readLine();
        answerC = reader.readLine();
        answerD = reader.readLine();
        correctAnswer = reader.readLine();
        points = reader.readLine();
        category = reader.readLine();
      }
      reader.close();
    }
    catch (IOException e) {
      System.out.println("An error occurred: " + e);
    }

/*


*/


    // add to frame
    frame.add(askName);
    frame.add(userName);
    frame.add(welcome);
    frame.add(question);
    frame.add(bt1);
    frame.add(bt2);
    frame.add(bt3);
    frame.add(bt4);
    frame.add(btNext);



    // GUI settings: 


  }



  public void actionPerformed(ActionEvent ae) {
    if(!(ae.getActionCommand().equals(""))){
      String uName = userName.getText();
      welcome.setText("Welcome! " + uName); 
    }


  }




}