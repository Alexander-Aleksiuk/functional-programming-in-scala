package common

case class Message(value : String) {
}

case class Endpoint(prompt : String) {
	def send(m : Message) {
		println(this.prompt + " " + m.value)
	}
}

object wsCommon {

}
