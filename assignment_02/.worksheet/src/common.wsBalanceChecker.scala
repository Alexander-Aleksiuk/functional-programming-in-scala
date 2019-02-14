package common

import java.util.Stack

object wsBalanceChecker {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(182); 
   def balance(chars : List[Char]) : Boolean = {
        checkBalance(new Stack[Char], chars.head, chars.tail)
    };System.out.println("""balance: (chars: List[Char])Boolean""");$skip(373); 

    def checkBalance(buffer : Stack[Char], item : Char, list : List[Char]) : Boolean = {
        if ('('.equals(item) || ')'.equals(item)) {
            if (')'.equals(item) && !buffer.isEmpty() && '('.equals(buffer.peek())) buffer.pop() else buffer.push(item)
        }

        if (list.nonEmpty) checkBalance(buffer, list.head, list.tail)

        buffer.isEmpty
    };System.out.println("""checkBalance: (buffer: java.util.Stack[Char], item: Char, list: List[Char])Boolean""");$skip(48); val res$0 = 

		balance("(if (zero? x) max (/ 1 x))".toList);System.out.println("""res0: Boolean = """ + $show(res$0));$skip(86); val res$1 = 
		balance("I told him (that it's not (yet) done).\n(But he wasn't listening)".toList);System.out.println("""res1: Boolean = """ + $show(res$1));$skip(24); val res$2 = 
		balance(":-)".toList);System.out.println("""res2: Boolean = """ + $show(res$2));$skip(25); val res$3 = 
		balance("())(".toList);System.out.println("""res3: Boolean = """ + $show(res$3));$skip(30); val res$4 = 
		balance("( test ))".toList);System.out.println("""res4: Boolean = """ + $show(res$4));$skip(29); val res$5 = 
		balance("()))(())".toList);System.out.println("""res5: Boolean = """ + $show(res$5))}
}
