package saulmm.retrofit2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

	private RestApi mRestApi;

	@Override protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// Should be done by a DI
		mRestApi = new RestApi();
	}

	public void onMakeCallPressed(View view) {
		mRestApi.listRepositories("saulmm");
	}
}
