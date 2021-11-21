class Question {
  private String question;
  private String answerA;
  private String answerB;
  private String answerC;
  private String answerD;
  private int correctAnswer;
  private int points;
  private String category;
  
  // Question Constructor:
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
  String getQuestion() {
    return question;
  }

  String getAnswerA() {
    return answerA;
  }

  String getAnswerB() {
    return answerB;
  }

  String getAnswerC() {
    return answerC;
  }

  String getAnswerD() {
    return answerD;
  }

  int getCorrectAnswer() {
    return correctAnswer;
  }

  int getPoints() {
    return points;
  }

  String getCategory() {
    return category;
  }
}


  