package recfun
import common._
import java.util.Stack

object Main {
	def main(args: Array[String]) {
		println("Pascal's Triangle")
		for (row <- 0 to 10) {
			for (col <- 0 to row)
				print(pascal(col, row) + " ")
				println()
		}
	}

	/**
	 * Exercise 1
	 */
	def pascal(c : Int, r : Int) : Int = {
		if (c == 0 || c == r) 1 else pascal(c - 1, r - 1) + pascal(c, r - 1)
	}

	/**
	 * Exercise 2
	 */
	def balance(chars : List[Char]) : Boolean = {
		def checkBalance(buffer: Stack[Char], item : Char, list : List[Char]) : Boolean = {
			if ('('.equals(item) || ')'.equals(item)) {
				if (')'.equals(item) && !buffer.isEmpty() && '('.equals(buffer.peek())) buffer.pop() else buffer.push(item)
			}

			if (list.nonEmpty) checkBalance(buffer, list.head, list.tail)

			buffer.isEmpty
		}

		checkBalance(new Stack[Char], chars.head, chars.tail)
	}

	/**
	 * Exercise 3
	 */
	def countChange(money: Int, coins: List[Int]): Int = {
		def countChangeInternal(money: Int, coins: List[Int], count: Int): Int = {
			if (coins.isEmpty) count
			else calculateChange(money, coins.head, coins.tail, count)
		}

		def calculateChange(money: Int, coin: Int, coins: List[Int], count: Int): Int = {
			val newCount = calculate(money, coin, coins, money / coin, count)

			if (coins.isEmpty) newCount
			else calculateChange(money, coins.head, coins.tail, newCount)
		}

		def calculate(money: Int, coin: Int, coins: List[Int], index: Int, count: Int): Int = {
			if (index == 0) count
			else {
				val newCount =
					if (money == index * coin) count + 1
					else countChangeInternal(money - index * coin, coins, count)
		
				calculate(money, coin, coins, index - 1, newCount)
			}
		}

		if (coins.isEmpty) 0
		else calculateChange(money, coins.head, coins.tail, 0)
	}
}
