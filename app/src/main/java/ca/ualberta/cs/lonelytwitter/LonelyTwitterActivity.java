package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class LonelyTwitterActivity extends Activity {

	private static final String FILENAME = "file.sav";
	private EditText bodyText;
	private ListView oldTweetsList;

	private ArrayList<Tweet> tweets = new ArrayList<Tweet>();
	private ArrayAdapter<Tweet> adapter;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		bodyText = (EditText) findViewById(R.id.body);
		Button saveButton = (Button) findViewById(R.id.save);
		Button clearButton = (Button) findViewById(R.id.clear); // added for the clear button
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);

		saveButton.setOnClickListener(new View.OnClickListener() {

				public void onClick(View v) {
					/*Tweet tweet = new ImportantTweet("");
					NormalTweet tweet1 = new NormalTweet("");

					Mood mood = new HappyMood("");
					SadMood mood1 = new SadMood("");


					try {
						tweet.setMessage("Hello");
					} catch (TweetTooLongException e) {
						//e.printStackTrace();
					}
					ArrayList<Tweet> tweets = new ArrayList<Tweet>();
					tweets.add(tweet);
					tweets.add(tweet1);
					for (Tweet t : tweets){
						Log.d("Some Tag", "The isImportant method on this object returns " + t.isImportant());
					}

					ArrayList<Tweetable> tweetable = new ArrayList<Tweetable>();
					tweetable.add(tweet);
					tweetable.add(tweet1);*/



					setResult(RESULT_OK);
					String text = bodyText.getText().toString();

					tweets.add(new NormalTweet(text));
					adapter.notifyDataSetChanged();

					//saveInFile(text, new Date(System.currentTimeMillis()));
					//finish();
				}
		});
	}

	/*clearButton.setOnClickListener(new View.OnClickListener() {
		public void onClick(View v) {
			setResult(RESULT_OK);

			tweets)
		}
	}*/

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		//String[] tweets = loadFromFile();
		adapter = new ArrayAdapter<Tweet>(this, R.layout.list_item, tweets);
		oldTweetsList.setAdapter(adapter);
	}

	private void loadFromFile() {
		//ArrayList<String> tweets = new ArrayList<String>();
		try {
			FileInputStream fis = openFileInput(FILENAME);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));

			Gson gson = new Gson();
			Type listType = new TypeToken<ArrayList<Tweet>>() {}.getType();
			tweets = gson.fromJson(in,listType);

			/*
			String line = in.readLine();
			while (line != null) {
				tweets.add(line);
				line = in.readLine();*/


		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			tweets = new ArrayList<Tweet>();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			throw new RuntimeException();

		}
		return;
	}
	
	private void saveInFile(String text, Date date) {
		try {
			FileOutputStream fos = openFileOutput(FILENAME,
					Context.MODE_PRIVATE);
			/*fos.write(new String(date.toString() + " | " + text)
					.getBytes());*/

			OutputStreamWriter writer = new OutputStreamWriter(fos);
			Gson gson = new Gson();
			gson.toJson(tweets,writer);
			writer.flush();
			fos.close();


		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			throw new RuntimeException();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			throw new RuntimeException();
		}
	}
}