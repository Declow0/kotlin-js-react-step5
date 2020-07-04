import kotlinx.css.Color
import kotlinx.css.color
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.td
import react.dom.tr
import styled.css
import styled.styledTd

class ProductRow: RComponent<ProductRowProps, RState>() {
    override fun RBuilder.render() {
        val product = props.product
        tr {
            styledTd {
                if (!product.stocked) {
                    css {
                        color = Color.red
                    }
                }
                +product.name
            }
            td {
                +"${product.price}\$"
            }
        }
    }
}

external interface ProductRowProps: RProps {
    var product: Product
}