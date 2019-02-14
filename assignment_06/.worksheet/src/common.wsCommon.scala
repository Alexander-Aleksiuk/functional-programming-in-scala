package common

object wsCommon {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(77); 
	println("Welcome to the Scala worksheet");$skip(24); 
	val pair = ("test", 1);System.out.println("""pair  : (String, Int) = """ + $show(pair ));$skip(26); 
	val (name, index) = pair;System.out.println("""name  : String = """ + $show(name ));System.out.println("""index  : Int = """ + $show(index ));$skip(47); 

	println("name=" + name + " index=" + index);$skip(37); 

	val listInt = List(2, 5, 6, 3, 1);System.out.println("""listInt  : List[Int] = """ + $show(listInt ));$skip(48); 
	val listString = List("q", "e", "h", "z", "r");System.out.println("""listString  : List[String] = """ + $show(listString ));$skip(101); 

	def customSort[T](list : List[T])(implicit ord : Ordering[T]) : List[T] = {
		list.sorted(ord)
	};System.out.println("""customSort: [T](list: List[T])(implicit ord: Ordering[T])List[T]""");$skip(24); val res$0 = 
 
	customSort(listInt);System.out.println("""res0: List[Int] = """ + $show(res$0));$skip(24); val res$1 = 
	customSort(listString);System.out.println("""res1: List[String] = """ + $show(res$1));$skip(73); 

	//---------------------------------
	val values = List(6, 2, 3, 4, 5);System.out.println("""values  : List[Int] = """ + $show(values ));$skip(25); val res$2 = 
	values map (x => x * x);System.out.println("""res2: List[Int] = """ + $show(res$2));$skip(28); val res$3 = 
	values filter (x => x > 2);System.out.println("""res3: List[Int] = """ + $show(res$3));$skip(31); val res$4 = 
	values filterNot (x => x > 2);System.out.println("""res4: List[Int] = """ + $show(res$4));$skip(31); val res$5 = 
	values partition (x => x > 2);System.out.println("""res5: (List[Int], List[Int]) = """ + $show(res$5));$skip(31); val res$6 = 
	values takeWhile (x => x > 2);System.out.println("""res6: List[Int] = """ + $show(res$6));$skip(31); val res$7 = 
	values dropWhile (x => x > 2);System.out.println("""res7: List[Int] = """ + $show(res$7));$skip(26); val res$8 = 
	values span (x => x > 2);System.out.println("""res8: (List[Int], List[Int]) = """ + $show(res$8));$skip(167); 

	def pack[T](xs: List[T]): List[List[T]] = xs match {
		case Nil => Nil
		case x :: xs1 =>
			val (first, second) = xs span (y => x == y)
			first :: pack(second)
	};System.out.println("""pack: [T](xs: List[T])List[List[T]]""");$skip(91); 

	def encode[T](xs: List[T]): List[(T, Int)] = {
		pack(xs) map (x => (x.head, x.size))
	};System.out.println("""encode: [T](xs: List[T])List[(T, Int)]""");$skip(50); val res$9 = 

	encode(List("a", "a", "a", "b", "c", "c", "a"));System.out.println("""res9: List[(String, Int)] = """ + $show(res$9));$skip(82); 
                                                  
	val abc = List("A", "B", "C");System.out.println("""abc  : List[String] = """ + $show(abc ));$skip(92); 

	def add(res: String, x: String) = {
		println(s"op: $res + $x = ${res + x}")
		res + x
	};System.out.println("""add: (res: String, x: String)String""");$skip(22); val res$10 = 

	abc.reduceLeft(add);System.out.println("""res10: String = """ + $show(res$10));$skip(24); val res$11 = 
	abc.foldLeft("z")(add);System.out.println("""res11: String = """ + $show(res$11));$skip(24); val res$12 = 
	abc.scanLeft("z")(add);System.out.println("""res12: List[String] = """ + $show(res$12));$skip(23); val res$13 = 

	abc.reduceRight(add);System.out.println("""res13: String = """ + $show(res$13));$skip(25); val res$14 = 
	abc.foldRight("z")(add);System.out.println("""res14: String = """ + $show(res$14));$skip(25); val res$15 = 
	abc.scanRight("z")(add);System.out.println("""res15: List[String] = """ + $show(res$15))}
}
