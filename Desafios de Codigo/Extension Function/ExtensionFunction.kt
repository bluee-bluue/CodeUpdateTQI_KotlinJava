fun main() {
    val titulo = readLine() ?: ""
    val autor = readLine() ?: ""

    // Aqui usamos a Extension Function "generateSlug()" nas Strings de Entrada.
    val slugTitulo = titulo.generateSlug()
    val slugAutor = autor.generateSlug()

    println("Slug gerado para o livro:")
    println("${slugTitulo}_${slugAutor}")
}

fun String.generateSlug(): String {
    // Converte a string para lower case
    val slug = this.toLowerCase()

    // Remove espaços e caracteres especiais
    val regex = Regex("[^a-z0-9- .]")
    return slug.replace(regex, " ")
        .replace(".", " ")
        .replace("  ", " ")
        .replace(" ", "-")
}