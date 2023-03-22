//Name: Caroline 
//T06 
//Declaration: This is my own work 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Set;
import java.util.Collections; 

enum SuitEnum
{
    Spade ("S"), 
    Heart ("H"),
    Diamond ("D"), 
    Club ("C"); 

    private final String suit;

    SuitEnum (String s)
    {
        suit = s; 
    }

    public String getSuit()
    {
        return suit; 
    }
}

enum RankEnum
{
    Two ("2"), Three ("3"), Four ("4"), Five ("5"), Six ("6"), Seven ("7"), Eight ("8"), Nine ("9"), Ten ("T"), Jack ("J"), Queen ("Q"), King ("K"), Ace("A"); 

    private final String rank; 

    RankEnum (String r)
    {
        rank = r; 
    }

    public String getRank()
    {
        return rank; 
    }
}

class PlayingCard
{
    SuitEnum suit; 
    RankEnum rank;
    
    public PlayingCard(SuitEnum suit, RankEnum rank)
    {
        this.suit = suit; 
        this.rank = rank; 
    }

    //copy constructor
    public PlayingCard(PlayingCard pc)
    {
        this.suit = pc.suit; 
        this.rank = pc.rank; 
    }

    public SuitEnum getSuit()
    {
        return this.suit; 
    }

    public RankEnum getRank()
    {
        return this.rank; 
    }

    public void setCard(SuitEnum suit, RankEnum rank)
    {
        this.suit = suit; 
        this.rank = rank; 
    }

    public String orderString()
    {
        return getSuit().getSuit() + (getRank().ordinal() + 2);  
        
    }

    public String toString()
    {
        return String.format("%s%s", suit.getSuit(), rank.getRank()); 
    }
}

class MyInt
{
    private int n; 

    public void setInt(int n)
    {
        this.n = n; 

    }

    public int getInt()
    {
        return n; 
    }

}

class Caroline_A1 
{
    private final static int MAXC = 13; 
    private final static int MAXD = 52; 
    public final static String LINE = "---------------------------------------------";


    private void deckOfCards(ArrayList <PlayingCard> cardList)
    { 
        for (SuitEnum s : SuitEnum.values())
        {
            for (RankEnum r : RankEnum.values())
            {
                cardList.add(new PlayingCard(s, r)); 
            }
        }
    }

    private void printDeck(ArrayList <PlayingCard> values)
    { 
        System.out.printf("Invoke printDeck method - array list version%n");
        System.out.printf("Printing from ArrayList%n");
        System.out.println();
        int i =0; 

        for (PlayingCard pc1 : values)
        {
            i++;
            System.out.print(pc1 + " ");
            if (i == MAXC)
            {
                System.out.println();
                i = 0;
            }
        }
    }

    private void listToArray (ArrayList <PlayingCard> cardList, PlayingCard [] cardArray)
    {
        for (int i = 0; i < cardList.size(); i++)
        {
            cardArray [i] = cardList.get(i); 
        }
    }

    private void printDeck(PlayingCard[] cardArray)
    {
        System.out.printf("Printing from Array%n");
        System.out.println();
        int i = 0; 
        for (PlayingCard card : cardArray)
        {
            i++;
            System.out.print(card + " ");
            if (i == MAXC)
            {
                System.out.println();
                i = 0;
            }
        }
        
    }

    //Transferring values from a deck to a String 
    private void transfer(PlayingCard[] cardArray, String [] strArray)
    {
        System.out.println("Re-arrange the cards");
        System.out.println();

        for (int i = 0; i < cardArray.length; i++)
        {
            strArray[i] = String.valueOf(cardArray[i]); 
        }
    }
    
    private void printStringArray(String [] strArray)
    {
        System.out.println("Printing from String array"); 
        System.out.println();

        int i = 0; 
        for (String a : strArray)
        {
            i++;
            System.out.print(a + " " );
            if (i == MAXC)
            {
                System.out.println();
                i = 0;
            }
        }
    }

    // shuffle the card k times 
    private void shuffle(PlayingCard[] cardArray)
    {
        System.out.println("Shuffle the cards - Array version");

        int k = (int) (Math.random() * MAXD); 
        for (int l = 0; l < k; l++)
        {
            int i = (int) (Math.random() * MAXD); 
            int j = (int) (Math.random() * MAXD);

            swap(cardArray, i, j); 
        }

    }

    private void swap(PlayingCard [] strArray, int i, int j)
    {
        PlayingCard temp = strArray[i]; 
        strArray[i] = strArray[j]; 
        strArray[j] = temp; 
    }

    //transfer from twoD array to string array 
    private void transfer2D(String [][] twoD, String [] strArray)
    {
        int c = 0; 
        for (int j = 0; j < 4; j++)
        {
            for (int i = 0; i <13; i++)
            {
                twoD[j][i] = strArray [c];
                c++;  
            }
        }
    }

    //printing the array 
    private void print2D_1(String [][] twoD)
    {
        System.out.println("Re-arrange the cards - 1 (Invoke print2D_1 method)");
        System.out.println();

        for (int j = 0; j <4; j++)
        {
            for (int i = 0; i < 13; i++)
            {
                System.out.print(twoD[j][i] + " ");
            }

            System.out.println();
            MyInt s = new MyInt(); 
            MyInt h = new MyInt();
            MyInt d = new MyInt();
            MyInt c = new MyInt();

            getHandInfo(twoD[j], s, h, d, c);
        }
    }

    private void print2D_2(String [][] twoD)
    {
            System.out.println();
            MyInt s = new MyInt(); 
            MyInt h = new MyInt();
            MyInt d = new MyInt();
            MyInt c = new MyInt();

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 13; j++) {
                   
                   twoD [i][j] = twoD [i][j].replaceAll("0","");
                   twoD [i][j] = twoD [i][j].replaceAll("10","T");
                   twoD [i][j] = twoD [i][j].replaceAll("11","J");
                   twoD [i][j] = twoD [i][j].replaceAll("12","Q");
                   twoD [i][j] = twoD [i][j].replaceAll("13","K");
                   twoD [i][j] = twoD [i][j].replaceAll("14","A");
                   
                   
                   System.out.printf("%s ", twoD[i][j]); 
                    getHandInfo(twoD[i],s,h,d,c);
                }
            System.out.println();
 		    System.out.printf("%s - %s - %s - %s\n", s.getInt(),h.getInt(), d.getInt(), c.getInt());   
            }
    }

    private void sort2D(String [][] twoD)
    {
        for (int i = 0; i < 4; i ++)
        {
            Arrays.sort(twoD[i], Collections.reverseOrder()); 
        }
    }

    private void getHandInfo(String [] anHand, MyInt s, MyInt h, MyInt d, MyInt c)
    {
        for (int i = 0; i < 13; i++)
        {
            switch (anHand[i].charAt(0))
            {
                case 'S': s.setInt(s.getInt() + 1); 
                break;

                case 'H': h.setInt(h.getInt() + 1); 
                break;
                
                case 'D': d.setInt(d.getInt() + 1); 
                break; 

                default: c.setInt(c.getInt() + 1);

            }
        }
        System.out.println(s.getInt() + " - " + h.getInt() + " - " + d.getInt() + " - " + c.getInt());
    }

    public static void main (String [] arg)
    {
        ArrayList <PlayingCard> cards = new ArrayList <PlayingCard>(); 
        PlayingCard [] deckArray = new PlayingCard[MAXD]; 

        String [] str = new String[deckArray.length]; 

        String [] strArray = new String [deckArray.length];  

        String [][] twoArray = new String [4][13]; 

        Caroline_A1 hand = new Caroline_A1(); 

        //set values of the no. cards into the deck 
        hand.deckOfCards(cards); 

        //printing deck from arraylist
        hand.printDeck(cards);
        System.out.println(LINE);

        //convert arraylist to array 
        hand.listToArray(cards, deckArray); 

        hand.printDeck(deckArray);
        System.out.println(LINE);

        //diplay the shuffle 
        hand.shuffle(deckArray);
        hand.printDeck(deckArray);
        System.out.println(LINE);

        //looping the String
        for (int i = 0; i < deckArray.length; i++)
        {
            strArray[i] = deckArray[i].orderString(); 
        }
        hand.printStringArray(strArray);
        System.out.println(LINE);

        //printing the twoD array
        hand.transfer2D(twoArray, strArray);
        hand.sort2D(twoArray);
        hand.print2D_1(twoArray);
        System.out.println(LINE);

        //print 2D_2
        System.out.println("Re-arrange the cards - 2 (Invoke print 2D_2 method)\n");
        hand.print2D_2(twoArray);
		System.out.println ("--------------------------------------");	
    }
} 
