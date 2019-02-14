package patmat

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import patmat.Huffman._

@RunWith(classOf[JUnitRunner])
class HuffmanSuite extends FunSuite {
	trait TestTrees {
		val t1 = Fork(Leaf('a', 2), Leaf('b', 3), List('a', 'b'), 5)
		val t2 = Fork(Fork(Leaf('a', 2), Leaf('b', 3), List('a', 'b'), 5), Leaf('d', 4), List('a', 'b', 'd'), 9)
	}

	test("weight of a larger tree") {
		new TestTrees {
			assert(weight(t1) === 5)
		}
	}

	test("chars of a larger tree") {
		new TestTrees {
			assert(chars(t2) === List('a', 'b', 'd'))
		}
	}

	test("string2chars(\"hello, world\")") {
		assert(string2Chars("hello, world") === List('h', 'e', 'l', 'l', 'o', ',', ' ', 'w', 'o', 'r', 'l', 'd'))
	}

	test("makeOrderedLeafList for some frequency table") {
		assert(makeOrderedLeafList(List(('t', 2), ('e', 1), ('x', 3))) === List(Leaf('e', 1), Leaf('t', 2), Leaf('x', 3)))
	}

	test("combine of some leaf list") {
		val leaflist = List(Leaf('e', 1), Leaf('t', 2), Leaf('x', 4))
		assert(combine(leaflist) === List(Fork(Leaf('e', 1), Leaf('t', 2), List('e', 't'), 3), Leaf('x', 4)))
	}

	test("until some trees") {
		val leaflist = List(Leaf('e', 1), Leaf('t', 2), Leaf('x', 4))
		assert(until(Huffman.singleton(leaflist), leaflist)(leaflist) === List(Fork(Fork(Leaf('e', 1), Leaf('t', 2), List('e', 't'), 3), Leaf('x', 4), List('e', 't', 'x'), 7)))
	}

	test("createCodeTree for word 'test'") {
		val message = "test"
		assert(Huffman.createCodeTree(Huffman.string2Chars(message)) === Fork(Fork(Leaf('s', 1), Leaf('e', 1), List('s', 'e'), 2), Leaf('t', 2), List('s', 'e', 't'), 4))
	}

	test("createCodeTree for empty word") {
		intercept[IllegalArgumentException] {
			val message = ""
			assert(Huffman.createCodeTree(Huffman.string2Chars(message)) === Fork(Fork(Leaf('e', 1), Leaf('s', 1), List('e', 's'), 2), Leaf('t', 2), List('e', 's', 't'), 4))
		}
	}

	test("encode word 'test'") {
		val message = "test"
		val t1 = Huffman.createCodeTree(message.toList)
		assert(encode(t1)(message.toList) === List(1, 0, 1, 0, 0, 1))
	}

	test("decode and encode a very short text should be identity") {
		new TestTrees {
			assert(decode(t1, encode(t1)("ab".toList)) === "ab".toList)
		}
	}

	test("decode secret code") {
		assert(decodedSecret === List('h', 'u', 'f', 'f', 'm', 'a', 'n', 'e', 's', 't', 'c', 'o', 'o', 'l'))
	}

	test("encode VS quickEncode") {
		val message = "test";
		val codeTree = Huffman.createCodeTree(message.toList)

		assert(quickEncode(codeTree)(message.toList) === quickEncode(codeTree)(message.toList))
	}

}
