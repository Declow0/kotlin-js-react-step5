import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.th
import react.dom.tr

class ProductCategoryRow: RComponent<ProductCategoryRowProps, RState>() {
    override fun RBuilder.render() {
        tr {
            th {
                attrs {
                    colSpan = 2.toString()
                }
                +props.category
            }
        }
    }
}

external interface ProductCategoryRowProps: RProps {
    var category: String
}