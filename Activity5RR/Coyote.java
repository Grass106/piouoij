import info.gridworld.actor.Actor;
import info.gridworld.actor.Rock;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;
import java.util.ArrayList;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Grid;

import java.awt.Color;

public class Coyote extends Critter
{ 
	private int direction;
	private int stepCount; 
	private int sit;
	
	public Coyote()
	{
		super();
		setColor(null);
		direction = ((int) (Math.random() * 8)) * 45;
		setDirection(direction);
		stepCount = 0;
		sit = 0;
	}
	
	public void processActors(ArrayList<Actor> actors) 
    {
        Grid<Actor> gr = getGrid();
        if (gr == null) return;
        
        Location next = getLocation().getAdjacentLocation(getDirection());
        if (!gr.isValid(next))
        {
			stepCount = 0;
			sit = 5;
			direction += (int) (Math.random() * 7) * 45;
			setDirection(direction);     
		}
		else if (gr.get(next) != null)
		{
			stepCount = 0;
			sit = 5;
			if (gr.get(next) instanceof Boulder) 
			{
				Location loc = gr.get(next).getLocation();
				gr.get(next).removeSelfFromGrid();
				new Kaboom().putSelfInGrid(gr, loc);   
				removeSelfFromGrid();   
			}  
			direction += (int) (Math.random() * 7) * 45;
			setDirection(direction);   
		}
    }

    public ArrayList<Location> getMoveLocations() 
    {
        ArrayList<Location> locs = new ArrayList<>();
        Grid<Actor> gr = getGrid();
       
        if (gr == null || sit > 0)
        {
			return locs;
		}

        Location next = getLocation().getAdjacentLocation(getDirection());
        if (gr.isValid(next) && gr.get(next) == null) 
        {
            locs.add(next);
        }
        return locs;
    }

    public void makeMove(Location loc) 
    {
		if (sit != 0) 
        {
            sit--;
        } 
        else 
        {
            moveTo(loc);
            stepCount++;
        }

        if (stepCount == 5) 
        {
            stepCount = 0;
            sit = 5;

            Grid<Actor> gr = getGrid();
            if (gr != null) 
            {
				ArrayList<Location> emptyLocs = gr.getEmptyAdjacentLocations(getLocation());
                if (!emptyLocs.isEmpty() &&  getGrid().getValidAdjacentLocations(getLocation()).size() == 8) 
                {
                    int rand = (int) (Math.random() * emptyLocs.size());
                    new Stone().putSelfInGrid(gr, emptyLocs.get(rand));
                }
            }
			direction += (int) (Math.random() * 7) * 45;
			setDirection(direction);   
        }
    }
   
}
