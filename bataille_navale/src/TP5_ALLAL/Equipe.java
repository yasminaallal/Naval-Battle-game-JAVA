package TP5_ALLAL;
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import TP5_INTERFACE.*;
import TP5_ENUM.*;

// classe copier du pdf

public class Equipe implements JHumain, JIA {

	//attributs
	protected ArrayList<Navire> listeNavire;
	protected Statut myStatut;
	protected Commande myCommande;
	protected Nature myNature ;
	public int ident ;
	private Random rd;
	private Scanner sc;
	
	//constructeur
	public Equipe(Nature n) 
	{
		this.listeNavire = new ArrayList<Navire>() ;
		this.myNature = n;
		rd = new Random() ;
		sc = new Scanner(System.in);
		
	}
	
	
	public void setStatut(Statut s) 
	{
		myStatut = s ;
	}
	
	public Statut getStatut() 
	{
		return myStatut;
	}
	
	public Commande getCommande() 
	{
		if (myNature == Nature.HUMAIN)
				interrogationParClavier() ;
		else
				tirageAleatoire() ;
		System.out.println("\n\n\tCommande de l’equipe "+ident+" "+myCommande);
		return myCommande;
	}
	
	public void tirageAleatoire() 
	{
		for(int  i=0; i<listeNavire.size();i++)
		{
			System.out.println(listeNavire.get(i).carac());
			
		}
		int idNav = rd.nextInt(listeNavire.size()) ;
		idNav = listeNavire.get(idNav).getIdent() ;
		int idAction = rd.nextInt(2) ;
		if ((myStatut == Statut.NEUTRE) &&(idAction == 1))
				idAction ++ ;
		int idDirection = rd.nextInt(4) ;
		myCommande = new Commande(this,idNav,idAction,idDirection) ;
	}
	
	
	public void interrogationParClavier() 
	{
		String strIdNav = "" ;
		String strAction = "" ;
		String strDirection = "" ;
		int size=0;
		int id;
		for(int  i=0; i<listeNavire.size();i++)
		{
			System.out.println(listeNavire.get(i).carac());
			
		}
		size=listeNavire.size();
		if(size==3)
			System.out.println("\n\nVeuillez saisir le numero du navire qui va agir (de 1 a "+(listeNavire.size())+") :");
		else if(size ==2)
			System.out.println("\n\nVeuillez saisir le numero du navire qui va agir (de "+ listeNavire.get(0).getRang()+" a "+listeNavire.get(1).getRang()+") :");
		else
			System.out.println("\n\nVeuillez saisir le numero du navire qui va agir ( "+ listeNavire.get(0).getRang()+" )");
		strIdNav = sc.nextLine();
		System.out.println("Vous avez saisi : " + strIdNav);
		int i;
		for( i=0; i<listeNavire.size();i++)
		{
			if( getlisteNavire().get(i).rang==Integer.parseInt(strIdNav) )
			{
				break;
			}
			
		}
		id= getlisteNavire().get(i).getIdent();
		strIdNav=""+id;
		if (myStatut == Statut.MILITAIRE)
			System.out.println("Veuillez saisir l’action a faire (DEPLACEMENT, TIR) :");
		else
			System.out.println("Veuillez saisir l’action a faire (DEPLACEMENT, PECHE) :");
		strAction = sc.nextLine();
		System.out.println("Vous avez saisi : " + strAction);
			System.out.println("Veuillez saisir la direction ds laquelle agir (NORD, SUD, EST, OUEST) :");
			strDirection = sc.nextLine();
			System.out.println("Vous avez saisi : " + strDirection);
			myCommande = new Commande(this,strIdNav,strAction,strDirection) ;
}
	
	public String toString() 
	{
		return "Equipe "+ident+" (" + myStatut + "," + myNature + "), avec " + listeNavire;
	}
	
	public void addNavire(Navire nav) 
	{
		listeNavire.add(nav) ;
	}

	public Integer getId() 
	{
		return ident;
	}

	public Nature getnature() 
	{
		return myNature;
	}

	public ArrayList <Navire> getlisteNavire() {
		
		return listeNavire;
	}
		
}






