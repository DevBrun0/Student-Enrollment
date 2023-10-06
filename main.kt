enum class Level { BASIC, INTERMEDIATE, HARD }

class User(val name: String)

data class EducationContent(val name: String, val duration: Int = 60)

class Formation(val name: String, val level: Level, val contents: List<EducationContent>) {
    val subscribes = mutableListOf<User>()
    val progress = mutableMapOf<User, MutableList<EducationContent>>()

    fun enroll(User: User, content: EducationContent) {
        subscribes.add(User)
        progress[User] = mutableListOf()
        progress[User]?.add(content)
        println("$User was registered in formation $name and studying the content ${content.name}")
    }
}

fun main() {

    // Creating some education content 
    val content1 = EducationContent("Introduction to Programming", 90)
    val content2 = EducationContent("Data Structure", 120)
    val content3 = EducationContent("Advanced Algorithms", 150)

    // Creating the formation of student 
    val formation1 = Formation("Computing Science", Level.INTERMEDIATE, listOf(content1, content2, content3))

    // the array users is used to count how much students we have.
    val users = arrayOf(User("Alice"), User("Bob"), User("Carol"))
    val contentsToDo = listOf(content1, content2, content3)

    // Creating the enroll for the students and attching them with the exist content 
    for (i in users.indices) {
        formation1.enroll(users[i], contentsToDo[i])
    }

}