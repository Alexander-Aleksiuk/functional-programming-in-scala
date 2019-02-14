package common

object wsCommon {
	println("Welcome to the Scala worksheet") //> Welcome to the Scala worksheet
	val pair = ("test", 1)                    //> pair  : (String, Int) = (test,1)
	val (name, index) = pair                  //> name  : String = test
                                                  //| index  : Int = 1

	println("name=" + name + " index=" + index)
                                                  //> name=test index=1

	val listInt = List(2, 5, 6, 3, 1)         //> listInt  : List[Int] = List(2, 5, 6, 3, 1)
	val listString = List("q", "e", "h", "z", "r")
                                                  //> listString  : List[String] = List(q, e, h, z, r)

	def customSort[T](list : List[T])(implicit ord : Ordering[T]) : List[T] = {
		list.sorted(ord)
	}                                         //> customSort: [T](list: List[T])(implicit ord: Ordering[T])List[T]
 
	customSort(listInt)                       //> res0: List[Int] = List(1, 2, 3, 5, 6)
	customSort(listString)                    //> res1: List[String] = List(e, h, q, r, z)

	//---------------------------------
	val values = List(6, 2, 3, 4, 5)          //> values  : List[Int] = List(6, 2, 3, 4, 5)
	values map (x => x * x)                   //> res2: List[Int] = List(36, 4, 9, 16, 25)
	values filter (x => x > 2)                //> res3: List[Int] = List(6, 3, 4, 5)
	values filterNot (x => x > 2)             //> res4: List[Int] = List(2)
	values partition (x => x > 2)             //> res5: (List[Int], List[Int]) = (List(6, 3, 4, 5),List(2))
	values takeWhile (x => x > 2)             //> res6: List[Int] = List(6)
	values dropWhile (x => x > 2)             //> res7: List[Int] = List(2, 3, 4, 5)
	values span (x => x > 2)                  //> res8: (List[Int], List[Int]) = (List(6),List(2, 3, 4, 5))

	def pack[T](xs: List[T]): List[List[T]] = xs match {
		case Nil => Nil
		case x :: xs1 =>
			val (first, second) = xs span (y => x == y)
			first :: pack(second)
	}                                         //> pack: [T](xs: List[T])List[List[T]]

	def encode[T](xs: List[T]): List[(T, Int)] = {
		pack(xs) map (x => (x.head, x.size))
	}                                         //> encode: [T](xs: List[T])List[(T, Int)]

	encode(List("a", "a", "a", "b", "c", "c", "a"))
                                                  //> res9: List[(String, Int)] = List((a,3), (b,1), (c,2), (a,1))
                                                  
	val abc = List("A", "B", "C")             //> abc  : List[String] = List(A, B, C)

	def add(res: String, x: String) = {
		println(s"op: $res + $x = ${res + x}")
		res + x
	}                                         //> add: (res: String, x: String)String

	abc.reduceLeft(add)                       //> op: A + B = AB
                                                  //| op: AB + C = ABC
                                                  //| res10: String = ABC
	abc.foldLeft("z")(add)                    //> op: z + A = zA
                                                  //| op: zA + B = zAB
                                                  //| op: zAB + C = zABC
                                                  //| res11: String = zABC
	abc.scanLeft("z")(add)                    //> op: z + A = zA
                                                  //| op: zA + B = zAB
                                                  //| op: zAB + C = zABC
                                                  //| res12: List[String] = List(z, zA, zAB, zABC)

	abc.reduceRight(add)                      //> op: B + C = BC
                                                  //| op: A + BC = ABC
                                                  //| res13: String = ABC
	abc.foldRight("z")(add)                   //> op: C + z = Cz
                                                  //| op: B + Cz = BCz
                                                  //| op: A + BCz = ABCz
                                                  //| res14: String = ABCz
	abc.scanRight("z")(add)                   //> op: C + z = Cz
                                                  //| op: B + Cz = BCz
                                                  //| op: A + BCz = ABCz
                                                  //| res15: List[String] = List(ABCz, BCz, Cz, z)
}