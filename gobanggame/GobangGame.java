package GobangGame;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 五子棋游戏类
 
 */
public class GobangGame {
	// 定义达到赢条件的棋子数目
	private final int WIN_COUNT = 5;
	// 定义用户输入的X坐标
	private int posX = 0;
	// 定义用户输入Y坐标
	private int posY = 0;
	// 定义棋盘
	private Chessboard chessboard;

///-----syl
//	private int PC_x;
//	private int PC_y;
//	private int PC_maxNum;
//	private int PC_direction;//表示方向1代表横向，2代表纵向，3代表斜向
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
	 * 空构造器
	 */
	public GobangGame() {
	}

	/**
	 * 构造器，初始化棋盘和棋子属性
	 * 
	 * @param chessboard
	 *            棋盘类
	 */
	public GobangGame(Chessboard chessboard) {
		this.chessboard = chessboard;
	}

	/**
	 * 检查输入是否合法。
	 * 
	 * @param inputStr
	 *            由控制台输入的字符串。
	 * @return 字符串合法返回true,反则返回false。
	 */
	public boolean isValid(String inputStr) {
		// 将用户输入的字符串以逗号(,)作为分隔，分隔成两个字符串
		String[] posStrArr = inputStr.split(",");
		try {
			posX = Integer.parseInt(posStrArr[0]) - 1;
			posY = Integer.parseInt(posStrArr[1]) - 1;
		} catch (NumberFormatException e) {
			chessboard.printBoard();
			System.out.println("请以(数字,数字)的格式输入：");
			return false;
		}
		// 检查输入数值是否在范围之内
		if (posX < 0 || posX >= Chessboard.BOARD_SIZE || posY < 0
				|| posY >= Chessboard.BOARD_SIZE) {
			chessboard.printBoard();
			System.out.println("X与Y坐标只能大于等于1,与小于等于" + Chessboard.BOARD_SIZE
					+ ",请重新输入：");
			return false;
		}
		// 检查输入的位置是否已经有棋子
		String[][] board = chessboard.getBoard();
		if (board[posX][posY] != "十") {
			chessboard.printBoard();
			System.out.println("此位置已经有棋子，请重新输入：");
			return false;
		}
		return true;
	}

	/**
	 * 开始下棋
	 */
	//////////////////-----SYL/////////////////////////
//	public void pcGo()//电脑下棋
//	{
//	//	setMaxNumAndXY(1);
//		setMaxNumAndXY("○");
//	//	setPlayerNextLocation();
//		setPCNextLocation();
////		System.out.println("玩家全连最多棋子位置："+getPlayerx()+","+getPlayery());
////		System.out.println("玩家全连最多棋子数目:"+getPlayerMaxNum());
////		System.out.println("玩家全连最多方位:"+getPlayerDirection());
//		System.out.println("电脑全连最多棋子位置:"+getPCx()+","+getPCy());
//		System.out.println("电脑全连最多棋子数目："+getPCMaxNum());
//		System.out.println("电脑全连最多棋子方位:"+getPCDirection());
//		
//	     attack();
//	
//			
//	}
	
//	public void attack() //电脑进攻
//	{
//		System.out.println("策略：进攻"+"\t"+getPCNextX()+","+getPCNextY());
//		if(p.getState(getPCNextX(),getPCNextY())!=0)
//		{
//			//locateAnyWhere(2); //随机
//		}
//		p.setState(getPCNextX(),getPCNextY(),2);
//		p.setAlignment(getPCNextX(),getPCNextY());
//		p.repaint();
//	}
//	
//	public void setMaxNumAndXY(String currentState)//0---+,1--黑，2---
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
//		//横向
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
//		//纵向
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
//		//反斜向
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
//		//正斜向
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
//	public void setPCLocationAndNum(int x,int y,int value,int dire)//下棋的感觉
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
		// true为游戏结束
		boolean isOver = false;
		chessboard.initBoard();
		chessboard.printBoard();
		// 获取键盘的输入
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputStr = null;
		// br.readLine:每当键盘输入一行内容按回车键，则输入的内容被br读取到
		while ((inputStr = br.readLine()) != null) {
			isOver = false;
			if (!isValid(inputStr)) {
				// 如果不合法，要求重新输入，再继续
				continue;
			}
			// 把对应的数组元素赋为"●"
			String chessman = Chessman.BLACK.getChessman();
			chessboard.setBoard(posX, posY, chessman);
			// 判断用户是否赢了
			if (isWon(posX, posY, chessman)) {
				isOver = true;

			} else {
				// 计算机随机选择位置坐标
				///////---------这里要挑出X，Y---------------/////
				///最后没有实现AI，简单的随机了。。。。。
				int[] computerPosArr = computerDo(posX,posY);
			    ///////---------这里要挑出X，Y---------------/////
				
				chessman = Chessman.WHITE.getChessman();
				chessboard.setBoard(computerPosArr[0], computerPosArr[1],
						chessman);
				// 判断计算机是否赢了
				if (isWon(computerPosArr[0], computerPosArr[1], chessman)) {
					isOver = true;
				}
			}
			// 如果产生胜者，询问用户是否继续游戏
			if (isOver) {
				// 如果继续，重新初始化棋盘，继续游戏
				if (isReplay(chessman)) {
					chessboard.initBoard();
					chessboard.printBoard();
					continue;
				}
				// 如果不继续，退出程序
				break;
			}
			chessboard.printBoard();
			System.out.println("请输入您下棋的坐标，应以x,y的格式输入：");
		}
	}

	/**
	 * 是否重新开始下棋。
	 * 
	 * @param chessman
	 *            "●"为用户，"○"为计算机。
	 * @return 开始返回true，反则返回false。
	 */
	public boolean isReplay(String chessman) throws Exception {
		chessboard.printBoard();
		String message = chessman.equals(Chessman.BLACK.getChessman()) ? "恭喜您，您赢了，"
				: "很遗憾，您输了，";
		System.out.println(message + "再下一局？(y/n)");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		if (br.readLine().equals("y")) {
			// 开始新一局
			return true;
		}
		return false;

	}

	/**
	 * 计算机随机下棋
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
		while (board[x][y] != "十") {
			x++;
			
		}
		}
		x=y=1;
		if((num2>=num1)&&(num2>=num4)&&(num2>=num3))
		{x = posX;
		 y =posY+1;
		String[][] board = chessboard.getBoard();
		while (board[x][y] != "十") {
		y++;
		}
		}
		int[] result = { x, y };
		return result;
	}
	/**
	 * 判断输赢
	 * 
	 * @param posX
	 *            棋子的X坐标。
	 * @param posY
	 *            棋子的Y坐标
	 * @param ico
	 *            棋子类型
	 * @return 如果有五颗相邻棋子连成一条直接，返回真，否则相反。
	 */
	public boolean isWon(int posX, int posY, String ico) {
		// 直线起点的X坐标
		int startX = 0;
		// 直线起点Y坐标
		int startY = 0;
		// 直线结束X坐标
		int endX = Chessboard.BOARD_SIZE - 1;
		// 直线结束Y坐标
		int endY = endX;
		// 同条直线上相邻棋子累积数
		int sameCount = 0;
		int temp = 0;

		// 计算起点的最小X坐标与Y坐标
		temp = posX - WIN_COUNT + 1;
		startX = temp < 0 ? 0 : temp;
		temp = posY - WIN_COUNT + 1;
		startY = temp < 0 ? 0 : temp;
		// 计算终点的最大X坐标与Y坐标
		temp = posX + WIN_COUNT - 1;
		endX = temp > Chessboard.BOARD_SIZE - 1 ? Chessboard.BOARD_SIZE - 1
				: temp;
		temp = posY + WIN_COUNT - 1;
		endY = temp > Chessboard.BOARD_SIZE - 1 ? Chessboard.BOARD_SIZE - 1
				: temp;
		// 从左到右方向计算相同相邻棋子的数目
		String[][] board = chessboard.getBoard();
		for (int i = startY; i < endY; i++) {
			if (board[posX][i] == ico && board[posX][i + 1] == ico) {
				sameCount++;
			} else if (sameCount != WIN_COUNT - 1) {
				sameCount = 0;
			}
		}
		if (sameCount == 0) {
			// 从上到下计算相同相邻棋子的数目
			for (int i = startX; i < endX; i++) {
				if (board[i][posY] == ico && board[i + 1][posY] == ico) {
					sameCount++;
				} else if (sameCount != WIN_COUNT - 1) {
					sameCount = 0;
				}
			}
		}
		if (sameCount == 0) {
			// 从左上到右下计算相同相邻棋子的数目
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
