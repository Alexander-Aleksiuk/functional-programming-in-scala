package common

import scala.annotation.tailrec

object wsCoins {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(205); 
	def countChange(money: Int, coins: List[Int]): Int = {
		if (coins.isEmpty) 0
		else calculateChange(money, coins.head, coins.tail, 0)
	};System.out.println("""countChange: (money: Int, coins: List[Int])Int""");$skip(168); 

	def countChangeInternal(money: Int, coins: List[Int], count: Int): Int = {
		if (coins.isEmpty) count
		else calculateChange(money, coins.head, coins.tail, count)
	};System.out.println("""countChangeInternal: (money: Int, coins: List[Int], count: Int)Int""");$skip(250); 

	def calculateChange(money: Int, coin: Int, coins: List[Int], count: Int): Int = {
		val newCount = calculate(money, coin, coins, money / coin, count)

		if (coins.isEmpty) newCount
		else calculateChange(money, coins.head, coins.tail, newCount)
	};System.out.println("""calculateChange: (money: Int, coin: Int, coins: List[Int], count: Int)Int""");$skip(502); 

	def calculate(money: Int, coin: Int, coins: List[Int], index: Int, count: Int): Int = {
		val matched = money == index * coin
		val remain = money - index * coin

		if (index == 0) count
		else {
			println("calcualte(), idx=" + index + " money=" + money + " coin=" + coin + "(" + index * coin + ") rem=" + remain + " matched=" + matched)

			val newCount =
				if (matched) count + 1
				else countChangeInternal(remain, coins, count)
		
			calculate(money, coin, coins, index - 1, newCount)
		}
	};System.out.println("""calculate: (money: Int, coin: Int, coins: List[Int], index: Int, count: Int)Int""");$skip(30); val res$0 = 

	countChange(4, List(1, 2));System.out.println("""res0: Int = """ + $show(res$0));$skip(34); val res$1 = 


	countChange(5, List(1, 2, 3));System.out.println("""res1: Int = """ + $show(res$1))}
}
