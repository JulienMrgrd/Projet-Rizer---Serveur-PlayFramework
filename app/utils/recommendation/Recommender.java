package utils.recommendation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.common.LongPrimitiveIterator;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.ThresholdUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericItemBasedRecommender;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.recommender.svd.ALSWRFactorizer;
import org.apache.mahout.cf.taste.impl.recommender.svd.SVDRecommender;
import org.apache.mahout.cf.taste.impl.similarity.LogLikelihoodSimilarity;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.UserBasedRecommender;
import org.apache.mahout.cf.taste.similarity.ItemSimilarity;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

public class Recommender {

	public static void main(String[] args) {
		
		try {
			
				DataModel model = new FileDataModel(new File("app/utils/recommendation/data/tracks.csv"));
				UserSimilarity similarity = new PearsonCorrelationSimilarity(model);
				UserNeighborhood neighborhood = new ThresholdUserNeighborhood(0.1, similarity, model);
				
				UserBasedRecommender recommender = new GenericUserBasedRecommender(model, neighborhood, similarity);
				
				List<RecommendedItem> recommendations = recommender.recommend(721, 3);
				
				System.out.println("Coucou !");
				
				for (RecommendedItem recommendation : recommendations) {
				  System.out.println(recommendation);
				}
			
			
//			DataModel dm = new FileDataModel(
//					new File("app/utils/recommendation/data/tracks.csv") );
//			
//			System.out.println("Coucou1 !");
//			
//			ItemSimilarity sim = new LogLikelihoodSimilarity(dm);
//			GenericItemBasedRecommender recommender = new GenericItemBasedRecommender(dm, sim);
//			
//			int x = 1;
//			for(LongPrimitiveIterator items = dm.getItemIDs(); items.hasNext();) {
//				long itemId = items.nextLong();
//				List<RecommendedItem> recommendations = recommender.mostSimilarItems(itemId, 5);
//				
//				for(RecommendedItem recommendation : recommendations) {
//					System.out.println(itemId + "," + recommendation.getItemID() + "," + recommendation.getValue());
//				}
//				x++;
//				//if(x>10) System.exit(1);
//			}
			
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFound..");
			//e.printStackTrace();
		}catch (IOException e) {
			System.out.println("There was an error.");
			e.printStackTrace();
		} catch (TasteException e) {

			System.out.println("There was a Taste Exception");
			e.printStackTrace();
		}
	}

}
