using Android.App;
using Android.Content;
using Android.OS;
using Android.Runtime;
using Android.Views;
using Android.Widget;
using TheNoteStorer.Android;
using TheNoteStorer.Interfaces;


[assembly: Xamarin.Forms.Dependency(typeof(ToastNotification_Android))]
namespace TheNoteStorer.Android
{
    public class ToastNotification_Android : IToastNotification
    {
        public void Show(string message)
        {
            Toast.MakeText(Application.Context, message, ToastLength.Short).Show();
        }
    }
}
