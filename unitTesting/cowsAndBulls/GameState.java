package unitTesting.cowsAndBulls;

public enum GameState {
  PLAYING("playing"), FINISHED("finished");

  String state;
  GameState(String state){
    this.state = state;
  }
}
