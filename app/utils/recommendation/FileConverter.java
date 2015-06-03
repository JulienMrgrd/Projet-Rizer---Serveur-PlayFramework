package utils.recommendation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileConverter {

	public static void main(String[] args) throws IOException {
		
	
		BufferedReader br = new BufferedReader( 
				new	FileReader("recommendation data/u.data") );
		
		BufferedWriter bw = new BufferedWriter(
				new FileWriter("recommendation data/myU.csv"));
		
		try{
			String line;
		
			while( (line = br.readLine() ) != null ){
				
				String[] values = line.split("\t", -1);
				bw.write(values[0]+ ',' +values[1] + ',' + values[2] + '\n');
			}
		
		} catch (FileNotFoundException e) {
			
			System.out.println("File not found.");
			e.printStackTrace();
			
		} catch (IOException e) {
			
			System.out.println("IO Error");
			e.printStackTrace();
		}
		finally{
			br.close();
			bw.close();
		}
		
	}

	

}
