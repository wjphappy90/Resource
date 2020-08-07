public class Test01 {
	public static void main(String[] args) {
		Programer p = new Programer("张三","0001",6888.8);	//创建程序员类对象，并使用有参构造给属性赋值
															//打印输出程序员类的属性
		System.out.println(p.getName() +"--"+ p.getId() +"--"+p.getSalary());
		p.work();											//调用程序员的工作方法
															//创建项目经理类对象，并使用有参构造给属性赋值
		ProjectManager pm = new ProjectManager("李四", "0002", 8888.88, 250);
															//打印输出项目经理类的属性
		System.out.println(pm.getName()+"--"+ pm.getId() +"--"+pm.getSalary() + "--" + pm.getBouns());
		pm.work();											//调用项目经理的工作方法
		
	}
}

class Emplyee {				//员工
					
	private String name;	//姓名
	private String id;		//工号
	private double salary;	//工资
	
	public Emplyee(){}		//无参构造方法
							//有参构造方法
	public Emplyee(String name, String id, double salary){
		this.name = name;
		this.id = id;
		this.salary = salary;
	}

	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}
	public void setId(String id){
		this.id = id;
	}
	public String getId(){
		return id;
	}
	public void setSalary(double salary){
		this.salary = salary;
	}
	public double getSalary(){
		return salary;
	}
	public void work(){
		System.out.println("工作");
	}
}

class Programer extends Emplyee	//程序员
{
	public Programer(){}		//无参构造方法
								//有参构造方法
	public Programer(String name, String id, double salary){
		super(name,id,salary);
	}
	public void work(){
		System.out.println("程序员工作");
	}
}

class ProjectManager extends Emplyee// 项目经理
{
	private double bouns;			//奖金

	public ProjectManager(){}		//无参构造方法
									//有参构造方法
	
	public ProjectManager(String name, String id, double salary, double bouns){
		super(name,id,salary);
		this.bouns = bouns;
	}
	public void setBouns(double bouns){
		this.bouns = bouns;
	}
	public double getBouns(){
		return bouns;
	}
	public void work(){
		System.out.println("项目经理工作");
	}
}
