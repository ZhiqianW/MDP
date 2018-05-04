/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mdp;


public class policy {
    private action policyAct;
    private final state currentstate;
    private transition currentTransition;
    private action currentAct;
    private state[] currentNextstates;
    private final int x;
    private final int y;
    private final grid gamegrid;
    private double tempV;
    private double tempQV;
    private double[] tempPr;
    private double Vstar;
    private final double r = 0.9;

    public policy( state currentstate) {
        this.currentstate = currentstate;
        this.gamegrid = currentstate.getgrid();
        this.x = currentstate.getRid();
        this.y = currentstate.getCid();
        Vstar = Double.NEGATIVE_INFINITY;
    }
    
    public void valueIteration() {
        reward currentReward = new reward(currentstate);
        for (int i = 0; i < 4; i++) {
            //System.out.println("111-----");
            tempQV = 0;
            currentAct = new action(i);
            currentTransition = new transition(currentstate, currentAct);
            tempPr = currentTransition.getp();
            currentNextstates = currentTransition.getnextstates();
            //System.out.println(tempQV);
            
            for (int j = 0; j < 4; j++) {
                //System.out.println("222-----");
                //System.out.println(tempQV);
                tempQV = tempQV + tempPr[j]*currentNextstates[j].getstateV();
                //System.out.println(tempQV);
                //System.out.println(tempPr[j]);
                //System.out.println(currentNextstates[j].getstateV());
            }
            //System.out.println(tempV);
            tempV = currentReward.getreward() + tempQV*r;
            //System.out.println(currentReward.getreward());
            //System.out.println(tempQV*r);
            if( tempV > Vstar) {
                //System.out.println("333-----");
                Vstar = tempV;
                policyAct = currentAct;
            }
        }
        currentstate.updateV(Vstar);
        gamegrid.updateA(x, y, policyAct);
    }
    
}
