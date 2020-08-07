package com.itheima.proxy;

//代理角色
public class TargetProxy implements ITarget {

	private ITarget target; // 目标

	public TargetProxy(ITarget target) {
		this.target = target;
	}

	@Override
	public void show() {
		// 在代理中通过目标来调用真实行为
		// 1.例如判断是否有权限调用目标行为
		// 2.进行日志操作
		// 3.性能临近
		target.show();
	}

}
