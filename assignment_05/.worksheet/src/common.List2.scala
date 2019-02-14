package common

object List2 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(98); 
	def apply[Int <: Nothing](x1 : Int, x2: Int): Int = {
		x1 + x2
	};System.out.println("""apply: [Int <: Nothing](x1: Int, x2: Int)Int""")}
}

object wsCommon {
	new List2(1, 2)
}
