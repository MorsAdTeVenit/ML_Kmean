public class Data {
    private float x;
    
    private float y;
    
    private int cluster;
    
    public Data(float x, float y) {
	this.x = x;
	this.y = y;
    }
    
    public float getX() {
	return this.x;
    }
    
    public float getY() {
	return this.y;
    }
    
    public void setX(float x) {
	this.x = x;
    }
    
    public void setY(float y) {
	this.y = y;
    }
    
    public int getCluster() {
	return this.cluster;
    }
    
    public void setCluster(int x) {
	this.cluster = x;
    }
}
