package com.chess;
import java.io.BufferedReader;
import java.io.InputStreamReader;

 
public class GobangGame {
	// ����ﵽӮ������������Ŀ
	private final int WIN_COUNT = 5;
	// �����û������X����
	private int posX = 0;
	// �����û������X����
	private int posY = 0;
	// ��������
	private Chessboard chessboard;

	/**
	 * �չ�����
	 */
	public GobangGame() {
	}

	/**
	 * ����������ʼ�����̺���������
	 * 
	 * @param chessboard
	 *            ������
	 */
	public GobangGame(Chessboard chessboard) {
		this.chessboard = chessboard;
	}

	/**
	 * ��������Ƿ�Ϸ���
	 * 
	 * @param inputStr
	 *            �ɿ���̨������ַ�����
	 * @return �ַ����Ϸ�����true,���򷵻�false��
	 */
	public boolean isValid(String inputStr) {
		// ���û�������ַ����Զ���(,)��Ϊ�ָ����ָ��������ַ���
		String[] posStrArr = inputStr.split(",");
		try {
			posX = Integer.parseInt(posStrArr[0]) - 1;
			posY = Integer.parseInt(posStrArr[1]) - 1;
		} catch (NumberFormatException e) {
			chessboard.printBoard();
			System.out.println("����(����,����)�ĸ�ʽ���룺");
			return false;
		}
		// ���������ֵ�Ƿ��ڷ�Χ֮��
		if (posX < 0 || posX >= Chessboard.BOARD_SIZE || posY < 0
				|| posY >= Chessboard.BOARD_SIZE) {
			chessboard.printBoard();
			System.out.println("X��Y����ֻ�ܴ��ڵ���1,��С�ڵ���" + Chessboard.BOARD_SIZE
					+ ",���������룺");
			return false;
		}
		// ��������λ���Ƿ��Ѿ�������
		String[][] board = chessboard.getBoard();
		if (board[posX][posY] != "ʮ") {
			chessboard.printBoard();
			System.out.println("��λ���Ѿ������ӣ����������룺");
			return false;
		}
		return true;
	}

	/**
	 * ��ʼ����
	 */
	public void start() throws Exception {
		// trueΪ��Ϸ����
		boolean isOver = false;
		chessboard.initBoard();
		chessboard.printBoard();
		// ��ȡ���̵�����
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputStr = null;
		// br.readLine:ÿ����������һ�����ݰ��س���������������ݱ�br��ȡ��
		while ((inputStr = br.readLine()) != null) {
			isOver = false;
			if (!isValid(inputStr)) {
				// ������Ϸ���Ҫ���������룬�ټ���
				continue;
			}
			// �Ѷ�Ӧ������Ԫ�ظ�Ϊ"��"
			String chessman = Chessman.BLACK.getChessman();
			chessboard.setBoard(posX, posY, chessman);
			// �ж��û��Ƿ�Ӯ��
			if (isWon(posX, posY, chessman)) {
				isOver = true;

			} else {
				// �����ѡ��λ������
				int[] computerPosArr = computerDo();
				chessman = Chessman.WHITE.getChessman();
				chessboard.setBoard(computerPosArr[0], computerPosArr[1],
						chessman);
				// �жϼ�����Ƿ�Ӯ��
				if (isWon(computerPosArr[0], computerPosArr[1], chessman)) {
					isOver = true;
				}
			}
			// �������ʤ�ߣ�ѯ���û��Ƿ������Ϸ
			if (isOver) {
				// ������������³�ʼ�����̣�������Ϸ
				if (isReplay(chessman)) {
					chessboard.initBoard();
					chessboard.printBoard();
					continue;
				}
				// ������������˳�����
				break;
			}
			chessboard.printBoard();
			System.out.println("����������������꣬Ӧ��x,y�ĸ�ʽ���룺");
		}
	}

	/**
	 * �Ƿ����¿�ʼ���塣
	 * 
	 * @param chessman
	 *            "��"Ϊ�û���"��"Ϊ�������
	 * @return ��ʼ����true�����򷵻�false��
	 */
	public boolean isReplay(String chessman) throws Exception {
		chessboard.printBoard();
		String message = chessman.equals(Chessman.BLACK.getChessman()) ? "��ϲ������Ӯ�ˣ�"
				: "���ź��������ˣ�";
		System.out.println(message + "����һ�֣�(y/n)");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		if (br.readLine().equals("y")) {
			// ��ʼ��һ��
			return true;
		}
		return false;

	}

	/**
	 * �����������в������
	 */
	public int[] computerDo() {
		for(int i=0;i<Chessboard.BOARD_SIZE;i++){
			for(int j=0;j<Chessboard.BOARD_SIZE;j++){
				chessboard.getThreaten()[i][j]=0;
				}
			}
		int posX=0;
		int posY=0;
		initthreaten();
		int m=0;
		for(int i=0;i<Chessboard.BOARD_SIZE;i++){
			for(int j=0;j<Chessboard.BOARD_SIZE;j++){
				if(m<chessboard.getThreaten()[i][j]){
					m=chessboard.getThreaten()[i][j];
					posX=i;
					posY=j;
				}
			}
		}
//		int posX = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
//		int posY = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
//	    String[][] board = chessboard.getBoard();
//		while (board[posX][posY] != "ʮ") {
//			posX = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
//			posY = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
//		}
		int[] result = { posX, posY };		
		return result;
	}
	/**
	 * �ж������ϵ���в��
	 * 
	 */
     public void initthreaten(){
    	 for(int i=0;i<Chessboard.BOARD_SIZE;i++){
    		 for(int j=0;j<Chessboard.BOARD_SIZE;j++){
    			 if(chessboard.getBoard()[i][j]!="ʮ"){
    				 chessboard.getThreaten()[i][j]=0;
    				 continue;
    			 }
    			 else{
    				 chessboard.getThreaten()[i][j]=(int)Math.pow(ysize(i,j,Chessman.BLACK.getChessman()),2)+(int)Math.pow(xsize(i,j,Chessman.BLACK.getChessman()),2)+(int)Math.pow(yxsize(i,j,Chessman.BLACK.getChessman()),2)+(int)Math.pow(xysize(i,j,Chessman.BLACK.getChessman()),2);
    			 }
    		 }
    	 }
     }
	
	
	/**
	 * �ж���Ӯ
	 * 
	 * @param posX
	 *            ���ӵ�X���ꡣ
	 * @param posY
	 *            ���ӵ�Y����
	 * @param ico
	 *            ��������
	 * @return ��������������������һ��ֱ�ӣ������棬�����෴��
	 */
	public boolean isWon(int posX, int posY, String ico) {
		
		if(ysize(posX,posY,ico)>=5||xsize(posX,posY,ico)>=5||xysize(posX,posY,ico)>=5||yxsize(posX,posY,ico)>=5){
			return true;
		}	
		return false;
	}
	public boolean isBundle(int x,int y){
		if(x<0||x>21||y<0||y>21){
			return true;
		}
		return false;
	}
    public int ysize(int x,int y,String ico){
    	int size=1;
    	if((!isBundle(x, y-1))&&chessboard.getBoard()[x][y-1].equals(ico)){
    		++size;
    		if((!isBundle(x, y-2))&&chessboard.getBoard()[x][y-2].equals(ico)){
    			++size;
    			if((!isBundle(x, y-3))&&chessboard.getBoard()[x][y-3].equals(ico)){
    				++size;
    				if((!isBundle(x, y-4))&&chessboard.getBoard()[x][y-4].equals(ico)){
    					++size;
    				}
    			}
    		}
    	}
    	if((!isBundle(x, y+1))&&chessboard.getBoard()[x][y+1].equals(ico)){
    		++size;
    		if((!isBundle(x, y+2))&&chessboard.getBoard()[x][y+2].equals(ico)){
    			++size;
    			if((!isBundle(x, y+3))&&chessboard.getBoard()[x][y+3].equals(ico)){
    				++size;
    				if((!isBundle(x, y+4))&&chessboard.getBoard()[x][y+4].equals(ico)){
    					++size;
    				}
    			}
    		}
    		
    	}
    	return size;
    }
    public int xsize(int x,int y,String ico){
    	int size=1;
    	if((!isBundle(x-1, y))&&chessboard.getBoard()[x-1][y].equals(ico)){
    		++size;
    		if((!isBundle(x-2, y))&&chessboard.getBoard()[x-2][y].equals(ico)){
    			++size;
    			if((!isBundle(x-3, y))&&chessboard.getBoard()[x-3][y].equals(ico)){
    				++size;
    				if(!isBundle(x-4, y)&&chessboard.getBoard()[x-4][y].equals(ico)){
    					++size;
    				}
    			}
    		}
    	}
    	if((!isBundle(x+1, y))&&chessboard.getBoard()[x+1][y].equals(ico)){
    		++size;
    		if((!isBundle(x+2, y))&&chessboard.getBoard()[x+2][y].equals(ico)){
    			++size;
    			if((!isBundle(x+3, y))&&chessboard.getBoard()[x+3][y].equals(ico)){
    				++size;
    				if((!isBundle(x+4, y))&&chessboard.getBoard()[x+4][y].equals(ico)){
    					++size;
    				}
    			}
    		}
    	}
        return size;
    	
    	
    }
    public int xysize(int x,int y,String ico){
    	int size=1;
    	if((!isBundle(x+1, y-1))&&chessboard.getBoard()[x+1][y-1].equals(ico)){
    		++size;
    		if((!isBundle(x+2, y-2))&&chessboard.getBoard()[x+2][y-2].equals(ico)){
    			++size;
    			if((!isBundle(x+3, y-3))&&chessboard.getBoard()[x+3][y-3].equals(ico)){
    				++size;
    				if((!isBundle(x+4, y-4))&&chessboard.getBoard()[x+3][y-4].equals(ico)){
    					++size;
    				}
    			}
    		}
    	}
    	if((!isBundle(x-1, y+1))&&chessboard.getBoard()[x-1][y+1].equals(ico)){
    		++size;
    		if((!isBundle(x-2, y+2))&&chessboard.getBoard()[x-2][y+2].equals(ico)){
    			++size;
    			if((!isBundle(x-3, y+3))&&chessboard.getBoard()[x-3][y+3].equals(ico)){
    				++size;
    				if((!isBundle(x-4, y+4))&&chessboard.getBoard()[x-4][y+4].equals(ico)){
    					++size;
    				}
    			}
    		}
    	}
    	return size;
    }
    public int yxsize(int x,int y,String ico){
    	int size=1;
    	if((!isBundle(x-1, y-1))&&chessboard.getBoard()[x-1][y-1].equals(ico)){
    		++size;
    		if((!isBundle(x-2, y-2))&&chessboard.getBoard()[x-2][y-2].equals(ico)){
    			++size;
    			if((!isBundle(x-3, y-3))&&chessboard.getBoard()[x-3][y-3].equals(ico)){
    				++size;
    				if((!isBundle(x-4, y-4))&&chessboard.getBoard()[x-4][y-4].equals(ico)){
    					++size;
    				}
    			}
    		}
    	}
    	if((!isBundle(x+1, y+1))&&chessboard.getBoard()[x+1][y+1].equals(ico)){
    		++size;
    		if((!isBundle(x+2, y+2))&&chessboard.getBoard()[x+2][y+2].equals(ico)){
    			++size;
    			if((!isBundle(x+3, y+3))&&chessboard.getBoard()[x+3][y+3].equals(ico)){
    				++size;
    				if((!isBundle(x+4, y+4))&&chessboard.getBoard()[x+4][y+4].equals(ico)){
    					++size;
    				}
    			}
    		}
    	}
    	return size;
    }
	public static void main(String[] args) throws Exception {

		GobangGame gb = new GobangGame(new Chessboard());
		gb.start();
	}
}
