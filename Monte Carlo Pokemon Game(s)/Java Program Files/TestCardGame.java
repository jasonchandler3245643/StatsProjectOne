



public class TestCardGame
{
   
    public static void main (String[] args) {
    
        
        CardGame Game1 = new CardGame();
        CardGame Game2 = new CardGame(2, 2);
        CardGame Game3 = new CardGame(3, 3);
        CardGame Game4 = new CardGame(4, 4);
        
        Game1.run(1000000);
        Game2.run(1000000);
        Game3.run(1000000);
        Game4.run(1000000);
        
    }
    
    
}
