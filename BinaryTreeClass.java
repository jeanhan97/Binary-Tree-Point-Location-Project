/*
 * Name: Ji Eun Han
 * Assignment: Project 03
 * Section: TR 9:40am
 * Lab TA: Chengyu Deng, Matt Delsordo
 * I collaborated with Mackenzie Lee. 
 */

public class BinaryTreeClass {
	MyTreeNode root;
		
		public BinaryTreeClass(MyTreeNode root){
			this.root = root;
		}
		
		//Returns the path of a point until it reaches the tree leaves
		public String pathofPoint(Point p, MyTreeNode root ){
			String path = "";
			
			if(LineCalculation.ccw(p, root.line) == 0){
				
				if(root.rightChild.line !=null){
					path = path + "-" + root.line.lineq +  "-" + "0" + pathofPoint(p, root.rightChild);
				}else{
					path = path + "-" + root.line.lineq + "-" + "0";
				}
				
			}else{
				
				if(root.leftChild.line !=null){
					path = path + "-" + root.line.lineq + "-" + "1" + pathofPoint(p, root.leftChild);
				}else{
					path = path + "-" + root.line.lineq + "-" + "1";
				}
			}
			return path;
		}
		
		//Assigns the path of a point from above until it reaches a certain line internal node
		public String pathofPointUntil(Point p, MyTreeNode root, Lines l){
			
			String path = "";
			if(LineCalculation.ccw(p, root.line) == 0){
				
				if(root.rightChild.line !=null){
					if(root.rightChild.line.lineq == l.lineq){
						path = path + "-" + root.line.lineq + "-" + "0";
					}else{
						path = path + "-" + root.line.lineq +  "-" + "0" + pathofPoint(p, root.rightChild);	
					}
				}else{
					path = path + "-" + root.line.lineq + "-" + "0";
				}
			
			}else{
				
				if(root.leftChild.line !=null){
					
					if(root.leftChild.line.lineq == l.lineq){
						path = path + "-" + root.line.lineq + "-" + "1";	
					}else{
						path = path + "-" + root.line.lineq + "-" + "1" + pathofPoint(p, root.leftChild);
					}
				}else{
					path = path + "-" + root.line.lineq + "-" + "1";
				}
				
			}
			return path;
		}
		
		//Compares the two paths
		public boolean comparePathString(String path){
			if(path.equals(root.path) == true){
				return true;
			}else{
				return false; 
			}
		}
		
		//Inserts a line into the tree
		public void insertLine(Lines lineinsert){
			
			//If empty tree and root is null it fills it with the line 
			if(root.line == null){
				
				root.line = lineinsert;
				
				MyTreeNode rightChild = new MyTreeNode();
				root.rightChild = rightChild;
				rightChild.parent = root;
				rightChild.path = root.path + "-" + lineinsert.lineq + "-" + "0";
				
				MyTreeNode leftChild = new MyTreeNode();
				root.leftChild = leftChild;
				leftChild.parent = root;
				leftChild.path = root.path + "-" +lineinsert.lineq + "-" + "1";
				
				
			}else{
				
				Point pointsCrossing = LineCalculation.getIntersection(root.line, lineinsert);
				if(pointsCrossing != null){
				
					if(comparePathString(pathofPointUntil(pointsCrossing, LineCalculation.temproot,root.line)) == true || root == LineCalculation.temproot){
						
						BinaryTreeClass rightTree = new BinaryTreeClass(root.rightChild);
						rightTree.insertLine(lineinsert);
						
						BinaryTreeClass leftTree = new BinaryTreeClass(root.leftChild);
						leftTree.insertLine(lineinsert);
						
					}else{
						
						if(LineCalculation.ccw(lineinsert.p2, root.line) == 0){
							BinaryTreeClass rightTree = new BinaryTreeClass(root.rightChild);
							rightTree.insertLine(lineinsert);
						
						}else{
							BinaryTreeClass leftTree = new BinaryTreeClass(root.leftChild);
							leftTree.insertLine(lineinsert);
						}
					}
					
				//If lines don't intersect, method checks on which side line's on in terms of root.line
				}else if(LineCalculation.ccw(lineinsert.p1, root.line) > 0){
					
					BinaryTreeClass leftTree = new BinaryTreeClass(root.leftChild);
					leftTree.insertLine(lineinsert);
					
				}else if(LineCalculation.ccw(lineinsert.p1, root.line) == 0){
					
					BinaryTreeClass rightTree = new BinaryTreeClass(root.rightChild);
					rightTree.insertLine(lineinsert);
				}
				
			}
		}
		
		//Compares the paths of two points and checks if the two points are in the same region (with print statement) 
		public void checkRegion(Point p1, Point p2){
			
			if(pathofPoint(p1,LineCalculation.temproot).equals(pathofPoint(p2,LineCalculation.temproot)) == true){	
				System.out.println("The points are in the same region.");
			}else{
				System.out.println("The points aren't in the same region.");
			}
			
		}
		
		//Measuring external path length
		 public int length(int count, MyTreeNode node) {
				if (node.rightChild == null && node.leftChild == null){
					return count;
				}else{
					return length(count+1, node.leftChild) + length(count + 1, node.rightChild);
				}
		 }
		 
		 public int path(){
			 return length(0, root);
		 }
	
		 //Counting number of external nodes method 
		 public int counter(MyTreeNode root) {
			 if(root==null){
				 return 0;
			 }
			 if (root.leftChild == null && root.rightChild ==null){
				 return 1;
			 }else{
				 return counter(root.leftChild)+counter(root.rightChild);
			 }
			}
}
