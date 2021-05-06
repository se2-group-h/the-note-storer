using System.Collections.Generic;

namespace Selenium.TestData
{
    public class RegisterTestData
    {
        public static IEnumerable<object[]> TestData => Data;

        private static readonly List<object[]> Data = new List<object[]>()
        {
            new object[] {"1", "2", "3", "4", "5"}
        };
    }
}