package TP5_ENUM;

public enum TypeNav {

	CHALUTIER("C"),DESTROYER("D"),SOUSMARIN("S");
	
		//private attribut
		private String abreviation;
	
		//constructeur
		private TypeNav (String abre)
		{
			this.abreviation=abre;
		}
		
		public String getabre ()
		{
			return this.abreviation;
		}
}
