public abstract Class PageContext{
	/**
	  * 从四个域中由小到大逐个查找，根据name
	  */
	public Object findAttribute(String name){
		Object value = null;
		//1.先在page域找
		value = this.getAttribute(name);
		if(value != null){
			return value;
		}
	
		//2.去请求域中找
		value = this.getRequest().getAttribute(name);
		if(value != null){
			return value;
		}

		//3.去会话域中找
		value = this.getSession().getAttribute(name);
		if(value != null){
			return value;
		}


		//4.去应用域中找
		value = this.getServletContext().getAttribute(name);
		if(value != null){
			return value;
		}
		return value;
	}

}