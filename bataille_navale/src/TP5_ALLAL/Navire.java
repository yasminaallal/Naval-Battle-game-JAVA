package TP5_ALLAL;
import TP5_ENUM.*;
import java.awt.Point;
import java.util.Random;

//import java.lang.Math;

// classe navire : finie mais pas testé
// fonction deplacer

public class Navire {

	//_________
	//attributs
	//_________
	
	//identification unique pour chaque navire
	protected int ident;
	//type de navire
	protected TypeNav myType;
	//la position du navire
	protected Point position ;
    // strAffichage
	protected String straffichage;
	protected int rang; // nombre de bateau dans une equipe?
	protected int vie; // combien de fois tirer pour qu'il meurt
	//numero de l'equipe
	protected Integer numEq ;
	//etat = coule ou sain ou touche
	protected Etat etat;
	//porte specfique pour chaque type de navire aka u chalutier peut tier que a 50metres de lui
	protected int portee;
	//capacite de deplacement pour chaque navire 
	protected int vitesse;
	
	//___________
	//constructeur
	//____________
	public Navire (int rang,TypeNav t, int numEq)
	{
		Etat sain = Etat.SAIN;
		Random random = new Random();
		ident = random.nextInt(999999999);
		this.rang=rang;
		this.numEq= numEq;
		myType=t;
		position= new Point();
		etat=sain;
	}
	//___________
	//methodes
	//____________
	
	// redefinir equals des navires
	public boolean equals(Navire n)
	{
		if (this.ident== n.ident)
			return true;
		return false;
	}
	
	
	//__________________
	//setter
	//__________________
	public void setPosition(Point position)
	{
		this.position=position;
	}
	public void setTouche()
	{
		this.etat=Etat.TOUCHE;
	}	
	public void setCoule()
	{
		this.etat=Etat.COULE;
	}
	
	//__________________
	// is etat
	//__________________
	public Boolean estSain()
	{
		return (this.etat==Etat.SAIN);
	}
	
	public Boolean estTouche()
	{
		return (this.etat==Etat.TOUCHE);
	}
	
	public Boolean estCoule()
	{
		return (this.etat==Etat.COULE);
	}	
	
	// se deplacer
	//revenir quand on a fait plateau 
	// avoir coordonne x pos.getX()
	public void seDeplacer(Point pos)
	{
		position.setLocation( pos.getX() + position.getX() ,  pos.getY() + position.getY());
	}
	
	//__________________
	//getter
	//__________________
	
	public TypeNav getType()
	{
		return myType;
	}
	public Integer getIdent()
	{
		return this.ident;
	}
	public Integer getNumEquipe()
	{
		return this.numEq;
	}
	public Integer getVie()
	{
		return this.vie;
	}
	public Integer getRang()
	{
		return this.rang;
	}
	public Point getPosition()
	{
		return this.position;
	}
	public Integer getPortee()
	{
		return this.portee;
	}
	public Integer getVitesse()
	{
		return this.vitesse;
	}	
	
	//__________________
	//string to string
	//__________________

	public String toString ()
	{
		String s="";
		s= myType.getabre() + numEq.toString()+"("+rang+")";
		//
	    return s;
	}
	public String carac()
	{
		String s;
		s= "\nLes caracteristiques de ce navire "+this.toString()+"\n\tType du navire :"+this.myType+"\n\tEtat : "+this.etat+"\n\tVie:"+this.vie+"\n\tPortee:"+this.portee+"\n\tVitesse:"+this.vitesse;
		return s;
	}

}
