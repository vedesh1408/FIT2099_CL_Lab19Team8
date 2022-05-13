package game;

public class WalletManager {
    // WalletManager class modified loosely based on TaxationManager class from FIT2099 Bootcamp 5 lab notes.

    private Integer wallet;

    private static WalletManager instance;

    private WalletManager() { // 1-  private to prevent anyone else from instantiating
        wallet = 0;
    }

    public static WalletManager getInstance() {
        if (instance == null) {
            instance = new WalletManager();
        }
        return instance;
    }

    /**
     * It increments the wallet by the provided amount
     *
     * @param amount The amount to be added to wallet
     */
    public void changeWallet(Integer amount) { this.wallet += amount; }

    /**
     * It returns the amount of money in the wallet
     *
     * @return Amount the wallet contains
     */
    public Integer getWallet() {
        return wallet;
    }
}