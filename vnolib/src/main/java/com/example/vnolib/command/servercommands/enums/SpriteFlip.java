package com.example.vnolib.command.servercommands.enums;

public enum SpriteFlip implements CommandEnum {
    NOFLIP(0),
    FLIP(1);

    public final int flipNum;

    SpriteFlip(int flip) {
        flipNum = flip;
    }

    public boolean hasFlip() {
        return flipNum != 0;
    }

    @Override
    public String asRequestArgument() {
        return Integer.toString(flipNum);
    }
}
