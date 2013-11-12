package codejam.S2013;
import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Vector;


public class C{

	static final String TYPE = "C";
	static String inputFile;
	static String outputFile;

	private static void Name(String s){
		inputFile = s + ".in";
		outputFile = s + ".out";
	}
public static void main(String[] args) throws FileNotFoundException {
		
		String root = "data/S2013";
		
		// Test
//		Name("E-small-practice");
		Name("C-small-practice");
		
		Scanner in = new Scanner(new File(root, inputFile));
		PrintWriter out = new PrintWriter(new File(root, outputFile));
		int N, T;
		T = in.nextInt();
		
		for(int i = 0; i < T; i++){
			N = in.nextInt();
			in.nextLine();
			int[][] board = new int[N][N];
			int redCount = 0, blueCount = 0;
			for(int j = 0; j < N; j++){
				String s = in.nextLine();
				for(int k = 0; k < N; k++){
					if(s.charAt(k) == '.'){
						board[j][k] = 0;
					}else if(s.charAt(k) == 'B'){
						board[j][k] = 1;
						blueCount++;
					}else if(s.charAt(k) == 'R'){
						board[j][k] = 2;
						redCount++;
					}
				}
			}
			if(Math.abs(blueCount - redCount) > 1){
				out.println("Case #" + (i + 1) + ": Impossible");
			}else
				out.println("Case #" + (i + 1) + ": " + getState(board, redCount - blueCount == 1, redCount - blueCount == -1));
		}
		
		in.close();
		out.close();

	}
	
	public static String getState(int[][] board, boolean isRedFirst, boolean isBlueFirst){
		String state = "";
		int redState = 0, blueState = 0; // 0 lose, 1 win, 2 impossible
		int N = board.length;
		int[][] clusterGroup = new int[N][N];
		Point neighbors[] = {new Point(0, 1), 
				new Point(1, 0), 
				new Point(1, -1), 
				new Point(0, -1), 
				new Point(-1, 0), 
				new Point(-1, 1)};
		for(int i = 0; i < N; i++){
			for(int j = 0; j < N; j++){
				clusterGroup[i][j] = -1;
			}
		}
		int currentState = 0;
		while(currentState != N){
			int temp = currentState;
			for(; temp < N; temp++){
				if(board[0][temp] == 2 && clusterGroup[0][temp] == -1){
					break;
				}
			}
			if(temp >= N){
				break;
			}
			currentState = temp;
			Vector<Point> cands = new Vector<Point>();
			Point currentP = new Point(0, currentState);
			cands.add(currentP);
			clusterGroup[currentP.x][currentP.y] = currentState;
			while(!cands.isEmpty()){
				Point select = cands.get(0);
				cands.remove(select);
				for(int j = 0; j < 6; j++){
					Point nb = new Point(select.x + neighbors[j].x, select.y + neighbors[j].y);
					if(nb.x < 0 || nb.y < 0 || nb.x >= N || nb.y >= N){
						continue;
					}
					if(board[nb.x][nb.y] == 2 && clusterGroup[nb.x][nb.y] == -1){
						clusterGroup[nb.x][nb.y] = currentState;
						cands.add(nb);
					}
				}
			}
			int count = 0;
			for(int i = 0; i < N; i++){
				if(clusterGroup[N - 1][i] == currentState){
					count++;
				}
			}
			if(count == 0){
			}else if(count == 1 && redState == 0){
				redState = 1;
			}else{
				redState = 2;
				return "Impossible";
			}
			currentState++;
		}
		
		
		
		for(int i = 0; i < N; i++){
			for(int j = 0; j < N; j++){
				clusterGroup[i][j] = -1;
			}
		}
		currentState = 0;
		while(currentState != N){
			int temp = currentState;
			for(; temp < N; temp++){
				if(board[temp][0] == 1 && clusterGroup[temp][0] == -1){
					break;
				}
			}
			if(temp >= N){
				break;
			}
			currentState = temp;
			Vector<Point> cands = new Vector<Point>();
			Point currentP = new Point(currentState, 0);
			cands.add(currentP);
			clusterGroup[currentP.x][currentP.y] = currentState;
			while(!cands.isEmpty()){
				Point select = cands.get(0);
				cands.remove(select);
				for(int j = 0; j < 6; j++){
					Point nb = new Point(select.x + neighbors[j].x, select.y + neighbors[j].y);
					if(nb.x < 0 || nb.y < 0 || nb.x >= N || nb.y >= N){
						continue;
					}
					if(board[nb.x][nb.y] == 1 && clusterGroup[nb.x][nb.y] == -1){
						clusterGroup[nb.x][nb.y] = currentState;
						cands.add(nb);
					}
				}
			}
			int count = 0;
			for(int i = 0; i < N; i++){
				if(clusterGroup[i][N - 1] == currentState){
					count++;
				}
			}
			if(count == 0){
			}else if(count == 1 && blueState == 0){
				blueState = 1;
			}else{
				blueState = 2;
				return "Impossible";
			}
			currentState++;
		}
		System.out.println(redState + ", " + blueState);
		if(redState == 0 && blueState == 1){
			if(!isRedFirst)
				state = "Blue wins";
			else
				state = "Impossible";
		}else if(redState == 1 && blueState == 0){
			if(!isBlueFirst)
				state = "Red wins";
			else
				state = "Impossible";
		}else if(redState == 1 && blueState == 1){
			state = "Impossible";
		}else{
			state = "Nobody wins";
		}
		return state;
	}
}