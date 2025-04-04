import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Location;

public class SickCoyoteRunner
{
    public static void main(String[] args)
    {
        // Create a 5x5 GridWorld
        ActorWorld world = new ActorWorld(new BoundedGrid<>(5, 5));

        // Place 4 SickCoyote instances with different lifetimes
        world.add(new Location(1, 1), new SickCoyote());  // Lasts 3 steps
        world.add(new Location(2, 2), new SickCoyote(2));  // Lasts 2 steps
        world.add(new Location(3, 3), new SickCoyote(4));  // Lasts 4 steps
        world.add(new Location(4, 4), new SickCoyote(1));  // Lasts 1 step

        // Start the simulation
        world.show();
    }
}
