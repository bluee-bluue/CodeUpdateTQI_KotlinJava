# Descrição
O Design Pattern "Builder" é uma técnica utilizada para criar objetos complexos passo a passo, separando o processo de construção da representação final do objeto. Isso ajuda a melhorar a legibilidade e a flexibilidade do código, especialmente quando você precisa criar objetos com muitos parâmetros ou configurações diferentes.

Neste desafio, buscando soluções para um problema de negócios em uma plataforma de e-commerce, é necessário melhorar a forma como os pedidos personalizados são tratados. Você tem a opção de implementar a solução utilizando o padrão Builder para criar pedidos de forma mais eficiente e organizada, ou seguir uma abordagem alternativa sem a necessidade de utilizar o padrão Builder.

### Detalhamento da tarefa:
1. Capture o nome do cliente.
2. Solicite ao usuário a quantidade de produtos que deseja adicionar ao pedido.
3. Para cada produto, capture o nome, preço e quantidade.
4. Capture o endereço de entrega.
5. Calcule o total do pedido somando o preço de cada produto multiplicado pela quantidade.
6. Imprima os detalhes do pedido, incluindo os produtos, seus preços, quantidades, total a pagar e endereço de entrega.

# Entrada
O programa deve receber as seguintes informações do usuário:

* Nome do cliente (string);
* Lista de produtos a serem incluídos no pedido (cada produto possui nome, preço e quantidade);
* Endereço de entrega (string);

# Saída
Após receber todas as informações do usuário, o programa deve criar um objeto de pedido personalizado usando o padrão Builder e imprimir os detalhes do pedido construído, incluindo o total a pagar.

Para este desafio, considere apenas uma casa decimal após a vírgula.

# Exemplos
A tabela abaixo apresenta exemplos com alguns dados de entrada e suas respectivas saídas esperadas. Certifique-se de testar seu programa com esses exemplos e com outros casos possíveis.

| Entrada                                                  | Saída                                                               |
|----------------------------------------------------------|---------------------------------------------------------------------|
| Ada <br> 1 <br> Chocolate <br> 1.5 <br> 3 <br> Arabaiana | Ada <br> 1. Chocolate / 1.5 / 2 <br> Total: 3.0 <br> End: Arabaiana |
| Dante <br> 1 <br> Suco <br> 2.5 <br> 2 <br> Alto         | Dante <br> 1. Suco / 2.5 / 2 <br> Total: 5.0 <br> End: Alto         |
| Sofia <br> 1 <br> Pipoca <br> 4.5 <br> 3 <br> Lagoa      | Sofia <br> 1. Pipoca / 4.5 / 3 <br> Total: 13.5 <br> End: Lagoa     |

**Nota:** <br> O padrão Builder é uma abordagem valiosa quando se trata de criar objetos complexos com diferentes configurações. No entanto, deve-se considerar a relação entre a complexidade do problema e a necessidade de aplicar o padrão, especialmente em cenários mais simples. A decisão de usar ou não o padrão Builder dependerá das necessidades específicas do projeto e das características do sistema em que está sendo aplicado.

**_Caso queira saber mais sobre o Design Pattern Builder:_** <br>https://refactoring.guru/pt-br/design-patterns/builder



# Código Base
````kotlin
class Product(val name: String, val price: Double, val quantity: Int)

class CustomOrder private constructor(
    val customerName: String,
    val products: List<Product>,
    val total: Double,
    val deliveryAddress: String
) {
    class Builder {
        private var customerName: String = ""
        private var products: MutableList<Product> = mutableListOf()
        private var deliveryAddress: String = ""

        fun setCustomerName(name: String) = apply { customerName = name }
        fun addProduct(product: Product) = apply { products.add(product) }
        fun setDeliveryAddress(address: String) = apply { deliveryAddress = address }

        fun build(): CustomOrder {
            //TODO: Implemente a lógica para calcular o Total do Pedido (a partir dos dados de Produtos).
            //TODO: Instancie corretamente um CustomOrder, consolidando o Builder!
            return CustomOrder("", emptyList(), 0.00, "")
        }
    }

    fun printReceipt() {
        println("${this.customerName}")
        this.products.forEachIndexed { index, product ->
            println("${index + 1}. ${product.name} | ${product.price} | ${product.quantity}")
        }
        println("Total: ${this.total}")
        println("End: ${this.deliveryAddress}")
    }
}

fun main() {
    val customerName = readLine() ?: ""

    val orderBuilder = CustomOrder.Builder().setCustomerName(customerName)

    val numProducts = readLine()?.toIntOrNull() ?: 0
    for (i in 1..numProducts) {
        val productName = readLine() ?: ""
        val productPrice = readLine()?.toDoubleOrNull() ?: 0.0
        val productQuantity = readLine()?.toIntOrNull() ?: 0

        orderBuilder.addProduct(Product(productName, productPrice, productQuantity))
    }

    val deliveryAddress = readLine() ?: ""

    val customOrder = orderBuilder.setDeliveryAddress(deliveryAddress).build()

    customOrder.printReceipt()
}
````