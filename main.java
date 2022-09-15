/* Xander Siruno-Nebel
 * Java Programming 6th Period
 * 9/30/2021
 * Tic Tac Toe
 */
package TicTacToe;
import java.util.Arrays;
import java.util.Scanner;
public class TicTacToe {
//vars
int[][] board = new int[3][3];
final int BLANK = 0;
final int X_MOVE = 1;
final int O_MOVE = 2;
final int X_TURN = 0;
final int O_TURN = 1;
int turn = X_TURN;
Scanner scanner;
String input = "";
int xWins = 0;
int oWins = 0;
int ties = 0;
public TicTacToe() {
scanner = new Scanner(System.in);
boolean stillPlaying = true;
while(stillPlaying == true) {
while (checkWin(X_MOVE) == false && checkWin(O_MOVE) == false && 
checkTie() == false) {
//plays the game, only if no one has won/tied
printBoard();
input = scanner.nextLine();
if (input.length() != 2) { //checks to see if move is valid
System.out.println("Enter a letter followed by a number");
} else if (input.charAt(0) != 'a' && 
   input.charAt(0) != 'b' &&
   input.charAt(0) != 'c') {
System.out.println("Rows are labeled by a, b, or c.");
} else if (input.charAt(1) != '1' && 
   input.charAt(1) != '2' &&
   input.charAt(1) != '3') {
System.out.println("Columns are labeled by 1, 2, or 3.");
} else { //plays move
int row = input.charAt(0) - 'a';
int column = input.charAt(1) - '1';
if(board[row][column] == BLANK) {
if(turn == X_TURN) {
board[row][column] = X_MOVE;
turn = O_TURN;
} else {
board[row][column] = O_MOVE;
turn = X_TURN;
}
} else {
System.out.println("There is a piece there already!");
}
} 
} if(checkWin(X_MOVE) == true) { 
xWins++;
System.out.println("X wins! Do you want to play again? Type Y for yes 
and N for no.\n"+"X's Wins: "+xWins+"\nO's Wins: "+oWins+"\nTies: "+ties);
} else if(checkWin(O_MOVE) == true){
oWins++;
System.out.println("O wins! Do you want to play again? Type Y for yes 
and N for no.\n"+"X's Wins: "+xWins+"\nO's Wins: "+oWins+"\nTies: "+ties);
} else {
ties++;
System.out.println("Tie! Do you want to play again? Type Y for yes and 
N for no.\n"+"X's Wins: "+xWins+"\n O'sWins: "+oWins+"\nTies: "+ties);
}
String playingStatus = scanner.nextLine();
if (playingStatus.equals("Y")){ //sees whether player wants to play again
stillPlaying = true;
int x = 0; // integer names are x and y due to axes on the board
int y = 0;
for (; x < 3;y = 0) {
board[x][y] = BLANK;
y++;
board[x][y] = BLANK;
y++;
board[x][y] = BLANK;
x++;
}
} else {
stillPlaying = false;
}
}
}
public static void main(String[] args) {
new TicTacToe();
}
public boolean checkWin(int player) { // checks if a player has won
if(board[0][0] == player && board[0][1] == player && board[0][2] == 
player) {
return true;
} else if(board[1][0] == player && board[1][1] == player && board[1][2]
== player) {
return true;
} else if(board[2][0] == player && board[2][1] == player && board[2][2]
== player) {
return true;
} else if(board[0][0] == player && board[1][0] == player && board[2][0]
== player) {
return true;
}else if(board[0][1] == player && board[1][1] == player && board[2][1] 
== player) {
return true;
}else if(board[0][2] == player && board[1][2] == player && board[2][2] 
== player) {
return true;
} else if(board[0][0] == player && board[1][1] == player && board[2][2]
== player) {
return true;
} else if(board[2][0] == player && board[1][1] == player && board[0][2]
== player) {
return true;
}
return false;
}
public boolean checkTie() { // checks if there is a tie (if the board is 
full, and there is no winner)
for (int column = 0; column < board.length; column++) {
for (int row = 0; row < board.length; row++) {
if(board[row][column] == BLANK) {
return false;
}
}
}
return true;
}
public void printBoard() { // method prints the board
System.out.println(" \t1\t2\t3");
for (int row = 0; row < board.length; row++) {
String output = (char) ('a'+row) + "\t";
for (int column = 0; column < board[0].length; column++) {
if(board[row][column] == BLANK) {
output += " \t";
} else if (board[row][column] == X_MOVE){
output += "X\t";
} else if (board[row][column] == O_MOVE) {
output += "O\t";
}
  }
    System.out.println(output);
    }
  }
}
