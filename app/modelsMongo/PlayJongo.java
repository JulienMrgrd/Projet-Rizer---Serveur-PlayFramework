package modelsMongo;


import java.net.UnknownHostException;

import org.jongo.Jongo;
import org.jongo.MongoCollection;

import play.Logger;
import play.Play;

import com.mongodb.DB;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoException;
import com.mongodb.MongoURI;
import com.mongodb.gridfs.GridFS;

public class PlayJongo {

    private static volatile PlayJongo INSTANCE = null;

    private MongoClient mongo = null;
    private Jongo jongo = null;
    private GridFS gridfs = null;
    private MongoClientURI uri =null;
    private String dataBase = "playjava";

    private PlayJongo() throws UnknownHostException, MongoException {

    		uri  = new MongoClientURI("mongodb://admin:aqwzsx@ds059651.mongolab.com:59651/playjava"); 
            mongo = new MongoClient(uri);
            DB db = mongo.getDB(uri.getDatabase());
            jongo = new Jongo(db);
            gridfs = new GridFS(jongo.getDatabase());
    }

    public static PlayJongo getInstance() {
        if (INSTANCE == null) {
            synchronized (PlayJongo.class) {
                if (INSTANCE == null) {
                    try {
                        INSTANCE = new PlayJongo();
                    } catch (UnknownHostException e) {
                        Logger.error("UnknownHostException", e);
                    } catch (MongoException e) {
                        Logger.error("MongoException", e);
                    }
                }
            }
        }
        return INSTANCE;
    }

    public static void forceNewInstance() {
        INSTANCE = null;
        getInstance();
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
}