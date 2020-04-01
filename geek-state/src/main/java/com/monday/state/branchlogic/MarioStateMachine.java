package com.monday.state.branchlogic;

import static com.monday.state.branchlogic.State.*;


public class MarioStateMachine {
    private int score;
    private State currentState;

    public MarioStateMachine() {
        this.score = 0;
        this.currentState = SMALL;
    }

    public void obtainMushRoom() {
        if (currentState.equals(SMALL)) {
            currentState = SUPER;
            score += 100;
        }
    }

    public void obtainCape() {
        if (currentState.equals(SMALL) || currentState.equals(SUPER)) {
            currentState = CAPE;
            score += 200;
        }
    }

    public void obtainFireFlower() {
        if (currentState.equals(SMALL) || currentState.equals(SUPER)) {
            currentState = FIRE;
            score += 300;
        }
    }

    public void meetMonster() {
       switch (currentState) {
           case SUPER:
               currentState = SMALL;
               score -= 100;
               break;

           case CAPE:
               currentState = SMALL;
               score -= 200;

           case FIRE:
               currentState = SMALL;
               score -= 300;
               default:
                   break;
       }
    }

    public int getScore() {
        return this.score;
    }

    public State getCurrentState() {
        return this.currentState;
    }
}
