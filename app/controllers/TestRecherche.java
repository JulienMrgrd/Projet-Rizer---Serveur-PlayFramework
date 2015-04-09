package controllers;

import service.UtilsService;

public class TestRecherche {

	public static void main(String[] args){
		long startTime = System.currentTimeMillis();
		UtilsService.searchArtist("Michael Jackson");
		long endTime = System.currentTimeMillis();

		long duration = (long) ((endTime - startTime)/1000.0);
		System.out.println("Durée : "+ duration);
		
	}
}
