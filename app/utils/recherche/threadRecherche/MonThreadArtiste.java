package utils.recherche.threadRecherche;

import java.util.ArrayList;
import java.util.List;

import utils.recherche.api_gracenote.webapi.GracenoteException;
import utils.recherche.api_gracenote.webapi.GracenoteMetadata;
import utils.recherche.api_gracenote.webapi.GracenoteWebAPI;
import utils.recherche.utils.*;

public class MonThreadArtiste extends ThreadMusic{
	
	private Object sync;
	private List<String> resultats;
	private List<String> recales;
	private String chaine;
	
	private int FLAG_ALL_FINISH;
	private int nb_Threads;
	
	public MonThreadArtiste(GracenoteWebAPI api, String chaine, Object sync) {
		super(api);
		this.sync = sync;
		this.chaine=chaine;
	}

	public void run(){
	       searchArtiste(chaine);
    }
	
	private void searchArtiste( final String chaine ){
		resultats = new ArrayList<String>();
		recales = new ArrayList<String>();
    	final Object verrou = new Object();
    	nb_Threads = 0;
    	FLAG_ALL_FINISH = 0;
    	
    	new Thread(new Runnable() { public void run() { 
    		apiSearchArtiste(chaine, verrou);
    		FLAG_ALL_FINISH++;
    		synchronized (verrou){
    			verrou.notify();
    		}
		}}).start();
    	nb_Threads++;
    	
    	final String[] tab = chaine.split(" ");
    	if(tab.length > 1){
    		for(final String s : tab){
	    		new Thread(new Runnable() { public void run() { 
	        		apiSearchArtiste(s, verrou);
	        		FLAG_ALL_FINISH++;
	        		synchronized (verrou){
	        			verrou.notify();
	        		}
	    		}}).start();
	        	nb_Threads++;
	    	}
    	}
    	
    	synchronized (verrou) {
			while(FLAG_ALL_FINISH < nb_Threads){
				try {
					verrou.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
    	
    	synchronized (sync) {
			sync.notify();
			super.setListResultats(resultats);
			super.setListRecales(recales);
		}
    }
	
	private void apiSearchArtiste(String texte, Object verrou){
		
		GracenoteMetadata temp = null;
		try{
			temp = api.searchArtist(texte);
		} catch (GracenoteException ge){ }
		
    	if(temp!=null && temp.getAlbums() != null){
			String str_tmp = (String) temp.getAlbum(0).get("album_artist_name");
			if(str_tmp!=null && !str_tmp.equals("null")){
				if(str_tmp.toLowerCase().contains(texte.toLowerCase()) || texte.toLowerCase().contains(str_tmp.toLowerCase()) 
				   || Similarite.similarity(str_tmp,texte)>Similarite.SEUIL_MINIMUM)
					
					synchronized (verrou) {
						resultats.add(str_tmp);
					}
    				
				
    			else {
    				synchronized (verrou) {
    					recales.add("Artiste : "+str_tmp);
    				}
    			}
			}
    	}
	}

}
