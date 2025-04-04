import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import java.util.ArrayList;

public class RR extends Critter
{
    public RR()
    {
        setColor(null);
        setDirection(Location.NORTH);
    }
    
    public ArrayList<Location> getMoveLocations()
	{
		int dir = getDirection();
		ArrayList<Location> moveLocs = new ArrayList<Location>();
		
		ArrayList<Integer> directions = new ArrayList<Integer>();
		directions.add(Location.NORTH);
		directions.add(Location.NORTHEAST);
		directions.add(Location.EAST);
		directions.add(Location.SOUTHEAST);
		directions.add(Location.SOUTH);
		directions.add(Location.SOUTHWEST);
		directions.add(Location.WEST);
		directions.add(Location.NORTHWEST);
		
		Location current = getLocation();
		Grid<Actor> gr = getGrid();

		for (int direction : directions)
		{
			Location next = current;
			boolean blocked = false;

			for (int i = 0; i < 3 && !blocked; i++)
			{
				next = next.getAdjacentLocation(direction);

				if (!gr.isValid(next))
				{
					blocked = true;
				}
				else
				{
					Actor actor = gr.get(next);
					if (actor != null)
					{
						blocked = true;

						if (actor instanceof Coyote || actor instanceof Boulder)
						{
							moveLocs.add(next);
						}
					}
					else if (i == 2)
					{
						moveLocs.add(next);
					}
				}
			}
		}
		 return moveLocs;
	}
		

		
	public void makeMove(Location loc)
    {
		Grid<Actor> gr = getGrid();
		ArrayList<Location> arr = gr.getEmptyAdjacentLocations(loc);
		
        if(gr.get(loc) instanceof Boulder)
        {
			gr.get(loc).removeSelfFromGrid();
			removeSelfFromGrid();
			Kaboom kb = new Kaboom();
			kb.putSelfInGrid(gr, loc);
		}
		else if(!arr.isEmpty() && gr.get(loc) instanceof Coyote)
		{
			gr.get(loc).removeSelfFromGrid();
			super.makeMove(loc);
			
			int rand =(int)(Math.random()*arr.size());
			SickCoyote sc = new SickCoyote();
			Location newLoc =  arr.get(rand);
			sc.putSelfInGrid(gr, newLoc);
		}
		else
		{
			super.makeMove(loc);
		}
    }
  
	public void processActors(ArrayList<Actor> actors)
	{
		
	}
}




