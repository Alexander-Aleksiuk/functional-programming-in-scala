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
	}

	val m1 = new Main()                       //> m1  : common.wsCommon.Main = common.wsCommon$Main@6c8d5190
	val m2 = new MainA()                      //> m2  : common.wsCommon.MainA = common.wsCommon$MainA@114536a5
	val m3 = new MainC()                      //> m3  : common.wsCommon.MainC = common.wsCommon$MainC@70bd61d4
	val mX = new MainX()                      //> mX  : common.wsCommon.MainX = common.wsCommon$MainX@2161df1f

	
}