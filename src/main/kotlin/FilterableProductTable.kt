import react.*

class FilterableProductTable : RComponent<FilterableProductTableProps, FilterableProductTableState>() {
    override fun FilterableProductTableState.init() {
        filterText = ""
        inStockOnly = false
    }

    override fun RBuilder.render() {
        child(SearchBar::class) {
            attrs {
                filterText = state.filterText
                inStockOnly = state.inStockOnly
                onFilterTextChange = ::handleFilterTextChange
                onInStockChange = ::handleInStockChange
            }
        }
        child(ProductTable::class) {
            attrs {
                filterText = state.filterText
                inStockOnly = state.inStockOnly
                products = props.products
            }
        }
    }

    private fun handleFilterTextChange(filterText: String) {
        setState {
            this.filterText = filterText
        }
    }

    private fun handleInStockChange(inStockOnly: Boolean) {
        setState {
            this.inStockOnly = inStockOnly
        }
    }
}

external interface FilterableProductTableProps : RProps {
    var products: List<Product>
}

external interface FilterableProductTableState : RState {
    var filterText: String
    var inStockOnly: Boolean
}