import javax.swing.*;

/**
 * A remove controller of a product inventory application.
 *
 * <p>CS18000 -- Spring 2018 -- Complex GUIs -- Homework</p>
 */
public final class RemoveController {
    /**
     * The inventory model of this remove controller.
     */
    private TransactionModel transactionModel;

    /**
     * The remove view of this remove controller.
     */
    private RemoveView removeView;

    /**
     * Constructs a newly allocated {@code RemoveController} object with the specified inventory model and remove view.
     *
     * @param transactionModel the inventory model of this remove controller
     * @param removeView     the remove view of this remove controller
     * @throws IllegalArgumentException if the {@code inventoryModel} argument or {@code removeView} argument is
     *                                  {@code null}
     */
    public RemoveController(TransactionModel transactionModel, RemoveView removeView) throws IllegalArgumentException {
        if (transactionModel == null) {
            throw new IllegalArgumentException("inventoryModel argument is null");
        } else if (removeView == null) {
            throw new IllegalArgumentException("removeView argument is null");
        } else {
            this.transactionModel = transactionModel;
            this.removeView = removeView;

            this.removeView.getRemoveButton().addActionListener(e -> this.getRemoveButtonSemantics());

            this.removeView.getClearButton().addActionListener(e -> this.getClearButtonSemantics());
        } //end if
    } //RemoveController

    /**
     * Gets the semantics of a remove view's remove button.
     */
    private void getRemoveButtonSemantics() {
        //TODO implement method

        if (transactionModel.searchBySku(removeView.getSkuTextField().getText()).isPresent()) {
            transactionModel.remove(transactionModel.searchBySku(removeView.getSkuTextField().getText()).get());
            JOptionPane.showMessageDialog(new JFrame(),
                    "This product has been removed from the inventory.",
                    "Product Inventory", JOptionPane.INFORMATION_MESSAGE);
            removeView.getSkuTextField().setText("");
            removeView.getSkuTextField().requestFocus();
        } else {
            JOptionPane.showMessageDialog(new JFrame(),
                    "A product with the specified SKU does not exist in this invenstory!",
                    "Product Inventory", JOptionPane.ERROR_MESSAGE);
            removeView.getSkuTextField().requestFocus();
        }



    } //getRemoveButtonSemantics

    /**
     * Gets the semantics of a remove view's clear button.
     */
    private void getClearButtonSemantics() {
        //TODO implement method
        removeView.getSkuTextField().setText("");
        removeView.getSkuTextField().requestFocus();

    } //getClearButtonSemantics

    /**
     * Gets the hash code of this remove controller.
     *
     * @return the hash code of this remove controller
     */
    @Override
    public int hashCode() {
        int result = 23;

        result = 19 * result + (this.transactionModel == null ? 0 : this.transactionModel.hashCode());

        result = 19 * result + (this.removeView == null ? 0 : this.removeView.hashCode());

        return result;
    } //hashCode

    /**
     * Determines whether or not this remove controller is equal to the specified object. {@code true} is returned if
     * and only if the specified object is an instance of {@code RemoveController}, and its field values are equal to
     * this remove controller's.
     *
     * @param anObject the object to be compared
     * @return {@code true}, if this remove controller is equal to the specified object, and {@code false} otherwise
     */
    @Override
    public boolean equals(Object anObject) {
        return (anObject instanceof RemoveController)
                && (this.transactionModel == null ? ((RemoveController) anObject).transactionModel == null : this.transactionModel.equals(((RemoveController) anObject).transactionModel))
                && (this.removeView == null ? ((RemoveController) anObject).removeView == null : this.removeView.equals(((RemoveController) anObject).removeView));
    } //equals

    /**
     * Gets a {@code String} representation of this remove controller.
     *
     * @return a {@code String} representation of this remove controller
     */
    @Override
    public String toString() {
        return String.format("RemoveController[%s, %s]", this.transactionModel, this.removeView);
    } //toString
}