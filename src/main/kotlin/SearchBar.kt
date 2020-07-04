import kotlinx.html.InputType
import kotlinx.html.js.onChangeFunction
import org.w3c.dom.HTMLInputElement
import org.w3c.dom.events.Event
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.form
import react.dom.input
import react.dom.p

class SearchBar : RComponent<SearchBarProps, RState>() {
    override fun RBuilder.render() {
        form {
            input(InputType.text) {
                attrs {
                    placeholder = "Search..."
                    value = props.filterText
                    onChangeFunction = ::handleFilterTextChange
                }
            }
            p {
                input(InputType.checkBox) {
                    attrs {
                        checked = props.inStockOnly
                        onChangeFunction = ::handleInStockChange
                    }
                }
                +" Only show products in stock"
            }
        }
    }

    private fun handleFilterTextChange(e: Event) {
        props.onFilterTextChange(e.target.unsafeCast<HTMLInputElement>().value)
    }

    private fun handleInStockChange(e: Event) {
        props.onInStockChange(e.target.unsafeCast<HTMLInputElement>().checked)
    }
}

external interface SearchBarProps : RProps {
    var filterText: String
    var inStockOnly: Boolean
    var onFilterTextChange: (String) -> Unit
    var onInStockChange: (Boolean) -> Unit
}

