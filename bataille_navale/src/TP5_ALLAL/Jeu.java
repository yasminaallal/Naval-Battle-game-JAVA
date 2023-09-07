package TP5_ALLAL;

import java.util.ArrayList;
import java.util.Random;
//import java.util.Scanner;
import java.awt.Point;
//import TP5_INTERFACE.*;
import TP5_ENUM.Direction;
import TP5_ENUM.Etat;
import TP5_ENUM.Nature;
//import TP5_ENUM.TypeNav;
//import TP5_ENUM.TypeNav;
import TP5_Exception.OccupException;

public class Jeu {

	//attributs
	public  Boolean fini;
	public  ArrayList<Equipe> listeequipes;
	public  Plateau lePlateau;
	
	//constructeurs
	public Jeu(int taille)
	{
		//_______
		lePlateau= new Plateau (taille);
		fini=false;
		listeequipes = new ArrayList<Equipe>();
		//____________
		
	}
	
	//methodes
	public void choixJoueurs(Jeu jeu)

	{
		 
		Nature humain = Nature.HUMAIN;
		Nature ia = Nature.IA;
		Nature nature;
		nature=Nature.randomNature();
		EqPecheur joueur1 = new EqPecheur(1, nature);
		System.out.println(joueur1.toString());
		jeu.listeequipes.add(joueur1);
		// si le joueur pecheur est lordinateur
		if(nature==ia)
		{
			// les deux autres joueurs humain militaires
			EqBataillon joueur2 = new EqBataillon(2, humain);
			EqBataillon joueur3 = new EqBataillon(3, humain);
			jeu.listeequipes.add(joueur2);
			jeu.listeequipes.add(joueur3);
			System.out.println(joueur2.toString());
			System.out.println(joueur3.toString());

		}
		//sinon le joueur pecheur est humain
		else
		{
			nature=Nature.randomNature();
			EqBataillon joueur2 = new EqBataillon(2, nature);
			jeu.listeequipes.add(joueur2);
			System.out.println( joueur2.toString());
			
			if(nature == ia)
			{
				EqBataillon joueur3 = new EqBataillon(3, humain);			
				jeu.listeequipes.add(joueur3);	
				System.out.println(joueur3.toString());
			}
			else
			{
				EqBataillon joueur3 = new EqBataillon(3, ia);			
				jeu.listeequipes.add(joueur3);	
				System.out.println(joueur3.toString());
			}
		}
	}
	 
	public  void attributionNavire(Jeu jeu)
	{
		Random random = new Random();
		int x,y;
		
		for(int i =0; i<jeu.listeequipes.size();i++)
		{
			for(int j =0; j<jeu.listeequipes.get(i).getlisteNavire().size();j++)
			{
				do
				{ x = random.nextInt(jeu.lePlateau.myTaille);
		          y = random.nextInt(jeu.lePlateau.myTaille);
				} while (jeu.lePlateau.matrice[x][y].estOccupee());
		        try {
		        	Point position = new Point (x,y);
		        	jeu.listeequipes.get(i).getlisteNavire().get(j).setPosition(position);
		        	jeu.lePlateau.matrice[x][y].addUnOccupant(jeu.listeequipes.get(i).getlisteNavire().get(j));
		        	
				} catch (OccupException e) {
					System.err.println("Redemarrer programme");
					System.exit(1);
				}
		       
			}
		}
		
	}

	public void JeuCasTirouPeche(Jeu jeu, Commande cmd)
	{
		//int porte;
		//Scanner sc = new Scanner(System.in);
		Direction est = Direction.EST;
		Direction ouest = Direction.OUEST;
		Direction nord = Direction.NORD;
		int x,y;
		double k,v;
		Boolean limite=false;
		int id=cmd.getidNavire();
		Equipe equipe = cmd.getEquipe();
		
		int i=0;
		for( i=0; i<equipe.listeNavire.size();i++)
		{
			if( equipe.getlisteNavire().get(i).ident==id)
			{
				break;
			}
			
		}
		k=equipe.listeNavire.get(i).getPosition().getX() ;
		v=equipe.listeNavire.get(i).getPosition().getY() ;
		System.out.println("Navire : "+equipe.getlisteNavire().get(i).toString()+"\nSa portée : "+equipe.getlisteNavire().get(i).portee);
			
			for(int j=0;j<equipe.getlisteNavire().get(i).portee; j++)
			{
					limite=false;
					x =equipe.getlisteNavire().get(i).getPosition().x;
					y = equipe.getlisteNavire().get(i).getPosition().y;
					if(  cmd.getDirectionChoisie()==est)
						{				
							equipe.getlisteNavire().get(i).getPosition().setLocation(x, y-1);
							if(y -1<=0)
							{
								if(y==0) break;
								equipe.getlisteNavire().get(i).getPosition().setLocation(x, 0);
								limite=true;
							}
						
					}
				  else if(  cmd.getDirectionChoisie()==ouest)
					{
						equipe.getlisteNavire().get(i).getPosition().setLocation(x, y+1);
						if(y+1 > lePlateau.myTaille -1)
						{
							if(y==lePlateau.myTaille -1) break;
							equipe.getlisteNavire().get(i).getPosition().setLocation(x, lePlateau.myTaille -1);
							limite=true;
						}
						
					}		
				else if(  cmd.getDirectionChoisie()==nord)
					{
					   equipe.getlisteNavire().get(i).getPosition().setLocation(x-1, y);
						if(x-1 <=0)
						{
							if(x==0) break;
							equipe.getlisteNavire().get(i).getPosition().setLocation(0, y);						
							limite=true;
						}
					}
				else
					{
					equipe.getlisteNavire().get(i).getPosition().setLocation(x+1, y);
						if(x+1  >lePlateau.myTaille -1)
						{
							if(x==lePlateau.myTaille -1) break;
							equipe.getlisteNavire().get(i).getPosition().setLocation(lePlateau.myTaille -1, y);
							limite=true;
						}
					}
					x =equipe.getlisteNavire().get(i).getPosition().x;
					y = equipe.getlisteNavire().get(i).getPosition().y;
					
					// si la case n'est pas vide
				if (jeu.lePlateau.matrice[x][y].getLesOccupants().size()>0)
				{
								
								jeu.lePlateau.matrice[x][y].getLesOccupants().get(0).vie --;
								
								if(jeu.lePlateau.matrice[x][y].getLesOccupants().get(0).vie==0)
								{
									Etat etatcoule = Etat.COULE;									
									jeu.lePlateau.matrice[x][y].getLesOccupants().get(0).etat=etatcoule;
									System.err.println("Navire "+jeu.lePlateau.matrice[x][y].getLesOccupants().get(0).toString()+"COULÉ");
									int out=0, nav=0;
									int keep=0,b=0;
									for( out=0; out<jeu.listeequipes.size();out++)
									{
										nav=0;
						
										for( nav=0; nav<jeu.listeequipes.get(out).getlisteNavire().size();nav++)
										{
											//System.out.println(jeu.lePlateau.matrice[x][y].getLesOccupants().get(0).toString()+""+jeu.listeequipes.get(out).getlisteNavire().get(nav)+" "+jeu.lePlateau.matrice[x][y].getLesOccupants().get(0).toString().compareTo(jeu.listeequipes.get(out).getlisteNavire().get(nav).toString()));
				
											if(jeu.lePlateau.matrice[x][y].getLesOccupants().get(0).toString().compareTo(jeu.listeequipes.get(out).getlisteNavire().get(nav).toString())==0)      
												{ keep=out;
												  b=nav;
												  break; }
										}
										//System.out.println("out =" +out + "nav =" +nav);
									}
									//System.out.println(jeu.lePlateau.matrice[x][y].getLesOccupants().get(0).toString()+""+jeu.listeequipes.get(keep).getlisteNavire().get(b));
									jeu.listeequipes.get(keep).listeNavire.remove(b);
									jeu.lePlateau.matrice[x][y].getLesOccupants().remove(0);
									System.out.println("\n\tEQUIPE REDUITE A :\n\t\t"+jeu.listeequipes.get(keep).listeNavire.toString());
								}
								else if(jeu.lePlateau.matrice[x][y].getLesOccupants().get(0).vie<0) 
									jeu.lePlateau.matrice[x][y].getLesOccupants().get(0).vie=0;
								else
								{
									Etat etattouche = Etat.TOUCHE;
									jeu.lePlateau.matrice[x][y].getLesOccupants().get(0).etat=etattouche;
									System.err.println("Navire "+jeu.lePlateau.matrice[x][y].getLesOccupants().get(0).toString()+"TOUCHÉ");
								}															
			
		       	}
				
				if (limite == true)
					{
						break;
					}
			}
				equipe.getlisteNavire().get(i).getPosition().setLocation(k, v);
				
	}

	public void JeuCasDeplacement(Jeu jeu, Commande cmd)
	{
		Direction est = Direction.EST;
		Direction ouest = Direction.OUEST;
		Direction nord = Direction.NORD;
		int id=cmd.getidNavire();
		Equipe equipe = cmd.getEquipe();
		
		int i;
		for( i=0; i<equipe.listeNavire.size();i++)
		{
			if( equipe.getlisteNavire().get(i).ident==id)
			{
				break;
			}
			
		}
		int vitesse=equipe.listeNavire.get(i).getVitesse()  ;
		System.out.println("Navire : "+equipe.getlisteNavire().get(i).toString()+"\nSa vitesse : "+vitesse);
		int x=equipe.listeNavire.get(i).getPosition().x ;
		int y= equipe.listeNavire.get(i).getPosition().y;
		int k=equipe.listeNavire.get(i).getPosition().x ;
		int v= equipe.listeNavire.get(i).getPosition().y;		
		if(  cmd.getDirectionChoisie()==est)
		{
			if(y-vitesse < 0)
				equipe.listeNavire.get(i).getPosition().setLocation(x, 0);
			else
				equipe.listeNavire.get(i).getPosition().setLocation(x, y-vitesse);
			
		}
		else if(  cmd.getDirectionChoisie()==ouest)
		{
			equipe.listeNavire.get(i).getPosition().setLocation(x, y+vitesse);
			if(y+vitesse >= jeu.lePlateau.myTaille)
				equipe.listeNavire.get(i).getPosition().setLocation(x, jeu.lePlateau.myTaille-1);
		}
		else if(  cmd.getDirectionChoisie()==nord)
		{
			equipe.listeNavire.get(i).getPosition().setLocation(x-vitesse, y);
			if(x-vitesse < 0)
				equipe.listeNavire.get(i).getPosition().setLocation(0, y);
		}
		else
		{
			equipe.listeNavire.get(i).getPosition().setLocation(x+vitesse, y);
			if(x+vitesse >= jeu.lePlateau.myTaille)
				equipe.listeNavire.get(i).getPosition().setLocation(jeu.lePlateau.myTaille-1, y);
		}
		x=equipe.listeNavire.get(i).getPosition().x ;
		y= equipe.listeNavire.get(i).getPosition().y;

		try {
			jeu.lePlateau.matrice[x][y].addUnOccupant(equipe.listeNavire.get(i));
			jeu.lePlateau.matrice[k][v].removeUnOccupant(equipe.getlisteNavire().get(i));
		} catch (OccupException e) {
			
			System.err.println(e.getMessage());
		}
	
	
		
	}
	
	public void checkfinpartie(Jeu jeu)
	{
		int size1,size2,size3;
		size1=jeu.listeequipes.get(0).getlisteNavire().size();
		size2=jeu.listeequipes.get(1).getlisteNavire().size();
		size3=jeu.listeequipes.get(2).getlisteNavire().size();
		if(size1==0)
			{ System.err.println("L'equipe "+ jeu.listeequipes.get(0).getId()+" a perdu");
			 jeu.fini=true ;
			 }
		if(size2==0)
		{ System.err.println("L'equipe "+ jeu.listeequipes.get(1).getId()+" a perdu");
		  jeu.fini=true ;
		  }
		if(size3==0)
		{
		  System.err.println("L'equipe "+ jeu.listeequipes.get(2).getId()+" a perdu");
		  jeu.fini=true ;
		 }
		
	}
	public void checkgagnant(Jeu jeu)
	{
		int size1,size2,size3;
		size1=jeu.listeequipes.get(0).getlisteNavire().size();
		size2=jeu.listeequipes.get(1).getlisteNavire().size();
		size3=jeu.listeequipes.get(2).getlisteNavire().size();
		if(size1<size2 && size1<size3)
		{
			System.err.println("L'equipe "+ jeu.listeequipes.get(0).getId()+" a perdu");
		}
		else if(size2<size1 && size2<size3)
		{
			System.err.println("L'equipe "+ jeu.listeequipes.get(1).getId()+" a perdu");
		}
		else if(size3<size1 && size3<size2)
		{
			System.err.println("L'equipe "+ jeu.listeequipes.get(2).getId()+" a perdu");
		}
		else if (size2==size1 && size2==size3)
		{
			System.err.println("Aucune equipe n'a perdu!");
		}
		else if (size2==size1 && size2<size3)
		{
			
			System.err.println("Les equipes "+ jeu.listeequipes.get(0).getId()+" et "+jeu.listeequipes.get(1).getId()+"ont perdu");
		}
		else if (size2==size3 && size2<size1)
		{
			System.err.println("Les equipes "+ jeu.listeequipes.get(1).getId()+" et "+jeu.listeequipes.get(2).getId()+"ont perdu");
		}
		else if (size1==size3 && size1<size2)
		{
			System.err.println("Les equipes "+ jeu.listeequipes.get(0).getId()+" et "+jeu.listeequipes.get(2).getId()+"ont perdu");
		}
	}
}
