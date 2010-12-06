package com.erik.hellotabs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.ListActivity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
public class RedActivity extends ListActivity {


	        private static final String LOG_TAG = "Red";
	        private static final String SITE_URL = "http://www.alltommat.se/ajax/winesearch";

	        public static HashMap<Integer, JSONObject> channelMap;
	        public static HashMap<Integer, Bitmap> iconsMap;

	        @Override
	        public void onCreate(Bundle savedInstanceState) {
	                super.onCreate(savedInstanceState);
	                setListAdapter(new ArrayAdapter<String>(this, R.layout.news_list_item, COUNTRIES));

	          	  ListView lv = getListView();
	          	  lv.setTextFilterEnabled(true);

	          	  lv.setOnItemClickListener(new OnItemClickListener() {
	          	    public void onItemClick(AdapterView<?> parent, View view,
	          	        int position, long id) {
	          	      // When clicked, show a toast with the TextView text
	          	      Toast.makeText(getApplicationContext(), ((TextView) view).getText(),
	          	          Toast.LENGTH_SHORT).show();
	          	    }
	          	  });
	          	}
	          	static final String[] COUNTRIES = new String[] {
	          	    "Afghanistan", "Albania", "Algeria", "American Samoa", "Andorra",
	          	    "Angola", "Anguilla", "Antarctica", "Antigua and Barbuda", "Argentina",
	          	    "Armenia", "Aruba", "Australia", "Austria", "Azerbaijan",
	          	    "Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium",
	          	    "Belize", "Benin", "Bermuda", "Bhutan", "Bolivia",
	          	    "Bosnia and Herzegovina", "Botswana", "Bouvet Island", "Brazil", "British Indian Ocean Territory",
	          	    "British Virgin Islands", "Brunei", "Bulgaria", "Burkina Faso", "Burundi",
	          	    "Cote d'Ivoire", "Cambodia", "Cameroon", "Canada", "Cape Verde",
	          	    "Cayman Islands", "Central African Republic", "Chad", "Chile", "China",
	          	    "Christmas Island", "Cocos (Keeling) Islands", "Colombia", "Comoros", "Congo",
	          	    "Cook Islands", "Costa Rica", "Croatia", "Cuba", "Cyprus", "Czech Republic",
	          	    "Democratic Republic of the Congo", "Denmark", "Djibouti", "Dominica", "Dominican Republic",
	          	    "East Timor", "Ecuador", "Egypt", "El Salvador", "Equatorial Guinea", "Eritrea",
	          	    "Estonia", "Ethiopia", "Faeroe Islands", "Falkland Islands", "Fiji", "Finland",
	          	    "Former Yugoslav Republic of Macedonia", "France", "French Guiana", "French Polynesia",
	          	    "French Southern Territories", "Gabon", "Georgia", "Germany", "Ghana", "Gibraltar",
	          	    "Greece", "Greenland", "Grenada", "Guadeloupe", "Guam", "Guatemala", "Guinea", "Guinea-Bissau",
	          	    "Guyana", "Haiti", "Heard Island and McDonald Islands", "Honduras", "Hong Kong", "Hungary",
	          	    "Iceland", "India", "Indonesia", "Iran", "Iraq", "Ireland", "Israel", "Italy", "Jamaica",
	          	    "Japan", "Jordan", "Kazakhstan", "Kenya", "Kiribati", "Kuwait", "Kyrgyzstan", "Laos",
	          	    "Latvia", "Lebanon", "Lesotho", "Liberia", "Libya", "Liechtenstein", "Lithuania", "Luxembourg",
	          	    "Macau", "Madagascar", "Malawi", "Malaysia", "Maldives", "Mali", "Malta", "Marshall Islands",
	          	    "Martinique", "Mauritania", "Mauritius", "Mayotte", "Mexico", "Micronesia", "Moldova",
	          	    "Monaco", "Mongolia", "Montserrat", "Morocco", "Mozambique", "Myanmar", "Namibia",
	          	    "Nauru", "Nepal", "Netherlands", "Netherlands Antilles", "New Caledonia", "New Zealand",
	          	    "Nicaragua", "Niger", "Nigeria", "Niue", "Norfolk Island", "North Korea", "Northern Marianas",
	          	    "Norway", "Oman", "Pakistan", "Palau", "Panama", "Papua New Guinea", "Paraguay", "Peru",
	          	    "Philippines", "Pitcairn Islands", "Poland", "Portugal", "Puerto Rico", "Qatar",
	          	    "Reunion", "Romania", "Russia", "Rwanda", "Sqo Tome and Principe", "Saint Helena",
	          	    "Saint Kitts and Nevis", "Saint Lucia", "Saint Pierre and Miquelon",
	          	    "Saint Vincent and the Grenadines", "Samoa", "San Marino", "Saudi Arabia", "Senegal",
	          	    "Seychelles", "Sierra Leone", "Singapore", "Slovakia", "Slovenia", "Solomon Islands",
	          	    "Somalia", "South Africa", "South Georgia and the South Sandwich Islands", "South Korea",
	          	    "Spain", "Sri Lanka", "Sudan", "Suriname", "Svalbard and Jan Mayen", "Swaziland", "Sweden",
	          	    "Switzerland", "Syria", "Taiwan", "Tajikistan", "Tanzania", "Thailand", "The Bahamas",
	          	    "The Gambia", "Togo", "Tokelau", "Tonga", "Trinidad and Tobago", "Tunisia", "Turkey",
	          	    "Turkmenistan", "Turks and Caicos Islands", "Tuvalu", "Virgin Islands", "Uganda",
	          	    "Ukraine", "United Arab Emirates", "United Kingdom",
	          	    "United States", "United States Minor Outlying Islands", "Uruguay", "Uzbekistan",
	          	    "Vanuatu", "Vatican City", "Venezuela", "Vietnam", "Wallis and Futuna", "Western Sahara",
	          	    "Yemen", "Yugoslavia", "Zambia", "Zimbabwe"  };
	          }
