
/**
 * Write a description of class Player here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Player
{
    private String name;
    private int score;
    private int guesses;

    /**
     * Constructor for objects of class Player
     */
    public Player()
    {
        name = "";
        score = 0;
        guesses = 0;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String newName)
    {
        name = newName;
    }
    
    public int getScore()
    {
        return score;
    }
    
    public void setScore(int newScore)
    {
        score = newScore;
    }
    
    public int getGuesses()
    {
        return guesses;
    }
    
    public void setGuesses(int newGuess)
    {
        guesses = newGuess;
    }
    
    
}
