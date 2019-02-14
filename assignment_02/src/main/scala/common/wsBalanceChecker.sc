package common

import java.util.Stack

object wsBalanceChecker {
   def balance(chars : List[Char]) : Boolean = {
        checkBalance(new Stack[Char], chars.head, chars.tail)
    }                                             //> balance: (chars: List[Char])Boolean

    def checkBalance(buffer : Stack[Char], item : Char, list : List[Char]) : Boolean = {
        if ('('.equals(item) || ')'.equals(item)) {
            if (')'.equals(item) && !buffer.isEmpty() && '('.equals(buffer.peek())) buffer.pop() else buffer.push(item)
        }

        if (list.nonEmpty) checkBalance(buffer, list.head, list.tail)

        buffer.isEmpty
    }                                             //> checkBalance: (buffer: java.util.Stack[Char], item: Char, list: List[Char])B
                                                  //| oolean

		balance("(if (zero? x) max (/ 1 x))".toList)
                                                  //> res0: Boolean = true
		balance("I told him (that it's not (yet) done).\n(But he wasn't listening)".toList)
                                                  //> res1: Boolean = true
		balance(":-)".toList)             //> res2: Boolean = false
		balance("())(".toList)            //> res3: Boolean = false
		balance("( test ))".toList)       //> res4: Boolean = false
		balance("()))(())".toList)        //> res5: Boolean = false
}