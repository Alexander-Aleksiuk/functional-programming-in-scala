package common

object wsCommon {
	def sum(f: Int => Int)(a: Int, b: Int): Int = {
		def loop(a: Int, acc: Int): Int = {
			println("a=" + a + " acc=" + acc)

			if (a > b) acc
			else loop(a + 1, f(a) + acc)
		}
		
		loop(a, 0)
	}                                         //> sum: (f: Int => Int)(a: Int, b: Int)Int

	sum(x => x)(1, 5)                         //> a=1 acc=0
                                                  //| a=2 acc=1
                                                  //| a=3 acc=3
                                                  //| a=4 acc=6
                                                  //| a=5 acc=10
                                                  //| a=6 acc=15
                                                  //| res0: Int = 15

	def gcd(a: Int, b: Int): Int = {
		if (b == 0) a
		else gcd(b, a % b)
	}                                         //> gcd: (a: Int, b: Int)Int

	gcd(100, 7)                               //> res1: Int = 1
	
}