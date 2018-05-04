package edu.codeknights.ai.p4a.mdp;


public class reward {
    private final double Reward;
    private final state State;


    public reward(state State) {
        this.State = State;
        if (State.getstateValue().equals("1000"))
            this.Reward = 1;
        else if (State.getstateValue().equals("-800"))
            this.Reward = -1;
        else if (State.getstateValue().equals("0"))
            this.Reward = -0.01;
        else
            throw (new IllegalArgumentException("Illegal state:" + State));
    }

    public double getreward() {
        return Reward;
    }

}
