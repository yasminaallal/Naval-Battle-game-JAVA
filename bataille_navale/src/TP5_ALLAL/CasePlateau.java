package TP5_ALLAL;
import TP5_Exception.*;
import java.util.ArrayList;


// classe finie mais pas testé
public class CasePlateau {

	//----------
	//attributs
	//__________
	
	private ArrayList<Navire> lesOccupants;
	
	//------------
	//constructeurs
	//_____________
	public CasePlateau()
	{
		lesOccupants = new ArrayList<Navire>();
	}
	//---------
	//methodes
	//____________
	public ArrayList<Navire> getLesOccupants()
	{
		return this.lesOccupants;
	}
	
	
	public void addUnOccupant (Navire nouvelOccupant) throws OccupException
	{
		// parcourir vector si le type ex
		if(lesOccupants.size()==0)
		{
			
			lesOccupants.add(nouvelOccupant);
		}
			
		else
		{
			
			for (int i=0 ; i<lesOccupants.size(); i++)
			{
				if(nouvelOccupant.getType() ==lesOccupants.get(i).getType() || ( nouvelOccupant.getType().getabre()   =="C" && lesOccupants.get(i).getType().getabre()  =="D" ) || ( nouvelOccupant.getType().getabre()  =="D" && lesOccupants.get(i).getType().getabre()  =="C" ) )                               
					throw new OccupException("PLACE OCCUPÉ");
			}
		
			lesOccupants.add(nouvelOccupant);
		}
	}
	
	public String toString()
	{
		String s="";
		if(lesOccupants.size()==0)
		{
			s="|          |";
		}
		else 
		{
			s="|";
			for (int i=0 ; i<lesOccupants.size(); i++)
			{			
			   s=s+lesOccupants.get(i).toString();
			}
			if(lesOccupants.size()==1)
			{
				s=s+"     |";
			}
			else
			{
				s=s+"|";
			}
		}
		return s;
	}
	
	public boolean estOccupee()
	{
		if(lesOccupants.size()==0)
			return false;
		return true;
	}
	
	public boolean estPleine()
	{
		if(lesOccupants.size()==2)
			return true;
		return false;
	}
	
	// methode affichage???
	
	public void removeUnOccupant(Navire navire) 
	{
		int i=0;
			for ( i=0 ; i<lesOccupants.size(); i++)
			{
				if (lesOccupants.get(i).getIdent().equals(navire.getIdent()))
				{  
					break;}		
			}

				lesOccupants.remove(i);	
	}
	
	
}
