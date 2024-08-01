package com.gagemorgan;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java Main <executable_file>");
            return;
        }

        String filePath = args[0];
        Disassembler disassembler = new Disassembler();
        disassembler.disassembleFile(filePath);
    }
}
