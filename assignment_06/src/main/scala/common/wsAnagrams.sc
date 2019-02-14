package common

import forcomp._

object wsAnagrams {
	type Occurrences = List[(Char, Int)]
	val str = "abc"                           //> str  : String = abc
	val occ = Anagrams.wordOccurrences(str)   //> occ  : forcomp.Anagrams.Occurrences = List((a,1), (b,1), (c,1))



	def test(list: List[Char]): List[List[Char]] = {
		val tt = list.reduceLeft((x, y) => {
				println("x=" + x + " y=" + y)
				x
		})

		println("tt=" + tt)

		List()
	}                                         //> test: (list: List[Char])List[List[Char]]

	test(str.toList)                          //> x=a y=b
                                                  //| x=a y=c
                                                  //| tt=a
                                                  //| res0: List[List[Char]] = List()


	// Get list of combinations
	def getCombinations(list: List[Char]): List[List[Char]] = {
		def combine(hc: Char, chars: List[Char]): List[List[Char]] = {
			val rv = for {
				cc <- chars
				if (cc > hc)
			} yield((cc, List(hc, cc)))

			List(List(hc)) ::: List(List(hc) ::: rv.map(x => x._1)) ::: rv.map(x => x._2)
		}
	
		val res = for {
			lc <- list
		} yield(combine(lc, list)).distinct

		res.flatMap(f => f.seq)
	}                                         //> getCombinations: (list: List[Char])List[List[Char]]

	def combine(cmbs: List[List[Char]], tmpl: Map[Char,List[(Char, Int)]] ): List[Occurrences] = {
		def combineInt(cmbs: List[Char]): List[Occurrences] = {
			val tt = for {
				ch <- cmbs
				mp <- tmpl.getOrElse(ch, List())
			} yield(mp)

			println("cmbs=" + cmbs + " tt=" + tt)
			

			tt.asInstanceOf[List[Occurrences]]
		}

		val tt = for {
			cmb <- cmbs
		} yield(combineInt(cmb))

		List()
	}                                         //> combine: (cmbs: List[List[Char]], tmpl: Map[Char,List[(Char, Int)]])List[co
                                                  //| mmon.wsAnagrams.Occurrences]

	val cmbList = getCombinations(occ.map(x => x._1))
                                                  //> cmbList  : List[List[Char]] = List(List(a), List(a, b, c), List(a, b), List
                                                  //| (a, c), List(b), List(b, c), List(c))

	val map = (for {
		lst <- occ
		idx <- 1 to lst._2
	} yield((lst._1, idx))).groupBy(f => f._1)//> map  : scala.collection.immutable.Map[Char,List[(Char, Int)]] = Map(b -> Li
                                                  //| st((b,1)), a -> List((a,1)), c -> List((c,1)))

	combine(cmbList, map)                     //> cmbs=List(a) tt=List((a,1))
                                                  //| cmbs=List(a, b, c) tt=List((a,1), (b,1), (c,1))
                                                  //| cmbs=List(a, b) tt=List((a,1), (b,1))
                                                  //| cmbs=List(a, c) tt=List((a,1), (c,1))
                                                  //| cmbs=List(b) tt=List((b,1))
                                                  //| cmbs=List(b, c) tt=List((b,1), (c,1))
                                                  //| cmbs=List(c) tt=List((c,1))
                                                  //| res1: List[common.wsAnagrams.Occurrences] = List()


}
	/*
		List()
		List(('a', 1)),
		List(('a', 1), ('b', 1)),
		List(('a', 1), ('b', 2)),

		List(('a', 2)),
		List(('a', 2), ('b', 1)),
		List(('a', 2), ('b', 2))

		List(('b', 1)),
		List(('b', 2)),

		------------------
		List((a,2), (b,2), (c,2))

		List(),
		List(('a', 1)),
		List(('a', 2)),
		List(('b', 1)),
		List(('b', 2)),
		List(('c', 1)),
		List(('c', 2)),

		List(('a', 1), ('b', 1)),
		List(('a', 1), ('b', 2)),
		List(('a', 1), ('c', 1)),
		List(('a', 1), ('c', 2)),

		List(('a', 2), ('b', 1)),
		List(('a', 2), ('b', 2)),
		List(('a', 2), ('c', 1)),
		List(('a', 2), ('c', 2)),

		List(('b', 1), ('c', 1)),
		List(('b', 1), ('c', 2)),

		List(('b', 2), ('c', 1)),
		List(('b', 2), ('c', 2)),

		List(('a', 1), ('b', 1), ('c', 1)),
		List(('a', 1), ('b', 1), ('c', 2)),

		List(('a', 1), ('b', 2), ('c', 1)),
		List(('a', 1), ('b', 2), ('c', 2)),

		List(('a', 2), ('b', 1), ('c', 1)),
		List(('a', 2), ('b', 1), ('c', 2)),

		List(('a', 2), ('b', 2), ('c', 1)),
		List(('a', 2), ('b', 2), ('c', 2)))

		---

		List(),
		List((a,1)),
		List((a,2)),
		List((b,1)),
		List((b,2)),
		List((c,1)),
		List((c,2)),

		List((a,1), (b,1)),
		List((a,1), (b,2)),
		List((a,1), (c,1)),
		List((a,1), (c,2)),

		List((a,2), (b,1)),
		List((a,2), (b,2)),
		List((a,2), (c,1)),
		List((a,2), (c,2)),
		
		List((b,1), (c,1)),
		List((b,1), (c,2)),
		List((b,2), (c,1)),
		List((b,2), (c,2)),
*/