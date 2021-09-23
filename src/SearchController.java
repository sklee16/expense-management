import javax.swing.*;
import java.util.List;
import java.util.Optional;

/**
 * A search controller of a product inventory application.
 *
 * <p>CS18000 -- Spring 2018 -- Complex GUIs -- Homework</p>
 */
public final class SearchController {
    /**
     * The inventory model of this search controller.
     */
    private TransactionModel transactionModel;

    /**
     * The search view of this search controller.
     */
    private SearchView searchView;

    /**
     * Constructs a newly allocated {@code SearchController} object with the specified inventory model and search view.
     *
     * @param transactionModel the inventory model of this search controller
     * @param searchView     the search view of this search controller
     * @throws IllegalArgumentException if the {@code inventoryModel} argument or {@code searchView} argument is
     *                                  {@code null}
     */
    public SearchController(TransactionModel transactionModel, SearchView searchView) throws IllegalArgumentException {
        if (transactionModel == null) {
            throw new IllegalArgumentException("inventoryModel argument is null");
        } else if (searchView == null) {
            throw new IllegalArgumentException("searchView argument is null");
        } else {
            this.transactionModel = transactionModel;
            this.searchView = searchView;

            this.searchView.getSearchButton().addActionListener(e -> this.getSearchButtonSemantics());

            this.searchView.getClearButton().addActionListener(e -> this.getClearButtonSemantics());
        } //end if
    } //SearchController

    /**
     * Gets the semantics of a search view's search button.
     */
    private void getSearchButtonSemantics() {
        //TODO implement method
        searchView.getResultsTextArea().setText("");
        if (searchView.getFieldComboBox().getSelectedItem() == null) {
            JOptionPane.showMessageDialog(new JFrame(), "Please select a field!",
                    "Product Inventory", JOptionPane.ERROR_MESSAGE);
            searchView.getFieldComboBox().requestFocus();
        } else if (searchView.getFieldComboBox().getSelectedItem().equals("SKU")) {
            Optional<Expense> skuoptional = transactionModel.searchBySku(searchView.getSearchValueTextField().getText());
            if (skuoptional.isPresent()) {//check if there is an inventory with that SKU
                searchView.getResultsTextArea().append(skuoptional.get().toString());
                searchView.getSearchValueTextField().setText("");
                searchView.getFieldComboBox().setSelectedIndex(-1);
                searchView.getFieldComboBox().requestFocus();
            } else {
                JOptionPane.showMessageDialog(new JFrame(),
                        "The specified SKU was not found!",
                        "Product Inventory", JOptionPane.ERROR_MESSAGE);
                searchView.getSearchValueTextField().requestFocus();
            }
        } else if (searchView.getFieldComboBox().getSelectedItem().equals("Name")) {
            List<Expense> name = transactionModel.searchByName(searchView.getSearchValueTextField().getText());
            if (!name.isEmpty()) {
                for (Expense nameproduct : name) {
                    searchView.getResultsTextArea().append(nameproduct.toString() + "\n\n");
                }
                searchView.getSearchValueTextField().setText("");
                searchView.getFieldComboBox().setSelectedIndex(-1);
                searchView.getFieldComboBox().requestFocus();
            } else {
                JOptionPane.showMessageDialog(new JFrame(),
                        "The specified name was not found!",
                        "Product Inventory", JOptionPane.ERROR_MESSAGE);
                searchView.getSearchValueTextField().requestFocus();
            }

        } else if (searchView.getFieldComboBox().getSelectedItem().equals("Wholesale price")) {
            try {
                List<Expense> wholesaleprice = transactionModel.searchByWholesalePrice(Double.parseDouble(searchView.getSearchValueTextField().getText()));
                if (!wholesaleprice.isEmpty()) {//check if there is an inventory by that wholesale price
                    for (Expense wholesalepriceproduct : wholesaleprice) {
                        searchView.getResultsTextArea().append(wholesalepriceproduct.toString() + "\n\n");
                    }
                    searchView.getSearchValueTextField().setText("");
                    searchView.getFieldComboBox().setSelectedIndex(-1);
                    searchView.getFieldComboBox().requestFocus();
                } else {
                    JOptionPane.showMessageDialog(new JFrame(),
                            "The specified wholesale price was not found!",
                            "Product Inventory", JOptionPane.ERROR_MESSAGE);
                    searchView.getSearchValueTextField().requestFocus();
                }
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(new JFrame(),
                        "The specified wholesale price is not a vaild number!",
                        "Product Inventory", JOptionPane.ERROR_MESSAGE);
                searchView.getSearchValueTextField().requestFocus();
            }
        } else if (searchView.getFieldComboBox().getSelectedItem().equals("Retail price")) {
            try {
                List<Expense> retailprice = transactionModel.searchByRetailPrice(Double.parseDouble(searchView.getSearchValueTextField().getText()));
                if (!retailprice.isEmpty()) {
                    for (Expense retailpriceproduct : retailprice) {
                        searchView.getResultsTextArea().append(retailpriceproduct.toString() + "\n\n");
                    }
                    searchView.getSearchValueTextField().setText("");
                    searchView.getFieldComboBox().setSelectedIndex(-1);
                    searchView.getFieldComboBox().requestFocus();
                } else {
                    JOptionPane.showMessageDialog(new JFrame(),
                            "The specified retail price was not found!",
                            "Product Inventory", JOptionPane.ERROR_MESSAGE);
                    searchView.getSearchValueTextField().requestFocus();
                }
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(new JFrame(),
                        "The specified retail price is not a vaild number!",
                        "Product Inventory", JOptionPane.ERROR_MESSAGE);
                searchView.getSearchValueTextField().requestFocus();
            }
        } else if (searchView.getFieldComboBox().getSelectedItem().equals("Quantity")) {
            try {
                List<Expense> quantity = transactionModel.searchByQuantity(Integer.parseInt(searchView.getSearchValueTextField().getText()));
                if (!quantity.isEmpty()) {
                    for (Expense quantityproduct : quantity) {
                        searchView.getResultsTextArea().append(quantityproduct.toString() + "\n\n");
                    }
                    searchView.getSearchValueTextField().setText("");
                    searchView.getFieldComboBox().setSelectedIndex(-1);
                    searchView.getFieldComboBox().requestFocus();
                } else {
                    JOptionPane.showMessageDialog(new JFrame(),
                            "The specified quantity was not found!",
                            "Product Inventory", JOptionPane.ERROR_MESSAGE);
                    searchView.getSearchValueTextField().requestFocus();
                }
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(new JFrame(),
                        "The specified quantity is not a vaild number!",
                        "Product Inventory", JOptionPane.ERROR_MESSAGE);
                searchView.getSearchValueTextField().requestFocus();
            }
        }
    } //getSearchButtonSemantics

    /**
     * Gets the semantics of a search view's clear button.
     */
    private void getClearButtonSemantics() {
        //TODO implement method
        searchView.getSearchValueTextField().setText("");
        searchView.getFieldComboBox().setSelectedIndex(-1);
        searchView.getResultsTextArea().setText("");
        searchView.getSearchValueTextField().requestFocus();
    } //getClearButtonSemantics

    /**
     * Gets the hash code of this search controller.
     *
     * @return the hash code of this search controller
     */
    @Override
    public int hashCode() {
        int result = 23;

        result = 19 * result + (this.transactionModel == null ? 0 : this.transactionModel.hashCode());

        result = 19 * result + (this.searchView == null ? 0 : this.searchView.hashCode());

        return result;
    } //hashCode

    /**
     * Determines whether or not this search controller is equal to the specified object. {@code true} is returned if
     * and only if the specified object is an instance of {@code SearchController}, and its field values are equal to
     * this search controller's.
     *
     * @param anObject the object to be compared
     * @return {@code true}, if this search controller is equal to the specified object, and {@code false} otherwise
     */
    @Override
    public boolean equals(Object anObject) {
        return (anObject instanceof SearchController)
                && (this.transactionModel == null ? ((SearchController) anObject).transactionModel == null : this.transactionModel.equals(((SearchController) anObject).transactionModel))
                && (this.searchView == null ? ((SearchController) anObject).searchView == null : this.searchView.equals(((SearchController) anObject).searchView));
    } //equals

    /**
     * Gets a {@code String} representation of this search controller.
     *
     * @return a {@code String} representation of this search controller
     */
    @Override
    public String toString() {
        return String.format("SearchController[%s, %s]", this.transactionModel, this.searchView);
    } //toString
}