package models;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Token {
	
	@JsonProperty("_id")
	public String _id;
	private String accountId;
	private String dateMaj;
	public static DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
	
	public Token(String account){
	
		this._id=UUID.randomUUID().toString();
		this.accountId=account;
		this.dateMaj=new DateTime().toString();
	}

	@Override
	public String toString() {
		return "Token [_id=" + _id + "]";
	}

	public String get_id() {
		return _id;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	

	public void setDateMaj() {
		this.dateMaj = new DateTime().toString();
	}
	
	public long getDiffDay(){
		long diff= new DateTime().getMillis() - new DateTime(this.dateMaj).getMillis();
		return TimeUnit.MILLISECONDS.toDays(diff);
	}
	
	


	

}
