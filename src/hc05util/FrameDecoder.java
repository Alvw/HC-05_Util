package hc05util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

class FrameDecoder {

    public static final int START_FRAME_MARKER = 254;
    private int rxCntr;
    private byte[] rxData = new byte[30];
    private static final Log log = LogFactory.getLog(FrameDecoder.class);

    public FrameDecoder() {

    }

    public void onByteReceived(int inByte) {
        rxData[rxCntr++] = (byte)inByte;
        if(inByte == '\n'){
            rxCntr = 0;
            System.out.println(new String(rxData));
        }
    }
}
