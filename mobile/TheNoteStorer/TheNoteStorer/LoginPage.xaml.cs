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
        private const string FailedLogIn = "Failed to Log In";
        private bool _isLoginValid;
        private bool _isPasswordValid;

        public LoginPage()
        {
            InitializeComponent();
            LoginButton.IsEnabled = false;
            LoginButton.BackgroundColor = Color.LightGray;
            LoginButton.TextColor = Color.Gray;
            NavigationPage.SetHasNavigationBar(this, false);
        }

        async void LoginButton_Clicked(System.Object sender, System.EventArgs e)
        {
            var loginService = new LoginService();
            
            var username = LoginEntry.Text;
            var password = PasswordEntry.Text;
            var (loggedIn, token) = await loginService.LoginAsync(username, password);

            if (loggedIn)
            {
                ShowMessage(LoggedInText);
                Application.Current.Properties["token"] = token;

                await Navigation.PopModalAsync();
            }
            else
            {
                ShowMessage(FailedLogIn);
            }
        }

        void PasswordEntry_TextChanged(Object sender, TextChangedEventArgs e)
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

        void LoginEntry_TextChanged(Object sender, TextChangedEventArgs e)
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

        private void ShowMessage(string message)
        {
            if (Device.RuntimePlatform == Device.Android)
            {
                DependencyService.Get<IToastNotification>().Show(message);
            }

            if (Device.RuntimePlatform == Device.iOS)
            {
                CrossToastPopUp.Current.ShowToastMessage(message);
            }
        }

        private void RegisterButton_OnClicked(object sender, EventArgs e)
        {
            Navigation.PushModalAsync(new NavigationPage(new RegisterPage()));
        }
    }
}
