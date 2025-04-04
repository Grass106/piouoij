import info.gridworld.actor.Actor;
import info.gridworld.actor.Rock;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;
import java.util.ArrayList;
import info.gridworld.grid.Grid;
import java.awt.Color;

public class Stone extends Rock
{ 
	private int lifetime;
	private static final int THRESHOLD = 3;
	
	public Stone()
	{
		super();
		lifetime = (int)(Math.random()*200+1);
		setColor(null);
	}
	
	public Stone(int lifeIn)
	{
		super();
		lifetime = lifeIn;
		setColor(null);
	}
	
	
	public void act()
	{
		lifetime --;
		if(lifetime < THRESHOLD)
		{
			setColor(Color.GREEN);
		}
		if(lifetime == 0)
		{
			Location loc = getLocation();
			Grid<Actor> gr = getGrid();
			removeSelfFromGrid();
			Boulder bd = new Boulder();
			bd.putSelfInGrid(gr, loc);
		}
	}
	
}
