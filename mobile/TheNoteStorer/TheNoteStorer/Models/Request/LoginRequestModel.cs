using System;
using Newtonsoft.Json;

namespace TheNoteStorer.Models.Request
{
    public class LoginRequestModel
    {
        [JsonProperty("username")]
        public string Username { get; set; }
        
        [JsonProperty("password")]
        public string Password { get; set; }

        public LoginRequestModel(string username, string password)
        {
            Username = username;
            Password = password;
        }
    }
}
