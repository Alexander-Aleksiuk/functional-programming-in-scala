package funsets

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

/**
 * This class is a test suite for the methods in object FunSets. To run
 * the test suite, you can either:
 *  - run the "test" command in the SBT console
 *  - right-click the file in eclipse and chose "Run As" - "JUnit Test"
 */
@RunWith(classOf[JUnitRunner])
class FunSetSuite extends FunSuite {


  /**
   * Link to the scaladoc - very clear and detailed tutorial of FunSuite
   *
   * http://doc.scalatest.org/1.9.1/index.html#org.scalatest.FunSuite
   *
   * Operators
   *  - test
   *  - ignore
   *  - pending
   */

  /**
   * Tests are written using the "test" operator and the "assert" method.
   */
  test("string take") {
    val message = "hello, world"
    assert(message.take(5) == "hello")
  }

  /**
   * For ScalaTest tests, there exists a special equality operator "===" that
   * can be used inside "assert". If the assertion fails, the two values will
   * be printed in the error message. Otherwise, when using "==", the test
   * error message will only say "assertion failed", without showing the values.
   *
   * Try it out! Change the values so that the assertion fails, and look at the
   * error message.
   */
  test("adding ints") {
    assert(1 + 2 === 3)
  }

  
  import FunSets._

  test("contains is implemented") {
    assert(contains(x => true, 100))
  }
  
  /**
   * When writing tests, one would often like to re-use certain values for multiple
   * tests. For instance, we would like to create an Int-set and have multiple test
   * about it.
   * 
   * Instead of copy-pasting the code for creating the set into every test, we can
   * store it in the test class using a val:
   * 
   *   val s1 = singletonSet(1)
   * 
   * However, what happens if the method "singletonSet" has a bug and crashes? Then
   * the test methods are not even executed, because creating an instance of the
   * test class fails!
   * 
   * Therefore, we put the shared values into a separate trait (traits are like
   * abstract classes), and create an instance inside each test method.
   * 
   */

	trait TestSets {
		val s1 = singletonSet(1)
		val s2 = singletonSet(2)
		val s3 = singletonSet(3)
		val s4 = singletonSet(4)
		val s5 = singletonSet(5)

		val a1 = singletonSet(1)
		val a2 = singletonSet(2)
		val a3 = singletonSet(4)
	}

  /**
   * This test is currently disabled (by using "ignore") because the method
   * "singletonSet" is not yet implemented and the test would fail.
   * 
   * Once you finish your implementation of "singletonSet", exchange the
   * function "ignore" by "test".
   */
  test("singletonSet(1) contains 1") {
    
    /**
     * We create a new instance of the "TestSets" trait, this gives us access
     * to the values "s1" to "s3". 
     */
    new TestSets {
      /**
       * The string argument of "assert" is a message that is printed in case
       * the test fails. This helps identifying which assertion failed.
       */
      assert(contains(s1, 1), "Singleton")
    }
  }

  test("union contains all elements") {
    new TestSets {
      val s = union(s1, s2)
      assert(contains(s, 1), "Union 1")
      assert(contains(s, 2), "Union 2")
      assert(!contains(s, 3), "Union 3")
    }
  }

	test("intersection test") {
		new TestSets {
			val un1 = union(union(s1, s2), s3)
			val un2 = union(union(a1, a2), a3)

			val in = intersect(un1, un2)
			
			assert(contains(in, 1), "Intersection does not contain 1")
			assert(contains(in, 2), "Intersection does not contain 2")
			assert(!contains(in, 3), "Intersection contains 3")
			assert(!contains(in, 4), "Intersection contains 4")
		}
	}

	test("difference test") {
		new TestSets {
			val un1 = union(union(s1, s2), s3)
			val un2 = union(union(a1, a2), a3)

			val in = diff(un1, un2)
			
			assert(!contains(in, 1), "Difference contains 1")
			assert(!contains(in, 2), "Difference  contains 2")
			assert(contains(in, 3), "Difference does not contain 3")
		}
	}

	test("filter test") {
		new TestSets {
			val un1 = union(union(union(union(s1, s2), s3), s4), s5)

			val in = filter(un1, (value: Int) => value >= 2 && value <=4)
			
			assert(!contains(in, 1), "Filter contains 1")
			assert(contains(in, 2), "Filter does not contain 2")
			assert(contains(in, 3), "Filter does not contain 3")
			assert(contains(in, 4), "Filter does not contain 4")
			assert(!contains(in, 5), "Filter contains 5")
		}
	}

	test("forAll test") {
		new TestSets {
			val un1 = union(union(union(union(s1, s2), s3), s4), s5)

			val in = filter(un1, (value: Int) => value >= 2 && value <=4)

			assert(forall(un1, (value: Int) => value > 0), "All bigger than 0")
			assert(!forall(un1, (value: Int) => value % 2 == 0), "Not all modulo to 2")
		}
	}

	test("exists test") {
		new TestSets {
			val un1 = union(union(union(union(s1, s2), s3), s4), s5)

			assert(exists(un1, (value: Int) => value == 3), "Element 3 does not exist")
			assert(exists(un1, (value: Int) => value * 2 == 4), "Element 2*2 does not exist")
			assert(!exists(un1, (value: Int) => value < 0), "Negaive elements exists")
			assert(!exists(un1, (value: Int) => value == 10), "Element 10 exists")
		}
	}

	test("map test") {
		new TestSets {
			val un1 = union(union(union(union(s1, s2), s3), s4), s5)

			val res1 = map(un1, (value: Int) => value + 2)
			val res2 = map(un1, (value: Int) => value * 2)

			assert(contains(res1, 6), "Element 6 does not exist")
			assert(!contains(res1, 1), "Element 1 exists")

			assert(contains(res2, 10), "Element 10 does not exist")
			assert(!contains(res2, 5), "Element 5 exists")
		}
	}
}