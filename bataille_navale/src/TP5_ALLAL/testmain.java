package TP5_ALLAL;

import TP5_ENUM.Action;
import java.util.Scanner;
//import TP5_ENUM.Nature;

/*import java.util.Scanner;
import java.util.Random;
import java.util.Vector;
import TP5_INTERFACE.*;*/
/*import TP5_ENUM.*;
import TP5_Exception.OccupException;
import java.util.ArrayList;
import java.util.Random;
import java.awt.Point;
import TP5_INTERFACE.*;
import TP5_ENUM.Nature;*/

public class testmain {

	
	static void jouer() 
	{
		@SuppressWarnings("resource")
		Scanner sc1 = new Scanner(System.in);
		String taille="";
		int tailleint;
		do
		{System.out.println("\n\nVeuillez saisir la taille du plateau entre 5, 10, ou 20: ");
		taille = sc1.nextLine();
		tailleint=Integer.parseInt(taille);
		}while(tailleint!=5 && tailleint!=10 && tailleint!=20);
		Jeu jeu = new Jeu(tailleint);
		String tour;
		int touur;
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("\n\nVeuillez saisir le nombre de tours: ");
		tour = sc.nextLine();
		touur=Integer.parseInt(tour);
		jeu.choixJoueurs(jeu);
		jeu.attributionNavire(jeu); 
		jeu.lePlateau.affichage();	
		int interation=0;
		do {
			
			Action deplacement = Action.DEPLACEMENT;
			for(int i=0;i<jeu.listeequipes.size();i++)
			{
				
				Commande commande=jeu.listeequipes.get(i).getCommande();
				if( commande.getActionChoisie() == deplacement)
				{
					jeu.JeuCasDeplacement(jeu,  commande);
					jeu.lePlateau.affichage();	
				}
				else 
				{
					jeu.JeuCasTirouPeche(jeu,  commande);
					jeu.lePlateau.affichage();	
				}

			}
			interation++;
		jeu.checkfinpartie(jeu);
			
		if( touur==interation)
		{
			jeu.checkgagnant(jeu);
		}
		}while(touur  !=interation && !jeu.fini );
		
	}
	

public static void main (String args[]) {
	
	jouer();
	

	
}



}