using System;
using System.Net.Http;
using System.Text;
using System.Threading.Tasks;
using Newtonsoft.Json;
using TheNoteStorer.Models.Request;
using TheNoteStorer.Models.Response;

namespace TheNoteStorer.Services
{
    public class RegisterService
    {
        private static readonly HttpClient _client = new HttpClient();
        
        public async Task<bool> RegisterAsync(RegisterRequestModel requestModel)
        {
            var response = await SendRegisterRequest(requestModel);

            return response.IsSuccessStatusCode;
        }

        private async Task<HttpResponseMessage> SendRegisterRequest(RegisterRequestModel requestModel)
        {
            var json = JsonConvert.SerializeObject(requestModel);
            var data = new StringContent(json, Encoding.UTF8, "application/json");
            var url = "http://trn-staging-back.us-east-2.elasticbeanstalk.com/api/signup";

            var request = new HttpRequestMessage();
            request.RequestUri = new Uri(url);
            request.Content = data;
            request.Method = HttpMethod.Post;

            var response = await _client.SendAsync(request);

            return response;
        }
    }
}