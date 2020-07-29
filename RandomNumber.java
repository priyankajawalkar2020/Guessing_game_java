
/**
 * Write a description of class RandomNumber here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Random;
public class RandomNumber
{
  private int guessNoGame;
    
  
  public RandomNumber()
  {
      guessNoGame=0;
  }
  
  public int getGuessNoGame()
    {
        return  guessNoGame;
    }
    
    public void setGuessNoGame(int newGuess)
    {
       guessNoGame = newGuess;
    }
  
  public int randomPlayer()
  {
    int x = (int) Math.round(Math.random());
    return x;
  } 
  
  public int randomGuessNumber(int min,int max)
  {
    Random r =new Random();
   int guessdno =r.nextInt(max - min + 1) + min;
   return guessdno;
  }
  
  
    

  
    
  
    
}
