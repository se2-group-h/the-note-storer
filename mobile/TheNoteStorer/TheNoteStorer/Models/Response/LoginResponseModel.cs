namespace TheNoteStorer.Models.Response
{
    public class LoginResponseModel
    {
        public int UserId { get; set; }
        public string FirstName { get; set; }
        public string Token { get; set; }
    }
}