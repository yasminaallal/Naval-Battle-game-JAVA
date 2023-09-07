package TP5_ALLAL;

import TP5_ENUM.Nature;
import TP5_ENUM.Statut;
import TP5_ENUM.TypeNav;

public class EqBataillon extends Equipe{
	
	public EqBataillon(int idEq, Nature n) {
		super(n) ;
		myStatut = Statut.MILITAIRE ;
		ident = idEq ;
		TypeNav sousmarin = TypeNav.SOUSMARIN;
		TypeNav destroyer = TypeNav.DESTROYER;
		//__
		Navire sousmarin1 = new Navire (1,sousmarin, idEq);
		sousmarin1.portee= 2 ;
		sousmarin1.vitesse= 5;
		sousmarin1.vie= 1;
		//___
		Navire destroyer2 = new Navire (2,destroyer, idEq);
		destroyer2.portee= 1 ;
		destroyer2.vitesse= 6;
		destroyer2.vie= 3;
		//____
		Navire destroyer3 = new Navire (3,destroyer, idEq);
		destroyer3.portee= 2 ;
		destroyer3.vitesse= 4;
		destroyer3.vie= 3;
		//__
		listeNavire.add(sousmarin1);
		listeNavire.add(destroyer2);
		listeNavire.add(destroyer3);
		}

}
