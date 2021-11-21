import java.util.ArrayList;

class Player {
  private String name;
  private int score;
  private ArrayList<String> playerAnswer;
  private int totalScore;

  // player constructor
  public Player(String aName) {
    this.name = aName;
    this.score = 0;
    this.playerAnswer = new ArrayList<String> ();
    this.totalScore = 0;
  }

  // accessor:
  public String getName() {
    return name;
  }
  public int getScore() {
    return score;
  }
  public void totalScore(int aScore){
    this.totalScore = aScore + this.totalScore;
  }
  public void addPlayerAnswer(String ans) {
    this.playerAnswer.add(ans);
  }



}