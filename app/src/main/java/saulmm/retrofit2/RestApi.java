package saulmm.retrofit2;

import java.util.List;
import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;
import retrofit.http.GET;
import retrofit.http.Path;

public class RestApi {

	private static final String GITHUB_ENDPOINT = "https://api.github.com";
	private final GitHubService mService;

	public interface GitHubService {
		@GET("/users/{user}/repos") Call<List<Repo>> listRepos(@Path("user") String user);
	}

	public RestApi() {
		Retrofit retrofit = new Retrofit.Builder().baseUrl(GITHUB_ENDPOINT)
			.addConverterFactory(GsonConverterFactory.create())
			.build();

		mService = retrofit.create(GitHubService.class);
	}

	public void listRepositories(String saulmm) {
		mService.listRepos(saulmm).enqueue(new Callback<List<Repo>>() {
			@Override public void onResponse(Response<List<Repo>> response, Retrofit retrofit) {
				System.out.println("[DEBUG]" + " RestApi onResponse Number of repositories- " +response.body().size());
			}

			@Override public void onFailure(Throwable t) {
				System.out.println("[DEBUG]" + " RestApi onFailure - " +
					"");
			}
		});
	}
}

