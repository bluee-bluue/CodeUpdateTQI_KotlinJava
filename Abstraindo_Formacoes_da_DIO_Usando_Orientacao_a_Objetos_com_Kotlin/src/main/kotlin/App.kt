fun main() {
    val cursosKotlin = mutableListOf<ConteudoEducacional>()
    val cursosJava = mutableListOf<ConteudoEducacional>()

    cursosKotlin.add(ConteudoEducacional("Introdução ao Kotlin", 60, Nivel.BASICO))
    cursosKotlin.add(ConteudoEducacional("Kotlin Intermediário", 80, Nivel.INTERMEDIARIO))
    cursosKotlin.add(ConteudoEducacional("Kotlin Avançado", 60, Nivel.AVANCADO))

    cursosJava.add(ConteudoEducacional("Introdução ao Java", 40, Nivel.BASICO))
    cursosJava.add(ConteudoEducacional("Java Intermediário", 80, Nivel.INTERMEDIARIO))
    cursosJava.add(ConteudoEducacional("Java Avançado", 80, Nivel.AVANCADO))

    val formacaoKotlin = Formacao("Kotlin", cursosKotlin)
    val formacaoJava = Formacao("Java", cursosJava)

    formacaoKotlin.listarConteudos()
    formacaoJava.listarConteudos()

    val usuario1 = Usuario(1, "João")
    val usuario2 = Usuario(2, "Maria")
    val usuario3 = Usuario(3, "Caique")

    formacaoKotlin.matricular(usuario1)
    formacaoKotlin.alunosMatriculados()

    println()

    formacaoKotlin.matricular(usuario2)
    formacaoJava.matricular(usuario3)
    formacaoKotlin.alunosMatriculados()
    formacaoJava.alunosMatriculados()

    println()

    formacaoKotlin.estaMatriculado(usuario1)
    formacaoKotlin.estaMatriculado(usuario2)
    formacaoKotlin.estaMatriculado(usuario3)

    println()

    formacaoJava.estaMatriculado(usuario1)
    formacaoJava.estaMatriculado(usuario2)
    formacaoJava.estaMatriculado(usuario3)

    println()

    formacaoKotlin.desmatricular(usuario1)
    formacaoKotlin.alunosMatriculados()
    formacaoJava.alunosMatriculados()
}