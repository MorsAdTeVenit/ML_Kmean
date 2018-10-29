import java.util.ArrayList;

public class Output {    
    private ArrayList<Data> barycenters;
    public float distSum;
    
    public Output(ArrayList<Data> input, int nbcluster, float[][] metric, ArrayList<Data> centers){
	this.barycenters = centers;
	this.distSum = 0;
        
	ArrayList<Cluster> clust = new ArrayList<>();
	ArrayList<Data> dataToRM = new ArrayList<>();
	
	for(int i=0;i<nbcluster;i++){
	    clust.add(new Cluster(i));
	}
	
	for (Data data : input) {
	    data.setCluster(calcClosestCenter(data, metric));
	    int tmp = data.getCluster();
	    clust.get(tmp).addData(data);
	}
	
	boolean modif;
	
	this.resetBarycenters(clust);
	
	do {	    
            distSum = 0;
	    modif = false;
	    for(int i=0;i<clust.size();i++){
		for (Data data : clust.get(i).getData()) {
		    int tmp = calcClosestCenter(data, metric);
		    if(i!=tmp){
			data.setCluster(tmp);
			dataToRM.add(data);
			clust.get(tmp).addData(data);
			modif = true;
		    }
		}
		for (Data data : dataToRM) {
		   clust.get(i).getData().remove(data);
		}
		dataToRM.clear();
	    }
	
	    this.resetBarycenters(clust);
	    
	} while (modif);
        
        
    }
    
    private int calcClosestCenter(Data d, float[][] metric) {
	int closestCenter=0;
	float shortDist = (((d.getX() - barycenters.get(0).getX())*metric[0][0])*((d.getX() - barycenters.get(0).getX())*metric[0][0]))+(((d.getY() - barycenters.get(0).getY())*metric[1][1])*((d.getY() - barycenters.get(0).getY())*metric[1][1]));
	float dist;
	distSum+=shortDist;
	for(int i=1;i<this.barycenters.size();i++){
	    dist = (((d.getX() - barycenters.get(i).getX())*metric[0][0])*((d.getX() - barycenters.get(i).getX())*metric[0][0]))+(((d.getY() - barycenters.get(i).getY())*metric[1][1])*((d.getY() - barycenters.get(i).getY())*metric[1][1]));
	
	    if(dist<shortDist){
                distSum-=shortDist;
                distSum+=dist;
		shortDist = dist;
		closestCenter = i;
	    }
            
	}
	
	return closestCenter;
    }
    
    private void resetBarycenters(ArrayList<Cluster> clust){
	for(int i=0; i<clust.size();i++){
	    Data bary = clust.get(i).calcBarycenter();
	    this.barycenters.get(i).setX(bary.getX());
	    this.barycenters.get(i).setY(bary.getY());
	}
    }
}
