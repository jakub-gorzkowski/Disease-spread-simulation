public class Board {

    private static Board instance;
    private int x;
    private int y;
    private int[][] board;

    private Board (int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Board getInstance(int columns, int rows) {
        if (instance == null) {
            instance = new Board(columns, rows);
        }
        return instance;
    }

    int[][] generateBoard() {
        this.board = new int[x][y];
        return this.board;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

/**
 * TODO: Typ prawdopodobnie się nie będzie zgadzać
 */