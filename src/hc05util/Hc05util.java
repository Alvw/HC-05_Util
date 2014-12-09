package hc05util;

import java.util.ArrayList;
import java.util.List;

public class Hc05util {

    public static void main(String[] args) {
        ComPort comPort = new ComPort();
        FrameDecoder frameDecoder = new FrameDecoder();
        try {
            Thread.sleep(100);
            comPort.connect("COM16");
            comPort.setFrameDecoder(frameDecoder);
            comPort.writeToPort(stringToByteList("AT+ROLE=0\r\n"));
            Thread.sleep(100);
            comPort.writeToPort(stringToByteList("AT+NAME=BIMETER\r\n"));
            Thread.sleep(100);
            comPort.writeToPort(stringToByteList("AT+UART=230400,1,0\r\n"));
            Thread.sleep(100);
            comPort.writeToPort(stringToByteList("AT+RMAAD\r\n"));
            Thread.sleep(100);
            comPort.writeToPort(stringToByteList("AT+BIND=14,1,143476\r\n"));
            Thread.sleep(100);
            comPort.writeToPort(stringToByteList("AT+CMODE=0\r\n"));
            Thread.sleep(100);
            comPort.writeToPort(stringToByteList("AT+ADDR?\r\n"));
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        comPort.disconnect();
        System.out.println("done!");
    }


    private static List<Byte> stringToByteList(String st){
        List<Byte> result = new ArrayList<Byte>();
        byte[] bytes = st.getBytes();
        for (int i = 0; i < bytes.length; i++) {
            byte aByte = bytes[i];
            result.add(aByte);
        }
        return result;
    }
}
