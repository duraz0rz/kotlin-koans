package ii_collections

fun Shop.getCustomerWithMaximumNumberOfOrders(): Customer? = this.customers.maxBy { it.orders.count() }
fun Customer.getMostExpensiveOrderedProduct(): Product? = this.orderedProducts.maxBy { it.price }
