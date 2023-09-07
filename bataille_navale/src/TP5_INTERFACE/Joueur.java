package TP5_INTERFACE;
import TP5_ALLAL.*;
import java.util.ArrayList;
import TP5_ENUM.*;
//import TP5_INTERFACE.*;

public interface Joueur {
	public Commande getCommande();
	public Statut getStatut();
	public void addNavire (Navire nav);
	public ArrayList<Navire> getlisteNavire();
	public Integer getId();
}

