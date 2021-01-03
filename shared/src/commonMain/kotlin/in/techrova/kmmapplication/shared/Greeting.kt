package `in`.techrova.kmmapplication.shared



class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}
