module demo {
	// 如果有其他模块依赖我，那么其他模块下面的3个包都可以访问
	exports cn.itcast.day10.demo01;
	exports cn.itcast.day10.demo02;
	exports cn.itcast.day10.demo03;
	
	// 我需要依赖book模块，才能完成我的工作
	requires book;
}