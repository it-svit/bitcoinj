package com.itsvit

import org.bitcoinj.core.Address
import org.bitcoinj.core.Coin
import org.bitcoinj.core.InsufficientMoneyException
import org.bitcoinj.kits.WalletAppKit
import org.bitcoinj.params.TestNet3Params
import org.bitcoinj.wallet.DeterministicSeed
import java.io.File


fun main(args: Array<String>) {
    val params = TestNet3Params.get()
    val kit = WalletAppKit(params, File("."), "sendcoins")
    kit.restoreWalletFromSeed(DeterministicSeed("poet essay food chief scrub attitude basket suggest ginger object welcome mystery", null, "", 1506414167))
    kit.startAsync();
    kit.awaitRunning();
    val value = Coin.parseCoin("0.01")
    //will send to our selves
    val to = Address.fromBase58(params, "n4ojRkX2v1XX91Wq5ZvqX3rDsxMKbHKoty")
    try {
        val result = kit.wallet().sendCoins(kit.peerGroup(), to, value)
        println("Trunsaction ${result.tx.hashAsString} successful.")
    } catch (e: InsufficientMoneyException) {
        println("Not enough coins!")
    }
    kit.stopAsync();
    kit.awaitTerminated();
}