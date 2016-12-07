/*
 * Name: Ji Eun Han
 * Assignment: Project 03
 * Section: TR 9:40am
 * Lab TA: Chengyu Deng, Matt Delsordo
 * I collaborated with Mackenzie Lee. 
 */

public class Lines {
	
	int lineq;
	int lineOppo;
	//lineOppo confirms that if point (0,0) is COUNTERCLOCKWISE to line, method returning the location of point will return 
	//one instead of zero and zero instead of one
	
	Point p1;
	Point p2;
	
	
	public Lines(Point p1, Point p2){
		if(p1.x < p2.x){
			this.p1 = p1;
			this.p2 = p2;
		}else{
			this.p1 = p2;
			this.p2 = p1;
		}
	}
	
	//In order to make sure that point1 for all and any line is the point with the smallest coordinates
	public Lines(Point p1, Point p2, int lineq){
		this.lineq = lineq;
		if(p1.x <= p2.x){
			this.p1 = p1;
			this.p2 = p2;
		}else{
			this.p1 = p2;
			this.p2 = p1;
		}
		if(p1.y == 0.0 || p2.y == 0.0){
			lineOppo = -1;
		}else{
			lineOppo = 1;
		}
		
	}
}
