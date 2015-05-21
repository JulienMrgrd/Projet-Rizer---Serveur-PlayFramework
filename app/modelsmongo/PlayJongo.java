package modelsmongo;


import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jongo.Jongo;
import org.jongo.MongoCollection;

import com.mongodb.DB;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.gridfs.GridFS;

public class PlayJongo {

    private MongoClient mongo = null;
    private Jongo jongo = null;
    private GridFS gridfs = null;
    private MongoClientURI uri =null;

    private PlayJongo() {

		//mongodb://localhost:27017/playjava
		uri  = new MongoClientURI("mongodb://admin:aqwzsx@ds059651.mongolab.com:59651/playjava"); 
        try {
			mongo = new MongoClient(uri);
		} catch (UnknownHostException e) {
			System.out.println("Erreur MongoClientURI incorrect");
			e.printStackTrace();
		}
        DB db = mongo.getDB(uri.getDatabase());
        jongo = new Jongo(db);
        gridfs = new GridFS(jongo.getDatabase());
    }
    
    private static class Holder {
    	private final static PlayJongo INSTANCE = new PlayJongo();
    }

    public static PlayJongo getInstance() {
        return Holder.INSTANCE;
    }

    public static Mongo mongo() {
        return getInstance().mongo;
    }

    public static Jongo jongo() {
        return getInstance().jongo;
    }

    public static GridFS gridfs() {
        return getInstance().gridfs;
    }

    public static MongoCollection getCollection(String name) {
        return getInstance().jongo.getCollection(name);
    }

    public static DB getDatabase() {
        return getInstance().jongo.getDatabase();
    }
    
    public static List toArray(Iterator iter){
    	List result=new ArrayList();
    	while(iter.hasNext()){
    		result.add(iter.next());
    	}
    	
    	return result;
    }
}