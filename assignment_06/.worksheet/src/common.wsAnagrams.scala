package common

import forcomp._

object wsAnagrams {
	type Occurrences = List[(Char, Int)];import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(108); 
	val str = "abc";System.out.println("""str  : String = """ + $show(str ));$skip(41); 
	val occ = Anagrams.wordOccurrences(str);System.out.println("""occ  : forcomp.Anagrams.Occurrences = """ + $show(occ ));$skip(173); 



	def test(list: List[Char]): List[List[Char]] = {
		val tt = list.reduceLeft((x, y) => {
				println("x=" + x + " y=" + y)
				x
		})

		println("tt=" + tt)

		List()
	};System.out.println("""test: (list: List[Char])List[List[Char]]""");$skip(19); val res$0 = 

	test(str.toList);System.out.println("""res0: List[List[Char]] = """ + $show(res$0));$skip(428); 


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
	};System.out.println("""getCombinations: (list: List[Char])List[List[Char]]""");$skip(402); 

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
	};System.out.println("""combine: (cmbs: List[List[Char]], tmpl: Map[Char,List[(Char, Int)]])List[common.wsAnagrams.Occurrences]""");$skip(52); 

	val cmbList = getCombinations(occ.map(x => x._1));System.out.println("""cmbList  : List[List[Char]] = """ + $show(cmbList ));$skip(97); 

	val map = (for {
		lst <- occ
		idx <- 1 to lst._2
	} yield((lst._1, idx))).groupBy(f => f._1);System.out.println("""map  : scala.collection.immutable.Map[Char,List[(Char, Int)]] = """ + $show(map ));$skip(24); val res$1 = 

	combine(cmbList, map);System.out.println("""res1: List[common.wsAnagrams.Occurrences] = """ + $show(res$1))}


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
