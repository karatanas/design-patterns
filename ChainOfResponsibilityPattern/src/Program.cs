using System;
using System.Collections.Generic;

namespace ChainOfResponsibility
{

    class Program
    {
        static void Main(string[] args)
        {

            var crossborderEmployee = new CrossborderEmployee(new AwaitingPackage());
            var countryEmployee = new CountryEmployee(new AwaitingPackage());
            var plovdivEmployee = new PlovdivEmployee(new AwaitingPackage());

            var observer = new ObserverEmployee();
            crossborderEmployee.Attach(observer);
            countryEmployee.Attach(observer);
            plovdivEmployee.Attach(observer);

            crossborderEmployee.SetNext(countryEmployee).SetNext(plovdivEmployee);

            List<string> packages = new List<string> { "Plovdiv", "Varna", "Ukraine", "Bulgaria", "Plovdiv" };

            foreach (var package in packages)
            {
                Console.WriteLine($"\n==========================================\n\nClient with package for {package} entered office:");

                if (!crossborderEmployee.HandlePackage(package))
                {
                    Console.WriteLine($"  {package} was refused");
                }
            }
        }
    }
}
