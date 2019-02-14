package common

object wsCommon {
	class Main {
		def test() = {
			println("Main.test")
		}
	}

	class MainA extends Main {
		override
		def test() = {
			println("MainA.test")
		}
	}

	class MainC extends MainA {
		override
		def test() = {
			println("MainC.test")
		}
	}

	class MainX {
	};import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(315); 

	val m1 = new Main();System.out.println("""m1  : common.wsCommon.Main = """ + $show(m1 ));$skip(22); 
	val m2 = new MainA();System.out.println("""m2  : common.wsCommon.MainA = """ + $show(m2 ));$skip(22); 
	val m3 = new MainC();System.out.println("""m3  : common.wsCommon.MainC = """ + $show(m3 ));$skip(22); 
	val mX = new MainX();System.out.println("""mX  : common.wsCommon.MainX = """ + $show(mX ))}

	
}
