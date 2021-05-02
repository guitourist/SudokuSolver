package sudokusolver;

import edu.princeton.cs.algs4.ST;

import java.util.PriorityQueue;

public class SolvablePuzzles {
    ST<Double, Board> canSolve = new ST<>();
    PriorityQueue<Double> keys = new PriorityQueue<>();

    public void addSolveablePuzzle(Board b) {
        keys.add(Double.parseDouble(b.uniqueBoardID(b.grid)));
        canSolve.put(Double.parseDouble(b.uniqueBoardID(b.grid)), b);
    }

    public Board getSolveablePuzzleBoard() {
        if (!canSolve.isEmpty()) {
            Double temp = keys.poll();
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
