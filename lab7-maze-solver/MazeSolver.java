public class MazeSolver {

    private char[][] maze;

    public MazeSolver(char[][] maze) {
        this.maze = maze;
    }

    public void printMaze() {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("--------------------");
    }

    public boolean solve() {
        // TODO: Find the starting row and column of 'S'
        int startRow = -1;
        int startCol = -1;
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                if (maze[i][j] == 'S') {
                    startRow = i;
                    startCol = j;
                    break;
                }
            }
        }

        if (startRow != -1) {
            solve(startRow, startCol);
            return hasBeenSolved;
        }

        printMaze();
        return false;
    }

    /**
     * The core recursive method to solve the maze.
     * @param row The current row position.
     * @param col The current column position.
     * @return true if this position leads to a solution, false otherwise.
     */
    private boolean hasBeenSolved = false;
    private void solve(int row, int col) {
        if(hasBeenSolved)return;
        if (! (0 <= row && row < maze.length && 0 <= col && col < maze[0].length)) return; //out of bounds...
        // TODO: Implement the recursive logic with backtracking here.
        if (maze[row][col] == '.' || maze[row][col] == '#') return;
        
        
        // System.out.println();
        if (maze[row][col] == 'F') {
            System.out.println("Solution Found:");
            printMaze();
            hasBeenSolved = true;
            return;
        }
        maze[row][col] = '.';
        // printMaze();
        int dx[] = {1,0,-1,0};
        int dy[] = {0,1,0,-1};

        //this is a classic BFS problem but whatever lmao

        
        for (int i = 0; i < 4; i++) {

            solve(row + dx[i], col + dy[i]);
        }
        maze[row][col] = ' ';
        // 1. Base Case (Stopping Conditions)
        // Check if out of bounds, a wall, or already visited.
        // Check if the current cell is the finish ('F').
        // 2. Recursive Step
        // Mark the current cell as part of the path.
        // Try moving North, East, South, West.
        // If any direction returns true, then you've found a path, return true.
        // 3. Backtracking
        // If no direction works, un-mark the cell and return false.
    }

    public static void main(String[] args) {
        char[][] mazeToSolve = {
            {'#', '#', '#', '#', '#', '#', '#'},
            {'#', 'S', ' ', '#', ' ', ' ', '#'},
            {'#', ' ', ' ', '#', ' ', '#', '#'},
            {'#', ' ', '#', ' ', ' ', ' ', '#'},
            {'#', ' ', ' ', ' ', '#', 'F', '#'},
            {'#', '#', '#', '#', '#', '#', '#'}
        };

        MazeSolver solver = new MazeSolver(mazeToSolve);

        System.out.println("Original Maze:");
        solver.printMaze();

        if (solver.solve()) {
            // System.out.println("Solution Found:");
        } else {
            System.out.println("No Solution Found:");
        }
        // solver.printMaze();
    }
}