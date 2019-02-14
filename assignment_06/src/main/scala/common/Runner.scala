package common

import forcomp.Anagrams._

object Runner {
	def main(args : Array[String]) : Unit = {
		val setMarried = wordAnagrams("married").toSet // === Set("married", "admirer")
		val setPlayer = wordAnagrams("player").toSet //=== Set("parley", "pearly", "player", "replay")

		println("setMarried=" + setMarried)
		println("setPlayer=" + setPlayer)

		val comb = combinations(List(('a', 2), ('b', 2)))
		println("comb=" + comb)
	}
}