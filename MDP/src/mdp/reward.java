/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mdp;


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
            throw (new IllegalArgumentException("Illegal state:"+State));
    }
    
    public double getreward() {
        return Reward;
    }
    
}
