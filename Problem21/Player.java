public class Player {
  private int score;
  private int position;

  public Player(int startPosition) {
    score = 0;
    position = startPosition;
  }

  public void move(int roll) {
    position = (position + roll) % 10;
    if (position == 0) position = 10;
  }

  public void addScore() {
    score += position;
  }

  public int getScore() {
    return score;
  }

  public int getPosition() {
    return position;
  }
}
