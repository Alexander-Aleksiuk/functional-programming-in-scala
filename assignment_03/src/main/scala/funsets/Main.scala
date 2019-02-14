package funsets

object Main extends App {
	import FunSets._

	{ // Union
		val s1 = singletonSet(1)
		val s2 = singletonSet(2)

		val s = union(s1, s2)

		print("Union result:")
		printSet(s)

		assert(contains(s, 1), "Union 1")
		assert(contains(s, 2), "Union 2")
		assert(!contains(s, 3), "Union 3")
	}

	{ // Intersection
		val s1 = singletonSet(1)
		val s2 = singletonSet(2)
		val s3 = singletonSet(3)

		val a1 = singletonSet(1)
		val a2 = singletonSet(2)
		val a3 = singletonSet(4)

		val un1 = union(union(s1, s2), s3)
		val un2 = union(union(a1, a2), a3)

		val in = intersect(un1, un2)

		print("Intersection result:")
		printSet(in)

		assert(contains(in, 1), "Intersection does not contain 1")
		assert(contains(in, 2), "Intersection does not contain 2")
		assert(!contains(in, 3), "Intersection contains 3")
		assert(!contains(in, 4), "Intersection contains 4")
	}

	{ // Diff
		val s1 = singletonSet(1)
		val s2 = singletonSet(2)
		val s3 = singletonSet(3)

		val a1 = singletonSet(1)
		val a2 = singletonSet(2)
		val a3 = singletonSet(4)

		val un1 = union(union(s1, s2), s3)
		val un2 = union(union(a1, a2), a3)

		val in = diff(un1, un2)

		print("Diff result:")
		printSet(in)

		assert(!contains(in, 1), "Intersection contains 1")
		assert(!contains(in, 2), "Intersection contains 2")
		assert(contains(in, 3), "Intersection does not contain 3")
	}

	{ // Filter
		val s1 = singletonSet(1)
		val s2 = singletonSet(2)
		val s3 = singletonSet(3)
		val s4 = singletonSet(4)
		val s5 = singletonSet(5)

		val un1 = union(union(union(union(s1, s2), s3), s4), s5)

		val in = filter(un1, (value: Int) => value >= 2 && value <=4)

		print("Filter result:")
		printSet(in)

		assert(!contains(in, 1), "Filter contains 1")
		assert(contains(in, 2), "Filter does not contain 2")
		assert(contains(in, 3), "Filter does not contain 3")
		assert(contains(in, 4), "Filter does not contain 4")
		assert(!contains(in, 5), "Filter contains 5")
	}

	{ // ForAll
		val s1 = singletonSet(1)
		val s2 = singletonSet(2)
		val s3 = singletonSet(3)
		val s4 = singletonSet(4)
		val s5 = singletonSet(5)

		val un1 = union(union(union(union(s1, s2), s3), s4), s5)

		val isTrueForAll = forall(un1, (value: Int) => value > 0)
		println("isTrueForAll=" + isTrueForAll)
	}

	{ // exists
		val s1 = singletonSet(1)
		val s2 = singletonSet(2)
		val s3 = singletonSet(3)
		val s4 = singletonSet(4)
		val s5 = singletonSet(5)

		val un1 = union(union(union(union(s1, s2), s3), s4), s5)

		val isTrueAtLeastForOne = exists(un1, (value: Int) => value == 3)
		println("isTrueAtLeastForOne=" + isTrueAtLeastForOne)
	}

	{ // map
		val s1 = singletonSet(1)
		val s2 = singletonSet(2)
		val s3 = singletonSet(3)
		val s4 = singletonSet(4)
		val s5 = singletonSet(5)

		val un1 = union(union(union(union(s1, s2), s3), s4), s5)
		printSet(un1)

		val res = map(un1, (value: Int) => value * 2)
		printSet(res)
	}
	
	{
		val s0 = singletonSet(0)
		val s1 = singletonSet(1)
		val s2 = singletonSet(2)
		val s3 = singletonSet(3)
		val s4 = singletonSet(4)
		val s5 = singletonSet(5)
		val s7 = singletonSet(7)
		val s1000 = singletonSet(1000)
		val n1000 = singletonSet(-1000)

		// {1,3,4,5,7,1000} and {1,2,3,4}
		val un1 = union(union(union(union(union(s1, s3), s4), s5), s7), s1000)
		val un2 = union(union(union(s1, s2), s3), s4)

		val dif1 = diff(un1, un2)

		print("Diff1 result:")
		printSet(dif1)

		// {1,2,3,4} and {-1000,0}
		val un3 = union(union(union(s1, s2), s3), s4)
		val un4 = union(s0, n1000)

		val dif2 = diff(un3, un4)

		print("Diff2 result:")
		printSet(dif2)
	}
}