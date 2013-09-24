package codejam.H2013;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class A {

	public static void main(String[] args) throws FileNotFoundException {
		
		String root = "data/H2013";
		
		// Test
		
//		String inputFile = "A-in.txt";
//		String outputFile = "A-out.txt";
		
		// Small
		
//		String inputFile = "A-small-1-attempt1.in";
//		String outputFile = "A-small-1-attempt1.out";
		
		
		// Large
		
		String inputFile = "A-small-2-attempt1.in";
		String outputFile = "A-small-2-attempt1.out";
		
		Scanner in = new Scanner(new File(root, inputFile));
		PrintWriter out = new PrintWriter(new File(root, outputFile));
		
		int T = in.nextInt();
		
		for(int i=0;i<T;i++){
			
			int M = in.nextInt();

			Map<String, Integer> ID = new HashMap<String, Integer>();
			int[][] oppo = new int[M][2];
			int id = 0;
			for(int j=0;j<M;j++){
				
				String s1 = in.next();
				
				if(!ID.containsKey(s1)){
					ID.put(s1, id++);
				}

				
				String s2 = in.next();
				
				if(!ID.containsKey(s2)){
					ID.put(s2, id++);
				}

				oppo[j][0] = ID.get(s1);
				oppo[j][1] = ID.get(s2);
			}
			
			
			
			int N = ID.size();
			
			
			int[][] map = new int[N][N];
			for(int j=0;j<N;j++){
				for(int k=0;k<N;k++){
					map[j][k] = 0;
				}
			}
			
			for(int j=0;j<M;j++){
				map[oppo[j][0]][oppo[j][1]] = 1;
				map[oppo[j][1]][oppo[j][0]] = 1;
			}
			
			boolean[] flag = new boolean[N];
			

			boolean result = true;
			for(int j=0;j<flag.length;j++){
				if(flag[j] == false){
					result = oneRound(map, flag, N, j);
				}
				if(result == false)break;
			}

			out.print("Case #"+(i+1)+": ");
			
			if(result)
				out.println("Yes");
			else
				out.println("No");
			
			
		}
		
		in.close();
		out.close();

	}
	
	private static ArrayList<Integer> findEnemy(ArrayList<Integer> t1, int[][] map, boolean[] flag, int N){
		ArrayList<Integer> t2 = new ArrayList<Integer>();
		
		int[] enemy = new int[N];
		for(int j = 0;j<t1.size();j++){
			int target = t1.get(j);
			for(int k=0;k<N;k++){
				enemy[k] = (enemy[k] & map[target][k]) + (enemy[k] ^ map[target][k]);
			}
			System.out.println("");
		}
		for(int j=0;j<N;j++){
			if(enemy[j] == 1){
				t2.add(j);
				flag[j] = true;
			}
		}
		
		return t2;
		
	}
	
	private static boolean oneRound(int[][] map, boolean[] flag, int N, int start){
		ArrayList<Integer> teamA = new ArrayList<Integer>();
		ArrayList<Integer> teamB = new ArrayList<Integer>();
		
		boolean result = true;
		teamA.add(start);
		flag[start] = true;
		int sA = 0;
		int sB = 0;
		while(sA!=teamA.size()||sB!=teamB.size()){
			sA = teamA.size();
			sB = teamB.size();
			
			teamB = findEnemy(teamA, map, flag, N);
			
			for(int j=0;j<teamB.size();j++){
				if(teamA.contains(teamB.get(j))){
					result = false;
					break;
				}
			}
			if(result == false)break;
			teamA = findEnemy(teamB, map, flag, N);
			
			for(int j=0;j<teamA.size();j++){
				if(teamB.contains(teamA.get(j))){
					result = false;
					break;
				}
			}
			if(result == false)break;
		}
		
		return result;
	}

}
