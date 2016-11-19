/*
 * Copyright 2013 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.bitcoinj.params;

import org.bitcoinj.core.CoinDefinition;

import static com.google.common.base.Preconditions.checkState;

/**
 * Parameters for the old version 2 testnet. This is not useful to you - it exists only because some unit tests are
 * based on it.
 */
public class TestNet2Params extends AbstractBitcoinNetParams {
    public TestNet2Params() {
        super();
        id = ID_TESTNET;
        packetMagic = CoinDefinition.testnetPacketMagic; // FIXME

        port = CoinDefinition.testPort;
        addressHeader = CoinDefinition.testnetAddressHeader;
        p2shHeader = CoinDefinition.testnetp2shHeader;
        acceptableAddressCodes = new int[] { addressHeader, p2shHeader };
        interval = INTERVAL;
        targetTimespan = TARGET_TIMESPAN;
        maxTarget = CoinDefinition.testnetProofOfWorkLimit; // FIXME TODO Utils.decodeCompactBits(0x1d0fffffL);
        dumpedPrivateKeyHeader = 239;
        genesisBlock.setTime(CoinDefinition.testnetGenesisBlockTime); // FIXME
        genesisBlock.setDifficultyTarget(CoinDefinition.testnetGenesisBlockDifficultyTarget); // FIXME
        genesisBlock.setNonce(CoinDefinition.testnetGenesisBlockNonce); // FIXME
        spendableCoinbaseDepth = CoinDefinition.spendableCoinbaseDepth;
        subsidyDecreaseBlockCount = CoinDefinition.subsidyDecreaseBlockCount;
        String genesisHash = genesisBlock.getHashAsString();
        // TODO checkState(genesisHash.equals("00000007199508e34a9ff81e6ec0c477a4cccff2a4767a8eee39c11db367b008"));
        dnsSeeds = CoinDefinition.testnetDnsSeeds;
        addrSeeds = null;
        bip32HeaderPub = CoinDefinition.testnetAddressHeader;
        bip32HeaderPriv = CoinDefinition.p2shHeader;
    }

    private static TestNet2Params instance;
    public static synchronized TestNet2Params get() {
        if (instance == null) {
            instance = new TestNet2Params();
        }
        return instance;
    }

    @Override
    public String getPaymentProtocolId() {
        return null;
    }
}
