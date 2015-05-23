package service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import models.Album;
import models.Artist;
import models.Music;
import utils.RizerUtils;
import utils.recherche.gracenote.GracenoteException;
import utils.recherche.gracenote.GracenoteWebAPI;
import utils.recherche.utils.Similarite;
import dao.AlbumDao;
import dao.ArtistDao;
import dao.Dao;
import dao.MusicDao;

public class RechercheService{
	
	private final String SPLITTER = " ";
	
	private String search_str;
	
	public RechercheService(String search_str){
		if(search_str!=null) this.search_str = search_str;
		else search_str = "";
	}
	
	/**
	 * Recherche un artiste dans la base et dans la base de Gracenote
	 * @param search_str La chaine de caractere
	 * @return la liste des resultats
	 */
	@SuppressWarnings("unchecked")
	public List<Artist> searchArtist() {
		if(search_str.isEmpty()) return null;
		
		String[] search_str_split = null;
		if(search_str.contains(SPLITTER)) search_str_split = search_str.split(SPLITTER);
		Dao dao = new ArtistDao();
		Map<String, List<Artist> > resultats = new HashMap<String, List<Artist> >();
		
		List<Artist> artists_from_db = ((ArtistDao) dao).getArtistsContainsPseudo(search_str);
		
		if( ! artists_from_db.isEmpty() ) resultats = getMapWithNameAndArtist(artists_from_db);
		
		if(search_str_split!=null){
			for(String str : search_str_split){
				artists_from_db = ((ArtistDao) dao).getArtistsContainsPseudo(str);
				if( ! artists_from_db.isEmpty() ) resultats.putAll(getMapWithNameAndArtist(artists_from_db));
			}
		}
		
		if( ! resultats.isEmpty() ){
			removeNoSimilar(resultats, search_str);
			artists_from_db = (List<Artist>) orderBySimilarite( new HashMap< String,List<?> >(resultats) ); // l'instanciation d'une hashMap est obligatoire, car le cast est ici impossible
			supprimerDoublons( (List<Object>) (List<? extends Object>) artists_from_db );
		}
		
		if(! resultats.isEmpty() )	return artists_from_db;
		resultats.clear();
		List<String> all_split_with_half;
		if(search_str_split!=null){
			all_split_with_half = new ArrayList<String>( search_str_split.length*2);
			for(String str : search_str_split){
				all_split_with_half.addAll( Arrays.asList(splitInHalf(str)) );
			}
		} else {
			all_split_with_half = new ArrayList<String>( 2 );
			all_split_with_half.addAll( Arrays.asList(splitInHalf(search_str)) );
		}
		
		for(String half : all_split_with_half){
			artists_from_db = ((ArtistDao) dao).getArtistsContainsPseudo(half);
			if( ! artists_from_db.isEmpty() ) resultats.putAll(getMapWithNameAndArtist(artists_from_db));
		}
		
		if( ! resultats.isEmpty() ){
			removeNoSimilar(resultats, search_str);
			artists_from_db = (List<Artist>) orderBySimilarite( new HashMap< String,List<?> >(resultats) );
			supprimerDoublons( (List<Object>) (List<? extends Object>) artists_from_db );
		}
		if(! resultats.isEmpty() )	return artists_from_db;
		
		//TODO voir si intégration résultats de Gracenote
		else return null;

//		GracenoteMetadata data = null;
//		try{
//			data = getAPIGracenote().searchTrack(null, null, search_str);
//		} catch (GracenoteException ge){ }
//		
//    	if(data!=null && data.getAlbums() != null){
//			String str_tmp = (String) data.getAlbum(0).get("track_title");
//			if(str_tmp!=null && !str_tmp.equals("null")){
//    			if(str_tmp.toLowerCase().contains(str_tmp.toLowerCase()) || 
//    					str_tmp.toLowerCase().contains(str_tmp.toLowerCase()) 
//    			   || new Similarite().similarity(str_tmp,search_str) > RizerUtils.DEFAULT_SEUIL )
//    				
//    					resultats.add(str_tmp+" (de "+data.getAlbum(0).get("album_artist_name")+")");
//					}
//    				
//    			else {
//       					recales.add("Track : "+str_tmp+" (de "+temp.getAlbum(0).get("album_artist_name")+")");
//    			}
//			}
//    	}
	}

	/**
	 * Recherche un album dans la base et dans la base de Gracenote
	 * @param search_str La chaine de caractere
	 * @return la liste des resultats
	 */
	@SuppressWarnings("unchecked")
	public List<Album> searchAlbum() {
		if(search_str.isEmpty()) return null;
		
		String[] search_str_split = null;
		if(search_str.contains(SPLITTER)) search_str_split = search_str.split(SPLITTER);
		Dao dao = new AlbumDao();
		Map<String, List<Album> > resultats = new HashMap<String, List<Album> >();
		
		List<Album> albums_from_db = ((AlbumDao) dao).getAlbumsContainsName(search_str);
		
		if( ! albums_from_db.isEmpty() ) resultats = getMapWithNameAndAlbum(albums_from_db);
		
		if(search_str_split!=null){
			for(String str : search_str_split){
				albums_from_db = ((AlbumDao) dao).getAlbumsContainsName(str);
				if( ! albums_from_db.isEmpty() ) resultats.putAll(getMapWithNameAndAlbum(albums_from_db));
			}
		}
		
		if( ! resultats.isEmpty() ){
			removeNoSimilar(resultats, search_str);
			albums_from_db = (List<Album>) orderBySimilarite( new HashMap< String,List<?> >(resultats) ); // l'instanciation d'une hashMap est obligatoire, car le cast est ici impossible
			supprimerDoublons( (List<Object>) (List<? extends Object>) albums_from_db );
		}
		
		if(! resultats.isEmpty() )	return albums_from_db;
		resultats.clear();
		List<String> all_split_with_half;
		if(search_str_split!=null){
			all_split_with_half = new ArrayList<String>( search_str_split.length*2);
			for(String str : search_str_split){
				all_split_with_half.addAll( Arrays.asList(splitInHalf(str)) );
			}
		} else {
			all_split_with_half = new ArrayList<String>( 2 );
			all_split_with_half.addAll( Arrays.asList(splitInHalf(search_str)) );
		}
		
		for(String half : all_split_with_half){
			albums_from_db = ((AlbumDao) dao).getAlbumsContainsName(half);
			if( ! albums_from_db.isEmpty() ) resultats.putAll(getMapWithNameAndAlbum(albums_from_db));
		}
		
		if( ! resultats.isEmpty() ){
			removeNoSimilar(resultats, search_str);
			albums_from_db = (List<Album>) orderBySimilarite( new HashMap< String,List<?> >(resultats) );
			supprimerDoublons( (List<Object>) (List<? extends Object>) albums_from_db );
		}
		if(! resultats.isEmpty() )	return albums_from_db;
		
		//TODO voir si intégration résultats de Gracenote
		else return null;

//		GracenoteMetadata data = null;
//		try{
//			data = getAPIGracenote().searchTrack(null, null, search_str);
//		} catch (GracenoteException ge){ }
//		
//    	if(data!=null && data.getAlbums() != null){
//			String str_tmp = (String) data.getAlbum(0).get("track_title");
//			if(str_tmp!=null && !str_tmp.equals("null")){
//    			if(str_tmp.toLowerCase().contains(str_tmp.toLowerCase()) || 
//    					str_tmp.toLowerCase().contains(str_tmp.toLowerCase()) 
//    			   || new Similarite().similarity(str_tmp,search_str) > RizerUtils.DEFAULT_SEUIL )
//    				
//    					resultats.add(str_tmp+" (de "+data.getAlbum(0).get("album_artist_name")+")");
//					}
//    				
//    			else {
//       					recales.add("Track : "+str_tmp+" (de "+temp.getAlbum(0).get("album_artist_name")+")");
//    			}
//			}
//    	}
	}

	/**
	 * Recherche un musique dans la base et dans la base de Gracenote
	 * @param search_str La chaine de caractere
	 * @return la liste des resultats
	 */
	@SuppressWarnings("unchecked")
	public List<Music> searchMusic() {
		if(search_str.isEmpty()) return null;
		
		String[] search_str_split = null;
		if(search_str.contains(SPLITTER)) search_str_split = search_str.split(SPLITTER);
		Dao dao = new MusicDao();
		Map<String, List<Music> > resultats = new HashMap<String, List<Music> >();
		
		List<Music> musics_from_db = ((MusicDao) dao).getMusicsContainsName(search_str);
		
		if( ! musics_from_db.isEmpty() ) resultats = getMapWithNameAndMusic(musics_from_db);
		
		if(search_str_split!=null){
			for(String str : search_str_split){
				musics_from_db = ((MusicDao) dao).getMusicsContainsName(str);
				if( ! musics_from_db.isEmpty() ) resultats.putAll(getMapWithNameAndMusic(musics_from_db));
			}
		}
		
		if( ! resultats.isEmpty() ){
			removeNoSimilar(resultats, search_str);
			musics_from_db = (List<Music>) orderBySimilarite( new HashMap< String,List<?> >(resultats) ); // l'instanciation d'une hashMap est obligatoire, car le cast est ici impossible
			supprimerDoublons( (List<Object>) (List<? extends Object>) musics_from_db );
		}
		
		if(! resultats.isEmpty() )	return musics_from_db;
		resultats.clear();
		List<String> all_split_with_half;
		if(search_str_split!=null){
			all_split_with_half = new ArrayList<String>( search_str_split.length*2);
			for(String str : search_str_split){
				all_split_with_half.addAll( Arrays.asList(splitInHalf(str)) );
			}
		} else {
			all_split_with_half = new ArrayList<String>( 2 );
			all_split_with_half.addAll( Arrays.asList(splitInHalf(search_str)) );
		}
		
		for(String half : all_split_with_half){
			musics_from_db = ((MusicDao) dao).getMusicsContainsName(half);
			if( ! musics_from_db.isEmpty() ) resultats.putAll(getMapWithNameAndMusic(musics_from_db));
		}
		
		if( ! resultats.isEmpty() ){
			removeNoSimilar(resultats, search_str);
			musics_from_db = (List<Music>) orderBySimilarite( new HashMap< String,List<?> >(resultats) );
			supprimerDoublons( (List<Object>) (List<? extends Object>) musics_from_db );
		}
		if(! resultats.isEmpty() )	return musics_from_db;
		
		//TODO voir si intégration résultats de Gracenote
		else return null;

//		GracenoteMetadata data = null;
//		try{
//			data = getAPIGracenote().searchTrack(null, null, search_str);
//		} catch (GracenoteException ge){ }
//		
//    	if(data!=null && data.getAlbums() != null){
//			String str_tmp = (String) data.getAlbum(0).get("track_title");
//			if(str_tmp!=null && !str_tmp.equals("null")){
//    			if(str_tmp.toLowerCase().contains(str_tmp.toLowerCase()) || 
//    					str_tmp.toLowerCase().contains(str_tmp.toLowerCase()) 
//    			   || new Similarite().similarity(str_tmp,search_str) > RizerUtils.DEFAULT_SEUIL )
//    				
//    					resultats.add(str_tmp+" (de "+data.getAlbum(0).get("album_artist_name")+")");
//					}
//    				
//    			else {
//       					recales.add("Track : "+str_tmp+" (de "+temp.getAlbum(0).get("album_artist_name")+")");
//    			}
//			}
//    	}
	}
	
	
	///////////////// METHODES PRIVEES /////////////////
	
	/**
	 * Retourne une map<Nom de music, List<Music>, avec comme clé le nom de la musique en minuscule, et en valeur 
	 * la liste des musiques ayant ce nom (plusieurs musiques peuvent avoir le même titre)
	 * @param musics_from_db
	 * @return
	 */
	private Map<String, List<Music> > getMapWithNameAndMusic(List<Music> musics_from_db) {
		Map<String, List<Music> > map = new HashMap<String, List<Music> >();
		
		if (musics_from_db!=null){
			String music_db_name;
			
			for(Music music_db : musics_from_db){
				music_db_name = music_db.getName();
				
				List<Music> musics_in_map;
				if(map.containsKey(music_db_name)){
					musics_in_map = map.get(music_db_name);
					if( ! musics_in_map.contains(music_db) ) musics_in_map.add(music_db);
				} else {
					musics_in_map = new ArrayList<Music>();
					musics_in_map.add(music_db);
				}
				map.put(music_db_name.toLowerCase(), musics_in_map);
			}
		}
		return map;
	}
	
	/**
	 * Retourne une map<Nom d'album, List<Album>, avec comme clé le nom de l'album en minuscule, et en valeur 
	 * la liste des albums ayant ce nom (plusieurs albums peuvent avoir le même titre)
	 * @param albums_from_db
	 * @return
	 */
	private Map<String, List<Album> > getMapWithNameAndAlbum(List<Album> albums_from_db) {
		Map<String, List<Album> > map = new HashMap<String, List<Album> >();
		
		if (albums_from_db!=null){
			String album_db_name;
			
			for(Album album_db : albums_from_db){
				album_db_name = album_db.getTitle();
				
				List<Album> albums_in_map;
				if(map.containsKey(album_db_name)){
					albums_in_map = map.get(album_db_name);
					if( ! albums_in_map.contains(album_db) ) albums_in_map.add(album_db);
				} else {
					albums_in_map = new ArrayList<Album>();
					albums_in_map.add(album_db);
				}
				map.put(album_db_name.toLowerCase(), albums_in_map);
			}
		}
		return map;
	}
	
	/**
	 * Retourne une map<Nom d'artiste, List<Artiste>, avec comme clé le nom de l'artiste en minuscule, et en valeur 
	 * la liste des artistes ayant ce nom (plusieurs artistes PEUVENT avoir le même pseudo)
	 * @param albums_from_db
	 * @return
	 */
	private Map<String, List<Artist> > getMapWithNameAndArtist(List<Artist> artists_from_db) {
		Map<String, List<Artist> > map = new HashMap<String, List<Artist> >();
		
		if (artists_from_db!=null){
			String artist_db_name;
			
			for(Artist artist_db : artists_from_db){
				artist_db_name = artist_db.getPseudo();
				
				List<Artist> artists_in_map;
				if(map.containsKey(artist_db_name)){
					artists_in_map = map.get(artist_db_name);
					if( ! artists_in_map.contains(artist_db) ) artists_in_map.add(artist_db);
				} else {
					artists_in_map = new ArrayList<Artist>();
					artists_in_map.add(artist_db);
				}
				map.put(artist_db_name.toLowerCase(), artists_in_map);
			}
		}
		return map;
	}
	
	/**
	 * A partir d'une Map<Nom de l'objet, List<?> >, retourne la liste des objets, dont les noms sont triés par similarité
	 * @param resultats la map
	 * @return List<?> objets
	 */
	private List<?> orderBySimilarite(Map< String, List<? extends Object> > resultats) {
		if(resultats!=null){
			
			Map<Integer, List<String> > resultatsWithSimiLevel = new TreeMap<Integer, List<String> >(Collections.reverseOrder());
			int simi;
			for(String res : resultats.keySet()){
				if(res != null && !res.isEmpty()){
					simi = getSimilarite(res);
					if(resultatsWithSimiLevel.containsKey(simi)){
						resultatsWithSimiLevel.get( simi ).add(res);
					} else {
						resultatsWithSimiLevel.put( simi , new ArrayList<String>( Arrays.asList(res) ) );
					}
				}
			}
			
			List< List<String> > resultatsWithSimiLevel_values = new ArrayList<>(resultatsWithSimiLevel.values());
			List<Object> list_results = new ArrayList<>();
			for(List<String> results_keys : resultatsWithSimiLevel_values ){
				for(String result_key : results_keys) 
					list_results.addAll( resultats.get(result_key) );
			}
			return list_results;	
		}
		return new ArrayList<>();
	}
	
	private void removeNoSimilar(Map<String, ?> resultats, String search){
		if(resultats!=null){
			List<String> keys = new ArrayList<String>(resultats.keySet());
			for( int i=0; i<keys.size(); i++){
				if(getSimilarite(keys.get(i)) < RizerUtils.DEFAULT_SEUIL) {
					resultats.remove(keys.get(i));
				}
			}
		}
	}
	
	private int getSimilarite(String word){
		if(word!=null){
			int i = new Similarite().similarity(word, search_str.toLowerCase()); 
			return i;
		}
		else return 0;
	}
	
	private String[] splitInHalf(String chaine){
		if(chaine==null) return new String[]{""};
		else if (chaine.length()<2) return new String[]{chaine};
		else {
			String[] str_return = new String[2];
			str_return[0] = chaine.substring(0, chaine.length()/2);
			str_return[1] = chaine.substring(chaine.length()/2,chaine.length());
			return str_return;
		}
	}


	/** Supprime tous les doublons de la liste, tout en conservant l'ordre d'origine
	 * 
	 * @param listes d'objet
	 */
	private static void supprimerDoublons(List<Object> liste) {
		Set<? extends Object> set_without_duplicate = new LinkedHashSet<>(liste);
		liste.clear();
		for(Object obj : set_without_duplicate){
			liste.add(obj);
		}
	}
	
	private GracenoteWebAPI getAPIGracenote(){
		try
		{
			GracenoteWebAPI api = new GracenoteWebAPI(RizerUtils.CLIENT_ID, RizerUtils.CLIENT_TAG); // If you have a userID, you can specify it as the third parameter to constructor.
			return api;
		} catch (GracenoteException e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	
	public static void main(String[] args){
		
		Dao dao = new MusicDao();
		
//		String[] new_musiques = new String[]{"Michael Jackson","Mickel jachson","Michel Jason","Michael Jackson","Mikael Jackson"};
//		Music tmp;
//		for(String music : new_musiques){
//			tmp = new Music();
//			tmp.setName(music);
//			try {
//				dao.addMusic(null, tmp);
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
		
		List<Music> s = ((MusicDao) dao).findAll();
		System.out.println("Musiques en base : ");
		for(Music music : s){
			System.out.println("      "+music.getName());
		}
		
		System.out.println("========================");
		
		String recherche = "myckaelle jackson";
		System.out.println(new Similarite().similarity("Michael Jackson", recherche));
		s = new RechercheService(recherche).searchMusic();
		System.out.println("Recherche avec : "+recherche);
		if(s!=null && !s.isEmpty()){
			for(Music music : s){
				System.out.println(music.getName());
			}
		} else {
			System.out.println("=> Aucun résultat");
		}
		
	}
	
}
