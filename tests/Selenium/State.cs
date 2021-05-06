using System.Collections.Generic;
using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;

namespace Selenium
{
    public class State
    {
        public readonly string Login = "kiryl";
        public readonly string Password = "qwerty123";
        public readonly string Email = "test@gmail.com";
        public readonly string FirstName = "kiryl";
        public readonly string LastName = "volkau";
        public readonly IWebDriver HeadlessWebDriver = new ChromeDriver(GetService(), GetChromeOptions());
        public readonly IWebDriver UsualWebDriver = new ChromeDriver();

        private static ChromeOptions GetChromeOptions()
        {
            var optionsList = new List<string>()
            {
                "--silent-launch",
                "--no-startup-window",
                "no-sandbox", 
                "headless"
            };
            
            var options = new ChromeOptions();
            options.AddArguments(optionsList);

            return options;
        }

        private static ChromeDriverService GetService()
        {
            var chromeDriverService = ChromeDriverService.CreateDefaultService();
            chromeDriverService.HideCommandPromptWindow = true;

            return chromeDriverService;
        }
    }
}