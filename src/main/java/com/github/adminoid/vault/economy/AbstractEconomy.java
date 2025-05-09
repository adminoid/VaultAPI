package com.github.adminoid.vault.economy;

import org.bukkit.OfflinePlayer;

import java.math.BigDecimal;

@SuppressWarnings("deprecation")
public abstract class AbstractEconomy implements Economy {

	@Override
	public boolean hasAccount(OfflinePlayer player) {
		if (player.getName() == null) return false;
		return hasAccount(player.getName());
	}

	@Override
	public boolean hasAccount(OfflinePlayer player, String worldName) {
		if (player.getName() == null) return false;
		return hasAccount(player.getName(), worldName);
	}

	@Override
	public BigDecimal getBalance(OfflinePlayer player) {
		return getBalance(player.getName());
	}

	@Override
	public BigDecimal getBalance(OfflinePlayer player, String world) {
		return getBalance(player.getName(), world);
	}

	@Override
	public boolean has(OfflinePlayer player, BigDecimal amount) {
		if (player.getName() == null) return false;
		return has(player.getName(), amount);
	}

	@Override
	public boolean has(OfflinePlayer player, String worldName, BigDecimal amount) {
		if (player.getName() == null) return false;
		return has(player.getName(), worldName, amount);
	}

	@Override
	public EconomyResponse withdrawPlayer(OfflinePlayer player, BigDecimal amount) {
		return withdrawPlayer(player.getName(), amount);
	}

	@Override
	public EconomyResponse withdrawPlayer(OfflinePlayer player, String worldName, BigDecimal amount) {
		return withdrawPlayer(player.getName(), worldName, amount);
	}

	@Override
	public EconomyResponse depositPlayer(OfflinePlayer player, BigDecimal amount) {
		return depositPlayer(player.getName(), amount);
	}

	@Override
	public EconomyResponse depositPlayer(OfflinePlayer player, String worldName, BigDecimal amount) {
		return depositPlayer(player.getName(), worldName, amount);
	}

	@Override
	public EconomyResponse createBank(String name, OfflinePlayer player) {
		return createBank(name, player.getName());
	}

	@Override
	public EconomyResponse isBankOwner(String name, OfflinePlayer player) {
		return isBankOwner(name, player.getName());
	}

	@Override
	public EconomyResponse isBankMember(String name, OfflinePlayer player) {
		return isBankMember(name, player.getName());
	}

	@Override
	public boolean createPlayerAccount(OfflinePlayer player) {
		return createPlayerAccount(player.getName());
	}

	@Override
	public boolean createPlayerAccount(OfflinePlayer player, String worldName) {
		return createPlayerAccount(player.getName(), worldName);
	}

}
