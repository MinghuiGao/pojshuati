package cn.gaomh_1915;

import java.util.LinkedList;
import java.util.Scanner;

public class KnightMoves {

	private Stack mStack = new Stack();
	
	public static void main(String[] args) {
		KnightMoves knightMoves = new KnightMoves();
		Scanner  sc = new Scanner(System.in);
		
		int scenaroisCount  = sc.nextInt();
		// input 
//		int[][][] params = new int[scenaroisCount][3][];
		ParamsHolder[] holder= new ParamsHolder[scenaroisCount];
		
		for(int i  =  0; i< scenaroisCount;i++){
			int boardSize = sc.nextInt();
			if(boardSize <4 || boardSize > 300){
				System.out.println("the length  of a side of the chess board should be in [4 ,300]");
				break;
			}
			int startX = sc.nextInt();
			int startY = sc.nextInt();
			Point start = knightMoves.new Point(startX,startY);
			if(!isPointLeagle(start , boardSize)){
				System.out.println("illegal point");
				break;
			}
			int endX = sc.nextInt();
			int endY = sc.nextInt();
			Point end = knightMoves.new Point(endX,endY);
			if(!isPointLeagle(start , boardSize)){
				System.out.println("illegal point");
				break;
			}
//			params[i] = new int[][]{new int[]{boardSize},new int[]{startX,startY},new int[]{endX,endY}};
			holder[i] = knightMoves.new ParamsHolder(boardSize,start,end);
		}
		for(ParamsHolder params : holder){
			int countMoves = knightMoves.countMoves(params.boardSize,params. start, params.end);
			System.out.println(countMoves);
		}
		
		
	}
	
	//3
	public int countMoves(int boardSize,Point start	,Point end){
		int res = Integer.MAX_VALUE;
//		Point start = new Point(from[0],from[1]);
//		Point end = new Point(to[0],to[1]);
		mStack.push(start);
		LinkedList<Point> nextPossibleSteps = findNextPossibleSteps(start, boardSize);
		for(Point point : nextPossibleSteps){
			mStack.push(point);
			if(point.x == end.x && point.y == end.y){
				res = mStack.getStackDepth()-1<res?mStack.getStackDepth()-1:res;
			}else{
				mStack.pull();
				res = countMoves(boardSize,point,end);
			}
		}
		return res;
	}
	
	//1
	public LinkedList<Point> findNextPossibleSteps(Point start,int boardSize){
		int[][] rule = new int[][]{new int[]{-1,-2},new int[]{-2,-1},new int[]{1,-2},new int[]{2,-1},new int[]{1,2},new int[]{2,1},new int[]{-1,2},new int[]{-2,1}};
		LinkedList<Point> nextPoints = new LinkedList<Point>();
		for(int i = 0;i<rule.length ;i++){
			Point nextPoint = new Point();
			nextPoint.x = start.x+rule[i][0];
			nextPoint.y = start.y +rule[i][1];
			if(isPointLeagle(nextPoint, boardSize)){
				nextPoints.add(nextPoint);
			}
		}
		return nextPoints;
	}
	// 1.1
	public static boolean isPointLeagle(Point p,int boardSize){
		if(p.x <0 || p.x >= boardSize || p.y < 0 || p.y >= boardSize){
			return false;
		}else{
			return true;
		}
	}

	//2
	public class Stack{
		private LinkedList<Point> points = new LinkedList<Point>(); 
		
		public void push(Point p){
			points.add(p);
		}
		public Point pull(){
			return points.remove();
		}
		public int getStackDepth(){
			return points.size();
		}
		
	}
	
	public class Point{
		public Point(){};
		public Point(int x,int y){
			this.x = x;
			this.y = y;
		}
		public int x;
		public int y;
	}
	
	public class ParamsHolder{
		public ParamsHolder(){
		}
		public ParamsHolder(int boardSize,Point start,Point end){
			this.boardSize = boardSize;
			this.start = start;
			this. end = end;
		}
		public int boardSize;
		public Point start;
		public Point end;
	}
}
