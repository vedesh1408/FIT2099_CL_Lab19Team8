package edu.monash.fit2099.engine.positions;

import edu.monash.fit2099.engine.actors.*;

public class HighGround extends Ground {
    public HighGround() {

    }

    // Overriding because an actor cannot move to high ground without jumping.
    // (only the player can jump so we can add conditions to be met for that)
    @Override
    public boolean canActorEnter(Actor actor){
        return false;
    }
}
