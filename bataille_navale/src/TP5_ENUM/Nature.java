package TP5_ENUM;

import java.util.Random;

public enum Nature {
	 HUMAIN,IA;
	 
	  public static Nature randomNature()  {
		  return Nature.values()[new Random().nextInt(Nature.values().length)];
		  }
	}
