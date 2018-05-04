package edu.codeknights.ai.p4a.mdp;

/**
 * @author wangzhiq
 */
public class state {
    private final int Rid;
    private final int Cid;
    private final String svalue;
    private final grid gamegrid;
    private double v;


    public state(int R, int C, grid G) {
        this.v = G.getV(R, C);
        this.gamegrid = G;
        this.Rid = R;
        this.Cid = C;
        this.svalue = G.getstatev(Rid, Cid);

    }

    public String getstateValue() {
        return svalue;
    }

    public int getRid() {
        return Rid;
    }

    public int getCid() {
        return Cid;
    }

    public int getnextStatePosition(state nextState) {
        int nextStateP;
        if ((nextState.getRid() == (Rid - 1)) && (nextState.getCid() == Cid))
            nextStateP = 0;
        else if ((nextState.getRid() == Rid) && (nextState.getCid() == (Cid + 1)))
            nextStateP = 1;
        else if ((nextState.getRid() == (Rid + 1)) && (nextState.getCid() == Cid))
            nextStateP = 2;
        else if ((nextState.getRid() == Rid) && (nextState.getCid() == (Cid - 1)))
            nextStateP = 3;
        else
            throw (new IllegalArgumentException("Illegal nextState:" + nextState));
        return nextStateP;
    }

    public boolean checkwall() {
        if (svalue.equals("-"))
            return true;
        else
            return false;
    }

    public grid getgrid() {
        return gamegrid;
    }

    public double getstateV() {
        return v;
    }

    public void updateV(double newV) {
        v = newV;
        gamegrid.updateV(Rid, Cid, newV);
    }
}
