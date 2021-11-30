/*
 * This class runs our Trivia Game
 * @authors Ziyan Cui, Dillon Pearon, and Whenhan Zhu
 * @version 11/30/2021
*/
class Question {
  private String question;
  private String answerA;
  private String answerB;
  private String answerC;
  private String answerD;
  private int correctAnswer;
  private int points;
  private String category;
  
  /* 
   * Question Constructor
   * @param all information about the question
  */
  Question(String aQuestion, String aAnswerA, String aAnswerB, String aAnswerC, String aAnswerD, int aCorrectAnswer, int aPoints, String aCategory) {
    question = aQuestion;
    answerA = aAnswerA;
    answerB = aAnswerB;
    answerC = aAnswerC;
    answerD = aAnswerD;
    correctAnswer = aCorrectAnswer;
    points  = aPoints;
    category = aCategory;
  }

  // accessor getter methods we will use to write our file
  /* 
   * @return the question as a String
  */
  String getQuestion() {
    return question;
  }

  /* 
  * @return the A choice as a String
  */
  String getAnswerA() {
    return answerA;
  }

  /* 
  * @return the B choice as a String
  */
  String getAnswerB() {
    return answerB;
  }

  /* 
  * @return the C choice as a String
  */
  String getAnswerC() {
    return answerC;
  }

  /* 
  * @return the D choice as a String
  */
  String getAnswerD() {
    return answerD;
  }

  /* 
  * @return which answer is correct as an int
  */
  int getCorrectAnswer() {
    return correctAnswer;
  }

  /* 
  * @return points the question is worth as an int
  */
  int getPoints() {
    return points;
  }

  /* 
  * @return the category of the question as a String
  */
  String getCategory() {
    return category;
  }
}


  