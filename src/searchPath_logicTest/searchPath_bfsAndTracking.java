package searchPath_logicTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class searchPath_bfsAndTracking {
    // 최단거리 구하기

    public static int n = 0;    // 행수
    public static int m = 0;    // 열수    
    public static int[][] map;  // 맵정보
    public static String path = "";        // 이동경로
	static int startX =0 ,startY =2;
	static int endX=2, endY=5;
	

	
    public static void main(String[] args) throws IOException {

    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		
			for(int i=0; i<n; i++) {
				String s = br.readLine();
				for(int j=0; j<m; j++) {
					map[i][j] = s.charAt(j) - '0';
				}
		 }
            int dapth = 0;
            path = "";
            dapth = bfs();           
            System.out.println("최소비용: " + dapth + " 최단경로: " + path);
    
    }
 
    private static int bfs() {
        int  cost= 0;
        
        int nowX = startX;        // 현재 row
        int nowY = startY;        // 현재 col
        int nowDistance = 1;    // 현재 이동한 거리
        String nowPath = "";    // 현재까지 이동경로

        LinkedList<Node> queue = new LinkedList<Node>();
        queue.add(new Node(nowX, nowY, nowDistance, nowPath));
        
       
        while(!queue.isEmpty()) {
            Node Node = (Node) queue.poll();
            nowX = Node.x;
            nowY = Node.y;
            nowDistance = Node.distance;
            nowPath = Node.path;
            path = nowPath;
            cost = nowDistance;
            
            map[nowX][nowY] = 0;
            
            // 목적지에 도착하면 루핑 종료
            if(nowX == endX && nowY == endY) {
                break;
            }
            
            // 위로 갈수 있으면
            if(nowX-1 >= 0 && map[nowX-1][nowY] == 1) {
                queue.add(new Node(nowX-1, nowY, nowDistance+1, nowPath));
            }
            // 아래로 갈수 있으면
            if(nowX+1 < n && map[nowX+1][nowY] == 1) {
                queue.add(new Node(nowX+1, nowY, nowDistance+1, nowPath));
            }
            // 왼쪽으로 갈수 있으면
            if(nowY-1 >= 0 && map[nowX][nowY-1] == 1) {
                queue.add(new Node(nowX, nowY-1, nowDistance+1, nowPath));
            }
            // 오른쪽으로 갈수 있으면
            if(nowY+1 < m && map[nowX][nowY+1] == 1) {
                queue.add(new Node(nowX, nowY+1, nowDistance+1, nowPath));
            }
        }
        // 큐 클리어
        queue.clear();
        
        return cost;
    }
    
    // 이동하는 위치정보 및 거리정보 저장
    public static class Node {
        int x, y, distance;
        String path;
        
        public Node(int x, int y, int distance, String prePath) {
            this.x = x;
            this.y = y;
            this.distance = distance;
            if("".equals(prePath)) {

                this.path = "(" + x + ", " + y + ")"; 
            }
            else {

                this.path = prePath + " -> " + "(" + x + ", " + y + ")"; 
        
            	//System.out.println(this.path);
            }
        }
    }
}