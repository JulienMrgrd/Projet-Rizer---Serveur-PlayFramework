package utils.recherche.utils;

import java.util.List;

import utils.recherche.apiGracenote.gracenote.webapi.GracenoteWebAPI;
import utils.recherche.threadRecherche.*;


public class Recherche {
	
	private GracenoteWebAPI api;

	public Recherche(GracenoteWebAPI api){
		this.api = api;
	}
	
	/**
	 * Affiche tous les resultats (Artistes, Albums, Tracks) de la recherche
	 * @param chaine
	 */
	@SuppressWarnings("unchecked")
	public void displayResults( final String chaine ){
    	Object sync = new Object();
    	int cpt = 0;
		List<String> resultats_Artiste = null;	
		ThreadMusic threadArtiste = new MonThreadArtiste(api, chaine, sync);
		threadArtiste.start();
		
		List<String> resultats_Album = null;	
		ThreadMusic threadAlbum = new MonThreadAlbum(api, chaine,  sync);
		threadAlbum.start();
		
		List<String> resultats_Track = null;	
		ThreadMusic threadTracks = new MonThreadTrack(api, chaine, sync);
		threadTracks.start();
		
		List<String> recales = null;	
		
		synchronized (sync) {
			while(cpt<3){
				try {
					sync.wait();
					cpt++;
					if(cpt==1) System.out.println("Ah,  bouge ... 1 thread a fini !");
					else if (cpt==2) System.out.println("Ca bouge encore ... 2 threads ont finis !");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println("Les 3 threads ont finis !\n");
		
		resultats_Artiste = threadArtiste.getListResultats();
		resultats_Album = threadAlbum.getListResultats();
		resultats_Track = threadTracks.getListResultats();
		
		recales = threadArtiste.getListRecales();
		recales.addAll(threadAlbum.getListRecales());
		recales.addAll(threadTracks.getListRecales());
		
		supprimerDoublons(resultats_Artiste, resultats_Album, resultats_Track, recales);
		
		System.out.println("\n===========\t============\t============");
		System.out.println("\nRultats pour artistes :");
		if(resultats_Artiste!= null && !resultats_Artiste.isEmpty()){
			for(String str : resultats_Artiste){
				if(str!=null) System.out.println("\t"+str);
			}
		} else {
			System.out.println("\tAucun rsultat");
		}
		
		System.out.println("\nRsultats pour albums :");
		if(resultats_Album!= null && !resultats_Album.isEmpty()){
			for(String str : resultats_Album){
				if(str!=null) System.out.println("\t"+str);
			}
		} else {
			System.out.println("\tAucun rsultat");
		}
		
		System.out.println("\nRsultats pour tracks :");
		if(resultats_Track!= null && !resultats_Track.isEmpty()){
			for(String str : resultats_Track){
				if(str!=null) System.out.println("\t"+str);
			}
		} else {
			System.out.println("\tAucun rsultat");
		}
		

		System.out.println("\n===========\t============\t============");
		System.out.println("\nListe des non-accepts :");
		if(recales!= null && !recales.isEmpty()){
			for(String str : recales){
				if(str!=null) System.out.println("\t"+str);
			}
		} else {
			System.out.println("\tAucun recal !");
		}
		
		System.out.println("\n============================================");
		System.out.println("=====\t===> Recherche termine <===\t====");
    }

	
	/** Supprime tous les doublons de la liste, tout en conservant l'ordre d'origine
	 * 
	 * @param listes de String
	 */
	@SuppressWarnings("unchecked") 
	public static void supprimerDoublons(List<String> ... listes) {
		
		if(listes !=null){
			String str_temp;
			for(List<String> one_liste : listes){
				
				// inutile d'enlever des doublons si une liste ne contient que 0 ou 1 seul element, ou est null.
				if(one_liste!=null && one_liste.size()>1){
					
						for(int i=0; i<one_liste.size(); i++){
							str_temp = one_liste.remove(i);
							
							// nettoyage
							while(one_liste.contains(str_temp)){
								one_liste.remove(str_temp);
							}
							
							// remet l'element a sa position d'origine
							one_liste.add(i,str_temp);
							
						}
					}
			}
		}
	}
	

}
