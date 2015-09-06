package com.digi.xbee.example;

import java.io.UnsupportedEncodingException;

import com.digi.xbee.api.listeners.IDataReceiveListener;
import com.digi.xbee.api.models.XBeeMessage;
 
public class MyDataReceiveListener implements IDataReceiveListener {
    /*
     * Data reception callback.
     */
    @Override
    public void dataReceived(XBeeMessage xbeeMessage) {
//        String address = xbeeMessage.getXBeeAddress().toString();
//    	int var = xbeeMessage.getDataString();
    	String var = "";
        try {
        	var = new String(xbeeMessage.getData(), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("Received data" +
                ": " + var);
    }
}