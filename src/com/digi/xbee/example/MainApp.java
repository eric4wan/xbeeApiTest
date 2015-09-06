package com.digi.xbee.example;
 
import com.digi.xbee.api.XBeeDevice;
import com.digi.xbee.api.exceptions.XBeeException;
 
public class MainApp {
    private static final String PORT = "COM3";
    private static final int BAUD_RATE = 9600;
     
    private static final String DATA_TO_SEND = "Hello XBee World!";
     
    public static void main(String[] args) throws XBeeException {
        XBeeDevice myDevice = new XBeeDevice(PORT, BAUD_RATE);
        byte[] dataToSend = DATA_TO_SEND.getBytes();
         
        try {
            myDevice.open();
            System.out.format("Sending broadcast data: '%s'", new String(dataToSend));
             
            myDevice.sendBroadcastData(dataToSend);
            System.out.println(" >> Success");
             
        } catch (XBeeException e) {
            System.out.println(" >> Error");
            e.printStackTrace();
            System.exit(1);
        } finally {
            myDevice.close();
        }
    	
    	// Instantiate an XBee device object.
    	XBeeDevice myXBeeDevice = new XBeeDevice("COM3", 9600);
    	myXBeeDevice.open();
    	 
    	// Create the data reception listener.
    	MyDataReceiveListener myDataReceiveListener = new MyDataReceiveListener();
    	 
    	// Subscribe to data reception.
    	myXBeeDevice.addDataListener(myDataReceiveListener);
    }
}