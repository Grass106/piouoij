import info.gridworld.actor.Actor;
import info.gridworld.grid.Location;
import java.util.Arrays;
import info.gridworld.grid.Grid;
import java.util.ArrayList;


public class SickCoyote extends Actor 
{
	private int lifetime;
	private static final int THRESHOLD = 10;
	
	public SickCoyote()
	{
		super();
		lifetime = THRESHOLD;
		setColor(null);
	}
	
	// Overloaded constructor allows specifying custom lifetime
	public SickCoyote(int input)
	{
		super();
		lifetime = input;
		setColor(null);
	}
	
	// Called each time the SickCoyote acts in the world
	public void act()
	{
		Grid<Actor> gr = getGrid();
		
		lifetime --;
		if(lifetime == 0)
		{
			gr = getGrid();
			Location loc = getLocation();
			removeSelfFromGrid();
			Coyote ct = new Coyote();
			ct.putSelfInGrid(gr, loc);
		}
	}
}
