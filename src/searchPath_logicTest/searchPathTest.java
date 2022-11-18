package searchPath_logicTest;

public class searchPathTest {
	
	public static void main(String[] args ) {
		final int matrixSize= 5; 	
		int width;
		int height;
		int count =0;
		Block[][] blockMatrix = new Block[matrixSize][matrixSize];
		
		//블록 초기화 
		for(width=0; width<matrixSize; width++) {
			
			for(height=0; height<matrixSize; height++) {
				
				//블록 생성
				blockMatrix[width][height] = new Block();
				
				//일단 모든 블록을 복도로 초기화
				
				blockMatrix[width][height].setAreaNumber(count);
				blockMatrix[width][height].setRoom("path");
				blockMatrix[width][height].setColor("Green");
				count ++;
			}
		}
		//호실 표시 
		blockMatrix[0][0].setRoom("401");
		blockMatrix[0][0].setColor("Gray");

		blockMatrix[0][1].setRoom("401");
		blockMatrix[0][1].setColor("Gray");

		blockMatrix[0][3].setRoom("401");
		blockMatrix[0][3].setColor("Gray");
		

		blockMatrix[0][4].setRoom("401");
		blockMatrix[0][4].setColor("Gray");
		
		blockMatrix[2][0].setRoom("401");
		blockMatrix[2][0].setColor("Gray");
		
		blockMatrix[2][1].setRoom("401");
		blockMatrix[2][1].setColor("Gray");
		
		blockMatrix[3][4].setRoom("401");
		blockMatrix[3][4].setColor("Gray");
		
		blockMatrix[4][4].setRoom("401");
		blockMatrix[4][4].setColor("Gray");
	
		//비상구 블록 표시

		blockMatrix[0][4].setRoom("escape");
		blockMatrix[0][4].setColor("Blue");
		
		blockMatrix[4][0].setRoom("escape");
		blockMatrix[4][0].setColor("Blue");
		
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {

				System.out.print(blockMatrix[i][j].getAreaNumber()+" ");
			}
			System.out.println();
		}	
	}
}
