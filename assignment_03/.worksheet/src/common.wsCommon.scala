package common

object wsCommon {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(231); 
	def sum(f: Int => Int)(a: Int, b: Int): Int = {
		def loop(a: Int, acc: Int): Int = {
			println("a=" + a + " acc=" + acc)

			if (a > b) acc
			else loop(a + 1, f(a) + acc)
		}
		
		loop(a, 0)
	};System.out.println("""sum: (f: Int => Int)(a: Int, b: Int)Int""");$skip(20); val res$0 = 

	sum(x => x)(1, 5);System.out.println("""res0: Int = """ + $show(res$0));$skip(75); 

	def gcd(a: Int, b: Int): Int = {
		if (b == 0) a
		else gcd(b, a % b)
	};System.out.println("""gcd: (a: Int, b: Int)Int""");$skip(14); val res$1 = 

	gcd(100, 7);System.out.println("""res1: Int = """ + $show(res$1))}
	
}
