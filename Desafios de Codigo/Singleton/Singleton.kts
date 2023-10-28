class User(val id: Int, val name: String)

object UserManager {

    private val users = mutableListOf<User>()

    fun addUser(name: String) {
        // Adiciona um novo usuário à lista de usuários.
        users.add(User(users.size + 1, name))
    }

    fun listUsers() {
        // Imprime uma lista com os nomes dos usuários cadastrados.
        for (i in users.indices) {
            println("${i + 1} - ${users[i].name}")
        }
    }
}

fun main() {
    val quantity = readLine()?.toIntOrNull() ?: 0

    for (i in 1..quantity) {
        val name = readLine() ?: ""
        UserManager.addUser(name)
    }

    UserManager.listUsers()
}