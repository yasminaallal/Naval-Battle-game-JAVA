package TP5_ALLAL;

import TP5_ENUM.Action;
import TP5_ENUM.Direction;

public class Commande {

	//attributs
	private Equipe equipe;
	private Integer idNavire ;
	private Action actionChoisie; 
	private Direction directionChoisie;
	
	//constructeur
	public Commande(Equipe eq, int  id, int a, int d)
	{
		if(a==1)
			actionChoisie= Action.DEPLACEMENT;
		else if (a==2)
			actionChoisie= Action.TIR;
		else
			actionChoisie= Action.PECHE;
		
		if(d==1)
			directionChoisie= Direction.NORD;
		else if (d==2)
			directionChoisie= Direction.SUD;
		else if(d==3)
			directionChoisie= Direction.EST;
		else
			directionChoisie= Direction.OUEST;
		
		idNavire=id;
		equipe=eq;
	}
	public Commande(Equipe eq, String strid,String straction,String strdirection)
	{
		equipe=eq;
		int number = Integer.parseInt(strid);
		idNavire=number;
		if(straction.compareTo("DEPLACEMENT")==0)
		{
			actionChoisie = Action.DEPLACEMENT;
		}
		else if(straction.compareTo("TIR")==0)
		{
			actionChoisie = Action.TIR;
		}	
		else
		{
			actionChoisie = Action.PECHE;
		}
		
		if(strdirection.compareTo("NORD")==0)
		{
			directionChoisie = Direction.NORD;
		}
		else if(strdirection.compareTo("SUD")==0)
		{
			directionChoisie = Direction.SUD;
		}
		else if(strdirection.compareTo("EST")==0)
		{
			directionChoisie = Direction.EST;
		}		
		else 
		{
			directionChoisie = Direction.OUEST;
		}
				
	}
	//methodes
	public Equipe getEquipe()
	{
		return equipe;
	}
	public Integer getidNavire()
	{
		return idNavire;
	}	
	public Action getActionChoisie()
	{
		return actionChoisie;
	}
	public Direction getDirectionChoisie()
	{
		return directionChoisie;
	}
	public void setidNavire(int idnav)
 	{
		idNavire=idnav;
	}
	public void setActionChoisie(Action actionchoisie)
	{
		actionChoisie=actionchoisie;
	}
	public void setDirectionChoisie(Direction directionchoisie)
	{
		directionChoisie= directionchoisie;
	}	
	public String toString()
	{
		String s="\nEquipe : "+equipe.getId() +"\nAction : "+actionChoisie+"\nDirection : "+directionChoisie;
		
		return s;
	}
	
	
}
