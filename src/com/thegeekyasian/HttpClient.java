package com.thegeekyasian;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by VenD on 10/8/2017.
 */
public class HttpClient {

    final static Integer PORT = 80;
    public static Map<String, String> sendGetRequest(String url) throws Exception {
        Map<String, String> responseMap = new HashMap<>();
        URL urlObject = new URL(url);
        System.out.println("Establishing Connection");
        Socket socket = new Socket(InetAddress.getByName(urlObject.getHost()), PORT);
        System.out.println("Connection Established");
        PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
        printWriter.println("GET /" + urlObject.getFile() + " HTTP/1.0");
        printWriter.println("Host: " + urlObject.getHost());
        printWriter.println("");
        printWriter.flush();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String line;
        StringBuilder response = new StringBuilder();
        boolean headerDone = false;
        System.out.println("Fetching response. Please wait...");
        while ((line = bufferedReader.readLine()) != null) {
            response.append(line + "\n");
            if (line.isEmpty() && !headerDone) {
                responseMap.put("header", response.toString());
                headerDone = true;
                response = new StringBuilder();
            }
        }

        bufferedReader.close();
        printWriter.close();
        socket.close();
        System.out.println("Done!\n");

        responseMap.put("content", response.toString());
        return responseMap;
    }


    public static Map<String, String> sendPostRequest(String url, String data) throws Exception {
        Map<String, String> responseMap = new HashMap<>();
        URL urlObject = new URL(url);
        System.out.println("Creating Connection");
        Socket socket = new Socket(InetAddress.getByName(urlObject.getHost()), PORT);
        System.out.println("Connection Established");
        PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
        printWriter.println("POST /" + urlObject.getFile() + " HTTP/1.0");
        printWriter.println("Host: " + urlObject.getHost());
        printWriter.println("Content-Length: " + data.length());
        printWriter.println();   //Writing an empty line just to notify the server the header ends here
                                // and next thing written will the data/content
        printWriter.println(data);
        printWriter.println();
        printWriter.flush();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String line;
        StringBuilder response = new StringBuilder();
        boolean headerDone = false;
        System.out.println("Fetching response. Please wait...");
        while ((line = bufferedReader.readLine()) != null) {
            response.append(line + "\n");
            if (line.isEmpty() && !headerDone) {
                headerDone = true;
                response = new StringBuilder();
            }
        }
        bufferedReader.close();
        printWriter.close();
        socket.close();
        System.out.println("Done!\n");

        responseMap.put("content", response.toString());
        return responseMap;
    }
}
