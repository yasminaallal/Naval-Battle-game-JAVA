package TP5_ALLAL;

import TP5_ENUM.Nature;
import TP5_ENUM.Statut;
import TP5_ENUM.TypeNav;

public class EqPecheur extends Equipe {
	
	public EqPecheur(int idEq, Nature n) {
		//________
		super(n) ;
		myStatut = Statut.NEUTRE ;
		ident = idEq ;
		//________
		TypeNav chalutier = TypeNav.CHALUTIER;
		Navire chalutier1 = new Navire (1,chalutier, idEq);
		chalutier1.portee= 5 ;
		chalutier1.vitesse= 1;
		chalutier1.vie= 1;
		//________
		Navire chalutier2 = new Navire (2,chalutier, idEq);
		chalutier2.portee= 5 ;
		chalutier2.vitesse= 1;
		chalutier2.vie= 1;
		//___________
		Navire chalutier3 = new Navire (3,chalutier, idEq);
		chalutier3.portee= 4 ;
		chalutier3.vitesse= 1;
		chalutier3.vie= 2;
		//____________
		listeNavire.add(chalutier1);
		listeNavire.add(chalutier2);
		listeNavire.add(chalutier3);

		}
}
