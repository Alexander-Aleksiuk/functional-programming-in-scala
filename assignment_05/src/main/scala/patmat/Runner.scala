package patmat

import patmat.Huffman.Fork
import patmat.Huffman.Leaf
import patmat.Huffman.CodeTree

object Runner {
	def main(args : Array[String]) : Unit = {
		/*val times = Huffman.times("aabbbcccceeetttttyyyddjjjj".toList)
		println("times=" + times)

		val orderedLeafList = Huffman.makeOrderedLeafList(times)
		println("orderedLeafList=" + orderedLeafList)

		val combine = Huffman.combine(orderedLeafList)
		println("combine=" + combine)

		val until = Huffman.until(Huffman.singleton(orderedLeafList), orderedLeafList)(orderedLeafList)
		println("until=" + until)
*/
		// val leaflist = List(Leaf('e', 1), Leaf('t', 2), Leaf('x', 4))
		// assert(combine(leaflist) === List(Fork(Leaf('e', 1), Leaf('t', 2), List('e', 't'), 3), Leaf('x', 4)))

		val treeData = "abcdefghaaaaaaabb"
		val message = "d"

		val leaflist = List(Leaf('e', 1), Leaf('t', 2), Leaf('x', 4))
		val combine = Huffman.combine(leaflist)
		println("combine=" + combine)

		val codeTree = Huffman.createCodeTree(treeData.toList)

		println("codeTree=" + codeTree)

		val encode = Huffman.encode(codeTree)(message.toList)
		val quickEncode = Huffman.quickEncode(codeTree)(message.toList)
		val decode = Huffman.decode(codeTree, encode)

		println("encode=" + encode)
		println("quickEncode=" + quickEncode)
		println("decode=" + decode)
	}
}