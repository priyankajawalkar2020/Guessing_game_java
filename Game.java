
/**
 * Write a description of class Game here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;
public class Game
{
    // instance variables - replace the example below with your own
    Player human;
    Player computer;
    
    private int playerGuess,compGuess;
    
    public Game()
    {
        // initialise instance variables
        human = new Player();
        computer = new Player();
        
        
    }
    
    Scanner s = new Scanner(System.in);
    RandomNumber man = new RandomNumber();
    
    public void displayGamemsg()
    {
       System.out.println("------welcome to Gue55ing game----");
        
    }
    
    public void displayName()
    {
        String playerName;
        System.out.println("Please enter your name :-");
        playerName = s.nextLine();
        if(playerName.length() > 8 || playerName.contains(" ") || playerName==null || "".equals(playerName))
            { 
                 System.out.println("----------------Warning-----------------");
                 System.out.println("Name should not contains spaces, It should be less than 8 character and no blank input too");
                 System.out.println("-----------Re-enter your Name---------");
                 displayName();
            }
            else
            {
               String pName = playerName.trim();
               human.setName(pName);
            }
        
    }
    
    public void displayHumanGuess()
    {
        String playerGuess;
        System.out.println("Player enter your guess :");
        playerGuess = s.nextLine();
        String check = "\\d+";
        if(playerGuess==null || "".equals(playerGuess) || !playerGuess.matches(check))
        {
            System.out.println("Please enter only numbers not alphabates or blank values ");
            displayHumanGuess();
        }
        
        else if(Integer.parseInt(playerGuess) <1 || (Integer.parseInt(playerGuess)>100) && (Integer.parseInt(playerGuess)!= 999))
        {
            System.out.println("Please enter no in between 1 to 100 ");
            
        }
        else
       
        {
            human.setGuesses(Integer.parseInt(playerGuess));
            
        }
        
    }
    
    public boolean compareGuess(int guess)
    {
      if(guess == man.getGuessNoGame())
            return true;
      else
            return false;
    }
     
    public void humRange(int min,int max)
    {
        if(human.getGuesses() < man.getGuessNoGame())
              {
                min= human.getGuesses()+1;
                System.out.println("Your guess is lower than hidden number!!!");
                System.out.println("Hidden number is in between " + min + " to " + max );
              }
        else if(human.getGuesses() > man.getGuessNoGame())
              {
                max =  human.getGuesses()-1;
                System.out.println("Your guess is greater than hidden number!!!");
                System.out.println("Hidden number is in between " + min + " to " + max );
            }    
                                 
    }
    
    public void compRange(int min,int max)
    {
         if(computer.getGuesses() < man.getGuessNoGame())
                  {
                      min= computer.getGuesses()+1;
                      System.out.println("Your guess is lower than hidden number");
                      System.out.println("Hidden number is in between " + min + " to " + max );
                  }

                  else if(computer.getGuesses() > man.getGuessNoGame())
                  {
                      max =  computer.getGuesses()-1;
                      System.out.println("Your guess is greater than hidden number");
                      System.out.println("Hidden number is in between " + min + " to " + max );
                  }  
                  
    }
    
    public int scoreOne(int guessCounter)
    {
       int score = 0;
       switch(guessCounter)
       {
           case 1 :
           score += 20;
           break;
           
           case 2 : 
           score += 15;
           break;
           
           case 3 : 
           score += 11;
           break;
           
           case 4 : 
           score += 8;
           break;
           
           case 5 : 
           score += 6;
           break;
           
           case 6 : 
           score += 5;
           break;
       }
        
        return score;
    }
    
    

    public void gamePlayStarts()
    {
        displayGamemsg();
        displayName();
        System.out.println( "Welcome to the Game " + human.getName()+" !!");
        int min;
        int max;
        int generateCounter;
        for(int k = 1;k < 5; k++)
        {
         int abandonIndic = man.randomGuessNumber(1,20); 
         System.out.println("This is round " + k + " out of 4");
         min =1;
         max=100;
         generateCounter=0;
         int humanRoundScore = 0;
         int compRoundScore = 0;
         man.setGuessNoGame(man.randomGuessNumber(min,max));
         int x = man.randomPlayer();
        
            if(x==1)
               {
                 System.out.println("--Player will start this round--");
                        for(int i = 0 ; i < 3; i++)
                         {
                             displayHumanGuess();
                             generateCounter++;
                             if(compareGuess(human.getGuesses()))//to do - calculate score
                             { 
                                 human.setScore(scoreOne(generateCounter));
                                 break;
                             }
              
                             else if ( human.getGuesses()== 999 )//to do calculate score
                             {
                                 break;
                             }
                             else
                             {
                                 
                                 humRange(min,max);
                                 
                                 
                             }   
                  
                        System.out.println("Computer Enter your guess :");
                        computer.setGuesses( man.randomGuessNumber(min,max));
                        System.out.println(computer.getGuesses());
                        generateCounter++;
                            if(compareGuess(computer.getGuesses()))//to do - calculate score
                            {
                                break;
                            }
              
                            else if ( computer.getGuesses()== abandonIndic )//to do calculate score
                            {
                                break;
                            }
              
                            else
                            {
                                compRange(min, max);
                                
                            }
              
                
            }
            
        }
    
    
        else
        {
            System.out.println("--Computer will start this round--");
           
             for(int i=0;i<3;i++)
             {
              System.out.println("computer enter your guess");
              computer.setGuesses( man.randomGuessNumber(min,max));
              System.out.println(computer.getGuesses());
              generateCounter++;
              if(compareGuess(computer.getGuesses()))//to do - calculate score
              {
                   break;
              }
              
              else if ( computer.getGuesses()== abandonIndic )//to do calculate score
              {
                  break;
              }
              else
              {
                  compRange(min,max);
                  
              }   
             
              
              displayHumanGuess();
              generateCounter++;
              if(compareGuess(human.getGuesses()))//to do - calculate score
              {
                   break;
              }
              
              else if ( human.getGuesses()== 999 )//to do calculate score
              {
                  break;
              }
              else
              {
                  humRange(min,max);
                  
              }    
            }      
            
        }    
               
              
             
             
        
        
        System.out.println("---Round " +k+ " ends here---");
        System.out.println("Hidden no is " + man.getGuessNoGame());
        System.out.println("----------------------------");
    }
}
    public static void main(String[] args) {
		// TODO Auto-generated method stub
		Game game = new Game();
		game.gamePlayStarts();
	}
}

