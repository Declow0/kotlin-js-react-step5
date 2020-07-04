import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.*

class ProductTable : RComponent<ProductTableProps, RState>() {
    override fun RBuilder.render() {
        var lastCategory: String? = null

        table {
            thead {
                tr {
                    th {
                        +"Name"
                    }
                    th {
                        +"Price"
                    }
                }
            }
            tbody {
                props.products
                    .filter { it.name.contains(props.filterText) }
                    .filter { !props.inStockOnly || it.stocked }
                    .forEach {
                        if (it.category != lastCategory) {
                            child(ProductCategoryRow::class) {
                                attrs {
                                    category = it.category
                                }
                            }
                            lastCategory = it.category
                        }

                        child(ProductRow::class) {
                            attrs {
                                product = it
                            }
                        }
                    }
            }
        }
    }
}

external interface ProductTableProps : RProps {
    var filterText: String
    var inStockOnly: Boolean
    var products: List<Product>
}