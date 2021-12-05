/**
 * Study this code very carefully, it is a really good one. Problem statement is also included for reference.
 * 
 * 
 * There are N players standing in a line, indexed 1 to N from left to right. They all play a game of Rock, Paper, Scissors. Each player has already decided which move they want to play. You are given this information as a string S of length N, i.e,

Si is equal to R if player i will play Rock.
Si is equal to P if player i will play Paper.
Si is equal to S if player i will play Scissors.
Let W(i,j) denote the move played by the winner if players i,i+1,…,j compete in order from left to right. That is,

First, players i and i+1 play a game
The winner of this game plays against player i+2
The winner of the second game plays against player i+3
⋮
The winner of the first j−i−1 games plays against player j, and the move played by the winner of this game is declared to be W(i,j).
If i=j, then player i is considered to be the winner and W(i,i)=Si.

Your task is to find the value of W(i,N) for all i from 1 to N.

Note : If a person with index i and index j (i<j) play against each other, then:

If Si≠Sj, the winner is decided by classical rules, i.e, rock beats scissors, scissors beats paper, and paper beats rock.
If Si=Sj, the player with lower index (in this case, i) wins.
Input Format
The first line of input contains a single integer T, denoting the number of test cases. The description of T test cases follows.
The first line of each test case contains a single integer N, the number of players.
The second line of each test case contains the string S of length N, denoting the moves chosen by the players.
Output Format
For each test case, print a single line containing a string of length N, whose i-th character is W(i,N).

Constraints
1≤T≤105
1≤N≤5⋅105
Si is either R, P or S
Sum of N over all test cases doesn't exceed 5⋅105
Subtasks
Subtask 1 (10 points):

1≤T≤1000
1≤N≤5000
Sum of N over all test cases doesn't exceed 5000
Subtask 1 (90 points):

Original constraints
Sample Input 1 
2
1
S
4
SSPR
Sample Output 1 
S
RRPR

Explanation
Test Case 1. W(1,1)=S as there is only one player.

Test Case 2.

For W(1,4) the game is played as follows :

Player 1 and 2 compete, player 1 wins.
Player 1 and 3 compete, player 1 wins.
Player 1 and 4 compete, player 4 wins.
Hence, we print W(1,4)=S4=R
For W(3,4) the game is played as follows :

Player 3 and 4 compete, player 3 wins.
Hence, we print W(3,4)=S3=P
 */

/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class ROPASCI
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		try{
		    Scanner sc=new Scanner(System.in);
		    int t=sc.nextInt();
		    while(t-->0){
		        int n=sc.nextInt();
		        char[] c=sc.next().toCharArray();

                //we basically take 3 arrays to store what happens when one element is challenged by R, P, S.
		        char[] r=new char[n+1];
		        char[] p=new char[n+1];
		        char[] s=new char[n+1];
		        char[] w=new char[n+1];
		        r[n]=challenge(c[n-1], 'R');
		        p[n]=challenge(c[n-1], 'P');
		        s[n]=challenge(c[n-1], 'S');
		        w[n]=c[n-1];
		        for(int i=n-1; i>=1; i--){
		            char rx=challenge(c[i-1], 'R');
		            char px=challenge(c[i-1], 'P');
		            char sx=challenge(c[i-1], 'S');
		            
		            if(rx=='R'){
		                r[i]=r[i+1];
		            }else if(rx=='P'){
		                r[i]=p[i+1];
		            }else if(rx=='S'){
		                r[i]=s[i+1];
		            }
		            
		            if(px=='R'){
		                p[i]=r[i+1];
		            }else if(px=='P'){
		                p[i]=p[i+1];
		            }else if(px=='S'){
		                p[i]=s[i+1];
		            }
		            
		            if(sx=='R'){
		                s[i]=r[i+1];
		            }else if(sx=='P'){
		                s[i]=p[i+1];
		            }else if(sx=='S'){
		                s[i]=s[i+1];
		            }
		            
		            if(c[i-1]=='R'){
		                w[i]=r[i+1];
		            }else if(c[i-1]=='P'){
		                w[i]=p[i+1];
		            }else if(c[i-1]=='S'){
		                w[i]=s[i+1];
		            }
		        }
		        System.out.println((new String(w)).trim());
		    }
		}catch(Exception e){
		    e.printStackTrace();
		}
	}
	
	public static char challenge(char a, char b){
        if(a==b) return a;
        else if((a=='R'&&b=='S')||(a=='S'&&b=='R')) return 'R';
        else if((a=='R'&&b=='P')||(a=='P'&&b=='R')) return 'P';
        else //if((a=='P'&&b=='S')||(a=='S'&&b=='P'))
            return 'S';
	}
}
