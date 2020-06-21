using System;
using System.Collections.Generic;
using System.Text;

namespace ChainOfResponsibility
{
    class ObserverEmployee : IObserver
    {
        public void Update(AbstractEmployee subject)
        {           
            if ((subject as AbstractEmployee)._state.GetType() == new PreparingPakage().GetType())
            {
                Console.WriteLine("  Observer employee took the package from" + subject.GetType().Name);
                subject.SetAwaitingState();
            }
        }
    }
}
