/*
 * Name: Ji Eun Han
 * Assignment: Project 03
 * Section: TR 9:40am
 * Lab TA: Chengyu Deng, Matt Delsordo
 * I collaborated with Mackenzie Lee. 
 */

public class LineCalculation {
	public static MyTreeNode temproot;
	
	//Method to find the point of intersection of the two lines 
	public static Point getIntersection(Lines l1, Lines l2){
		double x1 = l1.p1.x;
		double y1 = l1.p1.y;
		double x2 = l1.p2.x;
		double y2 = l1.p2.y;
		double x3 = l2.p1.x;
		double y3 = l2.p1.y;
		double x4 = l2.p2.x;
		double y4 = l2.p2.y;
		double d = (x1-x2)*(y3-y4) - (y1-y2)*(x3-x4);
		 
		if(d != 0){
			 double xi = ((x3-x4)*(x1*y2-y1*x2)-(x1-x2)*(x3*y4-y3*x4))/d;
			 double yi = ((y3-y4)*(x1*y2-y1*x2)-(y1-y2)*(x3*y4-y3*x4))/d;
			 if(xi >= 0 && xi <= 1 && yi >= 0 && yi <= 1){
				 return new Point(xi,yi);
			 }
		 }
		
		 return null;
	}
	
	//Method to determine which side of a line point is located (given on instruction sheet)
	//Returns 0 for COUNTERCLOCKWISE
	//Returns 1 for CLOCKWISE
	//Returns 2 for COLINEAR
	
	public static int ccw(Point p0, Lines l) {
	    
		double dx1 = l.p1.x - p0.x;
	    double dy1 = l.p1.y - p0.y;
	    double dx2 = l.p2.x - p0.x;
	    double dy2 = l.p2.y - p0.y;
	   
	    if(l.lineOppo == 1){
	    	 if (dx1*dy2 > dy1*dx2) return 1;
	 	    else if (dx1*dy2 < dy1*dx2) return 0;
	 	    else if ((dx1*dx2 < 0) || (dy1*dy2 < 0)) return 0;
	 	    else if ((dx1*dx1+dy1*dy1) < (dx2*dx2+dy2*dy2)) return 1;
	 	    else return 2;
	   
	    }else{
	    	 if (dx1*dy2 > dy1*dx2) return 0;
	 	    else if (dx1*dy2 < dy1*dx2) return 1;
	 	    else if ((dx1*dx2 < 0) || (dy1*dy2 < 0)) return 1;
	 	    else if ((dx1*dx1+dy1*dy1) < (dx2*dx2+dy2*dy2)) return 0;
	 	    else return 2;
	    }  
	}
}
