package common

object wsAnagram {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(56); 
	val message = "abcd";System.out.println("""message  : String = """ + $show(message ));$skip(69); 

	val grouped = (message.toList).groupBy((element: Char) => element);System.out.println("""grouped  : scala.collection.immutable.Map[Char,List[Char]] = """ + $show(grouped ));$skip(126); 

	def process(groupedMap: Map[Char,List[Char]]) : List[(Char, Int)] = {
		groupedMap map (x => (x._1, x._2.length)) toList
	};System.out.println("""process: (groupedMap: Map[Char,List[Char]])List[(Char, Int)]""");$skip(19); val res$0 = 

	process(grouped);System.out.println("""res0: List[(Char, Int)] = """ + $show(res$0));$skip(36); val res$1 = 

	Anagrams.wordOccurrences(message);System.out.println("""res1: <error> = """ + $show(res$1));$skip(41); val res$2 = 

	sentenceOccurrences(List("abcd", "e"));System.out.println("""res2: <error> = """ + $show(res$2));$skip(65); val res$3 = 

s	// === List(('a', 1), ('b', 1), ('c', 1), ('d', 1), ('e', 1));System.out.println("""res3: <error> = """ + $show(res$3))}

}
