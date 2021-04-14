public class BurnTreesTimer {

	public static void main(String[] args) {
		int WIDTH = 1000;
		int HEIGHT = 1000;
		double DENSITY = 1.0;

		if(args.length > 1){
			WIDTH = Integer.parseInt(args[0]);
			HEIGHT = Integer.parseInt(args[1]);
			DENSITY = Double.parseDouble(args[2]);
		}

		BurnTrees test = new BurnTrees(WIDTH, HEIGHT, DENSITY);

		long startTime = System.currentTimeMillis();
		int ticks = test.run();
		long endTime = System.currentTimeMillis();

		System.out.println("Executed in " + (endTime-startTime)/1000.0 + " seconds in " + ticks + " ticks.");
	}

}
