package sudokusolver;

import edu.princeton.cs.algs4.ST;

import java.util.PriorityQueue;

public class SolvablePuzzles {
    ST<Integer, Board> canSolve = new ST<>();
    PriorityQueue<Integer> keys = new PriorityQueue<>();

    public void addSolveablePuzzle(Board b) {
        keys.add(b.getSolveability());
        canSolve.put(b.getSolveability(), b);
    }

    public Board getSolveablePuzzleBoard() {
        if (!canSolve.isEmpty()) {
            Integer temp = keys.poll();
            Board tempboard = canSolve.get(temp);
            canSolve.delete(temp);
            return tempboard;
        }
        return null;
    }
}
