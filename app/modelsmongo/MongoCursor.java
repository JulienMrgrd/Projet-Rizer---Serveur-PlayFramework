	package modelsmongo;

import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import org.jongo.ResultHandler;

public class MongoCursor<E> implements Iterator<E>, Iterable<E>, Closeable {

    private final DBCursor cursor;
    private final ResultHandler<E> resultHandler;

    public MongoCursor(DBCursor cursor, ResultHandler<E> resultHandler) {
        this.cursor = cursor;
        this.resultHandler = resultHandler;
    }

    public boolean hasNext() {
        return cursor.hasNext();
    }

    public E next() {
        if (!hasNext())
            throw new NoSuchElementException();

        DBObject dbObject = cursor.next();
        return resultHandler.map(dbObject);
    }

    public void remove() {
        throw new UnsupportedOperationException("remove() method is not supported");
    }

    public Iterator<E> iterator() {
        return new MongoCursor<E>(cursor.copy(), resultHandler);
    }

    public void close() throws IOException {
        cursor.close();
    }

    public int count() {
        return cursor.count();
    }
    
    public List<E> toArray(){
    	List<E> result=new ArrayList<E>();
    	while(this.hasNext()){
    		result.add(this.next());
    	}
    	
    	return result;
    }
}
