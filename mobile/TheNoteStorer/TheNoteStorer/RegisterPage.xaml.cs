using System;
using System.Collections.Generic;
using Plugin.Toast;
using TheNoteStorer.Interfaces;
using TheNoteStorer.Models.Request;
using TheNoteStorer.Services;
using Xamarin.Forms;

namespace TheNoteStorer
{
    public partial class RegisterPage : ContentPage
    {
        public RegisterPage()
        {
            InitializeComponent();
            NavigationPage.SetHasNavigationBar(this, false);
        }

        private async void RegisterButton_OnClicked(object sender, EventArgs e)
        {
            var login = UsernameEntry.Text;
            var password = PasswordEntry.Text;
            var email = EmailEntry.Text;
            var firstName = FirstNameEntry.Text;
            var lastName = LastNameEntry.Text;

            var registerModel = new RegisterRequestModel(email, login, firstName, lastName, password);
            var registerService = new RegisterService();
            var registrationSuccessfull = await registerService.RegisterAsync(registerModel);

            if (registrationSuccessfull)
            {
                await Navigation.PopModalAsync();
                ShowMessage("Registered successfully");
            }
            else
            {
                ShowMessage("Registration failed");
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
    }
}
