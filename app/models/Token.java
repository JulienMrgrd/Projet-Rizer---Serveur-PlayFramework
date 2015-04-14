package models;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.UUID;

public class Token {
	
	private String _id;
	private static DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
	
	Token(){
		
		UUID uId= UUID.randomUUID();
		String dateMaj= dateFormat.format(Calendar.getInstance().getTime());
		this._id=uId+dateMaj;
	}

	@Override
	public String toString() {
		return "Token [_id=" + _id + "]";
	}

	public String get_id() {
		return _id;
	}


	

}
