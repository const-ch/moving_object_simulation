package com.company.data.enums;

public enum Move {

    QUIT(0),
    FORWARD(1),
    BACKWARD(2),
    ROTATE_RIGHT(3),
    ROTATE_LEFT(4),
    UNKNOWN(404);

    private final int code;

    Move(int code) {
        this.code = code;
    }

    public static Move valueByCode(int id) {
        for (Move e : values()) {
            if (e.code == id)
                return e;
        }
        return UNKNOWN;
    }
}
