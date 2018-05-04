/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mdp;


public class action {
    private int act;
    private String actString;
    public action(int act) {
        this.act = act;
        if(act == 0) 
            actString = "N";
        else if (act == 1)
            actString = "E";
        else if (act == 2)
            actString = "S";
        else if (act == 3)
            actString = "W";
        else
            throw (new IllegalArgumentException("Illegal action:"+act));
    }
    //      N,0
    //  W,3      E,1
    //      S,2
    public action(String a) {
            if(a.equals("N")) {
                    act = 0; 
                    actString = "N";
            } else if(a.equals("E")) {
                    act = 1;
                    actString = "E";
            } else if(a.equals("S")) {
                    act = 2;
                    actString = "S";
            } else if(a.equals("W")) {
                    act =3;
                    actString = "W";
            } else
                    throw (new IllegalArgumentException("Illegal action:"+a));
    }
    public int getIndex() {
                    return act;
    }
    public String getactString() {
                    return actString;
    }
}
