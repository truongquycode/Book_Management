package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class AddressAPI {

    private static final String API_URL = "https://provinces.open-api.vn/api/";

    // Lấy danh sách tỉnh với depth=1
    public static ObservableList<Province> getProvinces() {
        ObservableList<Province> list = FXCollections.observableArrayList();
        try {
            String urlString = API_URL + "?depth=1";
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            
            int responseCode = conn.getResponseCode();
            if(responseCode != HttpURLConnection.HTTP_OK){
                System.err.println("HTTP error code: " + responseCode + " for URL: " + urlString);
                return list;
            }
            
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder json = new StringBuilder();
            String line;
            while((line = reader.readLine()) != null) {
                json.append(line);
            }
            reader.close();

            JSONArray jsonArray = new JSONArray(json.toString());
            for(int i = 0; i < jsonArray.length(); i++){
                JSONObject obj = jsonArray.getJSONObject(i);
                int code = obj.getInt("code");
                String name = obj.getString("name");
                list.add(new Province(code, name));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // Lấy danh sách huyện của một tỉnh dựa trên mã tỉnh
    public static ObservableList<District> getDistricts(int provinceCode) {
        ObservableList<District> list = FXCollections.observableArrayList();
        try {
            String urlString = API_URL + "p/" + provinceCode + "?depth=2";
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            
            int responseCode = conn.getResponseCode();
            if(responseCode != HttpURLConnection.HTTP_OK){
                System.err.println("HTTP error code: " + responseCode + " for URL: " + urlString);
                return list;
            }
            
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder json = new StringBuilder();
            String line;
            while((line = reader.readLine()) != null){
                json.append(line);
            }
            reader.close();

            JSONObject provinceObj = new JSONObject(json.toString());
            JSONArray districtsArray = provinceObj.getJSONArray("districts");
            for(int i = 0; i < districtsArray.length(); i++){
                JSONObject obj = districtsArray.getJSONObject(i);
                int code = obj.getInt("code");
                String name = obj.getString("name");
                list.add(new District(code, name));
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }

    // Lấy danh sách xã của một huyện dựa trên mã huyện
    public static ObservableList<Ward> getWards(int districtCode) {
        ObservableList<Ward> list = FXCollections.observableArrayList();
        try {
            String urlString = API_URL + "d/" + districtCode + "?depth=2";
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            
            int responseCode = conn.getResponseCode();
            if(responseCode != HttpURLConnection.HTTP_OK){
                System.err.println("HTTP error code: " + responseCode + " for URL: " + urlString);
                return list;
            }
            
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder json = new StringBuilder();
            String line;
            while((line = reader.readLine()) != null){
                json.append(line);
            }
            reader.close();

            JSONObject districtObj = new JSONObject(json.toString());
            JSONArray wardsArray = districtObj.getJSONArray("wards");
            for(int i = 0; i < wardsArray.length(); i++){
                JSONObject obj = wardsArray.getJSONObject(i);
                int code = obj.getInt("code");
                String name = obj.getString("name");
                list.add(new Ward(code, name));
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
}
