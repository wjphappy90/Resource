public class Test01 {
	public static void main(String[] args) {
		new Play(){						//创建匿名对象
			public void playGame(){		//重写接口中的抽象方法
				System.out.println("玩游戏");
			}
		}.playGame();					//使用匿名对象调用playGame()方法
	}
}

interface Play {						//接口
	public void playGame();
}