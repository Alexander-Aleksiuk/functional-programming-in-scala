package common

object List {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(84); 

	
	def apply(x1 : Int, x2: Int): Int = {
		x1 + x2
	};System.out.println("""apply: (x1: Int, x2: Int)Int""")}
}

object wsCommon {
	new List(1, 2)
}
