import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;
import info.gridworld.actor.Actor;
import info.gridworld.actor.Rock;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;
import java.util.ArrayList;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Grid;

import java.awt.Color;


/**
 * This class runs a world that contains chameleon critters. <br />
 * This class is not tested on the AP CS A and AB exams.
 */
public class CoyoteRunner
{
    public static void main(String[] args)
    {
        BoundedGrid<Actor> mygrid = new BoundedGrid<Actor>(10,10);
        ActorWorld world = new ActorWorld(mygrid);
        
       
        world.add(new Location(2, 2), new Coyote());
        world.add(new Location(7, 7), new Coyote());
/*
        for (int i = 0; i < 5; i++) // Adjust number of stones as needed
        {
            int row = (int) (Math.random() * 10);
            int col = (int) (Math.random() * 10);
            world.add(new Location(row, col), new Stone());
        }

        // Step 4: Run the world*/
        world.show();
        
    }
}
