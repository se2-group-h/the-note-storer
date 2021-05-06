using System;
using System.Threading;
using OpenQA.Selenium;
using Selenium.TestData;
using Xunit;
using Xunit.Abstractions;

namespace Selenium
{
    public class E2ETests : IClassFixture<StateFixture>
    {
        private const string AppName = "React App";
        
        private readonly ITestOutputHelper _output;
        private readonly StateFixture _fixture;
        private readonly IWebDriver _driver;

        public E2ETests(ITestOutputHelper output, StateFixture fixture)
        {
            _output = output;
            _fixture = fixture;
            _driver = fixture.State.UsualWebDriver;
        }
        
        [Fact]
        public void TestOpening()
        {
            _driver.Navigate().GoToUrl(Resources.BaseUrl);
            Assert.Equal(AppName, _driver.Title);
        }

        [Fact]
        public void TestRegisterButtonNavigation()
        {
            var registerButton = _driver.FindElement(By.Id(Resources.RegisterButtonId));
            registerButton.Click();
            Pause(1);
            Assert.Equal(Resources.RegisterUrl, _driver.Url);
        }

        [Theory]
        [MemberData(nameof(RegisterTestData.TestData), MemberType = typeof(RegisterTestData))]
        public void TestRegitrationFormErrors(
            string login, 
            string password, 
            string email, 
            string firstname, 
            string lastname)
        {
            // TODO
        }


        [Fact]
        public void CloseBrowserTest()
        {
            _driver.Close();
            _driver.Dispose();
        }

        private void Pause(int s = 3)
        {
            Thread.Sleep(s*1000);
        }
    }
}
