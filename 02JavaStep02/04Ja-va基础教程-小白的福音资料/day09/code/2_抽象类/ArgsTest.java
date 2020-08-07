class ArgsTest {
	public static void main(String[] args) {
		System.out.println(args);
		args = new String[]{"abc","def","ghi"};
		System.out.println(args);
		System.out.println(args.length);
	}
}
