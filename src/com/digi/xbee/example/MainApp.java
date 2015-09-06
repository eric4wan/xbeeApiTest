package com.digi.xbee.example;
 
import com.digi.xbee.api.RemoteXBeeDevice;
import com.digi.xbee.api.XBeeDevice;
import com.digi.xbee.api.exceptions.XBeeException;
import com.digi.xbee.api.models.XBee64BitAddress;
 
public class MainApp {
    private static final String PORT = "COM4";
//	private static final String PORT = "/dev/tty.usbserial-DA01M6QM";
    private static final int BAUD_RATE = 9600;
     
    private static final String DATA_TO_SEND = "Hello XBee World!";
     
    public static void main(String[] args) throws XBeeException {
    	// try to send fr
    	String data = "Hello XBee!";
    	
    	XBeeDevice myLocal = new XBeeDevice("COM4", 9600);
    	myLocal.open();
    	
    	RemoteXBeeDevice myRemote = new RemoteXBeeDevice(myLocal, new XBee64BitAddress("13A20040D51A0C"));
    	
    	myLocal.sendDataAsync(myRemote, data.getBytes());
//    	// example: try to send
//        XBeeDevice myDevice = new XBeeDevice(PORT, BAUD_RATE);
//        byte[] dataToSend = DATA_TO_SEND.getBytes();
//         
//        try {
//            myDevice.open();
//            System.out.format("Sending broadcast data: '%s'", new String(dataToSend));
//            myDevice.sendBroadcastData(dataToSend);
//            System.out.println(" >> Success");
//        } catch (XBeeException e) {
//            System.out.println(" >> Error");
//            e.printStackTrace();
//            System.exit(1);
//        } finally {
//            myDevice.close();
//        }
    	
        // example: try to receive
    	XBeeDevice myXBeeDevice = new XBeeDevice("COM3", 9600);
    	myXBeeDevice.open();
 
    	MyDataReceiveListener myDataReceiveListener = new MyDataReceiveListener();

    	myXBeeDevice.addDataListener(myDataReceiveListener);
    }
}