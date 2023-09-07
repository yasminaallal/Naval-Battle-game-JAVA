package TP5_ALLAL;


public class Plateau {

	// attributs
	public int myTaille;
	public CasePlateau matrice [][];
	
	// constructeurs
	public Plateau (int taille)
	{
		this.myTaille=taille;
		this.matrice = new CasePlateau[taille][taille];
		for (int i =0; i< this.myTaille ; i++)
		{
			for (int j =0; j< this.myTaille ; j++)
			{
				this.matrice[i][j]= new CasePlateau();
			}
		}
	}
	
	//methodes
	public void affichage()
	{
		System.out.println(this.toString());
	}
	
	public String toString()
	{
		String s="";
		for(int i=0; i<this.myTaille;i++)
	    	s=s+"____________";
		s=s+"\n";
		for (int i =0; i< this.myTaille ; i++)
		{
			//s=s+"|";
			for (int j =0; j< this.myTaille ; j++)
			{
				s=s+ this.matrice[i][j].toString();
			}
			s=s+"\n";
		}
		for(int i=0; i<this.myTaille;i++)
	    	s=s+"____________";
		s=s+"\n";
		return s;
	}
	public Integer getTaille()
	{
		return this.myTaille;
	}
	public CasePlateau getCasePlateau(int nl, int nc )
	{
		return this.matrice[nl][nc];
	}
	
	
	
}
