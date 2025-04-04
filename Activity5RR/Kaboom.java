import info.gridworld.actor.Actor;
import info.gridworld.actor.Rock;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;
import java.util.ArrayList;
import java.awt.Color;

public class Kaboom extends Actor
{ 
	private int lifetime;
	private static final int THRESHOLD = 3;
	
	public Kaboom()
	{
		super();
		lifetime = THRESHOLD;
		setColor(null);
	}
	
	public void act()
	{
		lifetime --;
		if(lifetime == 0)
		{
			removeSelfFromGrid();
		}
	}
}
