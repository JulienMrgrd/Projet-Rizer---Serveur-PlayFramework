package modelsMongo;

import play.Application;
import play.Plugin;

public class JongoPlugin extends Plugin {
	
	public JongoPlugin(Application application){
	}
	
	@Override
	public void onStart(){
		PlayJongo.forceNewInstance();
	}
	
	@Override
	public void onStop(){
		
	}
	

}
