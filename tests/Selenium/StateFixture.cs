using System;

namespace Selenium
{
    public class StateFixture : IDisposable
    {
        public State State { get; set; }

        public StateFixture()
        {
            State = new State();
        }
        
        public void Dispose()
        {
            State.HeadlessWebDriver.Dispose();
            State.UsualWebDriver.Dispose();
        }
    }
}