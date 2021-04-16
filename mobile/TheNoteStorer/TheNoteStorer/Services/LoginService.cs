using System;
using System.Threading.Tasks;
using System.Net.Http;
using Newtonsoft.Json;
using TheNoteStorer.Models;
using System.Text;
using TheNoteStorer.Models.Request;
using TheNoteStorer.Models.Response;

namespace TheNoteStorer.Services
{
    public class LoginService
    {
        private static readonly HttpClient _client = new HttpClient();

        public async Task<(bool, string)> LoginAsync(string username, string password)
        {
            var loginModel = new LoginRequestModel(username, password);

            var response = await SendLoginRequest(loginModel);

            if (!response.IsSuccessStatusCode)
            {
                return (false, null);
            }

            var responseContent = await response.Content.ReadAsStringAsync();
            var loginResponse = JsonConvert.DeserializeObject<LoginResponseModel>(responseContent);
            var token = loginResponse?.Token;

            return (true, token);
        }

        private async Task<HttpResponseMessage> SendLoginRequest(LoginRequestModel loginModel)
        {
            var json = JsonConvert.SerializeObject(loginModel);
            var data = new StringContent(json, Encoding.UTF8, "application/json");
            var url = "http://trn-staging-back.us-east-2.elasticbeanstalk.com/api/login";

            var request = new HttpRequestMessage();
            request.RequestUri = new Uri(url);
            request.Content = data;
            request.Method = HttpMethod.Post;

            var response = await _client.SendAsync(request);

            return response;
        }
    }
}
