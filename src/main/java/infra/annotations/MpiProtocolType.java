package infra.annotations;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Created by Evegeny on 06/05/2016.
 */
public enum MpiProtocolType implements Serializable{
    MAP(2, 3, 23), SAI(56), PRN(4), SRI4SM(560), FSM(550, 551), LTE(316), GTP(4000, 4001, 4002), ISUP(1000,1100, 1101, 1102, 1103, 1104, 1105), SIP(5000), ALL(0);


    private final Integer[] opcodes;

    MpiProtocolType(Integer... opcodes) {
        this.opcodes=opcodes;
    }

    public boolean isMyOpcode(int opcode) {
        return Arrays.asList(opcodes).contains(opcode);
    }
}
