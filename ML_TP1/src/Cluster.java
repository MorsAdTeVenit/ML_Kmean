
import java.util.ArrayList;

public class Cluster {
    
    private int id;
    
    private ArrayList<Data> datas;
    
    private Data center;
    
    public Cluster(int rank){
	this.id = rank;
	this.datas = new ArrayList<>();
    }
    
    public void addData(Data d){
	this.datas.add(d);
    }
    
    public ArrayList<Data> getData(){
	return this.datas;
    }
    
    public Data calcBarycenter(){
	Data mean = new Data(0,0);
	
	for (Data data : datas) {
	    mean.setX(mean.getX()+data.getX());
	    mean.setY(mean.getY()+data.getY());
	}
	mean.setX(mean.getX()/datas.size());
	mean.setY(mean.getY()/datas.size());
	
	return mean;	
    }
    
}
