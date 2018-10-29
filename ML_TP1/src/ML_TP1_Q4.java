import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ML_TP1_Q4 {
    
    public static void main(String args[]) throws FileNotFoundException, UnsupportedEncodingException, IOException{
	
	ArrayList<Data> input = new ArrayList<>();
	
	Random rand = new Random();
	
	int maxNumber = 6;

        float[] res = new float[maxNumber];
        
        for(int nbClust=maxNumber; nbClust>0; nbClust--){
	
	//FileReader fr = new FileReader("td2_d1.txt");
	FileReader fr = new FileReader("td2_d3.txt");
	//FileReader fr = new FileReader("td2_d3.txt");

	BufferedReader BR = new BufferedReader(fr);
	String lineX = BR.readLine();
	String lineY = BR.readLine();
	
	String[] resX = lineX.split(" +");
	String[] resY = lineY.split(" +");
	
	for(int i=1;i<resX.length;i++){
	    Data d = new Data(Float.parseFloat(resX[i]), Float.parseFloat(resY[i]));
	    input.add(d);
	}
	
	int nbElem = input.size();
	
	//Deviation standard Q2
	//float[][] metric = {{1f,0f},{0f,1f}};
	
	//Devation calculée pour Q3
	float moyX = 0;
	float moyY = 0;
	for(int i = 0;i<input.size();i++){
	    moyX += input.get(i).getX();
	    moyY += input.get(i).getY();
	}
	moyX = moyX/input.size();
	moyY = moyY/input.size();
	
	float deviationX = 0;
	float deviationY = 0;
	for(int i = 0;i<input.size();i++){
	    deviationX += (input.get(i).getX()-moyX)*(input.get(i).getX()-moyX);
	    deviationY += (input.get(i).getY()-moyY)*(input.get(i).getY()-moyY);
	}
	deviationX = deviationX/input.size();
	deviationY = deviationY/input.size();
	float[][] metric = {{(1/deviationX),0f},{0f,(1/deviationY)}};
	
	ArrayList<Data> centers = new ArrayList<>();
	
	//Boucle for : nbClust points choisis aléatoirement dans la liste des points inputs
	for(int i=0; i < nbClust;i++){
	    Data newData = new Data(input.get(rand.nextInt(input.size())).getX(), input.get(rand.nextInt(input.size())).getY());
	    centers.add(newData);
	}
	
	//Question 2
	//Les deux lignes suivantes, 2 centres initiaux choisis manuellement (attention, changer nbClust à 2)
//	centers.add(new Data(0f,0f));
//	centers.add(new Data(0f,8f));

	//Question 3
	//Les deux lignes suivantes, 2 centres initiaux choisis manuellement (attention, changer nbClust à 2)
	//centers.add(new Data(0f,0f));
	//centers.add(new Data(0f,1f));
	
	Output finalRes = new Output(input, nbClust, metric, centers);
	
        res[nbClust-1] = finalRes.distSum;
        
	
        }
        
        PrintWriter writer = new PrintWriter("result.txt", "UTF-8");
	
        writer.print(maxNumber+" ");
        
	for(int i=0;i<maxNumber;i++){
	    writer.print(res[i]+" ");
	}
	
	writer.close();
        
    }
}
