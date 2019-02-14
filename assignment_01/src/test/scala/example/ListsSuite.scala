package example

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

/**
 * This class implements a ScalaTest test suite for the methods in object
 * `Lists` that need to be implemented as part of this assignment. A test
 * suite is simply a collection of individual tests for some specific
 * component of a program.
 *
 * A test suite is created by defining a class which extends the type
 * `org.scalatest.FunSuite`. When running ScalaTest, it will automatically
 * find this class and execute all of its tests.
 *
 * Adding the `@RunWith` annotation enables the test suite to be executed
 * inside eclipse using the built-in JUnit test runner.
 *
 * You have two options for running this test suite:
 * 
 * - Start the sbt console and run the "test" command
 * - Right-click this file in eclipse and chose "Run As" - "JUnit Test"
 */
@RunWith(classOf[JUnitRunner])
class ListsSuite extends FunSuite {
	import Lists._

	/**
	 * Test for sum method
	 */

	test("sum of a few numbers") {
		assert(sum(List(1, 2, 0)) === 3)
	}

	test("sum of a negative numbers") {
		assert(sum(List(-10, -4, 20)) === 6)
	}

	test("sum of a negative and zero numbers") {
		assert(sum(List(-10, 0, -5, 20, 50, 0)) === 55)
	}

	test("sum of empty list") {
		assert(sum(List()) === 0)
	}

	test("sum of repeated elements") {
		assert(sum(List(2, 2, 4, 4)) === 12)
	}

	/**
	 * Test for max method
	 */

	test("max of a few numbers") {
		assert(max(List(3, 7, 2)) === 7)
	}

	test("max of a negative numbers") {
		assert(max(List(-15, -5, -3, -100, -50)) === -3)
	}

	test("max of a negative and zero numbers") {
		assert(max(List(0, 10, -10)) === 10)
	}

	test("max of empty list") {
		intercept[NoSuchElementException] {
			assert(max(List()) === 0)
		}
	}

	test("max of  repeated elements") {
		assert(max(List(5, 5, 10, 10, -10)) === 10)
	}
}