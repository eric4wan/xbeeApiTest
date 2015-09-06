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
    	String var = "";
        try {
        	var = new String(xbeeMessage.getData(), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("Received data" +
                ": " + var);
        if (var.length() > 5) {
        	System.out.println("fuck");
        }
    }
}