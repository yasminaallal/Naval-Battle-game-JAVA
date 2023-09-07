package TP5_ENUM;


public enum Direction {
NORD(1), SUD(2), EST(3),OUEST(4);
	
	//private attribut
	private int intdirection;
		
			//constructeur
			private Direction (int a)
			{
				this.intdirection=a;
			}
			
			public Integer getint ()
			{
				return this.intdirection;
			}
}
