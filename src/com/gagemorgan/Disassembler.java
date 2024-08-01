package com.gagemorgan;

import java.io.FileInputStream;
import java.io.IOException;

public class Disassembler {
    public void disassembleFile(String filePath) {
        try (FileInputStream fis = new FileInputStream(filePath)) {
            byte[] buffer = new byte[16];
            int bytesRead;
            long offset = 0;
            while ((bytesRead = fis.read(buffer)) != -1) {
                for (int i = 0; i < bytesRead; i++) {
                    Instruction instruction = disassemble(buffer[i]);
                    if (instruction != null) {
                        System.out.printf("0x%08x: %-12s %02X%n", offset++, instruction.getMnemonic(), instruction.getOpcode());
                    }
                }
            }
            System.exit(0); // Explicitly exit the program after reading the file
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1); // Exit with an error code if an exception occurs
        }
    }

    private Instruction disassemble(byte opcode) {
        switch (opcode) {
            case (byte) 0x90: return new Instruction(opcode, "NOP");
            case (byte) 0xC3: return new Instruction(opcode, "RET");
            case (byte) 0xCC: return new Instruction(opcode, "INT3");
            case (byte) 0xEB: return new Instruction(opcode, "JMP short");
            case (byte) 0xE8: return new Instruction(opcode, "CALL");
            case (byte) 0xE9: return new Instruction(opcode, "JMP");
            default: return null; // Return null for unknown opcodes
        }
    }
}
