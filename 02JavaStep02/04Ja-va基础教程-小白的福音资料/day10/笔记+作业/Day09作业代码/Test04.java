public class Test04 {
	public static void main(String[] args) {
		Person p = new Person();			//创建接口实现类对象
		p.playGame();						//使用实现类对象调用playGame()方法
	}
}

interface Play {							//接口
	public void playGame();
}

class Person implements Play{				//定义一个接口的实现类
	public void playGame(){					//重写接口中的抽象方法
		System.out.println("玩游戏");
	}
}