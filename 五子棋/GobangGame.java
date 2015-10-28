import java.io.BufferedReader;
import java.io.InputStreamReader;



public class GobangGame {
	// 定义达到赢条件的棋子数目
	private final int WIN_COUNT = 5;
	// 定义用户输入的X坐标
	private int posX = 0;
	// 定义用户输入的X坐标
	private int posY = 0;
	// 定义棋盘
	private Chessboard chessboard;
	private int[][] priorWhite = new int[22][22];
	private int[][] priorBlack = new int[22][22];
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
	public void start() throws Exception {
		// true为游戏结束
		boolean isOver = false;
		chessboard.initBoard();
		chessboard.printBoard();
		initPrior();
				
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
			updatePrior(posX,posY);
			// 判断用户是否赢了
			if (isWon(posX, posY, chessman)) {
				isOver = true;

			} else {
				// 计算机随机选择位置坐标
				int[] computerPosArr = computerDo();
				chessman = Chessman.WHITE.getChessman();
				chessboard.setBoard(computerPosArr[0], computerPosArr[1],
						chessman);
				updatePrior(computerPosArr[0], computerPosArr[1]);
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
					initPrior();
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
	public int[] computerDo() {

		int posX = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
		int posY = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
		int m = 0;
		for (int i = 0; i < Chessboard.BOARD_SIZE; i++)
		{
			for (int j = 0; j < Chessboard.BOARD_SIZE; j++)
			{
				if (m < priorBlack[i][j])
				{
					posX = i;
					posY = j;
					m = priorBlack[i][j];
				}
				if (m < priorWhite[i][j])
				{
					posX = i;
					posY = j;
					m = priorWhite[i][j];
				}
				
			}
		}
		String[][] board = chessboard.getBoard();
		while (board[posX][posY] != "十") {
			posX = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
			posY = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
		}
		int[] result = { posX, posY };
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
		int[] n = {1,0};
		if (linkedLength(posX,posY,ico,n) >= WIN_COUNT)
			return true;
		n[1] = 1;
		if (linkedLength(posX,posY,ico,n) >= WIN_COUNT)
			return true;
		n[0] = 0;
		if (linkedLength(posX,posY,ico,n) >= WIN_COUNT)
			return true;
		n[0] = -1;
		if (linkedLength(posX,posY,ico,n) >= WIN_COUNT)
			return true;
		return false;
	}
	
	public int linkedLength(int posX, int posY, String ico, int[] n)
	{
		int count = 1;
		int decrease = 0;
		String[][] board = chessboard.getBoard();
		for (int i = 1; i <= 4; i++)
		{
			int x = posX + i * n[0];
			int y = posY + i * n[1];			
			if (x < 0 || x >= Chessboard.BOARD_SIZE)
				break;
			if (y < 0 || y >= Chessboard.BOARD_SIZE)
				break;
			if (board[x][y] != ico && board[x][y] != "十")
			{
				decrease++;
				break;
			}
			if (board[x][y] != ico)
				break;
			count++;
		}
		for (int i = 1; i <= 4; i++)
		{
			int x = posX - i * n[0];
			int y = posY - i * n[1];
			if (x < 0 || x >= Chessboard.BOARD_SIZE)
				break;
			if (y < 0 || y >= Chessboard.BOARD_SIZE)
				break;
			if (board[x][y] != ico && board[x][y] != "十")
			{
				decrease++;
				break;
			}
			if (board[x][y] != ico)
				break;
			count++;
		}
		if (count < 5 && decrease > 0)
			count = 1;
		return count;
	}

	public void initPrior()
	{
		for (int i = 0; i < Chessboard.BOARD_SIZE; i++)
		{
			for (int j = 0; j < Chessboard.BOARD_SIZE; j++)
			{
				priorBlack[i][j] = 0;
				priorWhite[i][j] = 0;
			}
		}
	}
	public boolean updatePrior(int posX, int posY)
	{
		priorBlack[posX][posY] = -1;
		priorWhite[posX][posY] = -1;
		for (int i = 0; i < Chessboard.BOARD_SIZE; i++)
		{
			for (int j = 0; j < Chessboard.BOARD_SIZE; j++)
			{
				if (priorBlack[i][j] != -1)
				{
					priorBlack[i][j] = 0;
					String black = Chessman.BLACK.getChessman();
					int[] n = {1,0};
					priorBlack[i][j] += Math.pow(linkedLength(i,j,black,n),3);
					n[1] = 1;
					priorBlack[i][j] += Math.pow(linkedLength(i,j,black,n),3);
					n[0] = 0;
					priorBlack[i][j] += Math.pow(linkedLength(i,j,black,n),3);
					n[0] = -1;
					priorBlack[i][j] += Math.pow(linkedLength(i,j,black,n),3);

				}
				if (priorWhite[i][j] != -1)
				{
					priorWhite[i][j] = 0;
					String white = Chessman.WHITE.getChessman();
					int[] n = {1,0};
					priorWhite[i][j] += Math.pow(linkedLength(i,j,white,n),3);
					n[1] = 1;
					priorWhite[i][j] += Math.pow(linkedLength(i,j,white,n),3);
					n[0] = 0;
					priorWhite[i][j] += Math.pow(linkedLength(i,j,white,n),3);
					n[0] = -1;
					priorWhite[i][j] += Math.pow(linkedLength(i,j,white,n),3);					
				}
			}
		}
		return true;
	}
	public static void main(String[] args) throws Exception {

		GobangGame gb = new GobangGame(new Chessboard());
		gb.start();
	}
}
