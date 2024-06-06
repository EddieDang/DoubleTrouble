import java.util.HashMap;

public class GameManager {
    private HashMap<String, Integer> board;
    private int turn;

    /**
     * Creates a game
     */
    public GameManager() {
        this.board = new HashMap<>();
        this.board.put("Green", 3);
        this.board.put("Yellow", 7);
        this.board.put("Orange", 5);
        this.turn = 1;
    }

    /**
     * Removes pieces from board
     * @param color
     * @param amount
     */
    public void removePiece(String color, int amount){
        try{
            if(validateMove(color, amount)){
                int old_value = this.board.get(color);
                this.board.remove(color);
                this.board.put(color, old_value - amount);
                changePlayer();
                System.out.println(amount + " " + color + " has been removed!");
            }
        }catch (Exception e){
            System.out.println("Invalid color or amount! Try Again!");
        }
    }

    /**
     * Checks if the move is legal
     * If the chosen color has pieces that can be moved
     * If the chosen color has >= than the amount that the player wants to remove
     * @param color
     * @param amount
     * @return
     */
    public boolean validateMove(String color, int amount){
        if(this.board.containsKey(color) && (amount <= this.board.get(color))){
            return true;
        }
        return false;
    }

    public void changePlayer(){
        if(this.turn == 1){
            this.turn = 2;
        }
        this.turn = 2;
    }

    /**
     * Prints out the board
     */
    public void printBoard(){
        this.board.forEach((key, value) -> System.out.println(key + ": " + value));
    }
}

