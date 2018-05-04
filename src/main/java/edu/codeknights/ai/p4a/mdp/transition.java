package edu.codeknights.ai.p4a.mdp;

/**
 * @author wangzhiq
 */
public class transition {

    private int nextStateIndex;
    private state currentState;
    private final double[] actionN;
    private final double[] actionE;
    private final double[] actionS;
    private final double[] actionW;

    private final grid gamegrid;
    private final int x;
    private final int y;
    private state[] nextstates = new state[4];
    private double[] probabilities = new double[4];
    private state northState;
    private state eastState;
    private state southState;
    private state westState;

    //      N,0
    //  W,3      E,1
    //      S,2

    public transition(state currentState, action nextact) {
        actionN = new double[]{0.65, 0.15, 0.05, 0.15};
        actionE = new double[]{0.15, 0.65, 0.15, 0.05};
        actionS = new double[]{0.05, 0.15, 0.65, 0.15};
        actionW = new double[]{0.15, 0.05, 0.15, 0.65};
        this.currentState = currentState;
        gamegrid = currentState.getgrid();
        x = currentState.getRid();
        y = currentState.getCid();

        if (nextact.getIndex() == 0) {
            probabilities = actionN;
        } else if (nextact.getIndex() == 1) {
            probabilities = actionE;
        } else if (nextact.getIndex() == 2) {
            probabilities = actionS;
        } else if (nextact.getIndex() == 3) {
            probabilities = actionW;
        } else {
            throw (new IllegalArgumentException("Illegal action:" + nextact));
        }
    }

    public state[] getnextstates() {
        if (x == 0)
            northState = new state(x, y, gamegrid);
        else if (gamegrid.getstatev(x - 1, y).equals("-"))
            northState = new state(x, y, gamegrid);
        else
            northState = new state(x - 1, y, gamegrid);

        if (y == 5) {
            eastState = new state(x, y, gamegrid);
        } else if (gamegrid.getstatev(x, y + 1).equals("-")) {
            eastState = new state(x, y, gamegrid);
        } else {
            eastState = new state(x, y + 1, gamegrid);
        }

        if (x == 15) {
            southState = new state(x, y, gamegrid);
        } else if (gamegrid.getstatev(x + 1, y).equals("-")) {
            southState = new state(x, y, gamegrid);
        } else {
            southState = new state(x + 1, y, gamegrid);
        }

        if (y == 0)
            westState = new state(x, y, gamegrid);
        else if (gamegrid.getstatev(x, y - 1).equals("-"))
            westState = new state(x, y, gamegrid);
        else
            westState = new state(x, y - 1, gamegrid);

        nextstates[0] = northState;
        nextstates[1] = eastState;
        nextstates[2] = southState;
        nextstates[3] = westState;

        return nextstates;
    }


    public double[] getp() {
        return probabilities;
    }

}
