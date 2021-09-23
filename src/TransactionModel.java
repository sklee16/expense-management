import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * A model of a product inventory application.
 *
 * <p>CS18000 -- Spring 2018 -- Complex GUIs -- Homework</p>
 */
public final class TransactionModel {
    /**
     * The product list of this inventory model.
     */
    private List<Expense> expenseList;

    /**
     * Constructs a newly allocated {@code InventoryModel} object.
     */
    public TransactionModel() {
        this.expenseList = new ArrayList<>();
    } //InventoryModel

    /**
     * Determines whether or not this inventory model contains the specified product. The search is case-insensitive.
     *
     * @param aExpense the product to be searched for
     * @return {@code true}, if this inventory model contains the specified product, and {@code false} otherwise
     * @throws IllegalArgumentException if the {@code aProduct} argument is {@code null}
     */
    public boolean contains(Expense aExpense) throws IllegalArgumentException {
        if (aExpense == null) {
            throw new IllegalArgumentException("aProduct argument is null");
        } else {
            for (Expense expense : this.expenseList) {
                if (expense.getSku() == null ? aExpense.getSku() == null : expense.getSku().equalsIgnoreCase(aExpense.getSku())) {
                    return true;
                } //end if
            } //end for

            return false;
        } //end if
    } //contains

    /**
     * Attempts to add the specified product to this inventory model. If the specified product is already a member of
     * this model, it will not be added.
     *
     * @param aExpense the product attempting to be added
     * @return {@code true}, if the specified product was successfully added, and {@code false} otherwise
     * @throws IllegalArgumentException if the {@code aProduct} argument is {@code null}
     */
    public boolean add(Expense aExpense) throws IllegalArgumentException {
        if (aExpense == null) {
            throw new IllegalArgumentException("aProduct argument is null");
        } else if (this.contains(aExpense)) {
            return false;
        } else {
            this.expenseList.add(aExpense);

            return true;
        } //end if
    } //add

    /**
     * Attempts to remove the specified product from this inventory model. If the specified product is not a member of
     * this model, no products will be removed.
     *
     * @param aExpense the product attempting to be removed
     * @return {@code true}, if the specified product was successfully removed, and {@code false} otherwise
     * @throws IllegalArgumentException if the {@code aProduct} argument is {@code null}
     */
    public boolean remove(Expense aExpense) throws IllegalArgumentException {
        return this.expenseList.remove(aExpense);
    } //remove

    /**
     * Searches for a product with the specified SKU in this inventory model. The search is case-insensitive.
     *
     * @param sku the SKU to be searched for
     * @return an {@code Optional} containing the product with the specified SKU, or an empty {@code Optional} if the
     * product was not found
     */
    public Optional<Expense> searchBySku(String sku) {
        return this.expenseList.stream()
                .filter(expense -> (expense.getSku() == null ? sku == null : expense.getSku().equalsIgnoreCase(sku)))
                .findAny();
    } //searchBySku

    /**
     * Searches for products with the specified name in this inventory model. The search is case-insensitive.
     *
     * @param name the name to be searched for
     * @return a {@code List} containing products with the specified name
     */
    public List<Expense> searchByName(String name) {
        return this.expenseList.stream()
                .filter(expense -> (expense.getName() == null ? name == null : expense.getName().equalsIgnoreCase(name)))
                .collect(Collectors.toList());
    } //searchByName

    /**
     * Searches for products with the specified wholesale price in this inventory model.
     *
     * @param wholesalePrice the wholesale price to be searched for
     * @return a {@code List} containing products with the specified wholesale price
     */
    public List<Expense> searchByWholesalePrice(double wholesalePrice) {
        return this.expenseList.stream()
                .filter(expense -> (Double.compare(expense.getWholesalePrice(), wholesalePrice) == 0))
                .collect(Collectors.toList());
    } //searchByWholesalePrice

    /**
     * Searches for products with the specified retail price in this inventory model.
     *
     * @param retailPrice the retail price to be searched for
     * @return a {@code List} containing products with the specified retail price
     */
    public List<Expense> searchByRetailPrice(double retailPrice) {
        return this.expenseList.stream()
                .filter(expense -> (Double.compare(expense.getRetailPrice(), retailPrice) == 0))
                .collect(Collectors.toList());
    } //searchByRetailPrice

    /**
     * Searches for products with the specified quantity in this inventory model.
     *
     * @param quantity the quantity to be searched for
     * @return a {@code List} containing products with the specified quantity
     */
    public List<Expense> searchByQuantity(int quantity) {
        return this.expenseList.stream()
                .filter(expense -> (expense.getQuantity() == quantity))
                .collect(Collectors.toList());
    } //searchByQuantity

    /**
     * Gets the hash code of this inventory model.
     *
     * @return the hash code of this inventory model
     */
    @Override
    public int hashCode() {
        int result = 23;

        result = 19 * result + (this.expenseList == null ? 0 : this.expenseList.hashCode());

        return result;
    } //hashCode

    /**
     * Determines whether or not this inventory model is equal to the specified object. {@code true} is returned if and
     * only if the specified object is an instance of {@code InventoryModel}, and its field values are equal to this
     * inventory model's.
     *
     * @param anObject the object to be compared
     * @return {@code true}, if this inventory model is equal to the specified object, and {@code false} otherwise
     */
    @Override
    public boolean equals(Object anObject) {
        return (anObject instanceof TransactionModel)
                && (this.expenseList == null ? ((TransactionModel) anObject).expenseList == null : this.expenseList.equals(((TransactionModel) anObject).expenseList));
    } //equals

    /**
     * Gets a {@code String} representation of this inventory model. The returned {@code String} is of the form
     * {@code InventoryModel[p]}, where {@code p} is the list of products contained in this inventory model.
     *
     * @return a {@code String} representation of this inventory model
     */
    @Override
    public String toString() {
        return (this.expenseList == null ? "InventoryModel[]" : String.format("InventoryModel%s", this.expenseList));
    } //toString
}