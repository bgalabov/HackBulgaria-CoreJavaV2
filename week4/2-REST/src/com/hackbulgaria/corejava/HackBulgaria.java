package com.hackbulgaria.corejava;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;

public class HackBulgaria {

    public static void printStudentsWithMoreCourses() throws ClientProtocolException, IOException, JSONException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet getRequest = new HttpGet("https://hackbulgaria.com/api/students/");

        ResponseHandler<String> responseHandler = new ResponseHandler<String>() {

            @Override
            public String handleResponse(final HttpResponse response) throws ClientProtocolException, IOException {
                int status = response.getStatusLine().getStatusCode();
                if (status >= 200 && status < 300) {
                    HttpEntity entity = response.getEntity();
                    return entity != null ? EntityUtils.toString(entity) : null;
                } else {
                    throw new ClientProtocolException("Unexpected response status: " + status);
                }
            }

        };
        String responseBody = httpClient.execute(getRequest, responseHandler);
        JSONArray jsonArrayStudents = new JSONArray(responseBody);
        System.out.println("Students, who have signed for more than one course: ");
        System.out.println("----------------------------------------");
        for (int i = 0; i < jsonArrayStudents.length(); i++) {
            if (jsonArrayStudents.getJSONObject(i).getJSONArray("courses").length() > 1) {
                System.out.println(jsonArrayStudents.getJSONObject(i).get("name"));
            }
        }
    }

    public static void main(String[] args) throws ClientProtocolException, IOException, JSONException {
        HackBulgaria.printStudentsWithMoreCourses();
    }
}