package sudokusolver;

import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.Stack;

/**
 * Manages a symbol table and stack that provide functionality to be able to
 * recall previous randomly generated puzzles.
 * 
 * @author Adrien Baldwin & Marshall Ringwood
 *
 */
public class SolvablePuzzles {
    ST<Double, Board> canSolve = new ST<>();
    Stack<Double> keys = new Stack<>();

    public void addSolveablePuzzle(Board b) {
        keys.push(Double.parseDouble(b.uniqueBoardID(b.grid)));
        canSolve.put(Double.parseDouble(b.uniqueBoardID(b.grid)), b);
    }

    public Board getSolveablePuzzleBoard() {
        if (!canSolve.isEmpty()) {
            Double temp = keys.pop();
            Board tempboard = canSolve.get(temp);
            canSolve.delete(temp);
            return tempboard;
        }
        return null;
    }

    public boolean isEmpty() {
        return canSolve.isEmpty();
    }
}
