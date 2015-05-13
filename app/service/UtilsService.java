package service;

import java.util.ArrayList;
import java.util.List;

import models.Album;
import models.Artist;
import models.Music;
import utils.recherche.api_gracenote.webapi.GracenoteException;
import utils.recherche.api_gracenote.webapi.GracenoteWebAPI;
import utils.recherche.threadRecherche.MonThreadArtiste;
import utils.recherche.threadRecherche.ThreadMusic;

public class UtilsService{
	
	
	/**
	 * Recherche un artiste dans la base et dans la base de Gracenote
	 * @param research La chaine de caractere
	 * @return la liste des resultats
	 */
	public static List<Artist> searchArtist(String research) {
		Object sync = new Object();
		List<String> resultats_Artiste = null;	
		ThreadMusic threadArtiste = new MonThreadArtiste(getAPIGracenote(), research, sync);
		threadArtiste.start();
		
		List<String> recales = null;	
		
		synchronized (sync) {
			try {
				sync.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Les 3 threads ont finis !\n");
		
		resultats_Artiste = threadArtiste.getListResultats();
		
		recales = threadArtiste.getListRecales();
		
		supprimerDoublons(resultats_Artiste, recales);
		
		System.out.println("\n===========\t============\t============");
		System.out.println("\nResultats pour artistes :");
		if(resultats_Artiste!= null && !resultats_Artiste.isEmpty()){
			for(String str : resultats_Artiste){
				if(str!=null) System.out.println("\t"+str);
			}
		} else {
			System.out.println("\tAucun resultat");
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

		return listNamesToListArtist(resultats_Artiste);
	}

	/**
	 * Recherche un album dans la base et dans la base de Gracenote
	 * @param research La chaine de caractere
	 * @return la liste des resultats
	 */
	public List<Album> searchAlbum(String research) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Recherche un musique dans la base et dans la base de Gracenote
	 * @param research La chaine de caractere
	 * @return la liste des resultats
	 */
	public List<Music> searchMusic(String research) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Retourne la liste des artistes recommandes pour ce compte
	 * @param idAccount l'id du compte
	 * @return la liste des resultats
	 */
	public static List<Artist> recommendArtist(int idAccount) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Retourne la liste des albums recommandes pour ce compte
	 * @param idAccount l'id du compte
	 * @return la liste des resultats
	 */
	public static List<Album> recommendAlbum(int idAccount) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Retourne la liste des musiques recommandees pour ce compte
	 * @param idAccount l'id du compte
	 * @return la liste des resultats
	 */
	public static List<Music> recommendMusic(int idAccount) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	///////////////// METHODES PRIVEES /////////////////
	
	
	
	/** Supprime tous les doublons de la liste, tout en conservant l'ordre d'origine
	 * 
	 * @param listes de String
	 */
	@SafeVarargs
	private static void supprimerDoublons(List<String> ... listes) {
		
		Music u = new Music(null, null, null, null, null, null, null, null);
		u.getAlbum();
		
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
	
	private static GracenoteWebAPI getAPIGracenote(){
		try
		{
			String clientID = "12383232-C16B17D826EA99FE7123A650AC420AAC"; // Put your clientID here.
			String clientTag = "C16B17D826EA99FE7123A650AC420AAC"; // Put your clientTag here.
			GracenoteWebAPI api = new GracenoteWebAPI(clientID, clientTag); // If you have a userID, you can specify it as the third parameter to constructor.
			return api;
		} catch (GracenoteException e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	private static List<Artist> listNamesToListArtist(List<String> resultats_Artiste) {
		if(resultats_Artiste == null) return null;
		
		List<Artist> artistes = new ArrayList<>();
		Artist art_tmp;
		for(String str : resultats_Artiste){
			art_tmp = new Artist();
			art_tmp.setPseudo(str);
			artistes.add(art_tmp);
		}
		return artistes;
	}

	
}
