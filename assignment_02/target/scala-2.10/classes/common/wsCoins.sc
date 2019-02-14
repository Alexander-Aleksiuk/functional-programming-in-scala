package common

import scala.annotation.tailrec

object wsCoins {
	def countChange(money: Int, coins: List[Int]): Int = {
		if (coins.isEmpty) 0
		else calculateChange(money, coins.head, coins.tail, 0)
	}                                         //> countChange: (money: Int, coins: List[Int])Int

	def countChangeInternal(money: Int, coins: List[Int], count: Int): Int = {
		if (coins.isEmpty) count
		else calculateChange(money, coins.head, coins.tail, count)
	}                                         //> countChangeInternal: (money: Int, coins: List[Int], count: Int)Int

	def calculateChange(money: Int, coin: Int, coins: List[Int], count: Int): Int = {
		val newCount = calculate(money, coin, coins, money / coin, count)

		if (coins.isEmpty) newCount
		else calculateChange(money, coins.head, coins.tail, newCount)
	}                                         //> calculateChange: (money: Int, coin: Int, coins: List[Int], count: Int)Int

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
	}                                         //> calculate: (money: Int, coin: Int, coins: List[Int], index: Int, count: Int
                                                  //| )Int

	countChange(4, List(1, 2))                //> calcualte(), idx=4 money=4 coin=1(4) rem=0 matched=true
                                                  //| calcualte(), idx=3 money=4 coin=1(3) rem=1 matched=false
                                                  //| calcualte(), idx=2 money=4 coin=1(2) rem=2 matched=false
                                                  //| calcualte(), idx=1 money=2 coin=2(2) rem=0 matched=true
                                                  //| calcualte(), idx=1 money=4 coin=1(1) rem=3 matched=false
                                                  //| calcualte(), idx=1 money=3 coin=2(2) rem=1 matched=false
                                                  //| calcualte(), idx=2 money=4 coin=2(4) rem=0 matched=true
                                                  //| calcualte(), idx=1 money=4 coin=2(2) rem=2 matched=false
                                                  //| res0: Int = 3


	countChange(5, List(1, 2, 3))             //> calcualte(), idx=5 money=5 coin=1(5) rem=0 matched=true
                                                  //| calcualte(), idx=4 money=5 coin=1(4) rem=1 matched=false
                                                  //| calcualte(), idx=3 money=5 coin=1(3) rem=2 matched=false
                                                  //| calcualte(), idx=1 money=2 coin=2(2) rem=0 matched=true
                                                  //| calcualte(), idx=2 money=5 coin=1(2) rem=3 matched=false
                                                  //| calcualte(), idx=1 money=3 coin=2(2) rem=1 matched=false
                                                  //| calcualte(), idx=1 money=3 coin=3(3) rem=0 matched=true
                                                  //| calcualte(), idx=1 money=5 coin=1(1) rem=4 matched=false
                                                  //| calcualte(), idx=2 money=4 coin=2(4) rem=0 matched=true
                                                  //| calcualte(), idx=1 money=4 coin=2(2) rem=2 matched=false
                                                  //| calcualte(), idx=1 money=4 coin=3(3) rem=1 matched=false
                                                  //| calcualte(), idx=2 money=5 coin=2(4) rem=1 matched=false
                                                  //| calcualte(), idx=1 money=5 coin=2(2) rem=3 matched=false
                                                  //| calcualte(), idx=1 money=3 coin=3(3) rem=0 matched=true
                                                  //| calcualte(), idx=1 money=5 coin=3(3) rem=2 matched=false
                                                  //| res1: Int = 5
}