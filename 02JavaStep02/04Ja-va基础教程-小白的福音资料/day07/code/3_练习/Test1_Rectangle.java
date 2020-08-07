class Test1_Rectangle {							//Rectangle矩形
	public static void main(String[] args) {
		Rectangle r = new Rectangle(10,20);
		System.out.println(r.getLength());		//周长
		System.out.println(r.getArea());		//面积
	}
}
/*
* A:案例演示
	* 需求：
		* 定义一个长方形类,定义 求周长和面积的方法，
		* 然后定义一个测试类进行测试。
	分析:
		成员变量:
			宽width,高high
		空参有参构造
		成员方法:
			setXxx和getXxx
			求周长:getLength()
			求面积:getArea()
*/
class Rectangle {
	private int width;				//宽
	private int high;				//高

	public Rectangle(){}			//空参构造

	public Rectangle(int width,int high) {
		this.width = width;			//有参构造
		this.high = high;
	}

	public void setWidth(int width) {//设置宽
		this.width = width;
	}

	public int getWidth() {			//获取宽
		return width;
	}

	public void setHigh(int high) {	//设置高
		this.high = high;
	}

	public int getHigh() {			//获取高
		return high;
	}

	public int getLength() {		//获取周长
		return 2 * (width + high);
	}

	public int getArea() {			//获取面积
		return width * high;
	}
}
