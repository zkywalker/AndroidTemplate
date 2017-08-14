package me.arulnadhan.recyclerview.swipeable;

class InternalConstants {
    // bit: 0-5   : LEFT
    // bit: 6-11  : UP
    // bit: 12-17 : RIGHT
    // bit: 18-23 : DOWN
    // bit: 24    : REACTION_START_SWIPE_ON_LONG_PRESS
    static final int BIT_SHIFT_AMOUNT_LEFT = 0;
    static final int BIT_SHIFT_AMOUNT_UP = 6;
    static final int BIT_SHIFT_AMOUNT_RIGHT = 12;
    static final int BIT_SHIFT_AMOUNT_DOWN = 18;

    static final int REACTION_CAN_NOT_SWIPE = 0;
    static final int REACTION_CAN_NOT_SWIPE_WITH_RUBBER_BAND_EFFECT = 1;
    static final int REACTION_CAN_SWIPE = 2;
    static final int REACTION_MASK_START_SWIPE = 8;

    static final int REACTION_START_SWIPE_ON_LONG_PRESS = (1 << 24);

    static final int REACTION_CAPABILITY_MASK = 0x3;
}
