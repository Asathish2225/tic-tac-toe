import java.util.Scanner;

public class App {
    public static void main(String[] args){

        System.out.println("Welcome to tic-tac-toe!!!");
        System.out.println("--------------------------");
        System.out.println();

        char i='1';
        char[][] board= new char[3][3];
        for(int row=0;row<board.length;row++){
            for(int col=0;col<board[row].length;col++){
                board[row][col]=i++;
            }
        }

        char player = 'X';
        boolean gameOver=false;
        int count=0;
        Scanner sc = new Scanner(System.in);

        while(!gameOver && count<9){

            printBoard(board);

            System.out.println("Player " + player + ": Enter ur box number: ");
            int val=sc.nextInt();
          
            System.out.println();

            if(val<1 || val>9){
                System.out.println("Wrong Input ,Please Enter integer between 1 and 9 !");
                continue;
            }

            System.out.println();

            switch (val){
                    case 1: val=board[0][0];
                            break;
                    case 2: val=board[0][1];                            
                            break;
                    case 3: val=board[0][2];
                            break;
                    case 4: val=board[1][0];
                            break;
                    case 5: val=board[1][1];
                            break;
                    case 6: val=board[1][2];
                            break;
                    case 7: val=board[2][0];
                            break;
                    case 8: val=board[2][1];
                            break;
                    case 9: val=board[2][2];
                            break;
                }

                
            if(!(val=='X' || val=='O')){
                val-=48;
                switch (val){
                    case 1:
                            board[0][0]=player;
                            break;
                    case 2: 
                            board[0][1]=player;
                            break;
                    case 3: 
                            board[0][2]=player;
                            break;
                    case 4: 
                            board[1][0]=player;
                            break;
                    case 5: 
                            board[1][1]=player;
                            break;
                    case 6: 
                            board[1][2]=player;
                            break;
                    case 7: 
                            board[2][0]=player;
                            break;
                    case 8: 
                            board[2][1]=player;
                            break;
                    case 9: 
                            board[2][2]=player;
                            break;
                }
                
                count++;
                if(count>=5){
                    gameOver=haveWon(board,player);
                }
            
                if(gameOver){
                    System.out.println("Player " + player + " has WON!");
                }
                else if(count==9){
                    System.out.println("DRAW match!!!");
                    break;
                 }
                else{
                    player= (player=='X')?'O':'X';
                }
            }else{
                System.out.println("This position is already taken!");
            }
            
        }

        System.out.println();

        printBoard(board);
    }

  
    public static boolean haveWon(char[][] board,char player){
        for(int row=0;row<board.length;row++){
            if(board[row][0]==player && board[row][1]==player && board[row][2]==player){
                return true;
            }

            if(board[0][row]==player && board[1][row]==player && board[2][row]==player){
                return true;
            }
        }

        if(board[0][0]==player && board[1][1]==player && board[2][2]==player){
            return true;
        }

        if(board[0][2] == player && board[1][1] == player && board[2][0]==player){
            return true;
        }
        return false;
    }

    public static void printBoard(char[][] board){
        for(int row=0;row<board.length;row++){
            for(int col=0;col<board.length;col++){
                System.out.print(board[row][col] );
                if(col<2)System.out.print(" | ");
            }
            System.out.println();
            if(row<2){
                System.out.println("--+---+-- ");
            }   
        }
    }
}
