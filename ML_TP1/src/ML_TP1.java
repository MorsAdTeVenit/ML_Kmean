import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Random;

public class ML_TP1 {
    
    public static void main(String args[]) throws FileNotFoundException, UnsupportedEncodingException{
	
	ArrayList<Data> input = new ArrayList<>();
	
	Random rand = new Random();
	
	int nbElem = rand.nextInt(250) + 50;
	int nbClust = rand.nextInt(3) + 3;

	for(int i=0;i<nbElem;i++){
	    Data newData = new Data(rand.nextFloat(), rand.nextFloat());
	    input.add(newData);
	}
	
	float[][] metric = {{1f,0f},{0f,1f}};
	
	ArrayList<Data> centers = new ArrayList<>();
	for(int i=0; i < nbClust;i++){
	    Data newData = new Data(rand.nextFloat(), rand.nextFloat());
	    centers.add(newData);
	}
	
	Output finalRes = new Output(input, nbClust, metric, centers);
	
	PrintWriter writer = new PrintWriter("result.txt", "UTF-8");
	
	for(int i=0;i<input.size();i++){
	    writer.print(input.get(i).getX() + " ");
	}
	
	writer.println();
	
	for(int i=0;i<input.size();i++){
	    writer.print(input.get(i).getY() + " ");
	}
	
	writer.println();
	
	for(int i=0;i<input.size();i++){
	    writer.print(input.get(i).getCluster() + " ");
	}
	
	writer.close();
    }
}
