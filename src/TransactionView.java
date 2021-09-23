import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 * A view of a product inventory application.
 *
 * <p>CS18000 -- Spring 2018 -- Complex GUIs -- Homework</p>
 */
public final class TransactionView {
    /**
     * The main panel of this inventory view.
     */
    private JPanel mainPanel;

    /**
     * The add view of this inventory view.
     */
    private AddView addView;

    /**
     * The update view of this inventory view.
     */
    private UpdateView updateView;

    /**
     * The remove view of this inventory view.
     */
    private RemoveView removeView;

    /**
     * The search view of this inventory view.
     */
    private SearchView searchView;

    /**
     * The main tabbed pane of this inventory view.
     */
    private JTabbedPane mainTabbedPane;

    /**
     * Constructs a newly allocated {@code InventoryView} object.
     */
    public TransactionView() {
        this.addView = new AddView();
        this.updateView = new UpdateView();
        this.removeView = new RemoveView();
        this.searchView = new SearchView();

        this.mainTabbedPane.add("Add", this.addView.getMainPanel());

        this.mainTabbedPane.add("Update", this.updateView.getMainPanel());

        this.mainTabbedPane.add("Remove", this.removeView.getMainPanel());

        this.mainTabbedPane.add("Search", this.searchView.getMainPanel());
    } //InventoryView

    /**
     * Gets the main panel of this inventory view.
     *
     * @return the main panel of this inventory view
     */
    public JPanel getMainPanel() {
        return this.mainPanel;
    } //getMainPanel

    /**
     * Gets the add view of this inventory view.
     *
     * @return the add view of this inventory view
     */
    public AddView getAddView() {
        return this.addView;
    } //getAddView

    /**
     * Gets the update view of this inventory view.
     *
     * @return the update view of this inventory view
     */
    public UpdateView getUpdateView() {
        return this.updateView;
    } //getUpdateView

    /**
     * Gets the remove view of this inventory view.
     *
     * @return the remove view of this inventory view
     */
    public RemoveView getRemoveView() {
        return this.removeView;
    } //getRemoveView

    /**
     * Gets the search view of this inventory view.
     *
     * @return the search view of this inventory view
     */
    public SearchView getSearchView() {
        return this.searchView;
    } //getSearchView

    /**
     * Gets the hash code of this inventory view.
     *
     * @return the hash code of this inventory view
     */
    @Override
    public int hashCode() {
        int result = 23;

        result = 19 * result + (this.mainPanel == null ? 0 : this.mainPanel.hashCode());

        result = 19 * result + (this.addView == null ? 0 : this.addView.hashCode());

        result = 19 * result + (this.updateView == null ? 0 : this.updateView.hashCode());

        result = 19 * result + (this.removeView == null ? 0 : this.removeView.hashCode());

        result = 19 * result + (this.searchView == null ? 0 : this.searchView.hashCode());

        return result;
    } //hashCode

    /**
     * Determines whether or not this inventory view is equal to the specified object. {@code true} is returned if and
     * only if the specified object is an instance of {@code InventoryView}, and its field values are equal to this
     * inventory view's.
     *
     * @param anObject the object to be compared
     * @return {@code true}, if this inventory view is equal to the specified object, and {@code false} otherwise
     */
    @Override
    public boolean equals(Object anObject) {
        return (anObject instanceof TransactionView)
                && (this.mainPanel == null ? ((TransactionView) anObject).mainPanel == null : this.mainPanel.equals(((TransactionView) anObject).mainPanel))
                && (this.addView == null ? ((TransactionView) anObject).addView == null : this.addView.equals(((TransactionView) anObject).addView))
                && (this.updateView == null ? ((TransactionView) anObject).updateView == null : this.updateView.equals(((TransactionView) anObject).updateView))
                && (this.removeView == null ? ((TransactionView) anObject).removeView == null : this.removeView.equals(((TransactionView) anObject).removeView))
                && (this.searchView == null ? ((TransactionView) anObject).searchView == null : this.searchView.equals(((TransactionView) anObject).searchView));
    } //equals

    /**
     * Gets a {@code String} representation of this inventory view.
     *
     * @return a {@code String} representation of this inventory view
     */
    @Override
    public String toString() {
        return String.format("InventoryView[%s, %s, %s, %s, %s]", this.mainPanel, this.addView, this.updateView, this.removeView, this.searchView);
    } //toString
}