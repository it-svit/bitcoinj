package com.itsvit

import com.google.common.base.Joiner
import org.bitcoinj.params.TestNet3Params
import org.bitcoinj.wallet.Wallet

private const val SPACE = " "

fun main(args: Array<String>) {
    val params = TestNet3Params.get()
    val wallet = Wallet(params)
    val seed = wallet.keyChainSeed
    println("seed: $seed")
    println("creation time: ${seed.creationTimeSeconds}")
    val mnemoticCode = Joiner.on(SPACE).join(seed.mnemonicCode)
    System.out.println("mnemonicCode: $mnemoticCode")
}