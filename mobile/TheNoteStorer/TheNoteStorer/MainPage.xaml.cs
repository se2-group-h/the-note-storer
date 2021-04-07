using TheNoteStorer.Interfaces;
using TheNoteStorer.Services;
using Xamarin.Forms;

namespace TheNoteStorer
{
    public partial class MainPage : ContentPage
    {
        public bool IsClickable { get; set; }

        public MainPage()
        {
            InitializeComponent();
            Navigation.PushModalAsync(new LoginPage());
        }

        async void LogoutButton_Clicked(System.Object sender, System.EventArgs e)
        {
            await Navigation.PushModalAsync(new LoginPage());
        }
    }
}