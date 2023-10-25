data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {
    private var inscritos = mutableListOf<Usuario>()

    fun listarConteudos() {
        println("Conteúdos da formação $nome: ")
        for (conteudo in conteudos) {
            println("Nome: " + conteudo.nome + "\nDuração: " + conteudo.duracao + " minutos" + "\nNível: " + conteudo.nivel + "\n")
        }
    }

    fun matricular(usuario: Usuario) {
        if (inscritos.contains(usuario)) {
            println("O ${usuario.nome} (ID: ${usuario.id}) já está matriculado na formação $nome")
            return
        }
        else {
            println("O ${usuario.nome} (ID: ${usuario.id}) foi matriculado na formação $nome")
            inscritos.add(usuario)
        }
    }

    fun estaMatriculado(usuario: Usuario) {
        if (inscritos.contains(usuario)) {
            println("O ${usuario.nome} (ID: ${usuario.id}) está matriculado na formação $nome")
        }
        else {
            println("O ${usuario.nome} (ID: ${usuario.id}) não está matriculado na formação $nome")
        }
    }

    fun alunosMatriculados() {
        println("\nAlunos Matriculados em $nome:")
        for (inscrito in inscritos) {
            println("Nome: " + inscrito.nome + " (ID: " + inscrito.id + ")")
        }
    }

    fun desmatricular(usuario: Usuario) {
        for (inscrito in inscritos) {
            if (inscrito.id == usuario.id) {
                println("O ${usuario.nome} (ID: ${usuario.id}) foi desmatriculado da formação $nome")
                inscritos.remove(usuario)
                break
            }
        }
    }
}
