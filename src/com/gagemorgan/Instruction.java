package com.gagemorgan;

public class Instruction {
    private byte opcode;
    private String mnemonic;

    public Instruction(byte opcode, String mnemonic) {
        this.opcode = opcode;
        this.mnemonic = mnemonic;
    }

    public byte getOpcode() {
        return opcode;
    }

    public String getMnemonic() {
        return mnemonic;
    }

    @Override
    public String toString() {
        return String.format("%02X: %s", opcode, mnemonic);
    }
}
