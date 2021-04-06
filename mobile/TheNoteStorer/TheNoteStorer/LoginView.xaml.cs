using System;
using System.Collections.Generic;
using TheNoteStorer.Interfaces;
using TheNoteStorer.Services;
using Xamarin.Forms;

namespace TheNoteStorer
{
    public partial class LoginView : ContentView
    {
        public LoginView()
        {
            InitializeComponent();
        }

        async void LoginButton_Clicked(System.Object sender, System.EventArgs e)
        {
            var loginService = new LoginService();

            var loggedIn = await loginService.LoginAsync("", "");

            if (loggedIn)
            {
                DependencyService.Get<IToastNotification>().Show("Logged In");
            }
        }

    }
}
