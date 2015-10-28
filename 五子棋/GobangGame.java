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
	private int[][] priorWhite = new int[22][22];
	private int[][] priorBlack = new int[22][22];
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
		initPrior();
				
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
			updatePrior(posX,posY);
			// �ж��û��Ƿ�Ӯ��
			if (isWon(posX, posY, chessman)) {
				isOver = true;

			} else {
				// ��������ѡ��λ������
				int[] computerPosArr = computerDo();
				chessman = Chessman.WHITE.getChessman();
				chessboard.setBoard(computerPosArr[0], computerPosArr[1],
						chessman);
				updatePrior(computerPosArr[0], computerPosArr[1]);
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
					initPrior();
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
		while (board[posX][posY] != "ʮ") {
			posX = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
			posY = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
		}
		int[] result = { posX, posY };
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
			if (board[x][y] != ico && board[x][y] != "ʮ")
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
			if (board[x][y] != ico && board[x][y] != "ʮ")
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
