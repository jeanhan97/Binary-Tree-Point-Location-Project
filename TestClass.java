/*
 * Name: Ji Eun Han
 * Assignment: Project 03
 * Section: TR 9:40am
 * Lab TA: Chengyu Deng, Matt Delsordo
 * I collaborated with Mackenzie Lee. 
 */

import java.util.Scanner;

public class TestClass {

	public static void main(String[] args) {
		String stringinput = "";
		Scanner coordscan = new Scanner(System.in);
		Scanner scan = new Scanner(System.in);
		Scanner scanner = new Scanner(System.in);
		System.out.println("Write the number of lines:");
		int numberLines = scan.nextInt();
		
		MyTreeNode root = new MyTreeNode();
		BinaryTreeClass tree = new BinaryTreeClass(root);
		root.path = "";
		LineCalculation.temproot = tree.root;
		Lines[] lines = new Lines[numberLines];

		System.out.println("Type in line coordinates by 'x1 y1 x2 y2' structure");
		//Builds the tree
		for(int i = 0; i < numberLines; i++){
//			System.out.println(numberLines + " numberlines");
			
			String coordInput = scanner.nextLine();
			String[] input = new String[4];
			input = coordInput.split(" ");
			double[] inputdouble = new double[4];
			
			for (int j=0; j<input.length;j++){
				inputdouble[j] = Double.parseDouble(input[j]);
			}
			
			double x1 = inputdouble[0];
			double y1 = inputdouble[1];
			double x2 = inputdouble[2];
			double y2 = inputdouble[3];
		
			
			Lines line = new Lines(new Point(x1,y1),new Point(x2,y2));
			line.lineq = i;
			lines[i] = line;
			tree.insertLine(line);
			
			
		}
		System.out.println("Input pairs of points to be tested by 'x1 y1 x2 y2' structure. To stop write 'done'.");
		//Checks if the points are in the same region
		while(scan.hasNextDouble()){
			double pointx1 = scan.nextDouble();
			double pointy1 = scan.nextDouble();
			Point point1 = new Point(pointx1,pointy1);
			double pointx2 = scan.nextDouble();
			double pointy2 = scan.nextDouble();
			Point point2 = new Point(pointx2,pointy2);
			tree.checkRegion(point1, point2);
		}
		
		//Number of External Nodes (added .0 for more accurate division)  
		int count1 = tree.counter(tree.root) -1;
		String count1String = Integer.toString(count1) + ".0";
		double count1div = Double.parseDouble(count1String);
		
		//External Path Length
		double count2 = tree.path();
		
		double acuratePthLth = count2/count1div;

		System.out.println("Number of External Nodes in Tree: " + count1);
		System.out.println("External Path Length: " + count2);
		System.out.println("Average Path Length: " + acuratePthLth);
		

	}

}