package TicTacToe_Game;
import java.util.Scanner;


public class tictactoe {
    public static void Print_Board(char[][] ttt_board){
        System.out.println("|Rows|-Column1-|-Column2-|-Column3-|");
        System.out.println("|----------------------------------|");
        System.out.println("|Row1|    " + ttt_board[0][0] + "    |    "
                + ttt_board[0][1] + "    |    " + ttt_board[0][2]
                + "    |");
        System.out.println("|----------------------------------|");
        System.out.println("|Row2|    " + ttt_board[1][0] + "    |    "
                + ttt_board[1][1] + "    |    " + ttt_board[1][2]
                + "    |");
        System.out.println("|----------------------------------|");
        System.out.println("|Row3|    " + ttt_board[2][0] + "    |    "
                + ttt_board[2][1] + "    |    " + ttt_board[2][2]
                + "    |");
        System.out.println("|----------------------------------|");
        System.out.println("|Rows|-Column1-|-Column2-|-Column3-|");
    }
    public static void TicTacToe(char[][] ttt_board){
        Scanner TTT = new Scanner(System.in);
        char Sym = 'X';
        int player = 1;
        int Limit = 9;
        for (int i = 0;i<Limit;i++){
            System.out.println("Dear player"+player+", where would you like to place- "+Sym+" -?");
            System.out.print("Row: ");
            int Row = TTT.nextInt();
            if (Row<1||Row>3){
                System.out.println("There are only 3 Rows!");
                Limit  += 1;
                continue;
            }
            System.out.print("Column: ");
            int Col = TTT.nextInt();
            if (Col<1||Col>3){
                System.out.println("There are only 3 Columns!");
                Limit  += 1;
                continue;
            }
            ttt_board[Row-1][Col-1] = Sym;
            Print_Board(ttt_board);

            if (whoWin(ttt_board)){
                System.out.println("THE WINNER IS: "+ player);
                break;
            }
            if(Sym == 'X'){
                Sym = 'O';
            }else {
                Sym = 'X';
            }
            if(player == 1){
                player += 1;
            }else if(player==2){
                player -= 1;
            }
        }
    }
    public static boolean whoWin(char[][] ttt_board){
        boolean isWin = false;


        if(ttt_board[0][0] != '_' && ttt_board[0][0]==ttt_board[0][1]&&ttt_board[0][1]==ttt_board[0][2]){
            isWin = true;
        }else if(ttt_board[1][0] != '_' && ttt_board[1][0]==ttt_board[1][1]&&ttt_board[1][1]==ttt_board[1][2]) {
            isWin = true;
        }else if(ttt_board[2][0] != '_' && ttt_board[2][0]==ttt_board[2][1]&&ttt_board[1][1]==ttt_board[2][2]) {
            isWin = true;
        }else if(ttt_board[0][0] != '_' && ttt_board[0][0]==ttt_board[1][0]&&ttt_board[1][0]==ttt_board[2][0]) {
            isWin = true;
        }else if(ttt_board[0][1] != '_' && ttt_board[0][1]==ttt_board[1][1]&&ttt_board[1][1]==ttt_board[2][1]) {
            isWin = true;
        }else if(ttt_board[0][2] != '_' && ttt_board[0][2]==ttt_board[1][2]&&ttt_board[1][2]==ttt_board[2][2]) {
            isWin = true;
        }else if(ttt_board[1][1] != '_' && ttt_board[0][0]==ttt_board[1][1]&&ttt_board[1][1]==ttt_board[2][2]) {
            isWin = true;
        }else if(ttt_board[2][0] != '_' && ttt_board[2][0]==ttt_board[1][1]&&ttt_board[1][1]==ttt_board[0][3]) {
            isWin = true;
        }
        return isWin;
    }
    public static void main(String[] args) {
        char[][] ttt_board = new char[3][3];
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                ttt_board[i][j] = '_';
            }
        }
        System.out.println("-------|The game has started|-------");
        Print_Board(ttt_board);
        TicTacToe(ttt_board);
        System.out.println("------|The game has concluded|------");
    }
}