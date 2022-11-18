package searchPath_logicTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class searchPath_bfs {
	static int count;
	static int[][] map;
	static int n;
	static int m;
	
	static int startX =0 ,startY =2;
	
	static int endX= 2,  endY= 5;
	
	static boolean[][] visited;
	static int[] dx = { -1, 1, 0, 0 }; //x - 상하
    static int[] dy = { 0, 0, -1, 1 }; //y - 좌우 
    static int[][] path;
   //
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		path= new int[n][m];
		for(int i=0; i<n; i++) {
			String s = br.readLine();
			for(int j=0; j<m; j++) {
				path[i][j] = 0;
				map[i][j] = s.charAt(j) - '0';
			}
		}
		
		visited = new boolean[n][m];
		visited[startX][startY] = true; //시작할 위치 startX, startY 를 방문으로 만듦. 
		bfs(startX, startY); //시작할 위치 지정 (startX,startY) 
		//System.out.println(map[n-1][m-1]);
		
		/*
		for(int it=0; it<n; it++) {
			for(int jt=0; jt<m; jt++) {
				System.out.print(path[it][jt]+" ");
			}
			System.out.println(" ");
		}*/
		
	}

	public static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x,y});
		
		while(!q.isEmpty()) {
			int now[] = q.poll();
			
			int nowX = now[0];
			int nowY = now[1];

			for(int i=0; i<4; i++) {
				int nextX = nowX + dx[i];
				int nextY = nowY + dy[i];
				
		                if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= m)
                		    continue;
        		        if (visited[nextX][nextY] || map[nextX][nextY] == 0)
                    		continue;
        		        
		                q.add(new int[] {nextX, nextY});
		                
        		        map[nextX][nextY] = map[nowX][nowY] + 1;
                		//System.out.println(nextX + " " + nextY+ " "+map[nextX][nextY]);
                		
		                visited[nextX][nextY] = true;
		                count = map[nextX][nextY];
		               
		                if(nextX==endX && nextY == endY) { //내가 원하는 좌표 (endX,endY)에 도달할 때 까지의 비용 
		                	System.out.println(count);
		                	return ;
		                }
			}
		}
	}
}
