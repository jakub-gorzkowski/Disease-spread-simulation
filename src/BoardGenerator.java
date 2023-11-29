public class BoardGenerator {
    private int x;
    private int y;
    private int[][] board;

    BoardGenerator(int x, int y) {
        this.x = x;
        this.y = y;
    }

    int[][] generateBoard() {
        this.board = new int[x][y];
        return this.board;
    }
}

/**
 * TODO: Typ prawdopodobnie się nie będzie zgadzać
 */