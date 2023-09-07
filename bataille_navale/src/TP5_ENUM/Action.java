package TP5_ENUM;

public enum Action {
DEPLACEMENT(1), TIR(2), PECHE(3);
	
	//private attribut
	private int intaction;
		
			//constructeur
			private Action (int a)
			{
				this.intaction=a;
			}
			
			public Integer getint ()
			{
				return this.intaction;
			}
}
