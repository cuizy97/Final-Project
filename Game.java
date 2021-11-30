import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
/*
 * @authors Ziyan Cui, Dillon Pearon, and Whenhan Zhu
 * @version 11/30/2021
*/
public class Game implements ActionListener{ 
  JFrame frame;
  JTextField userName;
  JLabel askName;
  JLabel welcome;
  
  // JLabel for category, question text, points worth, and current score
  JLabel categoryLb, questionLb, pointsLb, scoreLb;
  
  // variables used when playing the game to track scoring and traverse our ArrayList
  int currentScore = 0;
  int userAnswer = 0;
  int morePoints = 0;
  int i = -1;

  // Question object in questionList:
  ArrayList<Question> questionList = new ArrayList<Question>();
  String question = "";
  String answerA = "";
  String answerB = "";
  String answerC = "";
  String answerD = "";
  String correctAnswer = "";
  int crAnswer = 0;
  String points = "";
  int pts = 0;
  String category = "";

  //initialize all buttons
  JButton bt1;
  JButton bt2;
  JButton bt3;
  JButton bt4;
  JButton btNext;
  JButton allDone;
  JButton quit;

 /*
  * This class runs our Trivia Game
  * @authors Ziyan Cui, Dillon Pearon, and Whenhan Zhu
  * @version 11/30/2021
  */
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
    
    // font and color for welcome Label
    welcome.setFont(new Font("SanSerif", Font.BOLD, 20));
    welcome.setForeground(Color.RED);
    
    // 4 JButtons each contains one of the options, and a Next button
    bt1 =new JButton("A. ");
    bt2 =new JButton("B. ");
    bt3 =new JButton("C. ");
    bt4 =new JButton("D. ");
    btNext =new JButton("Next Question");
    allDone = new JButton("Done");
    quit = new JButton("Quit");
    
    // font and color for next button
    btNext.setFont(new Font("SanSerif", Font.BOLD, 12));
    btNext.setBackground(Color.WHITE);
    btNext.setForeground(Color.BLUE);
    
    // actionListeners:
    userName.addActionListener(this);
    bt1.addActionListener(this);
    bt2.addActionListener(this);
    bt3.addActionListener(this);
    bt4.addActionListener(this);
    btNext.addActionListener(this);
    allDone.addActionListener(this);
    quit.addActionListener(this);

    //start FileReader try block
    try {
      FileReader file = new FileReader("trivia.txt");
      BufferedReader reader = new BufferedReader(file);
      while(reader.ready()) {
        // read in questions
        question = reader.readLine();
        answerA = reader.readLine();
        answerB = reader.readLine();
        answerC = reader.readLine();
        answerD = reader.readLine();
        correctAnswer = reader.readLine();
        crAnswer = Integer.parseInt(correctAnswer); 
        points = reader.readLine();
        pts = Integer.parseInt(points);
        category = reader.readLine();
        // add questions to questionList
        Question ques = new Question(question, answerA, answerB, answerC, answerD, Integer.parseInt(correctAnswer), Integer.parseInt(points), category);
        questionList.add(ques);
      }
      reader.close(); //close reader
    }

    catch (IOException e) {
      System.out.println("An error occurred: " + e); //IOEXception catch
    }

    // 4 labels to show the question itself, its details, and the score earned
    questionLb = new JLabel("Question:"); 
    categoryLb = new JLabel("Category:");
    pointsLb = new JLabel("Points:");
    scoreLb = new JLabel("Score:");

    // add to frame
    frame.add(askName);
    frame.add(welcome);
    frame.add(userName);

    // have to be displayed from a loop of the questions list
    frame.add(questionLb);
    frame.add(categoryLb);
    frame.add(bt1);
    frame.add(bt2);
    frame.add(bt3);
    frame.add(bt4);
    frame.add(pointsLb);
    frame.add(scoreLb);
    frame.add(btNext);

    // lastly:
    frame.add(allDone); // to get the final result conclusion
    frame.add(quit);

    // Make frame visible
		frame.setVisible(true);	
  }

  /*
   @param The players inputs
  */
  public void actionPerformed(ActionEvent ae) {
    String uName = userName.getText();

    if(!(ae.getActionCommand().equals(""))) { // if userName is not empty
      welcome.setText("Welcome! " + uName); 
    }

    // when click the next button to move to next question
    if (ae.getActionCommand().equals("Next Question")) {
      i++;
      if(i < questionList.size()) {
        questionLb.setText(questionList.get(i).getQuestion());
        categoryLb.setText("Category: " + questionList.get(i).getCategory()); //simply here to show what category the question belongs to
        bt1.setText(questionList.get(i).getAnswerA());
        bt2.setText(questionList.get(i).getAnswerB());
        bt3.setText(questionList.get(i).getAnswerC());
        bt4.setText(questionList.get(i).getAnswerD());
        pointsLb.setText(String.valueOf("Points: " + questionList.get(i).getPoints()));
        scoreLb.setText(String.valueOf("Score:" + currentScore));
      }
      if(i >= questionList.size()-1) { //to show the last question but not allow the user to go to a question that doesn't exist
       questionLb.setText(questionList.get(i).getQuestion());
        categoryLb.setText("Category: " + questionList.get(i).getCategory()); //simply here to show what category the question belongs to
        bt1.setText(questionList.get(i).getAnswerA());
        bt2.setText(questionList.get(i).getAnswerB());
        bt3.setText(questionList.get(i).getAnswerC());
        bt4.setText(questionList.get(i).getAnswerD());
        pointsLb.setText(String.valueOf("Points: " + questionList.get(i).getPoints()));
        scoreLb.setText(String.valueOf("Score:" + currentScore));
        btNext.setVisible(false); // set next button to not visible
      }


      
    }

    //checks if the user chooses the correct answer and adds the appropriate number of points to display their current score
    if (ae.getActionCommand().equals(questionList.get(i).getAnswerA())) {
      userAnswer = 1;
      if (userAnswer == questionList.get(i).getCorrectAnswer()) {
        morePoints = questionList.get(i).getPoints();
        // calculate current score
        currentScore = currentScore + morePoints;
        scoreLb.setText(String.valueOf("Score: " + currentScore));
        
      }
    }

    if (ae.getActionCommand().equals(questionList.get(i).getAnswerB())) {
      userAnswer = 2;
        if (userAnswer == questionList.get(i).getCorrectAnswer()) {
        morePoints = questionList.get(i).getPoints();
        currentScore = currentScore + morePoints;
        // calculate current score
        scoreLb.setText(String.valueOf("Score: " + currentScore));
      }
    }

    if (ae.getActionCommand().equals(questionList.get(i).getAnswerC())) {
      userAnswer = 3;
      if (userAnswer == questionList.get(i).getCorrectAnswer()) {
        morePoints = questionList.get(i).getPoints();
        // calculate current score
        currentScore = currentScore + morePoints;
        scoreLb.setText(String.valueOf("Score: " + currentScore));
      }
    }

    if (ae.getActionCommand().equals(questionList.get(i).getAnswerD())) {
      userAnswer = 4;
      if (userAnswer == questionList.get(i).getCorrectAnswer()) {
        morePoints = questionList.get(i).getPoints();
        // calculate current score
        currentScore = currentScore + morePoints;
        scoreLb.setText(String.valueOf("Score: " + currentScore));
      }
    }

    // when clicked the all done button (game is over)
    if (ae.getActionCommand().equals("Done")){
      pointsLb.setText("Your final score is:");
      scoreLb.setText(String.valueOf(currentScore));

      // Read the file in after finishing the trivia
      // try block:
      try {
        // FileWriter object named fWriter
        FileWriter fWriter = new FileWriter("scores.txt", true); //adding the true allows the file to be appended to instead of being overwritten
        
        // BufferedWriter object named bWriter and uses fWriter:
        BufferedWriter bWriter = new BufferedWriter(fWriter);
        
        // write in the file
        bWriter.write(uName); // adds the players name
        bWriter.newLine();
        bWriter.write(Integer.toString(currentScore)); // adds the final score as a String
        bWriter.newLine();        

        // close the try block and the writer object:
        bWriter.flush();
        bWriter.close();
        
      } 
      catch (IOException e) {
        System.out.println("An error occurred: " + e);
		  }
    }

    // when click on the quit button to end the game
    if (ae.getActionCommand().equals("Quit")) {
      // set the frame to not visible as ending the game
      frame.setVisible(false);	
      // print out user's final score in console
      System.out.println("You have quitted the trivia.\nFinal score: " + currentScore);
    }


  }
}