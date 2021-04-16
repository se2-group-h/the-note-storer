using Newtonsoft.Json;

namespace TheNoteStorer.Models.Request
{
    public class RegisterRequestModel
    {
        [JsonProperty("email")]
        public string Email { get; set; }
        
        [JsonProperty("login")]
        public string Login { get; set; }
        
        [JsonProperty("firstName")]
        public string FirstName { get; set; }
        
        [JsonProperty("lastName")]
        public string LastName { get; set; }
        
        [JsonProperty("password")]
        public string Password { get; set; }

        public RegisterRequestModel(
            string email,
            string login,
            string firstName,
            string lastName,
            string password
            )
        {
            Email = email;
            Login = login;
            FirstName = firstName;
            LastName = lastName;
            Password = password;
        }
    }
}