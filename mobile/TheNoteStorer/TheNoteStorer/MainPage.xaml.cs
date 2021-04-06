using TheNoteStorer.Interfaces;
using TheNoteStorer.Services;
using Xamarin.Forms;

namespace TheNoteStorer
{
    public partial class MainPage : ContentPage
    {
        public MainPage()
        {
            InitializeComponent();
            Content = new LoginView();
        }
    }
}