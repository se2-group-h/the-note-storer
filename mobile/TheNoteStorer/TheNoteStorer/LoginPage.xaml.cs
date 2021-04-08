using System;
using System.Collections.Generic;
using Plugin.Toast;
using TheNoteStorer.Interfaces;
using TheNoteStorer.Services;
using Xamarin.Forms;

namespace TheNoteStorer
{
    public partial class LoginPage : ContentPage
    {
        private const string LoggedInText = "Logged In";
        private bool _isLoginValid;
        private bool _isPasswordValid;

        public LoginPage()
        {
            InitializeComponent();
            LoginButton.IsEnabled = false;
            LoginButton.BackgroundColor = Color.LightGray;
            LoginButton.TextColor = Color.Gray;
        }

        async void LoginButton_Clicked(System.Object sender, System.EventArgs e)
        {
            var loginService = new LoginService();

            var loggedIn = await loginService.LoginAsync("", "");

            if (loggedIn)
            {
                if (Device.RuntimePlatform == Device.Android)
                {
                    DependencyService.Get<IToastNotification>().Show(LoggedInText);
                }

                if (Device.RuntimePlatform == Device.iOS)
                {
                    CrossToastPopUp.Current.ShowToastMessage(LoggedInText);
                }

                await Navigation.PopModalAsync();
            }
        }

        void PasswordEntry_TextChanged(System.Object sender, Xamarin.Forms.TextChangedEventArgs e)
        {
            if(e.NewTextValue.Length > 5)
            {
                _isPasswordValid = true;
                if(_isLoginValid)
                {
                    LoginButton.IsEnabled = true;
                    LoginButton.BackgroundColor = Color.LawnGreen;
                    LoginButton.TextColor = Color.Black;
                }
            }
        }

        void LoginEntry_TextChanged(System.Object sender, Xamarin.Forms.TextChangedEventArgs e)
        {
            if (!string.IsNullOrEmpty(e.NewTextValue))
            {
                _isLoginValid = true;
                if(_isPasswordValid)
                {
                    LoginButton.IsEnabled = true;
                    LoginButton.BackgroundColor = Color.LawnGreen;
                    LoginButton.TextColor = Color.Black;
                }
            }
        }
    }
}
