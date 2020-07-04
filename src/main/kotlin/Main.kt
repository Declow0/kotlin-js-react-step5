import react.dom.render
import kotlin.browser.document

data class Product(
    val category: String,
    val price: Double,
    val stocked: Boolean,
    val name: String
)

fun main() {
    render(document.getElementById("container")) {
        child(FilterableProductTable::class) {
            attrs {
                products = listOf(
                    Product("Sporting Goods", 49.99, true, "Football"),
                    Product("Sporting Goods", 9.99, true, "Baseball"),
                    Product("Sporting Goods", 29.99, false, "Basketball"),
                    Product("Electronics", 99.99, true, "iPod Touch"),
                    Product("Electronics", 399.99, false, "iPhone 5"),
                    Product("Electronics", 199.99, true, "Nexus 7")
                )
            }
        }
    }
}