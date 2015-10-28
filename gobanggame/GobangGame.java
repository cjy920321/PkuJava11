package GobangGame;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * ��������Ϸ��
 
 */
public class GobangGame {
	// ����ﵽӮ������������Ŀ
	private final int WIN_COUNT = 5;
	// �����û������X����
	private int posX = 0;
	// �����û�����Y����
	private int posY = 0;
	// ��������
	private Chessboard chessboard;

///-----syl
//	private int PC_x;
//	private int PC_y;
//	private int PC_maxNum;
//	private int PC_direction;//��ʾ����1�������2��������3����б��
//	private int PC_nextx;
//	private int PC_nexty;
//	
//	private int player_x;
//	private int player_y;
//	private int player_maxNum;
//	private int player_direction;
//	private int player_nextx;
//	private int player_nexty;
//	//----syl
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
	//////////////////-----SYL/////////////////////////
//	public void pcGo()//��������
//	{
//	//	setMaxNumAndXY(1);
//		setMaxNumAndXY("��");
//	//	setPlayerNextLocation();
//		setPCNextLocation();
////		System.out.println("���ȫ���������λ�ã�"+getPlayerx()+","+getPlayery());
////		System.out.println("���ȫ�����������Ŀ:"+getPlayerMaxNum());
////		System.out.println("���ȫ����෽λ:"+getPlayerDirection());
//		System.out.println("����ȫ���������λ��:"+getPCx()+","+getPCy());
//		System.out.println("����ȫ�����������Ŀ��"+getPCMaxNum());
//		System.out.println("����ȫ��������ӷ�λ:"+getPCDirection());
//		
//	     attack();
//	
//			
//	}
	
//	public void attack() //���Խ���
//	{
//		System.out.println("���ԣ�����"+"\t"+getPCNextX()+","+getPCNextY());
//		if(p.getState(getPCNextX(),getPCNextY())!=0)
//		{
//			//locateAnyWhere(2); //���
//		}
//		p.setState(getPCNextX(),getPCNextY(),2);
//		p.setAlignment(getPCNextX(),getPCNextY());
//		p.repaint();
//	}
//	
//	public void setMaxNumAndXY(String currentState)//0---+,1--�ڣ�2---
//	{
//		int maxNum=0;
//		int x=0;
//		int y=0;
//		int i=0;
//		int j=0;
//		int num=0;
//		int tempi;
//		int tempj;
//		int a=4;
//		int direction=0;
//		//����
//		while(j<=14)
//		{
//			while(i<=14)
//			{
//				tempi=i;
//				while((tempi<=14)&&(a>=0)&&(chessboard.board[tempi][j])==currentState)
//				{
//					num++;
//					tempi++;
//					a--;
//				}
//				if(maxNum<=num)
//				{
//					if((((i-1)>=0)&&(chessboard.board[i+num][j]=="+")|| (((i+num)<=14)&&(chessboard.board[i+num][j]=="+")) ))
//					{
//						maxNum=num;
//					    x=i;
//					    y=j;
//					    direction=1;	
//					}	
//				}
//				i++;
//				a=4;
//				num=0;
//			}
//			j++;
//			i=0;
//		}
//		
//		i=0;
//		j=0;
//		//����
//		while(i<=14)
//		{
//			while(j<=14)
//			{
//				tempj=j;
//				while((tempj<=14)&&(chessboard.board[i][tempj]==currentState)&&(a>=0))
//				{
//					num++;
//					tempj++;
//				}
//				if(maxNum<=num)
//				{
//					if((((j-1)>=0)&&(chessboard.board[i][j-1]))||(((j+num)<=14)&&(p.getState(i,(j+num))==0)))
//					{
//						maxNum=num;
//					    x=i;
//					    y=j;
//					    direction=2;	
//					}
//				}
//				j++;
//				num=0;
//				a=4;
//			}
//			i++;
//			j=0;
//		}
//		
//		i=0;
//		j=0;
//		//��б��
//		while(i<=14)
//		{
//			while(j<=14)
//			{
//				tempi=i;
//				tempj=j;
//				while((tempi<=14)&&(tempj<=14)&&(p.getState(tempi,tempj)==currentState)&&(a>=0))
//				{
//					num++;
//					tempi++;
//					tempj++;
//				}
//				if(num>=maxNum)
//				{
//					if((((i-1)>=0)&&((j-1)>=0)&&(p.getState((i-1),(j-1))==0))||(((i+num)<=14)&&((j+num)<=14)&&(p.getState((i+num),(j+num))==0)))
//					{
//						maxNum=num;
//					    x=i;
//					    y=j;
//					    direction=3;	
//					}
//				}
//				num=0;
//				j++;
//			}
//			i++;
//			j=0;
//		}
//		i=0;
//		j=0;
//		//��б��
//		while(i<=14)
//		{
//			while(j<=14)
//			{
//				tempi=i;
//				tempj=j;
//				while((tempi>=0)&&(tempj<=14)&&(p.getState(tempi,tempj)==currentState)&&(a>=0))
//				{
//					num++;
//					tempi--;
//					tempj++;
//				}
//				if(num>=maxNum)
//				{
//					if((((i+1)<=14)&&((j-1)>=0)&&(p.getState((i+1),(j-1))==0))||(((i-num)>=0)&&((j+num)<=14)&&(p.getState((i-num),(j+num))==0)))
//					{
//						maxNum=num;
//					    x=i;
//					    y=j;
//					    direction=4;	
//					}
//				}
//				num=0;
//				j++;
//			}
//			i++;
//			j=0;
//		}
//	
//		
//		if(currentState==1)
//		{
//			setPlayerLocationAndNum(x,y,maxNum,direction);	
//		}
//		if(currentState==2)
//		{
//			setPCLocationAndNum(x,y,maxNum,direction);
//		}
//		
//	}
//	
//	public void setPCLocationAndNum(int x,int y,int value,int dire)//����ĸо�
//	{
//		PC_x=x;
//		PC_y=y;
//		PC_maxNum=value; //maxNum
//		PC_direction=dire;
//	}
//	
//	public void setPCNextLocation()//
//	{
//		int x,y,num,direction;
//		int nextX;
//		int nextY;
//		x=getPCx();
//		y=getPCy();
//		num=getPCMaxNum();
//		direction=getPCDirection();
//		if(direction==1)
//		{
//			nextX=x-1;
//			if((nextX>=0)&&(nextX<=14)&&(p.getState(nextX,y)==0))
//			{
//				PC_nextx=nextX;
//				PC_nexty=y;
//			}
//			else if(((nextX=x+num)<=14)&&(p.getState(nextX,y)==0))
//			{
//				PC_nextx=nextX;
//				PC_nexty=y;
//			}
//			else
//			{
//				//locateAnyWhere(2);
//			}
//		}
//		if(direction==2)
//		{
//			nextY=y-1;
//			if((nextY>=0)&&(p.getState(x,nextY)==0))
//			{
//				PC_nextx=x;
//				PC_nexty=nextY;
//			}
//			else if(((nextY=y+num)<=14)&&(p.getState(x,nextY)==0))
//			{
//				PC_nextx=x;
//				PC_nexty=nextY;
//			}
//			else
//			{
//				//locateAnyWhere(2);
//			}
//		}
//		if(direction==3)
//		{
//			nextX=x-1;
//			nextY=y-1;
//			if((nextX>=0)&&(nextY>=0)&&(p.getState(nextX,nextY)==0))
//			{
//				PC_nextx=nextX;
//				PC_nexty=nextY;
//			}
//			else if(((nextX=x+num)<=14)&&((nextY=y+num)<=14)&&(p.getState(nextX,nextY)==0))
//			{
//				PC_nextx=nextX;
//				PC_nexty=nextY;
//			}
//			else
//			{
//				//locateAnyWhere(2);
//			}
//		}
//		if(direction==4)
//		{
//			nextX=x+1;
//			nextY=y-1;
//			if((nextX<=14)&&(nextY>=0)&&(p.getState(nextX,nextY)==0))
//			{
//				PC_nextx=nextX;
//				PC_nexty=nextY;
//			}
//			else if(((nextX=x-num)>=0)&&((nextY=y+num)<=14)&&(p.getState(nextX,nextY)==0))
//			{
//				PC_nextx=nextX;
//				PC_nexty=nextY;
//			}
//			else
//			{
//				//locateAnyWhere(2);
//			}
//		}
//	}
//	
//	
	
	
	//////////////////////////////////SYL
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
				// ��������ѡ��λ������
				///////---------����Ҫ����X��Y---------------/////
				///���û��ʵ��AI���򵥵�����ˡ���������
				int[] computerPosArr = computerDo(posX,posY);
			    ///////---------����Ҫ����X��Y---------------/////
				
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
	 * ������������
	 */
	public int[] computerDo(int posX,int posY) {
		String [][] jboard=this.chessboard.getBoard();
		int flag1=1,flag2=1,num1,num2,num3,num4;
			
		while(true)
		{      num1=flag1+flag2;
		     if((posX+flag1)<22)
			if(jboard[posX+flag1][posY]==jboard[posX][posY])
			{ flag1++;   
		
			}
		     if((posX-flag2)>=0)
		     if(jboard[posX-flag2][posY]==jboard[posX][posY])
		         flag2++;
		      
			    
		      if(num1==(flag1+flag2))
		       break;
		}
		
		while(true)
		{      num2=flag1+flag2;
		     if((posY+flag1)<22)
			if(jboard[posX][posY+flag1]==jboard[posX][posY])
			{ flag1++;   
			
			}
		      if((posY-flag2)>=0)
		       if(jboard[posX][posY-flag2]==jboard[posX][posY])
		         flag2++;
		     
			  
		      if(num2==(flag1+flag2))
		       break;
		}
		while(true)
		{      num3=flag1+flag2;
		if((posY+flag1)<22&&(posX+flag1)<22)
			if(jboard[posX+flag1][posY+flag1]==jboard[posX][posY])
			{ flag1++;   
		
			}
		if((posY-flag2)>=0&&(posX-flag2)>0)     
		if(jboard[posX-flag2][posY-flag2]==jboard[posX][posY])
		         flag2++;
		      
			    
		      if(num3==(flag1+flag2))
		       break;
		}
		while(true)
		{      num4=flag1+flag2;
		if((posY-flag1)>=0&&(posX+flag1)<22)
			if(jboard[posX+flag1][posY-flag1]==jboard[posX][posY])
			{ flag1++;   
		
			}
		if((posX-flag2)>=0&&(posY+flag2)<22)
		       if(jboard[posX-flag2][posY+flag2]==jboard[posX][posY])
		         flag2++;
		 if(num4==(flag1+flag2))
		       break;
		}
		int x=1,y=1;
		if((num1>=num2)&&(num1>=num3)&&(num1>=num4))
		{x = posX+1;
		 y =posY;
		String[][] board = chessboard.getBoard();
		while (board[x][y] != "ʮ") {
			x++;
			
		}
		}
		x=y=1;
		if((num2>=num1)&&(num2>=num4)&&(num2>=num3))
		{x = posX;
		 y =posY+1;
		String[][] board = chessboard.getBoard();
		while (board[x][y] != "ʮ") {
		y++;
		}
		}
		int[] result = { x, y };
		return result;
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
		// ֱ������X����
		int startX = 0;
		// ֱ�����Y����
		int startY = 0;
		// ֱ�߽���X����
		int endX = Chessboard.BOARD_SIZE - 1;
		// ֱ�߽���Y����
		int endY = endX;
		// ͬ��ֱ�������������ۻ���
		int sameCount = 0;
		int temp = 0;

		// ����������СX������Y����
		temp = posX - WIN_COUNT + 1;
		startX = temp < 0 ? 0 : temp;
		temp = posY - WIN_COUNT + 1;
		startY = temp < 0 ? 0 : temp;
		// �����յ�����X������Y����
		temp = posX + WIN_COUNT - 1;
		endX = temp > Chessboard.BOARD_SIZE - 1 ? Chessboard.BOARD_SIZE - 1
				: temp;
		temp = posY + WIN_COUNT - 1;
		endY = temp > Chessboard.BOARD_SIZE - 1 ? Chessboard.BOARD_SIZE - 1
				: temp;
		// �����ҷ��������ͬ�������ӵ���Ŀ
		String[][] board = chessboard.getBoard();
		for (int i = startY; i < endY; i++) {
			if (board[posX][i] == ico && board[posX][i + 1] == ico) {
				sameCount++;
			} else if (sameCount != WIN_COUNT - 1) {
				sameCount = 0;
			}
		}
		if (sameCount == 0) {
			// ���ϵ��¼�����ͬ�������ӵ���Ŀ
			for (int i = startX; i < endX; i++) {
				if (board[i][posY] == ico && board[i + 1][posY] == ico) {
					sameCount++;
				} else if (sameCount != WIN_COUNT - 1) {
					sameCount = 0;
				}
			}
		}
		if (sameCount == 0) {
			// �����ϵ����¼�����ͬ�������ӵ���Ŀ
			int j = startY;
			for (int i = startX; i < endX; i++) {
				if (j < endY) {
					if (board[i][j] == ico && board[i + 1][j + 1] == ico) {
						sameCount++;
					} else if (sameCount != WIN_COUNT - 1) {
						sameCount = 0;
					}
					j++;
				}
			}
		}
		return sameCount == WIN_COUNT - 1 ? true : false;
	}

	public static void main(String[] args) throws Exception {

		GobangGame gb = new GobangGame(new Chessboard());
		gb.start();
	}
}
