/* This file is part of Vault.

    Vault is free software: you can redistribute it and/or modify
    it under the terms of the GNU Lesser General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    Vault is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU Lesser General Public License for more details.

    You should have received a copy of the GNU Lesser General Public License
    along with Vault.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.github.adminoid.vault.economy;

import java.math.BigDecimal;
import java.util.List;

import org.bukkit.OfflinePlayer;

/**
 * The main economy API
 *
 */
public interface Economy {

    /**
     * Checks if economy method is enabled.
     * @return Success or Failure
     */
    public boolean isEnabled();

    /**
     * Gets name of economy method
     * @return Name of Economy Method
     */
    public String getName();

    /**
     * Returns true if the given implementation supports banks.
     * @return true if the implementation supports banks
     */
    public boolean hasBankSupport();

    /**
     * Some economy plugins round off after a certain number of digits.
     * This function returns the number of digits the plugin keeps
     * or -1 if no rounding occurs.
     * @return number of digits after the decimal point kept
     */
    public int fractionalDigits();

    /**
     * Format amount into a human readable String This provides translation into
     * economy specific formatting to improve consistency between plugins.  
     *
     * @param amount to format
     * @return Human readable string describing amount
     */
    public String format(BigDecimal amount);

    /**
     * Returns the name of the currency in plural form.
     * If the economy being used does not support currency names then an empty string will be returned.
     * 
     * @return name of the currency (plural)
     */
    public String currencyNamePlural();


    /**
     * Returns the name of the currency in singular form.
     * If the economy being used does not support currency names then an empty string will be returned.
     * 
     * @return name of the currency (singular)
     */
    public String currencyNameSingular();

    /**
     * 
     * @deprecated As of VaultAPI 1.4 use {@link #hasAccount(OfflinePlayer)} instead.
     */
    @Deprecated
    public boolean hasAccount(String playerName);

    /**
     * Checks if this player has an account on the server yet
     * This will always return true if the player has joined the server at least once
     * as all major economy plugins auto-generate a player account when the player joins the server
     * 
     * @param player to check
     * @return if the player has an account
     */
    public boolean hasAccount(OfflinePlayer player);
    
    /**
     * @deprecated As of VaultAPI 1.4 use {@link #hasAccount(OfflinePlayer, String)} instead.
     */
    @Deprecated
    public boolean hasAccount(String playerName, String worldName);

    /**
     * Checks if this player has an account on the server yet on the given world
     * This will always return true if the player has joined the server at least once
     * as all major economy plugins auto-generate a player account when the player joins the server
     * 
     * @param player to check in the world
     * @param worldName world-specific account
     * @return if the player has an account
     */
    public boolean hasAccount(OfflinePlayer player, String worldName);

    /**
     * @deprecated As of VaultAPI 1.4 use {@link #getBalance(OfflinePlayer)} instead.
     */
    @Deprecated
    public BigDecimal getBalance(String playerName);
    
    /**
     * Gets balance of a player
     * 
     * @param player of the player
     * @return Amount currently held in players account
     */
    public BigDecimal getBalance(OfflinePlayer player);

    /**
     * @deprecated As of VaultAPI 1.4 use {@link #getBalance(OfflinePlayer, String)} instead.
     */
    @Deprecated
    public BigDecimal getBalance(String playerName, String world);
    
    /**
     * Gets balance of a player on the specified world.
     * IMPLEMENTATION SPECIFIC - if an economy plugin does not support this the global balance will be returned.
     * @param player to check
     * @param world name of the world
     * @return Amount currently held in players account
     */
    public BigDecimal getBalance(OfflinePlayer player, String world);
    
    /**
     * @deprecated As of VaultAPI 1.4 use {@link #has(OfflinePlayer, BigDecimal)} instead.
     */
    @Deprecated
    public boolean has(String playerName, BigDecimal amount);
    
    /**
     * Checks if the player account has the amount - DO NOT USE NEGATIVE AMOUNTS
     * 
     * @param player to check
     * @param amount to check for
     * @return True if <b>player</b> has <b>amount</b>, False else wise
     */
    public boolean has(OfflinePlayer player, BigDecimal amount);

    /**
     * @deprecated As of VaultAPI 1.4 use @{link {@link #has(OfflinePlayer, String, BigDecimal)} instead.
     */
    @Deprecated
    public boolean has(String playerName, String worldName, BigDecimal amount);
    
    /**
     * Checks if the player account has the amount in a given world - DO NOT USE NEGATIVE AMOUNTS
     * IMPLEMENTATION SPECIFIC - if an economy plugin does not support this the global balance will be returned.
     * 
     * @param player to check
     * @param worldName to check with
     * @param amount to check for
     * @return True if <b>player</b> has <b>amount</b>, False else wise
     */
    public boolean has(OfflinePlayer player, String worldName, BigDecimal amount);

    /**
     * @deprecated As of VaultAPI 1.4 use {@link #withdrawPlayer(OfflinePlayer, BigDecimal)} instead.
     */
    @Deprecated
    public EconomyResponse withdrawPlayer(String playerName, BigDecimal amount);

    /**
     * Withdraw an amount from a player - DO NOT USE NEGATIVE AMOUNTS
     * 
     * @param player to withdraw from
     * @param amount Amount to withdraw
     * @return Detailed response of transaction
     */
    public EconomyResponse withdrawPlayer(OfflinePlayer player, BigDecimal amount);

    /**
     * @deprecated As of VaultAPI 1.4 use {@link #withdrawPlayer(OfflinePlayer, String, BigDecimal)} instead.
     */
    @Deprecated
    public EconomyResponse withdrawPlayer(String playerName, String worldName, BigDecimal amount);
    
    /**
     * Withdraw an amount from a player on a given world - DO NOT USE NEGATIVE AMOUNTS
     * IMPLEMENTATION SPECIFIC - if an economy plugin does not support this the global balance will be returned.
     * @param player to withdraw from
     * @param worldName - name of the world
     * @param amount Amount to withdraw
     * @return Detailed response of transaction
     */
    public EconomyResponse withdrawPlayer(OfflinePlayer player, String worldName, BigDecimal amount);

    /**
     * @deprecated As of VaultAPI 1.4 use {@link #depositPlayer(OfflinePlayer, BigDecimal)} instead.
     */
    @Deprecated
    public EconomyResponse depositPlayer(String playerName, BigDecimal amount);

    /**
     * Deposit an amount to a player - DO NOT USE NEGATIVE AMOUNTS
     * 
     * @param player to deposit to
     * @param amount Amount to deposit
     * @return Detailed response of transaction
     */
    public EconomyResponse depositPlayer(OfflinePlayer player, BigDecimal amount);

    /**
     * @deprecated As of VaultAPI 1.4 use {@link #depositPlayer(OfflinePlayer, String, BigDecimal)} instead.
     */
    @Deprecated
    public EconomyResponse depositPlayer(String playerName, String worldName, BigDecimal amount);
   
    /**
     * Deposit an amount to a player - DO NOT USE NEGATIVE AMOUNTS
     * IMPLEMENTATION SPECIFIC - if an economy plugin does not support this the global balance will be returned.
     * 
     * @param player to deposit to
     * @param worldName name of the world
     * @param amount Amount to deposit
     * @return Detailed response of transaction
     */
    public EconomyResponse depositPlayer(OfflinePlayer player, String worldName, BigDecimal amount);

    /**
     * @deprecated As of VaultAPI 1.4 use {{@link #createBank(String, OfflinePlayer)} instead.
     */
    @Deprecated
    public EconomyResponse createBank(String name, String player);

    /**
     * Creates a bank account with the specified name and the player as the owner
     * @param name of account
     * @param player the account should be linked to
     * @return EconomyResponse Object
     */
    public EconomyResponse createBank(String name, OfflinePlayer player);

    /**
     * Deletes a bank account with the specified name.
     * @param name of the back to delete
     * @return if the operation completed successfully
     */
    public EconomyResponse deleteBank(String name);

    /**
     * Returns the amount the bank has
     * @param name of the account
     * @return EconomyResponse Object
     */
    public EconomyResponse bankBalance(String name);

    /**
     * Returns true or false whether the bank has the amount specified - DO NOT USE NEGATIVE AMOUNTS
     * 
     * @param name of the account
     * @param amount to check for
     * @return EconomyResponse Object
     */
    public EconomyResponse bankHas(String name, BigDecimal amount);

    /**
     * Withdraw an amount from a bank account - DO NOT USE NEGATIVE AMOUNTS
     * 
     * @param name of the account
     * @param amount to withdraw
     * @return EconomyResponse Object
     */
    public EconomyResponse bankWithdraw(String name, BigDecimal amount);

    /**
     * Deposit an amount into a bank account - DO NOT USE NEGATIVE AMOUNTS
     * 
     * @param name of the account
     * @param amount to deposit
     * @return EconomyResponse Object
     */
    public EconomyResponse bankDeposit(String name, BigDecimal amount);
    
    /**
     * @deprecated As of VaultAPI 1.4 use {{@link #isBankOwner(String, OfflinePlayer)} instead.
     */
    @Deprecated
    public EconomyResponse isBankOwner(String name, String playerName);
    
    /**
     * Check if a player is the owner of a bank account
     * 
     * @param name of the account
     * @param player to check for ownership
     * @return EconomyResponse Object
     */
    public EconomyResponse isBankOwner(String name, OfflinePlayer player);

    /**
     * @deprecated As of VaultAPI 1.4 use {{@link #isBankMember(String, OfflinePlayer)} instead.
     */
    @Deprecated
    public EconomyResponse isBankMember(String name, String playerName);
    
    /**
     * Check if the player is a member of the bank account
     * 
     * @param name of the account
     * @param player to check membership
     * @return EconomyResponse Object
     */
    public EconomyResponse isBankMember(String name, OfflinePlayer player);

    /**
     * Gets the list of banks
     * @return the List of Banks
     */
    public List<String> getBanks();

    /**
     * @deprecated As of VaultAPI 1.4 use {{@link #createPlayerAccount(OfflinePlayer)} instead.
     */
    @Deprecated
    public boolean createPlayerAccount(String playerName);
    
    /**
     * Attempts to create a player account for the given player
     * @param player OfflinePlayer
     * @return if the account creation was successful
     */
    public boolean createPlayerAccount(OfflinePlayer player);
    
    /**
     * @deprecated As of VaultAPI 1.4 use {{@link #createPlayerAccount(OfflinePlayer, String)} instead.
     */
    @Deprecated
    public boolean createPlayerAccount(String playerName, String worldName);
    
    /**
     * Attempts to create a player account for the given player on the specified world
     * IMPLEMENTATION SPECIFIC - if an economy plugin does not support this then false will always be returned.
     * @param player OfflinePlayer
     * @param worldName String name of the world
     * @return if the account creation was successful
     */
    public boolean createPlayerAccount(OfflinePlayer player, String worldName);
}
